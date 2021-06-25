/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.nprog.client.helper;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import rs.ac.bg.fon.nprog.domen.Lokacija;
import rs.ac.bg.fon.nprog.domen.PrijavaPronalaskaPsa;
import rs.ac.bg.fon.nprog.domen.ZahtevZaTrazenjePsa;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JToolTip;
import org.jxmapviewer.JXMapKit;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import rs.ac.bg.fon.nprog.client.gui.FrmPrijavaPronalaska;
import rs.ac.bg.fon.nprog.client.gui.FrmZahtevZaTrazenje;
import java.util.logging.Level;
import java.util.logging.Logger;
import rs.ac.bg.fon.nprog.client.kontoler.Kontroler;


/**
 *
 * @author tamara
 */
public class MapHelper {
    //private static MapHelper instanca;
    private  String lokacijaReturn;
    private boolean signal=true;
    private JDialog jDialog;
    private JXMapViewer mapViewer;
    private PrijavaPronalaskaPsa prijavaPronalaskaPsa;
    private FrmPrijavaPronalaska formaPrijave;
    
    private ZahtevZaTrazenjePsa zahtevZaTrazenjePsa;
    private FrmZahtevZaTrazenje formaZahteva;
    
    
    public MapHelper() {
        //lokacijaReturn = new Lokacija(1,"Beograd",44.793531,20.442141);
        prijavaPronalaskaPsa=new PrijavaPronalaskaPsa();
        zahtevZaTrazenjePsa=new ZahtevZaTrazenjePsa();
    }

    public MapHelper(String lokacijaReturn, PrijavaPronalaskaPsa prijavaPronalaskaPsa, ZahtevZaTrazenjePsa zahtevZaTrazenjePsa) {
        this.lokacijaReturn = lokacijaReturn;
        this.prijavaPronalaskaPsa=prijavaPronalaskaPsa;
        this.zahtevZaTrazenjePsa=zahtevZaTrazenjePsa;
    }
    
    /**
     * 
     * @param x X koordinata
     * @param y Y koordinata
     * @return Vraca naziv grada, drzave sa izabranog dela mape na osnovu koordinata
     */
    
    public String vratiGrad(double x, double y){
        
        try {
           String path="https://nominatim.openstreetmap.org/reverse?format=jsonv2&lat="+x+"&lon="+y;
           URL url = new URL(path);
            // making connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;
            String out="";
            System.out.println("Output from Server: \n");
            while ((output = br.readLine()) != null) {
                out+=output;
            }
            Gson gson=new Gson();
            JsonObject rez=gson.fromJson(out, JsonObject.class);
       
            //System.out.println(rez);
            
            String lokacija;
            if(rez.get("address").getAsJsonObject().has("suburb")){
                lokacija = rez.get("address").getAsJsonObject().get("suburb").getAsString();
            }else if(rez.get("address").getAsJsonObject().has("city")){
                 lokacija = rez.get("address").getAsJsonObject().get("city").getAsString();
            }else if(rez.get("address").getAsJsonObject().has("municipality")){
                lokacija = rez.get("address").getAsJsonObject().get("municipality").getAsString();
            }else if(rez.get("address").getAsJsonObject().has("country")){
                lokacija = rez.get("address").getAsJsonObject().get("country").getAsString();
            }else{
                lokacija = "";
            }
            //System.out.println(lokacija);
            conn.disconnect();
            return lokacija;
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block

        } catch (IOException e) {
            // TODO Auto-generated catch block

        }
        return "";
    }
    /**
     * 
     * @param l Lokacija koja se prosledjuje i prikazuje na mapi
     * @return Vraca Lokaciju koja je izabrana sa mape duplim klikom 
     */
    public void mapaPrijava(double x, double y) {
 
        final JXMapKit jXMapKit = new JXMapKit();
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapKit.setTileFactory(tileFactory);

        //location of Java
        final GeoPosition gp;
        gp = new GeoPosition(x, y); 
       

        final JToolTip tooltip = new JToolTip();
        tooltip.setTipText("Java");
        tooltip.setComponent(jXMapKit.getMainMap());
        jXMapKit.getMainMap().add(tooltip);

        jXMapKit.setZoom(7);
        jXMapKit.setAddressLocation(gp);

        jXMapKit.getMainMap().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) { 
                // ignore
            }

            @Override
            public void mouseMoved(MouseEvent e)
            {
                JXMapViewer map = jXMapKit.getMainMap();

                // convert to world bitmap
                Point2D worldPos = map.getTileFactory().geoToPixel(gp, map.getZoom());

                // convert to screen
                Rectangle rect = map.getViewportBounds();
                int sx = (int) worldPos.getX() - rect.x;
                int sy = (int) worldPos.getY() - rect.y;
                Point screenPos = new Point(sx, sy);


                // check if near the mouse
                if (screenPos.distance(e.getPoint()) < 20)
                {
                    screenPos.x -= tooltip.getWidth() / 2;

                    tooltip.setLocation(screenPos);
                    tooltip.setVisible(true);
                }
                else
                {
                    tooltip.setVisible(false);
                }
            }
        });
        
         mapViewer = jXMapKit.getMainMap();
        mapViewer.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent me) {
                Point2D gp_pt = null;

               
                    //convert to world bitmap
                    gp_pt = mapViewer.getTileFactory().geoToPixel(gp, mapViewer.getZoom());
                    //convert to screen
                    Rectangle rect = mapViewer.getViewportBounds();
                    Point converted_gp_pt = new Point((int) gp_pt.getX() - rect.x,
                            (int) gp_pt.getY() - rect.y);
                    //check if near the mouse

          
                    jXMapKit.setAddressLocation(mapViewer.convertPointToGeoPosition(me.getPoint()));
                    GeoPosition pozicija = mapViewer.convertPointToGeoPosition(me.getPoint());
                    if (me.getClickCount() == 1) { 
                        String lokacija=vratiGrad(pozicija.getLatitude(), pozicija.getLongitude());
                        System.out.println("X kordinata: "+pozicija.getLatitude());
                        System.out.println("Y kordinata: "+pozicija.getLongitude());
                        System.out.println(lokacija); 
                    }else{
                        String lokacijaNaziv=vratiGrad(pozicija.getLatitude(), pozicija.getLongitude());
                        //return new Lokacija(1, lokacija, pozicija.getLatitude(), pozicija.getLongitude());
//                        long id=-1;
//                        setLokacijaReturn(new Lokacija(id, lokacijaNaziv, pozicija.getLatitude(), pozicija.getLongitude()));
//                        getPrijavaPronalaskaPsa().setLokacija(lokacijaReturn);
                        prijavaPronalaskaPsa.setOpis(lokacijaNaziv);
                        prijavaPronalaskaPsa.setX(pozicija.getLatitude());
                        prijavaPronalaskaPsa.setY(pozicija.getLongitude());
                        formaPrijave.promeniPolje(lokacijaNaziv, pozicija.getLatitude(),pozicija.getLongitude() );
                        
//                    try {
//                        //insert lokacije u bazu
//                        if(lokacijaReturn!=null && formaPrijave!=null){
//                            Lokacija sacuvana=Kontroler.vratiInstancu().zapamtiLokaciju(lokacijaReturn);
//                            formaPrijave.popuniComboLokacija();
//                            
//                            formaPrijave.promeniPolje(sacuvana);
//                            jDialog.dispose();
//                        }                      
//                        
//                        
//                    } catch (Exception ex) {
//                        Logger.getLogger(MapHelper.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                        
                        
                        //insert lokacije u bazu
                        
                        
                        signal = false;
                    }
               }
                
            
        });
        // Display the viewer in a JFrame
        
        setjDialog(new JDialog());
        getjDialog().setTitle("Lokacija psa");
        getjDialog().getContentPane().add(jXMapKit);
        getjDialog().setSize(800, 600);
        getjDialog().setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        getjDialog().setVisible(true);
    

        //return lokacijaReturn;
    }
    
    public void mapaZahtev(double x, double y){
        
        
        
        final JXMapKit jXMapKit = new JXMapKit();
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapKit.setTileFactory(tileFactory);

        //location of Java
        final GeoPosition gp;
        gp = new GeoPosition(x, y); 
       

        final JToolTip tooltip = new JToolTip();
        tooltip.setTipText("Java");
        tooltip.setComponent(jXMapKit.getMainMap());
        jXMapKit.getMainMap().add(tooltip);

        jXMapKit.setZoom(7);
        jXMapKit.setAddressLocation(gp);

        jXMapKit.getMainMap().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) { 
                // ignore
            }

            @Override
            public void mouseMoved(MouseEvent e)
            {
                JXMapViewer map = jXMapKit.getMainMap();

                // convert to world bitmap
                Point2D worldPos = map.getTileFactory().geoToPixel(gp, map.getZoom());

                // convert to screen
                Rectangle rect = map.getViewportBounds();
                int sx = (int) worldPos.getX() - rect.x;
                int sy = (int) worldPos.getY() - rect.y;
                Point screenPos = new Point(sx, sy);


                // check if near the mouse
                if (screenPos.distance(e.getPoint()) < 20)
                {
                    screenPos.x -= tooltip.getWidth() / 2;

                    tooltip.setLocation(screenPos);
                    tooltip.setVisible(true);
                }
                else
                {
                    tooltip.setVisible(false);
                }
            }
        });
        
        mapViewer = jXMapKit.getMainMap();
        mapViewer.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent me) {
                Point2D gp_pt = null;

               
                    //convert to world bitmap
                    gp_pt = mapViewer.getTileFactory().geoToPixel(gp, mapViewer.getZoom());
                    //convert to screen
                    Rectangle rect = mapViewer.getViewportBounds();
                    Point converted_gp_pt = new Point((int) gp_pt.getX() - rect.x,
                            (int) gp_pt.getY() - rect.y);
                    //check if near the mouse

          
                    jXMapKit.setAddressLocation(mapViewer.convertPointToGeoPosition(me.getPoint()));
                    GeoPosition pozicija = mapViewer.convertPointToGeoPosition(me.getPoint());
                    if (me.getClickCount() == 1) { 
                        String lokacija=vratiGrad(pozicija.getLatitude(), pozicija.getLongitude());
                        System.out.println("X kordinata: "+pozicija.getLatitude());
                        System.out.println("Y kordinata: "+pozicija.getLongitude());
                        System.out.println(lokacija); 
                    }else{
                        String lokacijaNaziv=vratiGrad(pozicija.getLatitude(), pozicija.getLongitude());
   
                        zahtevZaTrazenjePsa.setOpis(lokacijaNaziv);
                        zahtevZaTrazenjePsa.setX(pozicija.getLatitude());
                        zahtevZaTrazenjePsa.setY(pozicija.getLongitude());
                        formaZahteva.promeniPolje(lokacijaNaziv, pozicija.getLatitude(), pozicija.getLongitude());
                            
                        
                        
                        signal = false;
                    }
               }
                
            
        });
        // Display the viewer in a JFrame
        
        setjDialog(new JDialog());
        getjDialog().setTitle("Lokacija psa");
        getjDialog().getContentPane().add(jXMapKit);
        getjDialog().setSize(800, 600);
        getjDialog().setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        getjDialog().setVisible(true);
    

        //return lokacijaReturn;
    
    }

    
     public void prikaziNaMapi(double x, double y){
       
        final JXMapKit jXMapKit = new JXMapKit();
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapKit.setTileFactory(tileFactory);

        //location of Java
        final GeoPosition gp;
        gp = new GeoPosition(x, y); 
       

        final JToolTip tooltip = new JToolTip();
        tooltip.setTipText("Lokacija psa");
        tooltip.setComponent(jXMapKit.getMainMap());
        jXMapKit.getMainMap().add(tooltip);

        jXMapKit.setZoom(7);
        jXMapKit.setAddressLocation(gp);

        jXMapKit.getMainMap().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) { 
                // ignore
            }

            @Override
            public void mouseMoved(MouseEvent e)
            {
                JXMapViewer map = jXMapKit.getMainMap();

                // convert to world bitmap
                Point2D worldPos = map.getTileFactory().geoToPixel(gp, map.getZoom());

                // convert to screen
                Rectangle rect = map.getViewportBounds();
                int sx = (int) worldPos.getX() - rect.x;
                int sy = (int) worldPos.getY() - rect.y;
                Point screenPos = new Point(sx, sy);


                // check if near the mouse
                if (screenPos.distance(e.getPoint()) < 20)
                {
                    screenPos.x -= tooltip.getWidth() / 2;

                    tooltip.setLocation(screenPos);
                    tooltip.setVisible(true);
                }
                else
                {
                    tooltip.setVisible(false);
                }
            }
        });
        
        JXMapViewer mapViewer = jXMapKit.getMainMap();
       
        // Display the viewer in a JFrame
        setjDialog(new JDialog());
        getjDialog().setTitle("Lokacija psa");
        getjDialog().getContentPane().add(jXMapKit);
        getjDialog().setSize(800, 600);
        getjDialog().setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        getjDialog().setVisible(true);
              

    
    }
    
    
    
    /**
     * @return the lokacijaReturn
     */
    public String getLokacijaReturn() {
        return lokacijaReturn;
    }

    /**
     * @param lokacijaReturn the lokacijaReturn to set
     */
    public void setLokacijaReturn(String lokacijaReturn) {
        this.lokacijaReturn = lokacijaReturn;
    }

    /**
     * @return the signal
     */
    public boolean isSignal() {
        return signal;
    }

    /**
     * @return the jDialog
     */
    public JDialog getjDialog() {
        return jDialog;
    }

    /**
     * @param jDialog the jDialog to set
     */
    public void setjDialog(JDialog jDialog) {
        this.jDialog = jDialog;
    }

    /**
     * @return the prijavaPronalaskaPsa
     */
    public PrijavaPronalaskaPsa getPrijavaPronalaskaPsa() {
        return prijavaPronalaskaPsa;
    }

    /**
     * @param prijavaPronalaskaPsa the prijavaPronalaskaPsa to set
     */
    public void setPrijavaPronalaskaPsa(PrijavaPronalaskaPsa prijavaPronalaskaPsa) {
        this.prijavaPronalaskaPsa = prijavaPronalaskaPsa;
    }

    /**
     * @return the formaPrijave
     */
    public FrmPrijavaPronalaska getFormaPrijave() {
        return formaPrijave;
    }

    /**
     * @param formaPrijave the formaPrijave to set
     */
    public void setFormaPrijave(FrmPrijavaPronalaska formaPrijave) {
        this.formaPrijave = formaPrijave;
    }

    /**
     * @return the formaZahteva
     */
    public FrmZahtevZaTrazenje getFormaZahteva() {
        return formaZahteva;
    }

    /**
     * @param formaZahteva the formaZahteva to set
     */
    public void setFormaZahteva(FrmZahtevZaTrazenje formaZahteva) {
        this.formaZahteva = formaZahteva;
    }

    /**
     * @return the zahtevZaTrazenjePsa
     */
    public ZahtevZaTrazenjePsa getZahtevZaTrazenjePsa() {
        return zahtevZaTrazenjePsa;
    }

    /**
     * @param zahtevZaTrazenjePsa the zahtevZaTrazenjePsa to set
     */
    public void setZahtevZaTrazenjePsa(ZahtevZaTrazenjePsa zahtevZaTrazenjePsa) {
        this.zahtevZaTrazenjePsa = zahtevZaTrazenjePsa;
    }

 
}

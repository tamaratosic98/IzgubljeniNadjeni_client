/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.nprog.client.kontoler;


import rs.ac.bg.fon.nprog.domen.Korisnik;
import rs.ac.bg.fon.nprog.domen.Lokacija;
import rs.ac.bg.fon.nprog.domen.PrijavaPronalaskaPsa;
import rs.ac.bg.fon.nprog.domen.Pronalazak;
import rs.ac.bg.fon.nprog.domen.Rasa;
import rs.ac.bg.fon.nprog.domen.ZahtevZaTrazenjePsa;
import java.awt.Image;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.nprog.client.komunikacija.KomunikacijaSaServerom;
import rs.ac.bg.fon.nprog.konstante.Operacije;
import rs.ac.bg.fon.nprog.transfer.KlijentskiZahtev;
import rs.ac.bg.fon.nprog.transfer.ServerskiOdgovor;

/**
 *
 * @author tamara
 */
public class Kontroler {
    private static Kontroler instanca;
    private SimpleDateFormat sdfDatum;
    private final SimpleDateFormat sdfDatumVreme;
    
    private Kontroler(){
        sdfDatum=new SimpleDateFormat("dd-MM-yyyy");
        sdfDatumVreme=new SimpleDateFormat("dd-MM-yyyy hh:mm");
        
    }
    public static Kontroler vratiInstancu(){
        if(instanca==null){
            instanca=new Kontroler();
        }
        return instanca;
    }
    public String formatDatum(Date datum){
        return sdfDatum.format(datum);
    } 
    public Date parseDatum(String datum) throws ParseException{
        return sdfDatum.parse(datum);
    }
     public String formatDatumVreme(Date datum){
        return sdfDatumVreme.format(datum);
    } 
    public Date parseDatumVreme(String datum) throws ParseException{
        return sdfDatumVreme.parse(datum);
    }

    public List<Rasa> ucitajListuRasa() throws Exception {
        KlijentskiZahtev kz=new KlijentskiZahtev();
        kz.setOperacija(Operacije.UCITAJ_LISTU_RASA);
        kz.setParametar(new Rasa());
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno()){
            return (List<Rasa>)(Object)so.getOdgovor();
        }
        throw new Exception(so.getPoruka());
    }

    public List<Lokacija> ucitajListuLokacija() throws Exception {
        KlijentskiZahtev kz=new KlijentskiZahtev();
        kz.setOperacija(Operacije.UCITAJ_LISTU_LOKACIJA);
        kz.setParametar(new Lokacija());
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno()){
            return (List<Lokacija>)(Object)so.getOdgovor();
        }
        throw new Exception(so.getPoruka());
    }

    public List<PrijavaPronalaskaPsa> ucitajListuPrijavaPronalaskaPsa() throws Exception {
        KlijentskiZahtev kz=new KlijentskiZahtev();
        kz.setOperacija(Operacije.UCITAJ_LISTU_PRIJAVA_PRONALASKA_PSA);
        kz.setParametar(new PrijavaPronalaskaPsa());
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno()){
            return (List<PrijavaPronalaskaPsa>)(Object)so.getOdgovor();
        }
        throw new Exception(so.getPoruka());
    }

    public List<ZahtevZaTrazenjePsa> ucitajListuZahtevaZaTrazenjePsa() throws Exception {
        KlijentskiZahtev kz=new KlijentskiZahtev();
        kz.setOperacija(Operacije.UCITAJ_LISTU_ZAHTEVA_ZA_TRAZENJE_PSA);
        kz.setParametar(new ZahtevZaTrazenjePsa());
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno()){
            return (List<ZahtevZaTrazenjePsa>)(Object)so.getOdgovor();
        }
        throw new Exception(so.getPoruka());
    }

    public List<ZahtevZaTrazenjePsa> nadjiZahteveZaTrazenjePsa(ZahtevZaTrazenjePsa zahtevZaTrazenjePsa) throws Exception {
        KlijentskiZahtev kz=new KlijentskiZahtev();
        kz.setOperacija(Operacije.NADJI_ZAHTEVE_ZA_TRAZENJE_PSA);
        kz.setParametar(zahtevZaTrazenjePsa);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno()){
            JOptionPane.showMessageDialog(null, so.getPoruka(), "Info", JOptionPane.INFORMATION_MESSAGE);
            return (List<ZahtevZaTrazenjePsa>)(Object)so.getOdgovor();
        }
        throw new Exception(so.getPoruka());
    }
    public List<PrijavaPronalaskaPsa> nadjiPrijavePronalaskaPsa(PrijavaPronalaskaPsa prijavaPronalaskaPsa) throws Exception {
        KlijentskiZahtev kz=new KlijentskiZahtev();
        kz.setOperacija(Operacije.NADJI_PRIJAVE_PRONALASKA_PSA);
        kz.setParametar(prijavaPronalaskaPsa);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno()){
            JOptionPane.showMessageDialog(null, so.getPoruka(), "Info", JOptionPane.INFORMATION_MESSAGE);
            return (List<PrijavaPronalaskaPsa>)(Object)so.getOdgovor();
        }
        throw new Exception(so.getPoruka());
    }

    public List<Pronalazak> nadjiPronalaske(Pronalazak pronalazak) throws Exception {
        KlijentskiZahtev kz=new KlijentskiZahtev();
        kz.setOperacija(Operacije.NADJI_PRONALASKE);
        kz.setParametar(pronalazak);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno()){
            JOptionPane.showMessageDialog(null, so.getPoruka(), "Info", JOptionPane.INFORMATION_MESSAGE);
            return (List<Pronalazak>)(Object)so.getOdgovor();
        }
        throw new Exception(so.getPoruka());
    }

    public List<Pronalazak> zapamtiPronalazak(List<Pronalazak> pronalasci) throws Exception {
        KlijentskiZahtev kz=new KlijentskiZahtev();
        kz.setOperacija(Operacije.ZAPAMTI_PRONALAZAK);
        kz.setParametar(pronalasci);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno()){
            JOptionPane.showMessageDialog(null, so.getPoruka(), "Info", JOptionPane.INFORMATION_MESSAGE);
            return (List<Pronalazak>)(Object)so.getOdgovor();
        }
        throw new Exception(so.getPoruka());
    }

    public PrijavaPronalaskaPsa obrisiPrijavuPronalaskaPsa(PrijavaPronalaskaPsa prijavaPronalaskaPsa) throws Exception {
        KlijentskiZahtev kz=new KlijentskiZahtev();
        kz.setOperacija(Operacije.OBRISI_PRIJAVU_PRONALASKA_PSA);
        kz.setParametar(prijavaPronalaskaPsa);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno()){
            JOptionPane.showMessageDialog(null, so.getPoruka(), "Info", JOptionPane.INFORMATION_MESSAGE);
            return (PrijavaPronalaskaPsa)so.getOdgovor();
        }
        throw new Exception(so.getPoruka());
    }

    public ZahtevZaTrazenjePsa obrisiZahtevZaTrazenjePsa(ZahtevZaTrazenjePsa zahtevZaTrazenjePsa) throws Exception {
        KlijentskiZahtev kz=new KlijentskiZahtev();
        kz.setOperacija(Operacije.OBRISI_ZAHTEV_ZA_TRAZENJE_PSA);
        kz.setParametar(zahtevZaTrazenjePsa);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno()){
            JOptionPane.showMessageDialog(null, so.getPoruka(), "Info", JOptionPane.INFORMATION_MESSAGE);
            return (ZahtevZaTrazenjePsa)so.getOdgovor();
        }
        throw new Exception(so.getPoruka());
    }

    public PrijavaPronalaskaPsa zapamtiPrijavuPronalaskaPsa(PrijavaPronalaskaPsa prijavaPronalaskaPsa) throws Exception {
        KlijentskiZahtev kz=new KlijentskiZahtev();
        kz.setOperacija(Operacije.ZAPAMTI_PRIJAVU_PRONALASKA_PSA);
        kz.setParametar(prijavaPronalaskaPsa);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno()){
            JOptionPane.showMessageDialog(null, so.getPoruka(), "Info", JOptionPane.INFORMATION_MESSAGE);
            return (PrijavaPronalaskaPsa)so.getOdgovor();
        }
        throw new Exception(so.getPoruka());
    }

    public ZahtevZaTrazenjePsa zapamtiZahtevZaTrazenjePsa(ZahtevZaTrazenjePsa zahtevZaTrazenjePsa) throws Exception {
         KlijentskiZahtev kz=new KlijentskiZahtev();
        kz.setOperacija(Operacije.ZAPAMTI_ZAHTEV_ZA_TRAZENJE_PSA);
        kz.setParametar(zahtevZaTrazenjePsa);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno()){
            JOptionPane.showMessageDialog(null, so.getPoruka(), "Info", JOptionPane.INFORMATION_MESSAGE);
            return (ZahtevZaTrazenjePsa)so.getOdgovor();
        }
        //JOptionPane.showMessageDialog(null, so.getPoruka(), "Greška", JOptionPane.ERROR_MESSAGE);
        throw new Exception(so.getPoruka());
    }

    public ZahtevZaTrazenjePsa ucitajZahtevZaTrazenjePsa(ZahtevZaTrazenjePsa zahtevZaTrazenjePsa) throws Exception {
        KlijentskiZahtev kz=new KlijentskiZahtev();
        kz.setOperacija(Operacije.UCITAJ_ZAHTEV_ZA_TRAZENJE_PSA);
        kz.setParametar(zahtevZaTrazenjePsa);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno()){
            JOptionPane.showMessageDialog(null, so.getPoruka(), "Info", JOptionPane.INFORMATION_MESSAGE);
            return (ZahtevZaTrazenjePsa)so.getOdgovor();
        }
        throw new Exception(so.getPoruka());
    }

    public PrijavaPronalaskaPsa ucitajPrijavuPronalaskaPsa(PrijavaPronalaskaPsa prijavaPronalaskaPsa) throws Exception {
        KlijentskiZahtev kz=new KlijentskiZahtev();
        kz.setOperacija(Operacije.UCITAJ_PRIJAVU_PRONALASKA_PSA);
        kz.setParametar(prijavaPronalaskaPsa);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno()){
            JOptionPane.showMessageDialog(null, so.getPoruka(), "Info", JOptionPane.INFORMATION_MESSAGE);
            return (PrijavaPronalaskaPsa)so.getOdgovor();
        }
        throw new Exception(so.getPoruka());
    }

    public Pronalazak ucitajPronalazak(Pronalazak pronalazak) throws Exception {
        KlijentskiZahtev kz=new KlijentskiZahtev();
        kz.setOperacija(Operacije.UCITAJ_PRONALAZAK);
        kz.setParametar(pronalazak);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno()){
            JOptionPane.showMessageDialog(null, so.getPoruka(), "Info", JOptionPane.INFORMATION_MESSAGE);
            return (Pronalazak)so.getOdgovor();
        }
        throw new Exception(so.getPoruka());
    }
    public void ucitajSliku(String putanjaDoSlike, JLabel lblSlika){
        //mora i ova da prima image
        ImageIcon imageIcon=new ImageIcon(putanjaDoSlike);
        int sirina=imageIcon.getIconWidth();
        int visina=imageIcon.getIconHeight();
        Double wh = sirina * 1.0/ visina;
        boolean slikaSira=wh>lblSlika.getWidth()*1.0/lblSlika.getHeight();
        Image image;
        if(!slikaSira){
            image = imageIcon.getImage().getScaledInstance((int) (lblSlika.getHeight()*wh), lblSlika.getHeight(), Image.SCALE_REPLICATE);
        }else{
            image = imageIcon.getImage().getScaledInstance(lblSlika.getWidth(), (int) (lblSlika.getWidth()/wh), Image.SCALE_REPLICATE);
        }
        ImageIcon konacna=new ImageIcon(image);
        lblSlika.setIcon(konacna);
    }
    public String MD5Hash(String lozinka){
        String lozinkaHash = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(lozinka.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            lozinkaHash = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
        }
        //System.out.println(lozinkaHash);
        return lozinkaHash;
    }

    public Korisnik ulogujKorisnika(Korisnik korisnik) throws Exception {
        KlijentskiZahtev kz=new KlijentskiZahtev();
        kz.setOperacija(Operacije.PRIJAVA_KORISNIKA);
        kz.setParametar(korisnik);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno()){
            JOptionPane.showMessageDialog(null, so.getPoruka(), "Info", JOptionPane.INFORMATION_MESSAGE);
            return (Korisnik)so.getOdgovor();
        }
        throw new Exception(so.getPoruka());
    }

    public Korisnik odjaviKorisnika(Korisnik korisnik) throws Exception {
        KlijentskiZahtev kz=new KlijentskiZahtev();
        kz.setOperacija(Operacije.ODJAVA_KORISNIKA);
        kz.setParametar(korisnik);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno()){
            JOptionPane.showMessageDialog(null, so.getPoruka(), "Info", JOptionPane.INFORMATION_MESSAGE);
            return (Korisnik)so.getOdgovor();
        }
        throw new Exception(so.getPoruka());
    }

    public Korisnik registrujKorisnika(Korisnik korisnik) throws Exception {
        KlijentskiZahtev kz=new KlijentskiZahtev();
        kz.setOperacija(Operacije.REGISTRACIJA_KORISNIKA);
        kz.setParametar(korisnik);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno()){
            JOptionPane.showMessageDialog(null, so.getPoruka(), "Info", JOptionPane.INFORMATION_MESSAGE);
            return (Korisnik)so.getOdgovor();
        }
        throw new Exception(so.getPoruka());
    }

    public Lokacija zapamtiLokaciju(Lokacija lokacija) throws Exception{
        KlijentskiZahtev kz=new KlijentskiZahtev();
        kz.setOperacija(Operacije.ZAPAMTI_LOKACIJU);
        kz.setParametar(lokacija);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno()){
            //JOptionPane.showMessageDialog(null, so.getPoruka(), "Info", JOptionPane.INFORMATION_MESSAGE);
            return (Lokacija)so.getOdgovor();
        }
        //JOptionPane.showMessageDialog(null, so.getPoruka(), "Greška", JOptionPane.ERROR_MESSAGE);
        throw new Exception(so.getPoruka());
    }
}

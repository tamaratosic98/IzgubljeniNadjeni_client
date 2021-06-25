/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.nprog.client.modeli;

import rs.ac.bg.fon.nprog.domen.ZahtevZaTrazenjePsa;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.nprog.client.kontoler.Kontroler;

/**
 *
 * @author tamara
 */
public class ModelTabeleZahtev  extends AbstractTableModel {
    private List<ZahtevZaTrazenjePsa> lista;
    private String[] kolone;

    public ModelTabeleZahtev(List<ZahtevZaTrazenjePsa> lista) {
        this.lista=lista;
        kolone=new String[]{"sifra","pol","boja","vreme nestanka","kontakt vlasnika","ime", "starost","rasa","lokacija"};
    }
    
    
    @Override
    public int getRowCount() {
       return getLista().size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ZahtevZaTrazenjePsa za=getLista().get(rowIndex);
        switch(columnIndex){
            case 0: return za.getZahtevZaTrazenjePsaId();
            case 1: return za.getPol();
            case 2: return za.getBoja();
            case 3: return Kontroler.vratiInstancu().formatDatumVreme(za.getVremeNestanka());
            case 4: return za.getKontaktVlasnika();
            case 5: return za.getIme();
            case 6: return za.getStarost();
            case 7: return za.getRasa();
            case 8: return za.getLokacija();
            default: return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    /**
     * @return the lista
     */
    public List<ZahtevZaTrazenjePsa> getLista() {
        return lista;
    }
    public void osvezi(List<ZahtevZaTrazenjePsa> lista){
        this.lista=lista;
        fireTableDataChanged();
    }
    
}

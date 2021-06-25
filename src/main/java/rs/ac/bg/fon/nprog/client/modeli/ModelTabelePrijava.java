/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.nprog.client.modeli;

import rs.ac.bg.fon.nprog.domen.PrijavaPronalaskaPsa;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.nprog.client.kontoler.Kontroler;

/**
 *
 * @author tamara
 */
public class ModelTabelePrijava extends AbstractTableModel{
    private List<PrijavaPronalaskaPsa> lista;
    private String[] kolone;

    public ModelTabelePrijava(List<PrijavaPronalaskaPsa> lista) {
        this.lista=lista;
        kolone=new String[]{"sifra","pol","boja","vreme pronalaska","kontakt nalazaca","rasa","lokacija"};
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
        PrijavaPronalaskaPsa ppp=getLista().get(rowIndex);
        switch(columnIndex){
            case 0: return ppp.getPrijavaPronalaskaPsaId();
            case 1: return ppp.getPol();
            case 2: return ppp.getBoja();
            case 3: return Kontroler.vratiInstancu().formatDatumVreme(ppp.getVremePronalaska());
            case 4: return ppp.getKontaktNalazaca();
            case 5: return ppp.getRasa();
            case 6: return ppp.getLokacija();
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
    public List<PrijavaPronalaskaPsa> getLista() {
        return lista;
    }
    
     public void osvezi(List<PrijavaPronalaskaPsa> lista){
        this.lista=lista;
        fireTableDataChanged();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.nprog.client.modeli;

import rs.ac.bg.fon.nprog.domen.Pronalazak;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.nprog.client.kontoler.Kontroler;

/**
 *
 * @author tamara
 */
public class ModelTabelePronalazak  extends AbstractTableModel{
    private List<Pronalazak> lista;
    private String[] kolone;
    

    public ModelTabelePronalazak(List<Pronalazak> lista) {
        this.lista=lista;
        kolone=new String[]{"zahtev za trazenje psa","prijava pronalaska psa","datum resavanja slucaja","napomena"};
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
        Pronalazak p=getLista().get(rowIndex);
        switch(columnIndex){
            case 0: return p.getZahtevZaTrazenjePsa();
            case 1: return p.getPrijavaPronalaskaPsa();
            case 2: return Kontroler.vratiInstancu().formatDatum(p.getDatumResavanjaSlucaja());
            case 3: return p.getNapomena();
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
    public List<Pronalazak> getLista() {
        return lista;
    }

    public void osvezi(List<Pronalazak> lista) {
        this.lista=lista;
        fireTableDataChanged();
    }

    public void add(Pronalazak pronalazak) {
        if(!lista.contains(pronalazak)){
            lista.add(pronalazak);
            fireTableDataChanged();
        }
    }

    public void remove(int index) {
        lista.remove(index);
        fireTableDataChanged();
    }
    
    
}

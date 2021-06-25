/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.nprog.client.gui;

import rs.ac.bg.fon.nprog.domen.Korisnik;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.nprog.client.kontoler.Kontroler;

/**
 *
 * @author tamara
 */
public class FrmRegistracija extends javax.swing.JDialog {

    /**
     * Creates new form FrmRegistracija
     */
    public FrmRegistracija(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        srediFormu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnRegistracija = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblIme = new javax.swing.JLabel();
        lblPrezime = new javax.swing.JLabel();
        lblTelefon = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblLozinka = new javax.swing.JLabel();
        lblLozinkaOpet = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        txtTelefon = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtLozinka = new javax.swing.JPasswordField();
        txtLozinkaOpet = new javax.swing.JPasswordField();
        lblError = new javax.swing.JLabel();
        btnRegistracija = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnRegistracija.setBackground(new java.awt.Color(153, 153, 153));
        pnRegistracija.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registracija", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        pnRegistracija.setForeground(new java.awt.Color(255, 255, 255));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/ac/bg/fon/nprog/img/logo.png"))); // NOI18N

        lblIme.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblIme.setForeground(new java.awt.Color(255, 255, 255));
        lblIme.setText("Ime");

        lblPrezime.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblPrezime.setForeground(new java.awt.Color(255, 255, 255));
        lblPrezime.setText("Prezime");

        lblTelefon.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblTelefon.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefon.setText("Telefon");

        lblEmail.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Email");

        lblLozinka.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblLozinka.setForeground(new java.awt.Color(255, 255, 255));
        lblLozinka.setText("Lozinka");

        lblLozinkaOpet.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblLozinkaOpet.setForeground(new java.awt.Color(255, 255, 255));
        lblLozinkaOpet.setText("Lozinka (ponovo)");

        txtIme.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        txtPrezime.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        txtTelefon.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        txtLozinka.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        txtLozinkaOpet.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        lblError.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));

        btnRegistracija.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btnRegistracija.setForeground(new java.awt.Color(102, 102, 102));
        btnRegistracija.setText("Registruj se");
        btnRegistracija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistracijaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnRegistracijaLayout = new javax.swing.GroupLayout(pnRegistracija);
        pnRegistracija.setLayout(pnRegistracijaLayout);
        pnRegistracijaLayout.setHorizontalGroup(
            pnRegistracijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRegistracijaLayout.createSequentialGroup()
                .addGroup(pnRegistracijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnRegistracijaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnRegistracijaLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pnRegistracijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnRegistracijaLayout.createSequentialGroup()
                                .addGroup(pnRegistracijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblIme)
                                    .addComponent(lblLozinkaOpet)
                                    .addComponent(lblPrezime)
                                    .addComponent(lblTelefon)
                                    .addComponent(lblEmail)
                                    .addComponent(lblLozinka))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnRegistracijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnRegistracija, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                    .addComponent(txtEmail)
                                    .addComponent(txtTelefon)
                                    .addComponent(txtPrezime)
                                    .addComponent(txtIme)
                                    .addComponent(txtLozinka)
                                    .addComponent(txtLozinkaOpet))))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pnRegistracijaLayout.setVerticalGroup(
            pnRegistracijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRegistracijaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnRegistracijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIme)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnRegistracijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrezime)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnRegistracijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefon)
                    .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnRegistracijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnRegistracijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLozinka)
                    .addComponent(txtLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnRegistracijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLozinkaOpet)
                    .addComponent(txtLozinkaOpet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRegistracija, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRegistracija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRegistracija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistracijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistracijaActionPerformed
        // TODO add your handling code here:
        String ime=txtIme.getText();
        String prezime=txtPrezime.getText();
        String telefon=txtTelefon.getText();
        String email=txtEmail.getText();
        String lozinka=txtLozinka.getText();
        String lozinkaOpet=txtLozinkaOpet.getText();
        if(ime.isEmpty() || prezime.isEmpty() || telefon.isEmpty() || email.isEmpty() || lozinka.isEmpty() || lozinkaOpet.isEmpty()){
            lblError.setText("Molimo Vas popunite sva polja radi uspešne registracije.");
            return;
        }
        lblError.setText("");
        if(!lozinka.equals(lozinkaOpet)){
            lblError.setText("Lozinke koje ste uneli se ne poklapaju.");
            JOptionPane.showMessageDialog(this,"Neuspešna registracija");
            return;
        }
        lblError.setText("");
        String lozinkaHash=Kontroler.vratiInstancu().MD5Hash(lozinka);
        Korisnik korisnik=new Korisnik(-1, ime, prezime, telefon, email, lozinkaHash);
        try {
            Kontroler.vratiInstancu().registrujKorisnika(korisnik);
            //new FrmMain(ulogovan).setVisible(true);
            //JOptionPane.showMessageDialog(this, "Uspešno!");
            this.dispose();
            new FrmPrijava().setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            Logger.getLogger(FrmRegistracija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegistracijaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistracija;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblIme;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLozinka;
    private javax.swing.JLabel lblLozinkaOpet;
    private javax.swing.JLabel lblPrezime;
    private javax.swing.JLabel lblTelefon;
    private javax.swing.JPanel pnRegistracija;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIme;
    private javax.swing.JPasswordField txtLozinka;
    private javax.swing.JPasswordField txtLozinkaOpet;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtTelefon;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        this.setTitle("Registracija");
        
    }
}

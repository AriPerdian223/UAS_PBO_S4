package tokostarmix;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;


public class Profile extends javax.swing.JFrame {

    /**
     * Creates new form Profile
     */
    public Profile() {
        // cek session
        if(Session.session.getSession() == null){
            Login login = new Login();
            this.setVisible(false);
            login.setVisible(true);
        }else{
            setIcon();
            initComponents();
            setProfilToko();
        }
    }
    
    public final void setProfilToko(){
        try {
            Connection conn = Koneksi.ConnectDB();
            String query = "SELECT * FROM tb_users WHERE id='"+Session.session.getSession()+"'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            String namaToko = "null";
            String pendapatan = "0";
            while(rs.next()){
                namaToko = rs.getString("nama_toko");
                pendapatan = rs.getString("pendapatan");
            }
            NamaToko_Profil.setText(namaToko);
            pendapatanValue.setText(RupiahFromat(Integer.parseInt(pendapatan)));
            
        } catch (SQLException e) {
            System.out.println("Data barang Gagal di tampilkan...");
            System.out.println(e);
        }
    }
    
    public String RupiahFromat(int amount){
        Locale indonesia = new Locale("id", "ID");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(indonesia);
        String formattedAmount = formatter.format(amount);
        formattedAmount = formattedAmount.replace("Rp", "");
        formattedAmount = formattedAmount.replace(",00", "");
        return formattedAmount;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        NamaToko_Profil = new javax.swing.JLabel();
        pendapatanValue = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnHapusAkun = new javax.swing.JButton();
        txtNamaToko = new javax.swing.JTextField();
        txtPasswordBaru = new javax.swing.JPasswordField();
        txtPasswordLama = new javax.swing.JPasswordField();
        btnLinkHome = new javax.swing.JButton();
        btnUpdatePassword = new javax.swing.JButton();
        btnUpdateNamaToko = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("APLIKASI TOKO STARMIX");
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password Baru     :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 510, 150, 20);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password Lama    :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(130, 460, 150, 20);

        NamaToko_Profil.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        NamaToko_Profil.setForeground(new java.awt.Color(255, 255, 255));
        NamaToko_Profil.setText("Nama Toko");
        getContentPane().add(NamaToko_Profil);
        NamaToko_Profil.setBounds(180, 60, 320, 50);

        pendapatanValue.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pendapatanValue.setForeground(new java.awt.Color(255, 255, 255));
        pendapatanValue.setText("0");
        getContentPane().add(pendapatanValue);
        pendapatanValue.setBounds(300, 110, 140, 20);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nama Toko     :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(130, 250, 120, 20);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Pendapatan : Rp ");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(180, 110, 120, 20);

        btnHapusAkun.setBackground(new java.awt.Color(0, 0, 0));
        btnHapusAkun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn-hapusAkun.png"))); // NOI18N
        btnHapusAkun.setBorder(null);
        btnHapusAkun.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapusAkun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusAkunActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapusAkun);
        btnHapusAkun.setBounds(150, 700, 300, 40);

        txtNamaToko.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtNamaToko);
        txtNamaToko.setBounds(260, 250, 200, 30);

        txtPasswordBaru.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtPasswordBaru);
        txtPasswordBaru.setBounds(280, 510, 180, 30);

        txtPasswordLama.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtPasswordLama);
        txtPasswordLama.setBounds(280, 460, 180, 30);

        btnLinkHome.setBackground(new java.awt.Color(0, 0, 0));
        btnLinkHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn-linkHome.png"))); // NOI18N
        btnLinkHome.setBorder(null);
        btnLinkHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLinkHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLinkHomeActionPerformed(evt);
            }
        });
        getContentPane().add(btnLinkHome);
        btnLinkHome.setBounds(460, 30, 100, 30);

        btnUpdatePassword.setBackground(new java.awt.Color(0, 0, 0));
        btnUpdatePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn-simpan.png"))); // NOI18N
        btnUpdatePassword.setBorder(null);
        btnUpdatePassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdatePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePasswordActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdatePassword);
        btnUpdatePassword.setBounds(240, 570, 90, 30);

        btnUpdateNamaToko.setBackground(new java.awt.Color(0, 0, 0));
        btnUpdateNamaToko.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn-simpan.png"))); // NOI18N
        btnUpdateNamaToko.setBorder(null);
        btnUpdateNamaToko.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateNamaToko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateNamaTokoActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdateNamaToko);
        btnUpdateNamaToko.setBounds(250, 310, 90, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/bg-profile.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 600, 816);

        setSize(new java.awt.Dimension(616, 824));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateNamaTokoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateNamaTokoActionPerformed
        // TODO add your handling code here:
        String namaTokoBaru = txtNamaToko.getText();
        if(!namaTokoBaru.isEmpty() && !namaTokoBaru.isBlank()){
            if(namaTokoBaru.length() >= 4){
                try {
                    Connection conn = Koneksi.ConnectDB();
                    String updt = "UPDATE `tb_users` SET `nama_toko`='"+namaTokoBaru+"' WHERE id='"+Session.session.getSession()+"'";
                    PreparedStatement preStmt = conn.prepareStatement(updt);
                    preStmt.execute();
                    JOptionPane.showMessageDialog(rootPane, "Berhasil.. \nNama Toko berhasil diubah!", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
                    NamaToko_Profil.setText(namaTokoBaru);
                    txtNamaToko.setText("");
                    
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(rootPane, "Oopss...\nData ditolak!", "Gagal", JOptionPane.ERROR_MESSAGE);
                    System.out.println(e);
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Oopss...\nNama Toko min.4 karakter!!", "Gagal", JOptionPane.ERROR_MESSAGE);
                txtNamaToko.setText("");
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Oopss...\nData harus diisi dengan benar!", "Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateNamaTokoActionPerformed

    private void btnUpdatePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePasswordActionPerformed
        // TODO add your handling code here:
        String passwordLama = txtPasswordLama.getText();
        String passwordBaru = txtPasswordBaru.getText();
        
        if(!passwordLama.isEmpty() && !passwordLama.isBlank() && !passwordBaru.isEmpty() && !passwordBaru.isBlank()){
            try {
                Connection conn = Koneksi.ConnectDB();
                String query = "SELECT * FROM tb_users WHERE id='"+Session.session.getSession()+"'";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                String password = "";
                while(rs.next()){
                    password = rs.getString("password");
                }
                // cek password lama
                if(password.equals(passwordLama)){
                    if(passwordBaru.length() >= 4){
                        if(!passwordBaru.equals(passwordLama)){
                            try {
                                String updt = "UPDATE `tb_users` SET `password`='"+passwordBaru+"' WHERE id='"+Session.session.getSession()+"'";
                                PreparedStatement preStmt = conn.prepareStatement(updt);
                                preStmt.execute();
                                JOptionPane.showMessageDialog(rootPane, "Berhasil.. \nNama Toko berhasil diubah!", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
                                txtPasswordLama.setText("");
                                txtPasswordBaru.setText("");

                            } catch (SQLException e) {
                                JOptionPane.showMessageDialog(rootPane, "Oopss...\nData ditolak!", "Gagal", JOptionPane.ERROR_MESSAGE);
                                System.out.println(e);
                            }
                        }else{
                            JOptionPane.showMessageDialog(rootPane, "Oopss...\nPassword baru tidak boleh sama!", "Gagal", JOptionPane.ERROR_MESSAGE);
                            txtPasswordBaru.setText("");
                        }
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Oopss...\nPassword min.4 karakter!", "Gagal", JOptionPane.ERROR_MESSAGE);
                        txtPasswordLama.setText("");
                    }
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Oopss...\nPassword Lama salah!", "Gagal", JOptionPane.ERROR_MESSAGE);
                    txtPasswordLama.setText("");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Oopss...\nData ditolak!", "Gagal", JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Oopss...\nData harus diisi dengan benar!", "Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdatePasswordActionPerformed

    private void btnLinkHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLinkHomeActionPerformed
        // TODO add your handling code here:
        AplikasiStarmix home = new AplikasiStarmix();
        this.setVisible(false);
        home.setVisible(true);
    }//GEN-LAST:event_btnLinkHomeActionPerformed

    private void btnHapusAkunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusAkunActionPerformed
        // TODO add your handling code here:
        int Pilih = JOptionPane.showConfirmDialog(rootPane,"Yakin ingin hapus akun permanen?\n*semua data akan terhapus secara permanen","Konfirmasi",JOptionPane.OK_CANCEL_OPTION);
        if(Pilih == JOptionPane.OK_OPTION){
            // hapus data user
            try {
                Connection conn = Koneksi.ConnectDB();
                String delet1 = "DELETE FROM `tb_keranjang` WHERE id_user='"+Session.session.getSession()+"'";
                PreparedStatement preStmt1 = conn.prepareStatement(delet1);
                preStmt1.execute();
                
                String delet2 = "DELETE FROM `tb_transaksi` WHERE id_user='"+Session.session.getSession()+"'";
                PreparedStatement preStmt2 = conn.prepareStatement(delet2);
                preStmt2.execute();
                
                String delet3 = "DELETE FROM `tb_barang` WHERE id_user='"+Session.session.getSession()+"'";
                PreparedStatement preStmt3 = conn.prepareStatement(delet3);
                preStmt3.execute();
                
                String delet4 = "DELETE FROM `tb_history` WHERE id_user='"+Session.session.getSession()+"'";
                PreparedStatement preStmt4 = conn.prepareStatement(delet4);
                preStmt4.execute();
                
                String delet5 = "DELETE FROM `tb_users` WHERE id='"+Session.session.getSession()+"'";
                PreparedStatement preStmt5 = conn.prepareStatement(delet5);
                preStmt5.execute();
                
                JOptionPane.showMessageDialog(rootPane, "Berhasil.. \nHapus Akun permanen berhasil!", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
                
                //set session
                Session.session.setSession(null);
                Login login = new Login();
                this.setVisible(false);
                login.setVisible(true);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Oopss...\nData ditolak!", "Gagal", JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
            }
            
        }else if(Pilih == JOptionPane.CANCEL_OPTION){
            setProfilToko();
        }
    }//GEN-LAST:event_btnHapusAkunActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NamaToko_Profil;
    private javax.swing.JButton btnHapusAkun;
    private javax.swing.JButton btnLinkHome;
    private javax.swing.JButton btnUpdateNamaToko;
    private javax.swing.JButton btnUpdatePassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel pendapatanValue;
    private javax.swing.JTextField txtNamaToko;
    private javax.swing.JPasswordField txtPasswordBaru;
    private javax.swing.JPasswordField txtPasswordLama;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../assets/icon-apk.png")));
    }
}

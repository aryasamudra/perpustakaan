/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.arya.sa.bangsukri.frames.perpustakaan;

import com.arya.sa.bangsukri.db.Basisdata;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Administrator
 */


public class PeminjamanAddFrame extends javax.swing.JFrame {

    /**
     * Creates new form PeminjamanAddFrame
     */
    public PeminjamanAddFrame() {
        initComponents();
        tanggalpinjamDatePicker.setDateToToday();
        tanggalkembaliDatePicker.setDateToToday();
        try {
            Connection koneksi = Basisdata.getConnection();
            String selectSQL = "SELECT * FROM anggota ";
            Statement statement = koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSQL);

            DefaultComboBoxModel m = new DefaultComboBoxModel();
                
            m = new DefaultComboBoxModel();
              m.addElement(
                  new ComboboxItem(
                          0, 
                          "- Pilih Nama Peminjam -")
                );
            
            while(resultSet.next()){
                m.addElement(
                  new ComboboxItem(
                          resultSet.getInt("idanggota"), 
                          resultSet.getString("nama"))
                );
            }
            
            namaCombobox.setModel(m);
            
            selectSQL = "SELECT * FROM buku";
            statement = koneksi.createStatement();
            resultSet = statement.executeQuery(selectSQL);

            m = new DefaultComboBoxModel();
              m.addElement(
                  new ComboboxItem(
                          0, 
                          "- Pilih Judul Buku -")
                );  
            while(resultSet.next()){
                m.addElement(
                  new ComboboxItem(
                          resultSet.getInt("nobuku"), 
                          resultSet.getString("judul"))
                );
            }
            
            judulCombobox.setModel(m);
            
            koneksi.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public PeminjamanAddFrame(int id) {
         initComponents();
    tanggalpinjamDatePicker.setDateToToday();
    tanggalkembaliDatePicker.setDateToToday();
    try {
        Connection koneksi = Basisdata.getConnection();

        // Fetch peminjaman data
        String selectPeminjamanSQL = "SELECT * FROM peminjaman WHERE id = " + id;
        Statement statementPeminjaman = koneksi.createStatement();
        ResultSet resultSetPeminjaman = statementPeminjaman.executeQuery(selectPeminjamanSQL);

        if (resultSetPeminjaman.next()) {
            idTextField.setText(String.valueOf(resultSetPeminjaman.getInt("id")));
        }

        // Fetch anggota data
        String selectAnggotaSQL = "SELECT * FROM anggota ";
        Statement statementAnggota = koneksi.createStatement();
        ResultSet resultSetAnggota = statementAnggota.executeQuery(selectAnggotaSQL);

        DefaultComboBoxModel mAnggota = new DefaultComboBoxModel();
        mAnggota.addElement(new ComboboxItem(0, "- Pilih Nama Peminjam -"));

        while (resultSetAnggota.next()) {
            mAnggota.addElement(
                    new ComboboxItem(
                            resultSetAnggota.getInt("idanggota"),
                            resultSetAnggota.getString("nama"))
            );
        }

        namaCombobox.setModel(mAnggota);

        // Fetch buku data
        String selectBukuSQL = "SELECT * FROM buku";
        Statement statementBuku = koneksi.createStatement();
        ResultSet resultSetBuku = statementBuku.executeQuery(selectBukuSQL);

        DefaultComboBoxModel mBuku = new DefaultComboBoxModel();
        mBuku.addElement(new ComboboxItem(0, "- Pilih Judul Buku -"));

        while (resultSetBuku.next()) {
            mBuku.addElement(
                    new ComboboxItem(
                            resultSetBuku.getInt("nobuku"),
                            resultSetBuku.getString("judul"))
            );
        }

        judulCombobox.setModel(mBuku);

        // Close ResultSets and Statements
        resultSetPeminjaman.close();
        statementPeminjaman.close();
        resultSetAnggota.close();
        statementAnggota.close();
        resultSetBuku.close();
        statementBuku.close();

        koneksi.close();
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        judulLabel = new javax.swing.JLabel();
        simpanButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        batalButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        namaCombobox = new javax.swing.JComboBox<>();
        judulCombobox = new javax.swing.JComboBox<>();
        tanggalpinjamDatePicker = new com.github.lgooddatepicker.components.DatePicker();
        tanggalkembaliDatePicker = new com.github.lgooddatepicker.components.DatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Id");

        jLabel3.setText("Judul Buku");

        judulLabel.setText("Tambah Data Peminjaman Buku");

        simpanButton.setText("Simpan");
        simpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Tanggal Pinjam");

        batalButton.setText("Batal");
        batalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Tanggal Kembali");

        idTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama Peminjam");

        namaCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        judulCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(judulLabel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(simpanButton)
                                .addGap(18, 18, 18)
                                .addComponent(batalButton))
                            .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(judulCombobox, javax.swing.GroupLayout.Alignment.LEADING, 0, 143, Short.MAX_VALUE)
                                .addComponent(namaCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(tanggalpinjamDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tanggalkembaliDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(135, 135, 135))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(judulLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(namaCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(judulCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tanggalpinjamDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tanggalkembaliDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpanButton)
                    .addComponent(batalButton))
                .addGap(0, 110, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanButtonActionPerformed
        String tanggalpinjam = tanggalpinjamDatePicker.getDate().toString();
        String tanggalkembali = tanggalkembaliDatePicker.getDate().toString();
        String nama = namaCombobox.getSelectedItem().toString();
        int nama_peminjam = ((ComboboxItem) namaCombobox.getSelectedItem()).getId();
        int judul_buku = ((ComboboxItem) judulCombobox.getSelectedItem()).getId();
        //System.out.println(tanggalpinjam);
        //System.out.println(tanggalkembali);
        //System.out.println(nama_peminjam);
        //System.out.println(judul_buku);
        
        if(idTextField.getText().equals("")){
            try {
            Connection koneksi = Basisdata.getConnection();
            String insertSQL = "INSERT INTO peminjaman SET " +
                    "idanggota = '" + nama_peminjam + "'," +
                    "nobuku = '" + judul_buku + "'," +
                    "tglpinjam = '" + tanggalpinjam + "'," + 
                    "tglkembali = '" + tanggalkembali + "'";
            Statement statement = koneksi.createStatement();
            statement.executeUpdate(insertSQL);
            koneksi.close();
            dispose();
   } catch (SQLException ex) {
      System.err.println(ex.getMessage());
   }
} else {
   try {
      Connection koneksi = Basisdata.getConnection();
      String updateSQL = "UPDATE peminjaman SET " +
                    "idanggota = '" + nama_peminjam + "'," +
                    "nobuku = '" + judul_buku + "'," +
                    "tglpinjam = '" + tanggalpinjam + "'," +
                    "tglkembali = '" + tanggalkembali + "'" +
                    " WHERE id = " + idTextField.getText();
        Statement statement = koneksi.createStatement();
      statement.executeUpdate(updateSQL);
      koneksi.close();
      dispose();
   } catch (SQLException ex) {
      System.err.println(ex.getMessage());
   }
}
    }//GEN-LAST:event_simpanButtonActionPerformed

    private void batalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalButtonActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_batalButtonActionPerformed

    private void idTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(PeminjamanAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PeminjamanAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PeminjamanAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PeminjamanAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PeminjamanAddFrame().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batalButton;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox<String> judulCombobox;
    private javax.swing.JLabel judulLabel;
    private javax.swing.JComboBox<String> namaCombobox;
    private javax.swing.JButton simpanButton;
    private com.github.lgooddatepicker.components.DatePicker tanggalkembaliDatePicker;
    private com.github.lgooddatepicker.components.DatePicker tanggalpinjamDatePicker;
    // End of variables declaration//GEN-END:variables
}

package id.web.candra.kamus.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import id.web.candra.kamus.db.*;

/**
 *
 * @author NAZ
 */
public class MasterData extends javax.swing.JFrame {

    private List<Kamus> records = new ArrayList<Kamus>();

    /** Creates new form MasterBuku */
    public MasterData() {
        initComponents();
        this.posisiAwal();
        this.loadRecords();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2,
                size.height / 2 - getHeight() / 2);
    }

    private void setClearTextField() {
        //     txtNo.setText("");
        txtKorea.setText("");
        txtSpelling.setText("");
        txtIndonesia.setText("");

    }

    private void setTextEnabled(boolean status) {
        //    txtNo.setEditable(status);
        //  txtNo.setEnabled(status);
        txtKorea.setEnabled(status);
        txtSpelling.setEnabled(status);
        txtIndonesia.setEnabled(status);

    }

    private void setPencarianEnabled(boolean status) {
        cariTextField.setEnabled(status);
        cariTextField.setText("");

        cariButton.setEnabled(status);
    }

    private void setFillTextField() {
        Kamus k = records.get(kamusTable.getSelectedRow());
        //     txtNo.setText(String.valueOf(korea.getNo()));
        txtKorea.setText(k.getKorea());
        txtSpelling.setText(k.getLafal());
        txtIndonesia.setText(k.getIndonesia());



    }

    private void setClearTable() {
        kamusTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{{null, null, null, null}},
                new String[]{"No", "Korea", "Spelling", "Indonesia"}));
    }

    private void posisiAwal() {
        this.setClearTextField();
        this.setTextEnabled(false);
        this.setPencarianEnabled(true);

        tambahButton.setEnabled(true);
        tambahButton.setText("tambah");
        editButton.setEnabled(true);
        editButton.setText("edit");
        resetButton.setEnabled(true);
        hapusButton.setEnabled(true);

        this.setClearTable();
        kamusTable.setEnabled(true);
        cariTextField.requestFocusInWindow();
    }

    private void posisiEdit() {
        this.setTextEnabled(true);
        this.setPencarianEnabled(false);
        kamusTable.setEnabled(false);
        tambahButton.setEnabled(false);

        this.setFillTextField();
        editButton.setText("simpan");
        //   txtNo.setEnabled(false);
        txtKorea.requestFocusInWindow();
    }

    private void posisiTambah() {
        this.setTextEnabled(true);
        editButton.setEnabled(false);
        tambahButton.setText("simpan");
        hapusButton.setEnabled(false);
        txtKorea.requestFocusInWindow();
        //    kodeBukuTextField.requestFocusInWindow();
    }

    //untuk ngisi table pas init
    private void loadRecords() {
        try {
            DBConnection conn = DBConnection.getInstance();
            KamusDAO dao = new KamusDAO(conn.getConnection());
            records = dao.selectAll();
            this.setFillTable();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setFillTable() {
        Object data[][] = new Object[records.size()][4];
        int x = 0;
        for (Kamus k : records) {
            data[x][0] = k.getNo();
            data[x][1] = k.getKorea();
            data[x][2] = k.getLafal();
            data[x][3] = k.getIndonesia();

            ++x;
        }
        String[] judul = {"No", "korea", "lafal", "indonesia"};

        kamusTable.setModel(new DefaultTableModel(data, judul));
        kamusScrollPane.setViewportView(kamusTable);
    }

    //untuk pencarian
    private void loadRecords(int kategori, String text) {
        try {
            DBConnection conn = DBConnection.getInstance();
            KamusDAO dao = new KamusDAO(conn.getConnection());
            if (kategori == 0) {
                records = dao.selectAllByIndonesian(text);
            } else {
                records = dao.selectAll();
            }
            this.setFillTable();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isTextFieldNotEmpty() {
        if (!txtKorea.getText().isEmpty()
                && !txtSpelling.getText().isEmpty()
                && !txtIndonesia.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statusButtonGroup = new javax.swing.ButtonGroup();
        editButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        kamusScrollPane = new javax.swing.JScrollPane();
        kamusTable = new javax.swing.JTable();
        hapusButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        cariTextField = new javax.swing.JTextField();
        cariButton = new javax.swing.JButton();
        tambahButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtKorea = new javax.swing.JTextField();
        txtSpelling = new javax.swing.JTextField();
        txtIndonesia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setTitle("Kamus");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        editButton.setText("edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        resetButton.setText("reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Kamus"));

        kamusTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Korea", "Spelling", "Indonesia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        kamusScrollPane.setViewportView(kamusTable);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kamusScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(kamusScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addContainerGap())
        );

        hapusButton.setText("hapus");
        hapusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusButtonActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Pencarian"));

        cariTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariTextFieldcariNamaDosenTextFieldActionPerformed(evt);
            }
        });

        cariButton.setText("cari");
        cariButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariButtoncariButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cariTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(cariButton)
                .addGap(22, 22, 22))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(cariTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cariButton))
        );

        tambahButton.setText("tambah");
        tambahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Korea");

        jLabel2.setText("Spelling");

        jLabel3.setText("Indonesia");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel4.setText("Pengolahan data Kamus");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tambahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resetButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hapusButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKorea, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                    .addComponent(txtSpelling, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                    .addComponent(txtIndonesia, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKorea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSpelling, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIndonesia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editButton)
                            .addComponent(resetButton)
                            .addComponent(hapusButton)
                            .addComponent(tambahButton))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        if (editButton.getText().equals("edit")) {
            this.posisiEdit();
        } else if (editButton.getText().equals("simpan")) {
            if (isTextFieldNotEmpty()) {
                try {
                    Kamus korea = new Kamus();
                    korea.setKorea(txtKorea.getText());
                    korea.setLafal(txtSpelling.getText());
                    korea.setIndonesia(txtIndonesia.getText());


                    DBConnection conn = DBConnection.getInstance();
                    KamusDAO dao = new KamusDAO(conn.getConnection());
                    dao.update(records.get(kamusTable.getSelectedRow()).getNo(), korea);
                    this.posisiAwal();
                    this.loadRecords();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            this.posisiAwal();
            this.setPencarianEnabled(true);
            this.editButton.setText("edit");
            this.loadRecords();
        }
}//GEN-LAST:event_editButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        this.posisiAwal();
        this.loadRecords();
}//GEN-LAST:event_resetButtonActionPerformed

    private void hapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusButtonActionPerformed

        try {
            Kamus korea= records.get(kamusTable.getSelectedRow());
            int kode = korea.getNo();

            DBConnection conn = DBConnection.getInstance();
            KamusDAO dao = new KamusDAO(conn.getConnection());
            dao.delete(kode);
            JOptionPane.showMessageDialog(this, "Data Terhapus!");
            this.posisiAwal();
            this.loadRecords();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Tidak jadi hapus data!");
        }
}//GEN-LAST:event_hapusButtonActionPerformed

    private void cariTextFieldcariNamaDosenTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariTextFieldcariNamaDosenTextFieldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_cariTextFieldcariNamaDosenTextFieldActionPerformed

    private void cariButtoncariButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariButtoncariButtonActionPerformed
        if (!cariTextField.getText().isEmpty()) {
            loadRecords(0, cariTextField.getText());
        } else {
            this.loadRecords();
        }
}//GEN-LAST:event_cariButtoncariButtonActionPerformed

    private void tambahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahButtonActionPerformed
        if (tambahButton.getText().equals("tambah")) {
            this.posisiTambah();
        } else if (tambahButton.getText().equals("simpan")) {
            if (isTextFieldNotEmpty()) {
                //    if (JOptionPane.showConfirmDialog(this, "Yakin simpan data?", "Konfirmasi", JOptionPane.YES_NO_OPTION) == 0) {
                try {
                    Kamus korea = new Kamus();
                    korea.setKorea(txtKorea.getText());
                    korea.setLafal(txtSpelling.getText());
                    korea.setIndonesia(txtIndonesia.getText());


                    DBConnection conn = DBConnection.getInstance();
                    KamusDAO dao = new KamusDAO(conn.getConnection());
                    
                    dao.insert(korea);
                    JOptionPane.showMessageDialog(this, "Data Tersimpan!");
                    this.posisiAwal();
                    this.loadRecords();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Data gagal disimpan simpan data!\n"+ex);
                }
                //   }
            } else {
                JOptionPane.showMessageDialog(this, "Semua data harus diisi!");

            }
        }

}//GEN-LAST:event_tambahButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cariButton;
    private javax.swing.JTextField cariTextField;
    private javax.swing.JButton editButton;
    private javax.swing.JButton hapusButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane kamusScrollPane;
    private javax.swing.JTable kamusTable;
    private javax.swing.JButton resetButton;
    private javax.swing.ButtonGroup statusButtonGroup;
    private javax.swing.JButton tambahButton;
    private javax.swing.JTextField txtIndonesia;
    private javax.swing.JTextField txtKorea;
    private javax.swing.JTextField txtSpelling;
    // End of variables declaration//GEN-END:variables
}

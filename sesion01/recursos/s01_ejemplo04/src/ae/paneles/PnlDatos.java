/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ae.paneles;

/**
 *
 * @author emaravi
 */
public class PnlDatos extends javax.swing.JPanel {

    /**
     * Creates new form PnlDatos
     */
    public PnlDatos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgSexo = new javax.swing.ButtonGroup();
        lblDni = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblPeso = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        rbtnMasc = new javax.swing.JRadioButton();
        rbtnFem = new javax.swing.JRadioButton();
        lblPasatiempo = new javax.swing.JLabel();
        cmbPasatiempo = new javax.swing.JComboBox();
        spnFeNac = new javax.swing.JSpinner();
        lblFeNac = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSalida = new javax.swing.JTextArea();
        btnVer = new javax.swing.JButton();
        lblKg = new javax.swing.JLabel();

        lblDni.setText("DNI");

        lblNombre.setText("Nombre");

        lblPeso.setText("Peso");

        lblSexo.setText("Sexo");

        bgSexo.add(rbtnMasc);
        rbtnMasc.setText("Masculino");

        bgSexo.add(rbtnFem);
        rbtnFem.setText("Femenino");

        lblPasatiempo.setText("Pasatiempo");

        cmbPasatiempo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Música", "Leer ", "Cine", "Deporte" }));
        cmbPasatiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPasatiempoActionPerformed(evt);
            }
        });

        spnFeNac.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.MONTH));
        spnFeNac.setToolTipText("Mes");

        lblFeNac.setText("Fe. Nac.");

        txtSalida.setColumns(20);
        txtSalida.setRows(5);
        jScrollPane1.setViewportView(txtSalida);

        btnVer.setText("Ver datos");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        lblKg.setText("Kg.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPasatiempo)
                            .addComponent(lblFeNac))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbPasatiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnFeNac, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDni)
                        .addGap(47, 47, 47)
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre)
                            .addComponent(lblPeso))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblKg))))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSexo)
                        .addGap(43, 43, 43)
                        .addComponent(rbtnMasc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnFem))
                    .addComponent(btnVer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDni)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPeso)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblKg)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexo)
                    .addComponent(rbtnMasc)
                    .addComponent(rbtnFem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPasatiempo)
                    .addComponent(cmbPasatiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnFeNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFeNac))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        //limpia la caja de texto 
        txtSalida.setText("Datos Personales \n");
        txtSalida.setText("============================== \n");
        
        //Mostrar los datos 
        txtSalida.append("dni:" + txtDni.getText() + "\n");
        txtSalida.append("nombres:" + txtNombre.getText() + "\n");
        txtSalida.append("Peso:" + txtPeso.getText() + "\n");
        txtSalida.append("Género:" + (rbtnMasc.isSelected()?"Masculino":"Femenino") + "\n");
        txtSalida.append("Pasatiempo:" + cmbPasatiempo.getSelectedItem()+ "\n");
        txtSalida.append("FEcha de Nacimiento:" + spnFeNac.getValue() + "\n");
        
    }//GEN-LAST:event_btnVerActionPerformed

    private void cmbPasatiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPasatiempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPasatiempoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgSexo;
    private javax.swing.JButton btnVer;
    private javax.swing.JComboBox cmbPasatiempo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblFeNac;
    private javax.swing.JLabel lblKg;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPasatiempo;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JRadioButton rbtnFem;
    private javax.swing.JRadioButton rbtnMasc;
    private javax.swing.JSpinner spnFeNac;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextArea txtSalida;
    // End of variables declaration//GEN-END:variables
}

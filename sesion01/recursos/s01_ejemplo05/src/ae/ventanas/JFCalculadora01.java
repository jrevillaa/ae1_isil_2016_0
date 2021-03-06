/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ae.ventanas;

import ae.paneles.PnlOperacionesAvanzadas;
import ae.paneles.PnlOperacionesBasicas;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author emaravi
 */
public class JFCalculadora01 extends javax.swing.JFrame {

    private JPanel p1 = new PnlOperacionesBasicas();
    private JPanel p2 = new PnlOperacionesAvanzadas();
    
    /**
     * Creates new form JFCalculadora01
     */
    public JFCalculadora01() {
        initComponents();
        pnlPrincipal.setLayout(new BorderLayout());
        pnlPrincipal.add(p1,BorderLayout.CENTER);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmArchivo = new javax.swing.JMenu();
        jmiSalir = new javax.swing.JMenuItem();
        jmOperaciones = new javax.swing.JMenu();
        jmiCalculadora = new javax.swing.JMenuItem();
        jmiOperaciones = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("La Calculadora");

        pnlPrincipal.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 257, Short.MAX_VALUE)
        );

        jmArchivo.setText("Archivo");

        jmiSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jmiSalir.setText("Salir");
        jmiSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSalirActionPerformed(evt);
            }
        });
        jmArchivo.add(jmiSalir);

        jMenuBar1.add(jmArchivo);

        jmOperaciones.setText("Operaciones");

        jmiCalculadora.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jmiCalculadora.setText("Calculadora Basica");
        jmiCalculadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCalculadoraActionPerformed(evt);
            }
        });
        jmOperaciones.add(jmiCalculadora);

        jmiOperaciones.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jmiOperaciones.setText("Operaciones 02");
        jmiOperaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiOperacionesActionPerformed(evt);
            }
        });
        jmOperaciones.add(jmiOperaciones);

        jMenuBar1.add(jmOperaciones);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jmiCalculadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCalculadoraActionPerformed
        pnlPrincipal.remove(p2);
        pnlPrincipal.add(p1,BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(pnlPrincipal);
    }//GEN-LAST:event_jmiCalculadoraActionPerformed

    private void jmiSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jmiSalirActionPerformed

    private void jmiOperacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiOperacionesActionPerformed
        pnlPrincipal.remove(p1);
        pnlPrincipal.add(p2,BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(pnlPrincipal);
    }//GEN-LAST:event_jmiOperacionesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFCalculadora01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFCalculadora01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFCalculadora01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFCalculadora01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new JFCalculadora01().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmArchivo;
    private javax.swing.JMenu jmOperaciones;
    private javax.swing.JMenuItem jmiCalculadora;
    private javax.swing.JMenuItem jmiOperaciones;
    private javax.swing.JMenuItem jmiSalir;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}

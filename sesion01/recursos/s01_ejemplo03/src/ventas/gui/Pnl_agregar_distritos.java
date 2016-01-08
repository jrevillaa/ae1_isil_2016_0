package ventas.gui;

import ventas.bean.Distrito;

import ventas.dao.DistritoDAO;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pnl_agregar_distritos extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1922898602554935240L;
	private JPanel jPanel1 = new JPanel();
    private JButton btnGrabar = new JButton();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JTextField txtCodigo = new JTextField();
    private JTextField txtNombre = new JTextField();
    private JTextField txtVendedor = new JTextField();

    public Pnl_agregar_distritos() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setSize(new Dimension(247, 154));
        jPanel1.setBounds(new Rectangle(10, 10, 230, 105));
        jPanel1.setBorder(BorderFactory.createTitledBorder("Nuevo Distrito"));
        jPanel1.setLayout(null);
        btnGrabar.setText("Grabar");
        btnGrabar.setBounds(new Rectangle(135, 120, 100, 25));
        btnGrabar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnGrabar_actionPerformed(e);
                    }
                });
        jLabel1.setText("Codigo");
        jLabel1.setBounds(new Rectangle(10, 20, 70, 15));
        jLabel1.setFont(new Font("Dialog", 1, 15));
        jLabel2.setText("Nombre");
        jLabel2.setBounds(new Rectangle(10, 45, 75, 15));
        jLabel2.setFont(new Font("Dialog", 1, 15));
        jLabel3.setText("Vendedor");
        jLabel3.setBounds(new Rectangle(10, 70, 75, 15));
        jLabel3.setFont(new Font("Dialog", 1, 15));
        txtCodigo.setBounds(new Rectangle(100, 15, 55, 20));
        txtNombre.setBounds(new Rectangle(100, 40, 120, 20));
        txtVendedor.setBounds(new Rectangle(100, 65, 120, 20));
        jPanel1.add(txtVendedor, null);
        jPanel1.add(txtNombre, null);
        jPanel1.add(txtCodigo, null);
        jPanel1.add(jLabel3, null);
        jPanel1.add(jLabel2, null);
        jPanel1.add(jLabel1, null);
        this.add(btnGrabar, null);
        this.add(jPanel1, null);
    }

    private void btnGrabar_actionPerformed(ActionEvent e) {

        try {
            DistritoDAO d = new DistritoDAO();
            d.cargaDistritos();//llenamos el vector con datos de la BD
            Distrito objD = d.buscar(txtCodigo.getText());
            if(objD==null){
                d.agregaDistrito(txtCodigo.getText(),
                                            txtNombre.getText(),
                                            txtVendedor.getText());
                JOptionPane.showMessageDialog(this,
                                    "Datos guardados satisfactoriamente",
                                    "Exito", 1);
            }else{
                JOptionPane.showMessageDialog(this,
                                    "El codigo ya existe",
                                    "Error", 2);
            }
        } catch (SQLException f) {
            System.out.println(f.toString());
        }
    }
}

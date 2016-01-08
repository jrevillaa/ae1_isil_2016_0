package ventas.gui;

import ventas.bean.Distrito;

import ventas.dao.DistritoDAO;

import java.awt.Dimension;

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

public class Pnl_eliminar_distrito extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jPanel1 = new JPanel();
    private JLabel lblCodigo = new JLabel();
    private JTextField txtCodigo = new JTextField();
    private JButton btnEliminar = new JButton();

    public Pnl_eliminar_distrito() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setSize(new Dimension(379, 100));
        jPanel1.setBounds(new Rectangle(5, 5, 370, 90));
        jPanel1.setBorder(BorderFactory.createTitledBorder("Eliminar Distrito"));
        jPanel1.setLayout(null);
        lblCodigo.setText("Codigo");
        lblCodigo.setBounds(new Rectangle(15, 30, 90, 30));
        txtCodigo.setBounds(new Rectangle(110, 30, 125, 30));
        btnEliminar.setText("Eliminar");
        btnEliminar.setBounds(new Rectangle(250, 30, 110, 30));
        btnEliminar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnEliminar_actionPerformed(e);
                    }
                });
        jPanel1.add(btnEliminar, null);
        jPanel1.add(txtCodigo, null);
        jPanel1.add(lblCodigo, null);
        this.add(jPanel1, null);
    }

    private void btnEliminar_actionPerformed(ActionEvent e) {        
    try {
            DistritoDAO d = new DistritoDAO();
            d.cargaDistritos();//llenamos el vector con datos de la BD
            Distrito objD = d.buscar(txtCodigo.getText());
            if(objD!=null){
                d.eliminaDistrito(txtCodigo.getText());
                JOptionPane.showMessageDialog(this,
                                    "Datos Eliminados satisfactoriamente",
                                    "Exito", 1);
            }else{
                JOptionPane.showMessageDialog(this,
                                    "El codigo no existe",
                                    "Error", 2);
            }
        } catch (SQLException f) {
            System.out.println(f.toString());
        }
    }
}

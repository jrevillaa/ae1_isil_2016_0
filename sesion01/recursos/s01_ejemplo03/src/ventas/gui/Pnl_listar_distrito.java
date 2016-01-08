package ventas.gui;

import ventas.bean.Distrito;

import ventas.dao.DistritoDAO;

import java.awt.Dimension;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Pnl_listar_distrito extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btn_Ver = new JButton();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTextArea txtSalida = new JTextArea();

    public Pnl_listar_distrito() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setSize(new Dimension(217, 296));
        btn_Ver.setText("Ver Distritos");
        btn_Ver.setBounds(new Rectangle(5, 5, 205, 30));
        btn_Ver.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btn_Ver_actionPerformed(e);
                    }
                });
        jScrollPane1.setBounds(new Rectangle(5, 40, 205, 250));
        jScrollPane1.getViewport().add(txtSalida, null);
        this.add(jScrollPane1, null);
        this.add(btn_Ver, null);
    }

    private void btn_Ver_actionPerformed(ActionEvent e) {
        try {
            DistritoDAO d= new DistritoDAO();
            Vector <Distrito> v = d.cargaDistritos();
            txtSalida.setText("Lista de Dsitritos \n");
            for(int i=0; i< v.size();i++){
                txtSalida.append(v.elementAt(i).getCodigo()+"\t");
                txtSalida.append(v.elementAt(i).getNombre()+"\t");
                txtSalida.append(v.elementAt(i).getVendedor()+"\n");
            }
            
        } catch (SQLException f) {
            System.out.println(f.toString());
        }
    }
}

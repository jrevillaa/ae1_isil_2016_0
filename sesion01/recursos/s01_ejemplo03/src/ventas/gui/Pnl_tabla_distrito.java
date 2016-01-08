package ventas.gui;

import ventas.util.QueryTableModel;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Pnl_tabla_distrito extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane jScrollPane1 = new JScrollPane();
    private QueryTableModel qtm = new QueryTableModel();
    private JTable tabla = new JTable();
    private JButton jButton1 = new JButton();
    
    public Pnl_tabla_distrito() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( null );
        jScrollPane1.setBounds(new Rectangle(15, 40, 345, 245));
        jButton1.setText("jButton1");
        jButton1.setBounds(new Rectangle(40, 5, 245, 30));
        jButton1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jButton1_actionPerformed(e);
                    }
                });
        jScrollPane1.getViewport().add(tabla, null);
        this.add(jButton1, null);
        this.add(jScrollPane1, null);
    }

    private void jButton1_actionPerformed(ActionEvent e) {
            tabla.setModel(qtm);
            qtm.setQuery("select * from tb_vendedor");
    }
}

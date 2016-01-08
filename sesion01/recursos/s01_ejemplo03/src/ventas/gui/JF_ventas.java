package ventas.gui;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JF_ventas extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar = new JMenuBar();
    private JMenu menuFile = new JMenu();
    private JMenuItem menuFileExit = new JMenuItem();
    private Pnl_agregar_distritos pnl_tabla_distrito1 = new Pnl_agregar_distritos();
    private JButton jButton1 = new JButton();

    public JF_ventas() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setJMenuBar( menuBar );
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(485, 449));
        this.setTitle( "Facturaci�n CJAVA" );
        menuFile.setText("Archivo");
        menuFileExit.setText("Salir");
        menuFileExit.addActionListener( new ActionListener() { public void actionPerformed( ActionEvent ae ) { fileExit_ActionPerformed( ae ); } } );
        pnl_tabla_distrito1.setBounds(new Rectangle(50, 50, 380, 340));
        jButton1.setText("jButton1");
        jButton1.setBounds(new Rectangle(125, 5, 215, 30));
        jButton1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jButton1_actionPerformed(e);
                    }
                });
        menuFile.add( menuFileExit );
        menuBar.add( menuFile );
        this.getContentPane().add(jButton1, null);
        this.getContentPane().add(pnl_tabla_distrito1, null);
    }

    void fileExit_ActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    private void jButton1_actionPerformed(ActionEvent e) {
           JFConsulta_Distrito v = new JFConsulta_Distrito();
           v.setSize(500,500);
           v.setLocation(100,100);
           v.setVisible(true);
    }
}

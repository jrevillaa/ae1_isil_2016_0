package ventas.gui;

import ventas.util.QueryTableModel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;

public class JFConsulta_Distrito extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BorderLayout layoutMain = new BorderLayout();
    private JPanel panelCenter = new JPanel();
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuFile = new JMenu();
    private JMenuItem menuFileExit = new JMenuItem();
    private JToolBar toolBar = new JToolBar();
    private JButton buttonOpen = new JButton();
    private JButton buttonClose = new JButton();
    private JButton buttonHelp = new JButton();
    private ImageIcon imageOpen = new ImageIcon(JFConsulta_Distrito.class.getResource("openfile.gif"));
    private ImageIcon imageClose = new ImageIcon(JFConsulta_Distrito.class.getResource("closefile.gif"));
    private ImageIcon imageHelp = new ImageIcon(JFConsulta_Distrito.class.getResource("help.gif"));
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JButton btnVer = new JButton();
    private JTable tablaDistrito = new JTable();
    private QueryTableModel qtm = new QueryTableModel();
    

    public JFConsulta_Distrito() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setJMenuBar( menuBar );
        this.getContentPane().setLayout( layoutMain );
        panelCenter.setLayout( null );
        this.setSize( new Dimension(400, 300) );
        this.setTitle( "Consulta con Grilla" );
        menuFile.setText( "File" );
        menuFileExit.setText( "Exit" );
        menuFileExit.addActionListener( new ActionListener() { public void actionPerformed( ActionEvent ae ) { fileExit_ActionPerformed( ae ); } } );
        buttonOpen.setToolTipText( "Open File" );
        buttonOpen.setIcon( imageOpen );
        buttonClose.setToolTipText( "Close File" );
        buttonClose.setIcon( imageClose );
        buttonHelp.setToolTipText( "About" );
        buttonHelp.setIcon( imageHelp );
        jScrollPane1.setBounds(new Rectangle(15, 40, 365, 175));
        btnVer.setText("Ver datos de los distritos");
        btnVer.setBounds(new Rectangle(55, 10, 280, 25));
        btnVer.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnVer_actionPerformed(e);
                    }
                });
        menuFile.add( menuFileExit );
        menuBar.add( menuFile );
        toolBar.add( buttonOpen );
        toolBar.add( buttonClose );
        toolBar.add( buttonHelp );
        this.getContentPane().add( toolBar, BorderLayout.NORTH );
        panelCenter.add(btnVer, null);
        jScrollPane1.getViewport().add(tablaDistrito, null);
        panelCenter.add(jScrollPane1, null);
        this.getContentPane().add(panelCenter, BorderLayout.CENTER);
    }

    void fileExit_ActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    private void btnVer_actionPerformed(ActionEvent e) {
            tablaDistrito.setModel(qtm);
            //qtm.setQuery("select cod_dis as Codigo, nom_dis as nombre from tb_distrito");
            qtm.setQuery("select * from tb_distrito");
    }
}

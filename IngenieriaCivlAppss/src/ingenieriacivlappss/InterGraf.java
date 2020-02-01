
package ingenieriacivlappss;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//DESCRIPCION DE LA CLASE:
//En conjunto con la demas clases que vayamos creando, esta clase se encarga de proporcionar todos los elementos de interfaz grafica que necesite la APP.
//El comportamiento de los objetos de la interfaz y lo todo los audiovisual SI son propios de esta clase.
//El procesamieto de datos NO es propio de esta clase
//Los streams NO son propios de esta clase
//Lo que tenga que ver con bases de datos NO son propios de esta clase
//Sin sistema de usuarios y contraseñas... xel momento

public class InterGraf extends JFrame implements ActionListener {
    //poner OJO en qué componetes se declaran como atributos. Los -- posibles xfa
    private JPanel panel_fondo; //panel que contiene todo
    private JPanel panelContenido_0; //corresponde al norte
    private JScrollPane panelContenido_1; //corresponde al contenido del oeste
    private JScrollPane panelContenido_2; //corresponde al contenido central
    
    public InterGraf() {
    
        inicializarAtbs();
        armarPanelesdContenido();
        
        hacerConfiguraxiones();
        
        this.panel_fondo.setBorder( BorderFactory.createLineBorder( Color.WHITE,15,true ) );
        this.panel_fondo.add( this.panelContenido_0,BorderLayout.NORTH );
        this.panel_fondo.add( this.panelContenido_1,BorderLayout.WEST );
        this.panel_fondo.add( this.panelContenido_2,BorderLayout.CENTER );
        
        this.add( panel_fondo );
            
    } //fin del metodo constructor
       
    public void hacerConfiguraxiones() {
    this.setVisible( true );
        this.setSize( 1000,600 );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setTitle( "BIENVENIDXS A LA APP" );
    }
    
    public void inicializarAtbs() {
        panel_fondo = new JPanel( new BorderLayout() ); //Se inicializa el panelDelFondo
        panelContenido_0 = new JPanel( new GridLayout( 1,5 ) );
        panelContenido_1 = new JScrollPane(); //CONDIGURAR VIWEPORT Y COMPORTAMIENTO
        panelContenido_2 = new JScrollPane(); //CONDIGURAR VIWEPORT Y COMPORTAMIENTO
       
    }//fin del metodo InicializarAtributos

    public void armarPanelesdContenido() {
        //instruccione de armado de: panel cero:
        String nomb_butnNorte[] = {
            "ARCHIVO",
            "PREFERENCIAS",
            "APARIENCIA",
            "INFO_APP",
            "SALIRALV"
        };
        for( int i=0;i<5;i++ )  this.panelContenido_0.add( new JButton( nomb_butnNorte[i] ));
        this.panelContenido_0.setBorder( BorderFactory.createLineBorder( Color.BLACK,5,true) );
        
    
        
        //instrucciones de armado de: panel uno:
        this.panelContenido_1.setViewportBorder( BorderFactory.createLineBorder( Color.RED, 5, true) );
        this.panelContenido_1.setViewportView( new JTextArea( "XDXDXDXXDAREA DE INFORMACION DEL OBJETO:",20,20 )); //HACER VISIBLE EN EL JSCROLLPANE OTRO PANEL NORMAL, CON UN FORMULARIO INTERACTIVO QUE MUESTRE LA INFORMACION DE OBJETO Y BRIDNE HERRAMIENTAS PARA MODIFICARLO
        this.panelContenido_1.createVerticalScrollBar();
        this.panelContenido_1.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        this.panelContenido_1.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        
        
        
        //instrucciones para el armado de: panel dos:
        this.panelContenido_2.setViewportBorder( BorderFactory.createLineBorder( Color.BLUE,5,true ));
        this.panelContenido_2.createVerticalScrollBar();
        this.panelContenido_2.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        
        
        
        
        
    }//fin del metodo ArmarPanelesDeContenido
    
    
    

    public void actionPerformed(ActionEvent e) {
 
        System.out.println( "Se ha desencadenado 1 evento" + e.toString() );
        
    } //fin del metodo AccionRealizada
    
    
    
}//fin del bloque de codigo de CLASE INTERGRAF



















/*COMENTARIOS GENERALES:
-- Intentar hacer lo mas universal posible el codigo de la asistente RITMAH para usarlo en este proyecto
--
--
--
--
*/
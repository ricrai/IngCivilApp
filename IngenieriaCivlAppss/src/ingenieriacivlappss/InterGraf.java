
package ingenieriacivlappss;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

//DESCRIPCION DE LA CLASE:
//En conjunto con la demas clases que vayamos creando, esta clase se encarga de proporcionar todos los elementos de interfaz grafica que necesite la APP.
//El comportamiento de los objetos de la interfaz y lo todo los audiovisual SI son propios de esta clase.
//El procesamieto de datos NO es propio de esta clase
//Los streams NO son propios de esta clase
//Lo que tenga que ver con bases de datos NO son propios de esta clase
//Sin sistema de usuarios y contraseñas... xel momento

public class InterGraf extends JFrame {
    //poner OJO en qué componetes se declaran como atributos. Los -- posibles xfa
    private JPanel panel_fondo; //panel que contiene todo
    private JPanel panelContenido_0; //corresponde al norte
    private JScrollPane panelContenido_1; //corresponde al contenido del oeste
    private JScrollPane panelContenido_2; //corresponde al contenido central
    private JOptionPane emerGente; //Ventana emergente controlada por el asistente
    private aSister sster01; //asistente que se diseño para procesar la informacion, implementa a varios listeners
    private PizarrondTrabajo pdt; //un objeto que se diseño para dibujar y borrar sobre el, extiende a JPanel
    private Font fuenteStd = new Font( "Arial",1,12 ); //primerArg: nombre, segundoArg: stylo, tercerArg: tamanho
    
    
    public InterGraf() {
    
        inicializarAtbs(); 
        armarPanelesdContenido(); //construye los paneles principales
        
        hacerConfiguraxiones(); //establece el tamaño, visible, etc
        
        panel_fondo.setBorder( BorderFactory.createLineBorder( Color.WHITE,15,true ));//BORDE GENERAL
        panel_fondo.add( panelContenido_0,BorderLayout.NORTH );
        panel_fondo.add( panelContenido_1,BorderLayout.WEST );
        panel_fondo.add( panelContenido_2,BorderLayout.CENTER );
        
        add( panel_fondo );
           
        emerGente.showConfirmDialog( this, "indik" );
        
    } //fin del metodo constructor
       
    public void hacerConfiguraxiones() {
        setVisible( true );
        setSize( 1000,600 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setTitle( "BIENVENIDXS A LA APP" );
    }
    
    public void inicializarAtbs() {
        panel_fondo = new JPanel( new BorderLayout() ); //Se inicializa el panelDelFondo
        panelContenido_0 = new JPanel( new GridLayout( 1,5 ) );
        panelContenido_1 = new JScrollPane(); //CONDIGURAR VIWEPORT Y COMPORTAMIENTO
        panelContenido_2 = new JScrollPane(); //CONDIGURAR VIWEPORT Y COMPORTAMIENTO
        pdt = new PizarrondTrabajo();
        sster01 = new aSister();
        emerGente = new JOptionPane( "mensaje1", 1,JOptionPane.ERROR_MESSAGE );
       
    }//fin del metodo InicializarAtributos

    public void armarPanelesdContenido() {
    
//1-----------------------------------------------------------------------------------------------------------------------        
    //instruccione de armado de: panel cero:
        String nomb_butnNorte[] = {
            "ARCHIVO",
            "PREFERENCIAS",
            "APARIENCIA",
            "INFO_APP",
            "SALIRALV"
        };
        for( int i=0;i<5;i++ ) panelContenido_0.add( new JButton( nomb_butnNorte[i] ));
        panelContenido_0.setBorder( hacerElBorde( "Barra de menu opciones generales",1 ) );
        
        
        
    
//2-----------------------------------------------------------------------------------------------------------------------                
        //instrucciones de armado de: panel uno:
        Box bx00 = Box.createHorizontalBox();
        JTextField in_tamanhoLado = new JTextField( "200xDefault" );
        JButton btn_ModificarLado = new JButton( ">>_GO_<<" );
        btn_ModificarLado.addActionListener( pdt );
        JLabel arrayJL[] = new JLabel[250];
        JPanel panelInfoFigura = new JPanel();
        panelInfoFigura.setLayout( new GridLayout( 250,1 ) );
        bx00.add( new JLabel("Lado en pixeles: ") );
        bx00.add( Box.createHorizontalStrut( 5 ) );
        bx00.add( in_tamanhoLado );
        bx00.add( Box.createHorizontalStrut( 30 ) );
        bx00.add( btn_ModificarLado );
        panelInfoFigura.add( new JLabel( "CARAKTERISTICAS PRINCIPALES DELA FIGURA SELECCIONADA" ));
        panelInfoFigura.add( new JLabel() );
        panelInfoFigura.add( bx00 );
        for( int i=0;i<200;i++ ) {
            if(i<3) panelInfoFigura.add( new JLabel() ); //condicional para que dibuje espacio en blanco
            else {
                arrayJL[i] = new JLabel( "etiqketa numero: " + i );
                panelInfoFigura.add( arrayJL[i] );
            }//fin del bloqueElse
        }//findelFOR
        panelContenido_1.setViewportView( panelInfoFigura );
        panelContenido_1.setBorder( hacerElBorde( "Kracteristicas del objeto selccionado", 2 ));
        panelContenido_1.createVerticalScrollBar();
        panelContenido_1.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        panelContenido_1.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
 
        
        
        
        
//3-----------------------------------------------------------------------------------------------------------------------        
//instrucciones para el armado de: panel dos:
       panelContenido_2.setViewportView( pdt );
       panelContenido_2.setBorder( hacerElBorde( "Lienzo para dibujar",3 ));
       panelContenido_2.createVerticalScrollBar();
       panelContenido_2.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
       panelContenido_2.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
            
        
        
        
    }//fin del metodo ArmarPanelesDeContenido
    

    public Border hacerElBorde( String s, int i ) {
        Border bordeGral;
        
        switch( i ) {
            case 1: bordeGral = BorderFactory.createCompoundBorder( BorderFactory.createTitledBorder( BorderFactory.createMatteBorder( 4,4,10,4,Color.BLACK ),s,3,TitledBorder.TOP,fuenteStd,Color.BLACK ), BorderFactory.createEtchedBorder( 1 ));
                break;
            case 2: bordeGral = BorderFactory.createCompoundBorder( BorderFactory.createTitledBorder( BorderFactory.createMatteBorder( 10,4,4,10,Color.RED ),s,1,TitledBorder.BOTTOM,fuenteStd,Color.RED ), BorderFactory.createEtchedBorder( 1 ));
                break;
            case 3: bordeGral = BorderFactory.createCompoundBorder( BorderFactory.createTitledBorder( BorderFactory.createMatteBorder( 10,10,4,4,Color.BLUE ),s,3,TitledBorder.BOTTOM,fuenteStd,Color.BLUE ), BorderFactory.createEtchedBorder( 1 ));
                break;
            default: bordeGral = BorderFactory.createEtchedBorder( 2 );
                break;
        }//fin del condicionalSwitch
        
        return bordeGral;
    } //fin del metodo para construir los bordes especiales
    
}//fin del bloque de codigo de CLASE INTERGRAF



















/*COMENTARIOS GENERALES:
-- Intentar hacer lo mas universal posible el codigo de la asistente RITMAH para usarlo en este proyecto
-- Se procurará agregar a cada componente una descripcion que muestre al usuario su funcionamiento en forma de etiquetaEmergente
--
--
--
*/
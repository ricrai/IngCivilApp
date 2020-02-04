
package ingenieriacivlappss;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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

public class InterGraf extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
    //poner OJO en qué componetes se declaran como atributos. Los -- posibles xfa
    private JPanel panel_fondo; //panel que contiene todo
    private JPanel panelContenido_0; //corresponde al norte
    private JScrollPane panelContenido_1; //corresponde al contenido del oeste
    private JScrollPane panelContenido_2; //corresponde al contenido central
    private JOptionPane emerGente; //Ventana emergente controlada por el asistente
    private PizarrondTrabajo pdt; //un objeto que se diseño para dibujar y borrar sobre el, extiende a JPanel
    private Font fuenteStd = new Font( "Arial",1,12 ); //primerArg: nombre, segundoArg: stylo, tercerArg: tamanho
    
    
    public InterGraf() {
    
        inicializarAtbs(); //inicializa atributos
        armarPanelesdContenido(); //construye los paneles principales
        
        hacerConfiguraxiones(); //establece el tamaño, visible, etc
        
        panel_fondo.setBorder( BorderFactory.createLineBorder( Color.WHITE,15,true )); //BORDE GENERAL un espacio en blanco
        panel_fondo.add( panelContenido_0,BorderLayout.NORTH ); //Se agrega el panel00 al NORTE
        panel_fondo.add( panelContenido_1,BorderLayout.WEST ); //Se agrega el panel01 al OESTE
        panel_fondo.add( panelContenido_2,BorderLayout.CENTER ); //Se agrega el panel02 al CENTRO
        add( panel_fondo ); // Se agrega el panel del fondo al frameGRAL
        emerGente.showConfirmDialog( this, "indik o sativa" ); // Lanza una ventana emergente generik con texto incluido
        
    } //fin del metodo constructor
       
    public void hacerConfiguraxiones() {
        setVisible( true ); //Se recomienda esta insatruccion x buenas practiks
        setSize( 1000,600 ); //Se establece el tamaño, con la posibilidad de que el usuairo cambia sus dimensiones
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); //Establece el comportamiento c
        setTitle( "BIENVENIDXS A LA APP" ); //Establce el titulo del frameGRAL
    } //fin del metodo
        
    public void inicializarAtbs() {
        panel_fondo = new JPanel( new BorderLayout() ); //Se inicializa el panelDelFondo
        panelContenido_0 = new JPanel( new GridLayout( 1,5 ) ); //tabla de 5x1 con todos los elementos del mismo tamaño, cambiar por un menuBar
        panelContenido_1 = new JScrollPane(); //CONDIGURAR VIWEPORT Y COMPORTAMIENTO
        panelContenido_2 = new JScrollPane(); //CONDIGURAR VIWEPORT Y COMPORTAMIENTO
        pdt = new PizarrondTrabajo(); //Inicializa otro de nuestros objetos, es atributo de esta clase
        emerGente = new JOptionPane( "mensaje1", 1,JOptionPane.ERROR_MESSAGE ); //Inicializa el objeto de tipo optionpane que usamos en el metodoConstructor casi al final del bloquedcod
    }//fin del metodo InicializarAtributos

    public void armarPanelesdContenido() {
    
//1-----------------------------------------------------------------------------------------------------------------------        
    //instruccione de armado de: panel cero:
        String nomb_butnNorte[] = { //Un array de cadenas para los nombres dela barra de menu
            "ARCHIVO",
            "PREFERENCIAS",
            "APARIENCIA",
            "INFO_APP",
            "SALIRALV"
        };
        for( int i=0;i<5;i++ ) panelContenido_0.add( new JButton( nomb_butnNorte[i] )); //cilo que agrega los cinco botones de la barraDeMemi 
        panelContenido_0.setBorder( hacerElBorde( "Barra de menu opciones generales",1 ) ); //se establece el borde del panelNorte, mandando a llamar 1 de nuestro metodos
        
        
        
    
//2-----------------------------------------------------------------------------------------------------------------------                
        //instrucciones de armado de: panel uno:
        Box bx00 = Box.createHorizontalBox(); //se hace una caja para almacenar los componentes de una "linea de objetos/componentes"
        JTextField in_tamanhoLado = new JTextField( "200xDefault" ); // inicializa Primer elemento de la "linea de objetos"
        JButton btn_ModificarLado = new JButton( ">>_GO_<<" );  //inicializa Segundo elemento e la "linea de objetos"
        btn_ModificarLado.addActionListener( pdt ); //agrega listenber a Tercer elementos de la "linea de objetos"
        JLabel arrayJL[] = new JLabel[250]; // Se declaran 150 etiquetas para hacer espacio...
        JPanel panelInfoFigura = new JPanel( new GridLayout( 250,1 ) ); //Un panel exclusivo para las etiquetas de arriba 
        bx00.add( new JLabel( "Lado en pixeles: ") );       // Se agregan a la caja box00
        bx00.add( Box.createHorizontalStrut( 5 ) );         // Se agregan a la caja box00
        bx00.add( in_tamanhoLado );                         // Se agregan a la caja box00
        bx00.add( Box.createHorizontalStrut( 30 ) );        // Se agregan a la caja box00
        bx00.add( btn_ModificarLado );                      // Se agregan a la caja box00 los ementos se muestran en el orden que fueron creados
        panelInfoFigura.add( new JLabel( "CARAKTERISTICAS PRINCIPALES DELA FIGURA SELECCIONADA" ));     //Se agrega al panelIzquierdo
        panelInfoFigura.add( new JLabel() );                                                            //Se agrega al panelIzquierdo
        panelInfoFigura.add( bx00 );                                                                    //Se agrega al panelIzquierdo
        for( int i=0;i<200;i++ ) { 
            if(i<5) panelInfoFigura.add( new JLabel() ); //condicional para que dibuje espacio en blanco
            else { //La mayoria de las iteraciones entran aki
                arrayJL[i] = new JLabel( "etiqketa numero: " + i ); //inicializa cada etiqueta y...
                panelInfoFigura.add( arrayJL[i] ); // ..luego se agrega al panel izquierdo
            }//fin del bloqueElse
        }//findelFOR
        panelContenido_1.setViewportView( panelInfoFigura ); //establece el area visible del panelBarra de la izquierda
        panelContenido_1.setBorder( hacerElBorde( "Kracteristicas del objeto selccionado", 2 )); //estblce el borde con nuestro metodo que retorna un BORDE especifico en funcion de los argumentos mandados
        panelContenido_1.createVerticalScrollBar(); //el objeto de tipo scrollpane se crea una barra vertikl
        panelContenido_1.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS ); // estblce politik de barra vertical
        panelContenido_1.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER ); // estblce politik de barra horizontal
 
        
        
        
        
//3-----------------------------------------------------------------------------------------------------------------------        
//instrucciones para el armado de: panel dos:
       panelContenido_2.setViewportView( pdt ); //establece el area visible del panelBarra de la izquierda
       panelContenido_2.setBorder( hacerElBorde( "Lienzo para dibujar",3 )); //estblce el borde del Centro con nuestro metodo que hace bordes bien prrones
       panelContenido_2.createVerticalScrollBar(); //el objeto de tipo scrollpane que se ubica en el centro del BorderLayout se autocrea una barra vertical
       panelContenido_2.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS ); //establce politik de barra vertical
       panelContenido_2.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS ); ///establce politik de barra horizontal
    }//fin del metodo ArmarPanelesDeContenido
    

    public Border hacerElBorde( String s, int i ) { //metodo que se llama para hacer los bordes de las areas del programa que son 3: norte, centro, oeste 
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

    
    
    
    
    
    
    
    
  
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////SE INICIAN LOS METODOS DE VARIAS INTERFACCCCCCCCCCCCCCCCC//////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
  
    }

    @Override
    public void mouseDragged(MouseEvent e) {
  
    }

    @Override
    public void mouseMoved(MouseEvent e) {
  
    }
    
}//fin del bloque de codigo de CLASE INTERGRAF









/*COMENTARIOS GENERALES:
-- Intentar hacer lo mas universal posible el codigo de la asistente RITMAH para usarlo en este proyecto
-- Se procurará agregar a cada componente una descripcion que muestre al usuario su funcionamiento en forma de etiquetaEmergente
--
--
--
*/
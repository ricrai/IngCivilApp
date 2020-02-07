
package ingenieriacivlappss;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.text.ParseException;
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
import javax.swing.Spring;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
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
        private JPanel panelconKard;
        private LineaDeFormulario lineasdeunFormulario[];
        private JPanel panelesBaraja[] = new JPanel[100]; //Limitado el uso de paneles aqui, que implica limitar la cantidad de figuras en el programa
    private JScrollPane panelContenido_2; //corresponde al contenido central
    private JOptionPane emerGente; //Ventana emergente controlada por el asistente
    private PizarrondTrabajo pizDeTrab; //un objeto que se diseño para dibujar y borrar sobre el, extiende a JPanel
    private Font fuenteStd = new Font( "Arial",1,12 ); //primerArg: nombre, segundoArg: stylo, tercerArg: tamanho
    private RectangTipo00 rectTemporal;
    
    public InterGraf() {            //metodo constructor
    
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
        panelconKard = new JPanel( new CardLayout() );
        panelesBaraja[0] = new JPanel();

        panelContenido_2 = new JScrollPane(); //CONDIGURAR VIWEPORT Y COMPORTAMIENTO
        pizDeTrab = new PizarrondTrabajo(); //Inicializa otro de nuestros objetos, es atributo de esta clase
        emerGente = new JOptionPane( "mensaje1", 1,JOptionPane.ERROR_MESSAGE ); //Inicializa el objeto de tipo optionpane que usamos en el metodoConstructor casi al final del bloquedcod
    }//fin del metodo InicializarAtributos

    public void armarPanelesdContenido() {
    
//1-----------------------------------------------------------------------------------------------------------------------        
        if( seConstruyoCorrectoPanel( 1 )) { 
            System.out.println( "Se construyo correctamente +1"  );
        }else{
            System.out.println( "NOSE construyo correctamente" );
        } //fin del else

//2-----------------------------------------------------------------------------------------------------------------------                
         if( seConstruyoCorrectoPanel( 2 )) { 
             System.out.println( "Se construyo correctamente +2" );
         }else{
             System.out.println( "NOSE construyo correctamente" );
         } //fin del else
        
        
//3-----------------------------------------------------------------------------------------------------------------------        
         if( seConstruyoCorrectoPanel( 3 )) { 
             System.out.println( "Se construyo correctamente +3" );
         }else{
             System.out.println( "NOSE construyo correctamente" );
         } //fin del else
        

    }//fin del metodo ArmarPanelesDeContenido
    

    public Border hacerElBorde( String s, int i ) { //metodo que se llama para hacer los bordes de las areas del programa que son 3: norte, centro, oeste 
        Border bordeGral;
        
        switch( i ) {
            case 1: bordeGral = BorderFactory.createCompoundBorder( BorderFactory.createTitledBorder( BorderFactory.createMatteBorder( 1,1,10,1,Color.BLACK ),s,3,TitledBorder.TOP,fuenteStd,Color.BLACK ), BorderFactory.createEtchedBorder( 1 ));
                break;
            case 2: bordeGral = BorderFactory.createCompoundBorder( BorderFactory.createTitledBorder( BorderFactory.createMatteBorder( 10,1,1,10,Color.RED ),s,1,TitledBorder.BOTTOM,fuenteStd,Color.RED ), BorderFactory.createEtchedBorder( 1 ));
                break;
            case 3: bordeGral = BorderFactory.createCompoundBorder( BorderFactory.createTitledBorder( BorderFactory.createMatteBorder( 10,10,1,1,Color.BLUE ),s,3,TitledBorder.BOTTOM,fuenteStd,Color.BLUE ), BorderFactory.createEtchedBorder( 1 ));
                break;
            default: bordeGral = BorderFactory.createEtchedBorder( 2 );
                break;
        }//fin del condicionalSwitch
        
        return bordeGral;
    } //fin del metodo para construir los bordes especiales

    public boolean seConstruyoCorrectoPanel( int ii ) { //El numero que se le pasa por parametro corresponde a una enumeracion informal de los espacios del borderLayout: 1)NORTE 2)OESTE 3)CENTRO
        
        switch( ii ){
            
            case 1:     //instrucciones de armado de: panel cero:
                String nomb_butnNorte[] = { //Un array de cadenas para los nombres dela barra de menu
                    "ARCHIVO",
                    "PREFERENCIAS",
                    "APARIENCIA",
                    "INFO_APP",
                    "SALIRALV"
                };
                for( int i=0;i<5;i++ ) panelContenido_0.add( new JButton( nomb_butnNorte[i] )); //cilo que agrega los cinco botones de la barraDeMemi 
                //---:
                JButton jb = (JButton)(panelContenido_0.getComponent( 3 ));
                jb.addActionListener( new ActionListener() {
                        public void actionPerformed( ActionEvent e ) {
                        System.out.println( "Se ha desencadenado un evento en \n" + e.getActionCommand() + "\nse muestra convertigo a cadena:\n" );
                    } //fin del metodo AxionRealizada
                } ); //fin Clase Interna A, y fin de llamada al metodo addActionListener 
                //---.
                panelContenido_0.setBorder( hacerElBorde( "Barra de menu opciones generales",1 ) ); //se establece el borde del panelNorte, mandando a llamar 1 de nuestro metodos
                return true; //si se logra ejecutar el programa hasta la linea anterior, se puede decir que el panel se construyo correctamente
            
            
            case 2:     //instrucciones de armado de: panel uno:
        
                lineasdeunFormulario = new LineaDeFormulario[7];
                
                panelesBaraja[0] = crearPaneldefig(  lineasdeunFormulario, 1 ); //el parametro entero "1" se refeiere a que es de tipo boxlayout
                //esta linea de arriba se va a usar en serie para crear y agregar varios paneles a una distribucion de cardLayout

                configurarScrolP_Izq(); //metodo que establece alguna configuraciones necesarias del ScrollPane de la izquierda
                return true;
            
            
            case 3:     //instrucciones para el armado de: panel dos:
                panelContenido_2.setViewportView( pizDeTrab ); //establece el area visible del panelBarra de la izquierda
                panelContenido_2.setBorder( hacerElBorde( "Lienzo para dibujar",3 )); //estblce el borde del Centro con nuestro metodo que hace bordes bien prrones
                panelContenido_2.createVerticalScrollBar(); //el objeto de tipo scrollpane que se ubica en el centro del BorderLayout se autocrea una barra vertical
                panelContenido_2.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS ); //establce politik de barra vertical
                panelContenido_2.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS ); ///establce politik de barra horizontal
                return true;
             
                
             default: 
                 System.out.println( "El numero que se envia a este metodo por parametro es incorrecto" ); 
                 return false;
        }//fin del switcch
        
        
    }//fin del metodo que construye cada panel
    
    
    public JPanel crearPaneldefig( LineaDeFormulario lns[], int num_segunFigura ) { //panels que se agregan a la distribucion de CARDLAYOUT 
        int larg = lns.length; //cada elemento del array corresponde a una VARIANTE de la figura
        JPanel p_deRetorno = new JPanel();  //primero se inicializa el panel
        int dts[] = { 100,100,100,100 };
        RectangTipo00 r = new RectangTipo00( dts,Color.BLACK,"" );
                
        switch( num_segunFigura ) { // se ejecuta el codigo segun el tipo de figura que se crea, aunq pensandolo bien para cualquier figura se dibujan una de tras de otra todas la lineas
            case 1: //hacer el panel por boxLayout
                p_deRetorno.setLayout( new BoxLayout( p_deRetorno,1) ); //panel tipo Boclayout Vertical
                
                //CAMBIAR que en este ciclo se usa un numero explicito y NO una variable
                for( int ent=0;ent<7;ent++ ) {
                    lns[ent] = new LineaDeFormulario( r.getNombresDeVariantes()[ ent ],3 ); //reinicializa SIETE objetos de tipo LineaDeFormulario, cuando 
                    lns[ent].getAxionador().addActionListener( this );  //AGREGA EL MISMO LISTENER PARA TODOS LOS BOTONES DE CADA LINEA_DE_FORMULARIO
                }//fin del for
                
                p_deRetorno.add( Box.createVerticalStrut( 40 ) );
                p_deRetorno.add( lns[0].getCajaGral() );
                p_deRetorno.add( Box.createVerticalStrut( 20 ) );
                p_deRetorno.add( lns[1].getCajaGral() );
                p_deRetorno.add( Box.createVerticalStrut( 20 ) );
                p_deRetorno.add( lns[2].getCajaGral() );
                p_deRetorno.add( Box.createVerticalStrut( 20 ) );
                p_deRetorno.add( lns[3].getCajaGral() );
                p_deRetorno.add( Box.createVerticalStrut( 20 ) );
                p_deRetorno.add( lns[4].getCajaGral() );
                p_deRetorno.add( Box.createVerticalStrut( 20 ) );
                p_deRetorno.add( lns[5].getCajaGral() );
                p_deRetorno.add( Box.createVerticalStrut( 20 ) );
                p_deRetorno.add( lns[6].getCajaGral() );
                p_deRetorno.add( Box.createVerticalStrut( 40 ) );

                break;
            
            case 2:
                break;
            
            case 3:
                break;
                
                
                
            default: 
               break; 
        }//fin del swithc
        
        
        
        

        
        return p_deRetorno;
    }//fin del metodo CrearUnaCartaParaPaneldeFiguraenelPizarron
    
    
    
    public float conversionSTaFLOAT( String s, JButton jb ) { //metodo que intenta pasar una cadena de caracteres a un numero flotante, en el camino puede fallar, pero con el manejo de excepciones siempre tenemos un valor float  de retorno
        float parseNumero = 0;
        
        try {
            parseNumero = Float.parseFloat( s );
            jb.setText( "A:" + parseNumero  );
        }
        catch( Exception e ) {
            System.err.println("errrrrrrrrrrrrrrrrrrrrrrrrrrrror, se ingreso algo distinto a un numero");
            jb.setText( "00.00" );
            
        }//fin del bloque
        
        return parseNumero;
    }
    
    
    
    
    public void crearFormularioCompleto( LineaDeFormulario ldFormu[], String nombDeCampo[], JPanel unaKrta ) { //crea unaa formulario enterito para un objeto de rectanguloTipo00
        //este metodo se dedica a reinicilizar los objetos LINEADEFORMULARIO, con valores ak personalizados, y se deberia arrojar un jPanel para nuestro siguiente propósito que es barajear las Cartas
        SpringLayout sprLay = ( SpringLayout )( panelesBaraja[0].getLayout() );
        ldFormu[0] = new LineaDeFormulario( nombDeCampo[0],2 );
        ldFormu[1] = new LineaDeFormulario( nombDeCampo[1],2 );
        ldFormu[2] = new LineaDeFormulario( nombDeCampo[2],3 );
        ldFormu[3] = new LineaDeFormulario( nombDeCampo[3],3 );
        ldFormu[4] = new LineaDeFormulario( nombDeCampo[4],3 );
        ldFormu[5] = new LineaDeFormulario( nombDeCampo[5],3 );
        ldFormu[6] = new LineaDeFormulario( nombDeCampo[6],1 ); //reinicializa cada objeto
        //ya que se inicializaron los 7 lineas, (todaas), se proced a montarlas en el srpinglayout
        
        sprLay.putConstraint( SpringLayout.EAST, panelesBaraja[0], -10, SpringLayout.EAST, ldFormu[2].getCajaGral() );
        sprLay.putConstraint( SpringLayout.NORTH, panelesBaraja[0], -10, SpringLayout.NORTH, ldFormu[2].getCajaGral() );

    }//fin del metodo crearFormularioCompleto deun rectanguloTipo00
    
    
    public void configurarScrolP_Izq() { //metodo que establece alguna configuraciones necesarias del ScrollPane de la izquierda
        panelContenido_1.setViewportView( panelesBaraja[0] ); //establece el area visible del panelBarra de la izquierda
        panelContenido_1.setBorder( hacerElBorde( "Kracteristicas del objeto selccionado", 2 )); //estblce el borde con nuestro metodo que retorna un BORDE especifico en funcion de los argumentos mandados
        panelContenido_1.createVerticalScrollBar(); //el objeto de tipo scrollpane se crea una barra vertikl
        panelContenido_1.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS ); // estblce politik de barra vertical
        panelContenido_1.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER ); // estblce politik de barra horizontal
    } //fin del metodo configurarScrollPaneIzquierdo
    
    
    
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////SE INICIAN LOS METODOS DE VARIAS INTERFACCCCCCCCCCCCCCCCC//////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object o = (Object)e.getSource();
        
        Object p = (Object)this.lineasdeunFormulario[0].getAxionador();
        Object q = (Object)this.lineasdeunFormulario[1].getAxionador();
        Object r = (Object)this.lineasdeunFormulario[2].getAxionador();
        Object s = (Object)this.lineasdeunFormulario[3].getAxionador();
        Object t = (Object)this.lineasdeunFormulario[4].getAxionador();
        Object u = (Object)this.lineasdeunFormulario[5].getAxionador();
        Object v = (Object)this.lineasdeunFormulario[6].getAxionador();
        Float f1 = this.conversionSTaFLOAT(  lineasdeunFormulario[1].getCampoSolicitador().getText(),lineasdeunFormulario[1].getAxionador() );//String, JButton
        Float f2 = this.conversionSTaFLOAT(  lineasdeunFormulario[2].getCampoSolicitador().getText(),lineasdeunFormulario[2].getAxionador() );
        Float f3 = this.conversionSTaFLOAT(  lineasdeunFormulario[3].getCampoSolicitador().getText(),lineasdeunFormulario[3].getAxionador() );
        Float f4 = this.conversionSTaFLOAT(  lineasdeunFormulario[4].getCampoSolicitador().getText(),lineasdeunFormulario[4].getAxionador() );

        pizDeTrab.getRectInici()[0].setEquis( f1.intValue()  );
        pizDeTrab.getRectInici()[0].setLle( f2.intValue() );
        pizDeTrab.getRectInici()[0].setAncho( f3.intValue() );
        pizDeTrab.getRectInici()[0].setAlto( f4.intValue() );
        pizDeTrab.dibujarRectangu( pizDeTrab.getRectInici()[0] ,pizDeTrab.getGraphics() );
        pizDeTrab.repaint();
        
    }//FIN DEL METODO ACTION LISTENER
    
    
    
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
-- Se procurará agregar a cada componente una descripcion que muestre al usuario su funcionamiento en forma de etiquetaEmergente
--
--
--
*/
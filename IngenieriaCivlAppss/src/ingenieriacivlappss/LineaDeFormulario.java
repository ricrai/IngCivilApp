
package ingenieriacivlappss;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//Clase que extiende a BOX, es siempre horizontal, y es el molde para hacer un formulario donde se muestre y/o soliciten datos
public class LineaDeFormulario {
    private Box cajaGral; //YA se ha intentado que esta clase herede de BOX, pero se complicó, por lo tanto la BOX simplemente sera un atributo de esta linea
    private JButton axionador; //el boton mostrará el estado del ultimo valor actualizado, y con ese mismo valor debe estar sincronizada la imagen del lienzo
    private JTextField campoSolicitador; //Campo cuyo contenido se debe revisar cada que se accione el boton de esta misma linea, con el fin de extraer su valor y reDibujar la figura en cuestion
    private JLabel etiquetador; //Una etiqueta que le dice al usuario qué ingresar en el campo JTextField del mismo objeto
    private String nombreDeLinea; //este nombre se mostrara tal cual en el texto de la etiqueta, y una parte de este nombre en el boton,
    private int typoDeLinea; // Atributo que representa y almacena el tipoDeLinea de cada objeto de esta clase. Corresponde a una enumeracion informal donde: 0[Un renglon vacio], 1[Linea simple que solamente contiene texto], 2[Linea que contiene 3 cosas, un JLabel, un TextField y una boton], 3[Linea que contiene 4 cosas, una checkBox, un Label, un textField y un boton], 
    private JComboBox opcionesDeSelec; //Objeto que mostrara las ultimas configuraciones de algun dato que redimensione la figuraGemetrica, en orden cronologico (ultimoArriba-primeroAbajo)
    private Font fuenteStd;
    
    
    public LineaDeFormulario() { //constructor xdefault inicializa valores xDefault
        cajaGral = Box.createHorizontalBox(); //inicializa su atributo mas importante, la cajaGral
        axionador = new JButton( "<<Presione" ); //inicializa y da nombre xDefecto al boton 
        campoSolicitador = new JTextField( "", 10 ); //inicializa y da pone testo en el campo de texto
            campoSolicitador.setHorizontalAlignment( SwingConstants.CENTER );
        etiquetador = new JLabel( "kMPOnuevo9cito" ); //inicializa una etiqueta con el texto xDefecto
        nombreDeLinea = "nuevoNombreGenerico"; //da valores a las varibles atributos
        opcionesDeSelec = new JComboBox(); //iniciliza una combo box, x si se ocupa
        typoDeLinea = 1; //se asigna valor al TIPO de linea q es
        fuenteStd = new Font( "Monospace",3,25 ); 
            axionador.setFont( fuenteStd );
            campoSolicitador.setFont( fuenteStd );
            etiquetador.setFont( fuenteStd );
            opcionesDeSelec.setFont( fuenteStd );
        agregarDefaults(); //
        System.out.println( "Se ha construido perfectamente el objeto de tipo LineadFormulario, que xAora tiene +1 atributos" );
    } //fin del bloque de codigo del constructor xdefecto

    
    public LineaDeFormulario( String nomb, int typo ) { //constructor con dos argumentos, inicializa el objeto y todos valores/atributos predeterminados, y luego en funcion del entero que se pasa por parametro, se crean y se agregan a su cajaHorizontal algunos elementos
        nombreDeLinea = nomb;
        typoDeLinea = typo;
        axionador = new JButton("<<botonAccion");
            Icon imgIc = new ImageIcon( this.getClass().getResource("kmbioValor22.png") );
            axionador.setIcon( imgIc );
            axionador.setHorizontalTextPosition( SwingConstants.CENTER );
            axionador.setVerticalTextPosition( SwingConstants.BOTTOM );
        cajaGral = Box.createHorizontalBox();
        cajaGral.setBorder( BorderFactory.createLineBorder(  Color.BLACK,2 ) );
        campoSolicitador = new JTextField( "", 6 );
            campoSolicitador.setHorizontalAlignment( SwingConstants.CENTER );
        etiquetador = new JLabel( "" );
        opcionesDeSelec = new JComboBox();
        
        fuenteStd = new Font( "Courier New",1,15 ); 
            axionador.setFont( fuenteStd );
            campoSolicitador.setFont( fuenteStd );
            etiquetador.setFont( fuenteStd );
            opcionesDeSelec.setFont( fuenteStd );
        
        
        
        
        
        
        switch( typo ) {
            case 0: //agrega 1 solo elemento sin texto
                cajaGral.add( etiquetador );
                break;
                
                
            case 1: //agrega 1 solo elemento con texto
                etiquetador.setText( nomb );
                cajaGral.add( etiquetador );
                break;
                
                
            case 2: //agrega 3 elementos
                etiquetador.setText( nomb );
                campoSolicitador.setText( "100" );
                campoSolicitador.setColumns(20);
                axionador.setText( "Inicial: " + 100 );
                cajaGral.add( Box.createHorizontalStrut( 5 ));
                cajaGral.add( etiquetador );
                cajaGral.add( Box.createHorizontalStrut( 10 ));
                cajaGral.add( campoSolicitador );
                cajaGral.add( Box.createHorizontalStrut( 10 ));
                cajaGral.add( axionador );
                cajaGral.add( Box.createHorizontalStrut( 5 ));
                break;
                
                
            case 3: //agrega 4 elementos
                etiquetador.setText( nomb );
                campoSolicitador.setText( "100" );
                axionador.setText( "Inicial: " + 100 );
                cajaGral.add( Box.createHorizontalStrut( 5 ));
                cajaGral.add( opcionesDeSelec );
                cajaGral.add( Box.createHorizontalStrut( 10 ));
                cajaGral.add( etiquetador );
                cajaGral.add( Box.createHorizontalStrut( 10 ));
                cajaGral.add( campoSolicitador );
                cajaGral.add( Box.createHorizontalStrut( 10 ));
                cajaGral.add( axionador );
                cajaGral.add( Box.createHorizontalStrut( 5 ));
                break;
                
            default: System.out.println( "el valor que se paso por parametro no es valido" );    
        }//fin del condicional switch
        
    } //fin del metodo constructor sobrecargado con dos argumentos
    
    
    
    
    
    public static Box hacerEspacioConlinea() {
        LineaDeFormulario ldForm = new LineaDeFormulario( "",0 ); //inicializa una linea de tipo00
        return ldForm.getCajaGral(); //regresa como valor de retorno la caja de la linea arribita creada
    } //fin del metodo para hacer 1 espacio

    

 
    
    public void agregarDefaults() { //agrega 4 elementos ala cajaGraltipoBox, con espacios entreEyos
        cajaGral.add( Box.createHorizontalStrut( 5 ));
        cajaGral.add( opcionesDeSelec );
        cajaGral.add( Box.createHorizontalStrut( 20 ));
        cajaGral.add( etiquetador );
        cajaGral.add( Box.createHorizontalStrut( 20 ));
        cajaGral.add( campoSolicitador );
        cajaGral.add( Box.createHorizontalStrut( 20 ));
        cajaGral.add( axionador );
        cajaGral.add( Box.createHorizontalStrut( 5 ));
    } //fin del metodo que agrega todos y cada uno de los elementos de los atributos
    
    
    
    
    
//metodo getset----------------------------------------------
    public JComboBox getComboOpcs() {
        return opcionesDeSelec;
    }
    public void setComboOpcs( JComboBox jcBox ) {
        opcionesDeSelec = jcBox;
    }
    
    
    
    public Box getCajaGral() {
        return this.cajaGral;
    }
    public void setCajaGral( Box bxCaja ){
        //el metodo establecer caja Gral no deberia ser usado, no deberia ni existir
    }
    
    
    public JButton getAxionador() {
        return this.axionador;
    }
    public void setAxionador( JButton jb ) {
        this.axionador = jb;
    }
    
    
    public JTextField getCampoSolicitador(){
        return this.campoSolicitador;
    }
    public void setCampoSolicitador( JTextField jtf ) {
        this.campoSolicitador = jtf;
    }
    
    
    public JLabel getEtiquetador() {
        return this.etiquetador;
    }
    public void setEtiquetador( JLabel jl ) {
        this.etiquetador = jl;
    }
    
    
    public String getNombreDeLinea() {
        return this.nombreDeLinea;
    }
    public void setNombreDeLinea( String s ) {
        this.nombreDeLinea = s;
    }
    
    
    public int getTypoDeLinea(){
        return this.typoDeLinea;
    }
    public void setTypoDeLinea( int i ) {
        this.typoDeLinea = i;
    }
    
     
    
}//fin del bloque de codigo de la clase

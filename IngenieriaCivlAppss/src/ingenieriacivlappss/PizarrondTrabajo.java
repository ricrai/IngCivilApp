
package ingenieriacivlappss;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

//DESCRIPCION DE LA CLASE: 
//Esta clase, podria ser considerada parte de la InterGraf(clase), ya que es el lienzo de trabajo del usuario. Donde se dibuja, edita, borra, todas la figuras geométricas que conformen el plano a diseñar.
//Se limita a dibujar solamente 1(RECTANGULOS), 2(CIRCULOS), 3(POLIGONOS_REGULARES), 4(LINEAS_RECTAS)
//las figuras arriba mencionadas con el ancho del borde como variable
//las figuras arriba mencionadas con el color variable
//las figuras arriba mencionadas con su PuntoCritico o punto de ubicacion tambien variable
//las figuras arriba mencionadas con sus dimansiones variables

public class PizarrondTrabajo extends JPanel implements ActionListener, MouseListener, MouseMotionListener{

    
    private Rectangle rect00;
    private Graphics almacenGrap;
            
    public PizarrondTrabajo() {
     
        setVisible( true ); //quiza es innecesaria esta isntruccion
        setBackground( Color.PINK ); //establece el fondo de toda el area de trabajo
        
        
        
        
    }//fin del constructor del Pizarrondtrabajo
    
    
    
    public void cambiarDeLugar( Rectangle rgl, int x, int y ) { 
        getGraphics().clearRect( rgl.x, rgl.x, rgl.width, rgl.height );
        
    }//fin del metodo cambiar de lugar
    
    
    
    public void paintComponent( Graphics g ) {
        almacenGrap = g;
        rect00 = new Rectangle( 50,50,200,200 );
        super.paintComponent( almacenGrap );
        almacenGrap.setColor( Color.ORANGE );
        plasmarRectngRednDft( rect00,almacenGrap ); //idibuja un rectangulo relleno
        

        
    }//fin del metodo pintarComponente, heredado de ?JPanel
    
    
    public void plasmarRectngRednDft( Rectangle r, Graphics g ) { //metodo que recibe por parametros, 1(el rectangulo a dibujar), 2(La interfaz dibujante, en este caso G minuscula)
   
        Random rndm = new Random();
        int cordX = rndm.nextInt( 300 );
        int cordY = rndm.nextInt( 300 );
        int redondo = rndm.nextInt( 100 ) - rndm.nextInt( 50 );
        g.fillRoundRect( cordX,cordY,r.width,r.height,redondo,redondo); // 
        
        
    }//fin delbloque de metodo PLASMAR_RECTANGULO_REDONDEADO-DEFAULT


    
    
    
    
    
    
    
    
    
    
    
//METODOS DE LISTENER-----------------------------------------------------------------------------------
//METODOS DE LISTENER-----------------------------------------------------------------------------------
//METODOS DE LISTENER-----------------------------------------------------------------------------------
    public void actionPerformed( ActionEvent e ) {
        System.out.println( "Se ha descencadenado un evento" + e.toString() );
    
        if( e.getActionCommand()==">>_GO_<<" ) {
            almacenGrap.setColor( Color.PINK );
            almacenGrap.fillRect( rect00.x, rect00.y, rect00.width, rect00.height );
            //getGraphics().clearRect( rect00.x, rect00.y, rect00.width, rect00.height );
        }//fin del condicional
    
    }//findel metodo

    public void mouseClicked(MouseEvent e) {
    
    }//findel metodo

    public void mousePressed(MouseEvent e) {
    
    }//findel metodo


    public void mouseReleased(MouseEvent e) {
        
    }//findel metodo

    public void mouseEntered(MouseEvent e) {
    
    }//findel metodo

    
    public void mouseExited(MouseEvent e) {
    
    }//findel metodo

    
    public void mouseDragged(MouseEvent e) {
    
    }//findel metodo

 
    public void mouseMoved(MouseEvent e) {
   
    }//findel metodo
    
    
}//fin del bloquede codigo de la clase

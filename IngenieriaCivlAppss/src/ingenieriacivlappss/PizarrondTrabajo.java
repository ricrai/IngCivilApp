
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

public class PizarrondTrabajo extends JPanel {

    
    private RectangTipo00 rectCreado;
    
    private RectangTipo00 rectangulosIniciales[] = new RectangTipo00[100];
    
            
    public PizarrondTrabajo() {
     
        setVisible( true ); //quiza es innecesaria esta isntruccion
        setBackground( Color.PINK ); //establece el fondo de toda el area de trabajo
        
        
        for( int j=0;j<100;j++ ) rectangulosIniciales[j] = new RectangTipo00();
        
        
    }//fin del constructor del Pizarrondtrabajo
    
    
    //se supone que ¿
    public void paintComponent( Graphics g ) {
        //aqui incluir el codigo que llame al metodo obtener texto/numero, de cierto componente/objeto perteneciente a la interfaz
        //se requiere que en todo momento esté establecido y mostrando un valor la caja tipo jtextfield 
        //agregar en la construccion de la interfaz grafik un boton que le facilite al usuario "hacer una nueva figura", con todos sus parametros aleatoriamente
        Random rdm = new Random();
        int array[] = { rdm.nextInt(750),rdm.nextInt(600),10,10 };
        rectCreado = new RectangTipo00( array, Color.RED,"el_number1" );
       
        super.paintComponent( g );
        g.setColor( rectCreado.getColorRell() ); //
        dibujarRectangu( rectCreado, g );
        
        for( int j=0;j<rectangulosIniciales.length;j++ ) {
            if( debeSerDib( rectangulosIniciales[j] ) ) {
                g.setColor( rectangulosIniciales[j].getColorRell() );
                dibujarRectangu( rectangulosIniciales[j], g );
            }else{}
        }
        
        
    }//fin del metodo pintarComponente, heredado de ?JPanel

    public boolean debeSerDib( RectangTipo00 r ) {
        
        return true;
    }
    
    
    
    public void dibujarRectangu( RectangTipo00 r, Graphics g ) {
        
        g.fillRoundRect( r.getEquis(), r.getLle(), r.getAncho(), r.getAlto(), 10, 10 );
        
    }//fin del metodo dibujar Rectangulo
    
    
    
    public RectangTipo00[] getRectInici() {
        return this.rectangulosIniciales;
    }

    
  
    
    
    
    
}//fin del bloquede codigo de la clase

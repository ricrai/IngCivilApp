
package ingenieriacivlappss;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;



//Clase que servira como asistente para escuchar a los elementos de la interfaz grafica, tambien busca y guarda en las bases de datos de la aplicacion
//
public class aSister implements ActionListener, MouseListener, MouseMotionListener { //avientame 1 hermana

    public aSister() {
        System.out.println( "Hola, soy una hermana. e he construido" );
    }//findel metodo cnstructor
    
    
    
    
    
    
    
    
    
//METODOS DE LISTENER-----------------------------------------------------------------------------------
//METODOS DE LISTENER-----------------------------------------------------------------------------------
//METODOS DE LISTENER-----------------------------------------------------------------------------------
    public void actionPerformed( ActionEvent e ) {
        System.out.println( "Se ha descencadenado un evento"+e.toString() );
        if( e.getActionCommand()==">>_GO_<<" ) {
            
        }
    
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
    
}//fin del bloque de clase

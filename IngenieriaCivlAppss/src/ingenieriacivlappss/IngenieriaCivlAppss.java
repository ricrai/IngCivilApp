
package ingenieriacivlappss;

import static java.lang.System.out;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//DESCRIPCION DE ESTA CLASE:
//Simplemente, ya que es la unica que contiene el metodo main, corre el programa llamando al constructor del metodo de la INTERFAZ_GRAFIK que contiene los codgios propiamente dichos
//Se pretende que tenga la menor cantidad de codigo posible

public class IngenieriaCivlAppss {

    public static void main(String[] args) {

        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
        
                InterGraf IG = new InterGraf();
                System.out.println("Hola mundo: Un app sensicha de ingeniería civil, para utilidades de desarrollo y planeacion de proyectos de esa especialidad");
                                
            }//fin del metodo RUN
        } ); //fin de clase interna anonima
        
        
        
    }//FIN DEL BLOQUE DEL METODO
    
}//FIN DE BLOQUE DE LA CLASE

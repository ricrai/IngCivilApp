
package ingenieriacivlappss;

import java.awt.Color;


//Clase rectangulo que modela atraves de puros numeros, toda la informacion estatica o dinamica de un rectangulo en la aplicacion

public class RectangTipo00 {
    private int xEquis;
    private int yLle;
    private int wAncho;
    private int hAlto;
    private Color c_fondo;
    private String nombreId;
    private boolean esVisible;
    private final String nombdvariantesFormu[]= { //cantidad de nombresdeVariabledelFormulario determina que tan largo es el mismo
        " Nombre_de_la_figura",
        "        Coordenada_X",
        "        Coordenada_Y",
        "       Pixeles_Ancho",
        "      Pixeles_Altura",
        "       Color_Relleno",
        "    Bool_Visibilidad"
    };
    private final int L = nombdvariantesFormu.length; //uniko atributo que mantiene como publico, contiene un entero que corresponde a cuantas variables itene la figura
    
       
    public RectangTipo00() { //constructor sin argumentos
        xEquis = 0;
        yLle = 0;
        hAlto = 0;
        wAncho = 0;
        c_fondo = Color.black;
        nombreId = "rectanguloGenerik";
        esVisible = false;
        
    }//fin del metodo constructor xDefecto

    public RectangTipo00( int entero[], Color clor, String nomb_id ) { //el array de enteros siempre debe contener CUATRO elementos
        
        xEquis = entero[0];
        yLle = entero[1];
        hAlto = entero[2];
        wAncho = entero[3];
        c_fondo = clor;
        nombreId = nomb_id;
        esVisible = true;
    
    }//fin del constructor TRES argumentos
    
    
    
    
    
    
      
//metodo getset----------------------------------------------
    public int getEquis() {
       return this.xEquis; 
    }
    public void setEquis( int i ) {
        this.xEquis = i;
    }
    
    
    public int getLle() {
        return this.yLle;
    }
    public void setLle( int i ) {
        this.yLle = i;
    }
    
    
    public int getAncho() {
        return this.wAncho;
    }
    public void setAncho( int i ) {
        this.wAncho = i;
    }
    
    
    public int getAlto() {
        return this.hAlto;
    }
    public void setAlto( int i ) {
        this.hAlto = i;
    }

    
    public boolean getEsVisible(){
        return this.esVisible;
    }
    public void setEsVisible( boolean b ) {
        this.esVisible = b;
    }
    
    
    public String getNombreId() {
        return this.nombreId;
    }
    public void setNombreId( String s ) {
        this.nombreId = s;
    }
            
            
    public Color getColorRell () {
        return this.c_fondo;
    }
    public void setColorRell( Color c ) {
        this.c_fondo = c;
    } 
    
    public String[] getNombresDeVariantes() {
        return this.nombdvariantesFormu;
    }
            
            
            
            



}//fin del bloque de toda la clase

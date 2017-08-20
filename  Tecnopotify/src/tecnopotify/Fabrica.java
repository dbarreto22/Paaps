
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pablo
 */
public class Fabrica {

private static Fabrica instancia;
private Fabrica(){};

    public static Fabrica getInstance(){
    if (instancia == null){
        instancia = new Fabrica();
    }
    return instancia;
}
    
public Interfaz getIControlador() {
    Interfaz In = new Controlador();
    return In;
}
    
}
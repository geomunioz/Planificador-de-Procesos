
package pprocesos;

public class PProcesos {

    public static void main(String[] args) {
        Controlador control = new Controlador();
        
        for (int i = 0; i < 2; i++) {
            control.agregarProcesos();
        }
        
        control.imprimirLista();
    }
    
}

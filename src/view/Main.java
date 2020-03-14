
package view;

import java.util.ArrayList;
import java.util.List;
import model.Manejador;
import model.Proceso;

public class Main {

    public static void main(String[] args) {
        Manejador manejador = new Manejador();
        
        /* PRUEBAS FCFS */
        List<Proceso> listaFCFS = new ArrayList();
        listaFCFS.add(new Proceso("A", 0, 2));
        listaFCFS.add(new Proceso("B", 0, 3));
        listaFCFS.add(new Proceso("C", 1, 1));
        listaFCFS.add(new Proceso("D", 3, 4));
        listaFCFS.add(new Proceso("E", 2, 2));
        
        manejador.FCFS(listaFCFS);
        /* PRUEBAS FCFS */

        
    }
    
}

package view;

import java.util.ArrayList;
import java.util.List;
import model.Manejador;
import model.Metodo;
import model.Proceso;

public class Main {

    public static void main(String[] args) {
        Manejador manejador = new Manejador();
        Metodo metodo;

        /* Lista de procesos Cuestionario 1 - Parte 2 - Ejercicio 1*/
        List<Proceso> listaFCFS = new ArrayList();

        listaFCFS.add(new Proceso("P1", 0, 10));
        listaFCFS.add(new Proceso("P2", 0, 1));
        listaFCFS.add(new Proceso("P3", 0, 2));
        listaFCFS.add(new Proceso("P4", 0, 1));
        listaFCFS.add(new Proceso("P5", 0, 5));
        /* Lista de procesos Cuestionario 1 - Parte 2 - Ejercicio 1*/

        /* PRUEBA FCFS */
        metodo = manejador.firstComeFirtServed(listaFCFS);
        System.out.println(metodo);
        /* PRUEBA FCFS */
    }

}

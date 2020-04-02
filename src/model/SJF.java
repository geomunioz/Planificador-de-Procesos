package model;

import interfaces.ISRJ;
import interfaces.RunnableMethod;
import java.util.ArrayList;
import java.util.List;

public class SJF extends Metodo implements RunnableMethod, ISRJ{

    public SJF() {
        super();
        setNombreMetodo("Shortest Job First (SJF)");
    }
    
    public SJF(ArrayList<Proceso> procesos) {
        super(procesos);
        setNombreMetodo("Shortest Job First (SJF)");
    }

    @Override
    public Metodo run(List<Proceso> processList) {
         /* Asignamos la lista de procesos */
        setListaProceso(processList);

        /* Inicializamos la estructura LUE para ponerle los valores de U y el tamaño correcto 
            Colocamos los valores de U (Unidades) */
        initLUE();

        /* Llenamos los valores L (Llegada) de la estructura LUE */
        fillArrivalTimeLUE();

        /* LLenamos E (Ejecución) de la estructura E */
        fillExecutionTime();

        /* Calculamos los totales y promedios */
        calculateResult();

        return this; 
    }
    private void fillExecutionTime() {
        int tamaño = getListaProceso().size();
        int tiempoLlegada[] = new int[tamaño];
        int duracionRafaga[] = new int[tamaño];
        int tiempoFinal[] = new int[tamaño];
        int tiempoArranque[] = new int[tamaño];
        int flag[] = new int[tamaño];
        int tiempoActual = 0, contProcesos = 0;
        //se le asigna el tiempo de llegada y la duracion de rafaga de cada proceso
        for (int i = 0; i < tamaño; i++) {
            tiempoLlegada[i] = getListaProceso().get(i).gettLlegada();
            duracionRafaga[i] = getListaProceso().get(i).getdRafaga();
            flag[i] = 0;
        }
        while (true) {
            int aux = tamaño, min = 99;
            if (contProcesos == tamaño) // comprobamos si ya completamos todos los procesos
            {
                break;
            }

            for (int i = 0; i < tamaño; i++) {
                //comprobamos cual proceso se ejecutara primero 
                if ((tiempoLlegada[i] <= tiempoActual) && (flag[i] == 0) && (duracionRafaga[i] < min)) {
                    min = duracionRafaga[i];
                    aux = i;
                }
            }
            /* checamos si algun proceso llego en el tiempoActual y si no es asi aumentamos la variable*/
            if (aux == tamaño) {
                tiempoActual++;
            } else {
                /*si entra algun proceso entonces calculamos su tiempo final(sumando el tiempoactual y la duracion de la rafaga)
                 y nuestro tiempo actual sera el tiempo de arrenque del proceso,  
                 al final tenemos que modificar el tiempo actual tambien aumentamos nuestro contador de procesos*/
                tiempoArranque[aux] = tiempoActual;
                tiempoFinal[aux] = tiempoActual + duracionRafaga[aux];
                tiempoActual += duracionRafaga[aux];
                flag[aux] = 1;
                contProcesos++;
            }
        }
        for (int i = 0; i < tamaño; i++) {
            String nombre = getListaProceso().get(i).getNombre();
            /*colocamos el tiempo de arranque y el tiempo final de cada proceso*/
            getListaProceso().get(i).settArranque(tiempoArranque[i]);
            getListaProceso().get(i).settFinalizacion(tiempoFinal[i]);

            /* Colocamos el proceso en la estructura LUE en E dentro del rango */
            for (int j = tiempoArranque[i]; j < tiempoFinal[i]; j++) {
                Unit unit = getListaLUE().get((j * 2) + 1);
                unit.setE(nombre);
            }

        }

    }
    
}

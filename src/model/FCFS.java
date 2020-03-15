package model;

import java.util.List;
import interfaces.IFCFS;
import interfaces.RunnableMethod;

public class FCFS extends Metodo implements RunnableMethod, IFCFS {

    public FCFS() {
        super();
        setNombreMetodo("First Come Firsr Served (FCFS)");
    }

    public FCFS(List<Proceso> procesos) {
        super(procesos);
        setNombreMetodo("First Come Firsr Served (FCFS)");
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
        int tArranque = 0;
        int tFinalizacion = 0;

        /* Recorremos la lista de procesos */
        for (Proceso proceso : getListaProceso()) {
            /* Obtenemos el nombre del proceso */
            String nombre = proceso.getNombre();

            /* Calculamos el tiempo de finalización */
            tFinalizacion = tArranque + proceso.getdRafaga();;
            
            /* Colocamos el tiempo de arranque y finalización */
            proceso.settArranque(tArranque);
            proceso.settFinalizacion(tFinalizacion);

            /* Colocamos el proceso en la esructura LUE en E dentro del rango */
            for (int i = tArranque; i < tFinalizacion; i++) {                
                Unit unit = getListaLUE().get((i*2) + 1);
                unit.setE(nombre);
            }

            /* Actualizamos el tiempo de arranque */
            tArranque = tFinalizacion;
        }
    }


}

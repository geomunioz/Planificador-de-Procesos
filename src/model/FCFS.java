package model;

import java.util.List;
import interfaces.IFCFS;
import interfaces.RunnableMethod;

public class FCFS extends Metodo implements RunnableMethod, IFCFS {

    public FCFS() {
        super();
    }

    public FCFS(List<Proceso> procesos) {
        super(procesos);
    }

    @Override
    public Metodo run(List<Proceso> processList) {
        setListaProceso(processList);
        
        /*
            Inicializamos la estructura LUE para ponerle
            los valores de U y el tamaño correcto
        */
        
        initLUE(); 
        
        /*
            Llenamos los valores L de la estructura LUE
        */
        
        fillArrivalTime();
        
        fillExecutionTime();
        
        for(Unit unit : getListaLUE()){
            System.out.println(unit);
        }
        
        
        return this;
    }

    private void fillArrivalTime() {

        for (Proceso proceso : getListaProceso()) {
            int tLlegada = proceso.gettLlegada();

            if (tLlegada >= 0) {
                int position = tLlegada * 2;
                addArrivalTimeToLUE(position, proceso.getNombre());
            } else {
                System.out.println("Error: El timepo de llegada tiene que ser mayor o igual a cero");
            }
        }
    }
    
    private void fillExecutionTime() {
        int tArranque = 0;
        int tFinalizacion = 0;
        
        for (Proceso proceso : getListaProceso()) {
            String nombre = proceso.getNombre();
            
            tFinalizacion = tArranque + proceso.getdRafaga();;
            
            proceso.settArranque(tArranque);
            proceso.settFinalizacion(tFinalizacion);
            
            for(int i = tArranque; i < tFinalizacion; i++){
                Unit unit = getListaLUE().get(i);
                unit.setE(nombre);
            }
            
            tArranque = tFinalizacion;
        }
    }

}

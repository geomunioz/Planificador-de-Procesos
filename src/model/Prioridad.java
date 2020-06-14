package model;

import interfaces.IPrioridad;
import interfaces.RunnableMethod;
import java.util.ArrayList;
import java.util.List;

public class Prioridad extends Metodo implements RunnableMethod, IPrioridad{
    
    
    public Prioridad() {
        super();
        setNombreMetodo("Prioridad");
    }
    
    public Prioridad(List<Proceso> procesos) {
        super(procesos);
        setNombreMetodo("Prioridad");
    }

    @Override
    public Metodo run(List<Proceso> processList) {
        /*Your code here*/
        
        /*Asignamos la lista de procesos*/
        setListaProceso(processList);
        
        /*Se inicializa la estructura LUE*/
        initLUE();
        
        /*LLenado de L */
        fillArrivalTimeLUE();
        
        /*Llenado de E*/
        ejecucionTiempo();
        
        /* Calculamos los totales y promedios */
        calculateResult();
        
        return this;
    }
    
    public void ejecucionTiempo(){
        
        ArrayList<Proceso> copia = new ArrayList();
        
        int posicion=0;
        int i=0;
        boolean band = true;
        
        int posLUE=0;
        
        while(band){
            /*Agrega procesos de acuerdo a su tiempo de llegada*/
            for(Proceso proceso : getListaProceso()){
                
                if(proceso.gettLlegada()== i){
                    copia.add(new Proceso(proceso.getNombre(),proceso.gettLlegada(),proceso.getdRafaga(), proceso.getPrioridad()));
                }
            }
            
            /*Busca la prioridad menor de los procesos listos*/
            int prioridad = copia.get(0).getPrioridad();
            
            for (int j = 0; j < copia.size(); j++) {
                if (prioridad >= copia.get(j).getPrioridad()) {
                    prioridad = copia.get(j).getPrioridad();
                }
            }
            
            int bandera = 0;
            for(int j = 0; j < copia.size(); j++){
                if(copia.get(j).getPrioridad() == prioridad && bandera == 0){
                    posicion = j;
                    bandera = 1;
                }
            }
            
            /* Obtenemos el nombre del proceso */
            String nombre = copia.get(posicion).getNombre();
            
            /*Agregamos a Lue*/
            Unit unit = getListaLUE().get((posLUE*2) + 1);
            un  it.setE(nombre);
            
            
            /*Reducimos valore de duracion de rafaga a proceso ejecutado */
            copia.get(posicion).setdRafaga(copia.get(posicion).getdRafaga() - 1);
            
            
            /*Verificamos que el proceso todavia tenga duracion de rafaga para ejecutar*/
            if(copia.get(posicion).getdRafaga()==0) {
                copia.remove(posicion);
            }
            
            /*incrementamos las variables*/ 
            posLUE++;
            i++;
            
            /*Verificamos que la lista de procesos listos no este vacia para seguir*/
            if(copia.isEmpty()) {
                band = false;
            }
        }
        
        
        /*Calculamos tiempo de llegada y tiempo de finalizacion de los procesos*/
        int timeInicio = 0;
        int timeFin = 0;
        
        for(Proceso proceso : getListaProceso()){
            
            int bd = 0;
            for (int j = 0; j < getListaLUE().size(); j++) {
                
                if (proceso.getNombre().equals(getListaLUE().get(j).getE())) {
                    
                    if (bd == 0) {
                        timeInicio = j;
                        bd = 1;
                    }
                    
                    timeFin = j;
                }
            }
            
            proceso.settArranque(timeInicio/2);
            proceso.settFinalizacion((timeFin/2)+1);
        }
        
    }
    
}

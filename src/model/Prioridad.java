package model;

import interfaces.IPrioridad;
import interfaces.RunnableMethod;
import java.util.List;

public class Prioridad extends Metodo implements RunnableMethod, IPrioridad{

    public Prioridad() {
        super();
    }
    
    public Prioridad(List<Proceso> procesos) {
        super(procesos);
    }

    @Override
    public Metodo run(List<Proceso> processList) {
        /*Your code here*/
        return null;
    }
    
}

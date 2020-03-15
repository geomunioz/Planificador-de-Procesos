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
        /*Your code here*/
        return null;
    }
    
}

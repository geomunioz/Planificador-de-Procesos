package model;

import interfaces.IRR;
import interfaces.RunnableMethod;
import java.util.List;

public class RR extends Metodo implements RunnableMethod, IRR{

    public RR() {
        super();
        setNombreMetodo("Round Robin (RR)");
    }
    
    public RR(List<Proceso> procesos) {
        super(procesos);
        setNombreMetodo("Round Robin (RR)");
    }

    @Override
    public Metodo run(List<Proceso> processList) {
        /*Your code here*/
        return null;
    }
    
}

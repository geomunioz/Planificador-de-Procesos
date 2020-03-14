package model;

import interfaces.IRR;
import interfaces.RunnableMethod;
import java.util.List;

public class RR extends Metodo implements RunnableMethod, IRR{

    public RR() {
        super();
    }
    
    public RR(List<Proceso> procesos) {
        super(procesos);
    }

    @Override
    public Metodo run(List<Proceso> processList) {
        /*Your code here*/
        return null;
    }
    
}

package model;

import interfaces.ISRJ;
import interfaces.RunnableMethod;
import java.util.ArrayList;
import java.util.List;

public class SRJ extends Metodo implements RunnableMethod, ISRJ{

    public SRJ() {
        super();
    }
    
    public SRJ(ArrayList<Proceso> procesos) {
        super(procesos);
    }

    @Override
    public Metodo run(List<Proceso> processList) {
        /*Your code here*/
        return null;
    }
    
}

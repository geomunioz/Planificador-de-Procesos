package model;

import interfaces.ISRT;
import interfaces.RunnableMethod;
import java.util.ArrayList;
import java.util.List;

public class SRT extends Metodo implements RunnableMethod, ISRT{

    public SRT() {
        super();
        setNombreMetodo("SRT");
    }
    
    public SRT(ArrayList<Proceso> procesos) {
        super(procesos); 
        setNombreMetodo("SRT");
    }

    @Override
    public Metodo run(List<Proceso> processList) {
        /*Your code here*/
        return null;
    }
    
}

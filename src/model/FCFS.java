package model;

import java.util.List;
import interfaces.IFCFS;

public class FCFS extends Metodo implements IFCFS{
    
    public FCFS(List<Proceso> procesos) {
        super(procesos);
    }

    @Override
    public void algoritmo(List<Proceso> arg) {
        
    }
}

package model;

import java.util.List;

public class Manejador {

    public Manejador() {
    
    }

    public Metodo FCFS(List<Proceso> processList){
       FCFS mFCFS = new FCFS();
       return mFCFS.run(processList);
    }
    
}

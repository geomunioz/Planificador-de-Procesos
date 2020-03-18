package model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Manejador {

    public Metodo firstComeFirtServed(List<Proceso> processList) {
        /* Ordenamos la lista de procesos por tiempo de llegada */
        Comparator<Proceso> compareById = (Proceso p1, Proceso p2)
                -> ((Integer) p1.gettLlegada()).compareTo(((Integer) p2.gettLlegada()));

        Collections.sort(processList, compareById);
        
        FCFS mFCFS = new FCFS();
        return mFCFS.run(processList);
    }

    public Metodo priority(List<Proceso> processList) {
        /* Ordenamos la lista de procesos por tiempo de llegada */
        Comparator<Proceso> compareById = (Proceso p1, Proceso p2)
                -> ((Integer) p1.gettLlegada()).compareTo(((Integer) p2.gettLlegada()));

        Collections.sort(processList, compareById);
        
        Prioridad mPrioridad = new Prioridad();
        return mPrioridad.run(processList);
    }

    public Metodo roundRobin(List<Proceso> processList) {
        RR mRR = new RR();
        return mRR.run(processList);
    }

    public Metodo shortestJobFirst(List<Proceso> processList) {
        SJF mSJF = new SJF();
        return mSJF.run(processList);
    }

    public Metodo SRT(List<Proceso> processList) {
        SRT mSRT = new SRT();
        return mSRT.run(processList);
    }

}

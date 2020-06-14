package model;

import interfaces.IRR;
import interfaces.RunnableMethod;
import java.util.List;

public class RR extends Metodo implements RunnableMethod, IRR {

    private int quantum;
    private int numberOfProceses;

    public RR(int quantum) {
        super();
        this.quantum = quantum;
        this.numberOfProceses = 0;
        setNombreMetodo("Round Robin (RR)");
    }

    public RR(List<Proceso> procesos, int quantum) {
        super(procesos);
        this.numberOfProceses = 0;
        this.quantum = quantum;
        setNombreMetodo("Round Robin (RR)");
    }

    @Override
    public Metodo run(List<Proceso> processList) {
        /* Asignamos la lista de procesos */
        setListaProceso(processList);
        numberOfProceses = processList.size();

        /* Inicializamos la estructura LUE para ponerle los valores de U y el tamaño correcto 
         Colocamos los valores de U (Unidades) */
        initLUE();

        /* Llenamos los valores L (Llegada) de la estructura LUE */
        fillArrivalTimeLUE();

        /* Hacemos el proceso */
        start();

        /* Calculamos los totales y promedios */
        calculateResult();

        return this;
    }

    private void start() {
        List<Proceso> list = this.getListaProceso();

        int tArranque = 0;

        if (!list.isEmpty()) {
            int index = 0;

            while (index < list.size()) {
                Proceso proceso = list.get(index);

                int rafaga = proceso.getdRafaga();
                String nombre = proceso.getNombre();

                int tFinalizacion = 0;

                if (proceso.getdRafaga() < quantum) {
                    /* Si su rafaga es menor que el quantum; Se ejecuta completo */

                    tFinalizacion = tArranque + rafaga;
                    proceso.settArranque(tArranque);
                    proceso.settFinalizacion(tFinalizacion);
                } else {
                    /* Sino, se ejecuta solo lo del quantum */

                    tFinalizacion = tArranque + quantum;
                    proceso.settArranque(tArranque);
                    proceso.settFinalizacion(tFinalizacion);

                    Proceso p = new Proceso(proceso);
                    p.setdRafaga(rafaga - quantum);

                    list.add(p);
                }

                /* Colocamos el proceso en la esructura LUE en E dentro del rango */
                for (int i = tArranque; i < tFinalizacion; i++) {
                    Unit unit = getListaLUE().get((i * 2) + 1);
                    unit.setE(nombre);
                }

                tArranque = tFinalizacion;
                index++;
            }
        }

    }

    private int gettFinalizacion(Proceso proceso) {
        int tFinalizacion = 0;
        String name = proceso.getNombre();
        List<Proceso> list = getListaProceso();

        for (Proceso p : list) {
            if (name.equals(p.getNombre())) {
                tFinalizacion = p.gettFinalizacion();
            }
        }

        return tFinalizacion;
    }

    @Override
    public void calculateResult() {
        /* Calculamos los datos de cada proceso */
        List<Proceso> list = getListaProceso();

        for (int i = 0; i < numberOfProceses; i++) {
            Proceso proceso = list.get(i);
            int tFinalizacion = this.gettFinalizacion(proceso);

            proceso.settRetorno(tFinalizacion - proceso.gettArranque());
            proceso.settRespuesta(tFinalizacion - proceso.gettLlegada());
            proceso.settDesperdicio(proceso.gettRespuesta() - proceso.getdRafaga());
            proceso.settPenalizacion(proceso.gettRespuesta() / Double.valueOf(proceso.getdRafaga()));
            proceso.settEspera(proceso.gettArranque() - proceso.gettLlegada());

            /* Calculamos los totales */
            this.setTotalRetorno(this.getTotalRetorno() + proceso.gettRetorno());
            this.setTotalRespuesta(this.getTotalRespuesta() + proceso.gettRespuesta());
            this.setTotalDesperdicio(this.getTotalDesperdicio() + proceso.gettDesperdicio());
            this.setTotalPenalizacion(this.getTotalPenalizacion() + proceso.gettPenalizacion());
            this.setTotalEspera(this.getTotalEspera() + proceso.gettEspera());
        }


        /* Obtenemos los promedios */
        this.setPromedioRetorno(this.getTotalRetorno() / numberOfProceses);
        this.setPromedioRespuesta(this.getTotalRespuesta() / numberOfProceses);
        this.setPromedioDesperdicio(this.getTotalDesperdicio() / numberOfProceses);
        this.setPromedioPenalizacion(this.getTotalPenalizacion() / numberOfProceses);
        this.setPromedioEspera(this.getTotalEspera() / numberOfProceses);
    }

}

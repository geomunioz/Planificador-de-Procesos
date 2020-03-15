package model;

import interfaces.ILUE;
import interfaces.IMethodUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Metodo implements IMethodUtils, ILUE {

    private List<Proceso> listaProceso;
    private List<Unit> listaLUE;
    private double totalRetorno;
    private double totalRespuesta;
    private double totalDesperdicio;
    private double totalPenalizacion;
    private double totalEspera;
    private double promedioRetorno;
    private double promedioRespuesta;
    private double promedioDesperdicio;
    private double promedioPenalizacion;
    private double promedioEspera;
    private String nombreMetodo;

    public Metodo() {
        this.listaProceso = new LinkedList();
        this.listaLUE = new ArrayList();
        this.totalRetorno = 0;
        this.totalRespuesta = 0;
        this.totalDesperdicio = 0;
        this.totalPenalizacion = 0;
        this.totalEspera = 0;
        this.promedioRetorno = 0;
        this.promedioRespuesta = 0;
        this.promedioDesperdicio = 0;
        this.promedioPenalizacion = 0;
        this.promedioEspera = 0;
        this.nombreMetodo = "Metodo Sin nombre";
    }

    public Metodo(List<Proceso> procesos) {
        this.listaProceso = procesos;
        this.listaLUE = new ArrayList();
        this.totalRetorno = 0;
        this.totalRespuesta = 0;
        this.totalDesperdicio = 0;
        this.totalPenalizacion = 0;
        this.totalEspera = 0;
        this.promedioRetorno = 0;
        this.promedioRespuesta = 0;
        this.promedioDesperdicio = 0;
        this.promedioPenalizacion = 0;
        this.promedioEspera = 0;
        this.nombreMetodo = "Metodo Sin nombre";
    }

    public List<Unit> getListaLUE() {
        return listaLUE;
    }

    public void setListaLUE(List<Unit> listaLUE) {
        this.listaLUE = listaLUE;
    }

    public List<Proceso> getListaProceso() {
        return listaProceso;
    }

    public void setListaProceso(List<Proceso> listaProceso) {
        this.listaProceso = listaProceso;
    }

    public double getTotalRetorno() {
        return totalRetorno;
    }

    public void setTotalRetorno(double totalRetorno) {
        this.totalRetorno = totalRetorno;
    }

    public double getTotalRespuesta() {
        return totalRespuesta;
    }

    public void setTotalRespuesta(double totalRespuesta) {
        this.totalRespuesta = totalRespuesta;
    }

    public double getTotalDesperdicio() {
        return totalDesperdicio;
    }

    public void setTotalDesperdicio(double totalDesperdicio) {
        this.totalDesperdicio = totalDesperdicio;
    }

    public double getTotalPenalizacion() {
        return totalPenalizacion;
    }

    public void setTotalPenalizacion(double totalPenalizacion) {
        this.totalPenalizacion = totalPenalizacion;
    }

    public double getTotalEspera() {
        return totalEspera;
    }

    public void setTotalEspera(double totalEspera) {
        this.totalEspera = totalEspera;
    }

    public double getPromedioRetorno() {
        return promedioRetorno;
    }

    public void setPromedioRetorno(double promedioRetorno) {
        this.promedioRetorno = promedioRetorno;
    }

    public double getPromedioRespuesta() {
        return promedioRespuesta;
    }

    public void setPromedioRespuesta(double promedioRespuesta) {
        this.promedioRespuesta = promedioRespuesta;
    }

    public double getPromedioDesperdicio() {
        return promedioDesperdicio;
    }

    public void setPromedioDesperdicio(double promedioDesperdicio) {
        this.promedioDesperdicio = promedioDesperdicio;
    }

    public double getPromedioPenalizacion() {
        return promedioPenalizacion;
    }

    public void setPromedioPenalizacion(double promedioPenalizacion) {
        this.promedioPenalizacion = promedioPenalizacion;
    }

    public double getPromedioEspera() {
        return promedioEspera;
    }

    public void setPromedioEspera(double promedioEspera) {
        this.promedioEspera = promedioEspera;
    }

    public String getNombreMetodo() {
        return nombreMetodo;
    }

    public void setNombreMetodo(String nombreMetodo) {
        this.nombreMetodo = nombreMetodo;
    }

    public void imprimirListaProcesos() {
        for (int i = 0; i < listaProceso.size(); i++) {
            System.out.println("->" + listaProceso.get(i).getNombre());
        }
    }
    
    @Override
    public void addArrivalTimeToLUE(int position, String nombre) {
        /* Obtenemos la unidad de la pocision indicada de la estrutura LUE */
        Unit unit = listaLUE.get(position);

        /* Obtenemos los procesos que ya estan en esta unidad  y agregamos el  nuevo */
        String L = unit.getL();
        L += " " + nombre;
        
        unit.setL(L);
    }

    @Override
    public void initLUE() {
        /* Obtenemos el tamaño máximo de la estrutura LUE */
        int size = getLUEsize();
        int position = 0;
        
        /* Hacemos un ciclo para crear la cantidad necesaria de unidades (cuadritos) */
        for (int i = 0; i <= size; i++) {
            /* Creamos una nueva unidad (Cuadrito) */
            Unit unit = new Unit();

            /* Si la pocision es para, colocamos el numero de unidad (Para dejar un espacio entre cuadritos) */
            if (i % 2 == 0) {
                unit.setU(String.valueOf(position));
                position++;
            }

            /* Lo agregamos a la estructura */
            listaLUE.add(unit);
        }
    }

    @Override
    public int getLUEsize() {
        int size = 0;

        /* Recorrmos la lista de procesos y le vamos sumando la
            rafaga de cada proceso al tamaño para obtener el tamaño total*/
        
        for (Proceso proceso : this.listaProceso) 
            size += proceso.getdRafaga();
        
        return size*2;
    }

    @Override
    public void fillArrivalTimeLUE() {

        /* Recorremos la lista de procesos */
        for (Proceso proceso : getListaProceso()) {
            /* Obtenemos el tiempo de llegada del proceso */
            int tLlegada = proceso.gettLlegada();

            /* Validamos que sea un tiempo valido */
            if (tLlegada >= 0) {
                /* Obtenemos el numero de pocisión (cuadrito) para agregar el proceso */
                int position = tLlegada * 2;
                /* Agregamos el proceso en su tiempo dellegada dentro de la estructura LUE */
                addArrivalTimeToLUE(position, proceso.getNombre());
            } else {
                System.out.println("Error: El timepo de llegada tiene que ser mayor o igual a cero");
            }
        }
    }

    @Override
    public void calculateResult() {
        /* Calculamos los datos de cada proceso */
        for (Proceso proceso : getListaProceso()) {
            proceso.settRetorno(proceso.gettFinalizacion() - proceso.gettArranque());
            proceso.settRespuesta(proceso.gettFinalizacion() - proceso.gettLlegada());
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
        int processSize = getListaProceso().size();
        this.setPromedioRetorno(this.getTotalRetorno() / processSize);
        this.setPromedioRespuesta(this.getTotalRespuesta() / processSize);
        this.setPromedioDesperdicio(this.getTotalDesperdicio() / processSize);
        this.setPromedioPenalizacion(this.getTotalPenalizacion() / processSize);
        this.setPromedioEspera(this.getTotalEspera() / processSize);
    }

    @Override
    public String toString() {

        String s = nombreMetodo + " {";

        s += "\t\nProcesos {";
        for (Proceso proceso : listaProceso) {
            s += "\t\t\n" + proceso.toString();
        }
        s += "\n\t}";

        s += "\t\nLUE {";
        for (Unit unit : getListaLUE()) {
            s += "\t\t\n" + unit.toString();
        }
        s += "\n\t}";

        s += "\t\nTotales {";
        s += "\t\t\nTotal Retorno: " + totalRetorno;
        s += "\t\t\nTotal Respuesta: " + totalRespuesta;
        s += "\t\t\nTotal Desperdicio: " + totalDesperdicio;
        s += "\t\t\nTotal Penalización: " + totalPenalizacion;
        s += "\t\t\nTotal Espera: " + totalEspera;
        s += "\n\t}";

        s += "\t\nPromedios {";
        s += "\t\t\nPromedio Retorno: " + promedioRetorno;
        s += "\t\t\nPromedio Respuesta: " + promedioRespuesta;
        s += "\t\t\nPromedio Desperdicio: " + promedioDesperdicio;
        s += "\t\t\nPromedio Penalización: " + promedioPenalizacion;
        s += "\t\t\nPromedio Espera: " + promedioEspera;
        s += "\n\t}";

        s += "\n}";
        return s;
    }

}

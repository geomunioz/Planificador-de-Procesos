
package pprocesos;

import java.util.LinkedList;
import java.util.List;


public class Metodo {
    private List<Proceso> listaProceso;
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
    
    public Metodo(){
        listaProceso = new LinkedList();
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
    }
    
    public Metodo(List<Proceso> procesos){
        this.listaProceso = procesos;
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
    
    
}

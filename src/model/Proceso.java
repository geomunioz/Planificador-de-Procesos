package model;


public class Proceso {
    private String nombre;
    private int prioridad;
    private int tLlegada;
    private int dRafaga;
    private int tArranque;
    private int tFinalizacion;
    private int tRetorno;
    private int tRespuesta;
    private int tDesperdicio;
    private double tPenalizacion;
    private int tEspera;
    
    
    public Proceso(){
        this.nombre = " ";
        this.prioridad = 0;
        this.tLlegada = 0;
        this.dRafaga = 0;
        this.tArranque = 0;
        this.tFinalizacion = 0;
        this.tRetorno = 0;
        this.tRespuesta = 0;
        this.tDesperdicio = 0;
        this.tPenalizacion = 0;
        this.tEspera = 0;
        
    }
    
    public Proceso(Proceso proceso){
        this.nombre = proceso.nombre;
        this.dRafaga = proceso.dRafaga;
        this.tLlegada = proceso.tLlegada;
        this.prioridad = proceso.prioridad;
        this.tArranque = proceso.tArranque;
        this.tFinalizacion = proceso.tFinalizacion;
        this.tRetorno = proceso.tRetorno;
        this.tRespuesta = proceso.tRespuesta;
        this.tDesperdicio = proceso.tDesperdicio;
        this.tPenalizacion = proceso.tPenalizacion;
        this.tEspera = proceso.tEspera;
    }
    
    public Proceso(String nombre, int llegada, int duracion){
        this.nombre = nombre;
        this.dRafaga = duracion;
        this.tLlegada = llegada;
        this.prioridad = 0;
        this.tArranque = 0;
        this.tFinalizacion = 0;
        this.tRetorno = 0;
        this.tRespuesta = 0;
        this.tDesperdicio = 0;
        this.tPenalizacion = 0;
        this.tEspera = 0;
        
    }
    
    public Proceso(String nombre, int llegada,int duracion, int prioridad){
        this.nombre = nombre;
        this.dRafaga = duracion;
        this.prioridad = prioridad;
        this.tLlegada = llegada;
        this.tArranque = 0;
        this.tFinalizacion = 0;
        this.tRetorno = 0;
        this.tRespuesta = 0;
        this.tDesperdicio = 0;
        this.tPenalizacion = 0;
        this.tEspera = 0;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int gettLlegada() {
        return tLlegada;
    }

    public void settLlegada(int tLlegada) {
        this.tLlegada = tLlegada;
    }

    public int getdRafaga() {
        return dRafaga;
    }

    public void setdRafaga(int dRafaga) {
        this.dRafaga = dRafaga;
    }

    public int gettArranque() {
        return tArranque;
    }

    public void settArranque(int tArranque) {
        this.tArranque = tArranque;
    }

    public int gettFinalizacion() {
        return tFinalizacion;
    }

    public void settFinalizacion(int tFinalizacion) {
        this.tFinalizacion = tFinalizacion;
    }

    public int gettRetorno() {
        return tRetorno;
    }

    public void settRetorno(int tRetorno) {
        this.tRetorno = tRetorno;
    }

    public int gettRespuesta() {
        return tRespuesta;
    }

    public void settRespuesta(int tRespuesta) {
        this.tRespuesta = tRespuesta;
    }

    public int gettDesperdicio() {
        return tDesperdicio;
    }

    public void settDesperdicio(int tDesperdicio) {
        this.tDesperdicio = tDesperdicio;
    }

    public double gettPenalizacion() {
        return tPenalizacion;
    }

    public void settPenalizacion(double tPenalizacion) {
        this.tPenalizacion = tPenalizacion;
    }

    public int gettEspera() {
        return tEspera;
    }

    public void settEspera(int tEspera) {
        this.tEspera = tEspera;
    }
    
    
    @Override
    public String toString() {
        
        return "Proceso {"
                + "\t\nNombre: " + nombre
                + "\t\nPrioridad: " + prioridad
                + "\t\nTiempo de Llegada: " + tLlegada
                + "\t\nDuración de Ráfaga: " + dRafaga
                + "\t\nTiempo de Arranque: " + tArranque
                + "\t\nTiempo de Finalización: " + tFinalizacion
                + "\t\nTiempo de Retorno: " + tRetorno
                + "\t\nTiempo de Respuesta: " + tRespuesta
                + "\t\nTasa de desperdicio: " + tDesperdicio
                + "\t\nTasa de penalización: " + tPenalizacion
                + "\t\nTiempo de espera: " + tEspera
                + "\n}";
    }
    
    
    
}

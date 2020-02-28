
package pprocesos;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Controlador {
    Scanner teclado = new Scanner(System.in);
    
    private Proceso proceso;
    private List<Proceso> listap = new LinkedList();
    private FCFS mfcfs;
    private Prioridad mprioridad;
    private RR mrr;
    private SRJ msrj;
    private SRT msrt;

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    public List<Proceso> getListap() {
        return listap;
    }

    public void setListap(List<Proceso> listap) {
        this.listap = listap;
    }

    public FCFS getMfcfs() {
        return mfcfs;
    }

    public void setMfcfs(FCFS mfcfs) {
        this.mfcfs = mfcfs;
    }

    public Prioridad getMprioridad() {
        return mprioridad;
    }

    public void setMprioridad(Prioridad mprioridad) {
        this.mprioridad = mprioridad;
    }

    public RR getMrr() {
        return mrr;
    }

    public void setMrr(RR mrr) {
        this.mrr = mrr;
    }

    public SRJ getMsrj() {
        return msrj;
    }

    public void setMsrj(SRJ msrj) {
        this.msrj = msrj;
    }

    public SRT getMsrt() {
        return msrt;
    }

    public void setMsrt(SRT msrt) {
        this.msrt = msrt;
        
        
    }
    
    public void agregarProcesos(){
        proceso = new Proceso();
        System.out.println("Agregar Procesos");
        System.out.println("Ingrese nombre: ");
        proceso.setNombre(teclado.nextLine());
        teclado.nextLine();
        System.out.println("Tiempo de llegada: ");
        proceso.setLlegada(teclado.nextInt());
        System.out.println("Duracion de rafaga: ");
        proceso.setdRafaga(teclado.nextInt());
        listap.add(proceso);
    }
    
    public void imprimirLista(){
        for (int i = 0; i < listap.size(); i++) {
            System.out.println("->"+listap.get(i).getNombre());
        }
        /*for (String listap.getProceso().getNombre() : listap)
        System.out.print(elemento + "-");
        System.out.println();*/
    }
    
    
}

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
    
    public String resultado(){
        StringBuilder str = new StringBuilder();
        
        str.append(
            "PROCESO" + this.addingSpace(2) + 
            "TIEMPO LLEGADA" + this.addingSpace(2) + //25
            "DURACION RAFAGA" + this.addingSpace(2) + //42
            "TIEMPO ARRANQUE" + this.addingSpace(2) +//59
            "TIEMPO FINALIZACION" + this.addingSpace(2) +//80
            "TIEMPO RETORNO"+ this.addingSpace(2) +
            "TIEMPO RESPUESTA"+ this.addingSpace(2) +
            "TASA DESPERDICIO" + this.addingSpace(2) +
            "TASA PENALIZACION" + this.addingSpace(2) +
            "TIEMPO ESPERA\n"
        );
        
        for (Proceso listaProceso1 : listaProceso) {
            str.append(
                            listaProceso1.getNombre() + this.addingSpace(9 - listaProceso1.getNombre().length()) + 
                            Integer.toString(listaProceso1.gettLlegada()) + this.addingSpace(16 - Integer.toString(listaProceso1.gettLlegada()).length()) +
                            Integer.toString(listaProceso1.getdRafaga()) + this.addingSpace(17 - Integer.toString(listaProceso1.getdRafaga()).length()) +
                            Integer.toString(listaProceso1.gettArranque()) + this.addingSpace(17 - Integer.toString(listaProceso1.gettArranque()).length()) +
                            Integer.toString(listaProceso1.gettFinalizacion()) + this.addingSpace(21 - Integer.toString(listaProceso1.gettFinalizacion()).length()) +
                            Integer.toString(listaProceso1.gettRetorno()) + this.addingSpace(16 - Integer.toString(listaProceso1.gettRetorno()).length()) +
                            Integer.toString(listaProceso1.gettRespuesta()) + this.addingSpace(18 - Integer.toString(listaProceso1.gettRespuesta()).length()) +
                            Integer.toString(listaProceso1.gettDesperdicio()) + this.addingSpace(18 - Integer.toString(listaProceso1.gettDesperdicio()).length()) +
                            Double.toString(listaProceso1.gettPenalizacion()) + this.addingSpace(19 - Double.toString(listaProceso1.gettPenalizacion()).length()) +
                            Double.toString(listaProceso1.gettEspera()) + this.addingSpace(13 - Double.toString(listaProceso1.gettEspera()).length()) +
            "\n");
            
        }
        
        str.append(
                "TIEMPO TOTAL"+ this.addingSpace(68)+
                Double.toString(totalRetorno)+ this.addingSpace(16 - Double.toString(totalRetorno).length()) +
                Double.toString(totalRespuesta)+ this.addingSpace(18 - Double.toString(totalRespuesta).length()) +
                Double.toString(totalDesperdicio)+ this.addingSpace(18 - Double.toString(totalDesperdicio).length()) +
                Double.toString(totalPenalizacion)+ this.addingSpace(19 - Double.toString(totalPenalizacion).length()) + 
                Double.toString(totalEspera)+ this.addingSpace(13 - Double.toString(totalEspera).length()) + "\n"+
                "PROMEDIO"+this.addingSpace(72)+
                Double.toString(promedioRetorno)+ this.addingSpace(16 - Double.toString(promedioRetorno).length()) +
                Double.toString(promedioRespuesta)+ this.addingSpace(18 - Double.toString(promedioRespuesta).length()) +
                Double.toString(promedioDesperdicio)+ this.addingSpace(18 - Double.toString(promedioDesperdicio).length()) +
                Double.toString(promedioPenalizacion)+ this.addingSpace(19 - Double.toString(promedioPenalizacion).length()) + 
                Double.toString(promedioEspera)+ this.addingSpace(13 - Double.toString(promedioEspera).length()) + "\n"
        );
        
        return str.toString();
    }
    
    public String resultadoconPriori(){
        StringBuilder str = new StringBuilder();
        
        str.append(
            "PRIORIDAD"+ this.addingSpace(2)+
            "PROCESO" + this.addingSpace(2) + 
            "TIEMPO LLEGADA" + this.addingSpace(2) + 
            "DURACION RAFAGA" + this.addingSpace(2) + 
            "TIEMPO ARRANQUE" + this.addingSpace(2) +
            "TIEMPO FINALIZACION" + this.addingSpace(2) +
            "TIEMPO RETORNO"+ this.addingSpace(2) + //
            "TIEMPO RESPUESTA"+ this.addingSpace(2) +
            "TASA DESPERDICIO" + this.addingSpace(2) +
            "TASA PENALIZACION" + this.addingSpace(2) +
            "TIEMPO ESPERA\n"
        );
        
        for (Proceso listaProceso1 : listaProceso) {
            str.append(
                            Integer.toString(listaProceso1.getPrioridad()) + this.addingSpace(11 - Integer.toString(listaProceso1.getPrioridad()).length()) +
                            listaProceso1.getNombre() + this.addingSpace(9 - listaProceso1.getNombre().length()) + 
                            Integer.toString(listaProceso1.gettLlegada()) + this.addingSpace(16 - Integer.toString(listaProceso1.gettLlegada()).length()) +
                            Integer.toString(listaProceso1.getdRafaga()) + this.addingSpace(17 - Integer.toString(listaProceso1.getdRafaga()).length()) +
                            Integer.toString(listaProceso1.gettArranque()) + this.addingSpace(17 - Integer.toString(listaProceso1.gettArranque()).length()) +
                            Integer.toString(listaProceso1.gettFinalizacion()) + this.addingSpace(21 - Integer.toString(listaProceso1.gettFinalizacion()).length()) +
                            Integer.toString(listaProceso1.gettRetorno()) + this.addingSpace(16 - Integer.toString(listaProceso1.gettRetorno()).length()) +
                            Integer.toString(listaProceso1.gettRespuesta()) + this.addingSpace(18 - Integer.toString(listaProceso1.gettRespuesta()).length()) +
                            Integer.toString(listaProceso1.gettDesperdicio()) + this.addingSpace(18 - Integer.toString(listaProceso1.gettDesperdicio()).length()) +
                            Double.toString(listaProceso1.gettPenalizacion()) + this.addingSpace(19 - Double.toString(listaProceso1.gettPenalizacion()).length()) +
                            Double.toString(listaProceso1.gettEspera()) + this.addingSpace(13 - Double.toString(listaProceso1.gettEspera()).length()) +
            "\n");
            
        }
        
        str.append(
                "TIEMPO TOTAL"+ this.addingSpace(79)+
                Double.toString(totalRetorno)+ this.addingSpace(16 - Double.toString(totalRetorno).length()) +
                Double.toString(totalRespuesta)+ this.addingSpace(18 - Double.toString(totalRespuesta).length()) +
                Double.toString(totalDesperdicio)+ this.addingSpace(18 - Double.toString(totalDesperdicio).length()) +
                Double.toString(totalPenalizacion)+ this.addingSpace(19 - Double.toString(totalPenalizacion).length()) + 
                Double.toString(totalEspera)+ this.addingSpace(13 - Double.toString(totalEspera).length()) + "\n"+
                "PROMEDIO"+this.addingSpace(83)+
                Double.toString(promedioRetorno)+ this.addingSpace(16 - Double.toString(promedioRetorno).length()) +
                Double.toString(promedioRespuesta)+ this.addingSpace(18 - Double.toString(promedioRespuesta).length()) +
                Double.toString(promedioDesperdicio)+ this.addingSpace(18 - Double.toString(promedioDesperdicio).length()) +
                Double.toString(promedioPenalizacion)+ this.addingSpace(19 - Double.toString(promedioPenalizacion).length()) + 
                Double.toString(promedioEspera)+ this.addingSpace(13 - Double.toString(promedioEspera).length()) + "\n"
        );
        return str.toString();
    }
    
    public String resultadoLUE(){
        String str = "";
        
        str +="L\t";
        
        for (Unit listaLUE1 : listaLUE) {
            str += listaLUE1.getL() + "\t";
        }
        
        str += "\nU\t";
        
        for (Unit listaLUE1 : listaLUE) {
            str += listaLUE1.getU() + "\t";
        }
        
        str += "\nE\t";
        
        for (Unit listaLUE1 : listaLUE) {
            str += listaLUE1.getE() + "\t";
        }
        
        str += "\n";
        
        return str;
    }
       
    private String addingSpace(int cant){
        StringBuilder spaces = new StringBuilder();
        for (int i = 0 ; i < cant ; i++)
            spaces.append(' ');
        return spaces.toString();
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

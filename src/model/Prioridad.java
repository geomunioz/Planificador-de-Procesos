package model;

import interfaces.IPrioridad;
import java.util.List;

public class Prioridad extends Metodo implements IPrioridad{

    public Prioridad(List<Proceso> procesos) {
        super(procesos);
    }
    
}

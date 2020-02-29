package model;

import interfaces.IRR;
import java.util.List;

public class RR extends Metodo implements IRR{

    public RR(List<Proceso> procesos) {
        super(procesos);
    }
    
}

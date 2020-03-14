package interfaces;


import java.util.List;
import model.Metodo;
import model.Proceso;

public interface RunnableMethod {
    public Metodo run(List<Proceso> processList);
}

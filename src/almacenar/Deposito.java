package almacenar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Deposito extends Contenedor{
    public final double maxCapacidad;
    public Deposito(double capacidad){
        maxCapacidad = capacidad;
    }
    @Override
    public boolean agregar(Paquete paquete){
        if (this.getVolumen() + paquete.getVolumen() <= maxCapacidad){
            return super.agregar(paquete);
        }
        return false;
    }
    public Iterator<Paquete> getPaquetes(){
        List<Paquete> copyContenido = new ArrayList<Paquete>(contenido);
        Collections.sort(copyContenido, new Comparator<Paquete>(){
            public int compare(Paquete paquete1, Paquete paquete2){
                if(paquete1.getVolumen() < paquete2.getVolumen()){
                    return -1;
                }else if(paquete1.getVolumen() == paquete2.getVolumen()){
                    return 0;
                }else{
                    return 1;
                }
            }
        });
        return copyContenido.iterator();
    }
    
    public Paquete getPaquete(int index) {
      return (Paquete) this.contenido.get(index);
    }
}

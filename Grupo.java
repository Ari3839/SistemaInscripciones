
package proyecto;

import java.util.LinkedList;
/**
 * Contiene métodos de acceso para el uso de objetos del tipo Grupo
 */
public class Grupo {
    Profesor prof;
    Asignatura asig;
    LinkedList<Alumno> alumnos=new LinkedList<>();
/**
 * Constructor para un objeto Grupo
 * @param p El parámetro p define al profesor asignado a este grupo
 * @param asig El parámetro asig define la asignatura de este grupo
 */
    public Grupo(Profesor p, Asignatura asig){
        this.prof=p;
        this.asig=asig;
    }
    /**
     * Método que imprime la lista de Alumnos de este grupo, solo si la lista no está vacía.
     */
    public void imprimirAlumnos(){
        int n=0;
        if(!this.alumnos.isEmpty()){
            for(Alumno i:this.alumnos){
                System.out.println("\t"+(++n)+". "+i.getNombre());
            }
        } else {
            System.out.println("\tAun no se registran alumnos");
        }
    }
    
}

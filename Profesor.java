
package proyecto;

import java.util.ArrayList;
import java.util.TreeSet;
/**
 * Contiene métodos de acceso para el uso de objetos del tipo Profesor
 */
public class Profesor{
    private String nombre;
    private String titulo;
    private TreeSet<Integer> grupoP =new TreeSet<>();
    /**
     * Constructor para un objeto Profesor.
     * @param nombre Parámetro que representa el nombre del profesor.
     * @param titulo Parámetro que representa el titulo o grado profesional del profesor.
     */
    public Profesor(String nombre, String titulo){
        setNombre(nombre);
        setTitulo(titulo);
    }
    /**
     * Regresa el nombre del profesor representado por este objeto Profesor.
     * @return El nombre del profesor representado por este profesor.
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * Realiza la asignación del nombre de este objeto Profesor, sólo si se cumplen las condiciones establecidas para el parámetro.
     * @param nombre Este parámetro representa el nombre que se asignará a este objeto Profesor,y no pude tener menos de cinco caracteres.
     */
    public void setNombre(String nombre){
        if(nombre.length()>4)
            this.nombre=nombre;
        else
            System.out.println("\n**Nombre no valido**");
    }
    /**
     * Regresa el título (grado profesional) del profesor representado por este objeto Profesor.
     * @return El título del profesor representado por este profesor.
     */
    public String getTitulo(){
        return titulo;
    }
    /**
     * Realiza la asignación del título de este objeto Profesor, sólo si se cumplen las condiciones establecidas para el parámetro.
     * @param titulo Representa el título o grado profesional que se asignará a este objeto profesor, y no pudeo tener una longitud menor a tres carateres.
     */
    public void setTitulo(String titulo){
        if(titulo.length()>2)
            this.titulo = titulo;
        else
            System.out.println("\n**Título no valido**");
    }
    /**
     * Regresa el TreeSet de las claves de los grupos a los que ha sido asignado este objeto Profesor.
     * @return El TreeSet de la calves de los grupos de este profesor
     * @see java.util.TreeSet
     */
    public TreeSet<Integer> getGrupoP(){
        return grupoP;
    }
       
}
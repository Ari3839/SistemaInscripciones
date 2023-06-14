
package proyecto;
/**
 * Contiene métodos de acceso para el uso de objetos del tipo Asignatura
 */
public class Asignatura {
    private String nombre;
    /**
     * Contructor para un objeto Asignatura
     * @param nombre Este parámetro representa el nombre de la asignatura.
     */
    public Asignatura(String nombre){
        setNombre(nombre);
    }
    /**
     * Devuelve el nombre de esta asignatura representada por este objeto Asignatura.
     * @return Una cadena de caracteres que representa el nombre de esta asignatura
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * Asigna la cadena recibida al nombre de este objeto Asignatura, solo si se cumplen las condiciones establecidas para el parámetro.
     * @param nombre Representa el nombre de esta asignatura, y no puede tener menos de seis caracteres. 
     */
    public void setNombre(String nombre){
        if(nombre.length()>5){
            this.nombre=nombre;
        }
        else
            System.out.println("\n**Nombre no valido, no se creó la asignatura**");
    }
    
}

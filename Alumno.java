
package proyecto;
/**
 * Esta clase administra los objetos de tipo alumno con ayuda de los respectivos métodos de acceso de los atributos establecidos
 * @author ***
 */
public class Alumno {
    private String nombre;
    private String carrera;
    private int [] grupos= {0,0,0};
    /**
     * Constructor de la clase Alumno
     * @param nombre Parámetro que representa el nombre de este objeto Alumno.
     * @param carrera Parámetro que representa la carrera de este objeto Alumno.
     */
    public Alumno(String nombre, String carrera){
        setNombre(nombre);
        setCarrera(carrera);
    }
    /**
     * Regresa el nombre de este alumno representado por este objeto Alumno.
     * @return Una cadena de caracteres que representa el nombre de este alumno.
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * Realiza la asignacion del nombre del estudiante, pero solo si el nombre resulta ser mayora 2 caracteres, en caso contrario no asigna nada 
     * @param nombre este parametro represente el nombre que se le va a asignar al alumno 
     */
    public void setNombre(String nombre){
        if(nombre.length()>2)
            this.nombre=nombre;
        else
            System.out.println("Nombre invalido");
    }
    /** 
    * Regresa el nombre de la carrera del alumno representado por el objeto alumno. 
    * @return Una cadena de caracteres que representa la carrera del alumno.
    */
    public String getCarrera(){
        return carrera;
    }
    
    /**
     * Realiza la asignacion del nombre de la carrera a la que pertenece el alumno.
     * @param carrera este parametro representa el nombre de la carrera a la que eprtenece el alumno representado por el objeto alumno. 
     */
    public void setCarrera(String carrera){
        if(carrera.length()>4)
                this.carrera=carrera;
        else
            System.out.println("\n**Carrera invalida**");
    }
    /**
     * Regresa el arreglo con las claves unicas de los grupos a los que pertenece el alumno representado por este objeto alumno. 
     * @return Un arreglo de enteros que representan las claves unicas de los grupos a los que est inscrito el alumno
     */
    public int[] getGrupos(){
        return grupos;
    }
    
    /**
     * Asigna la clave unica de grupo a un espacio que sea igual a 0 en el arreglo grupos del objeto alumno, si no hay espacios iguales a 0 en el arreglo o si la clave ya esta repetida, entonces, se regresara 0 y se imprimira un mensaje. 
     * @param clave este parametro representa la clave unica del grupo al que el alumno se quiere inscribir.
     * @return Regresa 1 si la asignacion de grupo se realizo correctamente o regresa 2 si no se pudo asignar el grupo.
     */
    public int setGrupos(int clave){
        for(int i=0;i<3;i++){
            if(grupos[i] == 0){
                if(grupos[0]!=clave&&grupos[1]!=clave&&grupos[2]!=clave){
                    grupos[i] = clave;
                    return 1;
                } 
                else {
                    System.out.println("\n**No te puedes inscribir 2 veces al mismo grupo**");
                    return 0;
                }
            }
            if((grupos[2]!=0)&&(grupos[1]!=0)&&(grupos[0]!=0)){
                System.out.print("\n**Solo te puedes inscribir a 3 grupos**");
                return 0;
            }
        }
        return 1;
    }
}

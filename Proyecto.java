
package proyecto;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;
/**
 * Esta clase contiene el metodo principal del proyecto
 * 
 */
public class Proyecto {
    /**
     * Menú principal del proyecto, aquí se puede ingresar a diferentes opciones de acuerdo con el rango del usuario
     * @param args 
     */
    public static void main(String[] args) {
        int op;
        
        Hashtable<Integer,Grupo> group=new Hashtable<>();
        LinkedList<Asignatura> subjet=new LinkedList<>();
        LinkedList<Profesor> prof=new LinkedList<>();
        Hashtable<Integer,Alumno> alumn=new Hashtable<>();
        Utileria obj = new Utileria();
        
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("\nSelecccione una opcion");
            System.out.println("1. Ingresar como alumno");
            System.out.println("2. Ingresar como docente");
            System.out.println("3. Ingresar como administrador de asignaturas");
            System.out.println("4. Salir");
            op=Integer.parseInt(sc.nextLine());
            switch(op){
                case 1:
                    obj.alumno(alumn,group);
                    break;
                case 2:
                    obj.docente(prof,group);
                    break;
                case 3:
                    obj.admin(subjet,prof,group);
                    break;
                case 4:
                    System.out.println("\nSaliendo...");
                    break;
                default:
                    System.out.println("\nIngresa una opcion correcta");
                    break;
            }
        }while(op!=4);
        
    }
    
}

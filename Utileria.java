
package proyecto;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;
/**
 * En esta clase se implementan todas las opciones presentadas al usuario (operaciones posibles entre clases)
 */
public class Utileria {
        /**
         * Contiene un submenu de la opcion "Ingresar como administrador de asignaturas",
         * se apoya de otros metodos para ejecutar las opciones de dicho submenu
         * @param subjet Recibe la lista de tipo Asignatura para guardar los datos segun los atributos de la clase
         * @param prof Recibe la lista de tipo Profesor para guardar en ella los datos necesarios de la clase
         * @param group  Recibe una tabla hash, en donde se guardaran los datos del grupo a crear
         */
        public void admin(LinkedList<Asignatura> subjet, LinkedList<Profesor> prof, Hashtable<Integer,Grupo> group){
        int op,clave=1223;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("\nEscoge una opcion");
            System.out.println("1. Ingresar asignatura");
            System.out.println("2. Imprimir asignaturas");
            System.out.println("3. Abrir grupos");
            System.out.println("4. Regresar al menú principal");
            op=Integer.parseInt(sc.nextLine());
            switch(op){
                case 1:
                    System.out.println("\nIngresa el nombre de la asignatura");
                    String nombre=sc.nextLine();
                    Asignatura a1=new Asignatura(nombre);
                    if(a1.getNombre()!=null)
                        subjet.add(a1); 
                    break;
                case 2:
                    if(subjet.size()==0)
                        System.out.println("\nLa lista esta vacia");
                    else
                        imprimirA(subjet);
                    break;
                case 3:
                        abrirGpo(subjet,prof,group,clave++);
                        imprimirGrupo(group);
                    break;
                case 4:
                    System.out.println("\nRegresando...");
                    break;
                default:
                    System.out.println("\nOpcion invalida");
            }
        }while(op!=4);
    }
    /**
     * Metodo implementado en el metodo admin, su objetivo es imprimir la lista de asignaturas
     * @param subjet Se proporciona la lista de tipo Asignatura para imprimir la lista de asignaturas
     */
    public void imprimirA(LinkedList<Asignatura> subjet){
        System.out.println("\nLa lista de asignaturas es:");
        for(Integer i=0;i<subjet.size();i++){
            System.out.println("\t"+(i+1)+". "+subjet.get(i).getNombre());
        }
    }
    /**
     * Es usado para poder crear un grupo asociando un profesor y una asignatura
     * @param subjet Es necesaria para poder asociar una asignatura un grupo
     * @param prof  Se recibe esta lista para asignar un profesor a un grupo
     * @param group En la tabla hash se guardara la clave del grupo con un objeto tipo Grupo
     * @param clave Clave necesaria en la tabla hash y con ella poder identificar cada grupo creado
     */
    public void abrirGpo(LinkedList<Asignatura> subjet, LinkedList<Profesor> prof, Hashtable<Integer,Grupo> group, int clave){
        int asi,pr;
        Scanner sc=new Scanner(System.in);
        if(subjet.size()!=0 && prof.size()!=0){
            System.out.println("\nEscoge un asignatura");
            imprimirA(subjet);
            asi=Integer.parseInt(sc.nextLine())-1;
            System.out.println("\nEscoge un profesor para impartir la asignatura");
            imprimirP(prof);
            pr=Integer.parseInt(sc.nextLine())-1;
            if ((pr>=0) && (pr<prof.size()) && (asi>=0) && (asi<subjet.size())){
                Grupo g = new Grupo(prof.get(pr),subjet.get(asi));
                group.put(clave, g);
                prof.get(pr).getGrupoP().add(clave);
            } 
            else{
                System.out.println("\nEl numero de asignatura o profesor son incorretos");
            }
        }
        else
            System.out.println("\nNo se han registrado asignaturas o profesores");
    }

    /**
     * Contiene un submenu de la opcion "Ingresar como docente" en el cual estan contenidas las opciones para interactuar con docente
     * @param profe En el parametro se guardaran los datos que sean ingresados por el usuario
     * @param group En el parametro se necesita para ver los grupos a los que esta inscrito el profesor
     */
    public void docente(LinkedList<Profesor> profe,Hashtable<Integer,Grupo> group){
        int op;
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("\nEscoge una opcion");
            System.out.println("1. Registrar profesor");
            System.out.println("2. Imprimir lista de profesores");
            System.out.println("3. Iniciar sesion");
            System.out.println("4. Regresar al menú principal");
            op=Integer.parseInt(sc.nextLine());
            switch(op){
                case 1:
                    System.out.println("\nIngresa el titulo del profesor");
                    String titulo=sc.nextLine();
                    System.out.println("Ingresa el nombre del profesor");
                    String nombre=sc.nextLine();
                    Profesor p1 = new Profesor(nombre, titulo);
                    if(p1.getNombre()!=null&&p1.getTitulo()!=null){
                        profe.add(p1);
                    } else { 
                        System.out.println("\nNo se registro el profesor");
                    }
                    break;
                case 2:
                    if(profe.size()==0)
                        System.out.println("\nLa lista esta vacia");
                    else
                        imprimirP(profe);
                    break;
                case 3:
                    System.out.println("Ingresa tu nombre");
                    nombre=sc.nextLine();
                    int indice=buscarNombre(profe,nombre);
                     if (indice!=-1){
                        iniciarS(profe,indice,group);
                    } 
                    else{
                        System.out.println("\nNo hay un profesor con ese nombre");
                    }
                    break;
                case 4:
                    System.out.println("\nRegresando...");
                    break;
                default:
                    System.out.println("\nOpcion invalida");
            }
        }while(op!=4);
    }
    /** 
     * Realiza la búsqueda lineal de un profesor por su nombre
     * @param prof Se requiere la lista de tipo Profesor, que contiene a los profesores registrados hasta el momento, para buscar en su contenido.
     * @param nombre Representa el nombre del profesor buscado
     * @return Si la lista de profesores está vacía, regresa un -1. En caso contrario, regresa el índice donde fue encontrada la primer coincidencia del profesor buscado.
     */
    public Integer buscarNombre(LinkedList<Profesor> prof,String nombre){
        if(prof.isEmpty()){
            System.out.println("No hay profesores registrados");
            return -1;
        }
        else{
            for(Integer i=0;i<prof.size();i++){
                if(prof.get(i).getNombre().compareTo(nombre)==0){
                    return i;
                }
            }
            return -1;
        }
    }
    /**
     * Método que contine un submenú donde se muestran la sopciones que pude realizar un profesor al iniciar sesión. 
     * @param prof Necesita la lista de profesores para encontrar al profesor que inicia ssión.
     * @param indice Representa la posición en la lista del profesor que inicia sesión. 
     * @param group Se necesita la colección de grupos para poder imprimir la lista de alumnos inscritos en un determinado grupo.
     */
    public void iniciarS(LinkedList<Profesor>prof,int indice,Hashtable<Integer,Grupo> group){
        int op=0;
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("\n\nBienvenido(a), "+prof.get(indice).getNombre()+"\n");
            System.out.println("Escoge una opcion");
            System.out.println("1) Ver lista de alumnos");
            System.out.println("2) Regresar");
            op=Integer.parseInt(sc.nextLine());
            switch(op){
                case 1:
                    if(!prof.get(indice).getGrupoP().isEmpty()){
                        imprimirGrupos(prof.get(indice).getGrupoP(),group);
                        System.out.println("\nIngresa la clave del grupo para observar la lista de alumnos del mismo");
                        int grupo=Integer.parseInt(sc.nextLine());
                        if(group.containsKey(grupo)){
                            System.out.println("\tClave: "+grupo+"\tAsignatura: "+ group.get(grupo).asig.getNombre());
                            System.out.println("\n\tAlumnos:\n");
                            group.get(grupo).imprimirAlumnos();
                        } else{
                            System.out.println("\n\nNo hay un grupo con esa clave");
                        }
                    } else{
                        System.out.println("\nNo tiene grupos registrados\n");
                    }
                    break;
                case 2:
                    System.out.println("\nRegresando...");
                    break;
                default:
                    System.out.println("\nOpcion invalida");
            }
        }while(op!=2);
        
    }
    /**
     * Método que imprime los grupos (clave y asignatura) a los que esta asociado un Profesor. 
     * @param grupoP Se necesitan las claves de los grupos asignados al rpofesor.
     * @param group Es necesaria la tabla hash de los grupos creados hasta el momento, para imprimir su contenido.
     */
    public void imprimirGrupos(TreeSet<Integer> grupoP,Hashtable<Integer,Grupo> group){
        if(grupoP.isEmpty()){
            System.out.println("\nNo se ha sido asignado a ningún grupo");
        }else{
            System.out.println("\nLa lista de grupos es:");
            //Transforma el TreeSet de las claves de los grupos a un arreglo de objetos Object
            Object grupos[]=grupoP.toArray();
            for(int i=0;i<grupoP.size();i++){
                System.out.println("\tClave: "+grupos[i]+"\tAsignatura: "+ group.get(grupos[i]).asig.getNombre());
            }
        }
    }
    
    /** 
     * Es necesaria para poder cumplir una opcion del metodo docente
     * @param prof Se necesita la lista de tipo Profesor para mostrar su contenido
     */
    public void imprimirP(LinkedList<Profesor> prof){
        if(prof.isEmpty())
            System.out.println("No hay profesores registrados");
        else{
            System.out.println("\nLa lista de profesores es:");
            for(Integer i=0;i<prof.size();i++){
                System.out.println("\t"+(i+1)+". "+prof.get(i).getTitulo()+" "+prof.get(i).getNombre());
                if(!prof.get(i).getGrupoP().isEmpty()){
                    System.out.println("\tCuyas claves de grupos son:");
                    System.out.println("\t"+prof.get(i).getGrupoP());
                }
            }
        }
        
    }
    /**
     * Este metodo contiene las opciones que puede elegir el usuario en la opcion "Ingresar como alumno"
     * @param alumn Obteniendo los datos proporcionados se comenzaran a guardar en la lista segun los atributos de la clase Alumno 
     * @param group Se guardaran los datos que sean necesarios en esta tabla hash
     */
    public void alumno(Hashtable<Integer,Alumno> alumn, Hashtable<Integer,Grupo> group){
        int op,clave=316000000;;
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("\nEscoge una opcion");
            System.out.println("1. Registrar alumno");
            System.out.println("2. Imprimir lista de alumnos");
            System.out.println("3. Iniciar Sesion (para alumnos registrados)");
            System.out.println("4. Regresar al menú principal");
            op=Integer.parseInt(sc.nextLine());
            switch(op){
                case 1:
                    System.out.println("Ingresa el nombre del alumno");
                    String nombre=sc.nextLine();
                    System.out.println("Ingresa la carrera del alumno");
                    String carrera=sc.nextLine();
                    Alumno a=new Alumno(nombre, carrera);
                    if(a.getNombre()!=null&&a.getCarrera()!=null){
                        alumn.put(clave, a);
                        System.out.println("\nTu registro se ha concluido exitosamente "+ nombre);
                        System.out.println("\nTu numero de cuenta es: "+clave);
                        clave++;
                    }
                    else
                        System.out.println("\nNo se pudo registrar alumno");
                    break;
                case 2:
                    if(alumn.isEmpty())
                        System.out.println("La lista esta vacia");
                    else
                        imprimirAl(alumn);
                    break;
                case 3:
                    int NC;
                    System.out.println("\nIngresa tu No.de cuenta:");
                    NC = Integer.parseInt(sc.nextLine());
                    if (alumn.containsKey(NC)){
                        iniciarS(alumn,NC,group);
                    } 
                    else{
                        System.out.println("\nNo hay un alumno con ese numero de cuenta");
                    }
                    break;
                case 4:
                    System.out.println("\nRegresando...");
                    break;
                default:
                    System.out.println("\nOpcion invalida");
            }
        }while(op!=4);
    }
    /**
     * Este metodo es llamado en el metodo alumno para cumplir con opciones presentadas al usuario
     * @param alumn Como su funcion es imprimir la lista de los alumnos previamente registrados, es necesario obtener los datos de la tabla hash
     */
    public void imprimirAl(Hashtable<Integer,Alumno> alumn){
         if(alumn.isEmpty()){
            System.out.println("\nNo se han registrado alumnos");
        }else{
            System.out.println("\nLa lista de alumnos es:");
            Enumeration en = alumn.elements();
            Enumeration en2 = alumn.keys();
            while(en.hasMoreElements()){
                Alumno Al = (Alumno)en.nextElement();
                System.out.println("No. de cuenta: "+en2.nextElement()+"\t\tAlumno: "+Al.getNombre()+"\t\tCarrera: "+Al.getCarrera());
            }
        }
    }
    /**
     * Contiene el submenu de una de las opciones presentadas al momento de que un alumno inicie sesion
     * @param alumn Se necesita la lista de alumnos para conocer que alumno quiere guardar o visualizar informacion
     * @param NC Mediante el numero de cuenta, accederemos al alumno que haya iniciado sesion
     * @param group Mediante esta lista, el alumno conocera los grupos dados de alta
     */
    public void iniciarS(Hashtable<Integer,Alumno> alumn, int NC, Hashtable<Integer,Grupo> group){
        int op,clave,exit = 0;
        int []j;
        boolean baja = false;
        do{
            Alumno al = (Alumno)alumn.get(NC);
            System.out.println("\nBienvenido(a), "+al.getNombre()+"\n");
            System.out.println("1) Ver grupos a los que se esta inscrito");
            System.out.println("2) Inscribirse en un grupo");
            System.out.println("3) Darse de baja de un grupo");
            System.out.println("4) Regresar");
            Scanner sc = new Scanner(System.in);
            op=Integer.parseInt(sc.nextLine());
            switch(op){
                case 1:
                    j=al.getGrupos();
                    if(j[0]!=0||j[1]!=0||j[2]!=0){
                        System.out.println("\n\n***Tus Grupos***");
                        for(int i=0;i<3;i++){
                            if(j[i]!=0)
                                System.out.println("\tClave: "+j[i]+"\t\tAsignatura: "+ group.get(j[i]).asig.getNombre() +"\t\tProfesor: "+group.get(j[i]).prof.getNombre());
                        }
                    } else {
                        System.out.println("\nNo estas inscrito en ningun grupo");
                    }
                    break;
                case 2:
                    imprimirGrupo(group);
                    if(!group.isEmpty()){
                        System.out.println("\nIngrese la clave del grupo");
                        clave=Integer.parseInt(sc.nextLine());
                        if(group.containsKey(clave)){
                            if(al.setGrupos(clave)==1){
                                group.get(clave).alumnos.add(al);
                                System.out.println("\nSe ha registrado el grupo");
                            } else {
                                System.out.println("\n**No se registro el grupo**");
                            }
                        } 
                        else {
                            System.out.println("\nNo hay un grupo con esa clave");
                        }
                    }    
                break;
                case 3:
                    baja = false;
                    System.out.println("\n***Darse de baja de un grupo***");
                    j=al.getGrupos();
                    if(j[0]!=0||j[1]!=0||j[2]!=0){
                        for(int i=0;i<3;i++){
                            if(j[i]!=0)
                                System.out.println("Clave: "+j[i]+"\tAsignatura: "+ group.get(j[i]).asig.getNombre() +"\tProfesor: "+group.get(j[i]).prof.getNombre());
                        }
                        System.out.println("\nIngresa el grupo del que te quieres dar de baja");
                        clave=Integer.parseInt(sc.nextLine());
                        for(int i=0;i<3;i++){
                            if(j[i]==clave){
                                j[i]=0;
                                group.get(clave).alumnos.remove(al);
                                System.out.println("\nTe has dado de baja exitosamente");
                                baja = true;
                            }
                        }
                        if(!baja){
                            System.out.println("\nNo estas registrado en un grupo con esa clave");
                        }
                    } 
                    else {
                        System.out.println("\nNo estas inscrito en ningun grupo");
                    }
                    break;
                case 4:
                    System.out.println("\nSaliendo");
                    exit=1;
                    break;
                default:
                    System.out.println("\nOpcion incorrecta");
                    break;
            }
        }while(exit!=1);
    }
    /**
     * Este metodo hace funcionar una opcion del metodo iniciarS
     * @param group Mediante el recorrido de la tabla hash es posile visuaizar los datos que esta contiene
     */
    public void imprimirGrupo(Hashtable<Integer,Grupo> group){
        if(group.isEmpty()){
            System.out.println("\nNo se han registrado grupos");
        }else{
            System.out.println("\nLa lista de grupos es:");
            Enumeration en = group.elements();
            Enumeration en2 = group.keys();
            while(en.hasMoreElements()){
                Grupo gr = (Grupo)en.nextElement();
                System.out.println("\tClave: "+ en2.nextElement()+"\t\tProfesor:" + gr.prof.getNombre()+"\t\tAsignatura:"+gr.asig.getNombre());
            }
        }
    }
}
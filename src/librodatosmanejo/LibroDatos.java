/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librodatosmanejo;

import java.util.LinkedList;

/**
 *
 * Clase STATIC que mantiene datos de libro guardados en un conjunto de elementos de tipo String dentro de una lista
 * de clase LinkedList. Cada elemento en la lista formará parte de un registro de libro; teniéndose un total
 * de tres datos de libro por registro.
 * Los datos de libro a guardar son: 'Nombre completo de libro', 'Isbn', 'Descripción'
 * El tamaño de registro es entonces de un total de 3 elementos.
 * 
 * 
 * @author angel
 */
public class LibroDatos {
   
    //Constante para guardar el número de elementos por registro
    static final int tam_registro=3;
    //Lista con datos de tipo String, para guardar los datos de libro en registros
    static LinkedList<String> DatosLibro;
    //Número de registros actualizados conforme se van insertando nuevos datos
    static int N_Registros;
    //Número de elementos actualizados conforme se van insertando nuevos registros
    static int N_Elementos;
    //Número de registros máximos a poder guardar en la lista de datos libro
    static int N_RegistrosMax;
    //Número de elementos máximos calculados a poder guardarse a partir de los registros insertados
    static int N_ElementosMax;
    
    /**
     * Método public accesible
     * Creador de la lista de elementos de Datos Libro con una tamaño inicial de 0 elementos, y de 0 registros, y de un
     * máximo de registros establecido con el valor de entrada 'num_regs' y máximo de elementos en la lista el tamaño de 
     * los registros multiplicado por el conjunto de datos de persona que se guarda (x3)
     * 
     * @param num_regs Valor de entrada del número de registros máximos a mantener en la lista de elementos
     */
    public static void CrearLibroDatos(int num_regs){
        
        //Inicialmente la lista a contener datos de persona tiene un tamaño libre
        //a crecer a medida se inserten, y a decrecer a medida se borren elementos
        DatosLibro=new LinkedList<>();

        //Datos miembro de la clase Static a mantener conforme se vaya trabajando con la lista
        //de elementos.
        N_Registros=0;
        N_Elementos=0;
        N_RegistrosMax=num_regs;
        N_ElementosMax=N_RegistrosMax*3;
        
    }

    /**
     * 
     * Método public accesible para añadir un registro de libro a la lista de elementos.
     * Los registros dentro de la lista de elementos están formados por 'un nombre', 'un isbn', y
     * 'una descripción'.
     * Por lo que los valores de entrada para formar un registro son insertados como parámtros al método
     * , y son de tipo String
     * Llegado a un máximo posible de registros el método no deja insertar más elementos, lanzando una
     * excepción si esto ocurre
     * 
     * @param Nombre Texto dato nombre completo del libro a insertar en la lista, de tipo String
     * @param Isbn texto dato isbn del libro a insertar en la lista, de tipo String
     * @param Descripcion texto dato descripción del libro a insertar en la lista de tipo String
     * @throws Exception Un excepción que se lanza cuando el tamaño máximo de registros se ha alcanzado    
     */    
    public static void Agregar_DatosLibro(String Nombre, String Isbn, String Descripcion) throws Exception{
        
        if(N_Registros<N_RegistrosMax){
            DatosLibro.add(Nombre);
            DatosLibro.add(Isbn);
            DatosLibro.add(Descripcion);
            
            N_Registros++;
            N_Elementos=N_Elementos+3;
            
        }else
            throw new Exception("Se produjo un error al intentar insertar. Máximo alcanzado");
        
    }
    
    public static void Borrar_DatosLibro(int pos_registro) throws Exception{
        
        if((pos_registro<N_Registros) && (pos_registro>=0)){

            int indice_elemento=pos_registro*3;

            for (int pos=indice_elemento;pos<indice_elemento+3;pos++)
                DatosLibro.remove(indice_elemento);
            
            N_Registros--;
            N_Elementos=N_Elementos-3;
            
        }else
            throw new Exception("Se produjo un error al intentar borrar un registro. Registro inexistente");
        
    }
    
    public static void Mostrar_DatosLibro(int pos_registro) throws Exception{
        
        if((pos_registro<N_Registros) && (pos_registro>=0)){
            int indice_elemento=pos_registro*3;

            for (int pos=indice_elemento;pos<indice_elemento+3;pos++){
                System.out.println("Dato "+pos+": "+DatosLibro.get(pos));
            }
                
        }else
            throw new Exception("Se produjo un error al intentar borrar un registro. Registro inexistente");        
        
    }
    /*
    public static void Borrar_DatosLibro(String isbn) throws Exception{
        

        int indice,indice_elem;
        
        indice=DatosLibro.indexOf(isbn);
        
        if (indice!=-1){
            indice_elem=indice-1;

            for(int pos=0;pos<3;pos++)
                DatosLibro.remove(indice_elem);

            N_Registros--;
            N_Elementos=N_Elementos-3;
            
        }else
            throw new Exception("Se produjo un error al intentar borrar un registro. Registro inexistente");

    }*/
    
}

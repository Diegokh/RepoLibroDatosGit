/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package librodatosmanejo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author angel
 */
public class ManejoDatosLibro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner scan=new Scanner(System.in);
        String dato_nombre, dato_isbn, dato_descripcion;
        String txt_aux;
        int var_aux;
        int opcion=-1;
        
        mostrar_opciones();                
        System.out.println("\n");
        System.out.print("Elija una opcion: ");
        opcion=scan.nextInt();
        
        while (opcion!=5){
            switch(opcion){
                case 0 -> {
                    System.out.println("Inicializa Lista de Registros Libros");
                    System.out.print("Inserte número de registros máximo a guardar en la lista: ");
                    var_aux=scan.nextInt();
                    LibroDatos.CrearLibroDatos(var_aux);
                }
                case 1 -> {
                    System.out.println("Agregar Libro:\n");

                    System.out.println("Inserte datos de libro a agregar.");
                    System.out.print("Nombre de libro: ");
                    dato_nombre=scan.nextLine();
                    System.out.println();
                    System.out.print("Número de isbn: ");
                    dato_isbn=scan.nextLine();        
                    System.out.println();
                    System.out.print("Datos de descripción: ");
                    dato_descripcion=scan.nextLine();

                    try{
                        LibroDatos.Agregar_DatosLibro(dato_nombre, dato_isbn, dato_descripcion);
                    }catch (Exception e){
                            System.out.println("Ocurrió una excepción. "+e.getMessage());
                    }

                }
                case 2 -> {
                        System.out.println("Borrar Datos de Libro:\n");

                        System.out.print("Inserte número de registro a borrar datos: ");
                        var_aux=scan.nextInt();

                        try{
                            LibroDatos.Borrar_DatosLibro(var_aux);
                        }catch(Exception e){
                            System.out.println("Ocurrió una excepción. "+e.getMessage());
                        }
                }
                case 3 -> {
                        System.out.println("Mostrar Datos de Libro:\n");

                        System.out.print("Inserte número de registro a mostrar datos: ");
                        var_aux=scan.nextInt();

                        try{
                            LibroDatos.Mostrar_DatosLibro(var_aux);
                        }catch(Exception e){
                            System.out.println("Ocurrió una excepción. "+e.getMessage());
                        }
                }
                case 4 -> {
                        System.out.println("Borrar Datos de Libro:\n");

                        System.out.print("Inserte número de isbn a borrar datos: ");
                        txt_aux=scan.nextLine();

                        try{
                            LibroDatos.Borrar_DatosLibro(txt_aux);
                        }catch(Exception e){
                            System.out.println("Ocurrió una excepción. "+e.getMessage());
                        }
                }
            }
            
        mostrar_opciones();
        System.out.println("\n");
        System.out.print("Elija una opcion: ");
        opcion=scan.nextInt();
        
        //Limpia el buffer
        scan.nextLine();
            
        }
        

    }
    
    public static void mostrar_opciones() {
        System.out.println("MANEJO DE DATOS DE PERSONA");
        System.out.println("Elija una opción");
        System.out.println("0.- Crear lista de datos libro");
        System.out.println("1.- Agregar libro a lista de datos");
        System.out.println("2.- Borra libro de lista de datos");
        System.out.println("3.- Mostrar datos de libro desde lista de datos");
        //System.out.println("4.- Borrar datos de libro desde lista de datos");
        System.out.println("5.- Salir");
    }
    
}

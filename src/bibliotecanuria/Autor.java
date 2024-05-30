/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecanuria;
import java.util.*;

/**
 *
 * @author nuria
 */
public class Autor {
    //Declaro los atributos como privados
        //private int id_Autor;
        private String nombre_Autor;
        private int anoNacimiento;
        private int anoMuerte;
        private List<Libro> listaLibrosAutor; //Creo una lista de libros que añadiré dentro de cada autor.
    
    /*Creo el constructor público para la clase Autor y le paso los argumentos (atributos) 
    privados que he declarado anteriormente (ahora serán accesibles con el constructor)*/
        public Autor(String nombre){
            //this.id_Autor = id_Autor;
            this.nombre_Autor = nombre_Autor;
            this.anoNacimiento = anoNacimiento;
            this.anoMuerte = anoMuerte;
            this.listaLibrosAutor = new ArrayList<>(); //Inicializo la lista que se me creará cada vez que cree un autor.
            AutorDAO.insertAutor(nombre_Autor, anoNacimiento, anoMuerte);
        }           
    
    //Creo métodos para coger el valor de los diferentes argumentos.
        public String getNombreAutor(){ //Método para coger el nombre.
            return nombre_Autor;
        }
        
        public static void InsertarAutor(String nombre_Autor, int anoNacimiento, int anoMuerte){
          
             AutorDAO.insertAutor(nombre_Autor, anoNacimiento, anoMuerte);
        
        }
        

        //El autor publica (y por lo tanto crea) un libro.
        public static void publicarLibro(String titulo, String autor){
          
            LibroDAO.insertLibro(titulo, autor, true);
        
        }
        
                
       
        //Imprimir lista libros Autor
        public static void imprimirListaLibrosAutor(int id_Autor){
            
            
            AutorDAO.printAutorLibroDetails(id_Autor);
 
        }
    
}

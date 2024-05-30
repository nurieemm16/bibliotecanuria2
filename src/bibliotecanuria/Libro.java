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
public class Libro {
    
    //Declaro los atributos como privados
        private int id;
        private String titulo;
        private String autor;
        private boolean disponibilidad;
        private static List<Libro> listaLibrosGenerica = new ArrayList<>(); //Declaro e inicializo una lista de libros genérica
        private static List<Libro> listaLibrosDisponibles = new ArrayList<>(); //Declaro e inicializo una lista de libros genérica para los disponibles
        private static List<Libro> listaLibrosNoDisponibles = new ArrayList<>(); //Declaro e inicializo una lista de libros genérica para los no disponibles
        
    /*Creo el constructor público para la clase Libro y le paso los argumentos (atributos) 
    privados que he declarado anteriormente (ahora serán accesibles con el constructor)*/
        public Libro(String titulo, String autor){
            this.id = id;
            this.titulo = titulo;
            this.autor = autor;
            this.disponibilidad = true;
            LibroDAO.insertLibro(titulo, autor, disponibilidad);
        
        /*Aquí digo que cada vez que creo un libro (con todos los argumentos del libro, "this",) se añadirá dentro de la lista
        "listaLibrosGenerica", "listaLibrosDisponibles" y "listaLibrosNoDisponibles (que de momento, si no digo nada, está en el aire).*/
            listaLibrosGenerica.add(this);
            listaLibrosDisponibles.add(this);
            listaLibrosNoDisponibles.add(this);
        }
    
    //Creo métodos para coger el valor de los diferentes argumentos.
        
            public int getIdLibro() {
        return id;
    }
        public String getTituloLibro(){ //Método para coger el título.
            return titulo;
        }

        public String getAutorLibro(){ //Método para coger el autor.
            return autor;
        }

        public boolean getDisponibilidadLibro(){ //Método para coger la disponibilidad.
            return disponibilidad;
        }

        public static List<Libro> getListaLibrosGenerica(){ //Método para coger la lista de libros genérica.
            return listaLibrosGenerica;
        }
        
        public static List<Libro> getListaLibrosDisponibles(){ //Método para coger la lista de libros genérica de los disponibles.
            return listaLibrosDisponibles;
        }
        
        public static List<Libro> getListaLibrosNoDisponibles(){ //Método para coger la lista de libros genérica de los no disponibles.
            return listaLibrosNoDisponibles;
        }
    
 
        //El libro se marca como prestado (ya no está disponible)
        public void marcarLibroPrestado(){
            System.out.println("El libro " + this.titulo + " se ha prestado y ya no está disponible.");
           LibroDAO.updateDispoLibro(false);
        }
        
         //El libro se marca como devuelto (vuelve a estar disponible)
        public void marcarLibroDevuelto(){
            System.out.println("El libro " + this.titulo + " se ha devuelto y vuelve ha estar disponible.");
            LibroDAO.updateDispoLibro(true);
        }
        
           public void marcarLibroReservado(){
            System.out.println("El libro " + this.titulo + " se ha reservado y próximamente estará en tus manos.");
            
            LibroDAO.updateDispoLibro(false);
        }
        
       
        
        public static void imprimirListaLibrosGenerica(){
            
            System.out.println("Lista general de libros de la biblioteca:");
            LibroDAO.printLibroDetails();
            /*for(Libro libroG : listaLibrosGenerica){ //Con el FOR recorro la lista de libros genérica, que se encuentra en la clase Libro (como es la clase donde estamos no le digo en qué clase está)
                System.out.println("    " + libroG.getTituloLibro());
            }
            
            return "";*/
        }
        
         public static boolean getDisponibilidad(String titulo){
             return LibroDAO.getDisponibilidad(titulo);
         }
         
         
        public static List<String> getAllLibrosName(){
            return LibroDAO.getAllLibrosName();
        }
        
        
            
         public static boolean isLibroInLista(String titulo){ 
        List<String> librosName =  Libro.getAllLibrosName();
        return librosName.contains(titulo);
    }
        
        
        public static void cambiarDisponibilidad(String titulo, boolean dispo){
            LibroDAO.cambiarDisponibiliad(titulo, dispo);
        }
        
        

 }          


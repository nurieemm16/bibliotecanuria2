/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bibliotecanuria;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nuria
 */
public class Bibliotecanuria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //OPERACIONES CRUD
        //CREO USUARIO
        //Usuario Usuario9 = new Usuario ("Aïda Salas","usuario");
        //UsuarioDAO.insertUsuario("Kevin Martínez", "usuario");
        //UsuarioDAO.printUsuarioDetails();
        
         //BORRO USUARIO
        
        //UsuarioDAO.deleteUsuario(6);
        //UsuarioDAO.printUsuarioDetails();
        
        
        //CREO AUTOR
       Autor.InsertarAutor("Núria", 1800, 1823);
        //AutorDAO.insertAutor("Mercè Rodoreda", 1908, 1983);
        //AutorDAO.printAutorDetails();
        
        //BORRO AUTOR
        //AutorDAO.deleteAutor(5, "Carlos Ruiz Zafón");
        //AutorDAO.printAutorDetails();
    
        //CREO LIBRO
        //Autor.publicarLibro("Circo Máximo", "Santiago Posteguillo");
        //LibroDAO.insertLibro("Mirall Trencat", "Mercè Rodoreda", true);
        //LibroDAO.printLibroDetails();
        
          //BORRO LIBRO
        
        //LibroDAO.deleteLibro(10, "La plaça del diamant");
        //LibroDAO.printLibroDetails();
    
        //CREO MIEMBRO PREMIUM
        
        //MiembroPremiumDAO.insertMP("Jana Llorent", "miembro premium");
        //MiembroPremiumDAO.printMPDetails();
         //MiembroPremium  MiembroPremium11 = new MiembroPremium("Roger Marí", "MiembroPremium");
     //MiembroPremium.insertMPLibroPrestadoSiExiste("Roger Marí", "La Caída de los Gigantes");
      //MiembroPremium.insertMPLibroPrestadoSiExiste("Hedwig Potter", "Yo, Julia"); 
      
        
        //BORRO MIEMBRO PREMIUM

        //MiembroPremiumDAO.deleteMiembroPremium(8);
        //MiembroPremiumDAO.printMPDetails();
        
        
        
         System.out.println("AUTORES Y LIBROS:");
        
            //Lista de libros publicados por el autor ID 1
                //Detalles del autor ID 1
                    //AutorDAO.printOneAutorDetails(1);
                     Autor.imprimirListaLibrosAutor(1);
                           
                
                       
                
        System.out.println("");
        
        //Autor ID 2 - Libros
       
                 //Lista de libros publicados por el autor ID 2
                //Detalles del autor ID 2
                    AutorDAO.printOneAutorDetails(2);
                           
                //Libros publicados por el autor ID 2 (Se imprime en la consola)
                    AutorDAO.printAutorLibroDetails(2);       
                
        System.out.println("");
        
        //Autor ID 3 - Libros
          
             //Lista de libros publicados por el autor ID 3
                //Detalles del autor ID 3
                    AutorDAO.printOneAutorDetails(3);
                           
                //Libros publicados por el autor ID 3 (Se imprime en la consola)
                    AutorDAO.printAutorLibroDetails(3);       
                
        System.out.println("");
        
        //Autor ID 4 - Libros
            
            
            //Lista de libros publicados por el autor ID 4
                //Detalles del autor ID 4
                    AutorDAO.printOneAutorDetails(4);
                           
                //Libros publicados por el autor ID 4 (Se imprime en la consola)
                    AutorDAO.printAutorLibroDetails(4);
                    
        //Autor ID 6 - Libros
            
            //Lista de libros publicados por el autor ID 6
                //Detalles del autor ID 6
                    AutorDAO.printOneAutorDetails(6);
                           
                //Libros publicados por el autor ID 6 (Se imprime en la consola)
                    AutorDAO.printAutorLibroDetails(6); 
        
                    
                    System.out.println("----------");
        
        System.out.println("Lista de autores:");
        AutorDAO.printAutorDetails();
        
        System.out.println("Lista de libros:");
        LibroDAO.printLibroDetails();
        
        System.out.println("-----------------------------------------------------------------------------------");     
                 
  
        System.out.println("Nuevos usuarios:");
        //Creo nuevos Usuarios
           //UsuarioDAO.insertUsuario("Maria Giró", "usuario");
            System.out.println("");
        System.out.println("Nuevos miembros premium:");
        //Creo nuevos Miembros Premium
            //MiembroPremiumDAO.insertMP("Albert Castany", "miembro premium");
            
            
        System.out.println("----------");
        System.out.println("Lista de Usuarios:");
        UsuarioDAO.printUsuarioDetails();

        System.out.println("Lista de Miembros Premium:");
        MiembroPremiumDAO.printMPDetails();
        
        System.out.println("-----------------------------------------------------------------------------------");     
        
        //PRESTAMOS: 
        
      
        
        System.out.println("PRÉSTAMOS USUARIOS Y MIEMBROS PREMIUM:");
        //Un usuario o miembro premium toma prestado algún libro
            //UsuarioDAO.insertUsuarioLibroPrestado(7, "Hedwig Potter", 2, "El aliento de los Dioses"); //Se insertan los datos a la tabla Usuario-LibrosPrestados
            //LibroDAO.librosPrestados(false); //Convierte los libros prestados a disponibilidad false.
            //MiembroPremiumDAO.insertMPLibroPrestado(1, "Àlex Ramos", 12, "Mirall Trencat");
            //MiembroPremiumDAO.cambiarDisponibiliad("Mirall Trencat", false);
           
        //Inserto Usuario desde la clase Usuario y alquilo un libro:
            
            //Usuario.insertUsuarioLibroPrestadoSiExiste("Núria Marzo", "Roma soy yo");
            

           
            
    
            
        //Lista genérica de libros que se han prestado
            System.out.println(" Lista de libros prestados:");
            LibroDAO.printLibrosPrestados();
            
            
         //DEVOLUCIONES:    
      System.out.println("DEVOLUCIONES:");
        //Un usuario devuelve algún libro
                //UsuarioDAO.devolverLibroPrestado(3, "El aliento de los Dioses");
                //UsuarioDAO.cambiarDisponibiliad("El aliento de los Dioses", true);
            //UsuarioDAO.devolverLibroPrestado(4, "Elantris");
            //UsuarioDAO.cambiarDisponibiliad("Elantris", true);
            //UsuarioDAO.devolverLibroPrestado(6, "Marina");
            //UsuarioDAO.cambiarDisponibiliad("Marina", true);
            //UsuarioDAO.devolverLibroPrestado(7, "Los Pilares de la tierra");
             //UsuarioDAO.cambiarDisponibiliad("Los Pilares de la tierra", true);
            //UsuarioDAO.devolverLibroPrestado(8, "La Caída de los Gigantes");
            //UsuarioDAO.cambiarDisponibiliad("La Caída de los Gigantes", true);
            //MiembroPremiumDAO.devolverLibroPrestadoMP(12, "Mirall Trencat");
            //MiembroPremiumDAO.cambiarDisponibiliad("Mirall Trencat", true);
           //UsuarioDAO.devolverLibroPrestado(3, "El aliento de los Dioses");
            //LibroDAO.librosDevueltos(3, true);
                //UsuarioDAO.devolverLibroPrestado(4, "Elantris");
       //UsuarioDAO.cambiarDisponibiliad("Elantris", true);
            
        //Lista genérica de libros que se han prestado (no incluye los libros devueltos)
            //System.out.println("Lista de libros prestados ACTUALIZADA:");
            //LibroDAO.printLibrosPrestados();
            
            
             //RESERVAS:    
      //System.out.println("RESERVAS:");
        //Un usuario premium reserva algún libro
           //MiembroPremiumDAO.reservarLibro(1, "Hedwig Potter", 1, "Roma Soy Yo");
            //LibroDAO.librosDevueltos(3, true);
            
        //Lista genérica de libros que se han reservado 
            //System.out.println("Lista de libros reservados ACTUALIZADA:");
            //LibroDAO.printLibrosPrestados();
            
        
        System.out.println("-----------------------------------------------------------------------------------");
        
        System.out.println("-----------------------------------------------------------------------------------");
        
        
        
      /*
                
      
        //Miembro Premium reserva un libro no disponible
            //mp1 reserva un libro
            mp1.reservarLibro("Aloma");
            
                System.out.println("-----");
                //Imprimo la lista de libros reservados (para ver si se ha añadido)
                mp1.imprimirListaLibrosReservados();
                
                System.out.println("-----");
                //Imprimo la lista de libros prestados (para ver si se ha añadido)
                mp1.imprimirListaLibrosPrestados();
        
  
    */
       
    
     /*   
    //Aquí nos comprueba si un usuario está en nuestra base de datos usuarios normales, no premium
    System.out.println("Lista completa Usuarios");
     List<String> nombresUsuario = Usuario.getAllUsersName();
     
     String nombre = "Maya Moliner";
     if(Usuario.isUserInList(nombre)){
         System.out.println(nombre + " se encuentra en la lista de usuarios");
     }else{
         System.out.println("Lo lamentamos pero "+ nombre + " no se encuentra en la lista de usuarios");
     }
    
     
     //Aquí nos comprueba si un libro está en nuestra base de datos
     System.out.println("Lista completa Libros");
    
     List<String> nombresLibros = Libro.getAllLibrosName(); //de getAllLibrosName() irá a LibroDAO, hará su funcion y me lo devolverá
              System.out.println("Lista Libros");
  
       String titulo = "Roma soy yo";
     
     if(Libro.isLibroInLista(titulo)){
         System.out.println("Te informamos que el libro " + titulo + " se encuentra en nuestra biblioteca");
     }else{
         System.out.println("Lo lamentamos pero actualmente no tenemos el libro "+ titulo);*/
     
      
    
    
    
    
    
    
    
    }
     
    
   
  
 }
   
    
 
    
     
      
    


    
       
    
   




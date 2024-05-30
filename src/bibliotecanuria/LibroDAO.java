/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecanuria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author nuria
 */
public class LibroDAO {
    
    //Método para OBTENER Y MOSTRAR los detalles de todos los libros.
    public static void printLibroDetails(){
        String query = "SELECT * FROM Libro";
        try(Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)){
            
            while(rs.next()){
                int id_Libro = rs.getInt("id_Libro");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                boolean disponibilidad = rs.getBoolean("disponibilidad");
            
                System.out.println("  - Libro " + id_Libro + ": " + titulo + " de " + autor + " | Disponibilidad: " + disponibilidad);
            }
            
        }catch(SQLException e){
            System.out.println("Oh, oh... Error con el printAutorDetails.");
            e.printStackTrace(); //Ens tornaria el trazo del error, ens diu quin error hi ha al SQL.
        }
    }
    
    
    //MOSTRAR LIBROS PRESTADOS 
    public static void printLibrosPrestados(){
        //String query = "SELECT * FROM Libro WHERE disponibilidad = false;";
        String query = "SELECT ulp.nombre_Usuario, l.id_Libro, l.titulo, l.autor FROM Libro l INNER JOIN Usuario_LibrosPrestados ulp ON l.titulo = ulp.titulo WHERE ulp.titulo IS NOT NULL;";
        try(Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)){
            
            while(rs.next()){
                int id_Libro = rs.getInt("id_Libro");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                String nombre_Usuario = rs.getString("nombre_Usuario");
                //boolean disponibilidad = rs.getBoolean("disponibilidad");
            
                System.out.println("  - Libro " + id_Libro + ": " + titulo + " - En manos de " + nombre_Usuario);
            }
            
        }catch(SQLException e){
            System.out.println("Oh, oh... Error con el printLibrosPrestados.");
            e.printStackTrace(); //Ens tornaria el trazo del error, ens diu quin error hi ha al SQL.
        }
    }
    
    //Método para INSERTAR los detalles de todos los LIBROS.
    public static void insertLibro(String titulo, String autor, boolean disponibilidad){
        String query = "INSERT INTO Libro (titulo, autor, disponibilidad) VALUES (?, ?, ?);";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){
                pstmt.setString(1, titulo); // El número es la posició de l'atribut, el nom es el mateix que hem posat als parèntesis de dalt.
                pstmt.setString(2, autor);
                pstmt.setBoolean(3, disponibilidad);
                pstmt.executeUpdate();
                
                System.out.println(autor + " ha publicado " + titulo + ".");
                
        }catch(SQLException e){
            System.out.println("Oh, oh... Error con el insertLibro.");
            e.printStackTrace();
        }
    }
    
    //Método para ACTUALIZAR la disponibilidad de un LIBRO a FALSE o TRUE.
    public static void updateDispoLibro(boolean newDispo){
        String query = "UPDATE Libro SET disponibilidad = ?;";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){
                pstmt.setBoolean(1, newDispo); // El número es la posició de l'atribut (al primer INTERROGANT), el nom es el mateix que hem posat als parèntesis de dalt.
                //pstmt.setInt(2, id_Libro);
                pstmt.executeUpdate();
                
        }catch(SQLException e){
            System.out.println("Oh, oh... Error con el updateDispoLibro.");
            e.printStackTrace();
        }
    }
    
    //Método para ACTUALIZAR la disponibilidad de un LIBRO a FALSE.
    public static void librosPrestados(boolean newDispo){
        String query = "UPDATE Libro l INNER JOIN Usuario_LibrosPrestados ulp ON l.titulo = ulp.titulo SET l.disponibilidad = ? WHERE ulp.titulo IS NOT NULL;";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){
                pstmt.setBoolean(1, newDispo); // El número es la posició de l'atribut (al primer INTERROGANT), el nom es el mateix que hem posat als parèntesis de dalt.
                // pstmt.setInt(2, id_Usuario);
                //pstmt.setString(2, titulo);
                pstmt.executeUpdate();
                
                System.out.println("\n      [LOS LIBROS PRESTADOS QUEDAN NO DISPONIBLES]");
                //.\n  Te recordamos que tendrás que devolverlo en un plazo máximo de 30 días.\n  Puedes consultar todos tus préstamos en el apartado <<Préstamos>> de tu cuenta."); //imprimo información para ver en la terminal y...
                        
                
        }catch(SQLException e){
            System.out.println("Oh, oh... Error con el libroPrestado.");
            e.printStackTrace();
        }
    }
    
   
    
    //Método para ACTUALIZAR la disponibilidad de un LIBRO a FALSE o TRUE.
    public static void librosDevueltos(int id_Libro, boolean newDispo){
        String query = "UPDATE Libro SET disponibilidad = ? WHERE id_Libro = ?;";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){
                pstmt.setBoolean(1, newDispo); // El número es la posició de l'atribut (al primer INTERROGANT), el nom es el mateix que hem posat als parèntesis de dalt.
                pstmt.setInt(2, id_Libro);
                pstmt.executeUpdate();
                
                System.out.println("\n      [LOS LIBROS DEVUELTOS VUELVEN A ESTAR DISPONIBLES]");
                
        }catch(SQLException e){
           
            e.printStackTrace();
        }
    }
    
    //MÉTODO PARA RECIBIR TODOS LOS TITULOS DE LOS LIBROS
     public static List<String> getAllLibrosName(){
        List<String> librosName = new ArrayList<>();
        
        String query = "SELECT titulo from libro;";
        try(Connection conn = DatabaseConnection.getConnection();
              Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)){
            
            while(rs.next()){
                librosName.add(rs.getString("titulo"));
            }
                
         }catch(SQLException e){
           
            e.printStackTrace();
        }
        return librosName;
    }
    
 
    //MÉTODO PARA SABER LA DISPONIBILIDAD DE LOS LIBROS 
    
    public static boolean getDisponibilidad(String titulo){
        String query = "SELECT disponibilidad FROM libro where titulo = ?";
        boolean disponible = true;
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){
            
            pstmt.setString(1, titulo); //lo que quiero lanzar
            
            ResultSet rs = pstmt.executeQuery(); //lo que quiero que me devuelva
            
            while(rs.next()){
                disponible = rs.getBoolean("disponibilidad"); //esto es del campo que lo queremos 
                System.out.println("El libro " + titulo + " su disponibilidad es: "+ disponible);
            }            
            
        }catch(SQLException e){
            System.out.println("No se ha podido acceder a la disponibilidad de"+ titulo);
            e.printStackTrace();
        }
        
        return disponible;
    }
    
     //MÉTODO PARA CAMBIAR LA DISPONIBILIDAD DE LOS LIBROS 
    
    public static void cambiarDisponibiliad(String titulo, boolean dispo){
        String query = "UPDATE libro SET disponibilidad = ? WHERE titulo = ?; ";
        
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){
            
            pstmt.setBoolean(1, dispo);
            pstmt.setString(2, titulo);
            pstmt.executeUpdate();
            
            System.out.println("La disponibilidad del libro " + titulo + " es la siguiente: " + dispo);
              
        }catch(SQLException e){
            System.out.println("No se ha podido cambiar la disponibilidad.");
            e.printStackTrace();
        }  
        
       
    }
    
    //MÉTODO PARA BORRAR LIBRO
    
         public static void deleteLibro(int id, String name) { // Estos parámetros se utilizan para identificar el usuario que se va a eliminar de la base de datos.
    String query = "DELETE FROM Libro WHERE id_Libro = ? AND  titulo= ?;";
    try (Connection conn = DatabaseConnection.getConnection(); // Creamos la conexión con la base de datos 
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setInt(1, id);
        pstmt.setString(2, name);
        pstmt.executeUpdate();
        
        System.out.println("Se ha borrado el libro" + name + ". Ya no está disponible. Lo lamentamos ");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
         

    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecanuria;
import java.sql.*;
import java.util.*;

/**
 *
 * @author nuria
 */
public class AutorDAO {
     //Método para OBTENER Y MOSTRAR los detalles de todos los autores.
    public static void printAutorDetails(){
        String query = "SELECT * FROM Autor";
        try(Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)){
            
            while(rs.next()){
                int id_Autor = rs.getInt("id_Autor");
                String nombre_Autor = rs.getString("nombre_Autor");
                int anoNacimiento = rs.getInt("anoNacimiento");
                int anoMuerte = rs.getInt("anoMuerte");
                if (anoMuerte != 0) { 
                    System.out.println("  - Autor con ID " + id_Autor + " | " + nombre_Autor + " (" + anoNacimiento + "-" + anoMuerte + ")");
                }
                if(anoMuerte == 0){
                    System.out.println("  - Autor con ID " + id_Autor + " | " + nombre_Autor + " (" + anoNacimiento + "-)");
                }
            }
            
        }catch(SQLException e){
            System.out.println("Oh, oh... Error con el printAutorDetails.");
            e.printStackTrace(); //Ens tornaria el trazo del error, ens diu quin error hi ha al SQL.
        }
    }
    
    //Método para OBTENER Y MOSTRAR los detalles de UN autor.
    public static void printOneAutorDetails(int id_Autor){
        String query = "SELECT * FROM Autor WHERE id_Autor = ?;";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
                pstmt.setInt(1, id_Autor);// El número es la posició de l'atribut, el nom es el mateix que hem posat als parèntesis de dalt.
                ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                //int id_Autor = rs.getInt("id_Autor");
                String nombre_Autor = rs.getString("nombre_Autor");
                int anoNacimiento = rs.getInt("anoNacimiento");
                int anoMuerte = rs.getInt("anoMuerte");
                if (anoMuerte != 0) { 
                    System.out.println("(" + id_Autor + ") " + nombre_Autor + " (" + anoNacimiento + "-" + anoMuerte + "):");
                }
                if(anoMuerte == 0){
                    System.out.println("(" + id_Autor + ") " + nombre_Autor + " (" + anoNacimiento + "-):");
                }
            }
            
        }catch(SQLException e){
            System.out.println("Oh, oh... Error con el printOneAutorDetails.");
            e.printStackTrace(); //Ens tornaria el trazo del error, ens diu quin error hi ha al SQL.
        }
    }
    
    //Método para OBTENER Y MOSTRAR los detalles de los libros según autor.
    public static void printAutorLibroDetails(int id_Autor){
        String query = "SELECT l.id_Libro, l.titulo, l.disponibilidad FROM Libro l INNER JOIN Autor a ON l.autor = a.nombre_Autor WHERE a.id_Autor = ?;";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){
                pstmt.setInt(1, id_Autor);// El número es la posició de l'atribut, el nom es el mateix que hem posat als parèntesis de dalt.
                ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                int id_Libro = rs.getInt("l.id_Libro");
                String titulo = rs.getString("l.titulo");
                boolean disponibilidad = rs.getBoolean("disponibilidad");
                
                System.out.println("    - Libro " + id_Libro + ": " + titulo + " | Disponibilidad: " + disponibilidad);
            }
            
        }catch(SQLException e){
            System.out.println("Oh, oh... Error con el printAutorLibroDetails.");
            e.printStackTrace(); //Ens tornaria el trazo del error, ens diu quin error hi ha al SQL.
        }
    }
    
    //Método para INSERTAR los detalles de un AUTOR en concreto.
    public static void insertAutor(String nombre_Autor, int anoNacimiento, int anoMuerte){
        String query = "INSERT INTO Autor (nombre_Autor, anoNacimiento, anoMuerte) VALUES (?, ?, ?);";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){
                pstmt.setString(1, nombre_Autor); // El número es la posició de l'atribut, el nom es el mateix que hem posat als parèntesis de dalt.
                pstmt.setInt(2, anoNacimiento);
                pstmt.setInt(3, anoMuerte);
                pstmt.executeUpdate();
                
                System.out.println("¡Alguien ha querido enviarnos sus libros a nuestra biblioteca! ¿Conoces a " + nombre_Autor + "?");
                
        }catch(SQLException e){
            System.out.println("Oh, oh... Error con el insertAutor.");
            e.printStackTrace();
        }
    }
    
     public static void deleteAutor(int id, String name) { // Estos parámetros se utilizan para identificar el usuario que se va a eliminar de la base de datos.
    String query = "DELETE FROM Autor WHERE id_Autor = ? AND  nombre_Autor= ?;";
    try (Connection conn = DatabaseConnection.getConnection(); // Creamos la conexión con la base de datos 
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setInt(1, id);
        pstmt.setString(2, name);
        pstmt.executeUpdate();
        
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecanuria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nuria
 */
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/bibliotecanuria"; //url de la base de datos
    private static final String USER = "root"; //usuario de la base de datos
    private static final String PASSWORD = "Ironhack12!"; //contraseña de la base de datos 
    /**
     * Método para obterner una conexión a la base de datos
     *
    *@return Connection objeto de conexión a la base de datos
    * @throws SQLException si ocurre un error al establecer la conexión
    */
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
}
    
}

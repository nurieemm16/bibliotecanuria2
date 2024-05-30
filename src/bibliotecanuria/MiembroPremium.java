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

public class MiembroPremium extends Usuario {
    //Declaro los atributos como privados
        private List<Libro> listaLibrosReservados; //Creo una lista de libros reservados que a�adir� dentro de cada miembro premium.
    
    /*Creo el constructor p�blico para la clase Usuario y le paso los argumentos (atributos) 
    privados que he declarado anteriormente (ahora ser�n accesibles con el constructor)*/
        public MiembroPremium(String nombre_MP, String rol){
            super(nombre_MP, rol);
            this.listaLibrosReservados = new ArrayList<>(); //Inicializo la lista que se me crear� cada vez que cree un miembro premium.
            MiembroPremiumDAO.insertMP(nombre_MP, rol);
        }
        
    //Creo m�todos para coger el valor de los diferentes argumentos.     
        public List<Libro> getListaLibrosReservados(){ //M�todo para coger la lista de libros reservados (de cada miembro premium).
            return listaLibrosReservados;
        }
        
        public String getNombreMiembroPremium(){ //M�todo para coger el nombre de la clase padre (Usuario)
            return super.getNombreUsuario();
        }
    
    //Otros m�todos
        //El miembro Premium reserva un libro
        public void reservarLibro(String titulo){
            boolean libroExistenteC = false;
            
            for(Libro libroZ : Libro.getListaLibrosGenerica()){ //Con el FOR recorro la lista de libros generica, que se encuentra en la clase Libro
                if(libroZ.getTituloLibro().equals(titulo)){ //Si el t�tulo del libro (clase Libro) coincide con el titulo que le he pasado (a trav�s de la clase MiembroPremium)...
                    
                    libroExistenteC = true; //... le marco el boolean como TRUE y...
                    boolean dispoLibro = libroZ.getDisponibilidadLibro(); //... creo e inicializo una variable tipo boolean que referencia a (es la misma que) "disponibilidad" de la clase Libro (la cojo con el get);
                    
                    if(dispoLibro == false){ //si la disponibilidad del libro es FALSE,
                        System.out.println(this.getNombreMiembroPremium() + ", has reservado el libro " + libroZ.getTituloLibro() + " porque actualmente no est� disponible.\n  Cuando est� disponible te llegar� un mensaje al correo.\n  Puedes consultar todas tus reservas en el apartado <<Reservas>> de tu cuenta."); //imprimo que el libro no est� disponible y le digo que lo ha reservado...
                       
                        listaLibrosReservados.add(libroZ); //...a�ado el libro a la lista de libros reservados del Miembro Premium que ha reservado el libro.
                        
                        System.out.println(""); //Imprimo una l�nea en blanco.
                        
                    } else { //Si la disponibilidad del libro NO ES FALSE...
                        System.out.println(this.getNombreMiembroPremium() + ", el libro que quieres reservar (" + libroZ.getTituloLibro() + ") est� disponible, as� que...\n   �puedes ir a buscarlo cuando quieras!\n"); //...imprimo que el libro est� disponible y que lo puede tomar prestado.
                        super.cogerLibroPrestado(titulo); //Implementa el m�todo para coger un libro prestado (este m�todo est� en la clase Usuarios; ponemos super para que el programador que lea el c�digo pueda ver m�s f�cilmente que se trata de la clase padre de MiembroPremium).
                        
                    } break; //Paro el bucle FOR (cuando se encuentra un libro de la lista de libros gen�rica y ha implementado el resto de m�todos, ya no busca m�s).
                }
            }
            if (libroExistenteC == false){ //Una vez recorrida la lista de libros gen�rica, si el t�tulo del libro (clase Libro) no coincide con el t�tulo que le he pasado, le marco FALSE.
                System.out.println("No hemos encontrado el libro " + titulo); //Imprimimos que no hemos encontrado el libro con el t�tulo que le ha pasado el usuario.
            }
        }
        
        public List<Libro> imprimirListaLibrosReservados(){
            
            System.out.println("Lista de libros reservados de " + this.getNombreMiembroPremium() + ":");

            for(Libro libroP : listaLibrosReservados){ //Con el FOR recorro la lista de libros reservados, que se encuentra en la clase MiembroPremium (como es la clase donde estamos no le digo en qu� clase est�)
                System.out.println("    - " + libroP.getTituloLibro()); //Imprimo los libros reservados por el usuario.
            }
            System.out.println("");
            return listaLibrosReservados;
        }
        
        
                     public static void insertMPLibroPrestadoSiExiste(String nombre_MP, String titulo){            
            if(MiembroPremium.isMPInList(nombre_MP)){
                if(Libro.isLibroInLista(titulo)){
                    if (Libro.getDisponibilidad(titulo)){
                        MiembroPremiumDAO.insertMPLibroPrestadoSiExiste(nombre_MP, titulo);
                        LibroDAO.cambiarDisponibiliad(titulo, false);
                         System.out.println(nombre_MP+ "  has cogido prestado correctamente el libro " + titulo);
                    }else{ 
                        System.out.println("Lo lamentamos, pero el libro " + titulo + " no está disponible en estos momentos. Inténtalo de nuevo con otro libro.");
                    }
                    
                }else {
                    System.out.println("El libro " + titulo + " no está en nuestra base de datos. Inténtalo de nuevo con otro libro.");
                }
                
                
            }else{
                        System.out.println("El usuario premium " + nombre_MP + " no está en nuestra base de datos. Inténtalo de nuevo.");
                 
        
    } 
       } 
                     
                        public static List<String> getAllMPName(){
            return  MiembroPremiumDAO.getAllMPName();
        }
        
        
        public static boolean isMPInList(String nombre){
            List<String> userName = MiembroPremium.getAllMPName();
            return userName.contains(nombre); // si contiene el nombre TRUE si no lo tiene FALSE      
        }
}

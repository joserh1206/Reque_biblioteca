package code;

import java.util.ArrayList;

public class Usuario {
    private String id;
    private String nombre;
    private String apellido;
    private String saldo = "0.0";

    private ArrayList<Libro> libros_prestados = new ArrayList<>();
    public static ArrayList<Usuario> lista_usuarios = new ArrayList<>();

    private static Usuario error = new Usuario("0", "error", "");

    Usuario(String id, String nombre, String apellido){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public static Usuario buscar_usuario(String id){
        for (Usuario user : lista_usuarios) {
            if(user.id.equals(id)){
                return user;
            }
        }
        return error;
    }

    public Boolean buscar_libro_prestamo(Libro libro){
        if(libros_prestados.contains(libro)){
            return true;
        }
        return false;
    }

    public void prestamo(Libro libro){
        libros_prestados.add(libro);
        Libro.lista_prestamos.add(libro);
        libro.setDisponible(false);
        setSaldo(Float.valueOf(saldo)+100f);
    }

    public void devolucion(Libro libro){
        libros_prestados.remove(libro);
        Libro.lista_prestamos.remove(libro);
        libro.setDisponible(true);
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = String.valueOf(saldo);
    }

    public static void nuevo_usuario(Usuario usuario){
        lista_usuarios.add(usuario);
    }

    public String getApellido() {
        return apellido;
    }
}

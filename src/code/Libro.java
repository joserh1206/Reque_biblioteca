package code;

import java.util.ArrayList;

public class Libro {
    private String ISBN;
    private String nombre;
    private String autor;
    private String anio;
    private int cantidad;
    private String estado;

    public String getAutor() {
        return autor;
    }

    public String getAnio() {
        return anio;
    }

    public String getEditorial() {
        return editorial;
    }

    private String editorial;
    private Boolean disponible = true; //True -> disponible , False -> no disponible

    public static ArrayList<Libro> lista_libros = new ArrayList<>();
    public static ArrayList<Libro> lista_prestamos = new ArrayList<>();
    private static Libro error = new Libro("0", "error", "", "", "", 1);

    Libro(String ISBN, String nombre, String autor, String anio, String editorial, int cantidad){
        this.ISBN = ISBN;
        this.nombre = nombre;
        this.autor = autor;
        this.anio = anio;
        this.editorial = editorial;
        this.cantidad = cantidad;
    }

    public static Libro buscar_libro(String ISBN){
        for (Libro libro: lista_libros) {
            if(libro.ISBN.equals(ISBN)){
                return libro;
            }
        }
        return error;
    }

    public static Libro buscar_prestamo(String ISBN){
        for (Libro libro: lista_prestamos) {
            if(libro.ISBN.equals(ISBN)){
                return libro;
            }
        }
        return error;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
        if(disponible){
            estado = "Disponible";
        } else {
            estado = "En préstamo";
        }
    }

    static void nuevo_libro(Libro libro){
        lista_libros.add(libro);
        libro.estado = "Disponible";
    }

    public String getEstado() {
        return estado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

package ar.edu.unju.escmi.poo.ejercicio4.model;

public class Cliente {
    private String dni;
    private String nombre;
    private char categoria;

    public Cliente(String dni, String nombre, char categoria) {
        this.dni = dni;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public char getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Cliente [DNI: " + dni + ", Nombre: " + nombre + ", Categoría: " + categoria + "]";
    }
}

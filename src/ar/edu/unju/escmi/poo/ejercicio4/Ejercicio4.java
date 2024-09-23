package ar.edu.unju.escmi.poo.ejercicio4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import ar.edu.unju.escmi.poo.ejercicio4.model.Cliente;

public class Ejercicio4 {
    public static void main(String[] args) {
        HashMap<String, Cliente> clientes = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de opciones:");
            System.out.println("1 – Alta cliente");
            System.out.println("2 – Mostrar todos los clientes");
            System.out.println("3 – Eliminar cliente");
            System.out.println("4 – Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese DNI: ");
                    String dni = scanner.nextLine();
                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese categoría (una letra): ");
                    char categoria = scanner.nextLine().charAt(0);
                    String clave = dni + categoria;
                    Cliente nuevoCliente = new Cliente(dni, nombre, categoria);
                    clientes.put(clave, nuevoCliente);
                    System.out.println("Cliente agregado con clave: " + clave);
                    break;

                case 2:
                    System.out.println("Mostrando todos los clientes:");
                    Iterator<Map.Entry<String, Cliente>> iterator = clientes.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<String, Cliente> entry = iterator.next();
                        System.out.println("Clave: " + entry.getKey() + " -> " + entry.getValue());
                    }
                    break;

                case 3:
                    System.out.print("Ingrese la clave del cliente a eliminar: ");
                    String claveEliminar = scanner.nextLine();
                    if (clientes.containsKey(claveEliminar)) {
                        clientes.remove(claveEliminar);
                        System.out.println("Cliente eliminado.");
                    } else {
                        System.out.println("No se encontró un cliente con esa clave.");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del sistema.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 4);

        scanner.close();
    }
}


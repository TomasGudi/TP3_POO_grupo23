package ar.edu.unju.escmi.poo.ejercicio5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Producto> productos = new ArrayList<>();
        int opcion;

        do {
            System.out.println("Menú de opciones:");
            System.out.println("1 – Alta de producto");
            System.out.println("2 – Mostrar productos");
            System.out.println("3 – Incrementar precio de productos");
            System.out.println("4 – Ordenar productos");
            System.out.println("5 – Filtrar productos");
            System.out.println("6 – Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese código del producto: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.print("Ingrese descripción del producto: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Ingrese precio del producto: ");
                    double precio = scanner.nextDouble();
                    productos.add(new Producto(codigo, descripcion, precio));
                    break;

                case 2:
                    System.out.println("Lista de productos:");
                    productos.stream().forEach(System.out::println);
                    break;

                case 3:
                    productos = productos.stream()
                            .map(producto -> {
                                producto.setPrecio(producto.getPrecio() + 300.00);
                                return producto;
                            })
                            .collect(Collectors.toList());
                    System.out.println("Precios incrementados en 300.00");
                    break;

                case 4:
                    productos.stream()
                            .sorted(Comparator.comparingInt(Producto::getCodigo))
                            .forEach(System.out::println);
                    break;

                case 5:
                    System.out.print("Ingrese un código de producto para filtrar: ");
                    int codigoFiltro = scanner.nextInt();
                    productos.stream()
                            .filter(producto -> producto.getCodigo() > codigoFiltro)
                            .forEach(System.out::println);
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}
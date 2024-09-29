package ar.edu.unju.escmi.poo.ejercicio1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        ArrayList<Persona> personas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        int opcion;
        do {
            System.out.println("Menú de opciones:");
            System.out.println("1 – Crear objeto con Constructor por defecto.");
            System.out.println("2 – Crear objeto con Constructor parametrizado.");
            System.out.println("3 – Crear objeto con Constructor (dni, nombre, fecha de nacimiento).");
            System.out.println("4 – Mostrar personas.");
            System.out.println("5 - Salir.");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    // Constructor por defecto
                    Persona persona1 = new Persona();
                    System.out.print("Ingrese DNI: ");
                    persona1.setDni(scanner.nextLine());
                    System.out.print("Ingrese nombre: ");
                    persona1.setNombre(scanner.nextLine());
                    System.out.print("Ingrese fecha de nacimiento (dd/MM/yyyy): ");
                    persona1.setFechaNacimiento(LocalDate.parse(scanner.nextLine(), formatter));
                    System.out.print("Ingrese domicilio: ");
                    persona1.setDomicilio(scanner.nextLine());
                    System.out.print("Ingrese provincia: ");
                    persona1.setProvincia(scanner.nextLine());
                    personas.add(persona1);
                    break;

                case 2:
                    // Constructor parametrizado
                    System.out.print("Ingrese DNI: ");
                    String dni = scanner.nextLine();
                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese fecha de nacimiento (dd/MM/yyyy): ");
                    LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine(), formatter);
                    System.out.print("Ingrese domicilio: ");
                    String domicilio = scanner.nextLine();
                    System.out.print("Ingrese provincia: ");
                    String provincia = scanner.nextLine();
                    Persona persona2 = new Persona(dni, nombre, fechaNacimiento, domicilio, provincia);
                    personas.add(persona2);
                    break;

                case 3:
                    // Constructor dni, nombre, fecha de nacimiento
                    System.out.print("Ingrese DNI: ");
                    String dni2 = scanner.nextLine();
                    System.out.print("Ingrese nombre: ");
                    String nombre2 = scanner.nextLine();
                    System.out.print("Ingrese fecha de nacimiento (dd/MM/yyyy): ");
                    LocalDate fechaNacimiento2 = LocalDate.parse(scanner.nextLine(), formatter);
                    Persona persona3 = new Persona(dni2, nombre2, fechaNacimiento2);
                    personas.add(persona3);
                    break;

                case 4:
                    // Mostrar personas
                    if (personas.isEmpty()) {
                        System.out.println("No hay personas para mostrar.");
                    } else {
                        for (Persona persona : personas) {
                            persona.mostrarDatos();
                            System.out.println("-----------------------------");
                        }
                    }
                    break;

                case 5:
                    // Salir
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
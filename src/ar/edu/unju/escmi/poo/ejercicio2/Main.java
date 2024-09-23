package ar.edu.unju.escmi.poo.ejercicio2;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		TreeSet<GatoSimple> gatos = new TreeSet<>();
		int opcion = 0;

		while (opcion != 6) {
			System.out.println("---MENU---");
			System.out.println("1 – Crear gato simple");
			System.out.println("2 – Dar de comer a un gato simple");
			System.out.println("3 – Eliminar un gato simple");
			System.out.println("4 – Mostrar todos los gatos");
			System.out.println("5 – Crear gato contrincante para pelear");
			System.out.println("6 – Salir\n");
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				System.out.println("---Crear Gato---");
				System.out.println("Ingrese nombre del gato: ");
				String nombre = sc.nextLine();
				
				System.out.println("Ingrese color del gato: ");
				String color = sc.nextLine();
				
				System.out.println("Ingrese peso del gato(Kg): ");
				double peso = sc.nextDouble();
				sc.nextLine();
				
				System.out.println("Ingrese raza del gato: ");
				String raza = sc.nextLine();
				
				System.out.println("Ingrese edad del gato (Año): ");
				int edad = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Ingrese sexo del gato (macho/hembra): ");
				String sexo = sc.nextLine();
				
				
				GatoSimple gato = new GatoSimple(nombre, color, peso, raza, edad, sexo);
				gatos.add(gato);
				break;

			case 2:
				System.out.println("Ingrese nombre del gato para alimentar: ");
				String gatoElejido = sc.nextLine();
				
				GatoSimple gatoParaComer = gatos.stream()
						.filter(g -> g.compareTo(new GatoSimple(gatoElejido, "", 0, "", 0, "")) == 0).findFirst()
						.orElse(null);
				
				if (gatoParaComer != null) {
					System.out.println("Ingrese comida: ");
					String comida = sc.nextLine();
					gatoParaComer.comer(comida);
				} else {
					System.out.println("No se pudo encontrar el gato ingresado.");
				}
				break;

			case 3:
				System.out.println("Ingrese nombre del gato para eliminar: ");
				String nombreParaEliminar = sc.nextLine();
				
				GatoSimple gatoParaEliminar = gatos.stream()
						.filter(g -> g.compareTo(new GatoSimple(nombreParaEliminar, "", 0, "", 0, "")) == 0).findFirst()
						.orElse(null);
				
				if (gatoParaEliminar != null) {
					gatos.remove(gatoParaEliminar);
					System.out.println("Gato eliminado correctamente.");
				} else {
					System.out.println("No se pudo encontrar el gato ingresado.");
				}
				break;

			case 4:
				System.out.println("---Gatos Creados---");
				if (!gatos.isEmpty()) {
					gatos.forEach(GatoSimple::mostrarGatos);
				} else {
					System.out.println("Aun no hay gatos registrados.");
				}
				break;

			case 5:
				System.out.println("---Crear Gato Contricante Para Pelear---");
				System.out.println("Ingrese nombre del gato: ");
				String nombreContricante = sc.nextLine();
				
				System.out.println("Ingrese color del gato: ");
				String colorContricante = sc.nextLine();
				
				System.out.println("Ingrese peso del gato(Kg): ");
				double pesoContricante = sc.nextDouble();
				sc.nextLine();
				
				System.out.println("Ingrese raza del gato: ");
				String razaContricante = sc.nextLine();
				
				System.out.println("Ingrese edad del gato (Año): ");
				int edadContricante = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Ingrese sexo del gato (macho/hembra): ");
				String sexoContricante = sc.nextLine();
				
				
				GatoSimple gatoContricante = new GatoSimple(nombreContricante, colorContricante, pesoContricante, razaContricante, edadContricante, sexoContricante);
				gatos.add(gatoContricante);

				System.out.println("Ingrese nombre del gato ya creado con el que peleara: ");
				String nombreParaPelear = sc.nextLine();
				GatoSimple gatoParaPelear = gatos.stream()
						.filter(g -> g.compareTo(new GatoSimple(nombreParaPelear, "", 0, "", 0, "")) == 0).findFirst()
						.orElse(null);
				if (gatoParaPelear != null) {
					gatoParaPelear.pelear(gatoContricante);
				} else {
					System.out.println("No se encontró el gato.");
				}
				break;

			case 6:
				System.out.println("Saliendo...");
				break;

			default:
				System.out.println("Opción inválida.");
			}
			System.out.println();
		}

		sc.close();
	}

}

package ar.edu.unju.escmi.poo.ejercicio3;

import java.util.HashSet;
import java.util.Scanner;

import ar.edu.unju.escmi.poo.ejercicio3.model.*;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<Empleado> empleados = new HashSet<>();
		int op;

		do {
			System.out.println("\n***** Menu *****");
			System.out.println("1- Crear empleado");
			System.out.println("2- Aumentar Salario");
			System.out.println("3- Mostrar la suma total de todos los salarios.");
			System.out.println("4- Mostrar todos los empleados.");
			System.out.println("5- Salir.");
			System.out.print("Elija una opcion: ");
			op = sc.nextInt();

			switch (op) {
			case 1:
				System.out.print("Ingrese el nombre del empleado: ");
				String nombre = sc.next();
				System.out.print("Ingrese el legajo del empleado: ");
				int legajo = sc.nextInt();
				System.out.print("Ingrese el salario del empleado: ");
				double salario = sc.nextDouble();

				Empleado nuevoEmpleado = new Empleado(nombre, legajo, salario);
				empleados.add(nuevoEmpleado);
				break;
			case 2:
				System.out.print("Ingrese el legajo del empleado que recibirá el aumento: ");
				int aux = sc.nextInt();
				boolean flag = false;

				for (Empleado emp : empleados) {
					if (emp.getLegajo() == aux) {
						emp.aumentarSalario();
						flag = true;
						break;
					}
				}

				if (!flag) {
					System.out.println("Empleado no encontrado o no existe");
				}
				break;
			case 3:
				double sumaTotal = 0;
				for (Empleado emp : empleados) {
					sumaTotal += emp.getSalario();
				}
				System.out.printf("La suma total de los salarios es: %.2f\n", sumaTotal);
				break;
			case 4:
				if (empleados.isEmpty()) {
					System.out.println("No hay empleados registrados.");
				} else {
					for (Empleado emp : empleados) {
						emp.mostrarDatos();
						System.out.println("*****************");
					}
				}
				break;
			case 5:
				System.out.println("Cerrando el programa...");
				break;
			default:
				System.out.println("Error");
				break;
			}
		} while (op != 5);
		sc.close();
	}
}


package ar.edu.unju.escmi.poo.ejercicio2;

import java.util.Scanner;
import java.util.TreeSet;

public class GatoSimple implements Comparable<GatoSimple> {
	private String nombre;
	private String color;
	private double peso;
	private String raza;
	private int edad;
	private String sexo;

	public GatoSimple(String nombre, String color, double peso, String raza, int edad, String sexo) {
		this.nombre = nombre;
		this.color = color;
		this.peso = peso;
		this.raza = raza;
		this.edad = edad;
		this.sexo = sexo;
	}

	// Metodos asociados a los gatos
	public void maullar() {
		System.out.println("Miauu");
	}

	public void ronronear() {
		System.out.println("Prrrr");
	}

	public void comer(String comida) {
		if (comida.equalsIgnoreCase("pescado")) {
			System.out.println("Que rico ¡Gracias!!");
		} else {
			System.out.println("Lo siento, yo solo como pescado");
		}
	}

	public void pelear(GatoSimple gatoContrincante) {
		if (this.sexo.equalsIgnoreCase("hembra")) {
			System.out.println("No me gusta pelear");
		} else 
			if (this.sexo.equalsIgnoreCase("macho")) {
			if (gatoContrincante.sexo.equalsIgnoreCase("hembra")) {
				System.out.println("No peleo contra gatitas");
			} else {
				System.out.println("¡Ven aquí que te vas a enterar!");
			}
		}
	}

	// Método para mantener ordenado por nombres
	@Override
	public int compareTo(GatoSimple otroGato) {
		return this.nombre.compareTo(otroGato.nombre);
	}

	public void mostrarGatos() {
		System.out.println("Nombre: " + nombre);
		System.out.println("Color: " + color);
		System.out.println("Peso(Kg): " + peso);
		System.out.println("Raza: " + raza);
		System.out.println("Edad(Año): " + edad);
		System.out.println("Sexo: " + sexo);
		maullar();
		ronronear();
	}

}

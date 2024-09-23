package ar.edu.unju.escmi.poo.ejercicio3.model;

public class Empleado {
    private String nombre;
    private int legajo;
    private double salario;

    public static final double SALARIO_MINIMO = 300000.00;
    public static final double AUMENTO_POR_MERITOS = 10000.00;

    public Empleado(String nombre, int legajo, double salario) {
        this.nombre = nombre;
        this.legajo = legajo;
        if (salario >= SALARIO_MINIMO) {
            this.salario = salario;
        } else {
            this.salario = SALARIO_MINIMO;
        }
    }

//  @Override
//	public String toString() {
//		return "Empleado [nombre=" + nombre + ", legajo=" + legajo + ", salario=" + salario + "]";
//	}

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Legajo: " + legajo);
        System.out.printf("Salario $: %.2f\n", salario);
    }
    
	public void aumentarSalario() {
        this.salario += AUMENTO_POR_MERITOS;
        System.out.println("Salario aumentado en " + AUMENTO_POR_MERITOS + ". Nuevo salario: " + this.salario);
    }

    public int getLegajo() {
        return legajo;
    }

    public double getSalario() {
        return salario;
    }
}

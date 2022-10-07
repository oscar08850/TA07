package TA07;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {

		// Declaramos las variables
		Hashtable<String, Double> listaNotas = new Hashtable<String, Double>();

		dameNumeroAlumnos(listaNotas);
		mostrarLista(listaNotas);

	}

	private static void mostrarLista(Hashtable<String, Double> listaNotas) {
		Enumeration<String> e = listaNotas.keys();
		Enumeration<Double> i = listaNotas.elements();

		// Para cada elemento mostraremos su clave(Nombre alumno) y su elemento (la nota
		// media)
		while (e.hasMoreElements())
			System.out.println("Alumno: " + e.nextElement() + ". Nota media: " + i.nextElement());

	}

	private static void dameNumeroAlumnos(Hashtable<String, Double> listaNotas) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Dame el numero de alumnos: ");
		int alumnos = Integer.parseInt(scanner.next());
		int nota;
		double sumaNotas = 0;
		String nombreAlumno = "";
		for (int i = 0; i < alumnos; i++) {
			System.out.print("Dame el nombre del alumno: ");
			nombreAlumno = scanner.next();
			for (int j = 0; j < 4; j++) {
				System.out.print("Dame la nota de la asignatura numero " + (j + 1) + ": ");
				nota = Integer.parseInt(scanner.next());
				sumaNotas = sumaNotas + nota;
			}

			listaNotas.put(nombreAlumno, sumaNotas / 4);
			sumaNotas = 0;
		}
		scanner.close();

	}
}

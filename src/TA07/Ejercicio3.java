package TA07;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {

		// En listaObjeto tendremos la lista de articulos de la tienda.
		Hashtable<String, ArrayList<Double>> ListaObjetos = new Hashtable<String, ArrayList<Double>>();
		Scanner scanner = new Scanner(System.in);
		String menu = "", busqueda = "";
		llenarInventario(ListaObjetos);
		boolean seguir = true;
		while (seguir) {
			System.out.println("1. Listar productos.");
			System.out.println("2. Añadir productos.");
			System.out.println("3. Buscar productos.");
			menu = scanner.next();
			System.out.println();
			switch (menu) {
			case "1":
				mostrarInventarioAlUsuario(ListaObjetos);

				break;

			case "2":
				añadirArticulo(ListaObjetos);
				break;

			case "3":
				System.out.println("Que articulo quieres buscar? ");
				busqueda = scanner.next();
				buscarArticulo(ListaObjetos, busqueda);
				break;

			default:
				seguir = !seguir;
				break;
			}
		}
		System.out.println("Bye bye!");

	}

	private static void buscarArticulo(Hashtable<String, ArrayList<Double>> listaObjetos, String busqueda) {
		listaObjetos.forEach((key, value) -> {
			if(key.equals(busqueda)) {
				System.out.println(key + ": precio = " + value.get(0) + ", cantidad = " + value.get(1));
			}
		});

		
	}

	private static void añadirArticulo(Hashtable<String, ArrayList<Double>> listaObjetos) {
		Scanner scanner = new Scanner(System.in);
		String nombreObjeto;
		double precio, IVA, cantidad;
		System.out.println("Dame nombre: ");
		nombreObjeto = scanner.next();
		System.out.println("Dame precio: ");
		precio = scanner.nextDouble();
		System.out.println("Dame IVA: ");
		IVA = scanner.nextDouble();
		System.out.println("Dame cantidad: ");
		cantidad = scanner.nextDouble();
		ArrayList<Double> articulo1 = new ArrayList<>();
		articulo1.add(precio);
		articulo1.add(IVA);
		articulo1.add(cantidad);
		listaObjetos.put(nombreObjeto, articulo1);

	}

	private static void mostrarInventarioAlUsuario(Hashtable<String, ArrayList<Double>> listaObjetos) {
		Enumeration<String> e = listaObjetos.keys();
		Enumeration<ArrayList<Double>> i = listaObjetos.elements();
		Enumeration<ArrayList<Double>> auxIVA = listaObjetos.elements();

		System.out.println("/// Productos de la tienda: ///");
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement() + ": Precio: " + (i.nextElement().get(0)) + ". IVA: "
					+ auxIVA.nextElement().get(1));// Muestra el nombre del elemento //Muestra el precio y el IVA
		}
		System.out.println("................................................");

//		while (e.hasMoreElements())
		// System.out.println("Articulo: " + e.nextElement() + ". Precio: " + i.ne;

	}

	private static void llenarInventario(Hashtable<String, ArrayList<Double>> listaObjetos) {

		/*
		 * Manzanas [1,4,0] Peras [2,4,0]
		 */

		// Precio bruto, IVA, cantidad //Inicilizamos la cantidad a 0.
		ArrayList<Double> articulo1 = new ArrayList<>();
		articulo1.add(1.0);
		articulo1.add(4.0);
		articulo1.add(10.0);
		listaObjetos.put("manzanas", articulo1);

		ArrayList<Double> articulo2 = new ArrayList<>();
		articulo2.add(2.0);
		articulo2.add(4.0);
		articulo2.add(4.0);
		listaObjetos.put("peras", articulo2);

		ArrayList<Double> articulo3 = new ArrayList<>();
		articulo3.add(5.0);
		articulo3.add(4.0);
		articulo3.add(6.0);
		listaObjetos.put("libros", articulo3);

		ArrayList<Double> articulo4 = new ArrayList<>();
		articulo4.add(10.0);
		articulo4.add(21.0);
		articulo4.add(4.0);
		listaObjetos.put("vasos", articulo4);

		ArrayList<Double> articulo5 = new ArrayList<>();
		articulo5.add(12.0);
		articulo5.add(21.0);
		articulo5.add(14.0);
		listaObjetos.put("platos", articulo5);

		ArrayList<Double> articulo6 = new ArrayList<>();
		articulo6.add(10.0);
		articulo6.add(21.0);
		articulo6.add(19.0);
		listaObjetos.put("cubiertos", articulo6);

		ArrayList<Double> articulo7 = new ArrayList<>();
		articulo7.add(100.0);
		articulo7.add(21.0);
		articulo7.add(20.0);
		listaObjetos.put("mesa", articulo7);

		ArrayList<Double> articulo8 = new ArrayList<>();
		articulo8.add(25.0);
		articulo8.add(21.0);
		articulo8.add(30.0);
		listaObjetos.put("silla", articulo8);

		ArrayList<Double> articulo9 = new ArrayList<>();
		articulo9.add(400.0);
		articulo9.add(21.0);
		articulo9.add(10.0);
		listaObjetos.put("iPad", articulo9);

		ArrayList<Double> articulo10 = new ArrayList<>();
		articulo10.add(700.0);
		articulo10.add(21.0);
		articulo10.add(40.0);
		listaObjetos.put("televisor", articulo10);
	}
}
package TA07;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {

		// En listaObjeto tendremos la lista de articulos de la tienda.
		Hashtable<String, ArrayList<Double>> ListaObjetos = new Hashtable<String, ArrayList<Double>>();

		llenarInventario(ListaObjetos);

		mostrarInventarioAlUsuario(ListaObjetos);

		hacerLaCompra(ListaObjetos);

	}

	private static void hacerLaCompra(Hashtable<String, ArrayList<Double>> listaObjetos) {
		boolean seguir = true;
		String comanda = "";
		double precioTotalSinIVA = 0;
		double precioTotalConIVA = 0;
		Scanner scanner = new Scanner(System.in);
		while (seguir) {
			System.out.println("Que quieres comprar? finaliza con el comando 'finalizar' ");
			comanda = scanner.next();
			switch (comanda) {
			case "Polystation":
				ArrayList<Double> Array1 = listaObjetos.get(comanda);

				Array1.set(2, Array1.get(2) + 1); // Me coges el tercer parametro que es cantidad, y le sumas 1 a la
													// cantidad que hubiese.

				precioTotalSinIVA = precioTotalSinIVA + Array1.get(0); // primera posicion esta el precio bruto
				precioTotalConIVA = precioTotalConIVA + (Array1.get(0) + (Array1.get(0) * (Array1.get(1) / 100)));

				System.out.println("Polystation añadida correctamente");
				break;
			case "PZ3":
				ArrayList<Double> Array2 = listaObjetos.get(comanda);

				Array2.set(2, Array2.get(2) + 1); // Me coges el tercer parametro que es cantidad, y le sumas 1 a la
													// cantidad que hubiese.

				precioTotalSinIVA = precioTotalSinIVA + Array2.get(0); // primera posicion esta el precio bruto
				precioTotalConIVA = precioTotalConIVA + (Array2.get(0) + (Array2.get(0) * (Array2.get(1) / 100)));

				System.out.println("PZ3 añadida correctamente");

				break;
			case "XGAME360":

				ArrayList<Double> Array3 = listaObjetos.get(comanda);

				Array3.set(2, Array3.get(2) + 1); // Me coges el tercer parametro que es cantidad, y le sumas 1 a la
													// cantidad que hubiese.

				precioTotalSinIVA = precioTotalSinIVA + Array3.get(0); // primera posicion esta el precio bruto
				precioTotalConIVA = precioTotalConIVA + (Array3.get(0) + (Array3.get(0) * (Array3.get(1) / 100)));

				System.out.println("XGAME360 añadida correctamente");

				break;
			case "TreamCast":

				ArrayList<Double> Array4 = listaObjetos.get(comanda);

				Array4.set(2, Array4.get(2) + 1); // Me coges el tercer parametro que es cantidad, y le sumas 1 a la
													// cantidad que hubiese.

				precioTotalSinIVA = precioTotalSinIVA + Array4.get(0); // primera posicion esta el precio bruto
				precioTotalConIVA = precioTotalConIVA + (Array4.get(0) + (Array4.get(0) * (Array4.get(1) / 100)));

				System.out.println("TreamCast añadida correctamente");

				break;
			case "finalizar":
				seguir = false;
				break;

			default:
				break;
			}

		}

		System.out.println("La lista de la compra es: ");
		System.out.println();
		listaObjetos.forEach((key, value) -> {

			if (value.get(2) > 0) { // No me muestres valores vacios
				System.out.println("Producto: " + key);
				System.out.println("IVA producto:" + value.get(1));
				System.out.println("Precio sin IVA: " + value.get(0));
				System.out.println("Precio con IVA: " + (value.get(0) + (value.get(0) * (value.get(1) / 100))));
				System.out.println("Cantidad comprada: " + value.get(2) + "\n");
			}
		});
		
		System.out.println("La factura asciende a: ");
		System.out.println("Precio bruto: " + precioTotalSinIVA);
		System.out.println("Precio neto: " + precioTotalConIVA);


		System.out.print("Introduzca dinero: ");
		double dineroAPagar = Double.parseDouble(scanner.next());
		
		System.out.print("Aquí tiene su cambio: " + (dineroAPagar - precioTotalConIVA));
		

	}

	private static void mostrarInventarioAlUsuario(Hashtable<String, ArrayList<Double>> listaObjetos) {
		Enumeration<String> e = listaObjetos.keys();
		Enumeration<ArrayList<Double>> i = listaObjetos.elements();
		Enumeration<ArrayList<Double>> auxIVA = listaObjetos.elements();

		System.out.println("/// Productos de la tienda: ///");
		while (e.hasMoreElements()) {
			System.out.println("Nombre del producto: " + e.nextElement());
			System.out
					.println(" Precio: " + (i.nextElement().get(0)) + ". El IVA es de: " + auxIVA.nextElement().get(1));
		}
		System.out.println("................................................");

//		while (e.hasMoreElements())
		// System.out.println("Articulo: " + e.nextElement() + ". Precio: " + i.ne;

	}

	private static void llenarInventario(Hashtable<String, ArrayList<Double>> listaObjetos) {

		// Precio bruto, IVA, cantidad //Inicilizamos la cantidad a 0.
		ArrayList<Double> articulo1 = new ArrayList<>();
		articulo1.add(49.0);
		articulo1.add(21.0);
		articulo1.add(0.0);
		listaObjetos.put("Polystation", articulo1);

		ArrayList<Double> articulo2 = new ArrayList<>();
		articulo2.add(79.0);
		articulo2.add(21.0);
		articulo2.add(0.0);
		listaObjetos.put("PZ3", articulo2);

		ArrayList<Double> articulo3 = new ArrayList<>();
		articulo3.add(69.0);
		articulo3.add(21.0);
		articulo3.add(0.0);
		listaObjetos.put("XGAME360", articulo3);

		ArrayList<Double> articulo4 = new ArrayList<>();
		articulo4.add(29.0);
		articulo4.add(4.0);
		articulo4.add(0.0);
		listaObjetos.put("TreamCast", articulo4);
	}
}
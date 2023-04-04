package com.funciones;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.clases.Partido;
import com.clases.Pronostico;

public class Mostrar {
	public static void partido(ArrayList<Partido> listaPartidos) {
		for (int i = 0; i < listaPartidos.size(); i++) {
			// Por consola
			System.out.println(
					listaPartidos.get(i).getEquipo1().getNombre() +
							" " +
							listaPartidos.get(i).getGolesEquipo1() +
							" " +
							listaPartidos.get(i).getEquipo2().getNombre() +
							" " +
							listaPartidos.get(i).getGolesEquipo2());

			// Por ventana
			JOptionPane.showMessageDialog(
					null,
					"Partido: " + (i + 1) + "\n" +
							listaPartidos.get(i).getEquipo1().getNombre() +
							" " +
							listaPartidos.get(i).getGolesEquipo1() +
							" " +
							listaPartidos.get(i).getEquipo2().getNombre() +
							" " +
							listaPartidos.get(i).getGolesEquipo2());
		}
	}

	public static void pronostico(ArrayList<Pronostico> listaPronosticos) {
		for (int i = 0; i < listaPronosticos.size(); i++) {
			// Por consola
			System.out.println(
					listaPronosticos.get(i).getEquipo1().getNombre() +
							" " +
							listaPronosticos.get(i).getResultado() + " " +
							listaPronosticos.get(i).getEquipo2().getNombre());

			// Por ventana
			JOptionPane.showMessageDialog(
					null,
					listaPronosticos.get(i).getEquipo1().getNombre() +
							" " +
							listaPronosticos.get(i).getResultado() + " " +
							listaPronosticos.get(i).getEquipo2().getNombre());
		}
	}

	public static void puntos(ArrayList<Partido> listaPartidos, ArrayList<Pronostico> listaPronosticos) {
		// unsolved

		// int puntos = 0;
		// for (int i = 0; i < listaPartidos.size(); i++) {
		// for (int j = 0; j < listaPronosticos.size(); j++) {
		// if (listaPartidos.get(i).getEquipo1().getNombre()
		// .equals(listaPronosticos.get(j).getEquipo1().getNombre())
		// && listaPartidos.get(i).getEquipo2().getNombre()
		// .equals(listaPronosticos.get(j).getEquipo2().getNombre())) {

		// // Por consola
		// System.out.println("Partido: " +
		// listaPartidos.get(i).getEquipo1().getNombre() + " vs "
		// + listaPartidos.get(i).getEquipo2().getNombre());

		// // def pronostico
		// ResultadoEnum pronostico = listaPronosticos.get(j).getResultado();

		// // def resultado
		// ResultadoEnum resultado = listaPartidos.get(i).resultado();

		// // def puntos
		// if (pronostico == resultado) {
		// puntos += 3;
		// } else if (pronostico == ResultadoEnum.EMPATE && resultado ==
		// ResultadoEnum.EMPATE) {
		// puntos += 1;
		// }

		// // Por consola
		// System.out.println("Pronostico: " + pronostico);
		// System.out.println("Resultado: " + resultado);
		// System.out.println("Puntos: " + puntos);
		// }
		// }
		// }

	}

	public static void resultado(ArrayList<Partido> listaPartidos, ArrayList<Pronostico> listaPronosticos) {
		int puntos = 0;
		for (int i = 0; i < listaPartidos.size(); i++) {
			for (int j = 0; j < listaPronosticos.size(); j++) {
				if (listaPartidos.get(i).getEquipo1().getNombre()
						.equals(listaPronosticos.get(j).getEquipo1().getNombre())
						&& listaPartidos.get(i).getEquipo2().getNombre()
								.equals(listaPronosticos.get(j).getEquipo2()
										.getNombre())) {

					// Por consola
					System.out.println("Partido: " + listaPartidos.get(i).getEquipo1().getNombre()
							+ " vs "
							+ listaPartidos.get(i).getEquipo2().getNombre());

					System.out.println("Pronostico: " + listaPronosticos.get(j).pronostico());

					System.out.println(
							"Resultado: " + listaPartidos.get(i).getGolesEquipo1() + " "
									+ listaPartidos.get(i).getGolesEquipo2());
					System.out.println(
							"Puntos: " + listaPronosticos.get(j).calcularPuntos(
									listaPartidos.get(i).getGolesEquipo1(),
									listaPartidos.get(i).getGolesEquipo2()));
					puntos += listaPronosticos.get(j).calcularPuntos(
							listaPartidos.get(i).getGolesEquipo1(),
							listaPartidos.get(i).getGolesEquipo2());

					// Por ventana
					JOptionPane.showMessageDialog(
							null,
							"Partido: " + listaPartidos.get(i).getEquipo1().getNombre()
									+ " vs "
									+ listaPartidos.get(i).getEquipo2().getNombre()
									+ " \nPronostico: "
									+ listaPronosticos.get(j).pronostico() +
									"\nResultado: "
									+ listaPartidos.get(i).getGolesEquipo1() + " "
									+ listaPartidos.get(i).getGolesEquipo2()
									+ "\nPuntos: "
									+ listaPronosticos.get(j).calcularPuntos(
											listaPartidos.get(i)
													.getGolesEquipo1(),
											listaPartidos.get(i)
													.getGolesEquipo2()));

				}
			}
		}

		// Mostrar Puntos Totales
		System.out.println("Puntos totales en esta Ronda: " + puntos);
		JOptionPane.showMessageDialog(null, "Puntos totales en esta Ronda: " + puntos);
	}

}

package org.douglasalvarado.main;

import org.douglasalvarado.clase.AdministradorArchivos;
import org.douglasalvarado.clase.CargaDatosException;
import org.douglasalvarado.clase.GuardarDatosException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AdministradorArchivos adminArchivos = new AdministradorArchivos();
        Scanner scanner = new Scanner(System.in);
        String rutaArchivo = "inventario.txt"; // Ruta del archivo de inventario

        while (true) {
            System.out.println("\n--- Sistema de Inventario de Tienda de Barrio ---");
            System.out.println("1. Leer inventario");
            System.out.println("2. Agregar al inventario");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    // Leer el inventario desde el archivo
                    try {
                        String datos = adminArchivos.leerArchivo(rutaArchivo);
                        System.out.println("\n--- Inventario Actual ---\n" + datos);
                    } catch (CargaDatosException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    // Agregar datos al inventario y guardarlos en el archivo
                    System.out.print("Ingrese los datos del inventario a agregar: ");
                    String nuevosDatos = scanner.nextLine();
                    try {
                        adminArchivos.escribirArchivo(rutaArchivo, nuevosDatos);
                        System.out.println("Datos agregados exitosamente.");
                    } catch (GuardarDatosException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    // Salir del programa
                    System.out.println("Saliendo del sistema...");
                    return;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
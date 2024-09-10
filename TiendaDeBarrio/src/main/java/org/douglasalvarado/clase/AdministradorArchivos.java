package org.douglasalvarado.clase;

import java.io.*;

public class AdministradorArchivos {

    // Método para leer datos del archivo de inventario
    public String leerArchivo(String rutaArchivo) throws CargaDatosException {
        StringBuilder datos = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                datos.append(linea).append("\n");
            }
        } catch (IOException e) {
            throw new CargaDatosException("Error al cargar los datos del archivo: " + e.getMessage());
        }
        return datos.toString();
    }

    // Método para escribir datos en el archivo de inventario
    public void escribirArchivo(String rutaArchivo, String datos) throws GuardarDatosException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            bw.write(datos);
        } catch (IOException e) {
            throw new GuardarDatosException("Error al guardar los datos en el archivo: " + e.getMessage());
        }
    }
}


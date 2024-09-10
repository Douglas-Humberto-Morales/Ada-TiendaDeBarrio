package org.douglasalvarado.clase;

import org.douglasalvarado.clase.AdministradorArchivos;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdministradorArchivosTest {

    @Test
    public void testLeerArchivo() {
        AdministradorArchivos adminArchivos = new AdministradorArchivos();
        String rutaArchivo = "inventarioTest.txt";

        try {
            String datos = adminArchivos.leerArchivo(rutaArchivo);
            assertNotNull(datos);
        } catch (CargaDatosException e) {
            fail("CargaDatosException lanzada: " + e.getMessage());
        }
    }

    @Test
    public void testEscribirArchivo() {
        AdministradorArchivos adminArchivos = new AdministradorArchivos();
        String rutaArchivo = "inventarioTest.txt";
        String datos = "Producto1, 10\nProducto2, 20";

        try {
            adminArchivos.escribirArchivo(rutaArchivo, datos);
        } catch (GuardarDatosException e) {
            fail("GuardarDatosException lanzada: " + e.getMessage());
        }
    }
}

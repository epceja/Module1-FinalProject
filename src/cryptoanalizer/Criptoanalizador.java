package cryptoanalizer;

import java.io.File;
import java.util.Scanner;
import java.lang.Runtime;
import java.io.IOException;

public class Criptoanalizador {

    private static final String CLEAR_CHARACTER = "\033[H\033[2J";

    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        String leidoDeTeclado = "";
        int opcionInicial = 0;
        boolean continuarMenuPrincipal = true;
        while (continuarMenuPrincipal) {
            System.out.print(CLEAR_CHARACTER);
            System.out.println("BIENVENIDO AL CRIPTOANALIZADOR");
            System.out.println("------------------------------");
            System.out.println("1. Cifrar un Archivo Existente");
            System.out.println("2. Descifrar un Archivo Existente");
            System.out.println("3. Salir del Programa");
            System.out.println("---------------------------------");
            System.out.print("Elija la Opción Deseada y presione <Enter> --> ");
            leidoDeTeclado = teclado.nextLine();
            opcionInicial = Integer.valueOf(leidoDeTeclado);
            switch (opcionInicial) {
                case 1:
                    menuCriptoanalizar("CIFRAR","_Cif","Cifrado",true);
                    break;
                case 2:
                    menuCriptoanalizar("DESCIFRAR","_Decif","Descifrado",true);
                    break;
                case 3:
                    System.out.println("\n\n\nGracias Por Utilizar Este Programa. ¡Hasta Luego!");
                    continuarMenuPrincipal = false;
                    break;
                default:
                    System.out.println("\n\n\n¡¡¡ Error debe elegir 1, 2 o 3 !!!\n\n");
                    break;
            }
        }
    }

    public static void menuCriptoanalizar(String eleccion, String modificador, String resultado, boolean cifrar) {
        Scanner teclado = new Scanner(System.in);
        String leidoDeTeclado = "", archivoATrabajar = "", archivoATrabajarM = "";
        AdministrarMetodoDeCambio metodoCambio = new AdministrarMetodoDeCambio();
        ManejoDeArchivos archivoParaTrabajar = new ManejoDeArchivos();
        boolean continuarMenu = true;
        while (continuarMenu) {
            //Runtime.getRuntime().exec("clear");
            System.out.print(CLEAR_CHARACTER);
            System.out.println("\n\n-- ELIGIÓ: " + eleccion + " UN ARCHIVO --");
            System.out.println("-------------------------------");
            System.out.println("-- Capture la ubicación del archivo a " + eleccion.toLowerCase() + " y presione <Enter> --> ");
            leidoDeTeclado = teclado.nextLine();
            archivoATrabajar = leidoDeTeclado;
            boolean archivoSi = existeArchivo(archivoATrabajar);
            if (!archivoSi) {
                break;
            }
            int metodoElegido = metodoCambio.elegirMetodoDeCambio();  // Menú para el método de cambio
            int punto = archivoATrabajar.lastIndexOf(".");
            archivoATrabajarM = archivoATrabajar.substring(0, punto) + modificador + archivoATrabajar.substring(punto);
            boolean exitoso = archivoParaTrabajar.modificarArchivo(archivoATrabajar, archivoATrabajarM, metodoElegido, cifrar);
            if (exitoso) {
                System.out.println("\n\n ¡¡ Archivo " + archivoATrabajarM + " ya está " + resultado + " !!\n\n");
                continuarMenu = false;
            }
        }
    }

    public static boolean existeArchivo(String archivo) {
        if (new File(archivo).exists()) {
            //System.out.println("Archivo sí existe");
            return true;
        } else {
            System.out.println("¡¡¡ Archivo no existe !!!\n");
            try {
                Thread.sleep(1 * 1000);
            } catch (Exception e) {
                System.out.println(e);
            }
            return false;
        }
    }
}

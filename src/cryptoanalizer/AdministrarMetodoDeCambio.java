package cryptoanalizer;

import java.util.Scanner;

public class AdministrarMetodoDeCambio {
    public int elegirMetodoDeCambio() {
        Scanner teclado2 = new Scanner(System.in);
        String leidoDeTeclado2 = "";
        int numeroDeMetodo = 0;
        boolean continuarMetodoCambio = true;
        while (continuarMetodoCambio) {
            System.out.println("--- Captura el método de cambio (1, 2, 3, 4 o 5) y presione <Enter> --> ");
            leidoDeTeclado2 = teclado2.nextLine();
            if ( leidoDeTeclado2.equals("1") ||
            leidoDeTeclado2.equals("2") ||
            leidoDeTeclado2.equals("3") ||
            leidoDeTeclado2.equals("4") ||
            leidoDeTeclado2.equals("5") ) {
                numeroDeMetodo = Integer.valueOf(leidoDeTeclado2);
                continuarMetodoCambio = false;
            }else {
                System.out.println("¡¡¡ Error de tecleo, las opciones son 1, 2, 3, 4 o 5 !!!");
            }
        }
        return numeroDeMetodo;
    }
}

package cryptoanalizer;

public class AlgoritmoParaCifrarYDescifrar {

    public String trabajarTexto(String textoATrabajar, int nMetodo, boolean cifrar) {
        boolean encontrado = false;
        String textoTrabajado = "";
        char[] alfabetoDeReferencia = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz.,\":-!? ".toCharArray();
        char[] textoATrabajarChar = textoATrabajar.toCharArray();
        for (int i = 0; i < textoATrabajarChar.length; i++) {
            encontrado = false;
            for (int j = 0; j < alfabetoDeReferencia.length; j++) {
                if (textoATrabajarChar[i] == alfabetoDeReferencia[j]) {
                    if (j - nMetodo >= 0) {
                        if (cifrar) {
                            textoTrabajado = textoTrabajado + String.valueOf(alfabetoDeReferencia[j - nMetodo]);
                        } else {
                            textoTrabajado = textoTrabajado + String.valueOf(alfabetoDeReferencia[j + nMetodo]);
                        }
                    } else {
                        if (cifrar) {
                            textoTrabajado = textoTrabajado + String.valueOf(alfabetoDeReferencia[alfabetoDeReferencia.length - 1 + nMetodo]);
                        } else {
                            textoTrabajado = textoTrabajado + String.valueOf(alfabetoDeReferencia[alfabetoDeReferencia.length + 1 - nMetodo]);
                        }
                    }
                    encontrado = true;
                    break;
                }
            }
            if (encontrado == false) {
                textoTrabajado = textoTrabajado + String.valueOf(textoATrabajarChar[i]);
            }
        }
        return textoTrabajado;
    }

}

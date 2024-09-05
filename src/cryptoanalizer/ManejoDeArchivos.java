package cryptoanalizer;

import java.io.*;

public class ManejoDeArchivos {

    public boolean modificarArchivo(String nombreDeArchivo, String nombredeArchivoM,
                                 int metodo, boolean cifrar) {
        boolean exito = false;
        try {
            FileReader fr = new FileReader(nombreDeArchivo);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(nombredeArchivoM);
            BufferedWriter bw = new BufferedWriter(fw);
            String linea;
            while ((linea = br.readLine()) != null) {
                String textoYaCifrado = new AlgoritmoParaCifrarYDescifrar().trabajarTexto(linea, metodo, cifrar);
                bw.write(textoYaCifrado);
                bw.newLine();
                exito = true;
            }
            br.close();
            bw.close();
        } catch (FileNotFoundException e) {
            System.out.println("\n¡¡¡ Archivo no Encontrado !!!\n\n");
        } catch (IOException e) {
            System.out.println("\n¡¡¡ Problemas con el archivo !!!\n\n");
        }
        return exito;
    }

}

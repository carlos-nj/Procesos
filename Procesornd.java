import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Scanner;

import javax.swing.JOptionPane;


public class Procesornd {

    private static String msg = "";
    private static String letras = "";

    public static void main(String[] args) {
        
        while (!letras.toUpperCase().equals("FIN")) {
            
            JOptionPane.showMessageDialog(null, "Se muestran " + letras.length() + " números aleatorios.\n");


            for (int i = 0; i < letras.length(); i++) {
                pb();
                
            }
            String nombre;
            nombre = JOptionPane.showInputDialog("Introduce una palabra");


        }

        System.out.println("Fin del programa");

        

    }

    public static void pb() {

        ProcessBuilder rnd = new ProcessBuilder();

        rnd.command("powershell.exe", "/c", "java .\\Aleatorio.java");

        try {

            // Ejecutamos el proceso con .start()
            Process process = rnd.start();

            // blocked :(
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "CP437"));

            
            String line ;
            
            while ((line = reader.readLine()) != null) {                
                msg = msg +line;
            

            //int exitCode = process.waitFor();
            //System.out.println("\nExited with error code : " + exitCode);
            }
            JOptionPane.showMessageDialog(null, msg);

        } catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
        }

} 
}
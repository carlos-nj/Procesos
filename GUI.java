import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *Clase GUI
 *Muestra la estructuta que deberia tener una Ventana en Java con la libreria
 *Swing, contiene una etiqueta, un caja de texto y un boton, que tiene la
 *accion de mostrar el texto en la caja por una ventana de mensaje.
 */

public class GUI extends JFrame implements ActionListener {
    //Variables Absolutas para la clase.
    private JLabel texto, texto2, texto3;
    private JTextField caja;
    private JTextField caja2;
    private JTextField caja3;
    private JButton boton, boton2, boton3;
    private static String cmd;
    private static String ps;
    private static String cm;

    /**
     * Constructor GUI
     * El constructor inicializa la aplicacion con el constructor super()
     * con el metodo configurarGUI() se configuran las caracteristicas de interfaz
     * el metodo inicializa conponentes necesarios
     * 
     */
    public GUI() {
        super();
        configurarGUI();
        inicializarComponentes();
 
    }
    public void openCmd(){
        ProcessBuilder processBuilder = new ProcessBuilder();
        //scanner para indicar lo que queremos
        String command = caja.getText();

        processBuilder.command("cmd.exe", "/c", "help", command);
        //ejecutamos nuestros programas
        try {

            Process process = processBuilder.start();

            // blocked :(
           BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                cmd= cmd+line+"\n";
            }

            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void OpenPs(){
        ProcessBuilder processBuilder = new ProcessBuilder();
                //scanner para indicar lo que queremos

        String order = caja2.getText();
            //ejecutamos nuestros programas
        processBuilder.command("cmd.exe", "/c", "ping -n 3", order);

        try {

            Process process = processBuilder.start();

            BufferedReader reader =                                     //usamos el CP437 para el idioma en español
                    new BufferedReader(new InputStreamReader(process.getInputStream(), "CP437"));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                ps = ps+line+"\n";
            }

            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void openSol(){
       
       
        ProcessBuilder processBuilder = new ProcessBuilder();
        String call = caja3.getText();
        processBuilder.command("powershell.exe", "-Command", call);   
            //ejecutamos nuestros programas

        

        try {

            Process process = processBuilder.start();

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream(), "CP437"));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                cm = cm + line + "\n";
            }

            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void configurarGUI() {
        /**
         * Metodo configurarGUI()
         * Metodo que inicia el estado de la GUI
         */
        this.setTitle("Esta Es Una Ventana");                   // colocamos titulo a la ventana
        this.setSize(310, 210);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(true);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
        this.setVisible(true);
    }


    private void inicializarComponentes() {
        /**
         * Metodo inicializarComponentes()
         * Metodo que genera los componentes necesarios para nuestra GUI.
         */

        texto = new JLabel();
        texto2 = new JLabel();
        texto3 = new JLabel();
        caja = new JTextField();
        caja2 = new JTextField();
        caja3 = new JTextField();
        boton = new JButton();
        boton2 = new JButton();
        boton3 = new JButton();
        // configuramos los componentes

        texto.setText("Inserte comando");    // colocamos un texto a la etiqueta
        texto.setBounds(30, 50, 100, 25);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
        caja.setBounds(150, 50, 100, 25);
        caja.setAlignmentX(CENTER_ALIGNMENT);   // colocamos posicion y tamanio a la caja (x, y, ancho, alto)
        boton.setText("Mostrar Ayuda");   // colocamos un texto al boton
        boton.setBounds(50, 100, 200, 30);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
        boton.addActionListener(this); 
             // hacemos que el boton tenga una accion y esa accion estara en esta clase
        texto2.setText("Introduzca pagina");
        texto2.setBounds(30, 150, 150, 25);
        caja2.setBounds(150, 150, 100, 25);
        caja2.setAlignmentX(CENTER_ALIGNMENT);   // colocamos posicion y tamanio a la caja (x, y, ancho, alto)      
        boton2.setText("Mostrar Ping");   
        boton2.setBounds(50, 200, 200, 30);  
        boton2.addActionListener(this);  

        texto3.setText("Programa a ejecutar");
        texto3.setBounds(30, 250, 150, 25);
        caja3.setBounds(150, 250, 100, 25);
        caja3.setAlignmentX(CENTER_ALIGNMENT);   // colocamos posicion y tamanio a la caja (x, y, ancho, alto)      
        boton3.setText("Ejecutar");   
        boton3.setBounds(50, 300, 200, 30);  
        boton3.addActionListener(this);     

        // adicionamos los componentes a la ventana

        this.add(texto);
        this.add(texto2);
        this.add(texto3);
        this.add(caja);
        this.add(caja2);
        this.add(caja3);
        this.add(boton);
        this.add(boton2);
        this.add(boton3);
        

    }

    @Override

    public void actionPerformed(ActionEvent e) {
        openCmd();
        JOptionPane.showMessageDialog(this.boton, cmd, "Ayuda", EXIT_ON_CLOSE);
        OpenPs();
        JOptionPane.showMessageDialog(this.boton2, ps, "Ping de pagina", EXIT_ON_CLOSE);
        openSol();
        JOptionPane.showMessageDialog(this.boton3, cm, "Programa elegido" + " " + caja3.getText(), EXIT_ON_CLOSE);


    }

    public static void main(String[] args) {
        
        GUI usuario = new GUI();      // creamos una ventana

    }

}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ListaPeliculas implements Utilizable{
    List<Pelicula> lista=new ArrayList<>();

    @Override
    public String muestraTodos() {
            String salida="Lista de películas:\n";
            for (Pelicula p:lista) {
                salida+=p.info()+"\n";
            }

        return salida;
    }

    @Override
    public void leeDeFichero(File fichero) {
        try {
            List<String> leido= Files.readAllLines(fichero.toPath());

            String nombrePelicula;
            double duracionHorasPelicula;
            for (String peliculaActual : leido) {
                nombrePelicula = peliculaActual.substring(0, peliculaActual.indexOf('{'));
                duracionHorasPelicula = Double.parseDouble(peliculaActual.substring(peliculaActual.indexOf('-') + 1, peliculaActual.indexOf('}')));
                lista.add(new Pelicula(nombrePelicula,duracionHorasPelicula));
            }


        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null,"No se ha podido leer el fichero","Error",JOptionPane.ERROR_MESSAGE);
        }catch (StringIndexOutOfBoundsException sioobe){
            JOptionPane.showMessageDialog(null,"No se ha podido leer el fichero","Error",JOptionPane.ERROR_MESSAGE);
        }catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null,"No se ha podido leer el fichero","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void guardaEnFichero(File fichero) {
        try (PrintWriter salida = new PrintWriter(fichero)) {
            for (Pelicula h:lista) {
                salida.print(h.toString()+"\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void pideYAnyade() {
        JFrame salida=new JFrame("Nueva Pelicula");
        CrearPeliculas panel=new CrearPeliculas();
        JButton anyadirALaLista=new JButton("Crear Pelicula");


        salida.setLayout(new BorderLayout());
        salida.setSize(390, 120);
        salida.setResizable(false);
        salida.setLocationRelativeTo(null);
        salida.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        salida.add(panel, BorderLayout.CENTER);
        anyadirALaLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre =  panel.getNombrePelicula().getText();
                    double duracionHoras = Double.parseDouble(panel.getDuracionHorasPelicula().getText());
                    lista.add(new Pelicula(nombre, duracionHoras));
                    salida.dispose();

                } catch (IllegalArgumentException iae) {
                    JOptionPane.showMessageDialog(null, iae.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        salida.add(anyadirALaLista,BorderLayout.SOUTH);
        salida.setVisible(true);


    }
}


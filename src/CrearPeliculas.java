import javax.swing.*;
import java.awt.*;

public class CrearPeliculas extends JPanel{

    private JLabel nombrePeli= new JLabel("Nombre de la película");
    private JTextField peliculaIntroducida=new JTextField();

    private JLabel duracionHorasPeli = new JLabel("Duración en horas de la película");
    private JTextField duracionHorasIntroducida=new JTextField();



    CrearPeliculas(){
        setLayout(new GridLayout(2,2));
        add(nombrePeli);
        add(peliculaIntroducida);
        add(duracionHorasPeli);
        add(duracionHorasIntroducida);
    }
    public JTextField getNombrePelicula(){
        return peliculaIntroducida;
    }

    public JTextField getDuracionHorasPelicula(){
        return duracionHorasIntroducida;
    }
}

import java.util.Objects;

public class Pelicula {
    private final String nombre;
    private final double duracionHoras;

    public Pelicula(String nombre, double duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras= duracionHoras;
    }

    public String getNombre() {
        return nombre;
    }

    public double getDuracionHoras() {
        return duracionHoras;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(nombre, pelicula.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "nombre='" + nombre + '\'' +
                ", duracionHoras=" + duracionHoras +
                '}';
    }
    public String info(){
        return "La pelicula "+this.nombre+", tiene una duración de "+this.duracionHoras+"horas";
    }
}
//a
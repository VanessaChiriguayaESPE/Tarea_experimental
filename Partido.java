import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

// Clase Partido
class Partido implements Comparable<Partido> {
    private Equipo equipo1;
    private Equipo equipo2;
    private String fecha;
    private String estado;
    private String resultado;

    public Partido(Equipo equipo1, Equipo equipo2, String fecha) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.fecha = fecha;
        this.estado = "Pendiente";
        this.resultado = null;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void actualizarResultado(String resultado) {
        this.resultado = resultado;
        this.estado = "Finalizado";
    }

    @Override
    public int compareTo(Partido otroPartido) {
        if (this.estado.equals(otroPartido.estado)) {
            return this.fecha.compareTo(otroPartido.fecha);
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Partido: " + equipo1.getNombre() + " vs " + equipo2.getNombre() + " | Fecha: " + fecha + " | Estado: " + estado + " | Resultado: " + (resultado != null ? resultado : "Pendiente");
    }
}
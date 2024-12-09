import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

// Clase Equipo
class Equipo {
    private String nombre;
    private String entrenador;
    private List<String> jugadores;

    public Equipo(String nombre, String entrenador) {
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.jugadores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarJugador(String jugador) {
        jugadores.add(jugador);
    }

    @Override
    public String toString() {
        return "Equipo: " + nombre + " | Entrenador: " + entrenador + " | Jugadores: " + jugadores;
    }
}
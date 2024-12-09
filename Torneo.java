import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

// Clase Torneo
class Torneo {
    List<Equipo> equipos;
    Set<Partido> partidos;

    public Torneo() {
        this.equipos = new ArrayList<>();
        this.partidos = new HashSet<>();
    }

    public void registrarEquipo(Equipo equipo) {
        equipos.add(equipo);
        System.out.println("Equipo registrado: " + equipo.getNombre());
    }

    public void crearPartido(Equipo equipo1, Equipo equipo2, String fecha) {
        Partido partido = new Partido(equipo1, equipo2, fecha);
        partidos.add(partido);
        System.out.println("Partido creado: " + equipo1.getNombre() + " vs " + equipo2.getNombre());
    }

    public void listarEquipos() {
        System.out.println("\nEquipos registrados:");
        equipos.forEach(equipo -> System.out.println("- " + equipo));
    }

    public void mostrarPartidos() {
        System.out.println("\nPartidos registrados:");
        if (partidos.isEmpty()) {
            System.out.println("No hay partidos registrados.");
        } else {
            partidos.forEach(System.out::println);
        }
    }

    public Partido buscarPartido(String equipo1, String equipo2) {
        return partidos.stream()
            .filter(p -> 
                p.getEquipo1().getNombre().equalsIgnoreCase(equipo1) && 
                p.getEquipo2().getNombre().equalsIgnoreCase(equipo2))
            .findFirst()
            .orElse(null);
    }
}
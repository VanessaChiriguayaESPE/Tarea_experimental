import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

// Clase Main
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Torneo torneo = new Torneo();

        while (true) {
            System.out.println("\n--- Sistema de Gestión de Torneos ---");
            System.out.println("1. Registrar equipo");
            System.out.println("2. Crear partido");
            System.out.println("3. Listar equipos");
            System.out.println("4. Mostrar historial de partidos");
            System.out.println("5. Actualizar resultado de un partido");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del equipo: ");
                    String nombreEquipo = scanner.nextLine();
                    System.out.print("Nombre del entrenador: ");
                    String entrenador = scanner.nextLine();

                    Equipo equipo = new Equipo(nombreEquipo, entrenador);

                    System.out.print("¿Cuántos jugadores desea registrar? ");
                    int numJugadores = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer

                    for (int i = 0; i < numJugadores; i++) {
                        System.out.print("Nombre del jugador " + (i + 1) + ": ");
                        equipo.agregarJugador(scanner.nextLine());
                    }

                    torneo.registrarEquipo(equipo);
                    break;

                case 2:
                    System.out.print("Nombre del equipo 1: ");
                    String equipo1 = scanner.nextLine();
                    System.out.print("Nombre del equipo 2: ");
                    String equipo2 = scanner.nextLine();
                    System.out.print("Fecha del partido (YYYY-MM-DD): ");
                    String fecha = scanner.nextLine();

                    Equipo eq1 = torneo.equipos.stream().filter(e -> e.getNombre().equalsIgnoreCase(equipo1)).findFirst().orElse(null);
                    Equipo eq2 = torneo.equipos.stream().filter(e -> e.getNombre().equalsIgnoreCase(equipo2)).findFirst().orElse(null);

                    if (eq1 != null && eq2 != null) {
                        torneo.crearPartido(eq1, eq2, fecha);
                    } else {
                        System.out.println("Uno o ambos equipos no están registrados.");
                    }
                    break;

                case 3:
                    torneo.listarEquipos();
                    break;

                case 4:
                    torneo.mostrarPartidos();
                    break;

                case 5:
                    System.out.print("Nombre del equipo 1: ");
                    String equipo1Busqueda = scanner.nextLine();
                    System.out.print("Nombre del equipo 2: ");
                    String equipo2Busqueda = scanner.nextLine();

                    Partido partido = torneo.buscarPartido(equipo1Busqueda, equipo2Busqueda);
                    if (partido != null) {
                        System.out.print("Ingrese el resultado (ejemplo: 2-1): ");
                        String marcador = scanner.nextLine();
                        partido.actualizarResultado(marcador);
                    } else {
                        System.out.println("Partido no encontrado.");
                    }
                    break;

                case 6:
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
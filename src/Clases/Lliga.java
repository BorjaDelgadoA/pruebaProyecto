package Clases;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Clase que gestiona una competición de liga entre varios equipos.
 * Se encarga de almacenar los equipos, simular los enfrentamientos (jornadas),
 * calcular las clasificaciones y determinar quién es el líder o el equipo más goleado.
 */
public class Lliga {

    private String nombre;
    private int numeroEquipos;
    private ArrayList<Equipo> equipos;

    /**
     * Constructor por defecto de la clase Lliga.
     */
    public Lliga() {
    }

    /**
     * Constructor que inicializa una liga con un nombre y un límite de participantes.
     *
     * @param nombre        Nombre de la competición.
     * @param numeroEquipos Cantidad máxima de equipos permitidos.
     */
    public Lliga(String nombre, int numeroEquipos) {
        this.nombre = nombre;
        this.numeroEquipos = numeroEquipos;
        this.equipos = new ArrayList<>();
    }

    /**
     * Busca un equipo participante por su nombre.
     *
     * @param nombre Nombre del equipo a buscar.
     * @return Un Optional que contiene el Equipo si existe, o vacío en caso contrario.
     */
    public Optional<Equipo> buscarEquipo(String nombre) {
        Optional<Equipo> encontrado = Optional.empty();
        for (Equipo e : equipos) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                encontrado = Optional.of(e);
            }
        }
        return encontrado;
    }

    /**
     * Determina cuál es el equipo con mayor puntuación en la liga actual.
     *
     * @return Un Optional con el equipo líder.
     */
    public Optional<Equipo> mejorEquipo() {
        Optional<Equipo> mejorOpt = Optional.empty();
        if (!equipos.isEmpty()) {
            Equipo mejorTemporal = equipos.get(0);
            for (Equipo e : equipos) {
                if (e.getEstadisticas().getPuntos() > mejorTemporal.getEstadisticas().getPuntos()) {
                    mejorTemporal = e;
                }
            }
            mejorOpt = Optional.of(mejorTemporal);
        }
        return mejorOpt;
    }

    /**
     * Identifica al equipo que ha marcado más goles en la liga.
     *
     * @return Un Optional con el equipo más goleador.
     */
    public Optional<Equipo> equipoMasGoleador() {
        Optional<Equipo> maxOpt = Optional.empty();
        if (!equipos.isEmpty()) {
            Equipo maxTemporal = equipos.get(0);
            for (Equipo e : equipos) {
                if (e.getEstadisticas().getGolesFavor() > maxTemporal.getEstadisticas().getGolesFavor()) {
                    maxTemporal = e;
                }
            }
            maxOpt = Optional.of(maxTemporal);
        }
        return maxOpt;
    }

    /**
     * Identifica al equipo que ha recibido más goles en la competición.
     *
     * @return Un Optional con el equipo con más goles en contra.
     */
    public Optional<Equipo> peorEquipo() {
        Optional<Equipo> peorOpt = Optional.empty();
        if (!equipos.isEmpty()) {
            Equipo peorTemporal = equipos.get(0);
            for (Equipo e : equipos) {
                if (e.getEstadisticas().getGolesContra() > peorTemporal.getEstadisticas().getGolesContra()) {
                    peorTemporal = e;
                }
            }
            peorOpt = Optional.of(peorTemporal);
        }
        return peorOpt;
    }

    /**
     * Añade un equipo a la liga siempre que no se haya superado el límite de plazas.
     *
     * @param equipo El objeto Equipo a inscribir.
     */
    public void agregarEquipo(Equipo equipo) {
        if (equipos.size() < numeroEquipos) {
            equipos.add(equipo);
        } else {
            System.out.println("La liga ya está llena");
        }
    }

    /**
     * Imprime por consola la tabla clasificatoria actual ordenada por puntos
     * y diferencia de goles. Muestra también el resumen final de la liga.
     */
    public void mostrarClasificacion() {
        equipos.sort((e1, e2) -> {
            int p1 = e1.getEstadisticas().getPuntos();
            int p2 = e2.getEstadisticas().getPuntos();
            if (p1 != p2) {
                return p2 - p1;
            }
            return e2.getEstadisticas().diferenciaGoles() - e1.getEstadisticas().diferenciaGoles();
        });

        System.out.println("---------------------------------------------------------");
        System.out.printf("%-20s | %-3s | %-3s | %-3s | %-3s | %-3s%n",
                "EQUIPO", "PTS", "PJ", "GF", "GC", "DG");
        System.out.println("---------------------------------------------------------");

        for (Equipo e : equipos) {
            Estadisticas st = e.getEstadisticas();
            System.out.printf("%-20s | %-3d | %-3d | %-3d | %-3d | %-3d%n",
                    e.getNombre(),
                    st.getPuntos(),
                    st.getPartidosJugados(),
                    st.getGolesFavor(),
                    st.getGolesContra(),
                    st.diferenciaGoles());
        }

        System.out.println("---------------------------------------------------------");
        System.out.println("\nRECUENTO DE LA JORNADA:");

        mejorEquipo().ifPresent(e ->
                System.out.println("Líder de la Liga: " + e.getNombre() + " (" + e.getEstadisticas().getPuntos() + " pts)"));

        equipoMasGoleador().ifPresent(e ->
                System.out.println("Máximo Goleador: " + e.getNombre() + " (" + e.getEstadisticas().getGolesFavor() + " goles)"));

        peorEquipo().ifPresent(e ->
                System.out.println("Peor equipo (más goles encajados): " + e.getNombre() + " (" + e.getEstadisticas().getGolesContra() + " goles)"));

        System.out.println("---------------------------------------------------------");
    }

    /**
     * Obtiene la lista completa de equipos inscritos.
     *
     * @return ArrayList de equipos.
     */
    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    /**
     * Simula los partidos de la liga. La calidad media de los jugadores
     * influye en las probabilidades de marcar goles de cada equipo.
     */
    public void disputarLiga() {
        for (int i = 0; i < equipos.size(); i++) {
            for (int j = i + 1; j < equipos.size(); j++) {
                Equipo local = equipos.get(i);
                Equipo visitante = equipos.get(j);

                int golesLocal = (int)(Math.random() * 3) + (int)(local.calcularCalidadMedia() / 30);
                int golesVisitante = (int)(Math.random() * 3) + (int)(visitante.calcularCalidadMedia() / 30);

                local.getEstadisticas().actualizarGoles(golesLocal, golesVisitante);
                visitante.getEstadisticas().actualizarGoles(golesVisitante, golesLocal);

                if (golesLocal > golesVisitante) {
                    local.getEstadisticas().sumarVictoria();
                    visitante.getEstadisticas().sumarDerrota();
                } else if (golesLocal < golesVisitante) {
                    visitante.getEstadisticas().sumarVictoria();
                    local.getEstadisticas().sumarDerrota();
                } else {
                    local.getEstadisticas().sumarEmpate();
                    visitante.getEstadisticas().sumarEmpate();
                }
            }
        }
    }
}
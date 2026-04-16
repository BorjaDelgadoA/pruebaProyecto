package Clases;

/**
 * Clase que guarda las estadísticas de un equipo o jugador.
 * Lleva la cuenta de puntos, partidos jugados, goles a favor y en contra.
 *
 * Autor: Borja
 * Fecha: 06/03/2026
 */
public class Estadisticas {

    private int puntos;
    private int partidosJugados;
    private int golesFavor;
    private int golesContra;

    /**
     * Constructor por defecto que inicializa todas las estadísticas a cero.
     */
    public Estadisticas() {
        puntos = 0;
        partidosJugados = 0;
        golesFavor = 0;
        golesContra = 0;
    }

    /**
     * Registra una victoria sumando 3 puntos al total
     * e incrementando en 1 los partidos jugados.
     */
    public void sumarVictoria() {
        puntos += 3;
        partidosJugados++;
    }

    /**
     * Registra un empate sumando 1 punto al total
     * e incrementando en 1 los partidos jugados.
     */
    public void sumarEmpate() {
        puntos += 1;
        partidosJugados++;
    }

    /**
     * Registra una derrota. Solo incrementa en 1 los partidos jugados.
     */
    public void sumarDerrota() {
        partidosJugados++;
    }

    /**
     * Actualiza la cantidad de goles marcados y recibidos en un partido.
     *
     * @param favor  Cantidad de goles marcados a favor.
     * @param contra Cantidad de goles recibidos en contra.
     */
    public void actualizarGoles(int favor, int contra) {
        golesFavor += favor;
        golesContra += contra;
    }

    /**
     * Calcula la diferencia entre los goles a favor y los goles en contra.
     *
     * @return La diferencia de goles.
     */
    public int diferenciaGoles() {
        return golesFavor - golesContra;
    }

    /**
     * Obtiene el total de goles en contra recibidos.
     *
     * @return Goles en contra.
     */
    public int getGolesContra() {
        return golesContra;
    }

    /**
     * Obtiene el total de goles a favor marcados.
     *
     * @return Goles a favor.
     */
    public int getGolesFavor() {
        return golesFavor;
    }

    /**
     * Obtiene el número total de partidos jugados.
     *
     * @return Partidos jugados.
     */
    public int getPartidosJugados() {
        return partidosJugados;
    }

    /**
     * Obtiene la puntuación total acumulada.
     *
     * @return Puntos totales.
     */
    public int getPuntos() {
        return puntos;
    }
}
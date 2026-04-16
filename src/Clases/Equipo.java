package Clases;

import java.util.ArrayList;

/**
 * Clase que representa a un equipo de fútbol dentro del juego.
 * Gestiona datos del equipo como nombre, ciudad, presidente,
 * estadio, cuerpo técnico, lista de jugadores y estadísticas.
 *
 * Autor: Borja
 * Fecha: 06/03/2026
 */
public class Equipo {

    private String nombre;
    private int anioFundacion;
    private String ciudad;
    private String NombrePresidente;
    private String nombreEstadio;
    private ArrayList<Jugador> jugadores;
    private Estadisticas estadisticas;
    private ArrayList<Entrenador> cuerpoTecnico;

    /**
     * Constructor por defecto de la clase Equipo.
     */
    public Equipo() {
    }

    /**
     * Constructor que inicializa un equipo con sus datos principales.
     *
     * @param nombre           El nombre del equipo.
     * @param anioFundacion    El año en el que se fundó.
     * @param nombrePresidente El nombre del presidente.
     * @param ciudad           La ciudad del equipo.
     * @param nombreEstadio    El nombre del estadio.
     */
    public Equipo(String nombre, int anioFundacion, String nombrePresidente, String ciudad, String nombreEstadio) {
        this.nombre = nombre;
        this.anioFundacion = anioFundacion;
        this.NombrePresidente = nombrePresidente;
        this.ciudad = ciudad;
        this.nombreEstadio = nombreEstadio;
        this.jugadores = new ArrayList<>();
        this.cuerpoTecnico = new ArrayList<>();
        this.estadisticas = new Estadisticas();
    }

    /**
     * Establece o modifica el nombre del presidente del equipo.
     *
     * @param nombrePresidente El nombre del presidente.
     */
    public void setNombrePresidente(String nombrePresidente) {
        this.NombrePresidente = nombrePresidente;
    }

    /**
     * Obtiene el nombre actual del equipo.
     *
     * @return El nombre del equipo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Añade un nuevo jugador a la plantilla del equipo.
     *
     * @param j El objeto Jugador a fichar.
     */
    public void ficharJugador(Jugador j) {
        jugadores.add(j);
    }

    /**
     * Obtiene el objeto con las estadísticas actuales del equipo.
     *
     * @return Las estadísticas del equipo.
     */
    public Estadisticas getEstadisticas() {
        return estadisticas;
    }

    /**
     * Elimina a un jugador de la plantilla del equipo.
     *
     * @param j El jugador a eliminar.
     */
    public void eliminarJugador(Jugador j) {
        jugadores.remove(j);
    }

    /**
     * Busca a un jugador dentro de la plantilla por su nombre y dorsal.
     *
     * @param nombre Nombre del jugador a buscar.
     * @param dorsal Número de dorsal del jugador.
     * @return El objeto Jugador si se encuentra, null si no existe.
     */
    public Jugador buscarJugador(String nombre, int dorsal) {
        for (Jugador j : jugadores) {
            if (j.getNombre().equals(nombre) && j.getDorsal() == dorsal) {
                return j;
            }
        }
        return null;
    }

    /**
     * Calcula la calidad técnica media del equipo basándose en la puntuación
     * de calidad de cada uno de sus jugadores.
     *
     * @return El promedio de calidad del equipo, o 0.0 si está vacío.
     */
    public double calcularCalidadMedia() {
        if (jugadores == null || jugadores.isEmpty()) {
            return 0.0;
        }

        double sumaCalidad = 0;
        for (Jugador j : jugadores) {
            sumaCalidad += j.getCalidad();
        }

        return sumaCalidad / jugadores.size();
    }

    /**
     * Obtiene el nombre del presidente actual del equipo.
     *
     * @return El nombre del presidente.
     */
    public String getNombrePresidente() {
        return NombrePresidente;
    }

    /**
     * Comprueba si un dorsal está disponible en la plantilla del equipo.
     *
     * @param dorsal Número de dorsal a comprobar.
     * @return true si el dorsal está libre, false si está ocupado.
     */
    public boolean siDorsalDisponible(int dorsal) {
        for (Jugador j : jugadores) {
            if (j.getDorsal() == dorsal) {
                return false;
            }
        }
        return true;
    }

    /**
     * Obtiene el año de fundación del equipo.
     *
     * @return El año de fundación.
     */
    public int getAnioFundacion() {
        return anioFundacion;
    }

    /**
     * Modifica el año de fundación del equipo.
     *
     * @param anioFundacion El nuevo año de fundación.
     */
    public void setAnioFundacion(int anioFundacion) {
        this.anioFundacion = anioFundacion;
    }

    /**
     * Modifica el nombre del equipo.
     *
     * @param nombre El nuevo nombre del equipo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre del estadio del equipo.
     *
     * @return El nombre del estadio.
     */
    public String getNombreEstadio() {
        return nombreEstadio;
    }

    /**
     * Modifica el nombre del estadio del equipo.
     *
     * @param nombreEstadio El nuevo nombre del estadio.
     */
    public void setNombreEstadio(String nombreEstadio) {
        this.nombreEstadio = nombreEstadio;
    }

    /**
     * Obtiene la ciudad de origen del equipo.
     *
     * @return La ciudad del equipo.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Modifica la ciudad del equipo.
     *
     * @param ciudad La nueva ciudad.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Establece o reemplaza el objeto de estadísticas del equipo.
     *
     * @param estadisticas Las nuevas estadísticas.
     */
    public void setEstadisticas(Estadisticas estadisticas) {
        this.estadisticas = estadisticas;
    }

    /**
     * Obtiene la lista completa de jugadores.
     *
     * @return Lista de jugadores.
     */
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    /**
     * Reemplaza la lista actual de jugadores por una nueva.
     *
     * @param jugadores Nueva lista de jugadores.
     */
    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    /**
     * Obtiene la lista del cuerpo técnico (entrenadores).
     *
     * @return Lista de entrenadores.
     */
    public ArrayList<Entrenador> getCuerpoTecnico() {
        return cuerpoTecnico;
    }

    /**
     * Devuelve una representación en formato texto con todos los datos del equipo.
     *
     * @return Cadena de texto estructurada con la ficha del equipo.
     */
    @Override
    public String toString() {
        String ficha = "\n========================================\n" +
                "       FICHA: " + nombre.toUpperCase() + "\n" +
                "========================================\n" +
                "Fundación:   " + anioFundacion + "\n" +
                "Estadio:     " + nombreEstadio + "\n" +
                "Presidente:  " + NombrePresidente + "\n" +
                "Ciudad:      " + ciudad + "\n" +
                "\n--- CUERPO TÉCNICO ---\n";

        if (cuerpoTecnico.isEmpty()) {
            ficha += "Sin entrenadores asignados.\n";
        } else {
            for (Entrenador ent : cuerpoTecnico) {
                ficha += ent + "\n";
            }
        }

        ficha += "\n--- PLANTILLA DE JUGADORES ---\n";
        if (jugadores.isEmpty()) {
            ficha += "Plantilla vacía.\n";
        } else {
            for (Jugador j : jugadores) {
                ficha += j + "\n";
            }
        }

        ficha += "========================================\n";
        return ficha;
    }
}
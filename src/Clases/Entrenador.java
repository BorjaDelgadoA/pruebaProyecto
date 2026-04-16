package Clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa a un entrenador dentro del juego.
 * Hereda de Persona y añade características propias como torneos ganados
 * y si ejerce como seleccionador nacional.
 *
 * Autor: Miguel
 * Fecha: 06/03/2026
 */
public class Entrenador extends Persona {

    private int torneosGanados;
    private boolean seleccionador;

    /**
     * Constructor para inicializar un nuevo entrenador con todos sus datos.
     *
     * @param nombre          Nombre del entrenador.
     * @param apellido        Apellido del entrenador.
     * @param fechaNacimiento Fecha de nacimiento del entrenador.
     * @param motivacion      Nivel de motivación actual.
     * @param sueldo          Salario actual del entrenador.
     * @param torneosGanados  Cantidad de torneos ganados.
     * @param seleccionador   Indica si es seleccionador nacional.
     */
    public Entrenador(String nombre, String apellido, LocalDate fechaNacimiento, double motivacion, double sueldo,
                      int torneosGanados, boolean seleccionador) {
        super(nombre, apellido, fechaNacimiento, motivacion, sueldo);
        this.torneosGanados = torneosGanados;
        this.seleccionador = seleccionador;
    }

    /**
     * Incrementa el sueldo actual del entrenador en un 0.5%.
     */
    public void incrementarSueldo() {
        double nuevoSueldo = getSueldo() * 1.005;
        setSueldo(nuevoSueldo);
    }

    /**
     * Obtiene la cantidad de torneos ganados.
     *
     * @return Número de torneos.
     */
    public int getTorneosGanados() {
        return torneosGanados;
    }

    /**
     * Indica si el entrenador es seleccionador nacional.
     *
     * @return true si es seleccionador, false en caso contrario.
     */
    public boolean isSeleccionadorNacional() {
        return seleccionador;
    }

    /**
     * Establece la cantidad de torneos ganados.
     *
     * @param torneosGanados Cantidad de torneos.
     */
    public void setTorneosGanados(int torneosGanados) {
        this.torneosGanados = torneosGanados;
    }

    /**
     * Establece si el entrenador es seleccionador nacional.
     *
     * @param seleccionador true si es seleccionador, false en caso contrario.
     */
    public void setSeleccionador(boolean seleccionador) {
        this.seleccionador = seleccionador;
    }

    /**
     * Simula la participación del entrenador en una sesión de entrenamiento.
     * Incrementa su nivel de motivación en 0.1 puntos.
     */
    @Override
    public void entrenar() {
        motivacion = motivacion + 0.1;
    }

    /**
     * Genera una representación en formato de cadena de texto con los datos principales.
     *
     * @return Cadena de texto con los datos del entrenador.
     */
    @Override
    public String toString() {
        return "Entrenador: " + getNombre() + " " + getApellido() +
                " | Torneos ganados: " + torneosGanados +
                " | Seleccionador: " + seleccionador;
    }

    /**
     * Formatea los datos del entrenador en una cadena separada por puntos y comas.
     *
     * @return Cadena de texto con los atributos separados por ';'.
     */
    @Override
    public String toCSV() {
        return "E;" + nombre + ";" + apellido + ";" +
                fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ";" +
                motivacion + ";" + sueldo + ";" +
                torneosGanados + ";" + seleccionador;
    }
}
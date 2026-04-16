package Clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa a un jugador de fútbol dentro del sistema.
 * Extiende la clase Persona incorporando atributos técnicos como el dorsal,
 * la posición en el campo y un valor numérico de calidad.
 *
 * Autor: Miguel
 * Fecha: 06/03/2026
 */
public class Jugador extends Persona {

    private int dorsal;
    private Posicion posicion;
    private double calidad;

    /**
     * Constructor para crear un nuevo jugador con sus atributos completos.
     *
     * @param nombre          Nombre del jugador.
     * @param apellido        Apellido del jugador.
     * @param fechaNacimiento Fecha de nacimiento.
     * @param motivacion      Nivel inicial de motivación.
     * @param sueldo          Salario anual.
     * @param dorsal          Número de camiseta asignado.
     * @param posicion        Posición táctica (POR, DEF, MIG, DAV).
     * @param calidad         Valor de habilidad técnica.
     */
    public Jugador(String nombre, String apellido, LocalDate fechaNacimiento, double motivacion, double sueldo,
                   int dorsal, Posicion posicion, double calidad) {
        super(nombre, apellido, fechaNacimiento, motivacion, sueldo);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.calidad = calidad;
    }

    /**
     * Enumeración de las posiciones posibles de un jugador en el campo.
     */
    public enum Posicion {
        POR, DEF, MIG, DAV
    }

    /**
     * Obtiene el dorsal del jugador.
     *
     * @return Número de dorsal.
     */
    public int getDorsal() {
        return dorsal;
    }

    /**
     * Establece el dorsal del jugador.
     *
     * @param dorsal Nuevo número de dorsal.
     */
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    /**
     * Obtiene la posición táctica del jugador.
     *
     * @return Posición del jugador.
     */
    public Posicion getPosicion() {
        return posicion;
    }

    /**
     * Obtiene la calidad técnica del jugador.
     *
     * @return Valor de calidad.
     */
    public double getCalidad() {
        return calidad;
    }

    /**
     * Evalúa si el jugador cambia de posición en base a una probabilidad del 5%.
     * Si el cambio ocurre, se le asigna una nueva posición aleatoria y su calidad aumenta.
     */
    public void cambioDePosicion() {
        if (Math.random() < 0.05) {
            Posicion[] todas = Posicion.values();
            int indice = (int) (Math.random() * todas.length);
            this.posicion = todas[indice];
            System.out.println("La posicion de [" + this.nombre + "] ha cambiado por: " + this.posicion);
            this.calidad = this.calidad + 1;
        }
    }

    /**
     * Implementa el entrenamiento específico del jugador, lo cual
     * incrementa su nivel de motivación en 0.2 puntos.
     */
    @Override
    public void entrenar() {
        motivacion = motivacion + 0.2;
    }

    /**
     * Devuelve una cadena de texto con la información básica del jugador.
     *
     * @return Representación textual del jugador.
     */
    @Override
    public String toString() {
        return "Jugador: " + getNombre() + " " + getApellido() +
                " | Dorsal: " + dorsal +
                " | Posicion: " + posicion +
                " | Calidad: " + calidad;
    }

    /**
     * Convierte los datos del jugador a un formato de texto separado por puntos y comas.
     *
     * @return Línea formateada para almacenamiento en archivo CSV.
     */
    @Override
    public String toCSV() {
        return "J;" + nombre + ";" + apellido + ";" +
                fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ";" +
                motivacion + ";" + sueldo + ";" +
                dorsal + ";" + posicion + ";" + calidad;
    }
}
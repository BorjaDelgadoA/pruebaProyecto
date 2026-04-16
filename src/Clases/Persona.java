package Clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase abstracta que representa a una persona dentro del juego.
 * Guarda datos básicos como nombre, apellido, sueldo, fecha de nacimiento y motivación.
 * Las clases que hereden de Persona (como Jugador o Entrenador) añadirán características específicas.
 *
 * Autor: Miguel
 * Fecha: 06/03/2026
 */
public abstract class Persona {

    protected String nombre;
    protected String apellido;
    protected double sueldo;
    protected LocalDate fechaNacimiento;
    protected double motivacion;

    /**
     * Constructor base para inicializar una persona con sus datos fundamentales.
     *
     * @param nombre          Nombre de la persona.
     * @param apellido        Apellido de la persona.
     * @param fechaNacimiento Fecha de nacimiento.
     * @param motivacion      Nivel de motivación (0-10).
     * @param sueldo          Sueldo asignado.
     */
    public Persona(String nombre, String apellido, LocalDate fechaNacimiento, double motivacion, double sueldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldo = sueldo;
        this.fechaNacimiento = fechaNacimiento;
        this.motivacion = motivacion;
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return El nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el apellido de la persona.
     *
     * @return El apellido.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Obtiene la fecha de nacimiento de la persona.
     *
     * @return Objeto LocalDate con la fecha.
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Obtiene el sueldo actual de la persona.
     *
     * @return El sueldo.
     */
    public double getSueldo() {
        return sueldo;
    }

    /**
     * Actualiza el sueldo de la persona.
     *
     * @param sueldo Nuevo valor de sueldo.
     */
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * Obtiene el nivel de motivación actual.
     *
     * @return Valor de motivación.
     */
    public double getMotivacion() {
        return motivacion;
    }

    /**
     * Método abstracto que define la acción de entrenar.
     * Cada subclase (Jugador o Entrenador) debe implementar su propia lógica.
     */
    public abstract void entrenar();

    /**
     * Método abstracto para exportar los datos a formato CSV.
     *
     * @return Cadena de texto en formato CSV.
     */
    public abstract String toCSV();
}
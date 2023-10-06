/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author diego
 */
import java.util.Date;

public class Asistencia {
    private Date fecha;
    private Estudiante estudiante;
    private boolean presente;

    public Asistencia(Date fecha, Estudiante estudiante, boolean presente) {
        this.fecha = fecha;
        this.estudiante = estudiante;
        this.presente = presente;
    }

    public Date getFecha() {
        return fecha;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public boolean isPresente() {
        return presente;
    }
}

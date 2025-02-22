package com.exe.app.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AgendaClase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombresApellidos;

    @Column(nullable = false, length = 15)
    private String celular;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false)
    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Horario horario;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categoria categoria;

    // Enumeración para los horarios disponibles
    public enum Horario {
        H_6_7_AM("6:00 AM - 7:00 AM"),
        H_7_8_AM("7:00 AM - 8:00 AM"),
        H_8_9_AM("8:00 AM - 9:00 AM"),
        H_6_7_PM("6:00 PM - 7:00 PM"),
        H_7_8_PM("7:00 PM - 8:00 PM"),
        H_8_9_PM("8:00 PM - 9:00 PM");

        private final String displayValue;

        Horario(String displayValue) {
            this.displayValue = displayValue;
        }

        public String getDisplayValue() {
            return displayValue;
        }
    }

    // Enumeración para los tipos de clase
    public enum Categoria {
        ENTRENAMIENTO_FISICO,
        DEPORTES_DE_COMBATE,
        DANZAS,
        PERSONALIZADO,
        CAPOEIRA
    }

    // Getters y Setters para cada campo


    public AgendaClase() {
    }


    public AgendaClase( String nombresApellidos, String celular, String email, LocalDate fecha, Horario horario, Categoria categoria) {
        this.nombresApellidos = nombresApellidos;
        this.celular = celular;
        this.email = email;
        this.fecha = fecha;
        this.horario = horario;
        this.categoria = categoria;
    }


    public AgendaClase(Long id, String nombresApellidos, String celular, String email, LocalDate fecha, Horario horario, Categoria categoria) {
        this.id = id;
        this.nombresApellidos = nombresApellidos;
        this.celular = celular;
        this.email = email;
        this.fecha = fecha;
        this.horario = horario;
        this.categoria = categoria;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombresApellidos() {
        return this.nombresApellidos;
    }

    public void setNombresApellidos(String nombresApellidos) {
        this.nombresApellidos = nombresApellidos;
    }

    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Horario getHorario() {
        return this.horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombresApellidos='" + getNombresApellidos() + "'" +
            ", celular='" + getCelular() + "'" +
            ", email='" + getEmail() + "'" +
            ", fecha='" + getFecha() + "'" +
            ", horario='" + getHorario() + "'" +
            ", categoria='" + getCategoria() + "'" +
            "}";
    }
}

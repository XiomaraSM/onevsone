package com.exe.app.models;



import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "SeguimientoPersona")
public class Seguimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "fechaSeguimiento")
    private LocalDate fechaSeguimiento;

    @Column(name = "Nombres")
    private String nombres;

    @Column(name = "Apellidos")
    private String apellidos;

    @Column(name = "Altura")
    private Double altura;  // Cambiado a Double

    @Column(name = "Peso")
    private Double peso;  // Cambiado a Double

    @Column(name = "Brazo")
    private Double brazo;  // Cambiado a Double

    @Column(name = "Cintura")
    private Double cintura;  // Cambiado a Double

    @Column(name = "Cadera")
    private Double cadera;  // Cambiado a Double

    @Column(name = "Pierna")
    private Double pierna;  // Cambiado a Double

    @Column(name = "IMC")
    private Double imc;  // Cambiado a Double


    public Seguimiento() {
    }
    

    public Seguimiento( LocalDate fechaSeguimiento, String nombres, String apellidos, Double altura, Double peso, Double brazo, Double cintura, Double cadera, Double pierna, Double imc) {
        this.fechaSeguimiento = fechaSeguimiento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.altura = altura;
        this.peso = peso;
        this.brazo = brazo;
        this.cintura = cintura;
        this.cadera = cadera;
        this.pierna = pierna;
        this.imc = imc;
    }

    public Seguimiento(Long id, LocalDate fechaSeguimiento, String nombres, String apellidos, Double altura, Double peso, Double brazo, Double cintura, Double cadera, Double pierna, Double imc) {
        this.id = id;
        this.fechaSeguimiento = fechaSeguimiento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.altura = altura;
        this.peso = peso;
        this.brazo = brazo;
        this.cintura = cintura;
        this.cadera = cadera;
        this.pierna = pierna;
        this.imc = imc;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaSeguimiento() {
        return this.fechaSeguimiento;
    }

    public void setFechaSeguimiento(LocalDate fechaSeguimiento) {
        this.fechaSeguimiento = fechaSeguimiento;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Double getAltura() {
        return this.altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return this.peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getBrazo() {
        return this.brazo;
    }

    public void setBrazo(Double brazo) {
        this.brazo = brazo;
    }

    public Double getCintura() {
        return this.cintura;
    }

    public void setCintura(Double cintura) {
        this.cintura = cintura;
    }

    public Double getCadera() {
        return this.cadera;
    }

    public void setCadera(Double cadera) {
        this.cadera = cadera;
    }

    public Double getPierna() {
        return this.pierna;
    }

    public void setPierna(Double pierna) {
        this.pierna = pierna;
    }

    public Double getImc() {
        return this.imc;
    }

    public void setImc(Double imc) {
        this.imc = imc;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", fechaSeguimiento='" + getFechaSeguimiento() + "'" +
            ", nombres='" + getNombres() + "'" +
            ", apellidos='" + getApellidos() + "'" +
            ", altura='" + getAltura() + "'" +
            ", peso='" + getPeso() + "'" +
            ", brazo='" + getBrazo() + "'" +
            ", cintura='" + getCintura() + "'" +
            ", cadera='" + getCadera() + "'" +
            ", pierna='" + getPierna() + "'" +
            ", imc='" + getImc() + "'" +
            "}";
    }


}
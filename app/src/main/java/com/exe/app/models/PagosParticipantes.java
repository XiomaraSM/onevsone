package com.exe.app.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PagosParticipantes {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false, length = 100)
    private String nombresApellidos;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoDocumento tipoDocumento;

    @Column(nullable = false, unique = true, length = 20)
    private String numeroDocumento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MetodoPago metodoPago;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;
    
    // Enumeraciones
    public enum TipoDocumento {
        CC, // Cédula de Ciudadanía
        TI, // Tarjeta de Identidad
        CE, // Cédula de Extranjería
        PAS, // Pasaporte
        NIT // Número de Identificación Tributaria
    }

    public enum Categoria {
        ENTRENAMIENTO_FISICO,
        DEPORTES_DE_COMBATE,
        DANZAS,
        PERSONALIZADO,
        CAPOEIRA
    }

    public enum MetodoPago {
        NEQUI,
        DAVIPLATA,
        BANCOLOMBIA,
        BBVA,
        EFECTIVO
    }

    public PagosParticipantes() {
    }


    public PagosParticipantes(LocalDate fecha, String nombresApellidos, TipoDocumento tipoDocumento, String numeroDocumento, Categoria categoria, MetodoPago metodoPago, BigDecimal valor) {
        this.fecha = fecha;
        this.nombresApellidos = nombresApellidos;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.categoria = categoria;
        this.metodoPago = metodoPago;
        this.valor = valor;
    }


    public PagosParticipantes(Long id, LocalDate fecha, String nombresApellidos, TipoDocumento tipoDocumento, String numeroDocumento, Categoria categoria, MetodoPago metodoPago, BigDecimal valor) {
        this.id = id;
        this.fecha = fecha;
        this.nombresApellidos = nombresApellidos;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.categoria = categoria;
        this.metodoPago = metodoPago;
        this.valor = valor;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombresApellidos() {
        return this.nombresApellidos;
    }

    public void setNombresApellidos(String nombresApellidos) {
        this.nombresApellidos = nombresApellidos;
    }

    public TipoDocumento getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return this.numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public MetodoPago getMetodoPago() {
        return this.metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", fecha='" + getFecha() + "'" +
            ", nombresApellidos='" + getNombresApellidos() + "'" +
            ", tipoDocumento='" + getTipoDocumento() + "'" +
            ", numeroDocumento='" + getNumeroDocumento() + "'" +
            ", categoria='" + getCategoria() + "'" +
            ", metodoPago='" + getMetodoPago() + "'" +
            ", valor='" + getValor() + "'" +
            "}";
    }

}


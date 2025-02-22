package com.exe.app.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class PQRS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombresApellidos;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoDocumento tipoDocumento;

    @Column(nullable = false, length = 15)
    private String numeroDocumento;

    @Column(nullable = false, length = 15)
    private String celular;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = true)
    private String mensaje;

    // Enumeración para los tipos de documento
    public enum TipoDocumento {
        CC("Cédula de Ciudadanía"),
        TI("Tarjeta de Identidad"),
        CE("Cédula de Extranjería"),
        PAS("Pasaporte"),
        NIT("NIT");

        private final String displayValue;

        TipoDocumento(String displayValue) {
            this.displayValue = displayValue;
        }

        public String getDisplayValue() {
            return displayValue;
        }
    }


    public PQRS() {
    }


    public PQRS(String nombresApellidos, TipoDocumento tipoDocumento, String numeroDocumento, String celular, String email, String mensaje) {
        this.nombresApellidos = nombresApellidos;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.celular = celular;
        this.email = email;
        this.mensaje = mensaje;
    }


    public PQRS(Long id, String nombresApellidos, TipoDocumento tipoDocumento, String numeroDocumento, String celular, String email, String mensaje) {
        this.id = id;
        this.nombresApellidos = nombresApellidos;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.celular = celular;
        this.email = email;
        this.mensaje = mensaje;
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

    public String getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }



    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombresApellidos='" + getNombresApellidos() + "'" +
            ", tipoDocumento='" + getTipoDocumento() + "'" +
            ", numeroDocumento='" + getNumeroDocumento() + "'" +
            ", celular='" + getCelular() + "'" +
            ", email='" + getEmail() + "'" +
            ", mensaje='" + getMensaje() + "'" +
            "}";
    }
}
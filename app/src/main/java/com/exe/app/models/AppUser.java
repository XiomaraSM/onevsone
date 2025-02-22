package com.exe.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoDocumento tipoDocumento;
    @Column( unique = true, name = "numeroDocumento", nullable = false, length = 50)
    private String numeroDocumento;

    @Column(name = "primerNombre", nullable = false, length = 50)
    private String primerNombre;
    @Column(name = "segundoNombre", length = 50)
    private String segundoNombre;

    @Column(name = "primerApellido", nullable = false, length = 50)
    private String primerApellido;
    @Column(name = "segundoApellido", length = 50)
    private String segundoApellido;

    @Column(unique = true, name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "celular", nullable = false, length = 15)
    private String celular;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LocalidadBogota localidadBogota;
    @Column(name = "barrio", nullable = false, length = 150)
    private String barrio;
    @Column(name = "direccion", nullable = false, length = 150)
    private String direccion;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    // Getter y Setter
    public UserRole getRole() {
        return this.role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public enum UserRole {
        USUARIO,
        ADMIN,
        ENTRENADOR
    }

    // Enumeraciones
    public enum TipoDocumento {
        CC, // Cédula de Ciudadanía
        TI, // Tarjeta de Identidad
        CE, // Cédula de Extranjería
        PAS, // Pasaporte
        NIT // Número de Identificación Tributaria
    }

    public enum LocalidadBogota {
        USAQUEN,
        CHAPINERO,
        SANTAFE,
        SAN_CRISTOBAL,
        USME,
        TUNJUELITO,
        BOSA,
        KENNEDY,
        FONTIBON,
        ENGATIVA,
        SUBA,
        BARRIOS_UNIDOS,
        TEUSAQUILLO,
        MARTIRES,
        ANTONIO_NARINO,
        PUENTE_ARANDA,
        CANDELARIA,
        RAFAEL_URIBE_URIBE,
        CIUDAD_BOLIVAR,
        SUMAPAZ
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPrimerNombre() {
        return this.primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return this.segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return this.primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return this.segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public LocalidadBogota getLocalidadBogota() {
        return this.localidadBogota;
    }

    public void setLocalidadBogota(LocalidadBogota localidadBogota) {
        this.localidadBogota = localidadBogota;
    }

    public String getBarrio() {
        return this.barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

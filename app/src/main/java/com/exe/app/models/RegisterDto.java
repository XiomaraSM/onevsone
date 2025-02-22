package com.exe.app.models;

import com.exe.app.models.AppUser.LocalidadBogota;
import com.exe.app.models.AppUser.TipoDocumento;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class RegisterDto {

    private TipoDocumento tipoDocumento;
    @NotEmpty
    private String numeroDocumento;

    @NotEmpty
    private String primerNombre;
    private String segundoNombre;
    @NotEmpty
    private String primerApellido;
    private String segundoApellido;

    @NotEmpty
    @Column(unique = true, nullable = false)
    private String email;

    @NotEmpty
    private String celular;

    private LocalidadBogota localidadBogota;
    @NotEmpty
    private String barrio;
    @NotEmpty
    private String direccion;

    @Size(min = 6, message = "La longitud mínima de la contraseña es de 6 caracteres")
    private String password;

    private String confirmPassword;



    public RegisterDto() {
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

    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

   
}

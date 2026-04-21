package com.arquisoft.negociocomercio.clientes.dto;

import java.time.LocalDateTime;

public class ClienteMessage {
    private String nombre;
    private String correo;
    private LocalDateTime fechaRegistro;

    public ClienteMessage() {
    }

    public ClienteMessage(String nombre, String correo, LocalDateTime fechaRegistro) {
        this.nombre = nombre;
        this.correo = correo;
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "ClienteMessage{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
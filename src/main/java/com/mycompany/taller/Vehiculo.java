
package com.mycompany.taller;
public class Vehiculo {
    private String marca;
    private String modelo;
    private String placa;
    private String horaIngreso;
    private String horaSalida;

    // Constructor
    public Vehiculo(String marca, String modelo, String placa,String horaIngreso) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.horaIngreso = horaIngreso;
    }
    
    public double calcularIngresos() {
    if (this.horaSalida == null) {
        return 3000;
    }

    String horaIngreso = this.horaIngreso;
    String horaSalida = this.horaSalida;

    String[] partesHoraI = horaIngreso.split(":");
    int horasIn = Integer.parseInt(partesHoraI[0]);

    String[] partesHoraS = horaSalida.split(":");
    int horasS = Integer.parseInt(partesHoraS[0]);

    return 3000 + ((horasS - horasIn) * 200);
    }

    // Getters y Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getHoraIngreso() {
        return horaIngreso;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraIngreso(String horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }
}
    

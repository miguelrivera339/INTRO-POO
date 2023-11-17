/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller;

public class Motocicleta extends Vehiculo {
    private int cilindrada;

    public Motocicleta(int cilindrada,String marca, String modelo, String placa, String horaIngreso) {
        super(marca, modelo, placa, horaIngreso);
        this.cilindrada = cilindrada;
    }
    
    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
    
    @Override
    public String toString() {
        return "Motocicleta{" +
                "marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", año=" + getPlaca() +
                ", cilindrada=" + cilindrada +
                '}';
    }
}
    

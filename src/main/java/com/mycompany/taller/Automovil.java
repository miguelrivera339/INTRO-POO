/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller;
public class Automovil extends Vehiculo {
    private int numeroPuertas;

    // Constructor

    public Automovil(int numeroPuertas,String marca, String modelo, String placa, String horaIngreso) {
        super(marca, modelo, placa, horaIngreso);
        this.numeroPuertas = numeroPuertas;
    }
 
    public double calcularPrecio() {
    double costo = 15;
    return costo + (numeroPuertas * 5);
    }

    // Getter y Setter
    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }
}

    

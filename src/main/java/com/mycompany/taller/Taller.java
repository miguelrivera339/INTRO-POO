package com.mycompany.taller;

import static spark.Spark.*;
import com.google.gson.Gson;
import java.util.LinkedList;
import java.util.Date;

public class Taller {
    public static void main(String[] args) {

        // Esto nos sirve para generar un formato json para retornar la data del array
        // sin tener que acomodarla bonita de manera manual
        Gson gson = new Gson();

        Date fecha = new Date();

        LinkedList<Vehiculo> automoviles = new LinkedList<>();
        LinkedList<Motocicleta> motos = new LinkedList<>();

        // Automovil creado por defecto
        Automovil carro1 = new Automovil(4, "Mazda", "3", "ZYX987", (fecha.getHours() + ":" + fecha.getMinutes()));
        automoviles.add(carro1);

        Motocicleta moto = new Motocicleta(600, "Honda", "CBR600", "XYZ789", (fecha.getHours() + ":" + fecha.getMinutes()));

        // Agregar la motocicleta a la lista de automoviles
        automoviles.add(moto);

        // Definir endpoints

        // Por defecto
        get("/motocicleta", (req, res) -> {
            res.type("application/json");
            return gson.toJson(moto);
        });

        // Listado de automoviles
        get("/automoviles", (req, res) -> {
            res.type("application/json");
            return gson.toJson(automoviles);
        });

        // Guardar automovil
        // endpoint GET para agregar un automóvil
        get("/agregarAutomovil/:marca/:modelo/:placa/:numeroPuertas", (req, res) -> {

            // Añadimos esto para retornar en formato Json
            res.type("application/json");

            // No olvidar convertir en integer los string numéricos que llegan por URL
            int numeroPuertas = Integer.parseInt(req.params(":numeroPuertas"));
            // Obtener parámetros de la URL
            String marca = req.params(":marca");
            String modelo = req.params(":modelo");
            String placa = req.params(":placa");

            // Crear un nuevo automóvil y agregarlo al parqueadero
            Automovil carroNuevo = new Automovil(numeroPuertas, marca, modelo, placa, (fecha.getHours() + ":" + fecha.getMinutes()));
            automoviles.add(carroNuevo);

            return gson.toJson(carroNuevo);
        });

        get("/motos", (req, res) -> {
            res.type("application/json");
            return gson.toJson(motos);
        });

        // Endpoint para obtener la lista de motocicletas
        get("/motos", (req, res) -> {
            res.type("application/json");
            return gson.toJson(motos);
        });

        // Endpoint para agregar una motocicleta con parámetros desde la URL
        get("/agregarMoto/:marca/:modelo/:placa/:cilindrada", (req, res) -> {
            res.type("application/json");

            Date nuevaFecha = new Date();
            String marcaMoto = req.params(":marca");
            String modeloMoto = req.params(":modelo");
            String placaMoto = req.params(":placa");
            int cilindrada = Integer.parseInt(req.params(":cilindrada"));

            Motocicleta motoNueva = new Motocicleta(cilindrada, marcaMoto, modeloMoto, placaMoto, (nuevaFecha.getHours() + ":" + nuevaFecha.getMinutes()));
            motos.add(motoNueva);

            return gson.toJson(motoNueva);
        });

        // Endpoint para obtener la lista de motocicletas actualizada
        get("/motos", (req, res) -> {
            res.type("application/json");
            return gson.toJson(motos);
        });

        //endpoint registrar hora de salida
        get("/registrarSalidaAutomovil/:placa", (req, res) -> {

            // Añadimos esto para retornar en formato Json
            res.type("application/json");

            // objeto fecha
            Date nuevaFecha = new Date();

            // Obtener parámetros de la URL
            String placaAuto = req.params(":placa");

            // Buscar en automóviles
            for (Vehiculo automovil : automoviles) {
                if (automovil.getPlaca().equals(placaAuto)) {
                    automovil.setHoraSalida((nuevaFecha.getHours() + ":" + nuevaFecha.getMinutes()));
                    return gson.toJson(automovil);
                }

            }
            return gson.toJson("Automovil no encontrado en el parqueadero");
        });

        get("/registrarSalidaMoto/:placa", (req, res) -> {

            res.type("application/json");

            Date nuevaFecha = new Date();

            String placaMoto = req.params(":placa");

            for (Motocicleta motocicleta : motos) {
                if (motocicleta.getPlaca().equals(placaMoto)) {
                    motocicleta.setHoraSalida((nuevaFecha.getHours() + ":" + nuevaFecha.getMinutes()));
                    return gson.toJson(motocicleta);
                }
            }
            return gson.toJson("Motocicleta no encontrada en el parqueadero");
        });

        get("/AutomovilesActuales", (req, res) -> {
            res.type("application/json");

            LinkedList<Vehiculo> automovilesActuales = new LinkedList<>();

            for (Vehiculo automovil : automoviles) {
                if (automovil.getHoraSalida() == null) {
                    automovilesActuales.add(automovil);
                }
            }

            return gson.toJson(automovilesActuales);
        });

        get("/motosActuales", (req, res) -> {
            res.type("application/json");

            LinkedList<Motocicleta> motosActuales = new LinkedList<>();

            for (Motocicleta motocicleta : motos) {
                if (motocicleta.getHoraSalida() == null) {
                    motosActuales.add(motocicleta);
                }
            }

            return gson.toJson(motosActuales);
        });

        get("/motosReporte", (req, res) -> {
            res.type("application/json");

            LinkedList<String> informeMotos = new LinkedList<>();
            for (Motocicleta m : motos) {
                informeMotos.add("Placa: " + m.getPlaca()
                        + ", Ingresos: " + m.calcularIngresos()
                        + ", Hora de Entrada: " + m.getHoraIngreso()
                        + ", Hora de Salida: " + m.getHoraSalida());
            }

            return new Gson().toJson(informeMotos);
        });

        get("/AutomovilesReporte", (req, res) -> {
            res.type("application/json");

            LinkedList<String> informeAutomoviles = new LinkedList<>();
            for (Vehiculo a : automoviles) {
                informeAutomoviles.add("Placa: " + a.getPlaca()
                        + ", Ingresos: " + a.calcularIngresos()
                        + ", Hora de Entrada: " + a.getHoraIngreso()
                        + ", Hora de Salida: " + a.getHoraSalida());
            }
            return new Gson().toJson(informeAutomoviles);
        });

        // Endpoint para obtener las ganancias totales de motocicletas
        get("/totalGananciasMotos", (req, res) -> {
            res.type("application/json");

            int totalGananciasMotos = 0;
            for (Motocicleta m : motos) {
                totalGananciasMotos += m.calcularIngresos();
            }

            return new Gson().toJson(totalGananciasMotos);
        });

        // Endpoint para obtener las ganancias totales de automóviles
        get("/totalGananciasAutomoviles", (req, res) -> {
            res.type("application/json");

            int totalGananciasAutomoviles = 0;
            for (Vehiculo a : automoviles) {
                totalGananciasAutomoviles += a.calcularIngresos();
            }

            return new Gson().toJson(totalGananciasAutomoviles);
        });

        get("/totalGananciasDia", (req, res) -> {
            res.type("application/json");

            double totalGananciasDia = 0;

            for (Motocicleta m : motos) {
                totalGananciasDia += m.calcularIngresos();
            }

            for (Vehiculo a : automoviles) {
                totalGananciasDia += a.calcularIngresos();
            }

            return new Gson().toJson(totalGananciasDia);
        });
    }
}

package parcial_1;


import parcial_1.EmpleadoPorHoras;

public class Parcial_1 {
    public static void main(String[] args) {
        // Crear un arreglo de empleados
        Empleado[] empleados = new Empleado[10];

        // Llenar el arreglo con empleados asalariados y empleados por horas
        empleados[0] = new EmpleadoAsalariado("Empleado1", 3000.0, 200.0);
        empleados[1] = new EmpleadoAsalariado("Empleado2", 2500.0, 150.0);
        empleados[2] = new EmpleadoPorHoras("Empleado3", 0.0, 40, 15.0);
        empleados[3] = new EmpleadoPorHoras("Empleado4", 0.0, 35, 18.0);
        // Agrega más empleados aquí

        // 2.1 - Obtener Empleados por horas
        System.out.println("Empleados por horas:");
        for (Empleado empleado : empleados) {
            if (empleado instanceof EmpleadoPorHoras) {
                System.out.println("Nombre: " + empleado.getNombre() + ", Salario: " + empleado.calcularSalario());
            }
        }

        // 2.2 - Obtener Empleados Asalariados
        System.out.println("Empleados asalariados:");
        for (Empleado empleado : empleados) {
            if (empleado instanceof EmpleadoAsalariado) {
                System.out.println("Nombre: " + empleado.getNombre() + ", Salario: " + empleado.calcularSalario());
            }
        }

        // 3 - Modificar el nombre o salario de un empleado
        for (Empleado empleado : empleados) {
            if (empleado.getNombre().equals("Empleado1")) {
                empleado.setNombre("NuevoNombre");
                empleado.setSalarioBase(3500.0);
            }
        }

        // 4 - Obtener Empleados por horas (Para verificar que se modificó)
        System.out.println("Empleados por horas después de la modificación:");
        for (Empleado empleado : empleados) {
            if (empleado instanceof EmpleadoPorHoras) {
                System.out.println("Nombre: " + empleado.getNombre() + ", Salario: " + empleado.calcularSalario());
            }
        }

        // 5 - Obtener un empleado específico
        System.out.println("Obtener un empleado específico:");
        for (Empleado empleado : empleados) {
            if (empleado.getNombre().equals("Empleado3")) {
                System.out.println("Nombre: " + empleado.getNombre() + ", Salario: " + empleado.calcularSalario());
            }
        }
    }
}

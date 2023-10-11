package Main;

public class Main {
    public static void main(String[] args) {
       
        Empleado[] empleados = new Empleado[10];
        empleados[0] = new EmpleadoAsalariado("Miguel", 1500000, 50000);
        empleados[1] = new EmpleadoPorHoras("Jordan", 0, 40, 50000);
      
        System.out.println("Empleados por horas:");
        for (Empleado empleado : empleados) {
            if (empleado instanceof EmpleadoPorHoras) {
                System.out.println(empleado.nombre);
            }
        }

       
        System.out.println("Empleados asalariados:");
        for (Empleado empleado : empleados) {
            if (empleado instanceof EmpleadoAsalariado) {
                System.out.println(empleado.nombre);
            }
        }

     
        int indiceEmpleadoAModificar = 2;
        if (empleados[indiceEmpleadoAModificar] != null) {
            empleados[indiceEmpleadoAModificar].nombre = "Nuevo Nombre";
        }

      
        System.out.println("Empleados por horas despues de la modificacion:");
        for (Empleado empleado : empleados) {
            if (empleado instanceof EmpleadoPorHoras) {
                System.out.println(empleado.nombre);
            }
        }

       
        String nombreBuscado = "Miguel";
        System.out.println("Empleado buscado: " + nombreBuscado);
        for (Empleado empleado : empleados) {
            if (empleado != null && empleado.nombre.equals(nombreBuscado)) {
                System.out.println("Nombre: " + empleado.nombre);
                System.out.println("Salario: " + empleado.calcularSalario());
            }
        }
    }
}

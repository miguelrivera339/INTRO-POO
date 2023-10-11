package Main;

public class EmpleadoAsalariado extends Empleado {
    private double deducciones;

    public EmpleadoAsalariado(String nombre, double salarioBase, double deducciones) {
        super(nombre, salarioBase);
        this.deducciones = deducciones;
    }

    @Override
    public double calcularSalario() {
        return salarioBase - deducciones;
    }
}

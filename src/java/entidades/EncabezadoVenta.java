package entidades;

import java.util.Date;

public class EncabezadoVenta {
    private Empleado empleado;
    private String fecha;
    private Cliente cliente;

    public EncabezadoVenta(Empleado empleado, String fecha, Cliente cliente) {
        this.empleado = empleado;
        this.fecha = fecha;
        this.cliente = cliente;
    }

    public EncabezadoVenta(String fecha, Cliente cliente) {
        this.fecha = fecha;
        this.cliente = cliente;
    }

    
    
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
}

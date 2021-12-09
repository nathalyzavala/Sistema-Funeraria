package entidades;

public class DetalleVenta {
    private int id;
    private EncabezadoVenta encabezado;
    private Servicio servicio;
    private int cantidadCuotas;
    private boolean estado;
    private boolean devolucion;

     public DetalleVenta(EncabezadoVenta encabezado, Servicio servicio, int cantidadCuotas) {
        this.encabezado = encabezado;
        this.servicio = servicio;
        this.cantidadCuotas = cantidadCuotas;
    }

    public boolean isDevolucion() {
        return devolucion;
    }

    public void setDevolucion(boolean devolucion) {
        this.devolucion = devolucion;
    }
    
    public DetalleVenta(int id, EncabezadoVenta encabezado, Servicio servicio, int cantidadCuotas, boolean devolucion) {
        this.id = id;
        this.encabezado = encabezado;
        this.servicio = servicio;
        this.cantidadCuotas = cantidadCuotas;
        this.devolucion = devolucion;
    }

    public DetalleVenta(int id, Servicio servicio) {
        this.id = id;
        this.servicio = servicio;
    }
    
    public EncabezadoVenta getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(EncabezadoVenta encabezado) {
        this.encabezado = encabezado;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public int getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(int cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    
    
}

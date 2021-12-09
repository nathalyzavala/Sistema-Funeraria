package entidades;

public class DetalleServicio {
    private int id;
    private Servicio servicio;
    private Producto producto;
    private int cantidad;
    
    
    public DetalleServicio(Producto producto, int cantidad){
        this.producto = producto;
        this.cantidad = cantidad;
        this.id = id;
    }

    
    
    public DetalleServicio(Producto producto) {
        this.producto = producto;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}

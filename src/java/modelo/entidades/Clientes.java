package modelo.entidades;

public class Clientes {

    private String id_cliente;
    private String duic;
    private String nombrec;
    private String apellidoc;
    private String telefono;
    private String direccionc;

    public Clientes() {
    }
    

    public Clientes(String id_cliente, String duic, String nombrec, String apellidoc, String telefono, String direccionc) {
        this.id_cliente = id_cliente;
        this.duic = duic;
        this.nombrec = nombrec;
        this.apellidoc = apellidoc;
        this.telefono = telefono;
        this.direccionc = direccionc;
    }

    public Clientes(String duic, String nombrec, String apellidoc, String telefono, String direccionc) {
        this.duic = duic;
        this.nombrec = nombrec;
        this.apellidoc = apellidoc;
        this.telefono = telefono;
        this.direccionc = direccionc;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getDuic() {
        return duic;
    }

    public void setDuic(String duic) {
        this.duic = duic;
    }

    public String getNombrec() {
        return nombrec;
    }

    public void setNombrec(String nombrec) {
        this.nombrec = nombrec;
    }

    public String getApellidoc() {
        return apellidoc;
    }

    public void setApellidoc(String apellidoc) {
        this.apellidoc = apellidoc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccionc() {
        return direccionc;
    }

    public void setDireccionc(String direccionc) {
        this.direccionc = direccionc;
    }
    
    
}

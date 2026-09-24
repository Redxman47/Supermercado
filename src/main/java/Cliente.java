import java.util.ArrayList;
import java.util.List;
public class Cliente {
    private String nombreCompleto;
    private String direccion;
    private String telefono;
    private String correo;
    private List<Compra> listaCompras;

    public Cliente(String nombreCompleto, String direccion, String telefono, String correo) {
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.listaCompras = new ArrayList<>();
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public List<Compra> getListaCompras() {
        return listaCompras;
    }
    public void setListaCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }
    public void agregarCompra(Compra compra) {
        listaCompras.add(compra);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", listaCompras=" + listaCompras +
                '}';
    }
}

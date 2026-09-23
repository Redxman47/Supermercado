import java.util.ArrayList;
import java.util.List;

public class Supermercado {

    private String nombre;
    private String direccion;
    private String telefono;

    //Listas
    private List<Cliente> listaClientes;
    private List<Producto> listaProductos;
    private List<Compra> listaCompras;

    //Constructor
    public Supermercado(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;

        //Inicializar listas
        listaClientes= new ArrayList<>();
        listaProductos = new ArrayList<>();
        listaCompras = new ArrayList<>();
    }

    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }

    //toString
    @Override
    public String toString() {
        return nombre+ " " +direccion+ " " +telefono+ " "+listaClientes+ " "+listaProductos + " "+listaCompras;
    }



}

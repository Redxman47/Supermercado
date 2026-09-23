import java.time.LocalDate;
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

    //Metodo para verificar clientes
    public boolean verificarCliente(String documento){
        boolean existe=false;
        for(Cliente cliente:listaClientes){
            if(cliente.getDocumento().equals(documento)){
                existe=true;
                break;
            }
        }
        return existe;
    }

    //Metodo agregar cliente
    public boolean agregarCliente(Cliente cliente){
        boolean agregado=false;
        boolean existe=verificarCliente(cliente.getDocumento());
        if(existe==false){
            listaClientes.add(cliente);
            agregado=true;
        }
        return agregado;
    }

    //Metodo para buscar un cliente
    public Cliente buscarCliente(String documento){
        Cliente encontrado=null;
        for(Cliente cliente:listaClientes){
            if(cliente.getDocumento().equals(documento)){
                encontrado=cliente;
                break;
            }
        }
        return encontrado;
    }

    //Metodo actualizar cliente
    public boolean actualizarCliente(String documento, String nombreCompleto, String telefono, String correo){
        boolean actualizado=false;
        Cliente cliente=buscarCliente(documento);
        if(cliente!=null){
            cliente.setNombreCompleto(nombreCompleto);
            cliente.setTelefono(telefono);
            cliente.setCorreo(correo);
            actualizado=true;
        }
        return actualizado;
    }

    //Metodo eliminar cliente
    public boolean eliminarCliente(String documento){
        boolean eliminado=false;
        Cliente cliente=buscarCliente(documento);
        if(cliente!=null){
            listaClientes.remove(cliente);
            eliminado=true;
        }
        return eliminado;
    }


    //Metodo para verificar productos
    public boolean verificarProducto(String codigo){
        boolean existe=false;
        for(Producto producto:listaProductos){
            if(producto.getCodigo().equals(codigo)){
                existe=true;
                break;
            }
        }
        return existe;
    }

    //Metodo agregar producto
    public boolean agregarProducto(Producto producto){
        boolean agregado=false;
        boolean existe=verificarProducto(producto.getCodigo());
        if(existe==false){
            listaProductos.add(producto);
            agregado=true;
        }
        return agregado;
    }

    //Metodo para buscar un producto
    public Producto buscarProducto(String codigo){
        Producto encontrado=null;
        for(Producto producto:listaProductos){
            if(producto.getCodigo().equals(codigo)){
                encontrado=producto;
                break;
            }
        }
        return encontrado;
    }

    //Metodo actualizar producto
    public boolean actualizarProducto(String codigo, String nombre, Categoria categoria, double precioUnitario, int cantidadDisponible){
        boolean actualizado=false;
        Producto producto=buscarProducto(codigo);
        if(producto!=null){
            producto.setNombre(nombre);
            producto.setCategoria(categoria);
            producto.setPrecioUnitario(precioUnitario);
            producto.setCantidadDisponible(cantidadDisponible);
            actualizado=true;
        }
        return actualizado;
    }

    //Metodo eliminar producto
    public boolean eliminarProducto(String codigo){
        boolean eliminado=false;
        Producto producto=buscarProducto(codigo);
        if(producto!=null){
            listaProductos.remove(producto);
            eliminado=true;
        }
        return eliminado;
    }


    //Metodo para verificar compras
    public boolean verificarCompra(String codigo){
        boolean existe=false;
        for(Compra compra:listaCompras){
            if(compra.getCodigo().equals(codigo)){
                existe=true;
                break;
            }
        }
        return existe;
    }

    //Metodo agregar compra
    public boolean agregarCompra(Compra compra){
        boolean agregado=false;
        boolean existe=verificarCompra(compra.getCodigo());
        if(existe==false){
            listaCompras.add(compra);
            agregado=true;
        }
        return agregado;
    }

    //Metodo para generar el reporte de ventas de una fecha
    public double generarReporteVentas(LocalDate fecha){
        double total=0;
        for(Compra compra:listaCompras){
            if(compra.getFecha().equals(fecha)){
                total=total+compra.getValorTotal();
            }
        }
        return total;
    }


}

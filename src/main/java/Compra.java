import java.time.LocalDate;
import java.util.List;
public class Compra {
    private String codigo;
    private LocalDate fecha;
    private MetodoPago metodoPago;
    private double valorTotal;
    private List<Producto> listaComprarProductos;

    public Compra(String codigo, LocalDate fecha, MetodoPago metodoPago, double valorTotal, List<Producto> listaComprarProductos) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
        this.valorTotal = valorTotal;
        this.listaComprarProductos = listaComprarProductos;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public MetodoPago getMetodoPago() {
        return metodoPago;
    }
    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public List<Producto> getListaComprarProductos() {
        return listaComprarProductos;
    }
    public void setListaComprarProductos(List<Producto> listaComprarProductos) {
        this.listaComprarProductos = listaComprarProductos;
    }
    public void agregarProducto(Producto producto) {
        listaComprarProductos.add(producto);
    }
    public double calcularValorTotal() {
        double valorTotal = 0;
        {
            for (Producto producto : listaComprarProductos) {
                valorTotal += producto.getPrecioUnitario();
            }
        }
        return valorTotal;
    }
    public void confirmarCompra() {
        for (Producto producto : listaComprarProductos) {
            producto.validarDisponibilidad(1);
        }
        this.valorTotal = calcularValorTotal();
        System.out.println("Compra confirmada. Valor total: " + this.valorTotal + "");
    }
}

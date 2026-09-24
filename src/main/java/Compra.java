   import java.time.LocalDate;
    import java.util.ArrayList;
    import java.util.List;
    public class Compra {
        private String codigo;
        private LocalDate fecha;
        private MetodoPago metodoPago;
        private double valorTotal;
        private List<Producto> listaCompraProductos;
    
    
            public Compra(String codigo, LocalDate fecha, MetodoPago metodoPago) {
            this.codigo = codigo;
            this.fecha = fecha;
            this.metodoPago = metodoPago;
            this.valorTotal = 0;
            this.listaCompraProductos = new ArrayList<>();
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
        public List<Producto> getListaCompraProductos() {
            return listaCompraProductos;
        }
        public void setListaCompraProductos(List<Producto> listaComprarProductos) {
            this.listaCompraProductos = listaComprarProductos;
        }
        public boolean agregarProducto(Producto producto) {
            if (producto == null) {
                return false;
            }
            listaCompraProductos.add(producto);
            return true;
        }
        public double calcularValorTotal() {
            double valorTotal = 0;
            {
                for (Producto producto : listaCompraProductos) {
                    valorTotal += producto.getPrecioUnitario();
                }
            }
            return valorTotal;
        }
        public void confirmarCompra() {
            for (Producto producto : listaCompraProductos) {
                producto.validarDisponibilidad(1);
            }
            this.valorTotal = calcularValorTotal();
            System.out.println("Compra confirmada. Valor total: " + this.valorTotal + "");
        }
        @Override
        public String toString() {
            return "Compra{" +
                    "codigo='" + codigo + '\'' +
                    ", fecha=" + fecha +
                    ", metodoPago=" + metodoPago +
                    ", valorTotal=" + valorTotal +
                    ", lista de Compra de Productos=" + listaCompraProductos +
                    '}';
        }
    }


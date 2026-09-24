import java.time.LocalDate;
import java.util.Scanner;

public class Aplicacion {

    void main(){

        //Menu Interactivo

        Scanner sc=new Scanner(System.in);

        Supermercado supermercado=new Supermercado("MarketPlus", "Calle 10 #20-30", "3001234567");
        int opcion;
        do{

            System.out.println(" ========== Menu Supermercado =========== ");
            System.out.println("------Cliente------");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Actualizar Cliente");
            System.out.println("3. Eliminar Cliente");
            System.out.println("4. Mostrar Clientes");

            System.out.println("------Producto------");
            System.out.println("5. Agregar Producto");
            System.out.println("6. Actualizar Producto");
            System.out.println("7. Eliminar Producto");
            System.out.println("8. Mostrar Productos");

            System.out.println("------Compra------");
            System.out.println("9. Registrar Compra");
            System.out.println("10. Mostrar Compras");
            System.out.println("11. Consultar Compras de un Cliente");

            System.out.println("------Reportes------");
            System.out.println("12. Reporte de Ventas por Fecha");

            System.out.println("--------------------------------");
            System.out.println("0. Salir");

            opcion=sc.nextInt();
            sc.nextLine();

            switch(opcion){
                //=============Cliente==============
                case 1:
                    System.out.println("----- Agregar Cliente -----");

                    System.out.print("Ingrese el nombre completo del cliente: ");
                    String nombreCliente=sc.nextLine();

                    System.out.print("Ingrese el documento del cliente: ");
                    String documentoCliente=sc.nextLine();

                    System.out.print("Ingrese el telefono del cliente: ");
                    String telefonoCliente=sc.nextLine();

                    System.out.print("Ingrese el correo del cliente: ");
                    String correoCliente=sc.nextLine();

                    Cliente cliente=new Cliente(nombreCliente, documentoCliente, telefonoCliente, correoCliente);
                    if(supermercado.agregarCliente(cliente)){
                        System.out.println("Cliente agregado exitosamente.");
                    }else{
                        System.out.println("Ya existe un cliente con ese documento.");
                    }
                    break;

                case 2:
                    System.out.println("----- Actualizar Cliente -----");

                    System.out.print("Ingrese el documento del cliente a actualizar: ");
                    String documentoActualizarCliente=sc.nextLine();

                    if(supermercado.verificarCliente(documentoActualizarCliente)){
                        System.out.print("Ingrese el nuevo nombre completo del cliente: ");
                        String nuevoNombreCliente=sc.nextLine();

                        System.out.print("Ingrese el nuevo telefono del cliente: ");
                        String nuevoTelefonoCliente=sc.nextLine();

                        System.out.print("Ingrese el nuevo correo del cliente: ");
                        String nuevoCorreoCliente=sc.nextLine();

                        supermercado.actualizarCliente(documentoActualizarCliente, nuevoNombreCliente, nuevoTelefonoCliente, nuevoCorreoCliente);
                        System.out.println("Cliente actualizado exitosamente.");
                    }else{
                        System.out.println("No existe un cliente con ese documento.");
                    }
                    break;

                case 3:
                    System.out.println("----- Eliminar Cliente -----");

                    System.out.print("Ingrese el documento del cliente a eliminar: ");
                    String documentoEliminarCliente=sc.nextLine();

                    if(supermercado.eliminarCliente(documentoEliminarCliente)){
                        System.out.println("Cliente eliminado exitosamente.");
                    }else{
                        System.out.println("No existe un cliente con ese documento.");
                    }
                    break;

                case 4:
                    System.out.println("----- Mostrar Clientes -----");

                    if(supermercado.getListaClientes().isEmpty()){
                        System.out.println("No hay clientes registrados.");
                    }else{
                        for(Cliente c:supermercado.getListaClientes()){
                            System.out.println(c);
                        }
                    }
                    break;

                //=============Producto==============
                case 5:
                    System.out.println("----- Agregar Producto -----");

                    System.out.print("Ingrese el codigo del producto: ");
                    String codigoProducto=sc.nextLine();

                    System.out.print("Ingrese el nombre del producto: ");
                    String nombreProducto=sc.nextLine();

                    Categoria categoriaProducto=pedirCategoria(sc);

                    System.out.print("Ingrese el precio unitario del producto: ");
                    double precioProducto=sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Ingrese la cantidad disponible del producto: ");
                    int cantidadProducto=sc.nextInt();
                    sc.nextLine();

                    Producto producto=new Producto(codigoProducto, nombreProducto, categoriaProducto, precioProducto, cantidadProducto);
                    if(supermercado.agregarProducto(producto)){
                        System.out.println("Producto agregado exitosamente.");
                    }else{
                        System.out.println("Ya existe un producto con ese codigo.");
                    }
                    break;

                case 6:
                    System.out.println("----- Actualizar Producto -----");

                    System.out.print("Ingrese el codigo del producto a actualizar: ");
                    String codigoActualizarProducto=sc.nextLine();

                    if(supermercado.verificarProducto(codigoActualizarProducto)){
                        System.out.print("Ingrese el nuevo nombre del producto: ");
                        String nuevoNombreProducto=sc.nextLine();

                        Categoria nuevaCategoriaProducto=pedirCategoria(sc);

                        System.out.print("Ingrese el nuevo precio unitario del producto: ");
                        double nuevoPrecioProducto=sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Ingrese la nueva cantidad disponible del producto: ");
                        int nuevaCantidadProducto=sc.nextInt();
                        sc.nextLine();

                        supermercado.actualizarProducto(codigoActualizarProducto, nuevoNombreProducto, nuevaCategoriaProducto, nuevoPrecioProducto, nuevaCantidadProducto);
                        System.out.println("Producto actualizado exitosamente.");
                    }else{
                        System.out.println("No existe un producto con ese codigo.");
                    }
                    break;

                case 7:
                    System.out.println("----- Eliminar Producto -----");

                    System.out.print("Ingrese el codigo del producto a eliminar: ");
                    String codigoEliminarProducto=sc.nextLine();

                    if(supermercado.eliminarProducto(codigoEliminarProducto)){
                        System.out.println("Producto eliminado exitosamente.");
                    }else{
                        System.out.println("No existe un producto con ese codigo.");
                    }
                    break;

                case 8:
                    System.out.println("----- Mostrar Productos -----");

                    if(supermercado.getListaProductos().isEmpty()){
                        System.out.println("No hay productos registrados.");
                    }else{
                        for(Producto p:supermercado.getListaProductos()){
                            System.out.println(p);
                        }
                    }
                    break;

                //=============Compra==============
                case 9:
                    System.out.println("----- Registrar Compra -----");

                    System.out.print("Ingrese el documento del cliente que realiza la compra: ");
                    String documentoCompra=sc.nextLine();

                    Cliente clienteCompra=supermercado.buscarCliente(documentoCompra);
                    if(clienteCompra==null){
                        System.out.println("No existe un cliente con ese documento.");
                        break;
                    }

                    System.out.print("Ingrese el codigo de la compra: ");
                    String codigoCompra=sc.nextLine();

                    if(supermercado.verificarCompra(codigoCompra)){
                        System.out.println("Ya existe una compra con ese codigo.");
                        break;
                    }

                    System.out.print("Ingrese la fecha de la compra (yyyy-MM-dd): ");
                    LocalDate fechaCompra=LocalDate.parse(sc.nextLine());

                    MetodoPago metodoPago=pedirMetodoPago(sc);

                    Compra compra=new Compra(codigoCompra, fechaCompra, metodoPago);

                    //Seleccion de productos: cada vez que se ingresa un codigo se agrega una unidad
                    String codigoSeleccionado;
                    do{
                        System.out.print("Ingrese el codigo del producto a agregar (0 para terminar): ");
                        codigoSeleccionado=sc.nextLine();

                        if(!codigoSeleccionado.equals("0")){
                            Producto productoSeleccionado=supermercado.buscarProducto(codigoSeleccionado);
                            if(productoSeleccionado==null){
                                System.out.println("No existe un producto con ese codigo.");
                            }else if(compra.agregarProducto(productoSeleccionado)){
                                System.out.println(productoSeleccionado.getNombre() + " agregado. Subtotal: " + compra.calcularValorTotal());
                            }else{
                                System.out.println("No hay unidades disponibles de " + productoSeleccionado.getNombre() + ".");
                            }
                        }
                    }while(!codigoSeleccionado.equals("0"));

                    if(compra.getListaCompraProductos().isEmpty()){
                        System.out.println("La compra no tiene productos, no se registro.");
                    }else{
                        compra.confirmarCompra();
                        supermercado.agregarCompra(compra);
                        clienteCompra.agregarCompra(compra);
                        System.out.println("Compra registrada exitosamente. Valor total: " + compra.getValorTotal());
                    }
                    break;

                case 10:
                    System.out.println("----- Mostrar Compras -----");

                    if(supermercado.getListaCompras().isEmpty()){
                        System.out.println("No hay compras registradas.");
                    }else{
                        for(Compra c:supermercado.getListaCompras()){
                            System.out.println(c);
                        }
                    }
                    break;

                case 11:
                    System.out.println("----- Compras de un Cliente -----");

                    System.out.print("Ingrese el documento del cliente: ");
                    String documentoConsulta=sc.nextLine();

                    Cliente clienteConsulta=supermercado.buscarCliente(documentoConsulta);
                    if(clienteConsulta==null){
                        System.out.println("No existe un cliente con ese documento.");
                    }else if(clienteConsulta.getListaCompras().isEmpty()){
                        System.out.println("El cliente no tiene compras registradas.");
                    }else{
                        for(Compra c:clienteConsulta.getListaCompras()){
                            System.out.println(c);
                        }
                    }
                    break;

                //=============Reportes==============
                case 12:
                    System.out.println("----- Reporte de Ventas -----");

                    System.out.print("Ingrese la fecha a consultar (yyyy-MM-dd): ");
                    LocalDate fechaReporte=LocalDate.parse(sc.nextLine());

                    double totalVendido=supermercado.generarReporteVentas(fechaReporte);
                    System.out.println("Valor total vendido el " + fechaReporte + ": " + totalVendido);
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        }while(opcion!=0);
        sc.close();
    }

    private MetodoPago pedirMetodoPago(Scanner sc) {
        System.out.println("Seleccione el metodo de pago:");
        System.out.println("1. Tarjeta");
        System.out.println("2. Transferencia bancaria");
        System.out.println("3. Efectivo");
        int opcionMetodoPago=sc.nextInt();
        sc.nextLine();

        return switch(opcionMetodoPago){
            case 1 -> MetodoPago.TARJETA;
            case 2 -> MetodoPago.TRANSFERENCIA;
            case 3 -> MetodoPago.EFECTIVO;
            default -> null;
        };
    }

    private Categoria pedirCategoria(Scanner sc) {
        System.out.println("Seleccione la categoria del producto:");
        System.out.println("1. Alimentos");
        System.out.println("2. Bebidas");
        System.out.println("3. Productos de aseo");
        System.out.println("4. Cuidado personal");
        int opcionCategoria=sc.nextInt();
        sc.nextLine();

        return switch(opcionCategoria){
            case 1 -> Categoria.ALIMENTOS;
            case 2 -> Categoria.BEBIDAS;
            case 3 -> Categoria.PRODUCTOS_ASEO;
            case 4 -> Categoria.CUIDADO_PERSONAL;
            default -> null;
        };
    }
}







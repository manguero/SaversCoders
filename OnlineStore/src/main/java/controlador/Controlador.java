package controlador;

import vista.Vista;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Articulo;
import modelo.Cliente;
import modelo.Pedido;

public class Controlador {

    ArticuloControlador ac = new ArticuloControlador();
    ClienteControlador cc = new ClienteControlador();
    PedidoControlador pc = new PedidoControlador();

    private final Vista vista;
    private int opcion = 0;

    public Controlador(/*Datos modelo,*/ Vista vista) {
        //this.modelo = modelo;
        this.vista = vista;
    }

    // MENU PRINCIPAL
    // Vista menu general
    public void mostrarMenuPrincipal() throws Exception {
        opcion = vista.printMenu();
        performActionMenu(opcion);
    }


    // Accion del menu principal
    public void performActionMenu(int choice) throws Exception {
        switch (choice) {
            case 0 -> OnlineStore.salirAplicacion();
            case 1 -> gestionArticulos();
            case 2 -> gestionClientes();
            case 3 -> gestionPedidos();
        }
    }

    //Gestion de articulos
    public void gestionArticulos() throws Exception {
        opcion = vista.printMenuArticulos();
        opcionesArticulos(opcion);
    }

    public void opcionesArticulos(int choice) throws Exception {
        switch (choice) {
            case 0 -> mostrarMenuPrincipal();
            case 1 -> agregarArticulo();
            case 2 -> mostrarArticulos();
            case 3 -> editarArticulo();
            case 4 -> eliminarArticulo();

        }
    }

    public void agregarArticulo() {
        boolean creado = false;
        List parametros = new ArrayList<>();

        parametros = vista.printAgregarArticulo();


        //si la información no está vacia
        if (!parametros.isEmpty()) {
            //NO HAY QUE HACER COMPROBACION DE QUE EXISTA
            //EL JPA YA TE IMPIDE CREAR UN ARTICULO CON UNA LLAVE PRIMARIA DUPLICADA

            try {
                //Creamos un nuevo objeto artículo y le pasamos los parámetros obtenidos en la vista
                Articulo articulo = new Articulo(parametros.get(0).toString(), parametros.get(1).toString(),
                        (Double) parametros.get(2), (Double) parametros.get(3), (Integer) parametros.get(4));
                //Utilizamos la instancia de ArticuloControlador que hemos hecho arriba y lo utilizamos para crear
                ac.crear(articulo);
                creado = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        vista.articuloCreado(creado);
    }

    public void mostrarArticulos() {
        // Crear una array temporal para recibir articulos
        // Llenar la array con los articulos
        List<Articulo> lista = ac.getArticulos();

        // Llamar a la vista para mostrar los articulos
        vista.printMostrarArticulos(lista);
    }

    public void editarArticulo() {
        boolean editado = false;
        List parametros = new ArrayList<>();


        parametros = vista.printAgregarArticulo();

        //si la información no está vacia
        if (!parametros.isEmpty()) {
            //NO HAY QUE HACER COMPROBACION DE QUE EXISTA
            //EL JPA YA TE IMPIDE CREAR UN ARTICULO CON UNA LLAVE PRIMARIA DUPLICADA

            try {
                //Creamos un nuevo objeto artículo y le pasamos los parámetros obtenidos en la vista
                Articulo articulo = new Articulo(parametros.get(0).toString(), parametros.get(1).toString(),
                        (Double) parametros.get(2), (Double) parametros.get(3), (Integer) parametros.get(4));

                //Ahora editamos
                ac.editar(articulo);
                editado = true;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        vista.articuloEditado(editado);
    }


    public void eliminarArticulo() {
        boolean eliminado = false;
        String codigoArticulo;

        codigoArticulo = vista.printAgregarCodigoArticulo();


        //si la información no está vacia
        if (!codigoArticulo.isEmpty()) {
            //NO HAY QUE HACER COMPROBACION DE QUE EXISTA
            //EL JPA YA TE IMPIDE CREAR UN ARTICULO CON UNA LLAVE PRIMARIA DUPLICADA Y TE AVISA

            try {
                //Creamos un nuevo objeto artículo y le asignamos el articulo buscado por su codigo
                Articulo articulo = ac.buscarArticuloPorCodigo(codigoArticulo);

                //Utilizamos la instancia de ArticuloControlador que hemos hecho arriba y lo utilizamos para crear
                ac.eliminar(articulo);
                eliminado = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        vista.articuloEliminado(eliminado);
    }


    //Gestion de clientes
    public void gestionClientes() throws Exception {
        opcion = vista.printMenuClientes();
        opcionesClientes(opcion);
    }

    public void opcionesClientes(int choice) throws Exception {
        switch (choice) {
            case 0 -> mostrarMenuPrincipal();
            case 1 -> agregarCliente();
            case 2 -> mostrarClientes();
            case 3 -> editarCliente();
            case 4 -> eliminarCliente();
            case 5 -> mostrarClientesEstandar();
            case 6 -> mostrarClientesPremium();

        }
    }

    public void agregarCliente() {
        boolean creado = false;
        List parametros = new ArrayList<>();

        parametros = vista.printAgregarCliente();


        //si la información no está vacia
        if (!parametros.isEmpty()) {
            //NO HAY QUE HACER COMPROBACION DE QUE EXISTA
            //EL JPA YA TE IMPIDE CREAR UN Cliente CON UNA LLAVE PRIMARIA DUPLICADA

            if(parametros.get(0).equals(1)) {
                try {
                    //Creamos un nuevo objeto artículo y le pasamos los parámetros obtenidos en la vista
                    Cliente cliente = new Cliente(parametros.get(1).toString(), parametros.get(2).toString(),
                            parametros.get(3).toString(), parametros.get(4).toString(),
                            0, 0);
                    //Utilizamos la instancia de ArticuloControlador que hemos hecho arriba y lo utilizamos para crear
                    cc.crear(cliente);
                    creado = true;

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if(parametros.get(0).equals(2)){
                Cliente cliente = new Cliente(parametros.get(1).toString(), parametros.get(2).toString(),
                        parametros.get(3).toString(), parametros.get(4).toString(),
                        30, 20);
                cc.crear(cliente);
                creado = true;

            }
        }
        vista.clienteCreado(creado);

    }

    public void mostrarClientes() {
        // Crear una array temporal para recibir articulos
        // Llenar la array con los articulos
        List<Cliente> lista = cc.getClientes();

        // Llamar a la vista para mostrar los articulos
        vista.printMostrarClientes(lista);
    }

    public void editarCliente() {
        boolean editado = false;
        List parametros = new ArrayList<>();


        parametros = vista.printAgregarCliente();

        //si la información no está vacia
        if (!parametros.isEmpty()) {
            //NO HAY QUE HACER COMPROBACION DE QUE EXISTA
            //EL JPA YA TE IMPIDE CREAR UN ARTICULO CON UNA LLAVE PRIMARIA DUPLICADA

            if(parametros.get(0).equals(1)) {
                try {
                    //Creamos un nuevo objeto artículo y le pasamos los parámetros obtenidos en la vista
                    Cliente cliente = new Cliente(parametros.get(1).toString(), parametros.get(2).toString(),
                            parametros.get(3).toString(), parametros.get(4).toString(),
                            0, 0);
                    //Utilizamos la instancia de ArticuloControlador que hemos hecho arriba y lo utilizamos para crear
                    cc.editar(cliente);
                    editado = true;

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if(parametros.get(0).equals(2)){
                Cliente cliente = new Cliente(parametros.get(1).toString(), parametros.get(2).toString(),
                        parametros.get(3).toString(), parametros.get(4).toString(),
                        30, 20);
                cc.editar(cliente);
                editado = true;

            }
        }
        vista.clienteCreado(editado);

    }


    public void eliminarCliente() {
        boolean eliminado = false;
        String emailCliente;

        emailCliente = vista.printAgregarEmailCliente();


        //si la información no está vacia
        if (!emailCliente.isEmpty()) {
            //NO HAY QUE HACER COMPROBACION DE QUE EXISTA
            //EL JPA YA TE IMPIDE CREAR UN ARTICULO CON UNA LLAVE PRIMARIA DUPLICADA Y TE AVISA

            try {

                Cliente cliente = cc.buscarClientePorEmail(emailCliente);

                //Utilizamos la instancia de ArticuloControlador que hemos hecho arriba y lo utilizamos para crear
                cc.eliminar(cliente);
                eliminado = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        vista.clienteEliminado(eliminado);
    }

    public void mostrarClientesEstandar() {
        // Crear una array temporal para recibir articulos
        // Llenar la array con los articulos
        List<Cliente> lista = cc.getClientesEstandar();

        // Llamar a la vista para mostrar los articulos
        vista.printMostrarClientesEstandar(lista);
    }

    public void mostrarClientesPremium() {
        // Crear una array temporal para recibir articulos
        // Llenar la array con los articulos
        List<Cliente> lista = cc.getClientesPremium();

        // Llamar a la vista para mostrar los articulos
        vista.printMostrarClientesPremium(lista);
    }



    //Gestion de pedidos
    public void gestionPedidos() throws Exception {
        opcion = vista.printMenuPedidos();
        opcionesPedidos(opcion);
    }

    public void opcionesPedidos(int choice) throws Exception {
        switch (choice) {
            case 0 -> mostrarMenuPrincipal();
            case 1 -> agregarPedido();
            case 2 -> mostrarPedidos();
            case 3 -> editarPedido();
            case 4 -> eliminarPedido();
            case 5 -> mostrarPedidosPendientes();
            case 6 -> mostrarPedidosEnviados();

        }
    }

    public void agregarPedido() {
        boolean creado = false;
        String emailCliente = vista.printAgregarEmailPedido();
        String codigoArticulo = vista.printAgregarArticuloPedido();
        int cantidad = vista.printAgregarCantidadPedido();
        Cliente clientePedido = cc.buscarClientePorEmail(emailCliente);
        Articulo articuloPedido = ac.buscarArticuloPorCodigo(codigoArticulo);

        Date date = new Date();
        java.sql.Timestamp dateSQL = new java.sql.Timestamp(date.getTime());

        boolean procesado = false;

            //NO HAY QUE HACER COMPROBACION DE QUE EXISTA
            //EL JPA YA TE IMPIDE CREAR UN pedido CON UNA LLAVE PRIMARIA DUPLICADA

            try {
                //Creamos un nuevo objeto pedido y le pasamos los parámetros obtenidos en la vista
                Pedido pedido = new Pedido(clientePedido, articuloPedido, cantidad, dateSQL, procesado);
                //Utilizamos la instancia de ArticuloControlador que hemos hecho arriba y lo utilizamos para crear
                pc.crear(pedido);
                creado = true;
            } catch (Exception e) {
                e.printStackTrace();
            }

        vista.pedidoCreado(creado);
    }

    public void mostrarPedidos() {
        pc.actualizarPedidos();
        // Crear una array temporal para recibir articulos
        // Llenar la array con los articulos
        List<Pedido> lista = pc.getPedidos();

        // Llamar a la vista para mostrar los articulos
        vista.printMostrarPedidos(lista);
    }

    public void editarPedido() {
        pc.actualizarPedidos();
        boolean editado = false;
        int numeroPedido = vista.printAgregarNumeroPedido();

        String emailCliente = vista.printAgregarEmailPedido();
        String codigoArticulo = vista.printAgregarArticuloPedido();
        int cantidad = vista.printAgregarCantidadPedido();
        Cliente clientePedido = cc.buscarClientePorEmail(emailCliente);
        Articulo articuloPedido = ac.buscarArticuloPorCodigo(codigoArticulo);

        Date date = new Date();
        java.sql.Timestamp dateSQL = new java.sql.Timestamp(date.getTime());

        boolean procesado = false;


            try {
                //Creamos un nuevo objeto pedido y le pasamos los parámetros obtenidos en la vista y en los diferentes controladores
                Pedido pedido = new Pedido(numeroPedido, clientePedido, articuloPedido, cantidad, dateSQL, procesado);

                //Ahora editamos
                pc.editar(pedido);
                editado = true;
            } catch (Exception e) {
                e.printStackTrace();
            }


        vista.pedidoEditado(editado);
    }


    public void eliminarPedido() {
        pc.actualizarPedidos();
        boolean eliminado = false;
        int numeroPedido = vista.printAgregarNumeroPedido();

        
            try {
                Pedido pedido = pc.buscarPedidoPorNumero(numeroPedido);

                //Utilizamos la instancia de PedidoControlador que hemos hecho arriba y lo utilizamos para crear
                pc.eliminar(pedido);
                eliminado = true;
            } catch (Exception e) {
                e.printStackTrace();
            }



        vista.pedidoEliminado(eliminado);
    }

    public void mostrarPedidosPendientes() {
        pc.actualizarPedidos();
        // Crear una array temporal para recibir articulos
        // Llenar la array con los articulos
        List<Pedido> lista = pc.getPedidosPendientes();

        // Llamar a la vista para mostrar los articulos
        vista.printMostrarPedidosPendientes(lista);
    }

    public void mostrarPedidosEnviados() {
        pc.actualizarPedidos();
        // Crear una array temporal para recibir articulos
        // Llenar la array con los articulos
        List<Pedido> lista = pc.getPedidosEnviados();

        // Llamar a la vista para mostrar los articulos
        vista.printMostrarPedidosEnviados(lista);
    }


}

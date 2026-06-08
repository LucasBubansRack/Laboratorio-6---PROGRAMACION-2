package Pedido;

import Cliente.Cliente;
import ItemPedido.ItemPedido;
import MedioVenta.MedioVenta;
import PedidoInvalido.PedidoInvalidoException;

import java.util.ArrayList;

public class Pedido {
    private Cliente cliente;
    private MedioVenta medio;
    private ArrayList<ItemPedido> items;

    public Pedido() {
    }

    public Pedido(Cliente cliente, MedioVenta medio) {
        this.cliente = cliente;
        this.medio = medio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public MedioVenta getMedio() {
        return medio;
    }

    public void setMedio(MedioVenta medio) {
        this.medio = medio;
    }

    public ArrayList<ItemPedido> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemPedido> items) {
        this.items = items;
    }

    public void agregarItem(ItemPedido item){
        if (item == null){
            throw new IllegalArgumentException("El item no puede ser nulo");
        }
        if (this.items == null){
            this.items = new ArrayList<>();
        }
        this.items.add(item);
    }

    public double calcularTotal() throws PedidoInvalidoException {
        double total = 0.0;
        if (items != null){
            for (ItemPedido item : items){
                if (item != null){
                    total += item.calcularSubtotal();
                }
            }
        }
        return total;
    }

    public void mostrarResumen() throws PedidoInvalidoException {
        double total = calcularTotal();
        System.out.println("===== RESUMEN PEDIDO =====");
        System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellido());
        System.out.println("Mail: " + cliente.getMail());
        System.out.println("Teléfono: " + cliente.getTelefono());
        System.out.println("Dirección: " + cliente.getDireccion());
        System.out.println("Medio de venta: " + medio);
        System.out.println("Items: ");
        for (ItemPedido item : items) {
            System.out.println(" - " + item.getPasta().getTipo()
                    + " | cantidad = " + item.getCantidad()
                    + " | precio = " + item.getPasta().getPrecio()
                    + " | subtotal = " + item.calcularSubtotal());
        }
        System.out.println("TOTAL: " + total);
        System.out.println("==========================");
    }

}

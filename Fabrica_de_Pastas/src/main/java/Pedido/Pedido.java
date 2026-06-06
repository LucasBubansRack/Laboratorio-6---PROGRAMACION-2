package Pedido;

import Cliente.Cliente;
import ItemPedido.ItemPedido;
import MedioVenta.MedioVenta;

import java.util.ArrayList;

public class Pedido {
    private Cliente cliente;
    private MedioVenta medio;
    private ArrayList<ItemPedido> items;

    public Pedido() {
    }

    public Pedido(Cliente cliente, MedioVenta medio, ArrayList<ItemPedido> items) {
        this.cliente = cliente;
        this.medio = medio;
        this.items = items;
    }



}

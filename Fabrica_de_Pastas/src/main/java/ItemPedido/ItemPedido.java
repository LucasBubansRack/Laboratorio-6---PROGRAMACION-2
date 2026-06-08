package ItemPedido;

import PedidoInvalido.PedidoInvalidoException;
import TipoPastaInfo.TipoPastaInfo;

import javax.swing.*;

public class ItemPedido {
    private TipoPastaInfo pasta;
    private double cantidad;

    public ItemPedido() {
    }

    public ItemPedido(TipoPastaInfo pasta, double cantidad) throws PedidoInvalidoException {
        this.pasta = pasta;
        this.cantidad = cantidad;
    }

    public TipoPastaInfo getPasta() {
        return pasta;
    }

    public void setPasta(TipoPastaInfo pasta) {
        this.pasta = pasta;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double calcularSubtotal(){
        validarCantidad();
        if (pasta == null){
            throw new IllegalStateException("Pasta no puede ser nulo");
        }
        return cantidad * pasta.getPrecio();
    }

    public void validarCantidad(){
        if (cantidad <= 0){
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
    }
}

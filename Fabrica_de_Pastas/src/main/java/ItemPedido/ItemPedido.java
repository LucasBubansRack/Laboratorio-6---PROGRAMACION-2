package ItemPedido;

import TipoPasta.TipoPasta;

import javax.swing.*;

public class ItemPedido {
    private TipoPasta pasta;
    private double cantidad;

    public ItemPedido() {
    }

    public ItemPedido(TipoPasta pasta, double cantidad) {
        this.pasta = pasta;
        this.cantidad = cantidad;
    }

    public TipoPasta getPasta() {
        return pasta;
    }

    public void setPasta(TipoPasta pasta) {
        this.pasta = pasta;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double calcularSubtotal(float precio){
        if (precio >= 0.0) {
            return cantidad * precio;
        }else {
            JOptionPane.showInputDialog("ERROR.Precio invalido");
            return 1;
        }
    }
}

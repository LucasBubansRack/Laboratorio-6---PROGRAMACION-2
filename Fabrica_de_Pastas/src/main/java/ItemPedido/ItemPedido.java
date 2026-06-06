package ItemPedido;

import TipoPasta.TipoPasta;

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

    public double calcularSubtotal(){
        switch (pasta) {

            case FIDEOS_AL_HUEVO:
                return cantidad * 3000;

            case NOQUIS:
                return cantidad * 3500;

            case RAVIOLES:
                return cantidad * 5000;

            case AGNOLOTIS:
                return cantidad * 5500;

            default:
                return 0;
        }
    }
}

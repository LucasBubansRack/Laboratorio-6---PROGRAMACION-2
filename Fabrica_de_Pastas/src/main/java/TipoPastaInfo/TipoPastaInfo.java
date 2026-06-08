package TipoPastaInfo;

import TipoPasta.TipoPasta;

public class TipoPastaInfo {
    private TipoPasta tipo;
    private double precio;

    public TipoPastaInfo() {
    }

    public TipoPastaInfo(TipoPasta tipo, double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }

    public TipoPasta getTipo() {
        return tipo;
    }

    public void setTipo(TipoPasta tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

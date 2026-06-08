package ItemPedido;

import PedidoInvalido.PedidoInvalidoException;
import TipoPasta.TipoPasta;
import TipoPastaInfo.TipoPastaInfo;

import javax.swing.*;

public class ItemPedido {
    private TipoPastaInfo pasta;
    private double cantidad;

    public ItemPedido(TipoPastaInfo pasta, double cantidad) throws PedidoInvalidoException {
        this.pasta = pasta;
        this.cantidad = cantidad;
        validarCantidad(cantidad);
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

    public double calcularSubtotal() throws PedidoInvalidoException {
        validarCantidad(cantidad);
        if (pasta == null){
            throw new IllegalStateException("Pasta no puede ser nulo");
        }
        return cantidad * pasta.getPrecio();
    }

    public void validarCantidad(double cantidad) throws PedidoInvalidoException {

            if (pasta.getTipo() == TipoPasta.RAVIOLES || pasta.getTipo() == TipoPasta.AGNOLOTIS) {

                // Validación de cajas
                if (cantidad <= 0) {
                    throw new PedidoInvalidoException(
                            "La cantidad de cajas debe ser mayor a 0."
                    );
                }

                if (cantidad % 1 != 0) {
                    throw new PedidoInvalidoException(
                            "Las cajas deben ser un número entero."
                    );
                }
            } else {

                // Validación de kg
                if (cantidad <= 0) {
                    throw new PedidoInvalidoException(
                            "Los kg deben ser mayores a 0."
                    );
                }

                if (cantidad > 10) {
                    throw new PedidoInvalidoException(
                            "No se pueden pedir más de 10 kg."
                    );
                }
            }
        }
    }

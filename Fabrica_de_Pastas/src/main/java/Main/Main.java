package Main;

import Cliente.Cliente;
import ItemPedido.ItemPedido;
import MedioVenta.MedioVenta;
import Pedido.Pedido;
import PedidoInvalido.PedidoInvalidoException;
import TipoPasta.TipoPasta;
import TipoPastaInfo.TipoPastaInfo;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            // CARGO LOS PRECIOS DE LOS PRODUCTOS
            System.out.println("=== CONFIGURACION DE PRECIOS ===");

            double precioFideos;
            double precioRavioles;
            double precioNoquis;
            double precioAgnolotis;

            System.out.print("Precio Fideos al huevo ($/kg): ");
            precioFideos = sc.nextDouble();

            System.out.print("Precio Ravioles ($/caja): ");
            precioRavioles = sc.nextDouble();

            System.out.print("Precio Ñoquis ($/kg): ");
            precioNoquis = sc.nextDouble();

            System.out.print("Precio Agnolotis ($/caja): ");
            precioAgnolotis = sc.nextDouble();

            sc.nextLine();

            // CARGO LOS DATOS DEL CLIENTE
            System.out.println("\n=== DATOS DEL CLIENTE ===");

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Apellido: ");
            String apellido = sc.nextLine();

            System.out.print("Mail: ");
            String mail = sc.nextLine();

            System.out.print("Telefono: ");
            String telefono = sc.nextLine();

            System.out.print("Direccion: ");
            String direccion = sc.nextLine();

            Cliente cliente = new Cliente(
                    nombre,
                    apellido,
                    mail,
                    telefono,
                    direccion
            );

            // MEDIO DE VENTA
            System.out.println("\n=== MEDIO DE VENTA ===");
            System.out.println("1- Telefono");
            System.out.println("2- Web");
            System.out.println("3- Redes Sociales");

            int opcion = sc.nextInt();

            MedioVenta medio;

            switch (opcion) {
                case 1:
                    medio = MedioVenta.TELEFONO;
                    break;
                case 2:
                    medio = MedioVenta.WEB;
                    break;
                case 3:
                    medio = MedioVenta.REDES_SOCIALES;
                    break;
                default:
                    throw new IllegalArgumentException("Medio de venta invalido.");
            }

            Pedido pedido = new Pedido(cliente, medio);

            // ITEMS DEL PEDIDO
            char continuar;
            do {

                System.out.println("\n=== TIPO DE PASTA ===");
                System.out.println("1- Fideos al huevo");
                System.out.println("2- Ravioles");
                System.out.println("3- Ñoquis");
                System.out.println("4- Agnolotis");

                int tipo = sc.nextInt();

                TipoPastaInfo pastaInfo;
                double cantidad;

                switch (tipo) {

                    case 1:

                        System.out.print("Kg de fideos: ");
                        cantidad = sc.nextDouble();

                        pastaInfo = new TipoPastaInfo(
                                TipoPasta.FIDEOS_AL_HUEVO,
                                precioFideos
                        );

                        pedido.agregarItem(
                                new ItemPedido(pastaInfo, cantidad)
                        );

                        break;

                    case 2:

                        System.out.print("Cantidad de cajas: ");
                        cantidad = sc.nextDouble();

                        pastaInfo = new TipoPastaInfo(
                                TipoPasta.RAVIOLES,
                                precioRavioles
                        );

                        pedido.agregarItem(
                                new ItemPedido(pastaInfo, cantidad)
                        );

                        break;

                    case 3:

                        System.out.print("Kg de ñoquis: ");
                        cantidad = sc.nextDouble();

                        pastaInfo = new TipoPastaInfo(
                                TipoPasta.ÑOQUIS,
                                precioNoquis
                        );

                        pedido.agregarItem(
                                new ItemPedido(pastaInfo, cantidad)
                        );

                        break;

                    case 4:

                        System.out.print("Cantidad de cajas: ");
                        cantidad = sc.nextDouble();

                        pastaInfo = new TipoPastaInfo(
                                TipoPasta.AGNOLOTIS,
                                precioAgnolotis
                        );

                        pedido.agregarItem(
                                new ItemPedido(pastaInfo, cantidad)
                        );

                        break;

                    default:
                        throw new IllegalArgumentException(
                                "Tipo de pasta inexistente."
                        );
                }

                System.out.print("\nAgregar otro item? (S/N): ");
                continuar = sc.next().toUpperCase().charAt(0);

            } while (continuar == 'S');

            // RESUMEN
            System.out.println("\n======================");
            pedido.mostrarResumen();
            System.out.println("======================");

            System.out.printf(
                    "\nTOTAL A PAGAR: $%.2f\n",
                    pedido.calcularTotal()
            );

        }

        catch (PedidoInvalidoException e) {
            System.out.println("ERROR DE PEDIDO: " + e.getMessage());
        }

        catch (InputMismatchException e) {
            System.out.println("ERROR: ingreso un dato de tipo incorrecto.");
        }

        catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        catch (ArithmeticException e) {
            System.out.println("ERROR ARITMÉTICO: " + e.getMessage());
        }

        catch (Exception e) {
            System.out.println("ERROR GENERAL: " + e.getMessage());
        }

        finally {
            sc.close();
        }
    }
}

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("##.##");
        Cuenta miCuenta = new Cuenta("Yuliana", 25000, "ARS");

        Consulta consulta = new Consulta();


        System.out.println("\n");
        System.out.println("************************************************");
        System.out.println("Información sobre su cuenta: \n");
        System.out.println("Nombre: " + miCuenta.getNombre());
        System.out.println("Saldo actual: " + miCuenta.getSaldoDisponibe() + " " +   miCuenta.getTipoDeMoneda() + "\n");



        System.out.println("******** Monedas disponibles ********\n");

        System.out.println("""
                   1- USD (DOLAR)
                   2- BOB (Boliviano Boliviano)
                   3- BRL (Real Brazilero)
                   4- CLP (Peso Chileno)
                   5- COP (Peso Colombiano)
                   6- ARS (Peso Argentino)
                    """);
        System.out.println("Ingrese una opción de conversión: ");
        Scanner teclado = new Scanner(System.in);


        try{
            while (true){
                String monedaFinal = null;
                var busqueda = teclado.nextInt();
                if (busqueda == 0 ){
                    break;
                }else{
                    switch (busqueda){
                        case 1 :
                            monedaFinal = "USD";
                            break;
                        case 2 :
                            monedaFinal = "BOB";
                            break;
                        case 3 :
                            monedaFinal = "BRL";
                            break;
                        case 4 :
                            monedaFinal = "CLP";
                            break;
                        case 5 :
                            monedaFinal = "COP";
                            break;
                        case 6 :
                            monedaFinal = "ARS";
                            break;
                        default:
                            monedaFinal = miCuenta.getTipoDeMoneda();
                            System.out.println("No se pudo realizar la conversion por que ingreso una opción no valida.");
                            break;

                    }


                }
                Conversor conversor = consulta.convetirMoneda(miCuenta.getSaldoDisponibe() , miCuenta.getTipoDeMoneda(), monedaFinal);
                Operaciones operacion = new Operaciones();
                operacion.setCalculoConversor(miCuenta.getSaldoDisponibe(), conversor.conversion_rate());

                System.out.println(" Detalles de su transaccion: " + df.format( operacion.getConversion() ) + " " + conversor.target_code() );
                System.out.println("\n************************************************\n");
                miCuenta.setTipoDeMoneda(monedaFinal);
                miCuenta.setSaldoDisponibe(operacion.getConversion());
                System.out.println("Realize otra operacion o presione 0 para salir.");

            }
        }catch (InputMismatchException e){
            System.out.println("Ha ocurrido un error. Reintente la operación");
        }
        System.out.println("Su saldo actual es: " + df.format(miCuenta.getSaldoDisponibe()) + " " + miCuenta.getTipoDeMoneda());

    }
}
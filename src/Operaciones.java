import java.text.DecimalFormat;

public class Operaciones {
    private double calculoConversor;

    DecimalFormat df = new DecimalFormat("###.###");

    public void setCalculoConversor(double saldoEnCuenta, double tasaDeCambio) {
        this.calculoConversor = ( saldoEnCuenta * tasaDeCambio ) ;
    }

    public double getConversion(){
        return calculoConversor;
    }

}

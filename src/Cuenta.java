public class Cuenta {
    private String nombre;
    private double saldoDisponibe;
    private String tipoDeMoneda;

    public Cuenta(String nombre, double saldoDisponibe, String tipoDeMoneda) {
        this.nombre = nombre;
        this.saldoDisponibe = saldoDisponibe;
        this.tipoDeMoneda = tipoDeMoneda;
    }

    public double getSaldoDisponibe() {
        return saldoDisponibe;
    }
    public String getTipoDeMoneda() {
        return tipoDeMoneda;
    }
    public String getNombre() {
        return nombre;
    }

    public void setSaldoDisponibe(double saldoDisponibe) {
        this.saldoDisponibe = saldoDisponibe;
    }

    public void setTipoDeMoneda(String tipoDeMoneda) {
        this.tipoDeMoneda = tipoDeMoneda;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

public class Moto extends Vehiculo {
    public Moto(String placa) {
        super(placa);
    }

    @Override
    public int calcularPeaje() {
        return 1;
    }

    @Override
    public String getTipo() {
        return "Moto";
    }
}
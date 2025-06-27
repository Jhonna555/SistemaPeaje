public class Carro extends Vehiculo {
    public Carro(String placa) {
        super(placa);
    }

    @Override
    public int calcularPeaje() {
        return 2;
    }

    @Override
    public String getTipo() {
        return "Carro";
    }
}
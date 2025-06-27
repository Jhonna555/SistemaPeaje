public class Camion extends Vehiculo {
    private int numeroEjes;

    public Camion(String placa, int numeroEjes) {
        super(placa);
        this.numeroEjes = numeroEjes;
    }

    @Override
    public int calcularPeaje() {
        return numeroEjes;
    }

    @Override
    public String getTipo() {
        return "Camion";
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }
}
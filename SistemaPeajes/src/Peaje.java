import java.util.ArrayList;

public class Peaje {
    private String nombre;
    private String canton;
    private int totalPeaje = 0;
    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    public Peaje(String nombre, String canton) {
        this.nombre = nombre;
        this.canton = canton;
    }

    public void añadirVehiculo(Vehiculo v) {
        vehiculos.add(v);
        totalPeaje += v.calcularPeaje();
    }

    public int getTotalPeaje() {
        return totalPeaje;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCanton() {
        return canton;
    }
}

package modelo;

/**
 *
 * @author Eduar Yosme Pardo
 */
public class NaveTripulada extends Nave{
    private int capacidadPersonas;

    public NaveTripulada() {
    }

    public NaveTripulada(String nombre, String pais, double peso, double velocidad, 
            double potencia, String combustible, int capacidadPersonas) {
        super(nombre, pais, peso, velocidad, potencia, combustible);
        this.capacidadPersonas = capacidadPersonas;
    }

    public int getCapacidadPersonas() {
        return capacidadPersonas;
    }

    public void setCapacidadPersonas(int capacidadPersonas) {
        this.capacidadPersonas = capacidadPersonas;
    }
    
    
    
}

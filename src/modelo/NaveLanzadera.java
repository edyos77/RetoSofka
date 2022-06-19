
package modelo;

/**
 *
 * @author Eduar Yosme Pardo
 */
public class NaveLanzadera extends Nave{
    
    private int capacidadCarga;
    private int altura;

    public NaveLanzadera() {
    }

    public NaveLanzadera(String nombre, String pais, double peso, double velocidad, 
            double potencia, String combustible, int capacidad, int altura ) {
        super(nombre, pais, peso, velocidad, potencia, combustible);
        this.capacidadCarga = capacidad;
        this.altura = altura;
    }

    public int getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }


    @Override
    public String toString() {
        return super.toString() + " NaveLanzadera{" + "capacidad=" + capacidadCarga 
                + ", altura=" + altura + '}';
    }
    
}

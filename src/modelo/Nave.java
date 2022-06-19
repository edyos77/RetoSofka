
package modelo;

/**
 *
 * @author Eduar Yosme Pardo
 * @version 1.0
 */
public abstract class Nave {
    protected String nombre;
    protected String pais;
    protected double peso;
    protected double velocidad;
    protected double potencia;
    protected String combustible;

    public Nave() {
    }

    public Nave(String nombre, String pais, double peso, double velocidad, 
                double potencia, String combustible) {
        this.nombre = nombre;
        this.pais = pais;
        this.peso = peso;
        this.velocidad = velocidad;
        this.potencia = potencia;
        this.combustible = combustible;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    @Override
    public String toString() {
        return "Nave{" + "nombre=" + nombre + ", pais=" + pais + ", peso=" + peso 
            + ", velocidad=" + velocidad + ", potencia=" + potencia + ", combustible=" 
            + combustible + '}';
    }
    
    
    
}

package Objects;

import Main.Controlador;
import java.util.Random;
public class Carga {
    // Declaracion Atributos
    private float velocidadInicial;
    private float velocidad;
    private int posicionY;
    private int posicionDetonacion;

    
    // Constructor
    public Carga() {
        velocidadInicial = 20;
        posicionY = 100;
        posicionDetonacion = generarPosicionDetonacion();
        setVelocidad();
    }

    
    // Getters y Setters
    public int getPosicionY() {
        return posicionY;
    }
    public int getPosicionDetonacion() { return posicionDetonacion; }
    public void setPosicion() { moverCarga(); }
    private void setVelocidad() { velocidad += velocidadInicial + (velocidadInicial * Controlador.getInstance().getNivel()) / 10 ; }

    
    // Metodos Internos
    private int generarPosicionDetonacion() {
        return new Random().nextInt(700 - 300) + 300;
    }
    private void moverCarga() {
        if (posicionY + velocidad < posicionDetonacion) {
            posicionY += velocidad;
        } else if (posicionY + velocidad >= posicionDetonacion) {
            Controlador.getInstance().setExisteCarga(false);
        }
    }
}

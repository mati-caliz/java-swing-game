package Objects;

import Main.Controlador;

import java.util.Random;

public class Barco {
    // Declaracion Atributos
    private int posicionX;
    private int posicionCargaX;
    private int posicionDetonacionCarga;
    private float velocidadInicial;
    private float velocidad;
    private boolean sentidoDirecto;
    private boolean existeCarga;
    private Carga carga;
    private int contadorBarcos;
    private int escala;

    
    // Constructor
    public Barco() {
        iniciarBarcoPosicionAleatoria();
        existeCarga = false;
        velocidadInicial = 16;
        velocidad = velocidadInicial;
    }

    
    // Setters y Getters
    public void setPosicionBarco() {
        moverBarco();
    }
    public void setExisteCarga(boolean existeCarga) {
        this.existeCarga = existeCarga;
    }
    public void setPosicionCarga() {
        if (existeCarga) {
            carga.setPosicion();
        }
    }
    public void aumentarVelocidad() { velocidad += velocidadInicial / 10 ; }
    public void lanzarCarga(int nivel) {
        if (!existeCarga) {
            posicionCargaX = posicionX;
            carga = new Carga(nivel);
            posicionDetonacionCarga = carga.getPosicionDetonacion();
            existeCarga = true;
        }
    }
    public int getPosicionX() {
        return posicionX;
    }
    public int getPosicionCargaX() { return posicionCargaX; }
    public int getPosicionCargaY() {
        if (existeCarga) {
            return carga.getPosicionY();
        }
        return 0;
    }
    public boolean getExisteCarga() { return existeCarga; }
    public int getPosicionDetonacionCarga() {
        return posicionDetonacionCarga;
    }
    public int getContadorBarcos() { return contadorBarcos; }
    public void setEscala(int escala) { this.escala = escala; }

    
    // Metodos Internos
    private void moverBarco() {
        if (sentidoDirecto) {
            posicionX += velocidad;
            if (posicionX > Controlador.getInstance().getPanelWidth() + escala / 2) {
                addBarcoContador();
                iniciarBarcoPosicionAleatoria();
            }
        } else {
            posicionX -= velocidad;
            if (posicionX < -escala) {
                addBarcoContador();
                iniciarBarcoPosicionAleatoria();
            }
        }
    }

    private void iniciarBarcoPosicionAleatoria() {
        Random random = new Random();
        sentidoDirecto = random.nextBoolean();
        if (sentidoDirecto) {
            posicionX = -escala;
        } else {
            posicionX = Controlador.getInstance().getPanelWidth() - escala / 2;
        } 
    }

    private void addBarcoContador() {
        if (contadorBarcos < 10) {
            contadorBarcos++;
        } else {
            contadorBarcos = 0;
            Controlador.getInstance().aumentarNivel();
        }
    }
}

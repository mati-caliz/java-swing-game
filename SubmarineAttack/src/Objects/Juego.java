package Objects;

import Main.Controlador;

public class Juego {
    // Declaracion Atributos
    private int nivel;
    private int vidas;
    private int puntos;
    private int contadorPuntos;


    // Constructor
    public Juego() {
        nivel = 1;
        vidas = 1;
        puntos = 0;
        contadorPuntos = 0;
    }


    // Getters y Setters
    public void addPuntos(int puntos) {
        this.puntos += puntos;
        contadorPuntos += puntos;
        verificarVidas();
    }
    public int getVidas() {
        return vidas;
    }
    public int getNivel() {
        return nivel;
    }
    public int getPuntos() {
        return puntos;
    }
    public void aumentarNivel() {
        nivel++;
        puntos += 200;
        contadorPuntos += 200;
        verificarVidas();
        Controlador.getInstance().aumentarVelocidadBarco();
    }
    public void eliminarVida() {
        if (vidas > 0) {
            vidas--;
        }
    }

    
    // Metodos Internos
    private void verificarVidas() {
        if (contadorPuntos >= 500) {
            contadorPuntos -= 500;
            vidas++;
        }
    }
}

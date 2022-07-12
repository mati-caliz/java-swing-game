package Objects;

import Main.Controlador;
import Panel.Window;

public class Submarino {
    // Declaracion Atributos
    private int velocidad;
    private int vida;
    private int posicionX;
    private int posicionY;
    private int escalaImagen;
    

    // Constructor
    public Submarino() {
        vida = 100;
        velocidad = 14;
        posicionX = Window.getInstance().getPanelWidth() / 2;
        posicionY = Window.getInstance().getPanelHeight() / 2;
    }


    // Getters y Setters
    public int getPosicionX() {
        return posicionX;
    }
    public int getPosicionY() {
        return posicionY;
    }
    public int getVida() { return vida; }
    public void setVidaNueva() {
        vida = 100;
    }
    public void setPosicion(boolean leftKeyPressed, boolean rightKeyPressed, boolean downKeyPressed, boolean upKeyPressed) {
        moverSubmarino(leftKeyPressed, rightKeyPressed, downKeyPressed, upKeyPressed);
    }
    public void setVida() {
        if (vida > 0) {
            if (!Controlador.getInstance().getExisteCarga()) {
                calcularDamage();
            }
        } else {
            Controlador.getInstance().eliminarVida();
            setVidaNueva();
        }
    }
    public void setEscalaImagen(int escalaImagen) {
        this.escalaImagen = escalaImagen;
    }


    // Metodos Internos
    private void moverSubmarino(boolean leftKeyPressed, boolean rightKeyPressed, boolean downKeyPressed, boolean upKeyPressed) {
        if (leftKeyPressed) {
            if (posicionX - velocidad > 0) {
                posicionX -= velocidad;
            }
        }
        if (rightKeyPressed) {
            if (posicionX + velocidad < Controlador.getInstance().getPanelWidth() - escalaImagen) {
                posicionX += velocidad;
            }
        }
        if (downKeyPressed) {
            if (posicionY + velocidad < Controlador.getInstance().getPanelHeight() - escalaImagen) {
                posicionY += velocidad;
            }
        }
        if (upKeyPressed) {
            if (posicionY - velocidad > Controlador.getInstance().getPanelHeight() / 4) {
                posicionY -= velocidad;
            }
        }
    }

    private void calcularDamage() {
        int distanciaX = posicionX - Controlador.getInstance().getPosicionCargaX();
        int distanciaY = posicionY - Controlador.getInstance().getPosicionDetonacion();
        int distancia = (int) Math.sqrt(Math.pow(distanciaX, 2) + Math.pow(distanciaY, 2));
        int nivelDamage = 0;
        
        if (distancia > 150 && distancia <= 175) {
            nivelDamage = 1;
        } else if (distancia > 100 && distancia <= 150) {
            nivelDamage = 2;
        } else if (distancia >= 0 && distancia <= 100) {
            nivelDamage = 3;
        }
        calcularVida(nivelDamage);
    }

    private void calcularVida(int nivelDamage) {
        if (nivelDamage == 0) {
            Controlador.getInstance().addPuntaje(30);
        } else if (nivelDamage == 1) {
            vida -= 30;
            Controlador.getInstance().addPuntaje(10);
        } else if (nivelDamage == 2) {
            vida -= 50;
        } else if (nivelDamage == 3) {
            vida = 0;
        }
    }
}

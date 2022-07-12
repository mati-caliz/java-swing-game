package Main;

import Objects.Barco;
import Objects.Juego;
import Objects.Submarino;
import Panel.KeyHandler;
import Panel.MusicHandler;
import Panel.Window;

public class Controlador {
    // Declaracion Atributos
    private static Controlador controladorInstance;
    private Submarino submarino = new Submarino();
    private Juego juego = new Juego();
    private Barco barco = new Barco();
    private KeyHandler keyHandler = KeyHandler.getInstance();
    private MusicHandler musicHandler = new MusicHandler();


    // Singleton
    public static Controlador getInstance() {
        if (controladorInstance == null) {
            controladorInstance = new Controlador();
        }
        return controladorInstance;
    }


    // Getters y Setters
    public int getPanelWidth() {
        return Window.getInstance().getPanelWidth();
    }
    public int getPanelHeight() {
        return Window.getInstance().getPanelHeight();
    }
    public int getPosicionSubmarinoX() {
        return submarino.getPosicionX();
    }
    public int getPosicionSubmarinoY() {
        return submarino.getPosicionY();
    }
    public int getPosicionBarcoX() {
        return barco.getPosicionX();
    }
    public int getPosicionCargaX() { return barco.getPosicionCargaX(); }
    public int getPosicionCargaY() { return barco.getPosicionCargaY(); }
    public int getPosicionDetonacion() { return barco.getPosicionDetonacionCarga(); }
    public int getNivel() {
        return juego.getNivel();
    }
    public boolean getExisteCarga() {
        return barco.getExisteCarga();
    }
    public int getVidaSubmarino() { return submarino.getVida(); }
    public void setPosicionSubmarino() {
        submarino.setPosicion(keyHandler.getLeftKey(), keyHandler.getRightKey(), keyHandler.getDownKey(), keyHandler.getUpKey());
    }
    public int getPuntaje() { return juego.getPuntos(); }
    public int getVidas() { return juego.getVidas(); }
    public int getContadorBarcos() { return barco.getContadorBarcos(); }
    public void setPosicionBarco() {
        barco.setPosicionBarco();
    }
    public void aumentarVelocidadBarco() {
    	barco.aumentarVelocidad();
    }
    public void setExisteCarga(boolean existeCarga) { barco.setExisteCarga(existeCarga);}
    public void setPosicionCarga() { barco.setPosicionCarga(); }
    public void setVidaSubmarino() { submarino.setVida(); }
    public void setEscalaImagenSubmarino(int escala) { submarino.setEscalaImagen(escala); }
    public void lanzarCargaBarco() { barco.lanzarCarga(juego.getNivel()); }
    public void eliminarVida() { juego.eliminarVida(); }
    public void addPuntaje(int puntos) {
        juego.addPuntos(puntos);
    }
    public void aumentarNivel() { juego.aumentarNivel(); }
}

package Panel;

import Main.Controlador;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
	// Declaracion Atributos
    private Controlador controladorInstance;
    private Image imagenFondo, imagenEscalaProfundidad, imagenSubmarino, imagenBarco, imagenCarga, imagenExplosion, imagenGameOver;
    private KeyHandler keyHandler;
    private int escalaSubmarino, escalaBarco, escalaCarga, escalaExplosion;
    Timer timer;


    // Constructor
    public GamePanel() {
        controladorInstance = Controlador.getInstance();
        imagenFondo = new ImageIcon("src/Media/Fondo.jpg").getImage();
        imagenEscalaProfundidad = new ImageIcon("src/Media/Escala.png").getImage();
        imagenSubmarino = new ImageIcon("src/Media/Submarino.png").getImage();
        imagenBarco = new ImageIcon("src/Media/Barco.png").getImage();
        imagenCarga = new ImageIcon("src/Media/Carga.png").getImage();
        imagenExplosion = new ImageIcon("src/Media/Explosion.png").getImage();
        imagenGameOver = new ImageIcon("src/Media/GameOver.png").getImage();
        escalaBarco = 250;
        escalaCarga = 100;
        escalaSubmarino = 200;
        escalaExplosion = 200;
        timer = new Timer(100, this);
        keyHandler = KeyHandler.getInstance();
        addKeyListener(keyHandler);
        setFocusable(true);
        timer.start();
        controladorInstance.setEscalaImagenSubmarino(escalaSubmarino);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // g.drawImage(image, x, y, [escalaX], [escalaY], observer)
        g.drawImage(imagenFondo, 0, 0, null);
        g.drawImage(imagenEscalaProfundidad, controladorInstance.getPanelWidth() - controladorInstance.getPanelWidth() / 12,
                controladorInstance.getPanelHeight() / 3, null);
        g.drawImage(imagenSubmarino, controladorInstance.getPosicionSubmarinoX(), controladorInstance.getPosicionSubmarinoY(),
                escalaSubmarino, escalaSubmarino, null);
        g.drawImage(imagenBarco, controladorInstance.getPosicionBarcoX(), -imagenBarco.getWidth(null) / 12, escalaBarco, escalaBarco, null);
        if (controladorInstance.getExisteCarga()) {
        	g.drawImage(imagenCarga, controladorInstance.getPosicionCargaX(), controladorInstance.getPosicionCargaY(), escalaCarga, escalaCarga, null);
        }
    	if(controladorInstance.getPosicionDetonacion() <= controladorInstance.getPosicionCargaY() + 20){
            g.drawImage(imagenExplosion,  controladorInstance.getPosicionCargaX()-50, controladorInstance.getPosicionCargaY(),escalaExplosion,escalaExplosion,null);
        }
        if(controladorInstance.getVidas() < 1) {
            g.drawImage(imagenGameOver,(controladorInstance.getPanelWidth() / 2) -100,(controladorInstance.getPanelHeight() / 2) - 175,200,200,null);
        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(controladorInstance.getVidas() < 1) {
            repaint();
            timer.stop();
        }
        controladorInstance = Controlador.getInstance();
        controladorInstance.setPosicionSubmarino();
        controladorInstance.setPosicionBarco();
        controladorInstance.lanzarCargaBarco();
        controladorInstance.setPosicionCarga();
        controladorInstance.setVidaSubmarino();
        repaint();
    }
}
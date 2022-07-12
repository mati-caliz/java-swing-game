package Panel;

import Main.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScorePanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 2L;
	// Declaracion Atributos
    private Controlador controladorInstance;
    private JLabel nivel;
    private JLabel vidaActual;
    private JLabel puntaje;
    private JLabel vidasTotales;
    private JLabel contadorBarcos;
    Timer timer;

    
    // Constructor
    public ScorePanel() {
        controladorInstance = Controlador.getInstance();
        vidaActual = new JLabel( "Vida: " + String.valueOf(controladorInstance.getVidaSubmarino()) + "%   -   ");
        puntaje = new JLabel( "Puntos: " + String.valueOf(controladorInstance.getPuntaje()) + "   -   ");
        vidasTotales = new JLabel( "Vidas: " + String.valueOf(controladorInstance.getVidas()) + "   -   ");
        nivel = new JLabel("Nivel: " + String.valueOf(controladorInstance.getNivel()));
        contadorBarcos = new JLabel("Barcos Nivel: " + String.valueOf(controladorInstance.getContadorBarcos()));

        setOpaque(true);
        setBackground(Color.CYAN);
        vidaActual.setFont(new Font("Monospaced", Font.PLAIN, 22));
        puntaje.setFont(new Font("Monospaced", Font.PLAIN, 22));
        vidasTotales.setFont(new Font("Monospaced", Font.PLAIN, 22));
        nivel.setFont(new Font("Monospaced", Font.PLAIN, 22));
        contadorBarcos.setFont(new Font("Monospaced", Font.PLAIN, 22));
        //font types - Serif, SansSerif, Monospaced, Dialog, and DialogInput

        add(nivel);
        add(puntaje);
        add(vidaActual);
        add(vidasTotales);
        add(contadorBarcos);
        
        timer = new Timer(100, this);
        timer.start();
    }

    
    // Metodos Internos
    @Override
    public void actionPerformed(ActionEvent e) {
        if(controladorInstance.getVidas() < 1) {
            timer.stop();
        }
        vidaActual.setText("Vida: " + String.valueOf(controladorInstance.getVidaSubmarino() + "%   -   "));
        puntaje.setText("Puntos: " + String.valueOf(controladorInstance.getPuntaje()) + "   -   ");
        vidasTotales.setText("Vidas: " + String.valueOf(controladorInstance.getVidas()) + "   -   ");
        nivel.setText("Nivel: " + String.valueOf(controladorInstance.getNivel()) + "   -   ");
        contadorBarcos.setText("Barcos Nivel: " + String.valueOf(controladorInstance.getContadorBarcos()));
    }
}

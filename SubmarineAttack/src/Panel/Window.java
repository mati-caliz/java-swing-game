package Panel;

import java.awt.*;

import javax.swing.JFrame;

public class Window {
    // Declaracion Atributos
    private static Window windowInstance;
    private static Dimension screenSize;
    private GamePanel gamePanel;
    private ScorePanel scorePanel;
    private int screenWidth;
    private int screenHeight;
    private int panelWidth;
    private int panelHeight;

    // Constructor
    public Window() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = (int) screenSize.getWidth();
        screenHeight = (int) screenSize.getHeight();
        panelWidth = screenWidth - screenWidth / 4;
        panelHeight = screenHeight - screenHeight / 8;
    }

    
    // Singleton
    public static Window getInstance() {
        if (windowInstance == null) {
            windowInstance = new Window();
        }
        return windowInstance;
    }

    
    // Getters y Setters
    public int getScreenWidth() {
        return screenWidth;
    }
    public int getScreenHeight() {
        return screenHeight;
    }
    
    public int getPanelWidth() {
    	return panelWidth;
    }
    
    public int getPanelHeight() {
    	return panelHeight;
    }
    
    
    // Metodos Internos
    public void setUpPanel() {
    	gamePanel = new GamePanel();   
    	scorePanel = new ScorePanel();
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setTitle("Submarine Attack");
        ventana.setPreferredSize(new Dimension(panelWidth, panelHeight));

        ventana.add(gamePanel);
        ventana.add(scorePanel, BorderLayout.NORTH);

        ventana.pack();
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}

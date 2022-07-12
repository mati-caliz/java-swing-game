package Panel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private static KeyHandler keyHandler;
    private boolean upKeyPressed;
    private boolean downKeyPressed;
    private boolean leftKeyPressed;
    private boolean rightKeyPressed;

    public boolean getUpKey() {
        return upKeyPressed;
    }

    public boolean getDownKey() {
        return downKeyPressed;
    }

    public boolean getLeftKey() {
        return leftKeyPressed;
    }

    public boolean getRightKey() {
        return rightKeyPressed;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                upKeyPressed = true;
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                leftKeyPressed = true;
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                downKeyPressed = true;
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                rightKeyPressed = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                upKeyPressed = false;
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                leftKeyPressed = false;
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                downKeyPressed = false;
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                rightKeyPressed = false;
                break;
        }
    }


    // Singleton
    public static KeyHandler getInstance() {
        if (keyHandler == null) {
            keyHandler = new KeyHandler();
        }
        return keyHandler;
    }
}

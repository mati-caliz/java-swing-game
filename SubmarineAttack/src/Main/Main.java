package Main;

import Panel.Window;

public class Main {
	private static Window window;
    // Main
    public static void main(String[] args) {
    	window = Window.getInstance();
    	window.setUpPanel();
    }
}

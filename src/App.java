import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class App extends JFrame {	
    public App() {
        super("SER Final Project");
       
        this.setLayout(new BorderLayout());

        JLabel label = new JLabel("Beta");
        
        
        DrawingPanel drawingPanel = new DrawingPanel();
        
  
        ControlPanel controlPanel = new ControlPanel(drawingPanel);
        
        this.setSize(1000, 800);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.add(controlPanel, BorderLayout.SOUTH);
        this.add(drawingPanel, BorderLayout.CENTER);
        this.add(label, BorderLayout.NORTH);

        this.setVisible(true);

    }

    public static void main(String[] args) {
        new App();
    }
}

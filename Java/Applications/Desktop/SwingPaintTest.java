import javax.swing.*;
import java.awt.*;

class SwingPaintTest {

	static class MainFrame extends JFrame {
		
		public MainFrame() {
			super("Hello World");
			setSize(300, 300);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setUndecorated(true);
			rootPane.setWindowDecorationStyle(JRootPane.FRAME);
			setContentPane(new ClockPanel());
		}
	}

	static class ClockPanel extends JPanel {
			
			@Override
			public void paintComponent(Graphics g) {
				g.setColor(Color.GREEN);
				g.drawRect(50, 50, 200, 20);
				g.setColor(Color.BLUE);
				var now = new java.util.Date();
				g.drawString(now.toString(), 55, 65);
			}
	}
	
	public static void main(String[] args) throws Exception {
		var frame = new MainFrame();
		frame.setVisible(true);
		for(;;){
			Thread.sleep(1000);
			SwingUtilities.invokeLater(() -> frame.repaint());
		}
	}

}



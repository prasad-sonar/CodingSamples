import javax.swing.*;
import java.awt.*;

class SwingChildTest {

	static class MainFrame extends JFrame {
		
		private JButton timeButton = new JButton("Time");

		public MainFrame() {
			super("Hello World");
			setSize(300, 300);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLayout(new FlowLayout());
			add(timeButton);
			timeButton.addActionListener(e -> {
				var now = new java.util.Date();
				JOptionPane.showMessageDialog(this, now, "Current Time", JOptionPane.INFORMATION_MESSAGE);
			});
		}
	}
	
	public static void main(String[] args) throws Exception {
		var frame = new MainFrame();
		frame.setVisible(true);
	}
}



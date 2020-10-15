import javax.swing.*;

class SwingPlainTest {

	static class MainFrame extends JFrame {
		
		public MainFrame() {
			super("Hello World");
			setSize(300, 300);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	}
	
	public static void main(String[] args) throws Exception {
		var frame = new MainFrame();
		frame.setVisible(true);
	}
}



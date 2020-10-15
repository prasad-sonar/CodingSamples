import java.awt.*;
import java.awt.event.*;

class AWTChildTest {

	static class MainFrame extends Frame {

		private Button timeButton = new Button("Time");
		private Button greetButton = new Button("Greet");

		public MainFrame() {
			super("Hello World");
			setSize(300, 300);
			enableEvents(AWTEvent.WINDOW_EVENT_MASK);
			//add(timeButton, BorderLayout.NORTH);
			setLayout(new FlowLayout());
			add(timeButton);
			timeButton.addActionListener(e -> {
				var now = new java.util.Date();
				setTitle(now.toString());
			});
			add(greetButton);
			greetButton.addActionListener(e -> {
				setTitle("Hello World");
			});
		}

		@Override
		public void processWindowEvent(WindowEvent e) {
			if(e.getID() == WindowEvent.WINDOW_CLOSING)
				System.exit(0);
			super.processWindowEvent(e);
		}
	
	}

	public static void main(String[] args) throws Exception{
		var frame = new MainFrame();
		frame.setVisible(true);
	}
}



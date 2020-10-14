import java.awt.*;
import java.awt.event.*;

class AWTPlainTest {

	static class MainFrame extends Frame {

		public MainFrame() {
			super("Hello World");
			setSize(300, 300);
			enableEvents(AWTEvent.WINDOW_EVENT_MASK);
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



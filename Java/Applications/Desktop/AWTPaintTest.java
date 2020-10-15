import java.awt.*;
import java.awt.event.*;

class AWTPaintTest {

	static class MainFrame extends Frame {

		public MainFrame() {
			super("Hello World");
			setSize(300, 300);
			enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		}

		@Override
		public void paint(Graphics g) {
			g.setColor(new Color(0, 255, 0));
			g.drawRect(50, 50, 200, 20);
			g.setColor(Color.BLUE);
			var now = new java.util.Date();
			g.drawString(now.toString(), 55, 65);
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
		for(;;) {
			Thread.sleep(1000);
			frame.repaint();
		}
	}
}



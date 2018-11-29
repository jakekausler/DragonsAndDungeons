import java.awt.Canvas;

import javax.swing.JFrame;

import map.Area;

public class Main {

	public static void main(String[] args) {
		Area area = new Area("res/areas/testArea.xml");
		
		JFrame frame = new JFrame(area.getName());
        MapDrawer md = new MapDrawer(area);
        md.setSize(600, 400);
        frame.add(md);
        frame.pack();
        frame.setVisible(true);
	}

}

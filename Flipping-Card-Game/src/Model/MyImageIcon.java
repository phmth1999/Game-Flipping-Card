package Model;

import javax.swing.ImageIcon;

public class MyImageIcon extends ImageIcon {

	private static int count;
	private int iconID = 0;

	public MyImageIcon(String filename) {
		super(filename);
		count++;
		iconID += count;
	}

	public int getID() {
		return iconID;
	}
}

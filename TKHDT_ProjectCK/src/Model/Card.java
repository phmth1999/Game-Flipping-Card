package Model;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Card extends JButton {
	private ImageIcon imageIcon;
	private MyImageIcon imageHinh;
	private int cardID;

	private boolean cardUp;
	private boolean clickable = true;

	public Card(ImageIcon imageIcon, MyImageIcon imageHinh, int cardID) {

		this.imageIcon = imageIcon;
		this.imageHinh = imageHinh;
		this.cardID = cardID;

	}

	public boolean isClickable() {
		return clickable;
	}

	public void setClickable(boolean clickable) {
		this.clickable = clickable;
	}

	// lấy cardID
	public int getCardID() {
		return cardID;
	}

	// thay đổi kích thước icon
	private ImageIcon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
		Image img = icon.getImage();
		Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(resizedImage);
	}

	// hiển thị hình ảnh
	public void showImage() {
		if (cardUp) {
			setIcon(resizeIcon(imageHinh, this.getWidth(), getHeight()));
		} else
			setIcon(resizeIcon(imageIcon, this.getWidth(), getHeight()));
	}

	// lật thẻ
	public void cardFlip() {
		if (cardUp)
			cardUp = false;
		else
			cardUp = true;
	}

}

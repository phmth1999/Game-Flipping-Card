package Model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Controller.CardController;

public class Card extends JButton {

	private CardController controller;

	private ImageIcon imageChuaLatHinh;
	private MyImageIcon imageDaLatHinh;

	private int cardID;
	private boolean cardUp;
	private boolean clickable;

	public Card(ImageIcon imageChuaLatHinh, MyImageIcon imageDaLatHinh, int cardID) {

		this.imageChuaLatHinh = imageChuaLatHinh;
		this.imageDaLatHinh = imageDaLatHinh;
		this.cardID = cardID;

		clickable = true;
		cardUp = false;

		setPreferredSize(new Dimension(220, 220));
		setBackground(new Color(230, 230, 230));

		ImageIcon image = new ImageIcon("src/images/cardBack.png");
		Image tmp = image.getImage();
		ImageIcon icon = new ImageIcon(tmp.getScaledInstance(220, 220, Image.SCALE_SMOOTH));
		setIcon(icon);

		addActionListener(ActionEvent -> {
			if (clickable) {
				cardFlip();
				showImage();
				controller.getCards(this);
			}
		});
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
			setIcon(resizeIcon(imageDaLatHinh, this.getWidth(), getHeight()));
		} else
			setIcon(resizeIcon(imageChuaLatHinh, this.getWidth(), getHeight()));
	}

	// lật thẻ
	public void cardFlip() {
		if (cardUp)
			cardUp = false;
		else
			cardUp = true;
	}

	// đặt lại controller
	public void setController(CardController controller) {
		this.controller = controller;
	}

	// không thể nhấp
	public void setClickableOff() {
		this.clickable = false;
	}

	// có thể nhấp
	public void setClickableOn() {
		this.clickable = true;
	}

}

package Factory;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;

import Model.Card;
import Model.MyImageIcon;

public class CardFactory {

	private ArrayList<MyImageIcon> images;
	private ImageIcon cardBack;

	public CardFactory() {

		cardBack = new ImageIcon("src/images/cardBack.png");

		MyImageIcon bull = new MyImageIcon("src/images/bull.png");
		MyImageIcon chicken = new MyImageIcon("src/images/chicken.png");
		MyImageIcon fox = new MyImageIcon("src/images/fox.png");
		MyImageIcon hedgehog = new MyImageIcon("src/images/hedgehog.png");
		MyImageIcon hippo = new MyImageIcon("src/images/hippo.png");
		MyImageIcon koala = new MyImageIcon("src/images/koala.png");
		MyImageIcon lemur = new MyImageIcon("src/images/lemur.png");
		MyImageIcon pig = new MyImageIcon("src/images/pig.png");
		MyImageIcon tiger = new MyImageIcon("src/images/tiger.png");
		MyImageIcon zebra = new MyImageIcon("src/images/zebra.png");

		images = new ArrayList<>();
		images.add(bull);
		images.add(chicken);
		images.add(fox);
		images.add(hedgehog);
		images.add(hippo);
		images.add(koala);
		images.add(lemur);
		images.add(pig);
		images.add(tiger);
		images.add(zebra);

	}

	// tạo ra danh sách thẻ dựa trên số lượng. vd: 2x3 : thì có 6 thẻ tương ứng với 3 hình ảnh mỗi hình có 2 ảnh giống nhau
	public ArrayList<Card> makeCards(int amount) {
		Collections.shuffle(images);
		ArrayList<Card> cards = new ArrayList<>();

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < amount / 2; j++) {
				Card c = new Card(cardBack, images.get(j), images.get(j).getID());
				cards.add(c);
			}
		}
		return cards;
	}

}

package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Timer;

import Model.Card;
import View.GameWindow;

public class CardController {

	private int cardsToMatch;
	private int cardsMatched = 0;
	private GameWindow game;
	// danh sách ảnh đã lật
	private ArrayList<Card> flippedCards = new ArrayList<>();
	// danh sách tất cả ảnh
	private ArrayList<Card> allCards = new ArrayList<>();

	public CardController(GameWindow gameWindow, int cardsToMatch) {
		this.game = gameWindow;
		this.cardsToMatch = (cardsToMatch / 2);

	}

	// lấy card
	public void getCards(Card card) {
		flippedCards.add(card);
		card.setClickableOff();
		if (flippedCards.size() == 2) {
			allCardsBlocked();
			if (flippedCards.get(0).getCardID() == flippedCards.get(1).getCardID()) {
				cardsMatched++;
				allCards.remove(flippedCards.get(0));
				allCards.remove(flippedCards.get(1));
				flippedCards.clear();
				allCardsUnlocked();
				try {
					checkGameStatus();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			} else {
				Card card1 = flippedCards.get(0);
				Card card2 = flippedCards.get(1);

				card1.cardFlip();
				card2.cardFlip();
				//thời gian trở về hình chưa lật khi lật 2 hình không giống nhau
				Timer timer = new Timer(1000, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						card1.showImage();
						card2.showImage();
						allCardsUnlocked();
					}
				});
				timer.setRepeats(false);
				timer.start();
				flippedCards.clear();
			}
		}
	}

	public void collectAllCards(Card c) {
		allCards.add(c);
	}

	//  thẻ bị chặn
	private void allCardsBlocked() {
		for (Card c : allCards)
			c.setClickableOff();
	}

	// thẻ được mở
	private void allCardsUnlocked() {
		for (Card c : allCards)
			c.setClickableOn();
	}

	// kiểm tra tình trạng để kết thúc trò chơi
	private void checkGameStatus() throws IOException {
		if (cardsMatched == cardsToMatch)
			game.setGameEnd();
	}
}

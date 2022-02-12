package Model;

import java.io.Serializable;

public class Result implements Serializable {

	private String display;
	private int score;

	public Result(String display, int score) {
		this.display = display;
		this.score = score;
	}

	@Override
	public String toString() {
		return display +" : "+ score;
	}

	public int getScore() {
		return score;
	}
}

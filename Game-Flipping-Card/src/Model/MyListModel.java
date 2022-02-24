package Model;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class MyListModel extends DefaultListModel {

	ArrayList<String> ranking;

	public MyListModel(ArrayList<String> list) {
		ranking = list;
	}

	@Override
	public String getElementAt(int number) {
		return ranking.get(number);
	}

	@Override
	public int getSize() {
		return ranking.size();
	}
}

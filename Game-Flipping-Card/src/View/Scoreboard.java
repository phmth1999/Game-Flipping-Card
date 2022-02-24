package View;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import Model.MyListModel;

public class Scoreboard extends JDialog {

	public  Scoreboard() {

		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setTitle("Scoreboard");

		JLabel rank = new JLabel("Ranking");

		ArrayList<String> list = new ArrayList<>();
		String line;

		try {
			BufferedReader br = new BufferedReader(new FileReader("src/scores.txt"));

			while ((line = br.readLine()) != null)
				list.add(line);
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		MyListModel mlm = new MyListModel(list);
		JList<String> ranking = new JList<>(mlm);
		JScrollPane scroll = new JScrollPane(ranking);

		setPreferredSize(new Dimension(200, 300));

		add(rank);
		add(scroll);

		rank.setAlignmentX(CENTER_ALIGNMENT);

		pack();
		setVisible(true);
	}
}

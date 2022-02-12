package View;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Model.Result;

public class EnterScore extends JDialog {

	private int finalScore;
	private int gridA;
	private int gridB;
	private String time;
	private JTextField nameField;
	private GameWindow gameWindow;

	public EnterScore(String time, int secondsForRanking, int gridSize, int gridA, int gridB, GameWindow gameWindow,
			int difficulty) {

		this.gridA = gridA;
		this.gridB = gridB;
		this.time = time;
		this.gameWindow = gameWindow;

		finalScore = (int) ((round((((double) gridSize / (double) secondsForRanking) * difficulty), 3)) * 1000);

		init();
	}

	private void init() {

		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		JLabel congrats = new JLabel("You finished the game in " + time);
		JLabel points = new JLabel("Your score: " + finalScore);
		JLabel enterName = new JLabel("Enter your name:");
		nameField = new JTextField();
		JButton ok = new JButton("OK");

		add(congrats);
		add(Box.createRigidArea(new Dimension(5, 10)));
		add(points);
		add(Box.createRigidArea(new Dimension(5, 10)));
		add(enterName);
		add(Box.createRigidArea(new Dimension(5, 10)));
		add(nameField);
		add(Box.createRigidArea(new Dimension(5, 10)));
		add(ok);
		add(Box.createRigidArea(new Dimension(5, 10)));

		ok.setAlignmentX(CENTER_ALIGNMENT);
		enterName.setAlignmentX(CENTER_ALIGNMENT);
		congrats.setAlignmentX(CENTER_ALIGNMENT);
		points.setAlignmentX(CENTER_ALIGNMENT);

		ok.addActionListener(ActionEvent -> {
			try {
				addToFile();
				dispose();
				gameWindow.dispose();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		pack();
		setVisible(true);
	}

	private void addToFile() throws IOException {
		String name = nameField.getText();
		try {

			FileOutputStream fos = new FileOutputStream("src/tmp.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(new Result(name, finalScore));
			oos.flush();
			oos.close();
			fos.close();

			FileInputStream fis = new FileInputStream("src/tmp.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			String rs=ois.readObject().toString();
			ois.close();
			fis.close();
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("src/scores.txt"));
			bw.write(rs.toString());
			bw.flush();
			bw.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}
}

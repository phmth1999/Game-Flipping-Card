package View;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class MainWindow extends JFrame {

	public MainWindow() {

		setWindow();
	}

	private void setWindow() {

		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		setTitle("Memory game");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(250, 250));

		JLabel title = new JLabel("Memory Game");
		JLabel id = new JLabel("MSSV:17130222");

		add(title);
		add(Box.createRigidArea(new Dimension(5, 10)));
		add(id);
		add(Box.createRigidArea(new Dimension(5, 10)));

		JButton newGame = new JButton("New Game");
		newGame.addActionListener(ActionEvent -> {
			new GridChoice();
		});
		add(newGame);
		add(Box.createRigidArea(new Dimension(5, 10)));

		JButton scoreboard = new JButton("Scoreboard");
		scoreboard.addActionListener(ActionEvent -> {
			new Scoreboard();
		});
		add(scoreboard);
		add(Box.createRigidArea(new Dimension(5, 10)));

		JButton exit = new JButton("Exit");
		exit.addActionListener((ActionEvent) -> {
			System.exit(0);
		});
		add(exit);
		add(Box.createRigidArea(new Dimension(5, 10)));

		setVisible(true);

		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		id.setAlignmentX(Component.CENTER_ALIGNMENT);
		newGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		scoreboard.setAlignmentX(Component.CENTER_ALIGNMENT);
		exit.setAlignmentX(Component.CENTER_ALIGNMENT);

		pack();
	}
}

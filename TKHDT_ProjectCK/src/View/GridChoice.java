package View;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class GridChoice extends JDialog {

	private ArrayList<int[][]> gridSizes;
	private int currentGridIndex = 0;

	public GridChoice() {

		int[][] a = { { 2, 3 } };
		int[][] b = { { 2, 4 } };
		int[][] c = { { 3, 4 } };
		int[][] d = { { 4, 4 } };
		int[][] e = { { 4, 5 } };

		gridSizes = new ArrayList<>();
		gridSizes.add(a);
		gridSizes.add(b);
		gridSizes.add(c);
		gridSizes.add(d);
		gridSizes.add(e);

		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Grid selection");

		initTopPanel();
		add(Box.createRigidArea(new Dimension(5, 10)));
		initBottomPanel();

		pack();
		setVisible(true);
	}

	private int getGridA() {
		return gridSizes.get(currentGridIndex)[0][0];
	}

	private int getGridB() {
		return gridSizes.get(currentGridIndex)[0][1];
	}

	private int getDifficulty() {
		return currentGridIndex + 1;
	}

	private void initTopPanel() {

		JPanel panel = new JPanel();

		ImageIcon arrowLeft = new ImageIcon("src/images/arrow_back.png");
		ImageIcon arrowRight = new ImageIcon("src/images/arrow_forward.png");

		JLabel size = new JLabel("Select grid size: ");
		JTextField displayText = new JTextField(getGridA() + " x " + getGridB());
		JToolBar nav = new JToolBar();
		JButton left = new JButton(arrowLeft);
		JButton right = new JButton(arrowRight);

		right.addActionListener(ActionEvent -> {
			if (currentGridIndex != gridSizes.size() - 1)
				currentGridIndex += 1;
			displayText.setText(getGridA() + " x " + getGridB());
		});

		left.addActionListener(ActionEvent -> {
			if (currentGridIndex != 0)
				currentGridIndex -= 1;
			displayText.setText(getGridA() + " x " + getGridB());
		});

		nav.setPreferredSize(new Dimension(80, 25));
		left.setPreferredSize(new Dimension(25, 25));
		right.setPreferredSize(new Dimension(25, 25));
		displayText.setPreferredSize(new Dimension(100, 25));

		nav.add(left);
		nav.add(right);
		panel.add(size);
		panel.add(displayText);
		panel.add(nav);

		nav.setFloatable(false);
		displayText.setFont(new Font("Arial", Font.BOLD, 14));
		displayText.setHorizontalAlignment(JTextField.CENTER);
		displayText.setEditable(false);

		add(panel);
	}

	private void initBottomPanel() {

		JPanel panel = new JPanel();
		JButton play = new JButton("PLAY");

		panel.add(play);

		add(panel);

		play.addActionListener(ActionEvent -> {
			new GameWindow(getDifficulty(), getGridA(), getGridB(), true);
			dispose();
		});
	}
}

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class GUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSelectionSort = new JButton("Selection sort");
		btnSelectionSort.setBounds(10, 33, 130, 23);
		frame.getContentPane().add(btnSelectionSort);
		
		JButton btnQuickSort = new JButton("Quick Sort");
		btnQuickSort.setBounds(10, 72, 130, 23);
		frame.getContentPane().add(btnQuickSort);
		
		JButton btnNewButton = new JButton("Insertion Sort");
		btnNewButton.setBounds(10, 108, 130, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cebolla Sort");
		btnNewButton_1.setBounds(10, 150, 130, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}

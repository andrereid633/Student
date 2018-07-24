import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class responses extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//responses frame = new responses();
				//	frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public responses(int ID) {
		setBounds(100, 100, 702, 379);
		getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.WHITE);
		textArea.setEditable(false);
		textArea.setBounds(10, 11, 666, 278);
		getContentPane().add(textArea);
		Queries q = new Queries();
		textArea.setText(q.viewResponses(ID));
		
		textField = new JTextField();
		textField.setBounds(10, 300, 451, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				q.addResponse(ID, textField.getText());
				getContentPane().repaint();
			}
		});
		btnNewButton.setBounds(498, 300, 89, 23);
		getContentPane().add(btnNewButton);
		this.setIconifiable(true);
		this.setClosable(true);
	}
}

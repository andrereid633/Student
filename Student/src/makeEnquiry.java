import interfaces.StudentEnquireiesInterface;

import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class makeEnquiry extends JInternalFrame {
	private JTextField textField;
	File selectedFile2 = null;
	File selectedFile = null;
	ObjectOutputStream os;
	ObjectInputStream is;
	Socket socket;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					makeEnquiry frame = new makeEnquiry();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public makeEnquiry() {

		setResizable(true);
		Queries queries = new Queries();
		setBounds(100, 100, 558, 292);
		getContentPane().setLayout(null);

		Choice choice = new Choice();
		choice.setBounds(193, 52, 147, 103);
		getContentPane().add(choice);

		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						null, "jpg", "pdf", "jpeg", "png");
				fileChooser.setFileFilter(filter);
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					selectedFile = fileChooser.getSelectedFile();
				}
			}
		});

		btnBrowse.setBounds(321, 164, 89, 23);
		getContentPane().add(btnBrowse);
		JLabel lblNewLabel = new JLabel("SELECT A SERVICE");
		lblNewLabel.setBounds(217, 32, 147, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblStateYourEnquiry = new JLabel("STATE YOUR ENQUIRY");
		lblStateYourEnquiry.setBounds(203, 78, 142, 14);
		getContentPane().add(lblStateYourEnquiry);

		textField = new JTextField();
		textField.setBounds(66, 103, 392, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblUploadADocument = new JLabel("UPLOAD A DOCUMENTS");
		lblUploadADocument.setBounds(204, 134, 160, 14);
		getContentPane().add(lblUploadADocument);

		JButton btnSubmit = new JButton("Submit");

		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
//				try {
//					Registry r = LocateRegistry.getRegistry(4500);
//					StudentEnquireiesInterface stud = (StudentEnquireiesInterface)r.lookup("localhost");
//					
//					if (selectedFile != null) {
//						//stud.uploadDocument(selectedFile, textField.getText());
//						System.out.println("Hello");
//					}
//					
//					System.out.println("Hello1");
//					if (selectedFile2 != null) {
//						//stud.uploadDocument(selectedFile, textField.getText());
//					}
//					
//					//stud.addEnquiry(textField.getText(), choice.getSelectedItem());
//					
//				} catch (RemoteException e2) {
//					// TODO Auto-generated catch block
//					e2.printStackTrace();
//				} catch (NotBoundException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				} 
////				catch (FileNotFoundException e1) {
////					// TODO Auto-generated catch block
////					e1.printStackTrace();
////				} catch (SQLException e1) {
////					// TODO Auto-generated catch block
////					e1.printStackTrace();
////				}
				closeFrame();
			}
		});
		btnSubmit.setBounds(210, 232, 108, 19);
		getContentPane().add(btnSubmit);

		JLabel lbldoc1 = new JLabel("No document selected");
		lbldoc1.setBounds(195, 168, 116, 14);
		getContentPane().add(lbldoc1);

		JLabel lblDocument = new JLabel("Document 1");
		lblDocument.setBounds(112, 168, 73, 14);
		getContentPane().add(lblDocument);

		JLabel lbldoc2 = new JLabel("No document selected");
		lbldoc2.setBounds(195, 197, 116, 14);
		getContentPane().add(lbldoc2);

		JButton button = new JButton("Browse");

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						null, "jpg", "pdf", "jpeg", "png");
				fileChooser.setFileFilter(filter);
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					selectedFile2 = fileChooser.getSelectedFile();
				}

			}
		});

		button.setBounds(321, 193, 89, 23);
		getContentPane().add(button);

		JLabel lblDocument_1 = new JLabel("Document 2");
		lblDocument_1.setBounds(112, 197, 73, 14);
		getContentPane().add(lblDocument_1);

		choice.add("Applying for Refunds");
		choice.add("Applying for Financial Clearance");
		choice.add("Generation of Semester Fee Statement");
		choice.add("Monies owed");
		choice.add("Account balance");

		this.setIconifiable(true);
		this.setClosable(true);

	}

	public void getStream() {
		try {

			socket = new Socket("localhost", 4400);

			os = new ObjectOutputStream(socket.getOutputStream());
			is = new ObjectInputStream(socket.getInputStream());

		} catch (IOException e) {
			System.err.println("Hello");
		}
	}

	public void closeFrame() {
		try {
			this.setClosed(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

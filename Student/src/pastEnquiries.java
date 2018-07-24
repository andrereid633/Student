import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;

public class pastEnquiries extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pastEnquiries frame = new pastEnquiries();
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
	
	public void closeFrame(){
		try {
			this.setClosed(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public pastEnquiries() {
		int[] EnquiryIDs = new int[10];
		setBounds(100, 100, 689, 359);
		getContentPane().setLayout(new MigLayout("", "[][153.00][147.00][96.00][137.00]", "[][][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Enquiry");
		getContentPane().add(lblNewLabel, "cell 1 0");
		
		JLabel lblLastResponse = new JLabel("Last Response");
		getContentPane().add(lblLastResponse, "cell 2 0");
		
		JLabel lblBy = new JLabel("By");
		getContentPane().add(lblBy, "cell 3 0");
		 JRadioButton rb[] = new JRadioButton[10];
		JLabel lblDate = new JLabel("Date");
		getContentPane().add(lblDate, "cell 4 0");
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int w =0;
				while (w <10){
					if (rb[w].isSelected()){
				responses r = new responses(EnquiryIDs[w]);
				getDesktopPane().add(r);
				r.setVisible(true);
				break;
					
				}
					w++;
					}
				closeFrame();
		
			}});
		getContentPane().add(btnNewButton, "cell 2 10");
		
		JLabel lbl[] = new JLabel[30];
		ButtonGroup bg = new ButtonGroup();
		Queries q = new Queries();
		ResultSet rs = q.getEnquiriesStudent(2);
		
		int i =0;
		int row = 1;
	
		int n = 0;
		
		try {
			while(rs.next()){
				System.out.println(rs.getString("enquiry"));
				EnquiryIDs[n] = rs.getInt("id");
				System.out.println(EnquiryIDs[n]);
				int column = 0;
				rb[n] = new JRadioButton("");
				getContentPane().add(rb[n], "cell "+column+" "+row+",alignx left,aligny center");
				bg.add(rb[n]);
				n++;
				i++;
				column++;
				
				System.out.print("this works");
				lbl[i]= new JLabel(rs.getString("enquiry"));
			
				getContentPane().add(lbl[i], "cell "+column+" "+row+",alignx left,aligny top");
				i++;
				column++;
				
				if (rs.getString("response")!=null){
			lbl[i]= new JLabel(rs.getString("response"));
				getContentPane().add(lbl[i], "cell "+column+" "+row+",alignx left,aligny top");}
				
				i++;
				column++;
				if (rs.getString("date")!=null){
				lbl[i]= new JLabel(rs.getString("date"));
				getContentPane().add(lbl[i], "cell "+column+" "+row+",alignx left,aligny top");}
				
				i++;
				column++;
				if (rs.getString("person")!=null){
				lbl[i]= new JLabel(rs.getString("person"));
				getContentPane().add(lbl[i], "cell "+column+" "+row+",alignx left,aligny top");
				}
				    
				row++;
				i++;
				column++;
				
				
				
			}
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.setIconifiable(true);
		this.setClosable(true);

	}

}

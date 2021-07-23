package assignment2;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class StudentRecord extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtno;
	private JTextField txtcls;
	private JTextField txtsec;
	private JTable table;
	
	
	Connection con = null; 

    Statement stmt = null; 

    ResultSet rs = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentRecord frame = new StudentRecord();
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
	public StudentRecord() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentRecordManagement = new JLabel("STUDENT  RECORD MANAGEMENT");
		lblStudentRecordManagement.setForeground(new Color(153, 0, 51));
		lblStudentRecordManagement.setFont(new Font("Comic Sans MS", Font.BOLD, 29));
		lblStudentRecordManagement.setBounds(450, 33, 560, 36);
		contentPane.add(lblStudentRecordManagement);
		
		JLabel lblRollNo = new JLabel("Roll No:");
		lblRollNo.setForeground(new Color(154, 205, 50));
		lblRollNo.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		lblRollNo.setBounds(102, 108, 95, 35);
		contentPane.add(lblRollNo);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(new Color(154, 205, 50));
		lblName.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		lblName.setBounds(102, 180, 95, 35);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		lblAddress.setForeground(new Color(154, 205, 50));
		lblAddress.setBounds(102, 243, 95, 35);
		contentPane.add(lblAddress);
		
		txtno = new JTextField();
		txtno.setBounds(192, 117, 116, 26);
		contentPane.add(txtno);
		txtno.setColumns(10);
		
		txtname = new JTextField();
		txtname.setBounds(192, 186, 116, 26);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JTextArea textAdr = new JTextArea();
		textAdr.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		textAdr.setForeground(new Color(0, 0, 0));
		textAdr.setBackground(new Color(102, 153, 102));
		textAdr.setBounds(192, 250, 138, 59);
		contentPane.add(textAdr);
		
		JLabel lblNewLabel = new JLabel("Class:");
		lblNewLabel.setForeground(new Color(154, 205, 50));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(366, 111, 95, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblSection = new JLabel("Section:");
		lblSection.setForeground(new Color(154, 205, 50));
		lblSection.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		lblSection.setBounds(366, 192, 79, 35);
		contentPane.add(lblSection);
		
		txtcls = new JTextField();
		txtcls.setBounds(450, 114, 116, 26);
		contentPane.add(txtcls);
		txtcls.setColumns(10);
		
		txtsec = new JTextField();
		txtsec.setBounds(450, 198, 116, 26);
		contentPane.add(txtsec);
		txtsec.setColumns(10);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Rollno", "Name", "Class", "Section", "Address",null},
			},
			new String[] {
				"Column", "Title", "Type", "Editable", "Title"
			}
		));
		table.setBounds(663, 120, 492, 400);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.setFont(new Font("Cambria Math", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(0, 204, 153));
		btnNewButton.setBackground(new Color(255, 228, 196));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try { 

				        Class.forName("com.mysql.cj.jdbc.Driver"); 

				        Connection con = DriverManager.getConnection( 

				            "jdbc:mysql://localhost:3306/student", "root", 

				            "rootmercy"); 

				        stmt = con.createStatement(); 

				        String rollno = txtname.getText(); 

				        String name = txtno.getText(); 

				        String clss = txtcls.getText(); 

				        String sec = txtsec.getText(); 

				        String adr = textAdr.getText(); 

				        String INSERT = "INSERT INTO record VALUES('"

				                        + name + "','" + rollno + "','"

				                        + clss + "','" + sec + "','" + adr 

				                        + "');"; 

				        stmt.executeUpdate(INSERT); 

				        JOptionPane.showMessageDialog( 

				            null, "Record Added Successfully"); 

				        btnNewButton.setEnabled(true); 

				    } 

				    catch (Exception e) { 

				        JOptionPane.showMessageDialog( 

				            null, "Error In Connectivity"); 

				    }
			
				
				
			}
		});
		btnNewButton.setBounds(37, 488, 95, 40);
		contentPane.add(btnNewButton);
		
		JButton btnViewData = new JButton("View data");
		btnViewData.setForeground(new Color(255, 0, 0));
		btnViewData.setFont(new Font("Cambria Math", Font.BOLD, 13));
		btnViewData.setBackground(new Color(255, 228, 196));
		btnViewData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel model 

			    = (DefaultTableModel)table.getModel(); 

			try { 

			    Class.forName("com.mysql.cj.jdbc.Driver"); 

			    Connection con = DriverManager.getConnection( 

			        "jdbc:mysql://localhost:3306/student", "root", 

			        "rootmercy"); 

			    String query = "SELECT* FROM record;"; 

			    ResultSet rs = stmt.executeQuery(query); 

			    while (rs.next()) { 

			        String rollno = rs.getString("rollno"); 

			        String name = rs.getString("name"); 

			        String clss = rs.getString("class"); 

			        String sec = rs.getString("section"); 

			        String adr = rs.getString("address"); 

			        model.addRow( 

			            new Object[] { rollno, name, clss, sec, adr }); 

			    } 

			    rs.close(); 

			    stmt.close(); 

			    con.close(); 
			} 

			catch (Exception e) { 

			    JOptionPane.showMessageDialog(null, 

			                                  "Error In Connectivity"); 
			}
			}
		});
		btnViewData.setBounds(175, 488, 116, 40);
		contentPane.add(btnViewData);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setForeground(new Color(0, 102, 153));
		btnClear.setFont(new Font("Cambria Math", Font.BOLD, 16));
		btnClear.setBackground(new Color(255, 228, 196));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			txtname.setText(""); 

				txtno.setText(""); 

				txtcls.setText(""); 

				txtsec.setText(""); 

				textAdr.setText(""); 
				DefaultTableModel dm 

				    = (DefaultTableModel)table.getModel(); 
				dm.getDataVector().removeAllElements(); 
				table.repaint();
			}
		});
		btnClear.setBounds(326, 487, 95, 40);
		contentPane.add(btnClear);
		
		JButton btnEdit = new JButton("Exit");
		btnEdit.setForeground(new Color(255, 0, 204));
		btnEdit.setFont(new Font("Cambria Math", Font.BOLD, 16));
		btnEdit.setBackground(new Color(255, 228, 196));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnEdit.setBounds(469, 487, 105, 41);
		contentPane.add(btnEdit);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\MANOJ KUMAR\\Desktop\\diary.jpg"));
		label.setBounds(37, 449, 279, 140);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\MANOJ KUMAR\\Desktop\\diary.jpg"));
		label_1.setBounds(311, 449, 279, 140);
		contentPane.add(label_1);
		
		
	}
}

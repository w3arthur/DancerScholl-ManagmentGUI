import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AddStudent extends JFrame {
	private static AddStudent frame;
	
	private static JPanel contentPane;
	private static JTextField textField_ID;
	private static JTextField textField_FirstName;
	private static JTextField textField_LastName;
	private static JTextField textField_Year;
	private static JTextField textField_Month;
	private static JTextField textField_Day;
	private JLabel lblNewLabel_3;
	private JLabel label;
	private JLabel label_1;
	private JButton btnSend;


	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AddStudent();
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
	public AddStudent() {
		setTitle("\u05D4\u05D5\u05E1\u05E4\u05EA \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 326, 353);
		contentPane = new JPanel();		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u05D4\u05E7\u05DC\u05D3 \u05D0\u05EA \u05E4\u05E8\u05D8\u05D9 \u05D4\u05E1\u05D8\u05D5\u05D3\u05E0\u05D8 \u05DC\u05D4\u05D5\u05E1\u05E4\u05D4");
		lblNewLabel.setBounds(104, 20, 173, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u05EA\"\u05D6");
		lblNewLabel_1.setBounds(200, 54, 45, 13);
		panel.add(lblNewLabel_1);
		
		textField_ID = new JTextField();
		textField_ID.setBounds(82, 47, 96, 27);
		panel.add(textField_ID);
		textField_ID.setColumns(10);
		
		textField_FirstName = new JTextField();
		textField_FirstName.setColumns(10);
		textField_FirstName.setBounds(82, 89, 96, 27);
		panel.add(textField_FirstName);
		
		textField_LastName = new JTextField();
		textField_LastName.setColumns(10);
		textField_LastName.setBounds(82, 138, 96, 27);
		panel.add(textField_LastName);
		
		JLabel lblFirstName = new JLabel("\u05E9\u05DD \u05E4\u05E8\u05D8\u05D9");
		lblFirstName.setBounds(188, 96, 59, 13);
		panel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05E4\u05D7\u05D4");
		lblLastName.setBounds(188, 145, 59, 13);
		panel.add(lblLastName);
		
		textField_Year = new JTextField();
		textField_Year.setBounds(56, 184, 45, 27);
		panel.add(textField_Year);
		textField_Year.setColumns(10);
		
		textField_Month = new JTextField();
		textField_Month.setBounds(115, 184, 25, 27);
		panel.add(textField_Month);
		textField_Month.setColumns(10);
		
		textField_Day = new JTextField();
		textField_Day.setColumns(10);
		textField_Day.setBounds(153, 184, 25, 27);
		panel.add(textField_Day);
		
		lblNewLabel_3 = new JLabel("-");
		lblNewLabel_3.setBounds(144, 191, 9, 13);
		panel.add(lblNewLabel_3);
		
		label = new JLabel("-");
		label.setBounds(104, 191, 9, 13);
		panel.add(label);
		
		label_1 = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05DC\u05D9\u05D3\u05D4");
		label_1.setBounds(188, 191, 59, 13);
		panel.add(label_1);
		
		btnSend = new JButton("\u05D0\u05D9\u05E9\u05D5\u05E8");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
//1
/***/			addStudent();
			}
		});
		btnSend.setBounds(104, 250, 85, 27);
		btnSend.setBackground(new Color(0x515151));
		
		
		panel.add(btnSend);
	}
	
	public static void addStudent() {
		addStudent_sql(
				textField_ID.getText(),
				textField_FirstName.getText(),
				textField_LastName.getText(),
				String.format("%s-%s-%s",textField_Year.getText(),textField_Month.getText(),textField_Day.getText())
				);
	}
	
	public static void addStudent_sql(String id, String firstName, String lastName, String Birthdate) {try {
		String quary="if(NOT Exists (select ID from person where ID=?)) BEGIN "
				+ "insert into person values (?, ?, ?, ?) \n"
				+ "insert into student values (?) \n"
				+ "END \n"
				+ "else RAISERROR (1,16,1)";
		
		/*Sql*/
		Connection connection = DriverManager.getConnection(Main.connectUrl);
		CallableStatement callablestatement = connection.prepareCall(quary);
		callablestatement.setString(1, id);
		callablestatement.setString(2, id);
		callablestatement.setString(6, id);
		callablestatement.setString(3, firstName);
		callablestatement.setString(4, lastName);
		callablestatement.setString(5, Birthdate);
		callablestatement.executeUpdate();
		callablestatement.close();
		
		/*Close Sql*/
		connection.close();
		JOptionPane.showMessageDialog(contentPane, "\u05D4\u05E1\u05D8\u05D5\u05D3\u05E0\u05D8 \u05D4\u05D5\u05E1\u05E3 \u05D1\u05D4\u05E6\u05DC\u05D7\u05D4", "\u05D1\u05D5\u05E6\u05E2",JOptionPane.INFORMATION_MESSAGE);
	} catch (SQLException e) {JOptionPane.showMessageDialog(contentPane, "\u05D4\u05D5\u05E1\u05E4\u05EA \u05D4\u05E1\u05D8\u05D5\u05D3\u05E0\u05D8 \u05E0\u05D5\u05D2\u05D3\u05EA \u05D0\u05EA \u05D4\u05D4\u05D2\u05D3\u05E8\u05D5\u05EA \u05D1\u05DE\u05E1\u05D3 \u05D4\u05E0\u05EA\u05D5\u05E0\u05D9\u05DD\r\n\u05EA\"\u05D6 9 \u05E1\u05E4\u05E8\u05D5\u05EA \u05E9\u05DC\u05D0 \u05E7\u05D9\u05D9\u05DD \u05DB\u05D1\u05E8 \u05D1\u05DE\u05E2\u05E8\u05EA\r\n1991-12-12 \u05EA\u05D0\u05E8\u05D9\u05DA \u05D1\u05EA\u05E7\u05DF\r\n\u05EA\u05D0\u05E8\u05D9\u05DA 16 \u05E9\u05E0\u05D9\u05DD \u05D4\u05E4\u05E8\u05E9 \u05DE\u05E9\u05DC \u05D4\u05D9\u05D5\u05DD\r\n\u05E9\u05DD \u05E4\u05E8\u05D8\u05D9+\u05DE\u05E9\u05E4\u05D7\u05D4 \u05D0\u05D5\u05EA\u05D9\u05D5\u05EA \u05D0\u05E0\u05D2\u05DC\u05D9\u05D5\u05EA", "\u05EA\u05E7\u05DC\u05EA SQL",JOptionPane.INFORMATION_MESSAGE);}}
	
	
	
}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class EditStudent extends JFrame {
	private static JPanel contentPane;
	@SuppressWarnings("rawtypes")
	private static JComboBox comboBox;
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
			public void run() {try {
					EditStudent frame = new EditStudent();
					frame.setVisible(true);
					
				} catch (Exception e) {e.printStackTrace();}}
		});
		
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("rawtypes")
	public EditStudent() {
		setTitle("\u05E2\u05E8\u05D9\u05DB\u05EA \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
//Page Exit
/***/			closeWindow();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 326, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u05D1\u05D7\u05E8 \u05D0\u05EA \u05D4\u05E1\u05D8\u05D5\u05D3\u05E0\u05D8 \u05D5\u05E2\u05E8\u05D5\u05DA \u05DC\u05D5 \u05D0\u05EA \u05D4\u05E4\u05E8\u05D8\u05D9\u05DD");
		lblNewLabel.setBounds(70, 10, 189, 26);
		panel.add(lblNewLabel);
		
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
		lblNewLabel_3.setBounds(145, 191, 9, 13);
		panel.add(lblNewLabel_3);
		
		label = new JLabel("-");
		label.setBounds(105, 191, 9, 13);
		panel.add(label);
		
		label_1 = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05DC\u05D9\u05D3\u05D4");
		label_1.setBounds(188, 191, 59, 13);
		panel.add(label_1);
		
		btnSend = new JButton("\u05D0\u05D9\u05E9\u05D5\u05E8");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
//2
/***/			editStudent();
			}
		});
		btnSend.setBounds(105, 246, 85, 27);
		btnSend.setBackground(new Color(0x515151));
		panel.add(btnSend);
		
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
//select item			
/***/				setAreas();
			}
		});
		comboBox.setBounds(33, 46, 214, 27);
		panel.add(comboBox);
		
		
//Page Start
/***/			pageStart();
		
	}
	
	
	public static Connection connection=null;
	
	public static void pageStart() {pageStart(0);}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void pageStart(int place) {try {
			String quary = "Select  Person.*\r\n" + 
					"from Person, Student\r\n" + 
					"where ID=StudentID";
			
			/*Sql*/
			connection = DriverManager.getConnection(Main.connectUrl);
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery(quary);
			
			List<Object> list = new ArrayList<>();
			while (resultset.next()) list.add(String.format("%s %s %s",resultset.getObject(1),resultset.getObject(2),resultset.getObject(3)));
			
			/*Close Sql*/
			resultset.close();
			statement.close();
			Object[] possibilities= new Object[list.size()+(list.size()!=0 ? 0 : 1)];
			int i=0;
			for(Object o:list) {possibilities[i]=o;i++;}
			
			comboBox.setModel(new DefaultComboBoxModel(possibilities));
			comboBox.setSelectedIndex(place);
			if (list.size() != 0) setAreas();
		} catch (SQLException e) {e.printStackTrace();}
	}
	
	
	public static void setAreas() {try {if (comboBox.getSelectedItem()!=null) {
			String quary = "select FirstName, LastName, YEAR(DateOfBirth) year, MONTH(DateOfBirth) month, Day (DateOfBirth) day  from Student join Person on StudentID=ID where StudentID=?";
			PreparedStatement preparedstatement = connection.prepareStatement(quary);
			preparedstatement.setString(1,comboBox.getSelectedItem().toString().substring(0, 9));
			ResultSet resultset = preparedstatement.executeQuery();
			resultset.next();
			
			textField_FirstName.setText(resultset.getObject(1).toString());
			textField_LastName.setText(resultset.getObject(2).toString());
			textField_Year.setText(resultset.getObject(3).toString());
			textField_Month.setText(resultset.getObject(4).toString());
			textField_Day.setText(resultset.getObject(5).toString());

			/*Close Sql*/
			preparedstatement.close();
			resultset.close();
	}} catch (SQLException e) {e.printStackTrace();}}
	
	
	
	public static void editStudent() {
		try {
			String quary="update Person SET FirstName=?, LastName=?, DateOfBirth=? where ID=?";
			String id=comboBox.getSelectedItem().toString().substring(0, 9);
			String date=String.format("%s-%s-%s", textField_Year.getText(),textField_Month.getText(),textField_Day.getText());
			
			/*Sql*/
			CallableStatement  callablestatement = connection.prepareCall(quary);
			callablestatement.setString(1, textField_FirstName.getText());
			callablestatement.setString(2, textField_LastName.getText());
			callablestatement.setString(3, date);
			callablestatement.setString(4, id);
			callablestatement.executeUpdate();
			callablestatement.close();
			
			
			JOptionPane.showMessageDialog(contentPane, "\u05D4\u05E1\u05D8\u05D5\u05D3\u05E0\u05D8 \u05E0\u05E2\u05E8\u05DA \u05D1\u05D4\u05E6\u05DC\u05D7\u05D4", "\u05D1\u05D5\u05E6\u05E2",JOptionPane.INFORMATION_MESSAGE);
			pageStart(comboBox.getSelectedIndex());
		} catch (SQLException e) {JOptionPane.showMessageDialog(contentPane, "\u05E2\u05E8\u05D9\u05DB\u05EA \u05D4\u05E1\u05D8\u05D5\u05D3\u05E0\u05D8 \u05E0\u05D5\u05D2\u05D3\u05EA \u05D0\u05EA \u05D4\u05D4\u05D2\u05D3\u05E8\u05D5\u05EA \u05D1\u05DE\u05E1\u05D3 \u05D4\u05E0\u05EA\u05D5\u05E0\u05D9\u05DD\r\n1991-12-12 \u05EA\u05D0\u05E8\u05D9\u05DA \u05D1\u05EA\u05E7\u05DF\r\n\u05EA\u05D0\u05E8\u05D9\u05DA 16 \u05E9\u05E0\u05D9\u05DD \u05D4\u05E4\u05E8\u05E9 \u05DE\u05E9\u05DC \u05D4\u05D9\u05D5\u05DD\r\n\u05E9\u05DD \u05E4\u05E8\u05D8\u05D9+\u05DE\u05E9\u05E4\u05D7\u05D4 \u05D0\u05D5\u05EA\u05D9\u05D5\u05EA \u05D0\u05E0\u05D2\u05DC\u05D9\u05D5\u05EA", "\u05EA\u05E7\u05DC\u05EA SQL",JOptionPane.INFORMATION_MESSAGE);}
	}
	
	public static void closeWindow() {
		try {connection.close();} catch (SQLException e) {e.printStackTrace();}
	}
	
	//add close to Connect to back/exit
}

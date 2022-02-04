import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import java.awt.GridBagLayout;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JScrollPane;
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
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


@SuppressWarnings("serial")
public class Main extends JFrame {
	
	/*Sql*/ public static String connectUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=College;integratedSecurity=true";
	private static AddStudent pageAddStudent;
	private static EditStudent pageEditStudent;
	public static JButton btnAddNewStudent;
	public static JButton btnEditStudent;
	public static JButton btnDeleteStudent;
	public static JButton btnReCoursed;
	public static JButton button_4;
	public static JButton button_5;
	public static JButton button_6;
	public static JButton button_7;
	public static JButton button_8;
	public static JButton button_9;
	public static JTextField lblTitle;
	public static boolean windowBackFocused=false;
	
	private static JPanel contentPane;
	private static JTable table;
	private static JPanel panelTable;
	private static JScrollPane scrollPane;
	private static DefaultTableModel model;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private static GridBagConstraints gbc_panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				windowBackFocused=true;
			}
		});
		setTitle("\u05DE\u05D8\u05DC\u05EA \u05D1\u05D5\u05E0\u05D5\u05E1 \u05D1\u05DE\u05E1\u05D3\u05D9 \u05E0\u05EA\u05D5\u05E0\u05D9\u05DD - \u05D0\u05E8\u05D8\u05D5\u05E8 \u05D6\u05E8\u05E0\u05E7\u05D9\u05DF");
//Page Design			
/***/	pageDesign();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 39, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblTitle = new JTextField();
		lblTitle.setText(titleBeginText);
		lblTitle.setEditable(false);
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTitle.gridwidth = 9;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 4;
		gbc_lblTitle.gridy = 0;
		contentPane.add(lblTitle, gbc_lblTitle);
		lblTitle.setColumns(10);
		lblTitle.setBackground(Color.BLACK);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setHorizontalAlignment(JTextField.CENTER);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 17;
		gbc_scrollPane.gridheight = 9;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		panelTable = new JPanel();
		scrollPane.setViewportView(panelTable);
		GridBagLayout gbl_panelTable = new GridBagLayout();
		gbl_panelTable.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelTable.rowHeights = new int[]{0, 0};
		gbl_panelTable.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelTable.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelTable.setLayout(gbl_panelTable);
		
		table = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 14;
		gbc_table.insets = new Insets(0, 0, 0, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		panelTable.add(table, gbc_table);
		
		JPanel panel = new JPanel();
		gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 9;
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 17;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		btnAddNewStudent = new JButton("\u05D4\u05D5\u05E1\u05E3 \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
		btnAddNewStudent.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
//uncheck AddStudent button when window closed
/***/			if(!windowBackFocused) resetAllButtonsBackground();
				else windowBackFocused=false;
			}
		});
		buttonGroup.add(btnAddNewStudent);
		
		btnAddNewStudent.setPreferredSize(buttonSizes);

		btnAddNewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//1
/***/				addStudentPage();
	
			}
		});
		GridBagConstraints gbc_btnAddNewStudent = new GridBagConstraints();
		gbc_btnAddNewStudent.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddNewStudent.gridx = 0;
		gbc_btnAddNewStudent.gridy = 0;
		panel.add(btnAddNewStudent, gbc_btnAddNewStudent);

		btnEditStudent = new JButton("\u05E2\u05E8\u05D5\u05DA \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
		btnEditStudent.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
//uncheck EditStudent button when window closed
/***/			if(!windowBackFocused) resetAllButtonsBackground();
				else windowBackFocused=false;
			}
		});
		buttonGroup.add(btnEditStudent);
		btnEditStudent.setPreferredSize(buttonSizes);
		btnEditStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//2
/***/			editStudentPage();
			}
		});
		GridBagConstraints gbc_btnEditStudent = new GridBagConstraints();
		gbc_btnEditStudent.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditStudent.gridx = 0;
		gbc_btnEditStudent.gridy = 1;
		panel.add(btnEditStudent, gbc_btnEditStudent);
		
		btnDeleteStudent = new JButton("\u05DE\u05D7\u05E7 \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
		buttonGroup.add(btnDeleteStudent);
		btnDeleteStudent.setPreferredSize(buttonSizes);
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//3
/***/			studentDelete();
			}
		});
		GridBagConstraints gbc_btnDeleteStudent = new GridBagConstraints();
		gbc_btnDeleteStudent.insets = new Insets(0, 0, 5, 0);
		gbc_btnDeleteStudent.gridx = 0;
		gbc_btnDeleteStudent.gridy = 2;
		panel.add(btnDeleteStudent, gbc_btnDeleteStudent);
		

		btnReCoursed = new JButton("\u05E7\u05D5\u05E8\u05E1\u05D9\u05DD \u05D7\u05D5\u05D6\u05E8\u05D9\u05DD");
		buttonGroup.add(btnReCoursed);
		btnReCoursed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//4
/***/			reCourse();
			}
		});
		btnReCoursed.setPreferredSize(buttonSizes);
		GridBagConstraints gbc_btnReCoursed = new GridBagConstraints();
		gbc_btnReCoursed.insets = new Insets(0, 0, 5, 0);
		gbc_btnReCoursed.gridx = 0;
		gbc_btnReCoursed.gridy = 3;
		panel.add(btnReCoursed, gbc_btnReCoursed);
		
		button_4 = new JButton("\u05E7\u05D5\u05E8\u05E1\u05D9\u05DD \u05D1\u05DC\u05D9 \u05EA\u05E8\u05D2\u05D5\u05DC");
		buttonGroup.add(button_4);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//5
/***/			CourseWithoutInstractionGroup();
			}
		});
		button_4.setPreferredSize(buttonSizes);
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.insets = new Insets(0, 0, 5, 0);
		gbc_button_4.gridx = 0;
		gbc_button_4.gridy = 4;
		panel.add(button_4, gbc_button_4);
		
		button_5 = new JButton("\u05D4\u05EA\u05D7\u05DC\u05EA \u05D4\u05D5\u05E8\u05D0\u05EA \u05DE\u05E8\u05E6\u05D4");
		buttonGroup.add(button_5);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//6
/***/				beginTeachingDate();
			}
		});
		button_5.setPreferredSize(buttonSizes);
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.insets = new Insets(0, 0, 5, 0);
		gbc_button_5.gridx = 0;
		gbc_button_5.gridy = 5;
		panel.add(button_5, gbc_button_5);
		
		button_6 = new JButton("\u05DB\u05D9\u05DE\u05D5\u05EA \u05E7\u05D5\u05E8\u05E1\u05D9\u05DD \u05DE\u05E8\u05E6\u05D4 \u05DC\u05E9\u05E0\u05D4");
		buttonGroup.add(button_6);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//7
/***/				teacherCourseCount();
			}
		});
		button_6.setPreferredSize(buttonSizes);
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.insets = new Insets(0, 0, 5, 0);
		gbc_button_6.gridx = 0;
		gbc_button_6.gridy = 6;
		panel.add(button_6, gbc_button_6);
		
		button_7 = new JButton("\u05DE\u05DE\u05D5\u05E6\u05E2 \u05D4\u05E6\u05D9\u05D5\u05E0\u05D9\u05DD \u05D1\u05E7\u05D5\u05E8\u05E1");
		buttonGroup.add(button_7);
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//8
/***/			courseAvg();
			}
		});
		button_7.setPreferredSize(buttonSizes);
		GridBagConstraints gbc_button_7 = new GridBagConstraints();
		gbc_button_7.insets = new Insets(0, 0, 5, 0);
		gbc_button_7.gridx = 0;
		gbc_button_7.gridy = 7;
		panel.add(button_7, gbc_button_7);
		
		button_8 = new JButton("\u05E1\u05D8\u05D5\u05D3\u05E0\u05D8\u05D9\u05DD \u05DC\u05D0 \u05DC\u05D5\u05DE\u05D3\u05D9\u05DD \u05D4\u05E9\u05E0\u05D4");
		buttonGroup.add(button_8);
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//9
/***/			studentsNotInYear();
			}
		});
		button_8 .setPreferredSize(buttonSizes);
		GridBagConstraints gbc_button_8 = new GridBagConstraints();
		gbc_button_8.insets = new Insets(0, 0, 5, 0);
		gbc_button_8.gridx = 0;
		gbc_button_8.gridy = 8;
		panel.add(button_8, gbc_button_8);
		
		button_9 = new JButton("\u05E1\u05D8\u05D5\u05D3\u05E0\u05D8\u05D9\u05DD \u05D1\u05E1\u05DE\u05E1\u05D8\u05E8 \u05D4\u05E2\u05D5\u05E7\u05D1");
		buttonGroup.add(button_9);
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//10
/***/			studentsNestSemester();
			}
		});
		button_9.setPreferredSize(buttonSizes);
		GridBagConstraints gbc_button_9 = new GridBagConstraints();
		gbc_button_9.insets = new Insets(0, 0, 5, 0);
		gbc_button_9.gridx = 0;
		gbc_button_9.gridy = 9;
		panel.add(button_9, gbc_button_9);
		
		JButton btnNewButton = new JButton("\u05E6\u05D0");
		btnNewButton.setPreferredSize(buttonSizes);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//Window close
/***/
				closeAddEditWindows();
				dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 15;
		panel.add(btnNewButton, gbc_btnNewButton);	
	}
	

	

	public static String titleBeginText="\u05D1\u05E8\u05D5\u05DA \u05D4\u05D1\u05D0";
	public static void setNullTitle() {
		lblTitle.setText(titleBeginText);
		}
	public static void titleAddValue(Object o) {
		lblTitle.setText(lblTitle.getText()+" ("+o+")");
	}
	

	
	
	public static void setNullTableAndButtons() {
			
		model = new DefaultTableModel();
		model.setDataVector(new Object[][] {}, new String[] {});
		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		resetAllButtonsBackground();
		setNullTitle();
		
		}
	
	public static void setCheckedButton(JButton button) {
		setNullTableAndButtons();
		closeAddEditWindows();	
		lblTitle.setText(button.getText());
		button.setBackground(checkedButtonColor);
		
	}
	
	
	@SuppressWarnings("static-access")
	public static void 	closeAddEditWindows() {
		if(pageAddStudent!=null)pageAddStudent.dispose();
		if(pageEditStudent!=null) {
			try {if(pageEditStudent.connection!=null) pageEditStudent.connection.close();} catch (SQLException e) {e.printStackTrace();}
			finally{pageEditStudent.dispose();}
		}
	}
	
	public static void resetAllButtonsBackground() {
		btnAddNewStudent.setBackground(uncheckedButtonColor);
		btnEditStudent.setBackground(uncheckedButtonColor);
		btnDeleteStudent.setBackground(uncheckedButtonColor);
		btnReCoursed.setBackground(uncheckedButtonColor);
		button_4.setBackground(uncheckedButtonColor);
		button_5.setBackground(uncheckedButtonColor);
		button_6.setBackground(uncheckedButtonColor);
		button_7.setBackground(uncheckedButtonColor);
		button_8.setBackground(uncheckedButtonColor);
		button_9.setBackground(uncheckedButtonColor);
		setNullTitle();
	}
	
	
	private static Dimension buttonSizes=new Dimension(170, 20);
	
	public static Color uncheckedButtonColor=new Color(0x21242b);
	public static Color checkedButtonColor=new Color(0x474d59);
	
	//Design
	public static void pageDesign(){try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		    	if ("Nimbus".equals(info.getName())) {UIManager.setLookAndFeel(info.getClassName());break;}
		    	}
		
			UIManager.put("text", new Color(0xfffefe));
			UIManager.put("nimbusLightBackground", new Color(0x515151));
			UIManager.put("nimbusSelectedText", Color.DARK_GRAY);//
			UIManager.put("nimbusSelectionBackground", new Color(0x58a2f6));
		//	UIManager.put("nimbusFocus", new Color(0x10101));//
			UIManager.put("nimbusBlueGrey", uncheckedButtonColor);
			UIManager.put("control", new Color(0x21242b));
			UIManager.put("Button.contentMargins", new Insets(0, 1, 0, 1));
			UIManager.put("ComboBox.arrowButton", new Color(0x21242b));
			UIManager.put("ComboBox.background", new Color(0x21242b));	
			
			
	// More information: https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/_nimbusDefaults.html		
	} catch (Exception e) {e.printStackTrace();}}
	
	
	
	//1 AddStudent 
	public static void addStudentPage() {
		setNullTableAndButtons();
		setCheckedButton(btnAddNewStudent);
	
		pageAddStudent= new AddStudent();
		pageAddStudent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pageAddStudent.setLocationRelativeTo(contentPane); 
		pageAddStudent.setVisible(true);
	}
	
	//2 EditStudent 
	public static void editStudentPage() {
		setNullTableAndButtons();
		setCheckedButton(btnEditStudent);
		
		pageEditStudent= new EditStudent();
		pageEditStudent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pageEditStudent.setLocationRelativeTo(contentPane); 
		pageEditStudent.setVisible(true);
	}
	
	
	//3
	public static void studentDelete() {try {
		setCheckedButton(btnDeleteStudent);
		
		String quary1 = "Select  StudentID, FirstName+' '+LastName FullName\r\n" + 
				"from Person, Student\r\n" + 
				"where ID=StudentID";
		
		/*Sql*/
		Connection connection = DriverManager.getConnection(connectUrl);
		List<Object> list=statmentForList(connection, quary1);	
		String s = possibilitiesChoose(list, "\u05D1\u05D7\u05E8 \u05EA\"\u05D6 \u05E9\u05DC \u05DE\u05E8\u05E9\u05D9\u05DE\u05EA \u05DB\u05DC \u05D4\u05E1\u05D8\u05D5\u05D3\u05E0\u05D8\u05D9\u05DD \u05DC\u05DE\u05D7\u05D9\u05E7\u05D4","\u05DE\u05D7\u05D9\u05E7\u05EA \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");	
		
		/*Sql*/
		int acceptDelete=1;
		if(s!=null) acceptDelete= JOptionPane.showConfirmDialog(contentPane, "\u05D0\u05E9\u05E8 \u05DE\u05D7\u05D9\u05E7\u05D4 \u05E9\u05DC \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8" + "\n" + s, "\u05D0\u05D6\u05D4\u05E8\u05EA \u05DE\u05D7\u05D9\u05E7\u05D4", JOptionPane.OK_CANCEL_OPTION);
		if(acceptDelete==0) {
			String id=s.substring(0, 9);
			String quary2 = "delete LearnsIn where StudentID=? \r\n" + 
					"delete StudentInCourse where StudentID=? \r\n" + 
					"delete Student where StudentID=? ";
			CallableStatement callablestatement = connection.prepareCall(quary2);
			int i=1;
			while(i<=3) callablestatement.setString(i++,id); //3 times 
			callablestatement.executeUpdate();
			callablestatement.close();
			resetAllButtonsBackground();
			JOptionPane.showMessageDialog(contentPane, "\u05D4\u05E1\u05D8\u05D5\u05D3\u05E0\u05D8 \u05E0\u05DE\u05D7\u05E7","\u05D0\u05D9\u05E9\u05D5\u05E8 \u05DE\u05D7\u05D9\u05E7\u05D4",JOptionPane.INFORMATION_MESSAGE);
		}
		else resetAllButtonsBackground();
		
		/*Close Sql*/
		connection.close();	
	} catch (SQLException e) {e.printStackTrace();}}
	
	
	//4
	public static void reCourse() {try {
		setCheckedButton(btnReCoursed);
		
		String quary= "select StudentID, FirstName+' '+LastName FullName,CourseName\r\n" + 
				"from Person P join StudentInCourse SIC on ID=StudentID join Course C ON SIC.CourseCode=C.CourseCode\r\n" + 
				"group by StudentID,FirstName,LastName, CourseName\r\n" + 
				"having count(*)>=2\r\n" + 
				"order by StudentID";
		
		/*Sql*/ 
		Connection connection = DriverManager.getConnection(connectUrl);
		List<String []> list = statmentForTable(connection, quary);
		createTable(list, "Student ID", "Full Name", "Course Name", 50, 100, 150);
		
		/*Close Sql*/
		connection.close();	
	} catch (SQLException e) {e.printStackTrace();}}
	
	//5
	public static void CourseWithoutInstractionGroup() {try {
		setCheckedButton(button_4);
		
		String quary= "select CourseCode, SchoolYear, SemesterName from Course\r\n" + 
				"EXCEPT\r\n" + 
				"select CourseCode, SchoolYear, SemesterName from InstructionGroup"; //
		
		/*Sql*/
		Connection connection = DriverManager.getConnection(connectUrl);
		List<String []> list = statmentForTable(connection, quary);
		createTable(list, "Course#", "Year", "Semester", 100, 100, 100);
			
		/*Close Sql*/
		connection.close();	
	} catch (SQLException e) {e.printStackTrace();}}

	//6
	public static void beginTeachingDate() {try {
		setCheckedButton(button_5);
		
		String quary1= "select TeacherID, FirstName+' '+LastName FullName\r\n" + 
				"from Teacher join Person on TeacherID=ID"; 
		
		/*Sql*/
		Connection connection = DriverManager.getConnection(connectUrl);		
		List<Object> list1=statmentForList(connection, quary1);	
		String s = possibilitiesChoose(list1,"\u05D1\u05D7\u05E8 \u05EA\"\u05D6 \u05DE\u05E8\u05E9\u05D9\u05DE\u05EA \u05DB\u05DC \u05D4\u05DE\u05E8\u05E6\u05D9\u05DD","\u05D4\u05EA\u05D7\u05DC\u05EA \u05D4\u05D5\u05E8\u05D0\u05EA \u05DE\u05E8\u05E6\u05D4");	
			
		if(s!=null) {
		String id=s.substring(0, 9);
		titleAddValue(id);
		String quary2 = "select top 1 TeacherID, FirstName+' '+LastName FullName, SchoolYear\r\n" + 
				"from CourseTeacher join Person on TeacherID=ID\r\n" + 
				"where TeacherID=?\r\n" + 
				"group by TeacherID, FirstName, LastName, SchoolYear\r\n" + 
				"order by SchoolYear";
		/*Sql*/
		List<String []> list2 = preparedstatementListForTable (connection, quary2, id,null,3);
		createTable(list2, "Teacher ID", "Full Name", "Begin Date", 100, 100, 100);
		}
		else resetAllButtonsBackground();
	
		/*Close Sql*/
		connection.close();	
	} catch (SQLException e) {e.printStackTrace();}}
	
	
	//7
	public static void teacherCourseCount() {try {
		setCheckedButton(button_6);
		
		String quary1= "select distinct TeacherID +' '+ FirstName+' '+LastName FullName, '[' +CONVERT(varchar(4), SchoolYear)+ ']' SchoolYear\r\n" + 
				"from CourseTeacher join Person on TeacherID=ID\r\n" + 
				"order by FullName"; 
		
		/*Sql*/
		Connection connection = DriverManager.getConnection(connectUrl);		
		List<Object> list1=statmentForList(connection, quary1);	
		String s = possibilitiesChoose(list1,"\u05D1\u05D7\u05E8 \u05EA\"\u05D6 \u05D5[\u05E9\u05E0\u05D4] \u05E9\u05DC \u05D4\u05DE\u05E8\u05E6\u05D4 \u05DE\u05EA\u05D5\u05DA \u05DE\u05E1\u05D3 \u05D4\u05E0\u05EA\u05D5\u05E0\u05D9\u05DD","\u05DB\u05DE\u05D4 \u05E7\u05D5\u05E8\u05E1\u05D9\u05DD \u05D4\u05E2\u05D1\u05D9\u05E8 \u05D4\u05DE\u05E8\u05E6\u05D4 \u05D1\u05E9\u05E0\u05D4");	
			
		if(s!=null) {
			String id=s.substring(0, 9);
			String date=s.substring(s.length()-5, s.length()-1);
			titleAddValue(id+" ["+date+"]");
			String quary2 = "select TeacherID, FirstName+' '+LastName FullName, COUNT(*) Cnt\r\n" + 
					"from CourseTeacher join Person on TeacherID=ID\r\n" + 
					"where TeacherID=? and SchoolYear=?\r\n" + 
					"group by TeacherID, FirstName, LastName";
			/*Sql*/
			List<String []> list2 = preparedstatementListForTable (connection, quary2, id, date,3);
			createTable(list2, "Teacher ID", "Full Name", "Number of Courses", 50, 70, 100);
		}
		else resetAllButtonsBackground();
	
		/*Close Sql*/
		connection.close();	
	} catch (SQLException e) {e.printStackTrace();}}	
	

	//8
	public static void courseAvg() {try {
		setCheckedButton(button_7);
		
		String quary1= "select CourseCode, CourseName from Course"; 
		
		/*Sql*/
		Connection connection = DriverManager.getConnection(connectUrl);		
		List<Object> list1=statmentForList(connection, quary1);	
		String s = possibilitiesChoose(list1,"\u05D1\u05D7\u05E8 \u05DE\u05E1\u05E4\u05E8 \u05E7\u05D5\u05E8\u05E1 \u05DE\u05EA\u05D5\u05DA \u05E8\u05E9\u05D9\u05DE\u05EA \u05D4\u05E7\u05D5\u05E8\u05E1\u05D9\u05DD \u05D4\u05E7\u05D9\u05D9\u05DE\u05D9\u05DD","\u05DE\u05DE\u05D5\u05E6\u05E2 \u05D4\u05E6\u05D9\u05D5\u05E0\u05D9\u05DD \u05D1\u05E7\u05D5\u05E8\u05E1");	
			
		if(s!=null) {
		int courseCode= Integer.parseInt(s.substring(0, 3));
		titleAddValue(courseCode);
		String quary2 = "select TeacherID,FirstName+' '+LastName FullName, I.CourseName, I.SemesterName, I.SchoolYear, Avarage\r\n" + 
				"from ( select C.CourseCode, C.CourseName, C.SemesterName, C.SchoolYear, CONVERT(decimal(5,3),AVG(Grade)) Avarage\r\n" + 
				"		from StudentInCourse SIC join Course C on SIC.CourseCode=C.CourseCode\r\n" + 
				"		where C.CourseCode=?\r\n" + 
				"		group by C.CourseCode, C.CourseName, C.SemesterName, C.SchoolYear\r\n" + 
				"		)I left join CourseTeacher CT on I.CourseCode=CT.CourseCode left join Person on TeacherID=ID";
		/*Sql*/
		List<String []> list2 = preparedstatementListForTable (connection, quary2, courseCode, null, 6);
		createTable(list2, "Teacher ID", "Full Name", "Course Name", "Semester", "Year", "Avg", 50, 70, 100,40,20,20);
		}
		else resetAllButtonsBackground();
	
		/*Close Sql*/
		connection.close();	
	} catch (SQLException e) {e.printStackTrace();}}	
	
	
	
	//9
	public static void studentsNotInYear() {try {
		setCheckedButton(button_8);
		
		String quary1= "select distinct SchoolYear, '' EmptyBox from StudentInCourse"; 
		
		/*Sql*/
		Connection connection = DriverManager.getConnection(connectUrl);		
		List<Object> list1=statmentForList(connection, quary1);	
		String s = possibilitiesChoose(list1,"\u05D1\u05D7\u05E8 \u05E9\u05E0\u05D4 \u05DE\u05EA\u05D5\u05DA \u05E8\u05E9\u05D9\u05DE\u05EA \u05D4\u05E9\u05E0\u05D9\u05DD \u05E9\u05DC \u05D4\u05E7\u05D5\u05E8\u05E1\u05D9\u05DD \u05DE\u05DE\u05E1\u05D3 \u05D4\u05E0\u05EA\u05D5\u05E0\u05D9\u05DD","\u05E1\u05D8\u05D5\u05D3\u05E0\u05D8\u05D9\u05DD \u05E9\u05DC\u05D0 \u05DC\u05D5\u05DE\u05D3\u05D9\u05DD \u05D1\u05E9\u05E0\u05EA \u05D4\u05DC\u05D9\u05DE\u05D5\u05D3\u05D9\u05DD");	
			
		if(s!=null) {
		int year= Integer.parseInt(s.substring(0, 4));
		titleAddValue(year);

		String quary2 = "select distinct StudentID, FirstName+' '+LastName FullName, YEAR(GETDATE())-YEAR(DateOfBirth) Age\r\n" + 
				"from StudentInCourse join Person on StudentID=ID\r\n" + 
				"where StudentID not in ( select StudentID from StudentInCourse where SchoolYear=? )";
		/*Sql*/
		List<String []> list2 = preparedstatementListForTable (connection, quary2, year, null, 3);
		createTable(list2, "Student ID", "Full Name", "Age", 50, 70, 100);
		}
		else resetAllButtonsBackground();
	
		/*Close Sql*/
		connection.close();	
	} catch (SQLException e) {e.printStackTrace();}}
	
	
	//10
	public static void studentsNestSemester() {try {
		setCheckedButton(button_9);
		lblTitle.setText(lblTitle.getText()+" "+"\u05E2\u05DD \u05D0\u05D5\u05EA\u05D5 \u05DE\u05E1\u05E4\u05E8 \u05E7\u05D5\u05E8\u05E1\u05D9\u05DD \u05DB\u05DE\u05D5 \u05D1\u05E7\u05D5\u05D3\u05DD");
		
		String quary1= "select StudentID, CourseCode, SchoolYear, CASE SemesterName WHEN 'Winter' THEN 0 WHEN 'Spring' THEN 1 WHEN 'Summer' THEN 2 END Semester into #tempCourseBySemesterNumbering from StudentInCourse\r\n" + 
				"select distinct CASE Semester WHEN 0 THEN 'Winter' WHEN 1 THEN 'Spring' WHEN 2 THEN 'Summer' END, I.SchoolYear , Semester from StudentInCourse SIC join #tempCourseBySemesterNumbering I on SIC.CourseCode=I.CourseCode  order by I.SchoolYear, Semester"; 
		
		/*Sql*/
		Connection connection = DriverManager.getConnection(connectUrl);		
		List<Object> list1=statmentForList(connection, quary1);	
		String s = possibilitiesChoose(list1,"\u05D1\u05D7\u05E8 \u05E9\u05E0\u05D4 \u05D5\u05E1\u05DE\u05E1\u05D8\u05E8 \u05DE\u05EA\u05D5\u05DA \u05DB\u05DC \u05DE\u05D4 \u05E9\u05DE\u05D5\u05E4\u05D9\u05E2 \u05D1\u05DE\u05E1\u05D3 \u05D4\u05E0\u05EA\u05D5\u05E0\u05D9\u05DD","\u05E1\u05D8\u05D5\u05D3\u05E0\u05D8\u05D9\u05DD \u05D1\u05E1\u05DE' \u05D4\u05E2\u05D5\u05E7\u05D1 \u05E2\u05DD \u05D0\u05D5\u05EA\u05D5 \u05DE\u05E1' \u05E7\u05D5\u05E8\u05E1\u05D9\u05DD");	
			
		if(s!=null) {
		int year = Integer.parseInt(s.substring(s.length()-4, s.length()));
		String semesterName = s.substring(0, s.length()-5);
		
		int semester=-1;
		String semesterNameHebrow="";
	    switch (semesterName) {
	        case "Winter":  semester = 0;semesterNameHebrow="\u05D7\u05D5\u05E8\u05E3";break;
	        case "Spring":  semester = 1;semesterNameHebrow="\u05D0\u05D1\u05D9\u05D1";break;
	        case "Summer":  semester = 2;semesterNameHebrow="\u05E7\u05D9\u05E5";break;
	        }
	    
	    titleAddValue(semesterNameHebrow+" "+year);
        
		String quary2 =  "declare @Semester int, @Year int; set @Semester=?; set @Year=?; \r\n" + 
				"select distinct	StudentID,  FirstName+' '+LastName FullName, CASE Semester WHEN 0 THEN 'Winter' WHEN 1 THEN 'Spring' WHEN 2 THEN 'Summer' END +' '+ CONVERT(varchar(4),SchoolYear) SemesterName from #tempCourseBySemesterNumbering I join Person on StudentID=ID\r\n" + 
				"where Semester=(@Semester +1)%3 and SchoolYear= @Year + (@Semester +1)/3 and StudentID in (\r\n" + 
				"			select 	StudentID\r\n" + 
				"				from #tempCourseBySemesterNumbering I1\r\n" + 
				"				where Semester=(@Semester +1)%3 and SchoolYear= @Year + (@Semester +1)/3\r\n" + 
				"				group by StudentID\r\n" + 
				"				HAVING COUNT(CourseCode) <=\r\n" + 
				"						(select COUNT(CourseCode) CNT\r\n" + 
				"						from #tempCourseBySemesterNumbering I\r\n" + 
				"						where Semester=@Semester and SchoolYear= @Year AND StudentID=I1.StudentID\r\n" + 
				"						group by StudentID)\r\n" + 
				"			)\r\n" + 
				"order by StudentID\r\n" + 
				"drop table #tempCourseBySemesterNumbering";
		/*Sql*/
		List<String []> list2 = preparedstatementListForTable (connection, quary2, semester, year, 3);
		createTable(list2, "Student ID", "Full Name", 50, 70);
		}
		else {
			String quary2 = "drop table #tempCourseBySemesterNumbering";
			CallableStatement callablestatement = connection.prepareCall(quary2);
			callablestatement.executeUpdate();
			callablestatement.close();
			resetAllButtonsBackground();
		}
		
		/*Close Sql*/
		connection.close();	
	} catch (SQLException e) {e.printStackTrace();}}
	
	
	
	

	
		// list array[] {1,2,3} from basic statment FOR TABLE
		public static List<String []> statmentForTable(Connection connection, String quary) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultset = statement.executeQuery(quary);
		
		List<String []> list = new ArrayList<>();
		while (resultset.next()) list.add(new String[] {resultset.getObject(1).toString(),resultset.getObject(2).toString(),resultset.getObject(3).toString()});
		
		/*Close Sql*/
		resultset.close();
		statement.close();
		
		return list;
		}
	

		//  list from basic statment FOR CHOOSEN LIST
		public static List<Object> statmentForList(Connection connection, String quary) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultset = statement.executeQuery(quary);
		
		List<Object> list = new ArrayList<>();
		while (resultset.next()) list.add(String.format("%s %s",resultset.getObject(1),resultset.getObject(2)));
		
		/*Close Sql*/
		resultset.close();
		statement.close();
		
		return list;
		}
	
	
		//CHOOSEN LIST SET
		public static String possibilitiesChoose(List<Object> list, String Text, String Title) {
			Object[] possibilities= new Object[list.size()+(list.size()>=20 ? 1 : 20-list.size())];
		    int i=0;
			for(Object o:list) {possibilities[i]=o;i++;}
			return (String) JOptionPane.showInputDialog(contentPane, Text+"\n", Title, JOptionPane.PLAIN_MESSAGE, null,  possibilities, null);
		}
	
	
		

		
		
		public static List<String []> preparedstatementListForTable (Connection connection, String quary, Object value1, Object value2, int tableColumnsOutput) throws SQLException{
			PreparedStatement preparedstatement = connection.prepareStatement(quary);
			if(value1 instanceof String) preparedstatement.setString(1,(String) value1);
			if(value1 instanceof Integer) preparedstatement.setInt(1,(int) value1);
			if(value2!=null&&value2 instanceof String) preparedstatement.setString(2,(String) value2);
			if(value2!=null&&value2 instanceof Integer) preparedstatement.setInt(2,(int) value2);
	
			ResultSet resultset = preparedstatement.executeQuery();
			
			List<String []> list = new ArrayList<>();
			if(tableColumnsOutput==6)
				while(resultset.next()) {
							list.add(new String[] {
							(resultset.getObject(1)!=null ? resultset.getObject(1).toString():"-no data-"),
							(resultset.getObject(2)!=null ?resultset.getObject(2).toString():"-no data-"), 
							resultset.getObject(3).toString(), resultset.getObject(4).toString(),
							resultset.getObject(5).toString(),
							resultset.getObject(6).toString()});
				}
			
			else 
				while(resultset.next()) {
							list.add(new String[] {
									resultset.getObject(1).toString(),
									resultset.getObject(2).toString(),
									resultset.getObject(3).toString()});
				}
			
			/*Close Sql*/
			resultset.close();
			preparedstatement.close();
			
			return list;
		}
		
		
		
		
		
		//Table Areas Set
		// 2x Areas table:
		public static void createTable(List<String []> list, String culName1, String culName2, int culWidth1, int culWidth2) {
			createTable(list, culName1, culName2, null, null, null, null, culWidth1, culWidth2, 0, 0, 0, 0);
		}
		// 3x Areas table:
		public static void createTable(List<String []> list, String culName1, String culName2, String culName3, int culWidth1, int culWidth2, int culWidth3) {
			createTable(list, culName1, culName2, culName3, null, null, null, culWidth1, culWidth2, culWidth3, 0, 0, 0);
		}
		// 6x Areas table:
		public static void createTable(List<String []> list, String culName1, String culName2, String culName3, String culName4, String culName5, String culName6, int culWidth1, int culWidth2, int culWidth3, int culWidth4, int culWidth5, int culWidth6) {
			boolean moreThan3=(culName4!=null&&culName5!=null&&culName6!=null);
			boolean moreThan2= (culName3!=null);
			Object[][] possibilities= new Object[list.size()][(moreThan3?7:4)];
		    int i=0;
			for(Object[] o:list) {
				possibilities[i][0]=i+1;
				possibilities[i][1]=o[0].toString();
				possibilities[i][2]=o[1].toString();
				if(moreThan2) possibilities[i][3]=o[2].toString();
				if(moreThan3) {
					possibilities[i][4]=o[3].toString();
					possibilities[i][5]=o[4].toString();
					possibilities[i][6]=o[5].toString();
				}
			i++;
			}
			
			model = new DefaultTableModel();
			String[] culumsNames=new String[] {""};
			if(moreThan3)  culumsNames = new String[] {"", culName1, culName2, culName3, culName4, culName5, culName6};
			else if(!moreThan2) culumsNames = new String[] {"", culName1, culName2};
			else culumsNames = new String[] {"", culName1, culName2, culName3};
			
			model.setDataVector(possibilities, culumsNames);
			
			table = new JTable();
			table.setModel(model);
			table.getColumnModel().getColumn(0).setPreferredWidth(5);//
			table.getColumnModel().getColumn(1).setPreferredWidth(culWidth1);
			table.getColumnModel().getColumn(2).setPreferredWidth(culWidth2);
			if(moreThan2) table.getColumnModel().getColumn(3).setPreferredWidth(culWidth3);
			if(moreThan3) {
				table.getColumnModel().getColumn(4).setPreferredWidth(culWidth4);
				table.getColumnModel().getColumn(5).setPreferredWidth(culWidth5);
				table.getColumnModel().getColumn(6).setPreferredWidth(culWidth6);
			}
			scrollPane.setViewportView(table);
		}
			
		
}

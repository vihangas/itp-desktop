package ui.finance.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import ui.components.KTab;
import utils.common.database.Database;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;

public class CreateExpenses extends KTab {
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTable table;
	
	Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateExpenses frame = new CreateExpenses();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
public void tableLoad(){
	    
        try{
           
            String sql = "SELECT * from Expenses";
          
            
            PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
                
            
            table.setModel(Database.resultSetToTableModel(rs));
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }
	
	
	
	

	/**
	 * Create the frame.
	 */
	public CreateExpenses() {
		super("Create Expenses");
		
		t1 = new JTextField();
		t1.setBounds(255, 98, 183, 32);
		getContentPane().add(t1);
		t1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Expense Id");
		lblNewLabel.setBounds(78, 107, 97, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Description ");
		lblNewLabel_1.setBounds(78, 188, 97, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(78, 278, 69, 14);
		getContentPane().add(lblDate);
		
		JLabel lblNewLabel_2 = new JLabel("NetAmount");
		lblNewLabel_2.setBounds(78, 356, 97, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Type");
		lblNewLabel_3.setBounds(78, 440, 69, 14);
		getContentPane().add(lblNewLabel_3);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(255, 179, 183, 32);
		getContentPane().add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(255, 269, 183, 32);
		getContentPane().add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(255, 347, 183, 32);
		getContentPane().add(t4);
		
		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(255, 431, 183, 32);
		getContentPane().add(t5);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String expensId = t1.getText();
				String dscrp = t2.getText();
				String date = t3.getText();
				String NetExpenses = t4.getText();
				String Types = t5.getText();
				String empid = t6.getText();
				
				
				try {
					String sql = "INSERT INTO Expenses(ExpensesId,Description,Date,NetExpenses,Type,EmployeeId) Values ('"+expensId+"','"+dscrp+"','"+date+"','"+NetExpenses+"','"+Types+"','"+empid+"')";
				
					ps = con.prepareStatement(sql);
					ps.execute();
					
					
					tableLoad();
				
				}catch(Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(711, 515, 117, 32);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Create Expenses");
		lblNewLabel_4.setBounds(43, 33, 117, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Employee Id");
		lblNewLabel_5.setBounds(78, 524, 82, 14);
		getContentPane().add(lblNewLabel_5);
		
		t6 = new JTextField();
		t6.setBounds(255, 515, 183, 32);
		getContentPane().add(t6);
		t6.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(461, 106, 509, 277);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		

	}
}

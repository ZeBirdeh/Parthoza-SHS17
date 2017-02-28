import java.awt.*;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;

public class CreateAssignment extends JFrame{
	private JTextField title;
	private JTextField description;
	private JTextField school;
	private JComboBox<String> dueMonth;
	private JComboBox dueDate;
	private JButton submit;
	
	public CreateAssignment(){
		super("Display");
		setBackground(Color.WHITE);
		
		title = new JTextField("");
	    title.setFont(new Font("Serif", Font.PLAIN, 14));
	    
	    description = new JTextField("");
	    description.setFont(new Font("Serif", Font.PLAIN, 14));
	    
	    school = new JTextField("");
	    school.setFont(new Font("Serif", Font.PLAIN, 14));
	    
	    dueMonth = new JComboBox<String>(new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"});
	    dueMonth.setFont(new Font("Helvetica", Font.PLAIN, 14));
	    add(dueMonth);
	    
	    submit = new JButton("Toggle Assignment");
	    submit.setFont(new Font("Serif", Font.PLAIN, 14));
	    submit.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{

	    	}
	    });
	}
	
	public static void main(String[] args){
		CreateAssignment window = new CreateAssignment();
		window.setBounds(50, 50, 520, 310);
	    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    //window.setResizable(false);
	    window.setVisible(true);
	}
	
}

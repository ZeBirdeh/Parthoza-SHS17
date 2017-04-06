import java.awt.*;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;

public class CreateAssignment extends JFrame{
	private JTextField title;
	private JTextField description;
	private JTextField school;
	private JTextField dueDate;
	private JComboBox<String> dueMonth;
	private JButton submit;
	
	private ReceiveAssignment source;
	
	public CreateAssignment(ReceiveAssignment sourced){
		super("Display");
		source = sourced;
		setBackground(Color.WHITE);
		
		title = new JTextField("");
	    title.setFont(new Font("Serif", Font.PLAIN, 14));
	    
	    description = new JTextField("");
	    description.setFont(new Font("Serif", Font.PLAIN, 14));
	    
	    school = new JTextField("");
	    school.setFont(new Font("Serif", Font.PLAIN, 14));
	    
	    dueDate = new JTextField("");
	    dueDate.setFont(new Font("Serif", Font.PLAIN, 14));
	    
	    dueMonth = new JComboBox<String>(new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"});
	    dueMonth.setFont(new Font("Helvetica", Font.PLAIN, 14));
	    
	    submit = new JButton("Create Assignment");
	    submit.setFont(new Font("Serif", Font.PLAIN, 14));
	    submit.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		boolean canSend = false;
	    		try{
	    			if (Integer.parseInt(dueDate.getText()) <= 31){
	    				canSend = true;
	    			}
	    		} catch (NumberFormatException error) {}
	    		if (dueMonth.getSelectedIndex() > -1) canSend = true;
	    		if (title.getText().length() > 1 && description.getText().length() > 1 && school.getText().length() > 1) canSend = true;
	    		
	    		if (canSend){
	    			returnAssignment(title.getText(),description.getText(),school.getText(), new Date(new Date().getYear(), dueMonth.getSelectedIndex(), Integer.parseInt(dueDate.getText())));
	    		}
	    	}
	    });
	    
	    Container pane = this.getContentPane();
	    GridBagConstraints c = new GridBagConstraints();
	    pane.setLayout(new GridBagLayout());
	    
	    c.gridwidth = 2;c.gridy = 0;c.gridx = 0;c.fill = GridBagConstraints.BOTH;c.weightx = 1;c.weighty = 1;
	    pane.add(title,c);
	    
	    c.gridwidth = 2;c.gridy = 1;c.gridx = 0;c.fill = GridBagConstraints.BOTH;c.weightx = 1;c.insets = new Insets(10,0,0,0);c.weighty = 1;
	    pane.add(description,c);

	    c.gridwidth = 2;c.gridy = 2;c.gridx = 0;c.fill = GridBagConstraints.BOTH;c.weightx = 1;c.insets = new Insets(0,0,0,0);c.weighty = 1;
	    pane.add(school,c);
	    
	    c.gridwidth = 1;c.gridy = 3;c.gridx = 0;c.fill = GridBagConstraints.HORIZONTAL;c.weightx = 0.6;
	    pane.add(dueMonth,c);
	    
	    c.gridwidth = 1;c.gridy = 3;c.gridx = 1;c.fill = GridBagConstraints.HORIZONTAL;c.weightx = 0.1;
	    pane.add(dueDate,c);
	    
	    c.gridwidth = 2;c.gridy = 4;c.gridx = 0;c.fill = GridBagConstraints.BOTH;c.weightx = 1;
	    pane.add(submit,c);
	}
	
	public void returnAssignment(String a, String b, String c, Date d){
		source.receiveAssignment(new Assignment(a, b, c, d, 5));
	}
	
	public static void main(String[] args){
		DisplayScreen window = new DisplayScreen();
		window.setBounds(50, 50, 520, 310);
	    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    //window.setResizable(false);
	    window.setVisible(true);
	    
		Assignment as = new Assignment("Math HW","Calc Worksheet","PHS",new Date(),3);
		window.am = new AssignmentMenu();
		window.am.addAssignment(as);
		//System.out.println(am.dispAssignAsStr());
		Assignment as2 = new Assignment("Eng HW","Write the essay","PHS",new Date(),10);
		window.am.addAssignment(as2);
		
	    window.updateDisp("Your Assignments:\n\n"+window.am.dispAssignAsStr());
	    
		CreateAssignment window2 = new CreateAssignment(window);
		window2.setBounds(50, 50, 520, 310);
	    window2.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    //window.setResizable(false);
	    window2.setVisible(true);
	}
	
}

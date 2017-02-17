import java.awt.*;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;

public class DisplayScreen extends JFrame implements ActionListener{
	private JTextArea banner;
	private JTextField toggle;
	private JButton addbutton;
	private JTextField assignname;
	private JButton button;
	private static AssignmentMenu am;
	
	public DisplayScreen(){
		super("Display");
		
		setBackground(Color.WHITE);
		banner = new JTextArea("");
		banner.setEditable(false);
	    banner.setFont(new Font("Serif", Font.BOLD, 14));
	    
		assignname = new JTextField("");
		assignname.setFont(new Font("Serif", Font.PLAIN, 14));
	    
	    addbutton = new JButton("Add Assignment");
	    addbutton.setFont(new Font("Serif", Font.PLAIN, 14));
	    addbutton.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		//TODO Remove some of this useless syso comments
	    		if (!toggle.getText().isEmpty()){
	    			Assignment a = am.getAssignment(toggle.getText());
	    			if (a != null){
	    				a.toggleCompletion();
	    				updateDisp("Your Assignments:\n\n"+am.dispAssignAsStr());
	    			}
	    		}
	    	}
	    });
		
	    toggle = new JTextField("");
	    toggle.setFont(new Font("Serif", Font.PLAIN, 14));
	    
	    button = new JButton("Toggle Assignment");
	    button.setFont(new Font("Serif", Font.PLAIN, 14));
	    button.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		//TODO Remove some of this useless syso comments
	    		if (!toggle.getText().isEmpty()){
	    			Assignment a = am.getAssignment(toggle.getText());
	    			if (a != null){
	    				a.toggleCompletion();
	    				updateDisp("Your Assignments:\n\n"+am.dispAssignAsStr());
	    			}
	    		}
	    	}
	    });
	    
	    Container pane = this.getContentPane();
	    GridBagConstraints c = new GridBagConstraints();
	    pane.setLayout(new GridBagLayout());
	    
	    c.gridwidth = 2;c.gridy = 0;c.gridx = 0;c.fill = GridBagConstraints.BOTH;c.weightx = 1;c.weighty = 1;
	    pane.add(banner,c);
	    
	    c.gridwidth = 1;c.gridy = 1;c.gridx = 0;c.fill = GridBagConstraints.HORIZONTAL;c.weightx = 0.9;c.insets = new Insets(10,0,0,0);c.weighty = 0;
	    pane.add(toggle,c);

	    c.gridwidth = 1;c.gridy = 1;c.gridx = 1;c.fill = GridBagConstraints.HORIZONTAL;c.weightx = 0.1;
	    pane.add(button,c);
	}
	
	public void updateDisp(String n){
		int ratio = (510*am.getRemainingDiff())/am.getTotalDiff();
		banner.setText(n);
		banner.setBackground(new Color(ratio<255?ratio:255,ratio>255?510-ratio:255,0));
	}
	
	public void actionPerformed(ActionEvent arg0) {

	}

	public static void main(String[] args){
		DisplayScreen window = new DisplayScreen();
		window.setBounds(50, 50, 520, 310);
	    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    //window.setResizable(false);
	    window.setVisible(true);
	    
		Assignment as = new Assignment("Math HW","Calc Worksheet","PHS",new Date(),3);
		am = new AssignmentMenu();
		am.addAssignment(as);
		//System.out.println(am.dispAssignAsStr());
		Assignment as2 = new Assignment("Eng HW","Write the essay","PHS",new Date(),10);
		am.addAssignment(as2);
		
	    window.updateDisp("Your Assignments:\n\n"+am.dispAssignAsStr());
	}
}

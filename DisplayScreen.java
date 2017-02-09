import java.awt.*;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;

public class DisplayScreen extends JFrame implements ActionListener{
	private JTextField banner;
	public DisplayScreen(){
		super("Display");
		
		setBackground(Color.WHITE);
		banner = new JTextField("ABCD\n\nABCD");
		banner.setEditable(false);
	    banner.setFont(new Font("Serif", Font.BOLD, 14));
	    banner.setHorizontalAlignment(JTextField.CENTER);
	    add(banner);
	}
	
	public void setText(String n){
		banner.setText(n);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
	}

	public static void main(String[] args){
		DisplayScreen window = new DisplayScreen();
		window.setBounds(50, 50, 520, 310);
	    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    window.setResizable(false);
	    window.setVisible(true);
	    
		Assignment as = new Assignment("Math HW","Calc Worksheet","PHS",new Date());
		AssignmentMenu am = new AssignmentMenu();
		am.addAssignment(as);
		//System.out.println(am.dispAssignAsStr());
		Assignment as2 = new Assignment("Eng HW","Write the essay","PHS",new Date());
		am.addAssignment(as2);
		
	    window.setText(am.dispAssignAsStr());
	}
}

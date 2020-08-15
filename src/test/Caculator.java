package test;
import javax.swing.*;
public class Caculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		double num1=0, num2=0, answer=0;
		String prompt="(choose an opption\n"+
		               "1.Assign a value  to num1\n"+
				        "2.Assign a value to num2\n"+
		                "3.Display answer\n"+
				        "4. add num1 and num2\n"+
		                "0.Exit";
		int choice = Integer.parseInt(JOptionPane.showInputDialog(prompt));
		while(choice!=0) {
			    if(choice==1) {
			    	num1=Double.parseDouble(JOptionPane.showInputDialog("Enter num1 value"));
			    			JOptionPane.showMessageDialog(null,num1)	;
			    }
			    else if(choice==2) {
			    	num2=Double.parseDouble(JOptionPane.showInputDialog("Enter num2 value"));
			    }
			    else if(choice==3) {
			    	JOptionPane.showMessageDialog(null,answer);
			    	
			    }
			    else if(choice==4) {
			    	answer=num1+num2;
			    	JOptionPane.showMessageDialog(null,"num1 and num2 added");
			    	
			    }
			    choice = Integer.parseInt(JOptionPane.showInputDialog(prompt)); 
		}
		
	}

}

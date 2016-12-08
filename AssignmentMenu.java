import java.util.Date;


public class AssignmentMenu {
	//Fields
	private int aNum;
	private Assignment[] aList;
	
	//Constructors
	public AssignmentMenu(){
		aNum = 0;
		aList = new Assignment[0];
	}
	
	//Methods
	public void addAssignment(Assignment a){
		Assignment[] tempList = new Assignment[aNum+1];
		for (int i=0;i<aList.length;i++){
			tempList[i] = aList[i];
		}
		tempList[aNum] = a;
		aList = tempList;
		aNum++;
	}
	public String dispAssignAsStr(){
		String outstr = "";
		for (int i=0;i<aList.length;i++){
			outstr += aList[i].toString()+"\n\n";
		}
		return outstr;
	}
	
	//Application
	public static void main(String[] args){
		Assignment as = new Assignment("Math HW","Calc Worksheet","PHS",new Date());
		AssignmentMenu am = new AssignmentMenu();
		am.addAssignment(as);
		//System.out.println(am.dispAssignAsStr());
		Assignment as2 = new Assignment("Eng HW","Write the essay","PHS",new Date());
		am.addAssignment(as2);
		System.out.println(am.dispAssignAsStr());
		System.out.println(as2.getID());
	}
}

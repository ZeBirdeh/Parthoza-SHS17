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
		int totaldiff = 0;
		for (int i=0;i<aList.length;i++){
			if (!aList[i].getCompletion()){
				totaldiff += aList[i].getDiff();
				outstr += aList[i].toString()+"\n\n";
			} else {
				outstr += "DONE - " + aList[i].getName() + "\n\n";
			}
		}
		outstr += (totaldiff > 0)?"Workload: "+totaldiff:"You are all done!";
		return outstr;
	}
	/*
	 * This version of the code leaves all the information from the Assignment (it uses the given toString of Assignment)
	 * The currently used on will only display "DONE" and the title.
	public String dispAssignAsStr(){
		String outstr = "";
		int totaldiff = 0;
		for (int i=0;i<aList.length;i++){
			if (!aList[i].getCompletion()){
				totaldiff += aList[i].getDiff();
			} else {
				outstr += "DONE - ";
			}
			outstr += aList[i].toString()+"\n\n";
		}
		outstr += (totaldiff > 0)?"Workload: "+totaldiff:"You are all done!";
		return outstr;
	}*/
	public void deleteAssignment(Assignment a){
		Assignment[] tempList = new Assignment[aNum-1];
		int c = 0;
		for (int i=0;i<aList.length;i++){
			if (!(a.equals(aList[i]))){
				tempList[c] = aList[i];
				c++;
			}
		}
		aList = tempList;
		aNum--;
	}
	public Assignment[] getAllAssignments(){
		return aList;
	}
	
	//Overloading the find assignment method
	//It will only find the first assignment with those parameters
	public Assignment getAssignment(String name){
		for (int i=0;i<aList.length;i++){
			if (aList[i].getName().equals(name)){
				return aList[i];
			}
		}
		return null;
	}
	public Assignment getAssignment(int id){
		for (int i=0;i<aList.length;i++){
			if (aList[i].getID()==id){
				return aList[i];
			}
		}
		return null;
	}
	public Assignment getAssignment(String name, int id){
		for (int i=0;i<aList.length;i++){
			if ((aList[i].getID()==id) && (aList[i].getName().equals(name))){
				return aList[i];
			}
		}
		return null;
	}
	
	//Find all assignments with this in their name (in development)
	public AssignmentMenu findAllAssignments(String name){
		AssignmentMenu amu = new AssignmentMenu();
		for (int i=0;i<aList.length;i++){
			if (aList[i].getName().equals(name)){
				amu.addAssignment(aList[i]);
			}
		}

		//Part 2
		String[] words = name.split(" ");
		
		
		return amu;
		
	}
	
	//Application
	public static void main(String[] args){
		Assignment as = new Assignment("Math HW","Calc Worksheet","PHS",new Date());
		AssignmentMenu am = new AssignmentMenu();
		am.addAssignment(as);
		//System.out.println(am.dispAssignAsStr());
		Assignment as2 = new Assignment("Eng HW","Write the essay","PHS",new Date());
		am.addAssignment(as2);
		as.setDiff(3);
		as2.setDiff(10);
		System.out.println(am.dispAssignAsStr());
		System.out.println(am.findAllAssignments("HW").dispAssignAsStr());
	}
}

import java.util.Date;

public class Assignment {
	//Fields
	private String name;
	private String desc;
	private String school;
	private Date duedate;
	private boolean complete;
	private int aID;
	private int difficulty;
	private static int assignmentNum = 0;
	
	//Constructors
	public Assignment(String nname, String ndesc, String nschool, Date ndate, int diff){
		name = nname;
		desc = ndesc;
		school = nschool;
		duedate = ndate;
		complete = false;
		assignmentNum++;
		aID = assignmentNum;
		difficulty = diff;
	}
	
	//Methods
	public String getName(){
		return name;
	}
	public String getDesc(){
		return desc;
	}
	public String getSchool(){
		return school;
	}
	@SuppressWarnings("deprecation")
	public int[] getDue(){
		int[] outlst = {duedate.getDay(), duedate.getMonth(), duedate.getYear()+1900};
		return outlst;
	}
	public int getID(){
		return aID;
	}
	public int getDiff(){
		return difficulty;
	}
	public boolean getCompletion(){
		return complete;
	}
	
	public void setDesc(String a){
		desc = a;
	}
	public void setSchool(String a){
		school = a;
	}
	public void toggleCompletion(){
		complete = !complete;
	}
	public void setDiff(int diff){
		difficulty = diff;
	}
	
	//Object Essentials
	public String toString(){
		return name+":\n"+desc+"\nFor "+school+", due "+(duedate.getMonth()+1)+"/"+duedate.getDate();
	}
	public boolean equals(Object obj){
		if (!(obj instanceof Assignment)){
			return false;
		}
		return ((Assignment)obj).name == this.name;
	}
	
	//Application
	public static void main(String[] args){
		Assignment as = new Assignment("a","beee","PHS",new Date(),5);
		System.out.println(as);
	}
}

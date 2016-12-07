import java.util.Date;

public class Assignment {
	//Fields
	String name;
	String desc;
	String school;
	Date duedate;
	
	//Constructors
	public Assignment(String nname, String ndesc, String nschool, Date ndate){
		name = nname;
		desc = ndesc;
		school = nschool;
		duedate = ndate;
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
	
	//Object Essentials
	public String toString(){
		return "Assignment "+name+":\n"+desc+"\nFor "+school+", due "+duedate.getMonth()+"/"+duedate.getDay();
	}
	
	
	
	//Application
	public static void main(String[] args){
		Assignment as = new Assignment("a","beee","PHS",new Date());
		System.out.println(as);
	}
}

package JDBC;

public class Student {
  private int roll;
  private String name;
  private String city;
  
  Student(int roll,String name,String city)
  {
	 this.roll=roll;
	 this.city=city;
	 this.name=name;
  }
  
  public int getRoll()
  {
	 return this.roll; 
  }
  public String getName()
  {
	 return this.name; 
  }
  public String getCity()
  {
	 return this.city; 
  }
  
  public String toString()
  {
	  return "[Roll:"+this.roll+" Name:"+this.name+" City:"+this.city+"]";
  }
}

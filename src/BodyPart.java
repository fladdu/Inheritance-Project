
public abstract class BodyPart{
	private double weight;
	private String location;
	private boolean isEssential;

/*	pre:
	post:
*/
	public void setWeight(double value){
		weight = value;
	}

/*	pre:
	post:
*/
	public void setLocation(String value){
		location = value;
	}

/*	pre:
	post:
*/
	public void setEssential(boolean value){
		isEssential = value;
	}

/*	pre:
	post:
*/
	public double getWeight(){
		return weight;
	}

/*	pre:
	post:
*/
	public String getLocation(){
		return location;
	}

/*	pre:
	post:
*/
	public boolean getEssential(){
		return isEssential;
	}
	public String toString(){
		return null;
	}
}


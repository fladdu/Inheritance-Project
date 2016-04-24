
public abstract class BodyPart{
	private double weight;
	private String location;
	private boolean isEssential;

/*	pre: weight is initialized, value is positive & non-zero
	post: set weight to value
*/
	public void setWeight(double value){
		weight = value;
	}

/*	pre: location is initialized, value is positive & non-zero
	post: set location to value
*/
	public void setLocation(String value){
		location = value;
	}

/*	pre: isEssential is initialized, value is positive & non-zero
	post: set isEssential to value
*/
	public void setEssential(boolean value){
		isEssential = value;
	}

/*	pre: weight is initialized + defined
	post: returns weight
*/
	public double getWeight(){
		return weight;
	}

/*	pre: location is initialized + defined
	post: location is returned
*/
	public String getLocation(){
		return location;
	}

/*	pre: isEssential is initialized + defined
	post: returns isEssential
*/
	public boolean getEssential(){
		return isEssential;
	}
	public String toString(){
		return null;
	}
}


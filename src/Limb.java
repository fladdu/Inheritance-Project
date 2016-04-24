
public abstract class Limb extends BodyPart{
	private double strength; 
	private double length;
	
/*	pre: strength is initialized, value is positive & non-zero
	post: sets strength to value
*/
	public void setStrength(double value){
		strength = value;
	}

/*	pre: length is initialized, value is positive & non-zero
	post: sets length to value
*/
	public void setLength(double value){
		length = value;
	}

/*	pre: strength is initialized + defined
	post: returns strength
*/
	public double getStrenght(){
		return strength;
	}

/*	pre: length is initialized + defined
	post: returns length
*/
	public double getLength(){
		return length;
	}

/*	pre: value is defined
	post: the Limb's function is performed
*/
	public abstract void doFunction(double value);

}

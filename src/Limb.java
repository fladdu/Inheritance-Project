
public abstract class Limb extends BodyPart{
	private double strength; 
	private double length;
	
/*	pre:
	post:
*/
	public void setStrength(double value){
		strength = value;
	}

/*	pre:
	post:
*/
	public void setLength(double value){
		length = value
	}

/*	pre:
	post:
*/
	public double getStrenght(){
		return zstrength
	}

/*	pre:
	post:
*/
	public double getLength(){
		return this.length;
	}

/*	pre:
	post:
*/
	public abstract void doFunction(double value);

}

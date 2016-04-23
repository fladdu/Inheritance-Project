

public abstract class Organ extends BodyPart {
	private String bodySystem;
	
	/*	
	pre:
	post:
    */
	public void setBodySystem(String value){
		bodySystem = value;
	}
	
	/*	
	pre:
	post:
    */
	public String getBodySystem(){
		return bodySystem;
	}

	/*	
	pre:
	post:
    */
	public abstract void doFunction();
	
}



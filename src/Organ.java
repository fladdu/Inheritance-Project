

public abstract class Organ extends BodyPart {
	private String bodySystem;
	
	/*	
	pre: bodysystem is initialized, value is defined
	post: sets bodySystem to value
    */
	public void setBodySystem(String value){
		bodySystem = value;
	}
	
	/*	
	pre: bodySystem is defined
	post: returns bodySystem
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



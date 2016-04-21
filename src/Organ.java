

public abstract class Organ extends BodyPart {
	private String bodySystem;
	
	public void setBodySystem(String value){
		bodySystem = value;
	}
	
	public String getBodySystem(){
		return bodySystem;
	}
	public abstract void doFunction();
	
}



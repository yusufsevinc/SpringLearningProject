package javaKampSpring.northwind.core.utilities.results;

public class Result {
	private boolean success;
	private String message;

	public Result(boolean success) {
		this.success = success;

	}

	public Result(boolean success, String message) {
		//class taki tek paretmeleri constructor
		this(success);
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}
	
	

}

package Exceptions;

public class AssetNotFoundException extends Exception {
	
	public AssetNotFoundException(String message) {
		super(message);
	}

	public AssetNotFoundException() {
		super();
		
	}
}

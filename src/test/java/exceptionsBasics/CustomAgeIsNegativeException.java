package exceptionsBasics;

public class CustomAgeIsNegativeException extends Exception {
	String errorMessage;

	public CustomAgeIsNegativeException(String errorMessage1) {

		this.errorMessage = errorMessage1;
	}

	@Override
	public String toString() {
		return errorMessage;

	}

}

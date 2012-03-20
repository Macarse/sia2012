package exceptions;

public class CorruptFileException extends Exception {

	private static final long serialVersionUID = 1L;

	public CorruptFileException(String string) {
		super(string);
	}

}

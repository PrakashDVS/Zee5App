package exception;
import lombok.ToString;

@ToString(callSuper = true)
public class IdNotFoundException extends Exception {
	public IdNotFoundException(String message) {
		super(message);
	}
}

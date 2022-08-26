package Exceptions;

public class ConnectionException extends Exception {
	public ConnectionException() { super(); }
	public ConnectionException(String reason) { super(reason);	}
}

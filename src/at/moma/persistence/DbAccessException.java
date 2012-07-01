package at.moma.persistence;

public class DbAccessException extends Exception {

	private static final long serialVersionUID = -6589478821263739952L;

	public DbAccessException(){
		super();
	}
	
	public DbAccessException(String msg){
		super(msg);
	}
}

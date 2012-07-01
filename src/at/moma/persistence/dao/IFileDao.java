package at.moma.persistence.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * The IFileDao privides access to the Text Files. The files has to
 * be syntactic and semantic correct MoMa property files. It always returns a
 * syntactic correct file.
 * 
 * @author stefan
 *
 */
public interface IFileDao {

	/**
	 * getValue returns the Value as String to the given key.
	 * 
	 * @param msg
	 * @return String
	 * @throws FileNotFoundException 
	 */
	public String getValue(String key) throws FileNotFoundException;
	
	/**
	 * setValue sets the value for the given key.
	 * 
	 * @param key
	 * @param value
	 * @throws IOException 
	 */
	public void setValue(String key, String value) throws IOException;
}

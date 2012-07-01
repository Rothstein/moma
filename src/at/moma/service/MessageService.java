package at.moma.service;

import java.io.FileNotFoundException;

import at.moma.persistence.dao.FileDao;
import at.moma.persistence.dao.IFileDao;

public class MessageService {

	private static MessageService instance = null;
	private IFileDao fileDao;
	
	public static synchronized MessageService instance(){
		if(instance == null){
			instance = new MessageService();
		}
		return instance;
	}
	
	private MessageService(){
		//TODO: use system independent file seperator
		fileDao = new FileDao("lang" + "/" + SettingsUtil.getLanguage());
	};
	
	/**
	 * Returns the message in the configured language which is associated
	 * with the given id.
	 * 
	 * @param id
	 * @return message
	 * @throws FileNotFoundException
	 */
	public String getMessage(String id) throws FileNotFoundException{
		return fileDao.getValue(id);
	}
}

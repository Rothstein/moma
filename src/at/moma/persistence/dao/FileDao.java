package at.moma.persistence.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * Implenents methods to read and write in property files.
 * 
 * @author stefan
 *
 */
public class FileDao implements IFileDao {

	private static Logger log = Logger.getLogger(FileDao.class);
	private String fileName;
	private Scanner sc;
	private FileWriter writer;
	private File file;
	
	public FileDao(String fileName){
		this.fileName = fileName;
		this.file = new File(fileName);
	}
	
	@Override
	public String getValue(String key) throws FileNotFoundException {
		log.debug("read from file: " + fileName);
		sc = new Scanner(file);
		while(sc.hasNext()){
			if(sc.next().equals(key)){
				return sc.nextLine().trim();
			}else{
				sc.nextLine();
			}
		}
		return null;
	}

	@Override
	public void setValue(String key, String value) throws IOException {
		log.debug("write to file: " + fileName);
		sc = new Scanner(file);
		String writeBack = "";
		String tmpKey;
		while(sc.hasNext()){
			tmpKey = sc.next();
			if(tmpKey.equals(key)){
				writeBack += tmpKey + " " + value + "\n";
				sc.nextLine();
			}else{
				writeBack += tmpKey + sc.nextLine() + "\n";
			}
		}
		writeBack.trim();
		writer = new FileWriter(file);
		writer.write(writeBack);
		writer.flush();
		writer.close();
	}
}

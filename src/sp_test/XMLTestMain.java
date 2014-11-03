package sp_test;

import java.io.File;
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLTestMain {
	public static void main(String[] args) {
		
//		FacultyStructure fs = new FacultyStructure();
//		fs.tempInit();
//		fs.print();
//		saveObject(fs, "C:\\ws\\structure.xml");
//		FacultyStructure fs = (FacultyStructure)loadObject("C:\\ws\\structure.xml", FacultyStructure.class);
//		fs.print();
		
//		Users u = new Users();
//		u.tempInit();
//		u.print();
//		saveObject(u, "C:\\ws\\users.xml");
		
		Curators c = new Curators();
		c.tempInit();
		c.print();
		saveObject(c, "C:\\ws\\curators.xml");
	}
	
	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!œ≈–≈œ»—¿“‹  ¿  ¬  ŒÕ—œ≈ “≈
	private static void saveObject(Object obj, String filePath) {
        try {
            File file = new File(filePath);
            JAXBContext jaxb = JAXBContext.newInstance(obj.getClass());
            Marshaller mar = jaxb.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mar.marshal(obj, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    
	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!œ≈–≈œ»—¿“‹  ¿  ¬  ŒÕ—œ≈ “≈
    private static Object loadObject(String filePath, Class<?> objClass) {
        try {
            File file = new File(filePath);
            JAXBContext jaxb = JAXBContext.newInstance(objClass);
            Unmarshaller unmar = jaxb.createUnmarshaller();
            Object user = unmar.unmarshal(file);
            return user;
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

}


import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import pojo.Individuals;

public class GetXML {

    public static Individuals deserialize() throws JAXBException {
        

            JAXBContext context = JAXBContext.newInstance(Individuals.class);
            Unmarshaller uMarshaller = context.createUnmarshaller();
            Individuals individuals = (Individuals) uMarshaller.unmarshal(new File("C:\\Users\\yourUser\\any_directory\\test.xml"));
            return individuals;
    }
    
    public static void main(String[] args) throws JAXBException {
        System.out.println("Name: " + deserialize().getName());
        System.out.println("CPF: " + deserialize().getCpf());
        System.out.println("CEP: " + deserialize().getAddress());
    }
}

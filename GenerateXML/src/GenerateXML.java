
import pojo.Individuals;
import pojo.Address;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class GenerateXML {

    public static void main(String[] args) throws JAXBException {

        // Creates the JAXB Context passing Class with Annotation @XmlRootElement
        JAXBContext context = JAXBContext.newInstance(Individuals.class);

        // Serialize a Java object into XML
        Marshaller marshaller = context.createMarshaller();

        // Instantiating the object
        Address address = new Address();
        address.setCep("58100-000");

        Individuals individuals = new Individuals();
        individuals.setCpf("12345678910");
        individuals.setName("Michael Jackson");
        individuals.setAddress(address.getCep());

        // Generates the XML file with information from the object
        marshaller.marshal(individuals, new File("C:\\Users\\yourUser\\any_directory\\test.xml"));
        System.out.println("Generated file");
    }
}

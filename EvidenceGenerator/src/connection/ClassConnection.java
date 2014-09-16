package connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author caitano junior
 */
public class ClassConnection {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvidenceGeneratorPU");
    private EntityManager em = null;// creating an entity manager
    private EntityTransaction transaction = null;//creating an entity transaction 
    
    
    //method that returns an entity management 
    public EntityManager returnEntityManager(){
        if(em == null){
            em = emf.createEntityManager();
        }
        return em;
    }
    
    //method that returns a transaction
    public EntityTransaction returnTransaction(){
        if(transaction == null){
            transaction = returnEntityManager().getTransaction();
        }
        return transaction;
    }
}

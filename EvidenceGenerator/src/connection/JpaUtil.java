package connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author caitano junior
 */
public class JpaUtil {
    
    private static final String PERSISTENCE_UNIT = "EvidenceGeneratorPU";
    private static EntityManagerFactory emf;
    private static EntityManager em = null;
    
    //method that returns an entity management 
    public static EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }

        if (em == null) {
            em = emf.createEntityManager();
        }
        return em;
    }
    
//    
//    //method that returns an entity management 
//    public EntityManager getEntityManager(){
//        if(em == null){
//            em = emf.createEntityManager();
//        }
//        return em;
//    }
    
//    //method that returns a transaction
//    public EntityTransaction returnTransaction(){
//        if(transaction == null){
//            transaction = returnEntityManager().getTransaction();
//        }
//        return transaction;
//    }
}

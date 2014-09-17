package controller;

import javax.persistence.EntityManager;
import dao.JpaUtil;
import model.Alternative;
import model.Question;

/**
 *
 * @author caitano junior
 */
public class EvidenceGenerator {

    public static void main(String[] args) {
        Question question1 = new Question();
        question1.setEnunciation("What is the origin of the universe?");
        question1.addAlternativesWrong(new Alternative("God created the heaven and the earth"));
        question1.addAlternativesWrong(new Alternative("There was an explosion, the big bang"));
        question1.addAlternativesWrong(new Alternative("Everything happened by chance"));
        question1.setCorrectAlternative(new Alternative("All previous"));

        Question question2 = new Question();
        question2.setEnunciation("How many planets have the via lactea??");
        question2.addAlternativesWrong(new Alternative("one"));
        question2.addAlternativesWrong(new Alternative("five"));
        question2.addAlternativesWrong(new Alternative("six"));
        question2.setCorrectAlternative(new Alternative("eight"));

        EntityManager entityManager = JpaUtil.getEntityManager();

        try {

            entityManager.getTransaction().begin();
            entityManager.persist(question1);
            entityManager.persist(question2);
            entityManager.getTransaction().commit();
            entityManager.close();
            
            System.out.println("Ok! Successfully inserted data  in the database.");
        } catch (Exception e) {
            System.err.println("Erro >>> " + e.getMessage());
        }
    }

}

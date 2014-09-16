package evidencegenerator;

import connection.ClassConnection;

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

        ClassConnection conn = new ClassConnection();

        try {

            conn.returnTransaction().begin();
            conn.returnEntityManager().persist(question1);
            conn.returnEntityManager().persist(question2);
            conn.returnTransaction().commit();
            conn.returnEntityManager().close();
            
            System.out.println("Ok! Successfully inserted data  in the database.");
        } catch (Exception e) {
            System.err.println("Erro >>> " + e.getMessage());
        }
    }

}
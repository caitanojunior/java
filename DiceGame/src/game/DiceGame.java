package game;

import java.util.Random;
import javax.swing.JOptionPane;

public class DiceGame {

    public static void main(String[] args) {

        Random n = new Random();
        int dice = n.nextInt(6) + 1;

        String str = JOptionPane.showInputDialog("What's your guess?");
        int guess = Integer.parseInt(str);

        if (guess > 6) {
            JOptionPane.showMessageDialog(null, "Invalid guess, try a number 1 a 6.");
        } else if (guess == dice) {
            JOptionPane.showMessageDialog(null, "Value of data: " + dice + "\n" + "Your guess: " + guess + "\n" + "Parabéns você acertou!");
        } else {
            JOptionPane.showMessageDialog(null, "Value of data: " + dice + "\n" + "Your guess: " + guess + "\n" + "Too bad you missed. :(");
        }
    }

}

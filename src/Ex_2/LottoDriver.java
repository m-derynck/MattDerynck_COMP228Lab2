package Ex_2;

import javax.swing.*;

public class LottoDriver {

    private static int lottoChances = 5;

    public static void main(String[] args) {
        Lotto lottoGame = new Lotto();
        String welcomeMsg = String.format("Welcome to the Lottery game.%nEnter a number between 3 and 27.");
        int userInputNumber = 0;
        do {
            try {
                userInputNumber = Integer.valueOf(JOptionPane.showInputDialog(null, welcomeMsg));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Bad input value. Try again.", "Invalid number.", JOptionPane.ERROR_MESSAGE);
            }
        }
        while (!validNum(userInputNumber));

        for (int i = 0; i < lottoChances; i++) {
            if (i > 0) {
                lottoGame.Roll();
            }
            int rollSum = lottoGame.getSum();
            if (userInputNumber == rollSum) {
                //User wins!
                String winningMsg = String.format("Congratulations! You chose number: %d and the winning number was %d%nYou win no money here but that was fun wasn't it?", userInputNumber, rollSum);
                JOptionPane.showMessageDialog(null, winningMsg, "You Win!", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            else{
                String reRollMsg = String.format("Better luck next time.%nLottery number was: %d%nRoll again!",rollSum);
                JOptionPane.showMessageDialog(null,reRollMsg,"Roll again!",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        //User loses.
        String losingMsg = String.format("Yikes, looks like you lose! You chose number: %d and the winning number was %d%nYou lost no money here but that was fun wasn't it?", userInputNumber, lottoGame.getSum());
        JOptionPane.showMessageDialog(null, losingMsg, "You Lost!", JOptionPane.INFORMATION_MESSAGE);
    }

    //checks if its a valid lottery number
    private static boolean validNum(int number) {
        if (number >= 3 && number <= 27) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Number must be between 3 and 27.", "Invalid number.", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
}

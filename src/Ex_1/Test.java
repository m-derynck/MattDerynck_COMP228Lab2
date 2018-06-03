package Ex_1;

import javax.swing.*;
import java.util.Random;

public class Test {
    //String constants for the message responses.
    private final String[] CorrectResponseMessages = new String[]{
            "Excellent!",
            "Good!",
            "Keep up the good work!",
            "Nice Work!"
    };
    private final String[] WrongResponseMessages = new String[]{
            "No. Better luck next time.",
            "Wrong. Try once more",
            "Nope. Don't Give up!",
            "No. Keep trying!"
    };

    private Random testRandomizer = new Random();
    private Question[] questions;

    //Constructor with prebuilt questions.
    public Test() {
        generateQuestions();
    }

    //Constructor for passing in a set of custom questions to use.
    public Test(Question[] customQuestions) {
        this.questions = customQuestions;
    }

    public void startTest() {
        Object[] options = {"Start", "Exit"};
        //Display initial start test window, simply begin test or exit program options.
        int selection = JOptionPane.showOptionDialog(null, "Welcome to the Java test. Select Start to begin the test.",
                "Java Test", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
        //Start Test option selected
        if (selection == JOptionPane.YES_OPTION) {
            displayQuestion(questions[0]);
        } else{//Exit the test.
            return;
        }
    }

    //Creates a predefined set of questions.
    private void generateQuestions() {
        questions = new Question[5];
        questions[0] = new Question("What makes you poop?",
                new String[]{"Blah", "Blah","baked beans","Cornbread"},
                0);
        questions[1] = new Question("What makes you poop?",
                new String[]{"Blah", "Blah"},
                1);
        questions[2] = new Question("What makes you poop?",
                new String[]{"Blah", "Blah"},
                1);
        questions[3] = new Question("What makes you poop?",
                new String[]{"Blah", "Blah"},
                0);
        questions[4] = new Question("What makes you poop?",
                new String[]{"Blah", "Blah"},
                1);
    }


    public String generateMessage(boolean correctAnswer) {
        if (correctAnswer) {
            return CorrectResponseMessages[testRandomizer.nextInt(CorrectResponseMessages.length)];
        } else {
            return WrongResponseMessages[testRandomizer.nextInt(WrongResponseMessages.length)];
        }
    }

    public void getUserInput() {

    }

    //Displays the question and the 4 options for the possible answer.
    private void displayQuestion(Question question){
        JPanel panel = new JPanel();
        ButtonGroup optionGroup = new ButtonGroup();
        panel.add(new JLabel(question.getActualQuestion()));
        for(String option : question.getOptions()){
            JRadioButton optionRadio = new JRadioButton(option);
            optionGroup.add(optionRadio);
            panel.add(optionRadio);
        }
        JOptionPane.showMessageDialog(null,panel);
    }
}

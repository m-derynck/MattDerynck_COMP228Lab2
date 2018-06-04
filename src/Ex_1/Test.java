package Ex_1;

import javax.swing.*;
import java.awt.*;
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

    //Starts the test and prompts the user with a set of questions then displays the results.
    public void startTest() {
        Object[] options = {"Start", "Exit"};
        //Display initial start test window, simply begin test or exit program options.
        int selection = JOptionPane.showOptionDialog(null, "Welcome to the Java test. Select Start to begin the test.",
                "Java Test", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
        //Start Test option selected
        if (selection == JOptionPane.YES_OPTION) {
            int correctAnswers = 0;
            int wrongAnswers = 0;
            for (int i = 0; i < questions.length; i++) {
                displayQuestion(questions[i]);
                switch (questions[i].getQuestionState()) {
                    case CORRECT: {
                        correctAnswers++;
                        break;
                    }
                    case WRONG: {
                        wrongAnswers++;
                        break;
                    }
                }
            }
            double finalPercent = ((double)correctAnswers/(double)questions.length) * 100.00;
            String finalResults = String.format("Correct Answers: %d%nWrong Answers: %d%nFinal Percent: %.2f%%",
                    correctAnswers,
                    wrongAnswers,
                    finalPercent );
            JOptionPane.showConfirmDialog(null,finalResults,"Final Results",JOptionPane.DEFAULT_OPTION);
        } else {//Exit the test.
            System.exit(1);
        }
    }


    //Creates a predefined set of questions.
    private void generateQuestions() {
        questions = new Question[5];
        questions[0] = new Question("Which of the following is not a primitive type?",
                new String[]{"int", "boolean", "String", "short"},
                2);
        questions[1] = new Question("Which of the following constructors properly declares a static method that is public and return type void?",
                new String[]{"public void static Foo()", "void static Foo()","public Foo() static void","public static void Foo()"},
                3);
        questions[2] = new Question("If your application builds but then crashes while executing, this is an example of a(n) _____ error.",
                new String[]{"Logic", "Runtime","Compile","Syntax"},
                1);
        questions[3] = new Question("Which of the following is not a proper access modifier?",
                new String[]{"public", "private","secret","protected"},
                2);
        questions[4] = new Question("Which of the following properly creates an object of class GameObject?",
                new String[]{"obj = new GameObject();", "GameObject obj = new GameObject();","new GameObject obj();","GameObject obj = GameObject();"},
                1);
    }

    //Picks a random response to send to the user from the constants defined above.
    public String generateMessage(boolean correctAnswer) {
        if (correctAnswer) {
            return CorrectResponseMessages[testRandomizer.nextInt(CorrectResponseMessages.length)];
        } else {
            return WrongResponseMessages[testRandomizer.nextInt(WrongResponseMessages.length)];
        }
    }

    //Displays the question and the 4 options for the possible answer.
    private void displayQuestion(Question question) {
        JPanel panel = new JPanel(new GridLayout(5, 0));
        ButtonGroup optionGroup = new ButtonGroup();
        panel.add(new JLabel(question.getActualQuestion()));
        for (int i = 0; i < question.getOptions().length; i++) {
            JRadioButton optionRadio = new JRadioButton(question.getOptions()[i]);
            optionRadio.setActionCommand(String.valueOf(i));
            optionGroup.add(optionRadio);
            panel.add(optionRadio);
        }

        Object[] options = {"Submit", "Exit"};
        //Display the submit and exit buttons to confirm the chosen answer by the user.
        int selection = JOptionPane.showOptionDialog(null, panel,
                "Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //Submit answer selected
        if (selection == JOptionPane.YES_OPTION) {
            if (optionGroup.getSelection() != null) {
                //Check the submitted answer by getting the selected index of the option radio button group.
                JOptionPane.showConfirmDialog(null,
                        generateMessage(question.checkAnswer(Integer.valueOf(optionGroup.getSelection().getActionCommand()))),
                        null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
            } else {
                //Please choose an answer before submitting.
                JOptionPane.showConfirmDialog(null,"Please choose an answer before submitting.","Choose Answer",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
                displayQuestion(question);
            }
        } else {//Exit the test.
            System.exit(1);
        }

    }
}

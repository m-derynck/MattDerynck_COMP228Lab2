package Ex_1;

//Question class is a container class for a multiple choice question.
//Includes a set of options for the question and a correct answer.
public class Question {

    //Current state of the question
    private enum QuestionState {
        NEW,
        CORRECT,
        WRONG
    }

    public QuestionState questionState = QuestionState.NEW;
    private int answerIndex;
    private String[] options;
    private String actualQuestion;


    public Question(String actualQuestion, String[] options, int answerIndex) {
        this.actualQuestion = actualQuestion;
        this.options = options;
        this.answerIndex = answerIndex;
    }


    //Checks the submitted answer with the answer assigned to this question.
    public boolean checkAnswer(int answerIndex) {
        if (this.answerIndex == answerIndex) {
            questionState = QuestionState.CORRECT;
            return true;
        } else {
            questionState = QuestionState.WRONG;
            return false;
        }
    }

    //Getters and setters below
    public int getAnswerIndex() {
        return answerIndex;
    }

    public void setAnswerIndex(int answerIndex) {
        this.answerIndex = answerIndex;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String getActualQuestion() {
        return actualQuestion;
    }

    public void setActualQuestion(String actualQuestion) {
        this.actualQuestion = actualQuestion;
    }
}

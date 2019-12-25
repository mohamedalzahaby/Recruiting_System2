package classes;

public class Answer extends TimeStamps {

    protected String answer;
    protected int questionId;
    protected int registrationId;

    public Answer(String id, String answer, int questionId, int registrationId) {
        super(id);
        this.answer = answer;
        this.questionId = questionId;
        this.registrationId = registrationId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }


}

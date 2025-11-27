package op1.Questionnaire.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class QuestionAnswers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String answerText;

    @ManyToOne
    @JoinColumn(name = "questionId")
    private Question question;

    public QuestionAnswers() {}

    public QuestionAnswers(String answerText, Question question) {
        this.answerText = answerText;
        this.question = question;
    }

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getAnswerText() {
      return answerText;
    }

    public void setAnswerText(String answerText) {
      this.answerText = answerText;
    }

    public Question getQuestion() {
      return question;
    }

    public void setQuestion(Question question) {
      this.question = question;
    }

}

package op1.Questionnaire.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Question {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String questionString;

  @ManyToOne
  @JoinColumn(name = "questionnaireId")
  private Questionnaire questionnaire;

  public Question(String questionString, Questionnaire questionnaire) {
    this.questionString = questionString;
    this.questionnaire = questionnaire;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getQuestionString() {
    return questionString;
  }

  public void setQuestionString(String questionString) {
    this.questionString = questionString;
  }

  public Questionnaire getQuestionnaire() {
    return questionnaire;
  }

  public void setQuestionnaire(Questionnaire questionnaire) {
    this.questionnaire = questionnaire;
  }
}

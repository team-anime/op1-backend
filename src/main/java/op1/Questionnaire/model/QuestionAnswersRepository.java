package op1.Questionnaire.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface QuestionAnswersRepository extends CrudRepository<QuestionAnswers, Long> {
    @Query(value = "SELECT qa.id, qa.question_id, qa.answer_text FROM QUESTION_ANSWERS qa join QUESTION q on q.id = qa.question_id where q.questionnaire_id = :questionnaireId;",
    nativeQuery = true)
    List<QuestionAnswers> findByQuestionnaireId(@Param("questionnaireId") Long questionnaireId);
}

/*
SELECT * FROM QUESTION_ANSWERS qa
join QUESTION q on q.id = qa.question_id
where q.questionnaire_id = 2;
 */
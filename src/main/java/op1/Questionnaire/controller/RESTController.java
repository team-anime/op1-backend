package op1.Questionnaire.controller;

import org.springframework.web.bind.annotation.RestController;

import op1.Questionnaire.model.Questionnaire;
import op1.Questionnaire.model.QuestionnaireRepository;
import op1.Questionnaire.model.Question;
import op1.Questionnaire.model.QuestionRepository;
import op1.Questionnaire.model.QuestionAnswers;
import op1.Questionnaire.model.QuestionAnswersRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class RESTController {
    private final QuestionnaireRepository questionnaireRepository;
    private final QuestionRepository questionRepository;
    private final QuestionAnswersRepository questionAnswerRepository;

    public RESTController(QuestionnaireRepository questionnaireRepository, QuestionRepository questionRepository,
            QuestionAnswersRepository questionAnswerRepository) {
        this.questionnaireRepository = questionnaireRepository;
        this.questionRepository = questionRepository;
        this.questionAnswerRepository = questionAnswerRepository;
    }

    @RequestMapping(value = "/questionnaires", method = RequestMethod.GET)
    public List<Questionnaire> questionnaires() {
        return (List<Questionnaire>) questionnaireRepository.findAll();
    }

    @RequestMapping(value = "/questionnaires/{id}", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> findQuestions(@PathVariable("id") Long questionnaireId) {
        Optional<Questionnaire> q = questionnaireRepository.findById(questionnaireId);
        Map<String, Object> l = new HashMap<>();
        List<Question> questions = q.get().getQuestions();

        l.put("id", q.get().getId());
        l.put("name", q.get().getName());
        l.put("questions", questions);

        return l;
    }

    /*
     * demo data for saving answers
     * {
     * "questionId": 1,
     * "answerText": "This is my answer"
     * }
     */
    @RequestMapping(value = "/questionAnswers", method = RequestMethod.POST)
    public QuestionAnswers saveAnswer(@RequestBody Map<String, Object> body) {
        Long questionId = Long.valueOf(body.get("questionId").toString());
        String answerText = body.get("answerText").toString();

        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Invalid question ID"));

        QuestionAnswers answer = new QuestionAnswers(answerText, question);
        return questionAnswerRepository.save(answer);
    }

    // katotaan toimiiko
    @RequestMapping(value = "/questionAnswers/batch", method = RequestMethod.POST)
    public List<QuestionAnswers> saveAllAnswers(@RequestBody Map<String, Object> body) {

        List<Map<String, Object>> answers = (List<Map<String, Object>>) body.get("answers");

        return answers.stream().map(a -> {
            Long questionId = Long.valueOf(a.get("questionId").toString());
            String answerText = a.get("answerText").toString();

            Question question = questionRepository.findById(questionId)
                    .orElseThrow(() -> new RuntimeException("Invalid question ID"));

            return questionAnswerRepository.save(new QuestionAnswers(answerText, question));
        }).toList();
    }

    @RequestMapping(value = "/questionAnswers", method = RequestMethod.GET)
    public List<QuestionAnswers> getAllAnswers() {
        return (List<QuestionAnswers>) questionAnswerRepository.findAll();
    }

}

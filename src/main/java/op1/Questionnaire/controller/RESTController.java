package op1.Questionnaire.controller;

import org.springframework.web.bind.annotation.RestController;

import op1.Questionnaire.model.Questionnaire;
import op1.Questionnaire.model.QuestionnaireRepository;
import op1.Questionnaire.model.Question;
import op1.Questionnaire.model.QuestionRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
public class RESTController {
    private final QuestionnaireRepository questionnaireRepository;
    private final QuestionRepository questionRepository;

    public RESTController(QuestionnaireRepository questionnaireRepository, QuestionRepository questionRepository) {
        this.questionnaireRepository = questionnaireRepository;
        this.questionRepository = questionRepository;
    }

    @RequestMapping(value = "/questionnaires", method=RequestMethod.GET)
    public List<Questionnaire> questionnaires() {
        return (List<Questionnaire>) questionnaireRepository.findAll();
    }

    @RequestMapping(value = "/questionnaires/{id}", method=RequestMethod.GET)
    public @ResponseBody Map<String, Object> findQuestions(@PathVariable("id") Long questionnaireId) {
        Optional<Questionnaire> q = questionnaireRepository.findById(questionnaireId);
        Map<String, Object> l = new HashMap<>();
        List<Question> questions = q.get().getQuestions();

        l.put("name", q.get().getName());
        l.put("questions", questions);
  
        return l;
    }
    
    
}

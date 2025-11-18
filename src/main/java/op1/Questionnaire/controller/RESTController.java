package op1.Questionnaire.controller;

import org.springframework.web.bind.annotation.RestController;

import op1.Questionnaire.model.Questionnaire;
import op1.Questionnaire.model.QuestionnaireRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class RESTController {
    private final QuestionnaireRepository questionnaireRepository;

    public RESTController(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }

    @RequestMapping(value = "/questionnaires", method=RequestMethod.GET)
    public List<Questionnaire> questionnaires() {
        return (List<Questionnaire>) questionnaireRepository.findAll();
    }
    
}

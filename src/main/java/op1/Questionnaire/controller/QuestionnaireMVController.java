package op1.Questionnaire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import op1.Questionnaire.model.QuestionnaireRepository;


@Controller
public class QuestionnaireMVController{
    private final QuestionnaireRepository questionnaireRepository;

    public QuestionnaireMVController(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }

    @RequestMapping("/addQuestionnaire")
    public String addQuestionnaire() {
        return "addQuestionnaire";
    }

}
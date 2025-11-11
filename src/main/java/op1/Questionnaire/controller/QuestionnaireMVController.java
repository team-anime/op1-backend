package op1.Questionnaire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import op1.Questionnaire.model.Questionnaire;
import op1.Questionnaire.model.QuestionnaireRepository;


@Controller
public class QuestionnaireMVController{
    private final QuestionnaireRepository questionnaireRepository;

    public QuestionnaireMVController(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }
    @RequestMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }
    

    @RequestMapping(value = "/addQuestionnaire")
    public String addQuestionnaire() {
        return "addQuestionnaire";
    }

    @RequestMapping(value = "/saveQuestionnaire", method = RequestMethod.POST)
    public String saveQuestionnaire(@RequestParam(name="name", required=true) String name) {
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setName(name);
        questionnaireRepository.save(questionnaire);

        return "redirect:index";
    }
}
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
    

    @RequestMapping("/addQuestionnaire")
    public String addQuestionnaire(@RequestParam(name="name", required=false) String name) {
        if(name != "" && name != null) {
            Questionnaire questionnaire = new Questionnaire();
            questionnaire.setName(name);
            questionnaireRepository.save(questionnaire);
            return "redirect:index";
        }
        return "addQuestionnaire";
    }

    // @RequestMapping(value = "/addQuestionnaire", method = RequestMethod.POST)
    // public String addQuestionnaire(Model model){
    // 	model.addAttribute("questionnaire", new Questionnaire());
    //     return "addQuestionnaire";
    // }

}
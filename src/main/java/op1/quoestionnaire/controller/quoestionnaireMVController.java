package op1.quoestionnaire.controller;

import op1.quoestionnaire.model.QuestionnaireRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class quoestionnaireMVController{
    private final QuestionnaireRepository questionnaireRepository;

    public quoestionnaireMVController(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }

    @RequestMapping("/addQuestionnaire")
    public String addQuestionnaire() {
        return "addQuestionnaire";
    }

}
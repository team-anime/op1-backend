package op1.Questionnaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import op1.Questionnaire.model.Question;
import op1.Questionnaire.model.QuestionRepository;
import op1.Questionnaire.model.Questionnaire;
import op1.Questionnaire.model.QuestionnaireRepository;

@Controller
public class QuestionMVController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @GetMapping("/addQuestion")
    public String showForm(Model model) {
        model.addAttribute("questionnaires", questionnaireRepository.findAll());
        return "addQuestion";
    }

    @PostMapping("/addQuestion")
    public String saveQuestion(@RequestParam String questionString, @RequestParam Long questionnaireId) {

        Questionnaire questionnaire = questionnaireRepository.findById(questionnaireId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid questionnaire id"));

        Question question = new Question(questionString, questionnaire);

        questionRepository.save(question);

        return "redirect:/index";
    }

}

package op1.quoestionnaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import op1.quoestionnaire.model.Question;
import op1.quoestionnaire.model.QuestionRepository;
import op1.quoestionnaire.model.QuestionnaireRepository;

@Controller
public class QuestionMVController {

    @Autowired
    private QuestionRepository qRepository;
    
    @Autowired
    private QuestionnaireRepository qrRepository;

    @GetMapping("/addquestion")
    public String addQuestion(Model model) {
        model.addAttribute("question", new Question(null, null)); 
        model.addAttribute("questionnaires", qrRepository.findAll()); 
        return "addQuestion"; 
    }

    @PostMapping("/addquestion")
    public String saveQuestion(@ModelAttribute Question question) {
        
        qRepository.save(question);
        return "redirect:/questionnaires"; 
    }
}

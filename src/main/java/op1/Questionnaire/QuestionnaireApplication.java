package op1.Questionnaire;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import op1.Questionnaire.model.Question;
import op1.Questionnaire.model.Questionnaire;
import op1.Questionnaire.model.QuestionnaireRepository;

@SpringBootApplication
public class QuestionnaireApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionnaireApplication.class, args);
	}

	@Bean
	public CommandLineRunner testiData(QuestionnaireRepository questionnaireRepo) {
		return args -> {
			Questionnaire questionnaire = new Questionnaire("Yeaaaahhh testidataaa yeahhh");
			Questionnaire questionnaire2 = new Questionnaire("Yeaaaahhh testidataaa kakkonen yeahhhhh");

			Question q1 = new Question("kylänäino", questionnaire);
			Question q2 = new Question(":((((", questionnaire);
			Question q3 = new Question("kylänäino", questionnaire2);
			Question q4 = new Question(":((((", questionnaire2);

			ArrayList<Question> questions = new ArrayList<>();
			questions.add(q1);
			questions.add(q2);
			questions.add(q3);
			questions.add(q4);
			questionnaire.setQuestions(questions);
			questionnaire2.setQuestions(questions);

			questionnaireRepo.save(questionnaire);
			questionnaireRepo.save(questionnaire2);

		};
	}

}

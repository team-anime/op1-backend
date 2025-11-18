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
			Questionnaire questionnaire2 = new Questionnaire("Yeahbro testidata kakkonen yeahhhhh");

			Question q1 = new Question("kylänäino", questionnaire);
			Question q2 = new Question(":((((", questionnaire);

			ArrayList<Question> questions1 = new ArrayList<>();
			questions1.add(q1);
			questions1.add(q2);
			
			Question q3 = new Question("voiiiii #@^%#*", questionnaire2);
			Question q4 = new Question("QwQ", questionnaire2);

			ArrayList<Question> questions2 = new ArrayList<>();
			questions2.add(q3);
			questions2.add(q4);

			questionnaire.setQuestions(questions1);
			questionnaire2.setQuestions(questions2);

			questionnaireRepo.save(questionnaire);
			questionnaireRepo.save(questionnaire2);

		};
	}

}

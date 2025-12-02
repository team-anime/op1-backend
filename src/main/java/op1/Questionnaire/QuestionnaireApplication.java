package op1.Questionnaire;

import java.util.ArrayList;
import java.util.Collections;

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
			Questionnaire questionnaire = new Questionnaire("Motivaatiokysely");
			Questionnaire questionnaire2 = new Questionnaire("Yeahbro testidata kakkonen yeahhhhh");

			Question q1 = new Question("Miltä sun opiskelumotivaatio näyttää juuri nyt?", questionnaire);
			Question q2 = new Question("Mikä saa sut yleensä tarttumaan hommiin?", questionnaire);
			Question q3 = new Question("Mikä yleensä vie sun motivaation pois?", questionnaire);
			Question q4 = new Question("Mikä kurssissa tällä hetkellä tuntuu selkeältä tai epäselvältä?", questionnaire);
			Question q5 = new Question("Mikä auttaa sua keskittymään paremmin?", questionnaire);
			Question q6 = new Question("Mikä auttaa sua jaksamaan arjessa?", questionnaire);
			Question q7 = new Question("Mihin aikaan oot yleensä tehokkain?", questionnaire);
			Question q8 = new Question("Mikä on yleisin syy, että siirrät tehtäviä myöhemmälle?", questionnaire);
			Question q9 = new Question("Miltä sun energiatasot tuntuu nyt?", questionnaire);
			Question q10 = new Question("Mikä muutos parantaisi motivoitumista eniten?", questionnaire);

			ArrayList<Question> questions1 = new ArrayList<>();
			Collections.addAll(questions1, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10);

			Question q11 = new Question("voiiiii #@^%#*", questionnaire2);
			Question q12 = new Question("QwQ", questionnaire2);

			ArrayList<Question> questions2 = new ArrayList<>();
			questions2.add(q11);
			questions2.add(q12);

			questionnaire.setQuestions(questions1);
			questionnaire2.setQuestions(questions2);

			questionnaireRepo.save(questionnaire);
			questionnaireRepo.save(questionnaire2);

		};
	}

}

package op1.quoestionnaire.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Questionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ManyToOne
    private Long id;
    private String name;

    public Questionnaire() {

    }
    public Questionnaire(String name) {
        this.name = name;
    }
}

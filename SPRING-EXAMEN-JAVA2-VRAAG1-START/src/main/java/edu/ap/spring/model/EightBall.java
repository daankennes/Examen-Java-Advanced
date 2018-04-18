package edu.ap.spring.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.ap.spring.jpa.Question;
import edu.ap.spring.jpa.QuestionRepository;
import edu.ap.spring.view.UI;

@Component
public class EightBall {
	
	private UI ui;
    private QuestionRepository repository;
    private List<String> answersgiven;
    
    @Autowired
    public void setRepository(QuestionRepository repository) {
    		this.repository = repository;
    }
    
    @Autowired
    public void setUI(UI ui) {
    		this.ui = ui;
    }

	
	public EightBall() {
		this.answersgiven = new ArrayList();
	}



	private String[] answers = {"It is certain", 
								"Yes definitely", 
								"Most likely",
								"Outlook good",
								"Better not tell you now",
								"Cannot predict now",
								"Don't count on it", 
								"Outlook not so good"};
	
	public String getRandomAnswer(String question) {

    	String definitiveAnswer;
    	
    	//check if question has been answered before
    	Question alreadyanswered = repository.findByQuestion(question);
    	
    	//question has not been answered before
    	if (alreadyanswered == null) {
    		//check if answer has been given before
    		
    		//all answers have been given before
    		if (answersgiven.size() >= 8) {
    			int rnd = new Random().nextInt(answers.length);
    			definitiveAnswer = answers[rnd];
    		}
    		//not all answers have been given before: keep trying
    		else {
    			int rnd = new Random().nextInt(answers.length);
    			definitiveAnswer = answers[rnd];
    			while (answersgiven.contains(definitiveAnswer)) {
    				rnd = new Random().nextInt(answers.length);
        			definitiveAnswer = answers[rnd];
    			}
    			answersgiven.add(definitiveAnswer);
    		}
    		repository.save(new Question(question, definitiveAnswer));
    	} 
    	//return existing answer
    	else {
    		definitiveAnswer = alreadyanswered.getAnswer();
    	}
    	
    	// log data
    	System.out.println(answersgiven);
    	System.out.println("All questions:");
    	repository.findAll().forEach(System.out::println);
    	
    	return definitiveAnswer;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}
}

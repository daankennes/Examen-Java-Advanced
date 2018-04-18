package edu.ap.spring.view;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ap.spring.jpa.Question;
import edu.ap.spring.jpa.QuestionRepository;
import edu.ap.spring.model.EightBall;

@Service
public class EventHandler {
	
	private UI ui;
    private QuestionRepository repository;
    private EightBall eightBall;
    private List<String> answersgiven;
    
    @Autowired
    public void setRepository(QuestionRepository repository) {
    		this.repository = repository;
    }
    
    @Autowired
    public void setUI(UI ui) {
    		this.ui = ui;
    }
    
    @Autowired
    public void setEightBall(EightBall eightBall) {
    		this.eightBall = eightBall;
    }
    

    public EventHandler() {
		//super();
    	this.answersgiven = new ArrayList();
	}

	public void whenButtonClicked(ActionEvent actionEvent) {
    	
    	/*String question = ui.getQuestion().getText();
    	this.ui.setLabel("test");
    	String test = eightBall.getRandomAnswer(question);
    	List<Question> alreadyanswered = repository.findByQuestion(question);
    	int size = alreadyanswered.size();
    	int size2 = answersgiven.size();*/
    		
    	String question = ui.getQuestion().getText();
    	//System.out.println(question);
    	String definitiveAnswer;
    	
    	//check if question has been answered before
    	List<Question> alreadyanswered = repository.findByQuestion(question);
    	
    	//question has not been answered before
    	if (alreadyanswered.size() == 0) {
    		//check if answer has been given before
    		
    		//all answers have been given before
    		if (answersgiven.size() >= 8) {
    			definitiveAnswer = eightBall.getRandomAnswer(question);
    		}
    		//not all answers have been given before: keep trying
    		else {
    			definitiveAnswer = eightBall.getRandomAnswer(question);
    			while (answersgiven.contains(definitiveAnswer)) {
    				definitiveAnswer = eightBall.getRandomAnswer(question);
    			}
    			answersgiven.add(definitiveAnswer);
    		}
    		repository.save(new Question(question, definitiveAnswer));
    	} 
    	//return existing answer
    	else {
    		definitiveAnswer = alreadyanswered.get(0).getAnswer();
    	}
    	
    	this.ui.setLabel(definitiveAnswer);
    	
    	// log data
    	System.out.println(answersgiven);
    	System.out.println("All questions:");
    	repository.findAll().forEach(System.out::println);
    	
    	
    	//User user = new User(username, password);
        //repository.save(user);

        /*System.out.println(user.toString() + " saved in repository");
        System.out.println("Find all : ") ;*/
        // repository.findAll().forEach(System.out::println);
    }

}

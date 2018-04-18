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
    	
    	
    	this.ui.setLabel(eightBall.getRandomAnswer(this.ui.getQuestion().getText()));
    	
    
    }

}

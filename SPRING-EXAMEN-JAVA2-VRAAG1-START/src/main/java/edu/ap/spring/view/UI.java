package edu.ap.spring.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.TransferHandler;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UI {
	
	@Autowired
	EventHandler eventHandler;

	private JFrame jFrame;
	private JLabel label1, label2;
	private JTextField question;
	//private JPasswordField userPass;
	private JPanel controlPanel;
    private JButton btnAskQuestion;
    
    public UI() {}
    
    public void setupUI() {
	    jFrame = new JFrame("Spring Eightball");
	    jFrame.setLayout(new FlowLayout());
	    	
	    controlPanel = new JPanel();
	    controlPanel.setLayout(new GridLayout(3, 4));

		label1 = new JLabel("Question: ");
		question = new JTextField(15);
		question.setDragEnabled(true);
		
		label2 = new JLabel("Answer: ");
		//userPass = new JPasswordField(15);

		btnAskQuestion = new JButton();
		btnAskQuestion.setText("Ask question");
		btnAskQuestion.setTransferHandler(new TransferHandler("text"));
		btnAskQuestion.addActionListener(eventHandler::whenButtonClicked);

		controlPanel.add(label1);
		controlPanel.add(question);
		//controlPanel.add(userPass);
		controlPanel.add(btnAskQuestion);
		controlPanel.add(label2);

		jFrame.add(controlPanel);
		        
		jFrame.setSize(400, 400);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setVisible(true);
    }

    public JFrame getjFrame() {
        return this.jFrame;
    }
    
    public JTextField getQuestion() {
    		return this.question;
    }
    
    public JLabel getLabel() {
        return this.label2;
    }
    
    public void setLabel(String answer) {
    	this.label2.setText("answer: " + answer);
    }

    public JButton getButton() {
        return btnAskQuestion;
    }
}


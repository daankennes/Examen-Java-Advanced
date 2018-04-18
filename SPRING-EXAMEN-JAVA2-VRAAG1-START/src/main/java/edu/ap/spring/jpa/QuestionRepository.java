package edu.ap.spring.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
	List<Question> findAll();
	Question findByQuestion(String question);
	List<Question> findByAnswer(String answer);
}


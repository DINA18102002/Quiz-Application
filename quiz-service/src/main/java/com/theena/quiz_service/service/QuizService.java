package com.theena.quiz_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.theena.quiz_service.dao.QuizDao;
import com.theena.quiz_service.feign.QuizInterface;
import com.theena.quiz_service.model.Question;
import com.theena.quiz_service.model.QuestionWrapper;
import com.theena.quiz_service.model.Quiz;
import com.theena.quiz_service.model.Response;
@Service
public class QuizService {
		
	@Autowired
	QuizDao quizDao ;
	
	@Autowired
	 QuizInterface quizInterface;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
		List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numQ).getBody();
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionsIds(questions);
		quizDao.save(quiz);
		
		
		return new ResponseEntity<>("success",HttpStatus.CREATED);
		
		
		
		
		
		
		
		
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		
		
		Quiz quiz = quizDao.findById(id).get();
		List<Integer> questionIds= quiz.getQuestionsIds();
		ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionFromId(questionIds);
		return questions;
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		
		ResponseEntity<Integer> score =  quizInterface.getScore(responses);
		
		return score;
		
		
		
		
	}
	
	
	
		
}

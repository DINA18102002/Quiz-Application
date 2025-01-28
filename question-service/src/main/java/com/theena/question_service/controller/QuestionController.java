package com.theena.question_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.theena.question_service.model.Question;
import com.theena.question_service.model.QuestionWrapper;
import com.theena.question_service.model.Response;
import com.theena.question_service.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	
	
	@Autowired
	 QuestionService questionService;

	@GetMapping("allQuestions")
	public List<Question> getAllQuestions() {
		
		List<Question> questions =  questionService.getAllQuestions();
		System.out.println("questions from controller" + questions);
		return questions;
	}
	
	
	
	
	
	@GetMapping("category/{category}")
	public ResponseEntity< List<Question>> getQuestionByCategory(@PathVariable String category){
		
		return questionService.getQuestionByCategory(category);
		
	}
	
	@PostMapping("add")
	public ResponseEntity< String> addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
		
		
	}
	
	@GetMapping("generate")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName,@RequestParam Integer numQuestions) {
		
		return questionService.getQuestionsForQuiz(categoryName,numQuestions);
		
	}
	
	@PostMapping("getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Integer> questionIds ){
		
		
		return questionService.getQuestionsFromId(questionIds);
	}
	
	
	@PostMapping("getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
		
		return questionService.getScore(responses);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

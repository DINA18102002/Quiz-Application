package com.theena.quiz_service.model;

public class QuizDto {
	
	private String CategoryName;
	private Integer numQuestions;
	private String title;
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public Integer getNumQuestions() {
		return numQuestions;
	}
	public void setNumQuestions(Integer numQuestions) {
		this.numQuestions = numQuestions;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public QuizDto(String categoryName, Integer numQuestions, String title) {
		super();
		CategoryName = categoryName;
		this.numQuestions = numQuestions;
		this.title = title;
	}
	public QuizDto() {
		super();
	}
	@Override
	public String toString() {
		return "QuizDto [CategoryName=" + CategoryName + ", numQuestions=" + numQuestions + ", title=" + title + "]";
	}
	
	
	
}

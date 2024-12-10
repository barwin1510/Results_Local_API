package com.project.Results.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonPropertyOrder({ "id", "name", "registerNo", "english", "tamil", "maths", "science", "social", "total", "result" })
public class Details {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Name;
	private Long registerNo;
	private int english;
	private int tamil;
	private int maths;
	private int science;
	private int social;
	private int total;
	private String result;
	
	public Details() {

	}
	
	public Details(String name, Long registerNo, int english, int tamil, int maths, int science, int social) {
		Name = name;
		this.registerNo = registerNo;
		this.english = english;
		this.tamil = tamil;
		this.maths = maths;
		this.science = science;
		this.social = social;
		calculateTotalAndResult();
	}
	
	public void calculateTotalAndResult() {
		this.total = english + tamil + maths + science + social;
		this.result = (english >= 35 && tamil >= 35 && maths >= 35 && science >= 35 && social >= 35) ? "Pass" : "Fail";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Long getRegisterNo() {
		return registerNo;
	}

	public void setRegisterNo(Long registerNo) {
		this.registerNo = registerNo;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getTamil() {
		return tamil;
	}

	public void setTamil(int tamil) {
		this.tamil = tamil;
	}

	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

	public int getScience() {
		return science;
	}

	public void setScience(int science) {
		this.science = science;
	}

	public int getSocial() {
		return social;
	}

	public void setSocial(int social) {
		this.social = social;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}

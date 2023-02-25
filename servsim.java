package com.example.demo.Leadservice;

import java.util.List;

import com.example.demo.Entity.Lead;

public interface  servsim {
	
	

	void insertData(Lead lead);
	public List<Lead> getAllLead()  ; 
	public void deleted(Integer id);
	public void updatedata(Lead lead, Integer id)   ;
	public void saveOrUpdate(Lead lead);
	public Lead getById(Integer id);
	public   List<Lead> searchProducts(String query);

}

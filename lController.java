package com.example.demo.Leadcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Lead;
import com.example.demo.Leadservice.leadserv;

@RestController
@RequestMapping("/ckpk")
public class lController {

	@Autowired
	private leadserv sev;
	
    //Insert the data to database
	@PostMapping
	public void savedata(@RequestBody Lead lead) {

		sev.insertData(lead);

	}
	
     //Show all data
	@GetMapping
	public List<Lead> getall() {
		
		return sev.getAllLead();
	}
	
	// Show data by using id
	@GetMapping("/getdata/{id}")
	public Lead getdatabyId(@PathVariable("id") Integer id) {
		
     return		sev.getById(id);
		
	}
	
    //Delete data by  using id
	@DeleteMapping("/delete/{id}")
	public void deleteData(@PathVariable("id") Integer id) {
		
		sev.deleted(id);
	}
	
     //Update data by using id
	@PutMapping("/update/{id}")
	public void updateone(@RequestBody Lead lead, @PathVariable("id") Integer id) {

		sev.updatedata(lead, id);	

	}
	
	//Search data by using fname & email_id
	 @GetMapping("/search")
	    public ResponseEntity<List<Lead>> searchProducts(@RequestParam("query") String query){
	        return ResponseEntity.ok(sev.searchProducts(query));
	    }

}


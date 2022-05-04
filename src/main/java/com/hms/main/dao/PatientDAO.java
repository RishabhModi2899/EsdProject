package com.hms.main.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.hms.main.components.DoctorModel;
import com.hms.main.components.PatientModel;

@Component 
public class PatientDAO extends DAO {
	
	public PatientDAO() {
		
	}
	
	public void create(PatientModel patient) {
		
		Session session = getSession();
		
		try {
			
			begin();
			
			session.save(patient);
			
			commit();
			
		} catch(Exception e) {
			
			System.out.println("Could not save the user details! PLease try again..!!");
			
			e.printStackTrace();
			
		} finally {
			
			close();
			
		}
		
	}
	
	public PatientModel getPatient(String username, String password) throws Exception {
	    	
	    	Session session = getSession();
	    	
	    	PatientModel obj;
	    	
	    	try {
	    		
	    		begin();
	    		
	    		Query q = session.createQuery("from PatientModel where username = :USER1 AND password = :PASS1"); 
	    		
	    		q.setParameter("USER1", username);
	    		
	    		q.setParameter("PASS1", password);
	    		
	    		obj = (PatientModel) q.uniqueResult();
	    		
	    	}
	    	catch(Exception e) {
	    		System.out.print(e.getMessage());
	    		
	    		throw new Exception(e.getMessage(), e);
	    		
	    	} finally {
	    		
	    		close();
	    		
	    	}

    		return obj;
	    }
	
}

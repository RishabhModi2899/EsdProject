package com.hms.main.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.hms.main.components.DoctorModel;

@Component
public class DoctorDAO extends DAO {
	
	public DoctorDAO() {
		
	}
	
    public void create(DoctorModel doctor) {

        Session session = getSession();

        try {

            begin();

            session.save(doctor);

            commit();

        } catch (Exception e) {

            System.out.println("Could not save user details!PLease try again..!");

            e.printStackTrace();

        } finally {

            session.close();

        }

    }
    
    public DoctorModel getDoctor(String username, String password) throws Exception {
    	
    	Session session = getSession();
    	
    	try {
    		Query q = session.createQuery("from DoctorModel where username = :USER1 AND password = :PASS1"); 
    		
    		q.setParameter("USER1", username);
    		
    		q.setParameter("PASS1", password);
    		
    		DoctorModel obj = (DoctorModel) q.uniqueResult();
    		
    		close();
    		
    		return obj;
    	}
    	catch(Exception e) {
    		System.out.print(e.getMessage());
    		
    		throw new Exception(e.getMessage(), e);
    	}
    	
    }
	
}

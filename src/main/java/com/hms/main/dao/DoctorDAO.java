package com.hms.main.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.hms.main.components.DoctorModel;

@Component
public class DoctorDAO extends DAO {
	
	public DoctorDAO() {
		
	}
	
//	To add user to the DB Table 
    public void create(DoctorModel doctor) {

        Session session = getSession();

        try {

            begin();

            session.save(doctor);

            commit();
            
            close();

        } catch (Exception e) {

            System.out.println("Could not save user details!PLease try again..!");

            e.printStackTrace();

        } finally {

            session.close();

        }

    }
    
//    To get doctor object for login and sign up purposes
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
    
    
//    To get doctor object with a specific doctor_ID 
    public DoctorModel getDoctorById(int doctor_id) throws Exception {
    	
    	DoctorModel obj = null;
    	
    	Session session = getSession();
    	
    	try {
    		Query q = session.createQuery("from DoctorModel where doctor_id = :DOCID1");
    		
    		q.setParameter("DOCID1", doctor_id);
    		
    		obj = (DoctorModel) q.uniqueResult();
    		
    		close();
    		
    	} catch(Exception e) {
    		
    		throw new Exception(e.getMessage(), e);
    		
    	}
    	
    	return obj;
    	
    }
	
}



























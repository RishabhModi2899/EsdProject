package com.hms.main.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.hms.main.components.DoctorAvailModel;

@Component
public class DoctorAvailDAO extends DAO {
	
	public DoctorAvailDAO() {
		
	}
	
    public void create(DoctorAvailModel avail) {

        Session session = getSession();

        try {

            begin();

            session.save(avail);

            commit();

        } catch (Exception e) {

            System.out.println("Could not save availability details!PLease try again..!");

            e.printStackTrace();

        } finally {

            session.close();

        }

    }
    
    public DoctorAvailModel getDoctor(int doc_ssn) throws Exception {
    	
    	Session session = getSession();
    	
    	try {
    		Query q = session.createQuery("from DoctorAvailModel where ssn = :SSN1"); 
    		
    		q.setParameter("SSN1", doc_ssn);
    		
    		DoctorAvailModel obj = (DoctorAvailModel) q.uniqueResult();
    		
    		close();
    		
    		return obj;
    	}
    	catch(Exception e) {
    		System.out.print(e.getMessage());
    		
    		throw new Exception(e.getMessage(), e);
    	}
    	
    }
	
	
}

package com.hms.main.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.hms.main.components.DoctorAvailModel;

@Component
public class DoctorAvailDAO extends DAO {

	public DoctorAvailDAO() {
		
	}
	
//	To create doctor availability in the DB table 
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
    
//    To get a particular doctor availability using doc_id
    public DoctorAvailModel getDoctorAvailability(int doc_id) throws Exception {
    	
    	Session session = getSession();
    	
    	try {
    		Query q = session.createQuery("from DoctorAvailModel where doctor_id = :DOCID1"); 
    		
    		q.setParameter("DOCID1", doc_id);
    		
    		DoctorAvailModel obj = (DoctorAvailModel) q.uniqueResult();
    		
    		close();
    		
    		return obj;
    	}
    	catch(Exception e) {
    		System.out.print(e.getMessage());
    		
    		throw new Exception(e.getMessage(), e);
    	}
    	
    }
    
//    To get all available doctors 
    public List<DoctorAvailModel> getAllDoctors() throws Exception {
    	
    	Session session = getSession();
    	
    	List<DoctorAvailModel> available_doctors = null;
    	
    	try {
    		
    		Query q = session.createQuery("from DoctorAvailModel where p_count > 0");
    		
    		available_doctors = q.list();
    		
    		close();
    		
    	} catch(Exception e) {
    		
    		e.printStackTrace();
    	
    	}
    	
//    	Testing 
    	for(DoctorAvailModel avail : available_doctors) {
    		System.out.println(avail.toString());
    	}
    	
		return available_doctors;
    	
    }
    
//    To update the p_count attribute of a particular Doctor 
    public void updatePCount(DoctorAvailModel doc_avail, int updatedValueForPCount) {
    	
    	Session session = getSession();
    	
    	try {
    		
    		begin();
    		
    		doc_avail.setP_count(String.valueOf(updatedValueForPCount));
    		
    		session.update(doc_avail);
    		
    		commit();
    		
    		close();
    		
    	} catch(Exception e) {
    		
    		e.printStackTrace();
    		
    	}
    	
    }
	
	
}





















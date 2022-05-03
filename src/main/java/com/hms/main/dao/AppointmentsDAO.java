package com.hms.main.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.hms.main.components.Appointments;

@Component
public class AppointmentsDAO extends DAO {
	
	public AppointmentsDAO() {
		
	}
	
//	To create an appointment and store 
	public void create(Appointments app) {
		
		Session session = getSession();

        try {

            begin();

            session.save(app);

            commit();
            
            close();

        } catch (Exception e) {

            System.out.println("Could not create the appointment!PLease try again..!");

            e.printStackTrace();

        } finally {

            session.close();

        }
		
	}
	
//	To get a particular Appointment by id
	public Appointments getAppointment(int id) {
		
		Session session = getSession();
		
		Appointments app = null;
		
		try {
			Query q = session.createQuery("from Appointments where appoint_id = :ID");
			
			q.setParameter("ID", id);
			
			app = (Appointments) q.uniqueResult();
			
			close();
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return app;
		
	}
	
//	To get all the appointments of a patient with patient_id 
	public List<Appointments> getAllAppointments(int pat_id) {
		
		Session session = getSession(); 
		
		List<Appointments> appointments = null;
		
		try{
			
			Query q = session.createQuery("from Appointments where patient_id = :PATID");
			
			q.setParameter("PATID", pat_id);
			
			appointments = q.list();
			
			close();
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
//		Testing 
		for(Appointments app : appointments) {
			System.out.println("Entered loop" + "\n");
			System.out.println("Appointments : ");
			System.out.println(app.toString());
			System.out.println("\n");
		}
		
		return appointments;
	}
	
//	To delete a particular appointment 
	public void deleteAppointment(Appointments app) {
		
		Session session = getSession();
		
		try {
			
			session.delete(app);
			
			commit();
			
			close();
			
		} catch(Exception e) {
			
			e.printStackTrace();
		
		}
	}
	
}	

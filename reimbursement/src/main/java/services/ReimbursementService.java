package services;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import models.Reimbursement;
import models.Status;
import repositories.ReimbursementDAO;
import repositories.ReimbursementDAOImpl;

public class ReimbursementService {
	
	public static Logger log = Logger.getLogger(ReimbursementService.class);
	
	public static ReimbursementDAO reimbDao = new ReimbursementDAOImpl();
	
	public static List<Reimbursement> getAll() {
		return reimbDao.findAll();
	}
	
	public static List<Status> getAllStatus() {
		return reimbDao.findAllStatus();
	}
	
	public static List<Reimbursement> getReimbursementByUserId(int userId) {
		List<Reimbursement> list = reimbDao.findAll();
		
		list.stream().filter(reimb -> reimb.getReimbAuthor() == userId).collect(Collectors.toList());
		
		return list;
	}
	
	public static void setReimb(Reimbursement reimb) {
		if (reimb != null) {
			reimbDao.insertReimb(reimb);
		} else {
			log.warn("Trying to insert an empty reimbursement!");
		}
		
	}
	
	public static void updateReimb(Reimbursement reimb) {
		if (reimb != null) {
			reimbDao.updateReimb(reimb);
		} else {
			log.warn("Trying to update a reimbursement!");
		}
		
	}

}

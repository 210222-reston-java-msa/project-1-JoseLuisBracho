package repositories;

import java.util.List;

import models.Reimbursement;
import models.Status;

public interface ReimbursementDAO {
	
	public boolean insertReimb(Reimbursement reimb);
	
	public int updateReimb(Reimbursement reimb);
	
	public Reimbursement getReimbByUser(String username);
	
	public Reimbursement getReimbByEmail(String email);
	
	public List<Reimbursement> findAll();
	
	public List<Status> findAllStatus();


}

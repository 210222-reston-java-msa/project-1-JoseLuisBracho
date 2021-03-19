package repositories;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import models.Reimbursement;
import models.Status;
import utils.ConnUtility;

public class ReimbursementDAOImpl implements ReimbursementDAO {
	
	private static Logger log = Logger.getLogger(ReimbursementDAOImpl.class);

	@Override
	public boolean insertReimb(Reimbursement reimb) {
		PreparedStatement st = null;
		

			Connection conn = ConnUtility.getConnection();
			String sql = "insert into reimbursement.ers_reimbursement (reimb_amount, reimb_submitted, "
					+ "reimb_description, reimb_author, reimb_status_id, reimb_type_id) "
					+ "values(?, ?, ?, ?, ?, ?)";
			
			try {
				st = conn.prepareStatement(sql);
				st.setDouble(1, reimb.getReimbAmount());
				st.setDate(2, new java.sql.Date(reimb.getReimbSubmitted().getTime()));
				st.setString(3, reimb.getReimbDescripton());
				st.setInt(4, reimb.getReimbAuthor());
				st.setInt(5, reimb.getReimbStatus());
				st.setInt(6, reimb.getReimbType());
				
				if (!st.execute()) {
					return false;
				}
				
			} catch (SQLException e) {
				log.warn("Unable to insert a reimbursement");
				return false;
			}
			
		return true;
	}

	@Override
	public Reimbursement getReimbByUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement getReimbByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> findAll() {
		
		List<Reimbursement> list = new ArrayList<>();
		
		try {
			Connection conn = ConnUtility.getConnection();
			String sql = "select * from reimbursement.ers_reimbursement";
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				int reimbId = rs.getInt("reimb_id");
				double reimbAmount = rs.getDouble("reimb_amount");
				Date reimbSubmitted = rs.getDate("reimb_submitted");
				Date reimbResolved = rs.getDate("reimb_resolved");
				String reimbDescription = rs.getString("reimb_description");
				FileInputStream reimbReceipt = (FileInputStream) rs.getBlob("reimb_receipt");
				int reimbAuthor = rs.getInt("reimb_author");
				int reimbResolver = rs.getInt("reimb_resolver");
				int reimbStatus = rs.getInt("reimb_status_id");
				int reimbType = rs.getInt("reimb_type_id");

				
				Reimbursement reimb = new Reimbursement(reimbId, reimbAmount, reimbSubmitted, reimbResolved, reimbDescription, reimbReceipt, 
						reimbAuthor, reimbResolver, reimbStatus, reimbType);
				
				list.add(reimb);
				
			}
		
		} catch (SQLException ex) {
			log.warn("Unable to retrieve all users", ex);

		}
		
		return list;
	}

	@Override
	public List<Status> findAllStatus() {
		
		List<Status> list = new ArrayList<>();
		
		try {
			Connection conn = ConnUtility.getConnection();
			String sql = "select * from reimbursement.ers_reimbursement_status";
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				int statusId = rs.getInt("reimb_status_id");
				String stat = rs.getString("reimb_status");
				
				Status status = new Status(statusId, stat);
				
				list.add(status);
				
			}
		
		} catch (SQLException ex) {
			log.warn("Unable to retrieve all users", ex);

		}
		
		return list;
	}

	@Override
	public int updateReimb(Reimbursement reimb) {
		int result = 0;
		try {
			Connection conn = ConnUtility.getConnection();
			String sqlUpdate = "update reimbursement.ers_reimbursement set reimb_resolved = ?,"
					+ " reimb_resolver=?, reimb_status_id=? where reimb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sqlUpdate);
			ps.setDate(1, new java.sql.Date(reimb.getReimbResolved().getTime()));;
			ps.setInt(2, reimb.getReimbResolver());
			ps.setInt(3, reimb.getReimbStatus());
			ps.setInt(4, reimb.getReimbId());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			log.info("An Internal Error has Ocurred");
		}
		
		log.info("Data upated...");
		return result;
	}

}

package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.ReimbTemplate;
import models.ReimbUser;
import models.Reimbursement;
import models.Status;
import models.User;
import models.UserLoginTemplate;
import services.ReimbursementService;
import services.UserService;

public class RequestHelper {
	
private static Logger log = Logger.getLogger(RequestHelper.class);
	
	private static ObjectMapper objMap = new ObjectMapper();
	
	public static void processLogin(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		BufferedReader reader = req.getReader();
		StringBuilder st = new StringBuilder();
		
		String line = reader.readLine();
		while (line != null) {
			st.append(line);
			line = reader.readLine();
		}
		
		String body = st.toString();
		
		log.info("From login form: " + body);
		
		UserLoginTemplate loginUser = objMap.readValue(body, UserLoginTemplate.class);
	
		String username = loginUser.getUsername();
		String password = loginUser.getPassword();
		
		log.info("User trying to login with " + username);
		
		User userDB = UserService.checkLogin(username, password);
		
		if (userDB != null) {
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
					
			PrintWriter pw = res.getWriter();
			
			res.setContentType("application/json");
			
			pw.println(objMap.writeValueAsString(userDB));
			
			log.info(username + " has successfully logged in");
		} else {
			res.setStatus(204);
		}
		
	}
	
	
	public static void processLogout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession(false);
		
		log.info("processing logout");
		
		if (session != null) {
			String username = (String) session.getAttribute("username");
			log.info(username + " has logged out");
			session.invalidate();
			
		}
		
		res.setStatus(200);
	}
	
	
	public static void processUserReimb(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		BufferedReader reader = req.getReader();
		StringBuilder st = new StringBuilder();
		
		String line = reader.readLine();
		while (line != null) {
			st.append(line);
			line = reader.readLine();
		}
		
		String body = st.toString();
		
		log.info("From sendReimb form: " + body);
		
		ReimbUser reimbUser = objMap.readValue(body, ReimbUser.class);
		
		int reimbType = reimbUser.getReimbType();
		double reimbAmount = reimbUser.getReimbAmount();
		String reimbDescription = reimbUser.getReimbDescription();
		FileInputStream fis = null;
		
		Date reimbSubmitted = new Date();
		Date reimbResolved = null;
		int reimbStatus = 4;
		int reimbResolver = 0;
		
		HttpSession session = req.getSession(false);
		int reimbAuthor = 0;
		String username = null;
		if (session != null) {
			username = (String) session.getAttribute("username");
			reimbAuthor = UserService.getUserbyUsername(username).getUserId();
		}
		
		Reimbursement reimb = new Reimbursement(reimbAmount, reimbSubmitted, reimbResolved, reimbDescription,
				fis, reimbAuthor, reimbResolver, reimbStatus, reimbType);
		
		ReimbursementService.setReimb(reimb);
		
		log.info("New reimbursement for " + username + " generated");
		
	}
	
	public static void processShowReimb(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession(false);
		User userDB;
		List<Reimbursement> reimbByUser;
		
		if (session != null) {
			String username = (String) session.getAttribute("username");
			
			userDB = UserService.getUserbyUsername(username);
	
			reimbByUser = ReimbursementService.getReimbursementByUserId(userDB.getUserId());
			
			PrintWriter pw = res.getWriter();
			
			res.setContentType("application/json");
			
			pw.println(objMap.writeValueAsString(reimbByUser));
			
			log.info("Lista de reimbursements " + reimbByUser);
		}
		
	}
	
	public static void processAllReimb(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession(false);
		List<Reimbursement> allReimb = ReimbursementService.getAll();
		
		if (session != null) {
			PrintWriter pw = res.getWriter();
			res.setContentType("application/json");
			
			pw.println(objMap.writeValueAsString(allReimb));
			
			log.info("All reimbursements: " + allReimb);
		}
}
	
	public static void processAllUsers(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession(false);
		List<User> allUsers = UserService.getAll();
		
		if (session != null) {
			PrintWriter pw = res.getWriter();
			res.setContentType("application/json");
			
			pw.println(objMap.writeValueAsString(allUsers));
			
			log.info("All reimbursements: " + allUsers);
		}
}
	
	
	public static void processAllStatus(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession(false);
		List<Status> allStatus = ReimbursementService.getAllStatus();
		
		if (session != null) {
			PrintWriter pw = res.getWriter();
			res.setContentType("application/json");
			
			pw.println(objMap.writeValueAsString(allStatus));
			
			log.info("All reimbursements: " + allStatus);
		}
}
	
	
	public static void processUpdateReimb(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		BufferedReader reader = req.getReader();
		StringBuilder st = new StringBuilder();
		
		String line = reader.readLine();
		while (line != null) {
			st.append(line);
			line = reader.readLine();
		}
		
		String body = st.toString();
		
		log.info("From updateReimb form: " + body);
		
		ReimbTemplate reimbUpdate = objMap.readValue(body, ReimbTemplate.class);
		
		int reimbId = reimbUpdate.getReimbId();
		int reimbStatus = reimbUpdate.getReimbStatus();
		String reimbDescription = reimbUpdate.getReimbDescription();

		Date reimbResolved = new Date();
		
		HttpSession session = req.getSession(false);
		int reimbResolver = 0;
		String username = null;
		if (session != null) {
			username = (String) session.getAttribute("username");
			reimbResolver = UserService.getUserbyUsername(username).getUserId();
		}
		
		Reimbursement reimb = new Reimbursement(reimbId, 0, null, reimbResolved, null,
				null, 0, reimbResolver, reimbStatus, 0);
		
		ReimbursementService.updateReimb(reimb);
		
		try {
			MailUtil.sendEmail("myAddress@example.com", "approved");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info("New updated reimbursement," + " generated by " + username);
		
	}
	
	public static void processError(HttpServletRequest req, HttpServletResponse res) throws IOException {
			
			try {
				req.getRequestDispatcher("error.html").forward(req, res);
	
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		
	}

}

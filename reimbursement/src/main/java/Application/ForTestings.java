package Application;

import javax.mail.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import models.Reimbursement;
import models.User;
import services.ReimbursementService;
import services.UserService;
import utils.MailUtil; 

public class ForTestings {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		for(Reimbursement reimb: ReimbursementService.getAll()) {
			System.out.println(reimb);
		}
		
		System.out.println("\nAhora usuario todos");
		
		for(User user: UserService.getAll()) {
			System.out.println(user);
		}
		
		System.out.println("\nAdquiriendo los roles");
	
		for(User user: UserService.getAll()) {
			System.out.println(UserService.getRole(user.getUsername(), user.getPassword()));
		}
		
		
		//MailUtil.sendEmail("j_bracho@hotmail.com", "denied");
		 

	}
	
	

}

//Employee User Stories
//An Employee can login
//An Employee can view the Employee Homepage
//An Employee can logout
//An Employee can submit a reimbursement request
//An Employee can upload an image of his/her receipt as part of the reimbursement request (extra credit)
//An Employee can view their pending reimbursement requests
//An Employee can view their resolved reimbursement requests
//An Employee can view their information
//An Employee can update their information
//An Employee receives an email when one of their reimbursement requests is resolved (optional)


//Manager User Stories
//A Manager can login
//A Manager can view the Manager Homepage
//A Manager can logout
//A Manager can approve/deny pending reimbursement requests
//A Manager can view all pending requests from all employees
//A Manager can view images of the receipts from reimbursement requests (extra credit)
//A Manager can view all resolved requests from all employees and see which manager resolved it
//A Manager can view all Employees
//A Manager can view reimbursement requests from a single Employee
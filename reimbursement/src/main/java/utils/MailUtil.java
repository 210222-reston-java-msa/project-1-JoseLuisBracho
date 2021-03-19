package utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class MailUtil {

	public static void sendEmail(String receipient, String status) throws Exception {

		Logger log = Logger.getLogger(MailUtil.class);

		final String emailId = "myAddress@example.com"; // sender's email address
		final String reciever = receipient; // reciever's email address
		final String password = "xxxxxx"; // provide your password here

		System.out.println("Sending Email from " + emailId + " to " + reciever);

		Properties pr = new Properties();

		pr.put("mail.smtp.auth", "true"); // for username and password authentication
		pr.put("mail.smtp.starttls.enable", "true");
		pr.put("mail.smtp.host", "smtp.gmail.com"); // here host is gmail.com
		pr.put("mail.smtp.port", "587"); // port no.

		Session gs = Session.getInstance(pr, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(emailId, password); // pass your email id and password here

			}
		});

		Message ms = messageContent(gs, emailId, reciever, status);

		Transport.send(ms);

		log.info("Message sent! ");

	}

	private static Message messageContent(Session gs, String emailId, String reciever, String status) throws Exception {
		try {

			Message msg = new MimeMessage(gs);
			msg.setFrom(new InternetAddress(emailId));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(reciever));
			msg.setSubject("Reimbursement Approved"); // to set the subject (not mandatory)
			String text = "Dear Employee; Your more recent reimbursement submit has been " + status + ". For additional information, please contact Finance Department.";
			msg.setText(text);

			return msg;

		} catch (MessagingException e) {
			System.out.println(e);

		}

		return null;

	}

}

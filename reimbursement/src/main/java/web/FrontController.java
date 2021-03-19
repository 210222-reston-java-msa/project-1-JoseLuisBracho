package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.RequestHelper;

@MultipartConfig(location = "d:\\tmp"
        , fileSizeThreshold = 1024 * 1024
        , maxFileSize = 1024 * 1024 * 5
        , maxRequestSize = 1024 * 1024 * 5 * 5)
public class FrontController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String URI = request.getRequestURI().replace("/reimbursement/", "");
		
		switch(URI) {
		
		case "login":
			RequestHelper.processLogin(request, response);
			break;
			
		case "logout":
			RequestHelper.processLogout(request, response);
			break;
		case "showReimb":
			RequestHelper.processShowReimb(request, response);
			break;
		case "sendReimb":
			RequestHelper.processUserReimb(request, response);
			break;
		case "allReimb":
			RequestHelper.processAllReimb(request, response);
			break;
		case "allUsers":
			RequestHelper.processAllUsers(request, response);
			break;
		case "allStatus":
			RequestHelper.processAllStatus(request, response);
			break;
		case "updateReimb":
			RequestHelper.processUpdateReimb(request, response);
			break;
		case "error":
			RequestHelper.processError(request, response);
			break;
		 
		} 
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

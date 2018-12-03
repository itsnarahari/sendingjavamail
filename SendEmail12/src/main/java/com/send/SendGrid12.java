package com.send;

import java.io.IOException;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;




public class SendGrid12 {
	
	

	  public static void main(String[] args) throws IOException {
	    Email from = new Email("naraharinaik7@gmail.com");
	    String subject = "Sending with SendGrid is Fun";
	    Email to = new Email("sirisrilatha32@gmail.com");
	    Content content = new Content("text/plain", "From Narahari");
	    Mail mail = new Mail(from, subject, to, content);
	    
	    SendGrid sg = new SendGrid("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");
	    Request request = new Request();
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      Response response = sg.api(request);
	      System.out.println(response.getStatusCode());
	      System.out.println(response.getBody());
	      System.out.println(response.getHeaders());
	    } catch (IOException ex) {
	      throw ex;
	    }
	  }
	}

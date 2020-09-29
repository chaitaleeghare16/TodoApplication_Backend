package AddUser;


import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	
	
	
	    //send email to the user email
	    public static boolean sendEmail(User u) {
	        boolean test = false;
	      
	        System.out.println("inside email");
	        System.out.println(u.getEmail());
	        System.out.println(u.getCode());
	        String toEmail = u.getEmail();
	        String fromEmail = "checkusermail123@gmail.com";
	        String password = "Home@123";

	        try {

	            // your host email smtp server details
	            Properties pr = new Properties();
	            pr.setProperty("mail.smtp.host", "smtp.gmail.com");
	            pr.setProperty("mail.smtp.port", "465");
	            pr.setProperty("mail.smtp.auth", "true");
	            pr.setProperty("mail.smtp.starttls.enable", "true");
	            pr.put("mail.smtp.socketFactory.port", "465");
	            pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	 
	            
	            //get session to authenticate the host email address and password
	            Session session = Session.getInstance(pr, new Authenticator() {
	                @Override
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(fromEmail, password);
	                }
	            });

	            //set email message details
	            Message mess = new MimeMessage(session);

	    		//set from email address
	            mess.setFrom(new InternetAddress(fromEmail));
	    		//set to email address or destination email address
	            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
	    		
	    		//set email subject
	            mess.setSubject("User Email Verification");
	         
	    		//set message text
	            mess.setText("Registered successfully.Please verify your account using this code: " + u.getCode());
	            //send the message
	            Transport.send(mess);
	            
	            test=true;
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return test;
	    }
	    
	   
}

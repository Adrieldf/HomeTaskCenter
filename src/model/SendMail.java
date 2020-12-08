package model;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	
	private String recipients;
	private String subject;
	private String text;
	
	public SendMail() {
		
	}
	
	public void setRecipients(String recipient) {
		this.recipients = recipient;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public void sendMailReminder() {
		
		Properties props = new Properties();
   		/** Parâmetros de conexão com servidor Gmail */
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class",
	    "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", "465");

	    Session session = Session.getDefaultInstance(props,
    		
    		new javax.mail.Authenticator() {
	    	
	    		protected PasswordAuthentication getPasswordAuthentication() {
	    			return new PasswordAuthentication("hometaskcenter@gmail.com", "hometask123");
	    		}
	      	}
	    );
		    
	    /** Ativa Debug para sessão */
	    session.setDebug(true);
		    
	    try {

	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress("hometaskcenter@gmail.com"));
	        //Remetente

	        Address[] toUser = InternetAddress.parse("hometaskcenter@gmail.com");

	        
	        String[] a = recipients.split(";");
	        for (int i = 0; i < a.length; i++) {
        		toUser = InternetAddress.parse(a[i]);	
			}

	        message.setRecipients(Message.RecipientType.TO, toUser);
	        message.setSubject(this.subject);
	        message.setText(this.text);
	        
	        /**Método para enviar a mensagem criada*/
	        Transport.send(message);

	        System.out.println("E-mail enviado com sucesso!");

	       } catch (MessagingException e) {
	    	  System.out.println("Erro ao enviar o e-mail");
	          throw new RuntimeException(e);
	          
	       }
	    
	}
	
}

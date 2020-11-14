package test;

import model.SendMail;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class TestMail {
	
	
	// Código correto
	public static void main(String[] args) {
		
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
	        // TODO mudar e-mail aqui
	        message.setFrom(new InternetAddress("hometaskcenter@gmail.com"));
	        //Remetente

	        Address[] toUser = InternetAddress //Destinatário(s)
	                   .parse("emersonajahn@gmail.com, emersonajahn@hotmail.com");

	        message.setRecipients(Message.RecipientType.TO, toUser);
	        message.setSubject("Enviando email com JavaMail");//Assunto
	        message.setText("Enviei este email utilizando JavaMail com minha conta GMail!");
	        
	        /**Método para enviar a mensagem criada*/
	        Transport.send(message);

	        System.out.println("E-mail enviado com sucesso!");

	       } catch (MessagingException e) {
	    	  System.out.println("Erro ao enviar o e-mail");
	          throw new RuntimeException(e);
	      }
	    }
	
	
	
	// Ignorar esse trecho de código 
//	private static String recipientOne = "emersonajahn@gmail.com";
//	private static String recipientTwo = "emersonajahn@hotmail.com";
//	private static String subject = "TestMail";
//	private static String text = "Testing mail";
//	private static SendMail mail = new SendMail();
//	
//	
//	
//	public static void main(String [] args) {
//		
//		Test();
//		System.out.println("chegou aqui");
//		
//	}
//	
//	private static void Test() {
//		mail.setRecipients(0, recipientOne);
//		mail.setRecipients(0, recipientTwo);
//		mail.setSubject(subject);
//		mail.setText(text);
//	}

}

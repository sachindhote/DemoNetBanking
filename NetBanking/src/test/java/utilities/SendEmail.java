package utilities;

import java.util.Properties;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {
	
	
		public static void sendReport() {
			
			//Receipants email id need to be mentioned
			String to="sjdhote@gmail.com";
			
			//Receipants email id need to be mentioned
			String from="sjdhote@gmail.com";
			
			//define email sever host(This is mostly in format mail.yourcompanyname.com
			String host="webmail.flex.com";
			
			//get system properties
			Properties properties = System.getProperties();
			
			//Setuo mail server
			properties.put("mail.host", host);
			properties.put("mail.smtp.user",from);
			properties.put("mail.smtp.port", "9090");
			
			//Get the default session object 
			Session session=Session.getDefaultInstance(properties);
			
			try {
				//create default message object
				MimeMessage message=new MimeMessage(session);
				
				//Set From: header field of the header
				message.setFrom(new InternetAddress(from));
				
				//Set to: header field of the header
				message.addRecipient(Message.RecipientType.TO, new InternetAddress (to));
				
				//set subject: header field
				message.setSubject("Automation Test Report");
				
				//set the actual message 
				//create message part
				BodyPart messageBodyPart =new MimeBodyPart();
				
				//set actual message
				messageBodyPart.setText("Automation Results");
				
				//create multipar message
				Multipart multipart=new MimeMultipart();
				
				//set test message part
				multipart.addBodyPart(messageBodyPart);
				
				//part two is attachment
				messageBodyPart =new MimeBodyPart();
				
				addAttachment(multipart,"C:\\Users\\punsdhot\\git\\inetbankingV1\\test-output\\MyOwnReport.html","MyOwnReport.html");
				addAttachment(multipart,"C:\\Users\\punsdhot\\git\\inetbankingV1\\test-output\\jquery-1.7.1.min.js","jquery-1.7.1.min.js");
				
				//send the complete message part
				message.setContent(multipart);
				
				//send message
				Transport.send(message);
				
				System.out.println("Send email successfully");
			}catch(MessagingException msg){
				msg.printStackTrace();
				
			}
	}
			private static void addAttachment(Multipart multipart, String filepath, String filename) throws MessagingException {
				DataSource source =new FileDataSource(filepath);
				BodyPart messageBodyPart =new MimeBodyPart();
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(filename);
				multipart.addBodyPart(messageBodyPart);
				
				
				
			}

}

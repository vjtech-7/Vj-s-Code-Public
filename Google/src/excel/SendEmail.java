package excel;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {

	public static void main(String args[]) throws EmailException
	{
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("techyvj@gmail.com", "goldgate82"));
		//email.setAuthentication("techyvj@gmail.com", "goldgate82");
		email.setSSLOnConnect(true);
		email.setFrom("techyvj@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("vj.k@outlook.com");
		email.send();
	}
}

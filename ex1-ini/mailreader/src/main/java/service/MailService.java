package service;

import domaine.Mail;

// vérifier le mail et envoyer au mailSender

public class MailService {
	
	MailSender sender;

	/**
	 * @param sujet = sujet du mail à envoyer
	 */
	public void envoyerMail(Mail mail, boolean production){
		
		if (production) {
			sender.envoyerMail(mail);
			System.out.println("Envoyé en prod");
		}
		else {
			sender.envoyerMail(mail);
			System.out.println("Envoyé en recette");
		}
			
	}
}
package service;

import domaine.Mail;

// Envoi du mail
public interface MailSender {
	
	void envoyerMail(Mail mail);
	
}
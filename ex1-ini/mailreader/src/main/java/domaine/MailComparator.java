package domaine;

import java.time.Instant;
import java.util.Comparator;

import domaine.Mail.Statut;

/**
 * Comparateur de mails
 * 
 * Comme on désire afficher les mails les plus importants en premier, l'element le plus grand retourne une valeur négative
 *
 */
public class MailComparator implements Comparator<Mail> {

	//Classement des mails
	private static final int SECOND_AVANT = 1;
	private static final int PREMIER_AVANT = -1;
	private static final int EGAUX = 0;

	
	/**
	 * Permet de comparer deux mails
	 * 
	 * @param mail1 : le premier mail à comparer
	 * @param mail2 : le second mail à comparer
	 * @return 0 si ils sont égaux, -1 si le premier mail passe avant le second, 1 si le second mail passe avant le premier
	 */
	
	public int compare(Mail mail1, Mail mail2) {
				
		if (mail1 == null || mail2 == null) {
			 
			return EGAUX;
		}
		
		boolean importanceMail1 = mail1.isImportant();
		boolean importanceMail2 = mail2.isImportant();
		
		if (importanceMail1 != importanceMail2) {
				return this.getMailImportant(mail1, mail2);
			
		}
		
		Statut statutMail1 = mail1.getStatut();
		Statut statutMail2 = mail2.getStatut();
		
		if (statutMail1 != statutMail2) {
			
			return this.getMailAvecStatutPlusImportant(mail1, mail2);
		}
		
		String sujetMail1 = mail1.getSujet();
		String sujetMail2 = mail2.getSujet();
		
		if (sujetMail1 != sujetMail2) {
			return this.getMailAvecSujetPlusImportant(sujetMail1, sujetMail2);
		}
		
		Instant dateMail1 = mail2.getDate();
		Instant dateMail2 = mail1.getDate();
		
		int dateMail1vsDateMail2 = dateMail1.compareTo(dateMail2);
		return dateMail1vsDateMail2;
	}
	
	
	private int getMailImportant(Mail mail1, Mail mail2) {
		if (mail1.isImportant() && !mail2.isImportant()) {
			return PREMIER_AVANT;
		} else {
			return SECOND_AVANT;
		}
	}
	
	private int getMailAvecStatutPlusImportant(Mail mail1, Mail mail2) {
		int comparaison = mail1.getStatut().ordinal() - mail2.getStatut().ordinal();
		
		return comparaison > EGAUX ? PREMIER_AVANT: SECOND_AVANT;
	}
	
	private int getMailAvecSujetPlusImportant(String sujetMail1, String sujetMail2) {
		
		int sujetMail1vsSujetMail2 = sujetMail2.compareTo(sujetMail1);
		return sujetMail1vsSujetMail2;
	}
	
	

}

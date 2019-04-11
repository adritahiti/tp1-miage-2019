package presentation;

// récupère les arguments 
public class ClientMail {

	
	private static final int arguments = 2;

	public static void main(String[] args) {
		
		  InterpreteurLigneCommande interpreteurLigneCommande = new InterpreteurLigneCommande();

		if(args.length<arguments) {
			System.out.println("Veuillez renseignez la valeur true pour la production ou flase pour la recette ainsi que le sujet du mail");
		} 
		
		else 
			interpreteurLigneCommande.nouveauMail(args);
		   
	}		
}
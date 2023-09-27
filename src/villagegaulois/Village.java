package villagegaulois;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}

	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef "
					+ chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom()
					+ " vivent les lÃ©gendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}
	
	private static  class Marche{
		private Etal[] etals;
		


		private void setEtals(int nbetals) {
			etals =new Etal[nbetals];
			
		}
		
		
		
		private void utiliseretall(int indiceEtal, Gaulois vendeur,String produit, int nbProduit) {
			etals[indiceEtal].occuperEtal(vendeur, produit, nbProduit);
			
		}
		private int trouverEtalLibre() {
			for (int i = 0; i < etals.length; i++) {
			    if (etals[i].isEtalOccupe()) {
			    	return i;
			    	}
			    }
		return -1;
		}
		
		private Etal[] trouverEtals(String produit) {
			Etal[] etalsprd =new Etal[etals.length];
			int tabind =0;
			for (int i = 0; i < etals.length; i++) {
				if (etals[i].contientProduit(produit)) {
			    	etalsprd[tabind] = etals[i];
			    	tabind++;
			    	}
			}
			return etalsprd;
		}
		
		private Etal trouverVendeur(Gaulois gaulois) {
			for (int i = 0; i < etals.length; i++) {
				if (etals[i].getVendeur()== gaulois) {
					return etals[i];}
			}
			return null;
		}
		
		
		private String afficherMarche() {
			StringBuilder etalstrn=new StringBuilder("les etales libres :");
			int nbetlanocc =0;
			for (int i = 0; i < etals.length; i++) {
			    if (etals[i].isEtalOccupe()) {
			    	etalstrn.append(etals[i].afficherEtal());
			    	}
			    else {
			    	nbetlanocc++;}
			    }
			if (nbetlanocc >0) {
				etalstrn.append("Il reste " + nbetlanocc + " étals non utilisés dans le marché.\n");
			}
			return etalstrn.toString();
		}
			
			
			
			
		}

	
}	
	

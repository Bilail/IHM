package model;

import java.util.ArrayList;
import java.util.List;
import events.CouleurObservateur;
import events.NouvelleValeurCouleurEvenement;

public class Model implements ModelInterface
{
	private int valeurRouge = 0;
	private int valeurVert = 0;
	private int valeurBleu = 0;
	
	private List<CouleurObservateur> couleurObserveurs = new ArrayList<CouleurObservateur>(); 
	
	@Override
	public int getValeurRouge() 
	{
		return valeurRouge;
	}
	
	@Override
	public void setValeurRouge(int valeurRouge)
	{
		this.valeurRouge = valeurRouge;
		prevenirLesObservateurs();
	}
	
	@Override
	public int getValeurVert() 
	{
		return valeurVert;
	}
	
	@Override
	public void setValeurVert(int valeurVert)
	{
		this.valeurVert = valeurVert;
		prevenirLesObservateurs();
	}
	
	@Override
	public int getValeurBleu()
	{
		return valeurBleu;
	}
	
	@Override
	public void setValeurBleu(int valeurBleu) 
	{
		this.valeurBleu = valeurBleu;
		prevenirLesObservateurs();
	}
	
	@Override
	public void setCouleur(int valeurRouge, int valeurVert, int valeurBleu)
	{
		this.valeurRouge = valeurRouge;
		this.valeurVert = valeurVert;
		this.valeurBleu = valeurBleu;
		prevenirLesObservateurs();
	}
	
	@Override
	public void ajouterUnObservateur(CouleurObservateur couleurObserveur)
	{
		this.couleurObserveurs.add(couleurObserveur);
	}
	
	@Override
	public void supprimerUnObservateur(CouleurObservateur couleurObserveur)
	{
		this.couleurObserveurs.remove(couleurObserveur);
	}
	
	@Override
	public void prevenirLesObservateurs()
	{
		for(CouleurObservateur couleurObserveur : couleurObserveurs)
		{
			couleurObserveur.NouvelleValeurCouleur(new NouvelleValeurCouleurEvenement(this, valeurRouge, valeurVert, valeurBleu));
		}
	}
}
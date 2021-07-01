package controller;

import model.Model;
import events.CouleurObservateur;

public class Controller implements ControllerInterface
{
	private Model modele;
	
	public Controller(Model modele)
	{
		this.modele = modele;
	}
	
	@Override
	public void ajouterUnObservateur(CouleurObservateur couleurObservateur)
	{
		modele.ajouterUnObservateur(couleurObservateur);	
	}
	
	@Override
	public void supprimerUnObservateur(CouleurObservateur couleurObservateur)
	{
		modele.supprimerUnObservateur(couleurObservateur);
	}
	
	@Override
	public void ValeurRougeModifiee(int valeurRouge)
	{
		modele.setValeurRouge(valeurRouge);
	}
	
	@Override
	public void ValeurVertModifiee(int valeurVert)
	{
		modele.setValeurVert(valeurVert);
	}
	
	@Override
	public void ValeurBleuModifiee(int valeurBleu)
	{
		modele.setValeurBleu(valeurBleu);
	}
	
	@Override
	public void CouleurModifiee(int valeurRouge, int valeurVert, int valeurBleu)
	{
		modele.setCouleur(valeurRouge, valeurVert, valeurBleu);
	}
}
package controller;

import events.CouleurObservateur;

public interface ControllerInterface
{
	/**
	 * Ajoute un observateur de l'état du modèle.
	 * @param couleurObserveur L'observateur à ajouter
	 */
	public void ajouterUnObservateur(CouleurObservateur couleurObservateur);
	
	/**
	 * Supprime un observateur de l'état du modèle.
	 * @param couleurObserveur L'observateur à supprimer
	 */
	public void supprimerUnObservateur(CouleurObservateur couleurObservateur);
	
	/**
	 * Actualise le modèle avec une nouvelle valeur de rouge.
	 * @param valeurRouge La nouvelle valeur de rouge
	 */
	public void ValeurRougeModifiee(int valeurRouge);
	
	/**
	 * Actualise le modèle avec une nouvelle valeur de vert.
	 * @param valeurVert La nouvelle valeur de vert
	 */
	public void ValeurVertModifiee(int valeurVert);
	
	/**
	 * Actualise le modèle avec une nouvelle valeur de bleu.
	 * @param valeurBleu La nouvelle valeur de bleu
	 */
	public void ValeurBleuModifiee(int valeurBleu);
	
	/**
	 * Actualise le modèle avec une nouvelle couleur.
	 * @param valeurRouge La nouvelle valeur de rouge
	 * @param valeurVert La nouvelle valeur de vert
	 * @param valeurBleu La nouvelle valeur de bleu
	 */
	public void CouleurModifiee(int valeurRouge, int valeurVert, int valeurBleu);
}

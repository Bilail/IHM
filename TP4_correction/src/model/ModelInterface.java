package model;

import events.CouleurObservateur;

public interface ModelInterface
{
	/**
	 * Donne accès à la valeur de rouge du modèle.
	 * @return La valeur de rouge
	 */
	public int getValeurRouge();
	
	/**
	 * Modifie la valeur de rouge du modèle.
	 * @param valeurRouge La nouvelle valeur de rouge
	 */
	public void setValeurRouge(int valeurRouge);
	
	/**
	 * Donne accès à la valeur de vert du modèle.
	 * @return La valeur de vert
	 */
	public int getValeurVert();
	
	/**
	 * Modifie la valeur de vert du modèle.
	 * @param valeurVert La nouvelle valeur de vert
	 */
	public void setValeurVert(int valeurVert);
	
	/**
	 * Donne accès à la valeur de bleu du modèle.
	 * @return La valeur de bleu
	 */
	public int getValeurBleu();
	
	/**
	 * Modifie la valeur de bleu du modèle.
	 * @param valeurBleu La nouvelle valeur de bleu
	 */
	public void setValeurBleu(int valeurBleu);
	
	/**
	 * Modifie la couleur du modèle.
	 * @param valeurRouge La nouvelle valeur de rouge
	 * @param valeurVert La nouvelle valeur de vert
	 * @param valeurBleu La nouvelle valeur de bleu
	 */
	public void setCouleur(int valeurRouge, int valeurVert, int valeurBleu);
	
	/**
	 * Ajoute un CouleurObservateur à la liste tenue par le modèle.
	 * Il sera prévenu si la couleur du modèle change.
	 * @param couleurObservateur Le CouleurObservateur à ajouter
	 */
	public void ajouterUnObservateur(CouleurObservateur couleurObservateur);
	
	/**
	 * Supprime un CouleurObservateur de la liste tenue par le modèle.
	 * Il ne sera plus prévenu si la couleur du modèle change.
	 * @param couleurObservateur Le CouleurObservateur à ajouter
	 */
	public void supprimerUnObservateur(CouleurObservateur couleurObservateur);
	
	/**
	 * Envoie, aux CouleurObservateurs de la liste tenue par le modèle,
	 * un événement contenant la nouvelle couleur.
	 */
	public void prevenirLesObservateurs();
}

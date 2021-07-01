package controller;

import event.PercentageValueListener;

public interface ControllerInterface
{
	/**
	 * Permet d'obtenir la valeur actuelle du pourcentage dans le modèle.
	 * @return La valeur actuelle du pourcentage
	 */
	public double getValue();
	
	/**
	 * Permet de modifier la valeur actuelle du pourcentage dans le modèle.
	 * @param value La nouvelle valeur du pourcentage
	 */
	public void setValue(double value);
	
	/**
	 * Ajoute un élément implémentant l'interface PercentageValueListener
	 * à la liste des éléments surveillant le modèle.
	 * @param percentageValueListener L'élément de type ValueListener à ajouter à la liste
	 */
	public void addPercentageValueListener(PercentageValueListener percentageValueListener);
	
	/**
	 * Retire un élément implémentant l'interface PercentageValueListener
	 * de la liste des éléments surveillant le modèle.
	 * @param percentageValueListener L'élément de type ValueListener à retirer de la liste
	 */
	public void removePercentageValueListener(PercentageValueListener percentageValueListener);
	
	/**
	 * Prévient le modèle que la valeur actuelle du pourcentage à changé. 
	 * @param value La nouvelle valeur du pourcentage
	 */
	public void notifyValueChanged(double value);
}
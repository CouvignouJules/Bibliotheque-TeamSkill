package fr.ynov.biblioskill.utilitaire;

/**
 * 
 * @author TeamSkill
 * Liste les différents DAO
 */
public enum DaoEnum {
	AUTEUR(1),CATEGORIE(2),LIVRE(3),PERSONNE(4),PRET(5),UTILISATEUR(6);
	private int daoEnum;
	
	/**
	 * ctor
	 * @param daoEnum
	 */
	private DaoEnum(int daoEnum) {
		this.daoEnum = daoEnum;
	}
	
	/**
	 * 
	 * @return le type de dao
	 */
	public int getDaoEnum() {
		return daoEnum;
	}
}
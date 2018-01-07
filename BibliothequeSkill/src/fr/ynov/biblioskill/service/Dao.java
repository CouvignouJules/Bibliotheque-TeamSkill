package fr.ynov.biblioskill.service;

import java.util.List;

public interface Dao<T> {
	public List<T> lireTous();
	public T lire(Long cle);
	public void inserer(T elt);
	public void update(Long index, T obj);
	public default void update(T obj) {}
	public void effacer(Long cle);
}

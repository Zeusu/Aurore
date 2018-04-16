package net.aurore.entities;

public class Context<E>{

	private E item;
	
	public Context(E e){
		item = e;
	}
	
	public E getItem(){
		return item;
	}
}

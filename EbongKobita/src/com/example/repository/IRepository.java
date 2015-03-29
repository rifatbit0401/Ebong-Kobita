package com.example.repository;

import java.util.List;

public interface IRepository<E> {

	public void insert(E e);
	public E get(int id);
	public List<E> get();
	
}

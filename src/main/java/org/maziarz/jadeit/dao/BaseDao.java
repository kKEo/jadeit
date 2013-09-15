package org.maziarz.jadeit.dao;

import java.util.List;

public interface BaseDao<T> {
	long count();
	List<T> list(final int offset, final int limit);
	T load(Long id);
	void save(T t);
}

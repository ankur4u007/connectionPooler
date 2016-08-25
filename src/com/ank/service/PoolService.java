package com.ank.service;

public interface PoolService<K> {

	public K getConnection();

	public boolean returnConnection(K connectionValue);

}

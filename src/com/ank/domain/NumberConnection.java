package com.ank.domain;

public interface NumberConnection<T, K> {

	NumberConnection<T, K> getNewPrevConnection(K value);
	
	K getValue();
	
	NumberConnection<T,K> getNext(boolean limit);
	
	void setNext(NumberConnection<T,K> connection);
	
}

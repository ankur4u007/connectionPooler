package com.ank.domain;

public interface Value<T> {

	T getIncrementedValue();
	
	T getValue();
	
	boolean isValidValue();
	
	int compare(T value);
	
	Integer getRoundedValue();
	
	boolean isNotEqualTo(T value);
	
	boolean isLessThan(T value);
	
	boolean isGreaterThan(T value);
	
	boolean isEqualTo(T value);
	
}

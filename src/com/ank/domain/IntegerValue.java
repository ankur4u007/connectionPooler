package com.ank.domain;

public class IntegerValue implements Value<IntegerValue> {
	
	public Integer value;
	
	public IntegerValue(Integer value) {
		this.value = value;
	}

	@Override
	public IntegerValue getIncrementedValue() {
		return new IntegerValue(value + 1);
	}

	@Override
	public IntegerValue getValue() {
		return this;
	}

	@Override
	public boolean isValidValue() {
		return value > 0;
	}

	@Override
	public Integer getRoundedValue() {
		return value;
	}

	@Override
	public int compare(IntegerValue value) {
		return value.compare(value);
	}

	@Override
	public boolean isNotEqualTo(IntegerValue value) {
		return this.value != value.getIntValue();
	}
	
	private int getIntValue(){
		return value;
	}

	@Override
	public boolean isLessThan(IntegerValue value) {
		return this.value < value.getIntValue();
	}

	@Override
	public boolean isGreaterThan(IntegerValue value) {
		return this.value > value.getIntValue();
	}

	@Override
	public boolean isEqualTo(IntegerValue value) {
		return !isNotEqualTo(value);
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	
}

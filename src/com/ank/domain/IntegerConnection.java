package com.ank.domain;

public class IntegerConnection implements NumberConnection<IntegerConnection, Value<IntegerValue>>{
	
	public NumberConnection<IntegerConnection, Value<IntegerValue>> next;
	public IntegerValue value;
	
	public IntegerConnection(IntegerConnection next, IntegerValue value) {
		this.next = next;
		this.value = value;
	}
	
	public IntegerConnection(IntegerValue value) {
		this.value = value;
	}

	public IntegerConnection getNewPrevConnection(Value<IntegerValue> value){
		return new IntegerConnection(null, value.getValue());
	}
	
	public IntegerValue getValue(){
		return value;
	}

	@Override
	public NumberConnection<IntegerConnection, Value<IntegerValue>> getNext() {
		if(next != null) {
			return next;
		} else {
			return getNewConnection();
		}
	}

	@Override
	public void setNext(NumberConnection<IntegerConnection, Value<IntegerValue>> connection) {
		this.next = connection;
	}	

	private IntegerConnection getNewConnection(){
		return new IntegerConnection(null, value.getIncrementedValue());
	}
}


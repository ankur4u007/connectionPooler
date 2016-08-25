package com.ank.domain;

public class Pool<T,K> {

	private NumberConnection<T, Value<K>> connection;
	private Integer maxSize;
	
	public Pool(NumberConnection<T, Value<K>> connection, Integer maxSize) {
		this.connection = connection;
		this.maxSize = maxSize;
	}

	public Value<K> getConnectionValue(){
		
		NumberConnection<T, Value<K>>  newConnection = connection.getNext();
		Value<K> oldConnectionValue = connection.getValue();
		this.connection = newConnection;
		return oldConnectionValue;
	}
	
	public boolean returnConnection(Value<K> connectionValue) {
		boolean toReturn = false;
		if (isValidReturn(connectionValue)) {
			NumberConnection<T, Value<K>> firstConnection = this.connection;
			NumberConnection<T, Value<K>> prevConnection = firstConnection;
			while (connection != null) {
				if (connection.getValue().isGreaterThan(connectionValue.getValue())) {
					NumberConnection<T, Value<K>> newPrevConnection = connection.getNewPrevConnection(connectionValue);
					newPrevConnection.setNext(connection);
					if(prevConnection.getValue().isLessThan(newPrevConnection.getValue().getValue())) {
						prevConnection.setNext(newPrevConnection);
					}
					if (firstConnection.getValue().isLessThan(newPrevConnection.getValue().getValue())) {
						this.connection = firstConnection;
					} else {
						this.connection = newPrevConnection;
					}
					toReturn = true;
					break;
				} else if (connection.getValue().isLessThan(connectionValue.getValue())) {
					prevConnection = this.connection;
					this.connection = this.connection.getNext();
				} else if (connection.getValue().isEqualTo(connectionValue.getValue())) {
					toReturn = false;
					this.connection = firstConnection;
					break;
				}
			}
		} 
		return toReturn;
	}
	
	private boolean isValidReturn(Value<K> connectionValue) {
		if (connectionValue.isValidValue() && maxSize >= connectionValue.getRoundedValue()
				&& connection.getValue().isNotEqualTo(connectionValue.getValue())) {
			return true;
		} else {
			return false;
		}
	}
	
}

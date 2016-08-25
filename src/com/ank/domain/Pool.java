package com.ank.domain;

public class Pool<T,K> {

	private NumberConnection<T, Value<K>> connection;
	private Integer maxSize;
	private Integer currentSize;
	
	public Pool(NumberConnection<T, Value<K>> connection, Integer maxSize) {
		this.connection = connection;
		this.maxSize = maxSize;
		if(connection != null) {
			currentSize = 1;
		}
	}

	public Value<K> getConnectionValue(){
		if(currentSize > maxSize) {
			return null;
		}
		NumberConnection<T, Value<K>>  newConnection = connection.getNext(false);
		Value<K> oldConnectionValue = connection.getValue();
		this.connection = newConnection;
		currentSize++;
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
					currentSize --;
					break;
				} else if (connection.getValue().isLessThan(connectionValue.getValue())) {
					prevConnection = this.connection;
					this.connection = this.connection.getNext(true);
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

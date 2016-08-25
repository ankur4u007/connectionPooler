package com.ank.service.impl;

import com.ank.domain.IntegerConnection;
import com.ank.domain.IntegerValue;
import com.ank.domain.NumberConnection;
import com.ank.domain.Pool;
import com.ank.domain.Value;
import com.ank.service.PoolService;

public class IntegerPoolServiceImpl implements PoolService<IntegerValue> {
	
	private Pool<IntegerConnection, IntegerValue> connectionPool;
	
	private IntegerPoolServiceImpl(Integer maxPoolSize) {
		IntegerValue integerValue = new IntegerValue(1);
		NumberConnection<IntegerConnection, Value<IntegerValue>> firstConnection = new IntegerConnection(integerValue);
		connectionPool = new Pool<IntegerConnection, IntegerValue>(firstConnection, maxPoolSize);
	}

	public static IntegerPoolServiceImpl init(Integer maxPoolSize){
		return new IntegerPoolServiceImpl(maxPoolSize);
	}
	
	public IntegerValue getConnection(){
		 Value<IntegerValue> value = connectionPool.getConnectionValue();
		 if(value != null) {
			 return value.getValue();
		 } else {
			 throw new RuntimeException("Max Connection Pool Size Limit Reached");
		 }
	}
	
	public boolean returnConnection(IntegerValue connectionValue){
		return connectionPool.returnConnection(connectionValue);
	}

}

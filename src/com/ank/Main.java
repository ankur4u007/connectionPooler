package com.ank;

import com.ank.domain.IntegerValue;
import com.ank.service.PoolService;
import com.ank.service.impl.IntegerPoolServiceImpl;

public class Main {

	public static void main(String[] args) {
		PoolService<IntegerValue> poolService = IntegerPoolServiceImpl.init(1000);
		IntegerValue connection1 = poolService.getConnection();
		IntegerValue connection2 = poolService.getConnection();
		IntegerValue connection3 = poolService.getConnection();
		System.out.println("Got Connection " + connection1 + " " + connection2 + " " +connection3);
		System.out.println("Return Connection "+ connection2 +" "+ poolService.returnConnection(connection2));
		System.out.println("Got Connection " +poolService.getConnection());
		System.out.println("Got Connection "+poolService.getConnection());
		System.out.println("Return Connection "+ connection1 +" "+  poolService.returnConnection(connection1));
		System.out.println("Return Connection 5 " + poolService.returnConnection(new IntegerValue(5)));
		System.out.println("Got Connection " +poolService.getConnection());
		System.out.println("Got Connection " +poolService.getConnection());
		System.out.println("Return Connection 1 " + poolService.returnConnection(new IntegerValue(1)));
		System.out.println("Return Connection 2 " + poolService.returnConnection(new IntegerValue(2)));
		System.out.println("Return Connection 3 " + poolService.returnConnection(new IntegerValue(3)));
		System.out.println("Return Connection 4 " + poolService.returnConnection(new IntegerValue(4)));
		System.out.println("Return Connection 5 " + poolService.returnConnection(new IntegerValue(5)));
		System.out.println("Got Connection " +poolService.getConnection());
		System.out.println("Got Connection " +poolService.getConnection());
		System.out.println("Got Connection " +poolService.getConnection());
		System.out.println("Got Connection " +poolService.getConnection());
		System.out.println("Got Connection " +poolService.getConnection());
		System.out.println("Got Connection " +poolService.getConnection());
		
	}
}

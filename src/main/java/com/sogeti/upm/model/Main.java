package com.sogeti.upm.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.h2.jdbcx.JdbcConnectionPool;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.sogeti.upm.dao.BaseDAO;
import com.sogeti.upm.service.ServiceTemp;
import com.sogeti.upm.spring.AppConfig;

public class Main {

	public static void main(String[] args) {
		
//		JdbcConnectionPool cp = JdbcConnectionPool.create("jdbc:h2:~/test", "sa", "");
////	         for (String sql : args) {
//	             Connection conn;
//				try {
//					conn = cp.getConnection();
//		             conn.createStatement().execute("create table test2(name varchar(100))");
//		             conn.close();
//
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
////	         }
//	         cp.dispose();
	     
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
		ServiceTemp dao = context.getBean(ServiceTemp.class);
        Address address = new Address();
        
        address.setCity("city");
        address.setCountry("country");
        address.setHouseNo(1234);
        States states = new States();
        states.setStateName("CG");
        address.setStates(states);
        address.setStreet("street");
        
        User user = new User();
//        user.setAddress(address);
        user.setEmailId("emailId");
//        user.setImage(new JdbcBlob(null, null, 1));
//        user.setLoginId("loginId");
        user.setPassword("password");
        user.setUserName("userName");
      address.setUser(user);
     
      dao.persist(address);
        UserOTP userOTP = new UserOTP();
        userOTP.setDateTime(new Date());
        userOTP.setOtp("dsdaslkdasjda");
//        userOTP.setFkUserId(dao.get);
        
        dao.persist(userOTP);
       
        System.out.println(dao.get(User.class, "1"));
        user.setUserName("Abdul Shakil Khan");
        dao.update(user);
        System.out.println(dao.get(User.class, "1"));
        context.close();

	}

}

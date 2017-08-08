package test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;







public class Test {
	public static void main(String[] args) {/*
		boolean isAdmin=false;
		String levelCode="G1";
		if(!isAdmin && !levelCode.equalsIgnoreCase("F1") && !levelCode.equalsIgnoreCase("H1")) {
			System.err.println("正选!");
        	
		}
		if( !isAdmin &&(levelCode.equalsIgnoreCase("G1") || levelCode.equalsIgnoreCase("J1")|| levelCode.equalsIgnoreCase("E1"))) {
			System.err.println("反选!");
        	
		}	
		Calendar c = Calendar.getInstance();
		System.out.println(c.get(Calendar.HOUR_OF_DAY));
		Date date = new Date();
		System.out.println(new Date().getHours());
		if(!(c.get(Calendar.HOUR_OF_DAY)>=21&&c.get(Calendar.HOUR_OF_DAY)<=23)){
			System.out.println("---");
			
		}
	*/
/*		 Map<String, Users> allList = new HashMap<String, Users>();
		 Users users = new Users();
		 users.setAges("12");
		 users.setNames("cui");
		 allList.put("1001", users);
		 Users users2 = new Users();
		 users2.setAges("13");
		 users2.setNames("jia");
		 allList.put("1002", users2);
		 Users users3 = allList.get("1001");
		 users3.setNames("qi");
		 Users users4 = new Users();
		 users4.setAges("15");
		 users4.setNames("cc");
		 
		 allList.put("1001", users);
		 System.out.println(allList.get("1001").getNames());*/
		 
	/*	 List<Users> userList = new CopyOnWriteArrayList<>();
		 Users users = new Users();
		 users.setAges("12");
		 users.setNames("cui");
		
		 Users users2 = new Users();
		 users2.setAges("13");
		 users2.setNames("jia");
		 userList.add(users);
		 userList.add(users2);
		 Users user3 = userList.get(0);
		 System.out.println(user3.getNames());
		 user3.setNames("qi");
		 System.out.println(userList.get(0).getNames());*/
		/*BigDecimal total = new BigDecimal("2.00");
		System.out.println(total.compareTo(BigDecimal.ZERO));*/
		String month = "201707";
		int year = Integer.parseInt(month.substring(0,4));
		int cmonth = Integer.parseInt(month.substring(4,6));
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR,year);
		c.set(Calendar.MONTH,cmonth);
		c.set(Calendar.DATE,0);
//		c.add(Calendar.MONTH,1);
		System.out.println(c.getTime());
	
	}

}

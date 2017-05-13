package exam08;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserDaoTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		
		UserDao dao = context.getBean("userDao",UserDao.class);
		System.out.println(dao.get("shlee"));
		System.out.println(dao.get("shlee"));
		System.out.println(dao.get("shlee"));
		System.out.println(dao.get("shlee"));
		System.out.println(dao.get("shlee"));
		System.out.println(dao.get("shlee"));
		
		CountConn count = context.getBean("countConnection",CountConn.class);
		count.showCount();
		
	}

}

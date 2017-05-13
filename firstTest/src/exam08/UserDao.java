package exam08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import vo.User;

// open closed principle
// 클래스와 모듈은 확장에는 열려있어야하고 변화에는 닫혀 있어야 한다

//높은 응집도 낮은 결합도
//응집도가 높다 변화가 일어날 때 해당 클래스나 모듈에서 변화는 부분이 크다
//결합도가 낮다 책임과 관심사가 다른 오브젝트나 모듈에 느슨한 변경을 유지한다.

//전략패턴
// 자신의 기능 맥락에서 필요에 따라 변경이
//필요한 알고리즘을 인터페이스를 통해  통째로 외부로 분리하여 인터페이스를
// 구현한 구체적인 클래스를 필요에 따라서 바꿔서 사용 할 수있게 해주는 
//디자인 패턴. 결과적으로 독립적인 


// abstract 클래스 상속 - overriding 위험이 있다.
public class UserDao {

	/*
	 *  UserDao 클래스는 Bean
	 *  항상 싱글톤 패턴으로 객체가 만들어지는 클래스
	 *  
	 *  승글톤 패턴으로 객체를 만들기 위해서는 무상태 클래스가 되어야한다.
	 */
	
	
	
	private ConnectionMaker scm =null;
	
	public UserDao(ConnectionMaker scm) {
		this.scm = scm;
	}
	public UserDao(){
		//생성자에서 주입을 받을 수단이 없기 때문에
		// UserDao가 스스로 의존성을 검색한다.
		// dependency lookup
		// 스프링 프레임워크로부터 이ㄹ
		
//		DaoFactory deDaoFactory = new DaoFactory();
//		this.scm = deDaoFactory.connectionMaker();
		
	}
	
	public ConnectionMaker getScm() {
		return scm;
	}

	public void setScm(ConnectionMaker scm) {
		this.scm = scm;
	}


	public void add(User user) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO TB_USER(USERID, USERPW, USERNAME,EMAIL,JOINDATE) VALUES(?,?,?,'email',sysdate)";
		try (Connection conn = scm.makeConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {

			ps.setString(1, user.getUserid());
			ps.setString(2, user.getUserpw());
			ps.setString(3, user.getUsername());
			ps.executeQuery();

		}
	}// add

	public User get(String userid) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM TB_USER WHERE USERID = ?";
		try (Connection conn = scm.makeConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {

			ps.setString(1, userid);
			try (ResultSet rs = ps.executeQuery();) {
				User user = null;

				if (rs.next()) {
					user = new User();
					user.setUserid(rs.getString("userid"));
					user.setUserpw(rs.getString("userpw"));
					user.setUsername(rs.getString("username"));
				}

				return user;
			}
		}

	}// get


}

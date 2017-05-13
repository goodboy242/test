package exam08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import vo.User;

// open closed principle
// Ŭ������ ����� Ȯ�忡�� �����־���ϰ� ��ȭ���� ���� �־�� �Ѵ�

//���� ������ ���� ���յ�
//�������� ���� ��ȭ�� �Ͼ �� �ش� Ŭ������ ��⿡�� ��ȭ�� �κ��� ũ��
//���յ��� ���� å�Ӱ� ���ɻ簡 �ٸ� ������Ʈ�� ��⿡ ������ ������ �����Ѵ�.

//��������
// �ڽ��� ��� �ƶ����� �ʿ信 ���� ������
//�ʿ��� �˰����� �������̽��� ����  ��°�� �ܺη� �и��Ͽ� �������̽���
// ������ ��ü���� Ŭ������ �ʿ信 ���� �ٲ㼭 ��� �� ���ְ� ���ִ� 
//������ ����. ��������� �������� 


// abstract Ŭ���� ��� - overriding ������ �ִ�.
public class UserDao {

	/*
	 *  UserDao Ŭ������ Bean
	 *  �׻� �̱��� �������� ��ü�� ��������� Ŭ����
	 *  
	 *  �±��� �������� ��ü�� ����� ���ؼ��� ������ Ŭ������ �Ǿ���Ѵ�.
	 */
	
	
	
	private ConnectionMaker scm =null;
	
	public UserDao(ConnectionMaker scm) {
		this.scm = scm;
	}
	public UserDao(){
		//�����ڿ��� ������ ���� ������ ���� ������
		// UserDao�� ������ �������� �˻��Ѵ�.
		// dependency lookup
		// ������ �����ӿ�ũ�κ��� �̤�
		
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

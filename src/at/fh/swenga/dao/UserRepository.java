package at.fh.swenga.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.model.UserModel;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<UserModel, Integer>{
	
	UserModel findByUserId(long id);
	List<UserModel> findByUsername(String name);
}
	

	
	
//	public static void connection(){
//			List<UserModel> userList = new ArrayList <UserModel>();
//			String host = "jdbc:mysql://10.25.2.109:3306/IMA15_fortmuelle_project_1";
//			
//			Connection conn = null;
//			PreparedStatement stmt = null;
//			
//			//PreparedStatement pst = conn.prepareStatement("SELECT * FROM USER WHERE username =?");
//			//ResultSet rs = pst.executeQuery();
//			
//			try{
//				conn = DriverManager.getConnection(host, "IMA15_fortmuelle", "Togepri15");
//				stmt = conn.prepareStatement("SELECT * FROM USER");
//				ResultSet result = stmt.executeQuery();
//				while(result.next()) {
//					UserModel user = new UserModel();
//					String userId = result.getString(1);
//					String email_address = result.getString(3);
//					String username = result.getString(14);
//					System.out.println(username);
//					userList.add(user);
//				}
//
//			}
//			finally {
//				if (stmt != null) {
//					try{
//						stmt.close();
//					} catch (SQLException ex) {
//						
//					}
//				}
//			if (conn != null) {
//				try{
//					conn.close();
//				} catch (SQLException ex) {
//					
//				}
//			}
//		
//
//			}
//
//	}
//	return userList;
//
//	}
	



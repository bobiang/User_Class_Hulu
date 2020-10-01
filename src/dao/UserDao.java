package dao;
import pojo.HuluClassUser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

public class UserDao {
    private Connection connect;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    public void UserDao() {
        try {
			Class.forName("com.mysql.jdbc.Driver");
	        // Setup the connection with the DB
	        connect = DriverManager
	                .getConnection("jdbc:mysql://localhost:3306/test?"
	                        + "user=user&password=password");

	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
	//create
	public void create(HuluClassUser user) {
		try {
			statement = connect.createStatement();
			preparedStatement=connect.prepareStatement("INSERT INTO user VALUES (NULL, ?, ?, ?) ");
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	//update
	public void update(int i, HuluClassUser user) {
		try {
			statement = connect.createStatement();
			preparedStatement=connect.prepareStatement("UPDATE user set PASSWORD=? where EMAIL =?");
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(1, user.getPassword());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	//read
	public void read(){
		
		try {
			statement = connect.createStatement();
			preparedStatement=connect.prepareStatement("SELECT * from user");
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1)+rs.getNString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//delete
	public void delete(HuluClassUser user) {
		try {
			statement = connect.createStatement();
			preparedStatement=connect.prepareStatement("delete from user where EMAIL = ? and PASSWORD = ?");
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(1, user.getPassword());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}

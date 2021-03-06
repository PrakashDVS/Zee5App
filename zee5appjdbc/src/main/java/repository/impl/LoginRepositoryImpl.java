package repository.impl;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import dto.Login;
import dto.ROLE;
import repository.LoginRepository;
import repository.UserRepository;
import utils.DBUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepositoryImpl implements LoginRepository {

//	DBUtils dbUtils = null;
//	private static LoginRepository loginRepository;
@Autowired
DataSource  dataSource;
	private LoginRepositoryImpl() throws IOException {
//		dbUtils = DBUtils.getInstance();
	}

//	public static LoginRepository getInstance() throws IOException {
//		if (loginRepository == null)
//			loginRepository = new LoginRepositoryImpl();
//		return loginRepository;
//	}

	@Override
	public String addCredentials(Login login) {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		PreparedStatement preparedStatement;

		String insertStatetment = "insert into login (userName,password,regId,role) values(?,?,?,?)";

		try {
			preparedStatement = connection.prepareStatement(insertStatetment);
			preparedStatement.setString(1, login.getUserName());
			preparedStatement.setString(2, login.getPassword());
			preparedStatement.setString(3, login.getRegId());
			preparedStatement.setString(4, login.getRole().toString());

			int result = preparedStatement.executeUpdate();
			// the no of rows afftected by the DML statement
			// 1 : one row is inserted
			//
			if (result > 0) {
				connection.commit();
				return "success";
			} else {
				connection.rollback();
				return "fail";
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "fail";
		}

	}

	@Override
	public String deleteCredentials(String userName) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String deleteStatetment = "delete from login where userName=?";
		try{
			connection = dataSource.getConnection();
		}
		catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			preparedStatement = connection.prepareStatement(deleteStatetment);
			preparedStatement.setString(1, userName);

			int result = preparedStatement.executeUpdate();

			if (result > 0) {
				connection.commit();
				return "success";
			} else {
				connection.rollback();
				return "fail";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "fail";
		} 
	}
//		finally {
//			dbUtils.closeConnection(connection);
//		}
//	}

	@Override
	public String changePassword(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeRole(String userName, ROLE role) {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String updateStmt = "UPDATE login set role=? WHERE userName = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(updateStmt);
			preparedStatement.setString(1, role.toString());
			preparedStatement.setString(2, userName);
			int result = preparedStatement.executeUpdate();

			if (result > 0) {
				connection.commit();
				return "success";
			} else {
				connection.rollback();
				return "fail";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "fail";
		} 
//		finally {
//			dbUtils.closeConnection(connection);
//		}
	}

}
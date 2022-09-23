package com.vti.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vti.entiy.Account;
import com.vti.entiy.Department;
import com.vti.utils.ApplicationUltils;
import com.vti.utils.JDBCUtils;

public class AccountRepository implements IAccountRepository {

	private IDepartmentRepository departmentRepository;

	public AccountRepository() {
		departmentRepository = new DepartmentRepository();
	}

	@Override
	public List<Account> getAccountList() throws SQLException, ClassNotFoundException, ParseException {

		List<Account> accountList = new ArrayList<>();

		Connection connection = JDBCUtils.getConnection();

		String sql = "SELECT * FROM `account`";
		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			// lay department theo id
			Department department = departmentRepository.getDepartmentById((byte) resultSet.getInt("department_id"));

			String dateString = resultSet.getString("create_date");
			// chuyen string sang date
			Date date = ApplicationUltils.getDateByString(dateString);

			System.out.println(date);
			Account account = new Account(resultSet.getInt("account_id"), resultSet.getString("email"),
					resultSet.getString("user_name"), resultSet.getString("email"), resultSet.getString("password"),
					department, date);
			accountList.add(account);
		}
		JDBCUtils.disconnect();
		return accountList;
	}

	@Override
	public Account getAccountById(int id) throws SQLException, ClassNotFoundException, ParseException {
		Connection connection = JDBCUtils.getConnection();

		String sql = "SELECT * FROM `account` WHERE account_id = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setInt(1, id);

		ResultSet resultSet = preparedStatement.executeQuery();
		JDBCUtils.disconnect();
		if (resultSet.next()) {
			// lay department theo id
			Department department = departmentRepository.getDepartmentById((byte) resultSet.getInt("department_id"));
			String dateString = resultSet.getString("create_date");
			// chuyen string sang date
			Date date = ApplicationUltils.getDateByString(dateString);
			Account account = new Account(resultSet.getInt("account_id"), resultSet.getString("email"),
					resultSet.getString("user_name"), resultSet.getString("email"), resultSet.getString("password"),
					department, date);
			return account;
		} else {
			return null;
		}
	}

	@Override
	public boolean isAccountNameExists(String name) throws SQLException, ClassNotFoundException {
		Connection connection = JDBCUtils.getConnection();
		String sql = "SELECT * FROM account WHERE account_name = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isAccountIdExists(int id) throws SQLException, ClassNotFoundException {
		Connection connection = JDBCUtils.getConnection();
		String sql = "SELECT * FROM account WHERE account_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void createAccount(String email, String userName, String password, String fullName, byte departmentId)
			throws ClassNotFoundException, SQLException {
		Connection connection = JDBCUtils.getConnection();
		String sql = "INSERT INTO `account` (`email`, user_name,`password`, full_name, department_id) \r\n"
				+ "VALUE(?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, userName);
		preparedStatement.setString(3, password);
		preparedStatement.setString(4, fullName);
		preparedStatement.setByte(5, departmentId);
		int count = preparedStatement.executeUpdate();
		if (count > 0) {
			System.out.println("them account thanh cong!");
		}
		JDBCUtils.disconnect();
	}

	@Override
	public void updateAccount(int id, String email, String userName, String password, String fullName,
			byte departmentId) throws SQLException, ClassNotFoundException {
		Connection connection = JDBCUtils.getConnection();
		String sql = "UPDATE `account` Set `email = ?, user_name = ?, `password` = ?, full_name = ?, department_id = 1 WHERE account_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, userName);
		preparedStatement.setString(3, password);
		preparedStatement.setString(4, fullName);
		preparedStatement.setByte(5, departmentId);
		preparedStatement.setInt(6, id);
		int count = preparedStatement.executeUpdate();
		if (count >0) {
			System.out.println("cap nhat account thanh cong!");
		}
		JDBCUtils.disconnect();

	}

	@Override
	public void deleteAccount(int id) throws SQLException, ClassNotFoundException {
		Connection connection = JDBCUtils.getConnection();
		String sql = "DELETE FROM `account` WHERE account_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		int count = preparedStatement.executeUpdate(); 
		if (count > 0) {
			System.out.println("xoa account thanh cong!");
		}
		JDBCUtils.disconnect();
	}

}

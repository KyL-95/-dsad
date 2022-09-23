package com.vti.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.vti.entiy.Department;
import com.vti.utils.JDBCUtils;

public class DepartmentRepository implements IDepartmentRepository {

	@Override
	public List<Department> getDepartmentList() throws SQLException, ClassNotFoundException {

		List<Department> departmentList = new ArrayList<>();

		Connection connection = JDBCUtils.getConnection();

		String sql = "SELECT department_id, department_name FROM department";
		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			Department department = new Department((byte) resultSet.getInt("department_id"),
					resultSet.getString("department_name"));
			departmentList.add(department);

		}
		JDBCUtils.disconnect();
		return departmentList;
	}

	@Override
	public Department getDepartmentById(byte id) throws SQLException, ClassNotFoundException {
		Connection connection = JDBCUtils.getConnection();

		String sql = "SELECT department_id, department_name FROM department WHERE department_id = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setInt(1, id);

		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Department department = new Department((byte) resultSet.getInt("department_id"),
					resultSet.getString("department_name"));
			return department;
		} else {
			return null;
		}
	}

	@Override
	public boolean isDepartmentNameExists(String name) throws SQLException, ClassNotFoundException {
		Connection connection = JDBCUtils.getConnection();
		String sql = "SELECT * FROM department WHERE department_name = ?";
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
	public boolean isDepartmentIdExists(byte id) throws SQLException, ClassNotFoundException {
		Connection connection = JDBCUtils.getConnection();
		String sql = "SELECT * FROM department WHERE department_id = ?";
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
	public void createDepartment(String name) throws ClassNotFoundException, SQLException {
		Connection connection = JDBCUtils.getConnection();
		String sql = "INSERT INTO department(department_name) VALUE (?) ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
		int count = preparedStatement.executeUpdate();
		if (count > 0) {
			System.out.println("them department thanh cong!");
		}
		JDBCUtils.disconnect();
	}

	@Override
	public void updateDepartment(int id, String name) throws SQLException, ClassNotFoundException {
		Connection connection = JDBCUtils.getConnection();
		String sql = "UPDATE department SET department_name = ? WHERE department_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, id);
		int count = preparedStatement.executeUpdate();
		if (count > 0) {
			System.out.println("cap nhat department thanh cong!");
		}
		JDBCUtils.disconnect();
	}

	@Override
	public void deleteDepartment(int id) throws SQLException, ClassNotFoundException {
		Connection connection = JDBCUtils.getConnection();
		String sql = "DELETE FROM department WHERE department_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		int count = preparedStatement.executeUpdate();
		if (count > 0) {
			System.out.println("xoa department thanh cong!");
		}
		JDBCUtils.disconnect();
	}

}

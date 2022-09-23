package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entiy.Department;

public interface IDepartmentRepository {
	//Lấy danh sách department
	public List<Department> getDepartmentList() throws SQLException, ClassNotFoundException;
	
	//Lấy phòng ban theo id
	public Department getDepartmentById(byte id) throws SQLException, ClassNotFoundException;

	//kiểm tra department có tồn tại theo name
	public boolean isDepartmentNameExists(String name) throws SQLException, ClassNotFoundException;

	//kiểm tra department có tồn tại theo id
	public boolean isDepartmentIdExists(byte id) throws SQLException, ClassNotFoundException;

	//tạo mới deparment
	public void createDepartment(String name) throws SQLException, ClassNotFoundException;

	//cập nhật name của department theo id
	public void updateDepartment(int id, String name) throws SQLException, ClassNotFoundException;

	// xóa department theo id
	public void deleteDepartment(int id) throws SQLException, ClassNotFoundException;
		 

}

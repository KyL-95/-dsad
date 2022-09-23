package com.vti.backend.presentationlayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.DepartmentService;
import com.vti.backend.businesslayer.IDepartmentService;
import com.vti.entiy.Department;

public class DepartmentController {

	private IDepartmentService departmentService;

	public DepartmentController() {
		departmentService = new DepartmentService();
	}

	public List<Department> getDepartmentList() throws SQLException, ClassNotFoundException {
		return departmentService.getDepartmentList();
	}

	public Department getDepartmentById(byte id) throws SQLException, ClassNotFoundException {
		return departmentService.getDepartmentById(id);
	}

	public void createDepartment(String name) throws Exception {
		departmentService.createDepartment(name);
	}

	public void updateDepartment(byte id, String name) throws Exception {
		departmentService.updateDepartment(id, name);
	}

	public void deleteDepartment(byte id) throws Exception {
		departmentService.deleteDepartment(id);
	}
}

package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.DepartmentRepository;
import com.vti.backend.datalayer.IDepartmentRepository;
import com.vti.entiy.Department;

public class DepartmentService implements IDepartmentService {

	private IDepartmentRepository departmentRepository;

	public DepartmentService() {
		departmentRepository = new DepartmentRepository();
	}

	@Override
	public List<Department> getDepartmentList() throws SQLException, ClassNotFoundException {
		return departmentRepository.getDepartmentList();
	}

	@Override
	public Department getDepartmentById(byte id) throws SQLException, ClassNotFoundException {
		return departmentRepository.getDepartmentById(id);
	}

	@Override
	public boolean isDepartmentNameExists(String name) throws SQLException, ClassNotFoundException {
		return departmentRepository.isDepartmentNameExists(name);
	}

	@Override
	public boolean isDepartmentIdExists(byte id) throws SQLException, ClassNotFoundException {
		return departmentRepository.isDepartmentIdExists(id);
	}

	@Override
	public void createDepartment(String name) throws Exception {
		// validate data
		// kiem tra ten phong ban bi null hoac rong
		if (name == null || name.isEmpty()) {
			throw new Exception("Ten phong ban khong de trong!");
		}
		// kiem tra ten phong ban da ton tai trong database chua
		if (isDepartmentNameExists(name)) {
			throw new Exception("Ten phong ban da ton tai!");
		}
		departmentRepository.createDepartment(name);
	}

	@Override
	public void updateDepartment(byte id, String name) throws Exception {
		// validate data
		// kiem tra ten phong ban bi null hoac rong
		if (name == null || name.isEmpty()) {
			throw new Exception("Ten phong ban khong de trong!");
		}
		// kiem tra ten phong ban da ton tai trong database chua
		if (isDepartmentNameExists(name) == true) {
			throw new Exception("Ten phong ban da ton tai!");
		}
		departmentRepository.updateDepartment(id, name);
	}

	@Override
	public void deleteDepartment(byte id) throws Exception {
		// kiem tra ten department co ton tai theo id khong
		if (isDepartmentIdExists(id) == false) {
			throw new Exception("phong ban chua ton tai!");
		}
		departmentRepository.deleteDepartment(id);
	}

}

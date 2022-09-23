package com.vti.frontend;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.presentationlayer.DepartmentController;
import com.vti.entiy.Department;
import com.vti.utils.ScannerUtils;

public class DepartmentProgram {
	public static void main(String[] args) {
		try {
			DepartmentController departmentController = new DepartmentController();

			// lay danh sach department
			List<Department> departmentList = departmentController.getDepartmentList();

			for (Department department : departmentList) {
				System.out.println(department);
			}

			// tao department

			System.out.print("nhap name: ");
			String name = ScannerUtils.inputString();
			
			departmentController.createDepartment(name);

			// tìm department theo id
			System.out.println("Nhập vào id: ");

			int id = ScannerUtils.inputInt("Lỗi, nhập lại");
			Department department = departmentController.getDepartmentById((byte) id);
			System.out.println(department);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

package com.vti.frontend;

import java.sql.SQLException;

import com.vti.backend.presentationlayer.AccountController;
import com.vti.entiy.Account;
import com.vti.utils.ScannerUtils;

public class AccountProgram {
	public static void main(String[] args) {
		try {

			AccountController accountController = new AccountController();

//			// lay danh sach account
//			List<Account> accountList = accountController.getAccountList();
//
//			for (Account account : accountList) {
//				System.out.println(account);
//			}
//
//			// tao account
//
//			System.out.print("nhap email: ");
//			String email = ScannerUtils.inputString();
//
//			System.out.print("nhap userName: ");
//			String userName = ScannerUtils.inputString();
//
//			System.out.print("nhap password: ");
//			String password = ScannerUtils.inputString();
//
//			System.out.print("nhap fullName: ");
//			String fullName = ScannerUtils.inputString();
//
//			System.out.print("nhap departmentId: ");
//			int departmentId = ScannerUtils.inputInt("nhap loi! nhap lai!");
//
//			accountController.createAccount(email, userName, password, fullName, (byte) departmentId);

			// tìm account theo id
			System.out.println("Nhập vào id: ");

			int id = ScannerUtils.inputInt("Lỗi, nhập lại");
			Account account = accountController.getAccountById(id);
			System.out.println(account);

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

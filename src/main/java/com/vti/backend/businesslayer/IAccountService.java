package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.vti.entiy.Account;

public interface IAccountService {
	public List<Account> getAccountList() throws SQLException, ClassNotFoundException, ParseException;

	// Lấy phòng ban theo id
	public Account getAccountById(int id) throws SQLException, ClassNotFoundException, ParseException;

	// kiểm tra account có tồn tại theo name
	public boolean isAccountNameExists(String name) throws SQLException, ClassNotFoundException;

	// kiểm tra account có tồn tại theo id
	public boolean isAccountIdExists(int id) throws SQLException, ClassNotFoundException;

	// tạo mới deparment
	public void createAccount(String email, String userName, String password, String fullName,
			byte departmentId) throws SQLException, ClassNotFoundException;

	// cập nhật name của account theo id
	public void updateAccount(int id, String name, String email, String userName, String password, String fullName,
			byte departmentId) throws SQLException, ClassNotFoundException;

	// xóa account theo id
	public void deleteAccount(int id) throws SQLException, ClassNotFoundException, Exception;

}

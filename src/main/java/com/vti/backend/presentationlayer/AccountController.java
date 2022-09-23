package com.vti.backend.presentationlayer;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.vti.backend.businesslayer.AccountService;
import com.vti.backend.businesslayer.IAccountService;
import com.vti.entiy.Account;

public class AccountController {

	private IAccountService accountService;

	public AccountController() {
		accountService = new AccountService();
	}

	public List<Account> getAccountList() throws SQLException, ClassNotFoundException, ParseException {
		return accountService.getAccountList();
	}

	public Account getAccountById(int id) throws SQLException, ClassNotFoundException, ParseException {
		return accountService.getAccountById(id);
	}

	public void createAccount(String email, String userName, String password, String fullName,
			byte departmentId) throws Exception {
		accountService.createAccount(email, userName, password, fullName, departmentId);
	}

	public void updateAccount(int id, String name, String email, String userName, String password, String fullName,
			byte departmentId) throws Exception {
		accountService.updateAccount(id, name, email, userName, password, fullName, departmentId);
	}

	public void deleteAccount(byte id) throws Exception {
		accountService.deleteAccount(id);
	}
}

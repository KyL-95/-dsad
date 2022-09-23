package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vti.backend.datalayer.AccountRepository;
import com.vti.backend.datalayer.IAccountRepository;
import com.vti.entiy.Account;

public class AccountService implements IAccountService {

	private IAccountRepository accountRepository;

	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern
			.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public AccountService() {
		accountRepository = new AccountRepository();
	}

	@Override
	public List<Account> getAccountList() throws SQLException, ClassNotFoundException, ParseException {
		return accountRepository.getAccountList();
	}

	@Override
	public Account getAccountById(int id) throws SQLException, ClassNotFoundException, ParseException {
		return accountRepository.getAccountById(id);
	}

	@Override
	public boolean isAccountNameExists(String name) throws SQLException, ClassNotFoundException {
		return accountRepository.isAccountNameExists(name);
	}

	@Override
	public boolean isAccountIdExists(int id) throws SQLException, ClassNotFoundException {
		return accountRepository.isAccountIdExists(id);
	}

	@Override
	public void createAccount(String email, String userName, String password, String fullName,
			byte departmentId) throws SQLException, ClassNotFoundException {
		if (isEmailValid(email) == false) {
			System.out.println("Email: không đúng định dạng");
		} else if (password.length() < 6 || password.length() > 10) {
			System.out.println("Password: phải nhập từ 6-10 ký tự");
		} else if (password.matches(".*[A-Z].*") == false) {
			System.out.println("Password: Phải có ít nhất 1 ký tự viết hoa");
		} else {
			accountRepository.createAccount(email, userName, password, fullName, departmentId);
		}

	}

	// hàm để validate email nhập vào
	public static boolean isEmailValid(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

	@Override
	public void updateAccount(int id, String name, String email, String userName, String password, String fullName,
			byte departmentId) throws SQLException, ClassNotFoundException {
		if (isEmailValid(email) == false) {
			System.out.println("Email: không đúng định dạng");
		} else if (password.length() < 6 || password.length() > 10) {
			System.out.println("Password: phải nhập từ 6-10 ký tự");
		} else if (!password.matches(".*[A-Z].*") == false) {
			System.out.println("Password: Phải có ít nhất 1 ký tự viết hoa");
		} else {
			accountRepository.updateAccount(id, email, userName, password, fullName, departmentId);
		}

	}
 
	@Override
	public void deleteAccount(int id) throws Exception {
		// kiem tra ten account co ton tai theo id khong
		if (isAccountIdExists(id) == false) {
			throw new Exception("account chua ton tai!");
		}
		accountRepository.deleteAccount(id);
	}

}

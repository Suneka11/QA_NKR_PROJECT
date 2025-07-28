package com.pageObjectManager;

import com.pageObjectModel.LoginPageModel;
import com.utility.FileReaderManager;

public class PageObjectManager {

	private LoginPageModel login;
	private FileReaderManager reader;
	private static PageObjectManager manager;

	private PageObjectManager() {
	}

	public static PageObjectManager PageObjectmanager() {
		if (manager == null) {
			manager = new PageObjectManager();
		}
		return manager;
	}

	public LoginPageModel getLoginPageManager() {
		if (login == null) {
			login = new LoginPageModel();
		}
		return login;
	}

	public FileReaderManager getFileReaderManager() {
		if (reader == null) {
			reader = new FileReaderManager();
		}
		return reader;
	}
}

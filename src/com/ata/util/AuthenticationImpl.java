package com.ata.util;

import com.ata.bean.CredentialsBean;

public class AuthenticationImpl implements Authentication {

	@Override
	public boolean authenticate(CredentialsBean credentialsBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String authorize(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus) {
		// TODO Auto-generated method stub
		return false;
	}

}

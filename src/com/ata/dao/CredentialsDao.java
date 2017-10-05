package com.ata.dao;

import java.util.ArrayList;

import com.ata.bean.CredentialsBean;

public interface CredentialsDao {
	String createCredentials(CredentialsBean credentialsBean);
	int deleteCredentials(ArrayList<String> userIds);
	boolean updateCredentials(CredentialsBean credentialsBean);
	CredentialsBean findByid(String userId);
	ArrayList<CredentialsBean> findAll();

}

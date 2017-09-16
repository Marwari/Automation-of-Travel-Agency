package com.ata.dao;

import java.util.ArrayList;

import com.ata.bean.CredentialsBean;

public interface CredentialsDao {
	String createProfile(CredentialsBean credentialsBean);
	int deleteProfile(ArrayList<String> userIds);
	boolean updateProfile(CredentialsBean credentialsBean);
	CredentialsBean findByid(String userId);
	ArrayList<CredentialsBean> findAll();

}

package com.ata.dao;

import java.util.ArrayList;

import com.ata.bean.ProfileBean;

public interface ProfileDao {
	String createProfile(ProfileBean profileBean);
	int deleteProfile(ArrayList<String> userIds);
	boolean updateProfile(ProfileBean profileBean);
	ProfileBean findByid(String userId);
	ArrayList<ProfileBean> findAll();
}

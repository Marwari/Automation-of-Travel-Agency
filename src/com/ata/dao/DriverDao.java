package com.ata.dao;

import java.util.ArrayList;

import com.ata.bean.DriverBean;

public interface DriverDao {
	String createProfile(DriverBean driverBean);
	int deleteProfile(ArrayList<String> userIds);
	boolean updateProfile(DriverBean driverBean);
	DriverBean findByid(String driverId);
	ArrayList<DriverBean> findAll();
}

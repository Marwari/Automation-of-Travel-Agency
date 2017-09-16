package com.ata.dao;

import java.util.ArrayList;

import com.ata.bean.VehicleBean;


public interface VehicleDao {
	String createProfile(VehicleBean vehicleBean);
	int deleteProfile(ArrayList<String> userIds);
	boolean updateProfile(VehicleBean vehicleBean);
	VehicleBean findByid(String userId);
	ArrayList<VehicleBean> findAll();

}

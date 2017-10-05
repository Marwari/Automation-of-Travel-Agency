package com.ata.dao;

import java.util.ArrayList;

import com.ata.bean.VehicleBean;


public interface VehicleDao {
	String createVehicle(VehicleBean vehicleBean);
	int deleteVehicle(ArrayList<String> userIds);
	boolean updateVehicle(VehicleBean vehicleBean);
	VehicleBean findByid(String userId);
	ArrayList<VehicleBean> findAll();

}

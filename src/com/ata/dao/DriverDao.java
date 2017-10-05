package com.ata.dao;

import java.util.ArrayList;

import com.ata.bean.DriverBean;

public interface DriverDao {
	String createDriver(DriverBean driverBean);
	int deleteDriver(ArrayList<String> userIds);
	boolean updateDriver(DriverBean driverBean);
	DriverBean findByid(String driverId);
	ArrayList<DriverBean> findAll();
}

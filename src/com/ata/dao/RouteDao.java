package com.ata.dao;

import java.util.ArrayList;

import com.ata.bean.RouteBean;


public interface RouteDao {
	String createProfile(RouteBean routeBean);
	int deleteProfile(ArrayList<String> userIds);
	boolean updateProfile(RouteBean routeBean);
	RouteBean findByid(String userId);
	ArrayList<RouteBean> findAll();
}

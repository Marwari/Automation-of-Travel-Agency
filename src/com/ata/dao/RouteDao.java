package com.ata.dao;

import java.util.ArrayList;

import com.ata.bean.RouteBean;


public interface RouteDao {
	String createRoute(RouteBean routeBean);
	int deleteRoute(ArrayList<String> userIds);
	boolean updateRoute(RouteBean routeBean);
	RouteBean findByid(String userId);
	ArrayList<RouteBean> findAll();
}

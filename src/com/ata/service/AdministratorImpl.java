package com.ata.service;

import java.sql.Date;
import java.util.ArrayList;

import com.ata.bean.DriverBean;
import com.ata.bean.ReservationBean;
import com.ata.bean.RouteBean;
import com.ata.bean.VehicleBean;
import com.ata.dao.VehicleDao;
import com.ata.dao.VehicleDaoImpl;

public class AdministratorImpl implements Administrator {

	@Override
	public String addVehicle(VehicleBean vehicleBean) {
		VehicleDao vdao = new VehicleDaoImpl();
		String vehicle = vdao.createVehicle(vehicleBean);
		
		
		return vehicle;
	}

	@Override
	public int deleteVehicle(ArrayList<String> vehicleId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public VehicleBean viewVehicle(String VehicleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifyVehicle(VehicleBean vehicleBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String addDriver(DriverBean driverBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteDriver(ArrayList<String> driverId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean allotDriver(String reservationId, String driver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyDriver(DriverBean driverBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String addRoute(RouteBean routeBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteRoute(ArrayList<String> routeId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RouteBean viewRoute(String routeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifyRoute(RouteBean routeBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<ReservationBean> viewBookingDetails(Date journeyDate, String source, String destination) {
		// TODO Auto-generated method stub
		return null;
	}

}

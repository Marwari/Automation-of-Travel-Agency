package com.ata.service;

import java.util.ArrayList;

import com.ata.bean.ReservationBean;
import com.ata.bean.RouteBean;
import com.ata.bean.VehicleBean;

public class CustomerImpl implements Customer {

	@Override
	public ArrayList<VehicleBean> viewVehicleByType(String vehicleType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VehicleBean> viewVehicleBySeat(int noOfSeats) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RouteBean> viewAllroutes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String bookVehicle(ReservationBean reservationBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cancelBooking(String userId, String reservationId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ReservationBean viewBookingDetails(String reservationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReservationBean printBookingDetails(String reservationId) {
		// TODO Auto-generated method stub
		return null;
	}

}

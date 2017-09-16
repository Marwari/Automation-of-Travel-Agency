package com.ata.service;

import java.util.ArrayList;

import com.ata.bean.ReservationBean;
import com.ata.bean.RouteBean;
import com.ata.bean.VehicleBean;

public interface Customer {
	ArrayList<VehicleBean> viewVehicleByType(String vehicleType);
	ArrayList<VehicleBean> viewVehicleBySeat(int noOfSeats);
	ArrayList<RouteBean> viewAllroutes();
	String bookVehicle(ReservationBean reservationBean);
	boolean cancelBooking(String userId, String reservationId);
	ReservationBean viewBookingDetails(String reservationId);
	ReservationBean printBookingDetails(String reservationId);
}

package com.ata.dao;

import java.util.ArrayList;

import com.ata.bean.ReservationBean;


public interface ReservationDao {
	String createReservation(ReservationBean reservationBean);
	int deleteReservation(ArrayList<String> userIds);
	boolean updateReservation(ReservationBean reservationBean);
	ReservationBean findByid(String userId);
	ArrayList<ReservationBean> findAll();

}

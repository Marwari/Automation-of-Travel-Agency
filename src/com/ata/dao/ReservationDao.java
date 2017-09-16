package com.ata.dao;

import java.util.ArrayList;

import com.ata.bean.ReservationBean;


public interface ReservationDao {
	String createProfile(ReservationBean reservationBean);
	int deleteProfile(ArrayList<String> userIds);
	boolean updateProfile(ReservationBean reservationBean);
	ReservationBean findByid(String userId);
	ArrayList<ReservationBean> findAll();

}

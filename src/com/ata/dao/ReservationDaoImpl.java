package com.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ata.bean.ReservationBean;
import com.ata.util.DBUtil;

public class ReservationDaoImpl implements ReservationDao {
	Connection con= DBUtil.getConnection();

	@Override
	public String createProfile(ReservationBean reservationBean) {
		try{
			PreparedStatement ps=
					con.prepareStatement("insert into ata_tbl_reservation values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, reservationBean.getReservationId());
			ps.setString(2, reservationBean.getUserId());
			ps.setString(3, reservationBean.getVehicleId());
			ps.setString(4, reservationBean.getRouteId());
			ps.setString(5, reservationBean.getBookingDate());
			ps.setString(6, reservationBean.getJourneyDate());
			ps.setString(7, reservationBean.getDriverId());
			ps.setString(8, reservationBean.getBookingStatus());
			ps.setString(9, reservationBean.getTotalFare());
			ps.setString(10, reservationBean.getBoardingPoint());
			ps.setString(11, reservationBean.getDropPoint());
			int a=ps.executeUpdate();
			if(a>0)
				return "Reservation Created.";
			else
				return "Reservation Not Created.";
		} catch(SQLException e){
			e.printStackTrace();
		}
		return "Error"
	}

	@Override
	public int deleteProfile(ArrayList<String> userIds) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateProfile(ReservationBean reservationBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ReservationBean findByid(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReservationBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

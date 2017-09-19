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
			ps.setDate(5, reservationBean.getBookingDate());
			ps.setDate(6, reservationBean.getJourneyDate());
			ps.setString(7, reservationBean.getDriverId());
			ps.setString(8, reservationBean.getBookingStatus());
			ps.setDouble(9, reservationBean.getTotalFare());
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
		return "Error";
	}

	@Override
	public int deleteProfile(ArrayList<String> userIds) {
		int count=0;
		try {
			PreparedStatement ps=
					con.prepareStatement("delete * from ata_tbl_reservation where reservationid=?");
			for(int i=0;i<userIds.size();i++)
			{
				ps.setString(1, userIds.get(i));
				ps.executeQuery();
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public boolean updateProfile(ReservationBean reservationBean) {
		boolean flag=false;
		try {
			PreparedStatement ps=
					con.prepareStatement("update ata_tbl_reservation SET userid=?,vehicleid=?,routeid=?,bookingdate=?,journeydate=?,driverid=?,bookingstatus=?,totalfare=?,boardingpoint=?,droppoing=? where reservationrid=?");
			ps.setString(1, reservationBean.getUserId());
			ps.setString(2, reservationBean.getVehicleId());
			ps.setString(3, reservationBean.getRouteId());
			ps.setDate(4, reservationBean.getBookingDate());
			ps.setDate(5, reservationBean.getJourneyDate());
			ps.setString(6, reservationBean.getDriverId());
			ps.setString(7, reservationBean.getBookingStatus());
			ps.setDouble(8, reservationBean.getTotalFare());
			ps.setString(9, reservationBean.getBoardingPoint());
			ps.setString(10, reservationBean.getDropPoint());
			ps.setString(11, reservationBean.getReservationId());
			ps.executeUpdate();
			flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
			return flag;
		}
		return flag;	}

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

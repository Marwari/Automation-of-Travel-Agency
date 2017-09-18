package com.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ata.bean.VehicleBean;
import com.ata.util.DBUtil;

public class VehicleDaoImpl implements VehicleDao {
	Connection con= DBUtil.getConnection();

	@Override
	public String createProfile(VehicleBean vehicleBean) {
		try{
			PreparedStatement ps=
					con.prepareStatement("insert into ata_tbl_vehicle values(?,?,?,?,?,?)");
			ps.setString(1, vehicleBean.getVehicleId());
			ps.setString(2, vehicleBean.getName());
			ps.setString(3, vehicleBean.getType());
			ps.setString(4, vehicleBean.getRegistrationNumber());
			ps.setLong(5, vehicleBean.getSeatingCapacity());
			ps.setLong(6, (long) vehicleBean.getFarePerKM());
			int a=ps.executeUpdate();
			if(a>0)
				return "Vehicle Added.";
			else
				return "vehicle Not Added.";
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
					con.prepareStatement("delete * from ata_tbl_vehicle where userid=? ");
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
	public boolean updateProfile(VehicleBean vehicleBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public VehicleBean findByid(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VehicleBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

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
	public String createVehicle(VehicleBean vehicleBean) {
		try{
			PreparedStatement ps=
					con.prepareStatement("insert into ata_tbl_vehicle values(?,?,?,?,?,?)");
			ps.setString(1, vehicleBean.getVehicleId());
			ps.setString(2, vehicleBean.getName());
			ps.setString(3, vehicleBean.getType());
			ps.setString(4, vehicleBean.getRegistrationNumber());
			ps.setDouble(5, vehicleBean.getSeatingCapacity());
			ps.setDouble(6, vehicleBean.getFarePerKM());
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
	public int deleteVehicle(ArrayList<String> userIds) {
		int count=0;
		try {
			PreparedStatement ps=
					con.prepareStatement("delete * from ata_tbl_vehicle where vehicleid=? ");
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
	public boolean updateVehicle(VehicleBean vehicleBean) {
		boolean flag=false;
		try {
			PreparedStatement ps=
					con.prepareStatement("update ata_tbl_vehicle SET name=?,type=?,registrationnumber=?,seatingcapacity=?,fareperkm=? where vehicleid=?");
			ps.setString(1, vehicleBean.getName());
			ps.setString(2, vehicleBean.getType());
			ps.setString(3, vehicleBean.getRegistrationNumber());
			ps.setDouble(4, vehicleBean.getSeatingCapacity());
			ps.setDouble(5, vehicleBean.getFarePerKM());
			ps.setString(6, vehicleBean.getVehicleId());
			ps.executeUpdate();
			flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
			return flag;
		}
		return flag;	}

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

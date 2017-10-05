package com.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ata.bean.DriverBean;
import com.ata.util.DBUtil;

public class DriverDaoImpl implements DriverDao {
	Connection con= DBUtil.getConnection();

	@Override
	public String createDriver(DriverBean driverBean) {
		try{
			PreparedStatement ps=
					con.prepareStatement("insert into ata_tbl_driver values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, driverBean.getDriverId());
			ps.setString(2, driverBean.getName());
			ps.setString(3, driverBean.getStreet());
			ps.setString(4, driverBean.getLocation());
			ps.setString(5, driverBean.getCity());
			ps.setString(6, driverBean.getState());
			ps.setString(7, driverBean.getPincode());
			ps.setString(8, driverBean.getMobileNo());
			ps.setString(9, driverBean.getLicenseNumber());
			int a=ps.executeUpdate();
			if(a>0)
				return "Driver Created.";
			else
				return "Driver Not Created.";
		} catch(SQLException e){
			e.printStackTrace();
		}
		return "Error";
	}

	@Override
	public int deleteDriver(ArrayList<String> userIds) {
		int count=0;
		try {
			PreparedStatement ps=
					con.prepareStatement("delete * from ata_tbl_driver where driverid=?");
			for(int i=0;i<userIds.size();i++)
			{
				ps.setString(1, userIds.get(i));
				ps.executeQuery();
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;	}

	@Override
	public boolean updateDriver(DriverBean driverBean) {
		boolean flag=false;
		try {
			PreparedStatement ps=
					con.prepareStatement("update ata_tbl_driver SET name=?,street=?,location=?,city=?,state=?,mobileno=?,licensenumber=? where driverid=?");
			ps.setString(1, driverBean.getName());
			ps.setString(2, driverBean.getStreet());
			ps.setString(3, driverBean.getLocation());
			ps.setString(4, driverBean.getCity());
			ps.setString(5, driverBean.getState());
			ps.setString(6, driverBean.getMobileNo());
			ps.setString(7, driverBean.getLicenseNumber());
			ps.setString(8, driverBean.getDriverId());
			ps.executeUpdate();
			flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
			return flag;
		}
		return flag;
	}

	@Override
	public DriverBean findByid(String driverId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DriverBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

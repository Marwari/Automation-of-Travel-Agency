package com.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ata.bean.RouteBean;
import com.ata.util.DBUtil;

public class RouteDaoImpl implements RouteDao {
	Connection con= DBUtil.getConnection();

	@Override
	public String createProfile(RouteBean routeBean) {
		try{
			PreparedStatement ps=
					con.prepareStatement("insert into ata_tbl_route values(?,?,?,?,?)");
			ps.setString(1, routeBean.getRouteId());
			ps.setString(2, routeBean.getSource());
			ps.setString(3, routeBean.getDestination());
			ps.setLong(4, routeBean.getDistance());
			ps.setString(5, routeBean.getTravelDuration());
			int a=ps.executeUpdate();
			if(a>0)
				return "Route Created.";
			else
				return "Route Not Created.";
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
	public boolean updateProfile(RouteBean routeBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RouteBean findByid(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RouteBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

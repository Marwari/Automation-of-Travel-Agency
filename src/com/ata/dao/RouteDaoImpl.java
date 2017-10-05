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
	public String createRoute(RouteBean routeBean) {
		try{
			PreparedStatement ps=
					con.prepareStatement("insert into ata_tbl_route values(?,?,?,?,?)");
			ps.setString(1, routeBean.getRouteId());
			ps.setString(2, routeBean.getSource());
			ps.setString(3, routeBean.getDestination());
			ps.setDouble(4, routeBean.getDistance());
			ps.setDouble(5, routeBean.getTravelDuration());
			int a=ps.executeUpdate();
			if(a>0)
				return "Route Created.";
			else
				return "Route Not Created.";
		} catch(SQLException e){
			e.printStackTrace();
		}
		return "Error";
	}

	@Override
	public int deleteRoute(ArrayList<String> userIds) {
		int count=0;
		try {
			PreparedStatement ps=
					con.prepareStatement("delete * from ata_tbl_route where routeid=?");
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
	public boolean updateRoute(RouteBean routeBean) {
		boolean flag=false;
		try {
			PreparedStatement ps=
					con.prepareStatement("update ata_tbl_user_Route SET source=?,destination=?,distance=?,travelduration=? where routeid=?");
			ps.setString(1, routeBean.getSource());
			ps.setString(2, routeBean.getDestination());
			ps.setDouble(3, routeBean.getDistance());
			ps.setDouble(4, routeBean.getTravelDuration());
			ps.setString(5, routeBean.getRouteId());
			ps.executeUpdate();
			flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
			return flag;
		}
		return flag;
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

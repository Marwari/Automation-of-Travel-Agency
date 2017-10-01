package com.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ata.bean.CredentialsBean;
import com.ata.util.DBUtil;

public class CredentialsDaoImpl implements CredentialsDao {
	Connection con= DBUtil.getConnection();

	@Override
	public String createProfile(CredentialsBean credentialsBean) {
		try{
			PreparedStatement ps=
					con.prepareStatement("insert into ata_tbl_user_credentials values(?,?,?,?)");
			ps.setString(1, credentialsBean.getUserId());
			ps.setString(2, credentialsBean.getPassword());
			ps.setString(3, credentialsBean.getUserType());
			ps.setLong(9, credentialsBean.getLoginStatus());
			int a=ps.executeUpdate();
			if(a>0)
				return "User Created.";
			else
				return "User Not Created.";
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
					con.prepareStatement("delete * from ata_tbl_user_credentials where userid=?");
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
	public boolean updateProfile(CredentialsBean credentialsBean) {
		boolean flag=false;
		try {
			PreparedStatement ps=
					con.prepareStatement("update ata_tbl_user_credentials SET password=?, usertype=?, loginstatus=? where userid=?");
			ps.setString(1, credentialsBean.getPassword());
			ps.setString(2, credentialsBean.getUserType());
			ps.setInt(3, credentialsBean.getLoginStatus());
			ps.setString(4, credentialsBean.getUserId());
			ps.executeUpdate();
			flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
			return flag;
		}
		return flag;	}

	@Override
	public CredentialsBean findByid(String userId) {
		CredentialsBean credentialsBean = new CredentialsBean();
		try {
			PreparedStatement ps = 
					con.prepareStatement("select * from ata_tbl_credentials where userid=?");
			ResultSet rs= ps.executeQuery();
			rs.next();
			credentialsBean.setPassword(rs.getString(1));
			credentialsBean.setUserType(rs.getString(2));
			credentialsBean.setLoginStatus(rs.getInt(3));
			credentialsBean.setUserId(rs.getString(4));
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
		}
		return credentialsBean;
	}

	@Override
	public ArrayList<CredentialsBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

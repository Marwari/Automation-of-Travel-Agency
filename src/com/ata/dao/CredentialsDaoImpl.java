package com.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ata.bean.CredentialsBean;
import com.ata.bean.ProfileBean;
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
			credentialsBean.setUserId(rs.getString(1));
			credentialsBean.setFirstName(rs.getString(2));
			credentialsBean.setLastName(rs.getString(3));
			credentialsBean.setDateOfBirth(rs.getDate(4));
			credentialsBean.setGender(rs.getString(5));
			credentialsBean.setStreet(rs.getString(6));
			credentialsBean.setLocation(rs.getString(7));
			credentialsBean.setCity(rs.getString(8));
			credentialsBean.setState(rs.getString(9));
			credentialsBean.setPincode(rs.getString(10));
			credentialsBean.setEmailId(rs.getString(11));
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
		}
		return profileBean;
	}

	@Override
	public ArrayList<CredentialsBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.ata.bean.ProfileBean;
import com.ata.util.DBUtil;

public class ProfileDaoImpl implements ProfileDao {
	Connection con= DBUtil.getConnection();

	@Override
	public String createProfile(ProfileBean profileBean) {
		try{
			PreparedStatement ps=
					con.prepareStatement("insert into ata_tbl_user_profile values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, profileBean.getUserId());
			ps.setString(2, profileBean.getFirstName());
			ps.setString(3, profileBean.getLastName());
			ps.setDate(4, profileBean.getDateOfBirth());
			ps.setString(5, profileBean.getGender());
			ps.setString(6, profileBean.getStreet());
			ps.setString(7, profileBean.getLocation());
			ps.setString(8, profileBean.getCity());
			ps.setString(9, profileBean.getState());
			ps.setString(10, profileBean.getPincode());
			ps.setString(11, profileBean.getMobileNo());
			ps.setString(12, profileBean.getEmailId());
			int a=ps.executeUpdate();
			if(a>0)
				return "Profile Created.";
			else
				return "Profile Not Created.";
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
					con.prepareStatement("delete * from ata_tbl_user_profile where userid=?");
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
	public boolean updateProfile(ProfileBean profileBean) {
		boolean flag=false;
		try {
			PreparedStatement ps=
					con.prepareStatement("update ata_tbl_user_profile SET firstname=?,lastname=?,dateofbirth=?,gender=?,street=?,location=?,city=?,state=?,pincode=?,mobileno=?,emailid=? where userid=?");
			ps.setString(1, profileBean.getFirstName());
			ps.setString(2,profileBean.getLastName());
			ps.setDate(3, profileBean.getDateOfBirth());
			ps.setString(4, profileBean.getGender());
			ps.setString(5, profileBean.getStreet());
			ps.setString(6, profileBean.getLocation());
			ps.setString(7, profileBean.getCity());
			ps.setString(8, profileBean.getState());
			ps.setString(9, profileBean.getPincode());
			ps.setString(10, profileBean.getMobileNo());
			ps.setString(11, profileBean.getEmailId());
			ps.setString(12, profileBean.getUserId());
			ps.executeUpdate();
			flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
			return flag;
		}
		return flag;
	}

	@Override
	public ProfileBean findByid(String userId) {
		ProfileBean profileBean = new ProfileBean();
		try {
			PreparedStatement ps = 
					con.prepareStatement("select * from ata_tbl_user_profile where userid=?");
			ResultSet rs= ps.executeQuery();
			rs.next();
			profileBean.setUserId(rs.getString(1));
			profileBean.setFirstName(rs.getString(2));
			profileBean.setLastName(rs.getString(3));
			profileBean.setDateOfBirth(rs.getDate(4));
			profileBean.setGender(rs.getString(5));
			profileBean.setStreet(rs.getString(6));
			profileBean.setLocation(rs.getString(7));
			profileBean.setCity(rs.getString(8));
			profileBean.setState(rs.getString(9));
			profileBean.setPincode(rs.getString(10));
			profileBean.setEmailId(rs.getString(11));
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
		}
		return profileBean;
	}

	@Override
	public ArrayList<ProfileBean> findAll() {
		ArrayList<ProfileBean> profiles= new ArrayList<ProfileBean>();
		Statement statement;
		try{
			statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from ata_tbl_user_profile");
			while(resultSet.next())
			{
				ProfileBean profile = new ProfileBean();
				profile.setUserId(resultSet.getString(1));
				profile.setFirstName(resultSet.getString(2));
				profile.setLastName(resultSet.getString(3));
				profile.setDateOfBirth(resultSet.getDate(4));
				profile.setGender(resultSet.getString(5));
				profile.setStreet(resultSet.getString(6));
				profile.setLocation(resultSet.getString(7));
				profile.setCity(resultSet.getString(8));
				profile.setState(resultSet.getString(9));
				profile.setPincode(resultSet.getString(10));
				profile.setMobileNo(resultSet.getString(11));
				profile.setEmailId(resultSet.getString(12));
				profiles.add(profile);
			}
		} catch(SQLException e){
			e.getStackTrace();
		}
		return profiles;
	}

}

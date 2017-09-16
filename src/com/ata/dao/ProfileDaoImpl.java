package com.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
			ps.setString(4, profileBean.getDateOfBirth());
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
		try {
			PreparedStatement ps= 
					con.prepareStatement("delete from ata_tbl_user_profile where userid=?");
			ps.setString(1, arg1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean updateProfile(ProfileBean profileBean) {
		boolean flag=false;
		try {
			PreparedStatement ps=
					con.prepareStatement("update ata_tbl_user_profile SET firstname=?,lastname=?,dateofbirth=?,gender=?,street=?,location=?,city=?,state=?,pincode=?,mobileno=?,emailid=? where userid=?");
			ps.setString(1, profileBean.getFirstName());
			ps.setString(2,profileBean.getLastName());
			ps.setString(3, profileBean.getDateOfBirth());
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ProfileBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

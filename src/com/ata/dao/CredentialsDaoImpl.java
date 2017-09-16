package com.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateProfile(CredentialsBean credentialsBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CredentialsBean findByid(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CredentialsBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

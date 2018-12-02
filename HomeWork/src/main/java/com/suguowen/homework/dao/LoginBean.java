package com.suguowen.homework.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginBean {
    private String username;    private String password;
    public void setUsername(String _username) {   this.username = _username;  }
    public String getUsername() {  return this.username;  }
    public void setPassword(String _password) {  this.password = _password;  }
    public String getPassword() {  return this.password;  }

    public boolean checklogin() {
        boolean loginsuccess = false;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
         try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homework?useSSL=false", "root", "root");
            stmt= con.createStatement();
            String sql = "Select * from USERS where UserName = '" + username + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                if (password.equals(rs.getString("Password")))
                   loginsuccess = true;
            }
        } catch (Exception sqlex1) {   sqlex1.printStackTrace();
        } finally{  if (con != null) 
                             try {  con.close();
                             } catch (SQLException sqlex2){  sqlex2.printStackTrace();  }
        }
        return loginsuccess;
    }
//    public static void main(String[] args) {
//    	LoginBean loginBean = new LoginBean();
//    	loginBean.setUsername("Robin");
//    	loginBean.setPassword("111");
//    	System.out.println(loginBean.checklogin());
//	}
}

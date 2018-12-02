<%@page contentType="text/html; charset=GBK" %>  <%@page import="java.sql.*" %>
<%
String username = request.getParameter("username");  String password = request.getParameter("password");  
boolean loginsuccess = false;
Connection con = null;  Statement stmt = null;  ResultSet rs = null;
try {  Class.forName("org.apache.derby.jdbc.ClientDriver");
          con = DriverManager.getConnection("jdbc:derby://localhost:1527/MyTest", "admin", "111");  
          stmt= con.createStatement();
          String sql = "Select * from USERS where \"UserName\" = '" + username + "'";  rs = stmt.executeQuery(sql);
          while (rs.next()) {
                 if (password.equals(rs.getString("Password"))){ loginsuccess = true;      session.setAttribute("username", username);
                 }
          }
} catch (Exception sqlex1) {  sqlex1.printStackTrace();
} finally{  if (con != null) {  try { con.close();
                                               } catch (SQLException sqlex2){sqlex2.printStackTrace();
                                               }
                 }
}
if (loginsuccess) {
%>  <jsp:forward page = "welcome.jsp"></jsp:forward>
<%
} else {
%>  <jsp:forward page = "error.jsp"></jsp:forward>
<%
}
%>

package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ServiceDao;

public class LoginAction extends Action{
	
	ServiceDao serviceDao = new ServiceDao();
	
@Override
public String execute(HttpServletRequest request, HttpServletResponse response) {

	
	String uname=request.getParameter("uname");
	String upass=request.getParameter("upass");
	
	return serviceDao.getUser(request, uname, upass);
	
}
}

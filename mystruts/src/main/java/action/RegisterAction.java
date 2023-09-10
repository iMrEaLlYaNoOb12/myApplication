package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ServiceDao;

public class RegisterAction extends Action{
	
	
	
	ServiceDao serviceDao = new ServiceDao();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String uname=request.getParameter("uname");
		String upass=request.getParameter("upass");
		
		serviceDao.saveUser(request, uname, upass, 0);

		return "lang.success";
	}
}

package com.pizza.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pizza.vo.PizzaModel;
import static com.pizza.common.JdbcTemplate.*;

@WebServlet("/order")
public class OrderController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String pizza = req.getParameter("pizza");
		String[] toppings = req.getParameterValues("topping");
		String[] sides = req.getParameterValues("side");
		String orderResult = "";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
			String id = "KH";
			String pwd = "KH";
			
			conn = DriverManager.getConnection(url, id, pwd);
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO PIZZA_TB (PIZZA, TOPPING, SIDE) VALUES(?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pizza);			
			if(toppings != null) {
				pstmt.setString(2, String.join(",", toppings));
			} else {
				pstmt.setString(2, "");
			}
			if(sides != null) {
				pstmt.setString(3, String.join(",", sides));
			} else {
				pstmt.setString(3, "");
			}
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				orderResult = "주문 성공";
			} else {
				orderResult = "주문 실패";
			}
			
			commit(conn);
			req.setAttribute("data", orderResult);
					
		} catch (Exception e) {
			e.printStackTrace();
			rollback(conn);
			orderResult="주문실패";
			
		} finally {
			close(conn);
			close(pstmt);
		}
		
		PizzaModel pizzaModel = new PizzaModel(pizza, toppings, sides, orderResult);
		req.setAttribute("pizzaModel", pizzaModel);
		
		req.setAttribute("key01", "value01");
		
		req.getSession().setAttribute("sessionKey", "sessionValue");
		
		req.setAttribute("testKey", "testValueRequest");
		req.getSession().setAttribute("testKey", "testValueSession");
		req.getServletContext().setAttribute("testKey", "testValueApplication");
//		page < request < session < application(servletContext)

		
		req.getRequestDispatcher("/WEB-INF/views/orderResult.jsp").forward(req, resp);
	}
}

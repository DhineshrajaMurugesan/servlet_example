package main.java;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/books")
public class BookServlet extends HttpServlet {
    // public Connection conn;
    // private Statement statement;
    public static MysqlConnection db;
    public MysqlConnection rs;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Book> listBook = new ArrayList<>();
        db=MysqlConnection.getDbCon();
        // System.out.println(MysqlConnection.getDbCon());
        String sql = "SELECT * FROM book";
        
        Statement statement = db.conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        // return res;
        while (resultSet.next()) {
            int id = resultSet.getInt("book_id");
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            float price = resultSet.getFloat("price");

            Book book = new Book(id, title, author, price);
            listBook.add(book);
        }

        resultSet.close();
        statement.close();
        System.out.println(listBook);
        request.setAttribute("listbook", listBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
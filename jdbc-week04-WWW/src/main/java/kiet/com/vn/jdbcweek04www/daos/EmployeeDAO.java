package kiet.com.vn.jdbcweek04www.daos;

import kiet.com.vn.jdbcweek04www.entities.Employee;


import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDAO {

    private DataSource dataSource;

    private Connection connection;

    public EmployeeDAO(DataSource dataSource) throws  Exception{
        this.dataSource = dataSource;
        connection = dataSource.getConnection();

    }

    public void insert(Employee employees) throws Exception{
        String query = "insert into employee value(?,?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, employees.getId());
        ps.setString(2, employees.getName());
        ps.executeUpdate();
    }

    public List<Employee> getAll()throws Exception{
        List<Employee> lst = new ArrayList<>();
        String query = "select * from employee";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            lst.add(new Employee(rs.getLong(1),rs.getString(2)));
        }
        return lst;
    }
}

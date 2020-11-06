package com.star.springbootdemo.sql;

import java.sql.*;

/**
 * @Author: StarC
 * @Date: 2020/4/15 9:59
 * @Description:
 */
public class Test {

    private static final String DRIVER = "jdbc:mysql://10.10.160.20:3306/adssp-prod?useUnicode=true&characterEncoding=UTF-8";
    private static final String UESRNAME = "root";
    private static final String PASSWORD = "adssp@Admin123";
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql ="select * from t_s_user where 1=1";
        try {
             connection = Test.getConnection();
            preparedStatement= connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            DatabaseMetaData metaData = connection.getMetaData();
           // ResultSet udTs = metaData.getUDTs();

            while(resultSet.next()){

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            closeConnection(resultSet, preparedStatement, connection);
        }
    }

    private static void closeConnection(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DRIVER, UESRNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

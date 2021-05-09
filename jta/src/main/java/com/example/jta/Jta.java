package com.example.jta;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.XAConnection;
import javax.sql.XADataSource;
import javax.transaction.UserTransaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.concurrent.*;

//http://www.tianshouzhi.com/api/tutorials/distributed_transaction/386 https://www.codingapi.com/docs/txlcn-preface/
public class Jta {
    public static void main(String[] args) throws Exception {
        JtaTransactionManager jtaTransactionManage = new JtaTransactionManager();
//        jtaTransactionManage.commit();
        //1. 加载驱动
        //Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
        String password = "password";
        String root = "root";
        String sql = "insert into test values('','f','d')";
        String sql2 = "insert into test values(2,'f','d')";
        UserTransactionImp userTransaction = new UserTransactionImp();
//        UserTransaction s=new UserTransactionManager();
//        s.begin();
        AtomikosDataSourceBean dataSourceBean = new AtomikosDataSourceBean();
        dataSourceBean.setUniqueResourceName("x");
        MysqlXADataSource xaDataSource = new MysqlXADataSource();
        xaDataSource.setPassword(password);
        xaDataSource.setUser(root);
        xaDataSource.setUrl(url);
        dataSourceBean.setXaDataSource(xaDataSource);
        userTransaction.begin();
        Connection connection = dataSourceBean.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();
//        MysqlXADataSource xaDataSource1=new MysqlXADataSource();
//        xaDataSource1.setPassword(password);
//        xaDataSource1.setUser(root);
//        xaDataSource1.setUrl(url);
//        XAConnection connection1=xaDataSource1.getXAConnection();
//        PreparedStatement preparedStatement1=connection1.getConnection().prepareStatement(sql2);
//        preparedStatement1.execute();
        //userTransaction.commit();


        try {
            Integer.parseInt("ds");
        } catch (Exception e) {
            userTransaction.rollback();
        }
    }
}

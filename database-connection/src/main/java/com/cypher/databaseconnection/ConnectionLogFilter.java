package com.cypher.databaseconnection;

import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.FilterEventAdapter;
import com.alibaba.druid.proxy.jdbc.ConnectionProxy;
import com.alibaba.druid.proxy.jdbc.StatementProxy;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;
import java.util.Properties;

@Slf4j
public class ConnectionLogFilter extends FilterEventAdapter {

    @Override
    public void connection_connectBefore(FilterChain chain, Properties info) {
        log.info("连接开始前");
    }

    @Override
    public void connection_connectAfter(ConnectionProxy connection) {
        log.info("连接开始后");
    }

    @Override
    protected void statementExecuteBefore(StatementProxy statement, String sql) {
        log.info("进行操作前");
    }

    @Override
    protected void statementExecuteAfter(StatementProxy statement, String sql, boolean result) {
        log.info("进行操作后");
    }
}

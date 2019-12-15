package com.cypher.datasource.config;

import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.FilterEventAdapter;
import com.alibaba.druid.proxy.jdbc.ConnectionProxy;
import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

@Slf4j
public class ConnectionFilter extends FilterEventAdapter {

    @Override
    public void connection_connectBefore(FilterChain chain, Properties info) {
        log.info("连接前产生的操作");
    }

    @Override
    public void connection_connectAfter(ConnectionProxy connection) {
        log.info("连接后产生的操作");
    }
}

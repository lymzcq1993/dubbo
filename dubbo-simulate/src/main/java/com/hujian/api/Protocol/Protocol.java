package com.hujian.api.Protocol;

import com.hujian.api.Invocation;

public interface Protocol {
    void send(String host,int port,Invocation invocation);

    void start();
}

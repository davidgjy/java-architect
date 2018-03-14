package com.genesis.architect.cxf.service;

import javax.jws.WebService;

/**
 * @author KG created on 16/12/4
 */
@WebService
public interface HelloService {

    public String sayHello(String content);

}

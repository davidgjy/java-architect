package com.genesis.architect.cxf.service;

        import javax.jws.WebService;

/**
 * @author KG created on 16/12/4
 */
@WebService(endpointInterface = "com.genesis.architect.cxf.service.HelloService")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String content) {
        return "hello," + content;
    }
}



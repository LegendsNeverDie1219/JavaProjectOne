package com.huawei.nce.javabase.day14.interfacetest;


/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/2 9:22
 */
public class NetWorkTest {
    /**
     * 接口的应用: 代理模式
     * 代理模式: 就是为一个对象提供一个代理对象, 用来控制这个对象的访问.
     */
    public static void main(String[] args) {
        // 不用代理模式.
        NetWork network = new Server();
        network.browse();
        System.out.println("==================");
        // 使用代理模式
        NetWork network2 = new ProxyServer(new Server());
        network2.browse();

    }
}

interface  NetWork {
    /**
     * 浏览数据,上网
     */
    void browse();
}

class Server implements  NetWork {

    /**
     * 浏览数据,上网
     */
    @Override
    public void browse() {
        System.out.println("服务器实现了网络接口, 能够上网");
    }
}

class ProxyServer implements NetWork {
    // 关联关系(依赖关系,关联关系, 聚合关系, 组合关系, 继承关系)
    private Server server;

    public ProxyServer(Server server) {
        this.server = server;
    }

    /**
     * 浏览数据,上网
     */
    @Override
    public void browse() {
        check();
        server.browse();
    }

    private void check() {
        System.out.println("校验网络安全");
    }
}
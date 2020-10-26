package Static;



/**
 * @Author WangFuKun
 * @create 2020/10/25 16:45
 */
//静态代理模式总结
//真实对象和代理对象都要实现同一个接口
//代理对象要代理真实角色
//好处：
//代理对象可以做很多真实对象做不了的事情
//真实对象可以专注做自己的事情
public class StaticProxy {
    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new You("野生程序员"));
        weddingCompany.HappyMarry();

    }
}

interface Marry {
    void HappyMarry();
}

class You implements Marry {
    private String name ;

    public You(String name) {
        this.name = name;
    }

    @Override
    public void HappyMarry() {
        System.out.println(name+"要结婚了，超级开心！");
    }
}

//代理角色，帮助你结婚
class WeddingCompany implements Marry {
    private Marry target;
    public WeddingCompany(Marry target) {
        this.target=target;
    }

    private void after() {
        System.out.println("结账");
    }

    private void before() {
        System.out.println("布置结婚现场");
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }
}
package Lambda;

/**
 * @Author WangFuKun
 * @create 2020/10/26 10:35
 */
//推导lambda表达式
public class Lambda {
    //静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("i like lambda2");
        }
    }
    public static void main(String[] args) {
        //局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("i like lambda3");
            }
        }

        ILike iLike = new Like();
        iLike.lambda();

        ILike iLike2 = new Like2();
        iLike2.lambda();
        ILike iLike3 = new Like3();
        iLike3.lambda();
        ILike iLike4 = new ILike() {
            @Override
            public void lambda() {
                System.out.println("i like lambda4");
            }

        };
        iLike4.lambda();
        //用lambda简化类
        ILike iLike5 =()->{
            System.out.println("i like lambda5");
        };
        iLike5.lambda();
    }
}
//定义一个函数式接口
interface ILike{
    void lambda();
}
//实现类
class Like implements ILike{

    @Override
    public void lambda() {
        System.out.println("i like lambda");
    }
}
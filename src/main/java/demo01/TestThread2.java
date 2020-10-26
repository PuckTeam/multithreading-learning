package demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author WangFuKun
 * @create 2020/10/25 8:36
 */
//练习实现多线程同步下载图片
public class TestThread2 extends Thread{
    private String url;
    private String name;
    public TestThread2(String url,String name){
        this.url=url;
        this.name = name;
    }
    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
    }

    public static void main(String[] args) {
        TestThread2 T1 = new TestThread2("http://wlgzs-net.oss-cn-beijing.aliyuncs.com/20190904100439.jpg?Expires=4721205880&OSSAccessKeyId=LTAICQjxITJz7uoN&Signature=FcSosuCOd8PqHY3EKw8GEeOxcmI%3D","1.jpg");
        TestThread2 T2 = new TestThread2("http://wlgzs-net.oss-cn-beijing.aliyuncs.com/20190904100439.jpg?Expires=4721205880&OSSAccessKeyId=LTAICQjxITJz7uoN&Signature=FcSosuCOd8PqHY3EKw8GEeOxcmI%3D","2.jpg");
        TestThread2 T3 = new TestThread2("http://wlgzs-net.oss-cn-beijing.aliyuncs.com/20190904100439.jpg?Expires=4721205880&OSSAccessKeyId=LTAICQjxITJz7uoN&Signature=FcSosuCOd8PqHY3EKw8GEeOxcmI%3D","3.jpg");
        T1.start();
        T2.start();
        T3.start();
    }
}

//下载器
class WebDownloader {
    //下载方法
    public void downloader(String url, String fileName) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(fileName));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("IO异常，下载出现问题");
        }

    }
}
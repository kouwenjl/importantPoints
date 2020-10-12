import java.util.ArrayList;
import java.util.List;

public class JvmTest {
    public static void main(String[] args) throws Exception{
        Runtime runtime=Runtime.getRuntime();
        System.out.println("初始化堆大小:"+runtime.totalMemory()/1024/1024+" M");
        System.out.println("空闲堆大小:"+runtime.freeMemory()/1024/1024+" M");
        System.out.println("最大堆大小:"+runtime.maxMemory()/1024/1024+" M");
        List result=new ArrayList();
        while (true){
            Thread.sleep(5*1000);
            byte[] data=new byte[1024*1024];
            result.add(data);

        }
    }
}

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

public class JvmTest {
    public static void main(String[] args) throws Exception {
//        Runtime runtime=Runtime.getRuntime();
//        System.out.println("初始化堆大小:"+runtime.totalMemory()/1024/1024+" M");
//        System.out.println("空闲堆大小:"+runtime.freeMemory()/1024/1024+" M");
//        System.out.println("最大堆大小:"+runtime.maxMemory()/1024/1024+" M");
//        List result=new ArrayList();
//        List<GarbageCollectorMXBean> garbageCollectorMXBeans= ManagementFactory.getGarbageCollectorMXBeans();
//        garbageCollectorMXBeans.forEach(t->{
//            System.out.println(t.getName());
//        });
//        while (true){
//            Thread.sleep(5*1000);
//            byte[] data=new byte[1024*1024];
//            result.add(data);
//
//        }
        float f = (float) Math.pow(2, -23);
        System.out.println(f);
        ;
        double a = 0.3;
        double b = 0.3;
        double c = a + b;
        System.out.println(0.3f + 0.3f);
    }
}

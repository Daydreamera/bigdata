import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HdfsClient {
    @Test
    public void testMkdirs() throws IOException, InterruptedException, URISyntaxException {
        // 1 获取文件系统
        Configuration configuration = new Configuration();
        // 配置在集群上运行
        configuration.set("fs.defaultFS", "hdfs://bigdata01:9000");
        FileSystem fs = FileSystem.get(new URI("hdfs://192.168.229.200:9000"), configuration, "congwang");
        // 2 创建目录
        fs.mkdirs(new Path("/javaAPI/test"));
        // 3 上传文件
        fs.copyFromLocalFile(new Path("C:/Users/Cong.Wang/Desktop/cloud.png"), new Path("/javaAPI/test/"));
        // 4 下载数据
//        fs.copyToLocalFile(false,new Path("/javaAPI/test/cloud.png"),new Path("D:/"),true);
        // 3 关闭资源
        fs.close();
    }
}

package minru.chen.bloghbn;

import minru.chen.bloghbn.Utils.FileIOUilts;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

/**
 * Author: minru
 * Date: 11/14/19
 * Time: 5:10 PM
 */
@SpringBootTest
public class FileUtilsTest {
    @Autowired
    FileIOUilts fileIOUilts;
    @Value("${file.root}")
    String root;

    @Test
    public void textRoot() throws IOException {
        String result=fileIOUilts.saveFile(123l,"newfile1");
    }
    @Test
    public void getDirTest(){
        //获得基本的信息
        System.out.println(FileUtils.getTempDirectory());//获取临时目录 java.io.tmpdir,getUserDirectoryPath返回路径字符串
        System.out.println(FileUtils.getUserDirectory());//获取用户主目录 user.home,getUserDirectoryPath返回路径字符串

        //以可读的方式，返回文件的大小EB, PB, TB, GB, MB, KB or bytes
        System.out.println(FileUtils.byteCountToDisplaySize(10000000));
        System.out.println(FileUtils.byteCountToDisplaySize(1));
    }
    @Test
    public void createDir() throws IOException {
        FileUtils.forceMkdirParent(new File(root+"dfs/sdfs/text.txt"));
        FileUtils.
    }
}

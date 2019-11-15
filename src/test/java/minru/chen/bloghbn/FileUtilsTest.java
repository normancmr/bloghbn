package minru.chen.bloghbn;

import minru.chen.bloghbn.Utils.FileIOUilts;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

/**
 * Author: minru
 * Date: 11/14/19
 * Time: 5:10 PM
 */
@SpringBootTest
public class FileUtilsTest {
    @Autowired
    FileIOUilts fileIOUilts;

    @Test
    public void textRoot(){
        String result=fileIOUilts.saveFile(123l,123l,new File(" "));
    }
}

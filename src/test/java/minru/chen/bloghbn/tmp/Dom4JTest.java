package minru.chen.bloghbn.tmp;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Author: minru
 * Date: 12/6/19
 * Time: 12:03 PM
 */
@SpringBootTest
public class Dom4JTest {
    @Value("${file.root}")
    String filepath;
    @Test
    public void testFileCreate() throws IOException {
        Document document=DocumentHelper.createDocument();
        document.setXMLEncoding("UTF-8");
        Element rootElement=DocumentHelper.createElement("root");
        rootElement.addAttribute("version","1.0");
        File file=new File(filepath+"xml1.xml");
        if (file.exists()){
            file.delete();
        }else{
            file.createNewFile();
            FileOutputStream fileOutputStream=new FileOutputStream(file);
            fileOutputStream.write(document.asXML().getBytes());
            fileOutputStream.flush();
            System.out.println(file.getPath());
        }

    }


}

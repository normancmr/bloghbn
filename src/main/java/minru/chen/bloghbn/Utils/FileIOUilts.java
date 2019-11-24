package minru.chen.bloghbn.Utils;




import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Author: minru
 * Date: 11/14/19
 * Time: 4:46 PM
 */

@Component
public class FileIOUilts {
    @Value("${file.root}")
    private static String fileRoot;
//    private static File rootDirt=new File(@Value("${file.root}") String fileroot);

    public String saveFile(Long user_id, String blogName) throws IOException {
        List<String> lines = Arrays.asList("The first line", "The second line");
        Path file = Paths.get(fileRoot+user_id.toString()+"/blog/"+blogName);
        Files.write(file, lines, Charset.forName("UTF-8"));
//        System.out.println(this.fileRoot);
        return this.fileRoot;
    }
    public String getFile(Long user_id, Long blog_id, File file){
        return "";
    }


}

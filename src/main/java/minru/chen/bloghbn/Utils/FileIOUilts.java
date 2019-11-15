package minru.chen.bloghbn.Utils;




import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Author: minru
 * Date: 11/14/19
 * Time: 4:46 PM
 */
@Component
public class FileIOUilts {
    @Value("${file.root}")
    String fileRoot;

    public String saveFile(Long user_id, Long blog_id, File file){
        System.out.println(this.fileRoot);
        return this.fileRoot;
    }
    public void getFile(Long user_id, Long blog_id, File file){

    }
}

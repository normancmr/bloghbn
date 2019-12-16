package minru.chen.bloghbn.Utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Author: minru
 * Date: 12/6/19
 * Time: 12:29 PM
 * This Utils is for storing blog and comments information into FileSystem. The operations include XML create, read, write, and delete.
 *
 */
@Slf4j
@Component
public class FilesUtil {
    @Value("${file.root}")
    String rootPath;

    public boolean checkFile(String path){
        File file = new File(rootPath+path);
        return file.exists();
    }

    public boolean createDirectory(String dirName){
        File file = new File(rootPath+dirName);
        if (file.exists()){
            log.info("Directory already exists!");
            return true;
        }else {

                file.mkdir();

                log.info("Can't create Directory !" );
                return false;
        }
    }
    public byte[] readFile(String userId,String fileName){
        File file =new File(rootPath+"/"+userId+"/"+fileName);
        try {
            FileInputStream fileInputStream=new FileInputStream(file);
        }catch ()


    }
}

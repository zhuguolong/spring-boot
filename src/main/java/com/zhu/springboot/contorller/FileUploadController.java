package com.zhu.springboot.contorller;

import com.zhu.springboot.utils.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 上传图片
 */
@RestController
public class FileUploadController {

    private final static Logger log = LoggerFactory.getLogger(FileUploadController.class);

    private final static String UPLOADED_FOLDER = "/usr/local/resource/www/picture/";

    @PostMapping(value = "/fileUpload")
    public Object fileUpload(MultipartFile file) {
        if (file.isEmpty()) {
            return ResultMap.err("Please select a file to upload!");
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER, file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
            throw new MultipartException(e.getMessage());
        }

        return ResultMap.ok("图片上传成功！");
    }
}

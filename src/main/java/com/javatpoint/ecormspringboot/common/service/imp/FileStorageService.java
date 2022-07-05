package com.javatpoint.ecormspringboot.common.service.imp;

import com.javatpoint.ecormspringboot.common.service.IFileStorageService;
import com.javatpoint.ecormspringboot.common.util.CustomException;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class FileStorageService implements IFileStorageService {

    @Value("${FilePath}")
    private String imagePath;

    @Value("${DigitalBillPath}")
    private String digitalBillPath;

    Path foundFile;

    public List<String> storeFiles(MultipartFile[] files){
        if(!Files.isDirectory(Paths.get(imagePath))){
            new File(imagePath).mkdirs();
        }
        List<String> filenames = new ArrayList<String>();
        Arrays.asList(files).stream().forEach(file -> {
            String originFileName = file.getOriginalFilename();
            UUID uuid = UUID.randomUUID();
            String uuidAsString = uuid.toString();
            String fileName = uuidAsString + "." + FilenameUtils.getExtension(originFileName);
            Path path = Paths.get(imagePath).resolve(fileName);
            try {
                Files.copy(file.getInputStream(), path);
            } catch (IOException e) {
                try {
                    throw new CustomException("Lưu không thành công", HttpStatus.INTERNAL_SERVER_ERROR);
                } catch (CustomException ex) {
                    ex.printStackTrace();
                }
            }
            filenames.add(fileName);
        });
        return filenames;
    }

    public Resource getFileAsResource(String filename) throws IOException {
        Path uploadDirectory = Paths.get(digitalBillPath);
        Files.list(uploadDirectory).forEach(file -> {
            if(file.getFileName().toString().equals(filename)){
                this.foundFile = file;
                return;
            }
        });
        if(foundFile != null){
            return new UrlResource(foundFile.toUri());
        }
        return null;
    }
}

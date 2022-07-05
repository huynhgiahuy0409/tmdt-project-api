package com.javatpoint.ecormspringboot.common.api;

import com.google.common.net.HttpHeaders;
import com.javatpoint.ecormspringboot.common.service.imp.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.*;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping(value = "/api")
public class FileController {

    @Value("${DigitalBillPath}")
    private String digitalBillPath;

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping("/downloadFile/{filename:.+}")
    public ResponseEntity downloadFile(HttpServletRequest request, HttpServletResponse response, @PathVariable("filename") String filename) throws IOException {
//        File file = new File(digitalBillPath + filename);
//        if(file.exists()){
//            String mimeType = URLConnection.guessContentTypeFromName(file.getName());
//            System.out.println(mimeType);
//            if (mimeType == null) {
//                //unknown mimetype so set the mimetype to application/octet-stream
//                mimeType = "application/octet-stream";
//            }
//            response.setContentType(mimeType);
//            response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
//            response.setContentLength((int) file.length());
//            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
//            FileCopyUtils.copy(inputStream, response.getOutputStream());
//        }
        Resource file = fileStorageService.getFileAsResource(filename);
        Path path = file.getFile().toPath();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(path))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}

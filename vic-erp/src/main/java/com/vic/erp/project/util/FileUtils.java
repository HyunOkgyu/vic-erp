package com.vic.erp.project.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.vic.erp.project.VO.AttachFileVO;

@Component("fileUtils")
public class FileUtils {

    public static final String FILE_STORAGE_PATH = "C:\\Users\\zovan\\Documents\\workspace-sts-3.9.20.CI-B2026\\vic-erp\\src\\main\\resources\\storedFile/"; // 파일이 저장될 위치

    public List<Map<String, Object>> parseInsertFileInfo(AttachFileVO attachFileVO, 
            MultipartHttpServletRequest mpRequest) throws Exception {

        Iterator<String> iterator = mpRequest.getFileNames();

        MultipartFile multipartFile = null;
        String originalFileName = null;
        String originalFileExtension = null;
        String storedFileName = null;

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> listMap = null;

        int bno = attachFileVO.getBoms_no();

        File file = new File(FILE_STORAGE_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }

        while (iterator.hasNext()) {
            multipartFile = mpRequest.getFile(iterator.next());
            if (!multipartFile.isEmpty()) {
                originalFileName = multipartFile.getOriginalFilename();
                originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
                storedFileName = getRandomString() + originalFileExtension;

                file = new File(FILE_STORAGE_PATH + storedFileName);
                multipartFile.transferTo(file);
                listMap = new HashMap<String, Object>();
                listMap.put("BNO", bno);
                listMap.put("atch_file_nm", originalFileName); // 원본파일이름
                listMap.put("atach_file_size", multipartFile.getSize()); // 파일 크기
                list.add(listMap);
            }
        }
        return list;
    }

    public static String getRandomString() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf(".");
        return dotIndex > 0 ? fileName.substring(dotIndex) : "";
    }
}

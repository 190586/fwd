package com.fwd.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fwd.domain.Menu;
import com.fwd.repository.MenuRepository;
import com.fwd.util.RC;
import com.fwd.util.RF;
import com.fwd.util.Utils;

@Controller
@RequestMapping("/api")
public class MenuCustomController {
    
    public final static String MENU_IMAGE_PATH = "image/";
    
    @Autowired
    MenuRepository menuRepository;
    
    @RequestMapping(value = "/menuscustom", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> addMenu(@RequestBody Menu request) {
        ResponseEntity<?> entity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Map<String, Object> resp = new HashMap();
        try {
            if (request.getImagePath() != null && !request.getImagePath().isEmpty()) {
                String pathHeader = MENU_IMAGE_PATH + RandomStringUtils.randomAlphanumeric(10) + "."
                        + Utils.UPLOAD_IMAGE_TYPE;
                Utils.createImage(request.getImagePath(), pathHeader);
                request.setImagePath(pathHeader);
            }
            
            
            menuRepository.save(request);
            boolean success = true;
            resp.put(RF.RESULTS, success);
            resp.put(RF.RESPONSE_CODE, RC.SUCCESS);
            resp.put(RF.RESPONSE_MESSAGE, RC.SUCCESS_DESC);
        } catch (Exception ex) {
            resp.put(RF.RESPONSE_CODE, RC.UNKNOWN_FAIL);
            resp.put(RF.RESPONSE_MESSAGE, RC.UNKNOWN_FAIL_DESC);
        }
        entity = new ResponseEntity(resp, headers, HttpStatus.OK);
        return entity;
    }
    
    @RequestMapping(value = "/menuscustom/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> editPage(@PathVariable("id") Long id, @RequestBody Menu request) {
        
        Menu menu = menuRepository.findOne(id);
        if (menu.getImagePath() != null && !menu.getImagePath().isEmpty() && request.isImagePathChanged()) {
            String pathImageHeader = Utils.PATH_UPLOAD + menu.getImagePath();
            Utils.deleteFile(pathImageHeader);
        }
        
        ResponseEntity<?> entity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Map<String, Object> resp = new HashMap();
        try {
            if (request.getImagePath() != null && !request.getImagePath().isEmpty() && request.isImagePathChanged()) {
                String pathHeader = MENU_IMAGE_PATH + RandomStringUtils.randomAlphanumeric(10) + "."
                        + Utils.UPLOAD_IMAGE_TYPE;
                Utils.createImage(request.getImagePath(), pathHeader);
                request.setImagePath(pathHeader);
            } else {
                request.setImagePath(menu.getImagePath());
            }
            
            menuRepository.save(request);
            boolean success = true;
            resp.put(RF.RESULTS, success);
            resp.put(RF.RESPONSE_CODE, RC.SUCCESS);
            resp.put(RF.RESPONSE_MESSAGE, RC.SUCCESS_DESC);
        } catch (Exception ex) {
            resp.put(RF.RESPONSE_CODE, RC.UNKNOWN_FAIL);
            resp.put(RF.RESPONSE_MESSAGE, RC.UNKNOWN_FAIL_DESC);
        }
        entity = new ResponseEntity(resp, headers, HttpStatus.OK);
        return entity;
    }
    
    @RequestMapping(value = "/menuscustom/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deletePage(@PathVariable("id") Long id) {
        
        Menu menu = menuRepository.findOne(id);
        if (menu.getImagePath() != null && !menu.getImagePath().isEmpty()) {
            String pathImageHeader = Utils.PATH_UPLOAD + menu.getImagePath();
            Utils.deleteFile(pathImageHeader);
        }
        
        ResponseEntity<?> entity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Map<String, Object> resp = new HashMap();
        try {
            menuRepository.delete(id);
            boolean success = true;
            resp.put(RF.RESULTS, success);
            resp.put(RF.RESPONSE_CODE, RC.SUCCESS);
            resp.put(RF.RESPONSE_MESSAGE, RC.SUCCESS_DESC);
        } catch (Exception ex) {
            resp.put(RF.RESPONSE_CODE, RC.UNKNOWN_FAIL);
            resp.put(RF.RESPONSE_MESSAGE, RC.UNKNOWN_FAIL_DESC);
        }
        entity = new ResponseEntity(resp, headers, HttpStatus.OK);
        return entity;
    }
    
}

package com.qlsv.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ApiUtil {

    public static ApiUtil getInstance(){
        return new ApiUtil();
    }

    public <T> T toModel(HttpServletRequest req, Class<T> tclass){
        try {
            req.setCharacterEncoding("UTF-8");
            return new ObjectMapper().readValue(req.getInputStream(), tclass);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}

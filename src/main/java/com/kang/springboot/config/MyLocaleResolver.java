package com.kang.springboot.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author klr
 * @create 2020-03-27-14:09
 */

//地区解析器，国际化

public class MyLocaleResolver implements LocaleResolver {

    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {

        //解析request得参数
        String language=httpServletRequest.getParameter("l");
        Locale locale=Locale.getDefault();//如果没有就使用默认得
        //如果请求得链接携带了国际化得参数
        if(!StringUtils.isEmpty(language)){
            //zh_CN
            String[] split=language.split("_");
            //国家，地区
            locale=new Locale(split[0],split[1]);
        }

        return locale;

    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}

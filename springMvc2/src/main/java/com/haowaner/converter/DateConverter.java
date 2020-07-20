package com.haowaner.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * 自定义类型转换器
 */
public class DateConverter implements Converter<String, Date> {
    //将字符串转化为日期类型
    @Override
    public Date convert(String source) {
        ResourceBundle dateConverter = ResourceBundle.getBundle("dateConverter");
        String dateString = dateConverter.getString("date");
        //等下使用配置文件的方式读取传来的字符串格式
        //定义转化字符串类型  yyyy-MM-dd
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateString);
        Date date = null;
        try {
            date = dateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}

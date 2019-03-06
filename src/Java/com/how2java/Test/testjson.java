package com.how2java.Test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class testjson {
    @Test
    public void objectToJson(){
        User user = new User("dmego","1234");
        String UserJson = JSON.toJSONString(user);
        System.out.println("简单java类转json字符串:"+UserJson);

    }
}

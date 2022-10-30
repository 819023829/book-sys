package com.book.common.lang;

import com.book.mbp.entity.Administer;


import java.util.HashMap;

/**
 * @author zcz
 * @created 2022/9/20 16:33
 */
public class UserTokenInfo {
    public static HashMap<String, Administer> TokenPool=new HashMap<>();
    public static Administer getUserInfo(String token){
        return TokenPool.get(token);
    }
}

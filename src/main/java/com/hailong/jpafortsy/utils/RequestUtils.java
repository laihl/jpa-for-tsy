package com.hailong.jpafortsy.utils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RequestUtils {


    /**
     * 二进制读取
     * @param request
     * @return
     */
    public static byte[] readBodyBytes(HttpServletRequest request)
    {

        int len = request.getContentLength();
        if (len==-1){
            return new byte[]{};
        }
        byte[] buffer = new byte[len];
        ServletInputStream in = null;

        try
        {
            in = request.getInputStream();
            in.read(buffer, 0, len);
            in.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (null != in)
            {
                try
                {
                    in.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return buffer;
    }


}

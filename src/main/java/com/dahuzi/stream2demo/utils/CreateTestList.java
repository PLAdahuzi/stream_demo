package com.dahuzi.stream2demo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dahuzi.stream2demo.entity.OprCategoryEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * [简要描述]:
 * [详细描述]:
 *
 * @author mjye
 * @version 1.0, 2019/12/17 11:45
 * @since JDK 1.8
 */
@Slf4j
public class CreateTestList
{
    public static void main(String[] args)
    {
        List<OprCategoryEntity> listPage = createListPage();
        System.out.println(JSON.toJSON(listPage));
    }

    public static List<OprCategoryEntity> createListPage()
    {
        String pageListString = getData();
        return JSONObject.parseArray(pageListString, OprCategoryEntity.class);
    }

    public static String getData()
    {
        BufferedReader br = null;
        try
        {
            String DATA_PATH = "category.json";
            InputStream resourceAsStream = ResourceUtils.class.getClassLoader().getResourceAsStream(DATA_PATH);
            if (null != resourceAsStream)
            {

                br = new BufferedReader(new InputStreamReader(resourceAsStream));
                String readLine;
                StringBuilder keyValue = new StringBuilder();
                while ((readLine = br.readLine()) != null)
                {
                    if (!(readLine.charAt(0) == '-'))
                    {
                        keyValue.append(readLine);
                    }
                }
                return keyValue.toString();
            }
            else
            {
                return null;
            }
        }
        catch (Exception e)
        {
            log.error("RSA密钥读取错误", e);
            return null;
        }
        finally
        {
            if (br != null)
            {
                try
                {
                    br.close();
                }
                catch (Exception e)
                {
                    log.error("密钥读取流关闭异常");
                }
            }
        }
    }
}
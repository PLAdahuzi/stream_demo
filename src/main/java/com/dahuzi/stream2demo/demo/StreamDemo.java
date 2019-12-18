package com.dahuzi.stream2demo.demo;

import com.alibaba.fastjson.JSON;
import com.dahuzi.stream2demo.entity.OprCategoryEntity;
import com.dahuzi.stream2demo.utils.CreateTestList;

import java.util.*;
import java.util.stream.Collectors;

/**
 * [简要描述]:
 * [详细描述]:
 *
 * @author mjye
 * @version 1.0, 2019/12/18 10:27
 * @since JDK 1.8
 */
public class StreamDemo
{
    private static List<OprCategoryEntity> list;

    static
    {
        list = CreateTestList.createListPage();
    }

    public static void main(String[] args)
    {
        group();
    }

    /**
     * [简要描述]: 分组
     * [详细描述]:
     * @return void
     * mjye  2019/12/18 - 16:33
     **/
    public static void group()
    {
        Map<Integer, List<OprCategoryEntity>> collect = list.stream()
                .collect(Collectors.groupingBy(OprCategoryEntity::getLevel));
        System.out.println(collect);

        Map<Integer, Set<String>> levelCategoryNoMap = new HashMap<>(1);
        list.stream().collect(Collectors.groupingBy(OprCategoryEntity::getLevel)).forEach((level, entitys) ->
        {
            Set<String> categoryNos = new HashSet<>(entitys.size());
            entitys.forEach(entity -> categoryNos.add(entity.getCategoryNo()));
            levelCategoryNoMap.put(level, categoryNos);
        });
        System.out.println(JSON.toJSONString(levelCategoryNoMap));
    }

    /**
     * [简要描述]: 升序
     * [详细描述]:
     *
     * @return void
     * mjye  2019/12/18 - 16:09
     **/
    public static void sortfieldAsc()
    {
        List<OprCategoryEntity> collect = list.stream().sorted(Comparator.comparing(OprCategoryEntity::getSort))
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * [简要描述]: 降序
     * [详细描述]:
     *
     * @return void
     * mjye  2019/12/18 - 16:09
     **/
    public static void sortfieldDesc()
    {
        List<OprCategoryEntity> collect = list.stream()
                .sorted(Comparator.comparing(OprCategoryEntity::getSort).reversed()).collect(Collectors.toList());
        System.out.println(collect);
    }
}
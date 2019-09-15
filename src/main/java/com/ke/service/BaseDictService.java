package com.ke.service;

import com.ke.pojo.BaseDict;

import java.util.List;

/**
 * @Author: YangxingLiu
 * @Description:
 * @Date: Created in 2019/9/15 21:02
 * @Modified By:
 */
public interface BaseDictService {
    public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);
}

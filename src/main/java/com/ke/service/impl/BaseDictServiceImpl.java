package com.ke.service.impl;


import com.ke.mapper.BaseDictMapper;
import com.ke.pojo.BaseDict;
import com.ke.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: YangxingLiu
 * @Description:
 * @Date: Created in 2019/9/15 21:04
 * @Modified By:
 */
@Service
public class BaseDictServiceImpl implements BaseDictService {
    @Autowired
    private BaseDictMapper baseDictMapper;
    @Override
    public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode) {
        return this.baseDictMapper.queryBaseDictByDictTypeCode(dictTypeCode);
    }
}

package com.ke.mapper;

import com.ke.pojo.BaseDict;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: YangxingLiu
 * @Description: 对BaseDict进行CURD
 * @Date: Created in 2019/9/15 19:00
 * @Modified By:
 */
@Repository
public interface BaseDictMapper {
    /**
     * @Author: YangxingLiu
     * @Description: 根据类别代码查询数据
     * @Date: Created in 20:59 2019/9/15
     * @Param dictTypeCode:
     * @return: java.util.List<com.ke.pojo.BaseDict>
     **/
    List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);
}

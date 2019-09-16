package com.ke.mapper;

import com.ke.pojo.Customer;
import com.ke.pojo.QueryVo;

import java.util.List;

/**
 * @Author: YangxingLiu
 * @Description:
 * @Date: Created in 2019/9/15 22:06
 * @Modified By:
 */
public interface CustomerMapper {
    /**
     * @Author: YangxingLiu
     * @Description: 根据queryVo分页查询数据
     * @Date: Created in 22:08 2019/9/15
     * @Param queryVo:
     * @return: java.util.List<com.ke.pojo.Customer>
     **/
    List<Customer> queryCustomerByQueryVo(QueryVo queryVo);

    /**
     * @Author: YangxingLiu
     * @Description: 根据queryVo查询数据条数
     * @Date: Created in 22:09 2019/9/15
     * @Param queryVo:
     * @return: java.lang.Integer
     **/
    Integer queryCountByQueryVo(QueryVo queryVo);

    /**
     * @Author: YangxingLiu
     * @Description: 根据id查询用户
     * @Date: Created in 23:13 2019/9/15
     * @Param id:
     * @return: com.ke.pojo.Customer
     **/
    Customer queryCustomerById(Long id);

    /**
     * @Author: YangxingLiu
     * @Description: 根据id编辑客户
     * @Date: Created in 23:22 2019/9/15
     * @Param customer:
     * @return: void
     **/
    void updateCustomerById(Customer customer);
    /**
     * @Author: YangxingLiu
     * @Description: 根据id删除用户
     * @Date: Created in 20:35 2019/9/16
     * @Param id:
     * @return: void
     **/
    void deleteCustomerById(Long id);
}

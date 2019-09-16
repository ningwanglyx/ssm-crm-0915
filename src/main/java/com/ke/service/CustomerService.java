package com.ke.service;

import com.ke.pojo.Customer;
import com.ke.pojo.QueryVo;
import com.ke.utils.Page;

/**
 * @Author: YangxingLiu
 * @Description:
 * @Date: Created in 2019/9/15 22:27
 * @Modified By:
 */
public interface CustomerService {
    /**
     * @Author: YangxingLiu
     * @Description: 根据条件分页查询客户
     * @Date: Created in 22:28 2019/9/15
     * @Param queryVo:
     * @return: com.ke.utils.Page<com.ke.pojo.Customer>
     **/
    Page<Customer> queryCustomerByQueryVo(QueryVo queryVo);

    /**
     * @Author: YangxingLiu
     * @Description: 根据id查询客户
     * @Date: Created in 23:15 2019/9/15
     * @Param id:
     * @return: com.ke.pojo.Customer
     **/
    Customer queryCustomerById(Long id);
    /**
     * @Author: YangxingLiu
     * @Description: 根据id编辑客户信息
     * @Date: Created in 23:24 2019/9/15
     * @Param customer:
     * @return: void
     **/
    void updateCustomerById(Customer customer);

    void deleteCustomerById(Long id);
}

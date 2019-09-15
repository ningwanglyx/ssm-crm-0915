package com.ke.service.impl;

import com.ke.mapper.CustomerMapper;
import com.ke.pojo.Customer;
import com.ke.pojo.QueryVo;
import com.ke.service.CustomerService;
import com.ke.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: YangxingLiu
 * @Description:
 * @Date: Created in 2019/9/15 22:29
 * @Modified By:
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo) {
        //设置查询条件，从哪一条数据开始
        queryVo.setStart((queryVo.getPage()-1)*queryVo.getRows());

        List<Customer> list = this.customerMapper.queryCustomerByQueryVo(queryVo);
        Integer total = this.customerMapper.queryCountByQueryVo(queryVo);

        Page<Customer> page = new Page<Customer>(total, queryVo.getPage(), queryVo.getRows(), list);
        return page;
    }

    @Override
    public Customer queryCustomerById(Long id) {
        Customer cus = this.customerMapper.queryCustomerById(id);
        return cus;
    }

    @Override
    public void updateCustomerById(Customer customer) {
        this.customerMapper.updateCustomerById(customer);
    }
}

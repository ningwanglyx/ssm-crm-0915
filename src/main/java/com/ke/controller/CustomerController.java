package com.ke.controller;


import com.ke.pojo.BaseDict;
import com.ke.pojo.Customer;
import com.ke.pojo.QueryVo;
import com.ke.service.BaseDictService;
import com.ke.service.CustomerService;
import com.ke.utils.Page;
import com.mchange.v2.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @Author: YangxingLiu
 * @Description:
 * @Date: Created in 2019/9/15 18:59
 * @Modified By:
 */
@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private BaseDictService baseDictService;
    @Autowired
    private CustomerService customerService;
   /**
    * @Author: YangxingLiu
    * @Description: 显示用户列目标
    * @Date: Created in 21:08 2019/9/15
    * @Param model:
    * @return: java.lang.String
    **/
    @RequestMapping("list")
    public String queryCustomerList(QueryVo queryVo, Model model){

       /* try {
            queryVo.setCustName(new String(queryVo.getCustName().getBytes("ISO-8859-1"), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/

        //fromType 客户来源
        List<BaseDict> fromType = this.baseDictService.queryBaseDictByDictTypeCode("002");
        model.addAttribute("fromType", fromType);
        //industryType 所属行业
        List<BaseDict> industryType = this.baseDictService.queryBaseDictByDictTypeCode("001");
        model.addAttribute("industryType", industryType);
        //levelType 客户级别
        List<BaseDict> levelType = this.baseDictService.queryBaseDictByDictTypeCode("006");
        model.addAttribute("levelType", levelType);

        //分页查询数据
        Page<Customer> page = this.customerService.queryCustomerByQueryVo(queryVo);
        //把分页查询的结果放到模型中
        model.addAttribute("page", page);
        //数据回显
        model.addAttribute("custName", queryVo.getCustName());
        model.addAttribute("custSource", queryVo.getCustSource());
        model.addAttribute("custIndustry", queryVo.getCustIndustry());
        model.addAttribute("custLevel", queryVo.getCustLevel());
        return "customer";
    }
    @RequestMapping("edit")
    @ResponseBody
    /**
     * @Author: YangxingLiu
     * @Description: 根据id查询用户，返回jason格式数据
     * @Date: Created in 23:20 2019/9/15
     * @Param id:
     * @return: com.ke.pojo.Customer
     **/
    public Customer queryCustomerById(Long id){
        return this.customerService.queryCustomerById(id);
    }

    /**
     * @Author: YangxingLiu
     * @Description: 根据id查询用户,返回更新客户后的json格式数据
     * @Date: Created in 23:26 2019/9/15
     * @Param customer:
     * @return: java.lang.String
     **/
    @RequestMapping("update")
    @ResponseBody
    public String updateCustomerById(Customer customer){
        this.customerService.updateCustomerById(customer);
        return "OK";
    }
}

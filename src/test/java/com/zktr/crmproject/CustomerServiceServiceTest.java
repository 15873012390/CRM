package com.zktr.crmproject;

import com.zktr.crmproject.pojos.Contacts;
import com.zktr.crmproject.pojos.Customer;
import com.zktr.crmproject.pojos.Customerservice;
import com.zktr.crmproject.service.HTCustomerServiceService;
import com.zktr.crmproject.vo.Pager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerServiceServiceTest {
    @Autowired
    private HTCustomerServiceService customerServiceService;
    @Test
    public void testFindByAllCustomerService(){
        List<Customerservice> list = customerServiceService.findByAllCustomerService();
        for(Customerservice c:list){
            System.out.println("你有城地地 "+c.getCustomer().getCusId());
        }

    }
    @Test
    public void testQueryAllCustomerByPage(){
        Pager<Customerservice> customerservicePager = customerServiceService.queryAllCustomerServiceByPage(1, 5);
        List<Customerservice> list = customerservicePager.getList();
        for(Customerservice list1:list){
            System.out.println(list1);
        }


    }
    @Test
    public void testSelectALL(){
        List<Customer> customers = customerServiceService.queryAllCustomer();
        for(Customer customer:customers){
            System.out.println(customer);
        }

    }
    @Test
    public void testQueryContactsByCusId(){
        List<Contacts> contacts = customerServiceService.queryContactsByCusId(1);
        for(Contacts contacts1:contacts){
            System.out.println(contacts1);
        }

    }


}

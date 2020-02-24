package com.zktr.crmproject.test;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthorityServiceTest {
    @Autowired
    private AuthorityService authorityService;

    @Test
    public void testSaveRole(){
        Rolex rolex = new Rolex();
        //rolex.setRoleName("系统管理员");
        //rolex.setRoleName("经理");
        rolex.setRoleName("业务员");
        //rolex.setRoleName("迎宾");

        authorityService.saveRole(rolex);
    }

    @Test
    public void testQueryAllRoles(){
        List<Rolex> list = authorityService.queryAllRoles();
        Assert.assertEquals(4, list.size());
    }

    @Test
    public void testDeleteRoles(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        authorityService.deleteRoles(list);
    }

    @Test
    public void testGetRoleDetails(){
        Map map = authorityService.getRoleDetails(4);
        //System.out.println(rolex.getRoleName());
    }
}

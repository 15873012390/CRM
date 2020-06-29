package com.zktr.crmproject.dao.mybatis;


import com.zktr.crmproject.pojos.Complaint;
import com.zktr.crmproject.vo.ComplaintAdvancedSearch;
import com.zktr.crmproject.vo.CustomerCareAdvancedSearch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HTIComplaintDao {

    public List<Complaint> queryAllByPage();

    public Complaint queryById(Integer csId);

    public List<Complaint> queryLikeComplaint(String value,String input,String select);

    public List<Complaint> queryComplaintByPage(ComplaintAdvancedSearch cas);

    public List pieChartQuery(String selectValue);

    public List queryByMonth();

    public List queryByMonthBySelect(String year);

    public List queryByCustomer();

    public void insertComplaint(Complaint complaint);

    public void updateComplaint(Complaint complaint);

    public void deleteByComId(Integer comId);

}

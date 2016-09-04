package org.invoice.dao;

import org.invoice.entity.SuccessPrinted;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/9/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessPrintedDaoTest {

    @Resource
    private SuccessPrintedDao successPrintedDao;
    @Test
    public void insertSuccessPrinted() throws Exception {
        long id = 1001L;
        long phone = 13502181181L;
        int insertCount = successPrintedDao.insertSuccessPrinted(id, phone);
        System.out.println("insertCount=" + insertCount);
    }

    @Test
    public void queryByIdWithInvoice() throws Exception {
        long id = 1001L;
        long phone = 13502181181L;
        SuccessPrinted successPrinted = successPrintedDao.queryByIdWithInvoice(id, phone);
        System.out.println(successPrinted);
        System.out.println(successPrinted.getInvoice());
    }
}
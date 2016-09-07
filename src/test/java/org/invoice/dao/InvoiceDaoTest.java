package org.invoice.dao;

import org.invoice.entity.Invoice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/9/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class InvoiceDaoTest {

    @Resource
    private InvoiceDao invoiceDao;

    @Test
    public void queryById() throws Exception {
        long id = 1000;
        Invoice invoice = invoiceDao.queryById(id);
        System.out.println(invoice.getName());
        System.out.println(invoice);
    }

    @Test
    public void queryByIds() throws Exception {
        List<Long> l = new ArrayList<Long>();
        l.add(1000L);
        l.add(1001L);
        l.add(1002L);
        List<Invoice> invoices = invoiceDao.queryByIds(l);
        for (Invoice invoice: invoices) {
            System.out.println(invoice);
        }
    }

    @Test
    public void queryAll() throws Exception {
        List<Invoice> invoices = invoiceDao.queryAll(0, 100);
        for (Invoice invoice : invoices) {
            System.out.println(invoice);
        }
    }

    @Test
    public void printInvoice() throws Exception {
        Date printTime = new Date();
        int updateCount = invoiceDao.printInvoice(1000L,printTime);
        System.out.println("updateCount=" + updateCount);
    }

    @Test
    public  void insertInvoice() throws Exception {
        Date testTime = new Date();
        Invoice invoice = new Invoice("testCombo", 1, (short) 1, testTime, testTime);
        int updateCount = invoiceDao.insertInvoice(invoice);
        System.out.println("updateCount=" + updateCount);
    }

    @Test
    public void setupConnection() throws Exception {
        List<Long> l = new ArrayList<Long>();
        l.add(1000L);
        l.add(1001L);
        int updateCount = invoiceDao.setupConnection(1004L,l);
        System.out.println("updateCount=" + updateCount);
    }


}
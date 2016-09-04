package org.invoice.dao;

import org.invoice.entity.Invoice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

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
}
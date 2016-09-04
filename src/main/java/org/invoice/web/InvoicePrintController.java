package org.invoice.web;

import org.invoice.dto.Exposer;
import org.invoice.dto.InvoicePrintExecution;
import org.invoice.dto.InvoiceResult;
import org.invoice.entity.Invoice;
import org.invoice.enums.InvoiceStatEnum;
import org.invoice.exception.InvoiceCloseException;
import org.invoice.exception.RepeatPrintException;
import org.invoice.service.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/9/5.
 */
@Controller//@Service @Component
@RequestMapping("/invoice")// url:/模块/资源/{id}/细分 /invoice/list
public class InvoicePrintController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    InvoiceService invoiceService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        //获取列表页
        List<Invoice> list = invoiceService.getInvoiceList();
        model.addAttribute("list", list);
        //list.jsp + model = ModelAndView
        return "list";// /WEB-INF/jsp/"list".jsp
    }

    @RequestMapping(value = "/{invoiceId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable("invoiceId") Long invoiceId, Model model) {
        if (invoiceId == null) {
            return "redirect:/invoice/list";
        }
        Invoice invoice = invoiceService.getById(invoiceId);
        if (invoice == null) {
            return "forward:/invoice/list";
        }
        model.addAttribute("invoice", invoice);
        return "detail";
    }


    //ajax json
    @RequestMapping(value = "/{invoiceId}/exposer",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public InvoiceResult<Exposer> exposer(@PathVariable Long invoiceId) {
        InvoiceResult<Exposer> result;
        try {
            Exposer exposer = invoiceService.exportInvoicePrintUrl(invoiceId);
            result = new InvoiceResult<Exposer>(true, exposer);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new InvoiceResult<Exposer>(false, e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/{invoiceId}/{md5}/execution",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public InvoiceResult<InvoicePrintExecution> execute(@PathVariable("invoiceId") Long invoiceId,
                                                        @PathVariable("md5") String md5,
                                                        @CookieValue(value = "printPhone", required = false) Long phone) {
        //springmvc valid
        if (phone == null) {
            return new InvoiceResult<InvoicePrintExecution>(false, "未注册");
        }
        InvoiceResult<InvoicePrintExecution> result;
        try {
            //存储过程调用.
            InvoicePrintExecution execution = invoiceService.executePrintInvoice(invoiceId, phone, md5);
            return new InvoiceResult<InvoicePrintExecution>(true, execution);
        } catch (RepeatPrintException e) {
            InvoicePrintExecution execution = new InvoicePrintExecution(invoiceId, InvoiceStatEnum.REPEAT_PRINT);
            return new InvoiceResult<InvoicePrintExecution>(true, execution);
        } catch (InvoiceCloseException e) {
            InvoicePrintExecution execution = new InvoicePrintExecution(invoiceId, InvoiceStatEnum.END);
            return new InvoiceResult<InvoicePrintExecution>(true, execution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            InvoicePrintExecution execution = new InvoicePrintExecution(invoiceId, InvoiceStatEnum.INNER_ERROR);
            return new InvoiceResult<InvoicePrintExecution>(true, execution);
        }
    }


    @RequestMapping(value = "/time/now",method = RequestMethod.GET)
    @ResponseBody
    public InvoiceResult<Long> time(){
        Date now = new Date();
        return new InvoiceResult(true,now.getTime());
    }
}

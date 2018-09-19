package com.yesion.action;

import com.yesion.pojo.TCustomer;
import com.yesion.service.OpenAccount;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class  OpAccuAction implements ServletResponseAware {
    private HttpServletResponse resp;
    private OpenAccount openAccount;
    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.resp = httpServletResponse;
    }

    public OpenAccount getOpenAccount() {
        return openAccount;
    }

    public void setOpenAccount(OpenAccount openAccount) {
        this.openAccount = openAccount;
    }

    public String chkIdNum() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String idNumber = request.getParameter("idNumber");
        resp.setCharacterEncoding("utf8");
        resp.setContentType("text/html");
        try {
            resp.getWriter().print(openAccount.checkIdNumber(idNumber));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String saveCustomer() {
        HttpServletRequest request = ServletActionContext.getRequest();
        TCustomer customer = new TCustomer();
        customer.setIdType(request.getParameter("idType"));
        customer.setIdNumber(request.getParameter("idNumber"));
        customer.setCustomerName(request.getParameter("cusName"));
        customer.setCustomerBirthday(request.getParameter("cusBirth"));
        customer.setCustomerSex(request.getParameter("cusSex"));
        customer.setCustomerAddress(request.getParameter("cusAddr"));
        openAccount.saveCustomer(customer);
        resp.setCharacterEncoding("utf8");
        resp.setContentType("text/html");
        try {
            resp.getWriter().print(customer.getCustomerId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String chknumber() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String number = request.getParameter("number");
        resp.setCharacterEncoding("utf8");
        resp.setContentType("text/html");
        try {
            resp.getWriter().print(openAccount.chkNumber(number));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

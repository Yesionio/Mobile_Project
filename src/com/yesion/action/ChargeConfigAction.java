package com.yesion.action;

import com.alibaba.fastjson.JSON;
import com.yesion.service.ITChargeService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ChargeConfigAction implements ServletResponseAware {
    private HttpServletResponse resp;
    private ITChargeService chargeService;
    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.resp = httpServletResponse;
    }

    public ITChargeService getChargeService() {
        return chargeService;
    }

    public void setChargeService(ITChargeService chargeService) {
        this.chargeService = chargeService;
    }

    public String queryCharge() {
        List[] list = chargeService.queryCharge();
        String chargeJson = JSON.toJSONString(list[0]);
        String chargeRuleJson = JSON.toJSONString(list[1]);
        resp.setCharacterEncoding("utf8");
        resp.setContentType("text/html");
        try {
            System.out.println(chargeJson+ "\n" +chargeRuleJson);
            resp.getWriter().printf("{\"chargeList\":%s,\"chargeRuleList\":%s}",
                    chargeJson.toString(), chargeRuleJson.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String updateCharge() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String a = request.getParameter("chargeCode");
        String b = request.getParameter("chargeName");
        double c = Double.parseDouble(request.getParameter("charge"));
        resp.setCharacterEncoding("utf8");
        resp.setContentType("text/html");
        try {
            if (chargeService.updateCharge(a, b, c)) {
                resp.getWriter().print("修改成功");
            } else {
                resp.getWriter().print("修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String updateChargeRule() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String a = request.getParameter("funcId");
        String b = request.getParameter("funcName");
        String[] c = request.getParameter("chargeRuleList").split(",");
        System.out.println(a + "  " + b + "  " + Arrays.toString(c));

        resp.setCharacterEncoding("utf8");
        resp.setContentType("text/html");
        try {
            resp.getWriter().print(chargeService.updateChargeRule(a, b, c));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

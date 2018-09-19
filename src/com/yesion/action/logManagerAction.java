package com.yesion.action;

import com.alibaba.fastjson.JSON;
import com.yesion.pojo.TOperator;
import com.yesion.service.ITOperatorService;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class logManagerAction implements ServletRequestAware, ServletResponseAware {
    private ITOperatorService itOperatorService;
    private HttpServletRequest servletRequest;
    private HttpServletResponse servletResponse;


    private String id;
    private String pwd;


    public ITOperatorService getItOperatorService() {
        return itOperatorService;
    }

    public void setItOperatorService(ITOperatorService itOperatorService) {
        this.itOperatorService = itOperatorService;
    }

    public HttpServletRequest getServletRequest() {
        return servletRequest;
    }

    @Override
    public void setServletRequest(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;
    }

    public HttpServletResponse getServletResponse() {
        return servletResponse;
    }

    @Override
    public void setServletResponse(HttpServletResponse servletResponse) {
        this.servletResponse = servletResponse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String login() {
        HttpSession session = servletRequest.getSession();
        TOperator tOperator = itOperatorService.LoginService(id, pwd);
        if (null != tOperator) {
            session.setAttribute("operator", tOperator);
            return "logok";
        }

        return "lognok";
    }

    public String fetchOperator() {
        TOperator operator = (TOperator) servletRequest.getSession().getAttribute("operator");
        try {
            String jsonObject = JSON.toJSONString(operator);
            servletResponse.setCharacterEncoding("utf8");
            servletResponse.setContentType("application/json");
            servletResponse.getWriter().print(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String saveOperator() {
        String a = servletRequest.getParameter("operatorId");
        String b = servletRequest.getParameter("operatorName");
        String c = servletRequest.getParameter("operatorPwd");
        String d = servletRequest.getParameter("isAdmin");
        TOperator operator = new TOperator(a, b, c, d);
        servletResponse.setCharacterEncoding("utf8");
        servletResponse.setContentType("text/html");
        try {
            servletResponse.getWriter().print(itOperatorService.SaveOperator(operator));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String queryOperator() {
        List topList = itOperatorService.queryOperator();
        String jsonArray = JSON.toJSONString(topList);

        servletResponse.setCharacterEncoding("utf8");
        servletResponse.setContentType("text/html");
        try {
            servletResponse.getWriter().print(jsonArray);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String updateOperator() {
        String a = servletRequest.getParameter("operatorId");
        String b = servletRequest.getParameter("operatorName");
        String c = servletRequest.getParameter("operatorPwd");
        String d = servletRequest.getParameter("isAdmin");
        TOperator operator = new TOperator(a, b, c, d);
        servletResponse.setCharacterEncoding("utf8");
        servletResponse.setContentType("text/html");
        try {
            servletResponse.getWriter().print(itOperatorService.updateOperatorService(operator));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

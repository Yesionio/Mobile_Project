package com.yesion.action;

import com.yesion.service.IResourceService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResourceManagerAction implements ServletResponseAware {
    private IResourceService resourceService;
    private HttpServletResponse resp;

    public IResourceService getResourceService() {
        return resourceService;
    }

    public void setResourceService(IResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.resp = httpServletResponse;
    }

    public String saveResource() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String a = request.getParameter("mtype");
        String b = request.getParameter("mfrom");
        String c = request.getParameter("mto");
        resp.setCharacterEncoding("utf8");
        resp.setContentType("text/html");
        try {
            if (resourceService.saveResource(b, c, a)) {
                resp.getWriter().print("保存号段成功");
            } else {
                resp.getWriter().print("保存号段失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

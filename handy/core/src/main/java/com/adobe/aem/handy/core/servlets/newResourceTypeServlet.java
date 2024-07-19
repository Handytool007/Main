package com.adobe.aem.handy.core.servlets;



import java.io.IOException;

import org.apache.sling.api.resource.Resource;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.commons.jcr.JcrConstants;

@Component(service = Servlet.class)
@SlingServletResourceTypes(
    resourceTypes = "handy/components/page",
    selectors = {"handy"},
    extensions={"txt","xml"}

)
public class newResourceTypeServlet extends SlingAllMethodsServlet {
    private static final Logger LOG=LoggerFactory.getLogger(newResourceTypeServlet.class);
@Override
protected void doGet(final SlingHttpServletRequest req, 
final SlingHttpServletResponse resp) throws ServletException, IOException{
final Resource resource=req.getResource();
resp.setContentType("text/plain");
resp.getWriter().write("Page Title=" + resource.getValueMap().get(JcrConstants.JCR_TITLE));
}
}

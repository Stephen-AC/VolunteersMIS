package edu.gdut.gytw.volunteerMIS.common.mytaglig;

import edu.gdut.gytw.volunteerMIS.common.PageBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class PageTag<T> extends SimpleTagSupport {
    private List<T> list;
    private PageBean<T> pb;
    private String var;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public PageBean<T> getPb() {
        return pb;
    }

    public void setPb(PageBean<T> pb) {
        this.pb = pb;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    @Override
    public void doTag() throws JspException, IOException {
        PageContext pageContext = (PageContext)this.getJspContext();
        int begin = pb.getCurrPage()*pb.getPageSize();
        int end = (pb.getCurrPage()+1)*pb.getPageSize();
        if(end>list.size()){
            end = list.size();
        }
        List<T> currList = list.subList(begin,end);
        Iterator<T> it = currList.iterator();
        while (it.hasNext()){
            Object obj = it.next();
            pageContext.setAttribute(var,obj);
            this.getJspBody().invoke(null);
        }
    }
}

package edu.gdut.gytw.volunteerMIS.common.mytaglig;

import edu.gdut.gytw.volunteerMIS.dao.factory.MISdaoFactory;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class ReviewResult extends SimpleTagSupport {
    private int sno;
    private String var;
    private String title;

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void doTag() throws JspException, IOException {
        PageContext pageContext = (PageContext) this.getJspContext();
        pageContext.setAttribute(this.var,MISdaoFactory.getDao().SingActivityResult(this.sno,this.title));
        this.getJspBody().invoke(null);
    }
}

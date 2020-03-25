package edu.gdut.gytw.volunteerMIS.common.mytaglig;

import edu.gdut.gytw.volunteerMIS.business.Factory.MISeboFactory;
import edu.gdut.gytw.volunteerMIS.entity.Volunteer;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class VolunteerInfoTag extends SimpleTagSupport {
    private int sno;
    private String var;

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

    @Override
    public void doTag() throws JspException, IOException {
        Volunteer volunteer = MISeboFactory.getMISeboFactory().getVolunteerInfo(this.sno);
        PageContext pageContext = (PageContext) this.getJspContext();
        pageContext.setAttribute(this.var,volunteer);
        this.getJspBody().invoke(null);
    }
}

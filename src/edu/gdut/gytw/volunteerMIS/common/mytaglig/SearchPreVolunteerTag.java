package edu.gdut.gytw.volunteerMIS.common.mytaglig;

import edu.gdut.gytw.volunteerMIS.business.Factory.MISeboFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class SearchPreVolunteerTag extends SimpleTagSupport {
    private int Sno;
    private String var;

    public int getSno() {
        return Sno;
    }

    public void setSno(int sno) {
        Sno = sno;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    @Override
    public void doTag() throws JspException, IOException {
            ((PageContext)this.getJspContext()).setAttribute(var,MISeboFactory.getMISeboFactory().searchRegisterForm(Sno));
            this.getJspBody().invoke(null);
    }
}

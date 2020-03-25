package edu.gdut.gytw.volunteerMIS.controller.filter;

import edu.gdut.gytw.volunteerMIS.business.Factory.MISeboFactory;
import edu.gdut.gytw.volunteerMIS.entity.SignActivity;

import javax.servlet.*;
import java.io.IOException;
import java.util.*;

public class SignActivityHistoryFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        Map<String,List<Integer>> map = new HashMap<>();
        List<SignActivity> list = MISeboFactory.getMISeboFactory().findAllSignActivityHistory();
        Iterator<SignActivity> it = list.iterator();
        List<String> title = new ArrayList<>();
        while (it.hasNext()){
            SignActivity signActivity = it.next();
            if (title.size()==0){
                title.add(signActivity.getTitle());
                List<Integer> list1 = new ArrayList();
                list1.add((int)signActivity.getSno());
                map.put(signActivity.getTitle(),list1);
            }else if(title.contains(signActivity.getTitle())){
                map.get(signActivity.getTitle()).add((int) signActivity.getSno());
            }else {
                title.add(signActivity.getTitle());
                List<Integer> list1 = new ArrayList();
                list1.add((int)signActivity.getSno());
                map.put(signActivity.getTitle(),list1);
            }
        }
        req.setAttribute("SignActivityMap",map);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

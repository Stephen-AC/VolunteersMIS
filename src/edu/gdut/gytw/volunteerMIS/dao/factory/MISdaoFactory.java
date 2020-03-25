package edu.gdut.gytw.volunteerMIS.dao.factory;

import edu.gdut.gytw.volunteerMIS.dao.dai.MISdai;
import edu.gdut.gytw.volunteerMIS.dao.impl.MISimpl;

public class MISdaoFactory {
    public static MISdai getDao(){
        return new MISimpl();
    }
}

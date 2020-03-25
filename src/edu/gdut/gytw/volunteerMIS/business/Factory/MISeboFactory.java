package edu.gdut.gytw.volunteerMIS.business.Factory;

import edu.gdut.gytw.volunteerMIS.business.ebi.MISebi;
import edu.gdut.gytw.volunteerMIS.business.ebo.MISebo;

public class MISeboFactory {
    public static MISebi getMISeboFactory(){
        return new MISebo();
    }
}

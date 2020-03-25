package edu.gdut.gytw.volunteerMIS.dao.dai;

import edu.gdut.gytw.volunteerMIS.entity.*;
import org.omg.CORBA.INTERNAL;

import java.util.List;

public interface MISdai {
    boolean createUser(User user);
    User getUser(User user);
    boolean deleteUser(User user);

    boolean createActivity(VolunteerActivity volunteerActivity);
    VolunteerActivity getActivity(String title);
    boolean deleteActivity(String title);
    List<VolunteerActivity> findAllActivity();

    boolean createRegisterForm(PreVolunteer preVolunteer);
    PreVolunteer searchRegisterForm(int sno);
    List<PreVolunteer> findAllPreVolunteer();
    boolean passPreVolunteer(int sno);
    boolean rejectPreVolunteer(int sno);

    Volunteer getVolunteerInfo(int sno);
    boolean saveVolunteerInfo(Volunteer volunteer);

    boolean SignActivity(int sno,String title);
    List<SignActivity> findAllSignActivity();
    List<SignActivity> findAllSignActivityHistory();
    boolean reviewSingActivity(SignActivity signActivity);

    String SingActivityResult(int sno,String title);
    List<SignActivity> FindSingActivityResultBySno(int sno);

}
package edu.gdut.gytw.volunteerMIS.business.ebo;

import edu.gdut.gytw.volunteerMIS.business.ebi.MISebi;
import edu.gdut.gytw.volunteerMIS.dao.dai.MISdai;
import edu.gdut.gytw.volunteerMIS.dao.factory.MISdaoFactory;
import edu.gdut.gytw.volunteerMIS.entity.*;

import java.util.List;

public class MISebo implements MISebi {
    @Override
    public boolean createUser(User user) {
        MISdai dao = MISdaoFactory.getDao();
        return dao.createUser(user);
    }

    @Override
    public User getUser(User user) {
        MISdai dao = MISdaoFactory.getDao();
        return dao.getUser(user);
    }

    @Override
    public boolean deleteUser(User user) {
        return false;
    }

    @Override
    public boolean createActivity(VolunteerActivity volunteerActivity) {
        MISdai dao = MISdaoFactory.getDao();
        return dao.createActivity(volunteerActivity);
    }

    @Override
    public VolunteerActivity getActivity(String title) {
        MISdai dao = MISdaoFactory.getDao();
        return dao.getActivity(title);
    }

    @Override
    public boolean deleteActivity(String title) {
        MISdai dao = MISdaoFactory.getDao();
        return dao.deleteActivity(title);
    }

    @Override
    public List<VolunteerActivity> findAllActivity() {
        MISdai dao = MISdaoFactory.getDao();
        return dao.findAllActivity();
    }

    @Override
    public boolean SignActivity(int sno, String title) {
        MISdai dao = MISdaoFactory.getDao();
        return dao.SignActivity(sno,title);
    }

    @Override
    public List<SignActivity> findAllSignActivity() {
        MISdai dao = MISdaoFactory.getDao();
        return dao.findAllSignActivity();
    }

    @Override
    public boolean reviewSingActivity(SignActivity signActivity) {
        MISdai dao = MISdaoFactory.getDao();
        return dao.reviewSingActivity(signActivity);
    }

    @Override
    public List<SignActivity> findAllSignActivityHistory() {
        MISdai dao = MISdaoFactory.getDao();
        return dao.findAllSignActivityHistory();
    }

    @Override
    public List<SignActivity> FindSingActivityResultBySno(int sno) {
        MISdai dao = MISdaoFactory.getDao();
        return dao.FindSingActivityResultBySno(sno);
    }

    @Override
    public String SingActivityResult(int sno, String title) {
        MISdai dao = MISdaoFactory.getDao();
        return dao.SingActivityResult(sno,title);
    }

    @Override
    public boolean createRegisterForm(PreVolunteer preVolunteer) {
        MISdai dao = MISdaoFactory.getDao();
        return dao.createRegisterForm(preVolunteer);
    }

    @Override
    public PreVolunteer searchRegisterForm(int sno) {
        MISdai dao = MISdaoFactory.getDao();
        return dao.searchRegisterForm(sno);
    }

    @Override
    public List<PreVolunteer> findAllPreVolunteer() {
        MISdai dao = MISdaoFactory.getDao();
        return dao.findAllPreVolunteer();
    }

    @Override
    public boolean passPreVolunteer(int sno) {
        MISdai dao = MISdaoFactory.getDao();
        return dao.passPreVolunteer(sno);
    }

    @Override
    public boolean rejectPreVolunteer(int sno) {
        MISdai dao = MISdaoFactory.getDao();
        return dao.rejectPreVolunteer(sno);
    }

    @Override
    public Volunteer getVolunteerInfo(int sno) {
        MISdai dao = MISdaoFactory.getDao();
        return dao.getVolunteerInfo(sno);
    }

    @Override
    public boolean saveVolunteerInfo(Volunteer volunteer) {
        MISdai dao = MISdaoFactory.getDao();
        return dao.saveVolunteerInfo(volunteer);
    }
}

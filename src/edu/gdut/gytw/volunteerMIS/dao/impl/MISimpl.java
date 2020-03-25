package edu.gdut.gytw.volunteerMIS.dao.impl;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.org.apache.bcel.internal.generic.Select;
import com.sun.org.apache.regexp.internal.RE;
import com.sun.scenario.effect.impl.prism.sw.PSWRenderer;
import edu.gdut.gytw.volunteerMIS.common.DBconnection;
import edu.gdut.gytw.volunteerMIS.dao.dai.MISdai;
import edu.gdut.gytw.volunteerMIS.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MISimpl implements MISdai {
    @Override
    public boolean createUser(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = null;
        try {
            conn = DBconnection.getConn();
            if (user.getRole().equals("client"))
                sql = "insert into clients values (?,?)";
            else
                sql = "insert into administrators values (?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user.getAccount());
            pstmt.setString(2, user.getPassword());
            pstmt.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public User getUser(User preuser) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = null;
        User user = null;
        try {
            conn = DBconnection.getConn();
            if (preuser.getRole().equals("client"))
                sql = "select * from clients where account=?";
            else
                sql = "select * from administrators where account=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, preuser.getAccount());
            ResultSet rs = pstmt.executeQuery();
            user = new User();
            while (rs.next()) {
                user.setAccount(rs.getInt(1));
                user.setPassword(rs.getString(2));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public boolean deleteUser(User user) {
        return false;
    }

    @Override
    public boolean createActivity(VolunteerActivity volunteerActivity) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = null;
        try {
            conn = DBconnection.getConn();
            sql = "insert into volunteermis.volunteeractivity(title, time, request, details) values (?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, volunteerActivity.getTitle());
            pstmt.setString(2, volunteerActivity.getTime());
            pstmt.setString(3, volunteerActivity.getRequest());
            pstmt.setString(4, volunteerActivity.getDetails());
            pstmt.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public VolunteerActivity getActivity(String title) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = null;
        VolunteerActivity volunteerActivity = null;
        sql = "select * from volunteermis.volunteeractivity where title=?";
        try {
            conn = DBconnection.getConn();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            ResultSet rs = pstmt.executeQuery();
            volunteerActivity = new VolunteerActivity();
            while (rs.next()) {
                volunteerActivity.setTitle(rs.getString(2));
                volunteerActivity.setTime(rs.getString(3));
                volunteerActivity.setRequest(rs.getString(4));
                volunteerActivity.setDetails(rs.getString(5));
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return volunteerActivity;
    }

    @Override
    public boolean deleteActivity(String title) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = null;
        VolunteerActivity volunteerActivity = null;
        sql = "drop from volunteermis.volunteeractivity where title=?";
        try {
            conn = DBconnection.getConn();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.execute();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public List<VolunteerActivity> findAllActivity() {
        Connection conn = null;
        Statement stmt = null;
        String sql = null;
        List<VolunteerActivity> list = null;
        VolunteerActivity activity = null;
        try {
            conn = DBconnection.getConn();
            list = new ArrayList<VolunteerActivity>();
            sql = "select * from volunteeractivity order by id desc;";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                activity = new VolunteerActivity();
                activity.setTitle(rs.getString(2));
                activity.setTime(rs.getString(3));
                activity.setRequest(rs.getString(4));
                activity.setDetails(rs.getString(5));
                list.add(activity);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public boolean SignActivity(int sno, String title) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = null;
        try {
            conn = DBconnection.getConn();
            sql = "select * from signactivity where sno=? and title=?;";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,sno);
            pstmt.setString(2,title);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                return false;
            }
            sql = "insert into signactivity(sno, title) values (?,?);";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,sno);
            pstmt.setString(2,title);
            pstmt.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List<SignActivity> findAllSignActivity() {
        SignActivity signActivity = null;
        Connection conn = null;
        String sql = null;
        Statement stmt = null;
        List<SignActivity> list = null;
        try {
            conn = DBconnection.getConn();
            list = new ArrayList<>();
            sql = "select sno,title from signactivity where result='审核中' order by title;";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                signActivity = new SignActivity();
                signActivity.setSno(rs.getInt(1));
                signActivity.setTitle(rs.getString(2));
                signActivity.setResult("审核中");
                list.add(signActivity);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<SignActivity> findAllSignActivityHistory() {
        SignActivity signActivity = null;
        Connection conn = null;
        String sql = null;
        Statement stmt = null;
        List<SignActivity> list = null;
        try {
            conn = DBconnection.getConn();
            list = new ArrayList<>();
            sql = "select * from signactivity order by title;";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                signActivity = new SignActivity();
                signActivity.setSno(rs.getInt(1));
                signActivity.setTitle(rs.getString(2));
                signActivity.setResult(rs.getString(3));
                list.add(signActivity);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean reviewSingActivity(SignActivity signActivity) {
        Connection conn = null;
        String sql = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBconnection.getConn();
            sql = "select result from signactivity where sno=? and title=?;";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,(int) signActivity.getSno());
            pstmt.setString(2,signActivity.getTitle());
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            if (rs.getString(1).equals("审核中")){
                sql = "update signactivity set result = ? where sno=? and title=?;";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,signActivity.getResult());
                pstmt.setInt(2,(int) signActivity.getSno());
                pstmt.setString(3,signActivity.getTitle());
                pstmt.execute();
                return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String SingActivityResult(int sno, String title) {
        String result = null;
        Connection conn = null;
        String sql = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBconnection.getConn();
            sql = "select result from signactivity where sno=? and title=?;";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,sno);
            pstmt.setString(2,title);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                result = rs.getString(1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<SignActivity> FindSingActivityResultBySno(int sno) {
        List<SignActivity> list = null;
        SignActivity signActivity = null;
        Connection conn = null;
        String sql = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBconnection.getConn();
            list = new ArrayList<>();
            sql = "select * from signactivity where sno=?;";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,sno);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                signActivity = new SignActivity();
                signActivity.setSno(sno);
                signActivity.setTitle(rs.getString(2));
                signActivity.setResult(rs.getString(3));
                list.add(signActivity);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean createRegisterForm(PreVolunteer preVolunteer) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        String sql1 = null;
        String sql2 = null;
        try {
            conn = DBconnection.getConn();
            sql1 = "insert into student_base_info values (?,?,?,?,?,?,?);";
            sql2 = "insert into prevolunteer_info values (?,?,?,?,?);";
            pstmt1 = conn.prepareStatement(sql1);
            pstmt1.setInt(1, preVolunteer.getSno());
            pstmt1.setString(2, preVolunteer.getName());
            pstmt1.setString(3, preVolunteer.getSex().toString());
            pstmt1.setInt(4, preVolunteer.getGrade());
            pstmt1.setString(5, preVolunteer.getMajor());
            pstmt1.setString(6, preVolunteer.getSemester());
            pstmt1.setString(7, preVolunteer.getPhone());
            pstmt1.execute();
            pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setInt(1, preVolunteer.getSno());
            pstmt2.setString(2, preVolunteer.getDialect());
            pstmt2.setString(3, preVolunteer.getSpeciality());
            pstmt2.setString(4, preVolunteer.getReason());
            pstmt2.setString(5, preVolunteer.getExperience());
            pstmt2.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public PreVolunteer searchRegisterForm(int sno) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = null;
        PreVolunteer preVolunteer = null;
        try {
            conn = DBconnection.getConn();
            sql = "select * from prevolunteer where sno=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, sno);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                preVolunteer = new PreVolunteer();
                preVolunteer.setSno(rs.getInt(1));
                preVolunteer.setName(rs.getString(2));
                preVolunteer.setSex(Sex.getType(rs.getString(3)));
                preVolunteer.setGrade(rs.getInt(4));
                preVolunteer.setMajor(rs.getString(5));
                preVolunteer.setSemester(rs.getString(6));
                preVolunteer.setPhone(rs.getString(7));
                preVolunteer.setDialect(rs.getString(8));
                preVolunteer.setSpeciality(rs.getString(9));
                preVolunteer.setReason(rs.getString(10));
                preVolunteer.setExperience(rs.getString(11));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preVolunteer;
    }

    @Override
    public List<PreVolunteer> findAllPreVolunteer() {
        List<PreVolunteer> list = new ArrayList<PreVolunteer>();
        Connection conn = null;
        Statement stmt = null;
        String sql = null;
        PreVolunteer preVolunteer = null;
        try {
            conn = DBconnection.getConn();
            sql = "select * from prevolunteer;";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                preVolunteer = new PreVolunteer();
                preVolunteer.setSno(rs.getInt(1));
                preVolunteer.setName(rs.getString(2));
                preVolunteer.setSex(Sex.getType(rs.getString(3)));
                preVolunteer.setGrade(rs.getInt(4));
                preVolunteer.setMajor(rs.getString(5));
                preVolunteer.setSemester(rs.getString(6));
                preVolunteer.setPhone(rs.getString(7));
                preVolunteer.setDialect(rs.getString(8));
                preVolunteer.setSpeciality(rs.getString(9));
                preVolunteer.setReason(rs.getString(10));
                preVolunteer.setExperience(rs.getString(11));
                list.add(preVolunteer);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean passPreVolunteer(int sno) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = null;
        PreVolunteer preVolunteer = null;
        try {
            conn = DBconnection.getConn();
            sql = "insert into clients (account, password) values (?,?);";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, sno);
            pstmt.setString(2, String.valueOf(sno));
            pstmt.execute();
            sql = "insert into volunteer_info(sno,dialect,speciality,experience) values" +
                    " (?,(select prevolunteer_info.dialect from prevolunteer_info where sno = ?)," +
                    "(select prevolunteer_info.speciality from prevolunteer_info where sno = ?)," +
                    "(select prevolunteer_info.experience from prevolunteer_info where sno = ?))";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,sno);
            pstmt.setInt(2,sno);
            pstmt.setInt(3,sno);
            pstmt.setInt(4,sno);
            pstmt.execute();
            sql = "delete from prevolunteer_info where sno=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, sno);
            pstmt.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean rejectPreVolunteer(int sno) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = null;
        PreVolunteer preVolunteer = null;
        try {
            conn = DBconnection.getConn();
            sql = "delete from prevolunteer_info where sno=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, sno);
            pstmt.execute();
            sql = "delete from student_base_info where sno=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, sno);
            pstmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Volunteer getVolunteerInfo(int sno) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = null;
        Volunteer Volunteer = null;
        try {
            conn = DBconnection.getConn();
            Volunteer = new Volunteer();
            sql = "select * from volunteer where sno=?;";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,sno);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Volunteer.setSno(rs.getInt(1));
                Volunteer.setName(rs.getString(2));
                Volunteer.setSex(Sex.getType(rs.getString(3)));
                Volunteer.setGrade(rs.getInt(4));
                Volunteer.setMajor(rs.getString(5));
                Volunteer.setSemester(rs.getString(6));
                Volunteer.setPhone(rs.getString(7));
                Volunteer.setNative_place(rs.getString(8));
                Volunteer.setDialect(rs.getString(9));
                Volunteer.setCharacter(rs.getString(10));
                Volunteer.setSpeciality(rs.getString(11));
                Volunteer.setWechat(rs.getString(12));
                Volunteer.setQq(rs.getString(13));
                Volunteer.setDrom(rs.getString(14));
                Volunteer.setExperience(rs.getString(15));
                Volunteer.setVolExperience(rs.getString(16));
                Volunteer.setOthers(rs.getString(17));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Volunteer;
    }

    @Override
    public boolean saveVolunteerInfo(Volunteer volunteer) {
        Connection conn = null;
        String sql = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBconnection.getConn();
            sql = "update student_base_info set major=?,semester=?,phone=? where sno=?;";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,volunteer.getMajor());
            pstmt.setString(2,volunteer.getSemester());
            pstmt.setString(3,volunteer.getPhone());
            pstmt.setInt(4,volunteer.getSno());
            pstmt.execute();
            sql = "update volunteer_info set native_place=?,dialect=?,speciality=?,wechat=?,QQ=?,drom=?,experience=?,vol_experience=?,others=?,`character`=? where sno=?;";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,volunteer.getNative_place());
            pstmt.setString(2,volunteer.getDialect());
            pstmt.setString(3,volunteer.getSpeciality());
            pstmt.setString(4,volunteer.getWechat());
            pstmt.setString(5,volunteer.getQq());
            pstmt.setString(6,volunteer.getDrom());
            pstmt.setString(7,volunteer.getExperience());
            pstmt.setString(8,volunteer.getVolExperience());
            pstmt.setString(9,volunteer.getOthers());
            pstmt.setString(10,volunteer.getCharacter());
            pstmt.setInt(11,volunteer.getSno());
            pstmt.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}

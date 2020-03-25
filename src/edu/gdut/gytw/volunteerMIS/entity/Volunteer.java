package edu.gdut.gytw.volunteerMIS.entity;


public class Volunteer extends Student{
  private String native_place;
  private String dialect;
  private String character;
  private String speciality;
  private String wechat;
  private String qq;
  private String drom;
  private String experience;
  private String volExperience;
  private String others;

    public String getNative_place() {
        return native_place;
    }

    public void setNative_place(String native_place) {
        this.native_place = native_place;
    }

    public String getDialect() {
    return dialect;
  }

  public void setDialect(String dialect) {
    this.dialect = dialect;
  }


  public String getCharacter() {
    return character;
  }

  public void setCharacter(String character) {
    this.character = character;
  }


  public String getSpeciality() {
    return speciality;
  }

  public void setSpeciality(String speciality) {
    this.speciality = speciality;
  }


  public String getWechat() {
    return wechat;
  }

  public void setWechat(String wechat) {
    this.wechat = wechat;
  }


  public String getQq() {
    return qq;
  }

  public void setQq(String qq) {
    this.qq = qq;
  }


  public String getDrom() {
    return drom;
  }

  public void setDrom(String drom) {
    this.drom = drom;
  }


  public String getExperience() {
    return experience;
  }

  public void setExperience(String experience) {
    this.experience = experience;
  }


  public String getVolExperience() {
    return volExperience;
  }

  public void setVolExperience(String volExperience) {
    this.volExperience = volExperience;
  }


  public String getOthers() {
    return others;
  }

  public void setOthers(String other) {
    this.others = other;
  }

}

package edu.gdut.gytw.volunteerMIS.entity;

public enum Sex {
    男("男",1),女("女",2);

    private String name;
    private int index;

    Sex(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getString(int index){
        for (Sex sex: Sex.values()){
            if (sex.index == index){
                return sex.name;
            }
        }
        return  null;
    }

    public static Sex getType(String string){
        for (Sex sex: Sex.values()){
            if(sex.name.equals(string))
                return sex;
        }
        return null;
    }
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

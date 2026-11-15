public class Students {

    private String name;
    private int group;
    private int mark;

    public Students(String name, int group, int mark) {
        this.name = name;
        this.group = group;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }
    public int getGroup() {
        return group;
    }
    public int getMark() {
        return mark;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGroup(int group) {
        this.group = group;
    }
    public void setMark(int mark) {
        this.mark = mark;
    }

}

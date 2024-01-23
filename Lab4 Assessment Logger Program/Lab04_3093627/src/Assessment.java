public abstract class Assessment {

    private String title;
    private String mark;

    /**
    * @param title
    * @param mark
    */
    public Assessment(String title, String mark) {
        this.title = title;
        this.mark = mark;
    }

    /**
    * @return the title
    */
    public String getTitle() {
        return title; //################### RETURN ####################
    } 

    /**
    * @param title
    */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
    * @return the mark
    */
    public String getMark() {
        return mark; //################### RETURN ####################
    }

    /**
    * @param mark
    */
    public void setMark(String mark) {
        this.mark = mark;
    }

    public abstract void submit(int studentID);
}

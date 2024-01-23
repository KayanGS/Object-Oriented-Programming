public class Exercise extends Assessment {

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_GREEN = "\u001B[32m";
    private int studentID;
    private boolean isFirstSubmission = true;

    /**
     * @param title
     * @param mark
     */
    public Exercise(String title, String mark) {
        super(title, mark);
    }

    /**
     * @return the studentID
     */
    public int getStudentID() {
        return studentID; //################### RETURN ####################
    }

    /**
     * @param studentID the studentID to set
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    /**
     * @return the isFirstSubmission
     */
    @Override
    public void submit(int studentID) {
        this.studentID = studentID;
        // Create an instance of AssessmentLogger
        AssessmentLogger assessmentLogger = AssessmentLogger.getInstance();
        // If it is the first submission add to submitted.log
        if (isFirstSubmission) {
        
            System.out.println(ANSI_GREEN);
            
            assessmentLogger.log(
                AssessmentLogger.Event.SUBMITTED,
                "Exercise tile: " +
                ANSI_BLUE +
                getTitle() +
                ANSI_GREEN +
                " submitted by Student ID " +
                ANSI_BLUE +
                studentID
            );
        isFirstSubmission = false;

        } else {
            // If it is not the first submission add to updated.log
            System.out.println(ANSI_YELLOW);
      
            assessmentLogger.log(
                AssessmentLogger.Event.UPDATED,
                "Exercise title: " +
                ANSI_BLUE +
                getTitle() +
                ANSI_YELLOW +
                " updated by Student ID " +
                ANSI_BLUE +
                studentID
            );
        }   
    }
}

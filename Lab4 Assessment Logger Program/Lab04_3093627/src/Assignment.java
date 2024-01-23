import java.time.LocalDate;

public class Assignment extends Assessment {

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    private DeadLine deadline;
    private boolean isFirstSubmission = true;

    /**
     * @param title
     * @param mark
     * @param deadline
     */
    public Assignment(String title, String mark, DeadLine deadline) {
        super(title, mark);
        this.deadline = deadline;
    }

    /**
     * @return the deadline
     */
    @Override
    public void submit(int studentID) {
        // Create an instance of AssessmentLogger
        AssessmentLogger assessmentLogger = AssessmentLogger.getInstance();
        // If it is before deadline and it is the first submission add to 
        // submitted.log
        if ((deadline.beforeDeadline(LocalDate.now())) && isFirstSubmission) {
            
            System.out.println(ANSI_GREEN);
            
            assessmentLogger.log(
                AssessmentLogger.Event.SUBMITTED,
                "Assignment title: " +
                ANSI_BLUE +
                getTitle() +
                ANSI_GREEN +
                " submitted by Student ID " +
                ANSI_BLUE +
                studentID
            );
        isFirstSubmission = false;
        // If it is before deadline and it is not the first submission add to
        // updated.log
        } else if (deadline.beforeDeadline(LocalDate.now()) && !isFirstSubmission) {
            
            System.out.println(ANSI_YELLOW);
      
            assessmentLogger.log(
                AssessmentLogger.Event.UPDATED,
                "Assignment title: " +
                ANSI_BLUE +
                getTitle() +
                ANSI_YELLOW +
                " updated by Student ID " +
                ANSI_BLUE +
                studentID
            );
        // If it is after deadline add to late_submission.log
        } else {
            
            System.out.println(ANSI_RED);
            
            assessmentLogger.log(
                AssessmentLogger.Event.LATE_SUBMISSION,
                "Assignment title: " +
                ANSI_BLUE +
                getTitle() +
                ANSI_RED +
                " submitted late by Student ID " +
                ANSI_BLUE +
                studentID
            );
        }
    } 
}

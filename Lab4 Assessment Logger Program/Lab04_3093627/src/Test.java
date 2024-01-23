import java.time.LocalDate;

public class Test extends Exercise {

    public static final String ANSI_RED = "\u001B[31m";
    private DeadLine deadline;
    private boolean isFirstSubmission = true;

    /**
     * @param title
     * @param mark
     * @param deadline
     */
    public Test(String title, String mark, DeadLine deadline) {
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
        // If the deadline is before the current date and it is the first
        // submission, it will log the submission as SUBMITTED
        if (deadline.beforeDeadline(LocalDate.now()) && isFirstSubmission) {
            System.out.println(ANSI_GREEN);
            
            assessmentLogger.log(
                AssessmentLogger.Event.SUBMITTED,
                "Test title: " +
                ANSI_BLUE +
                getTitle() +
                ANSI_GREEN +
                " submitted by Student ID " +
                ANSI_BLUE +
                studentID
            );
            
            // Will not be the first submission anymore
            isFirstSubmission = false;

        // If the deadline is after the current date and it is the first    
        } else if (
            !(deadline.beforeDeadline(LocalDate.now())) && isFirstSubmission
        ) {
     
            System.out.println(ANSI_RED);
            
            assessmentLogger.log(
                AssessmentLogger.Event.LATE_SUBMISSION,
                "Test title: " +
                ANSI_BLUE +
                getTitle() +
                ANSI_RED +
                " submitted late by Student ID " +
                ANSI_BLUE +
                studentID
            );
        // And again will not be the first submission anymore    
        isFirstSubmission = false;
          
        // if is not the first submission Test will not be updated
        } else if (!isFirstSubmission) {
            
            System.out.println(
                    ANSI_RED + 
                    "\nTests can be submitted only once.");
        }
    }
}

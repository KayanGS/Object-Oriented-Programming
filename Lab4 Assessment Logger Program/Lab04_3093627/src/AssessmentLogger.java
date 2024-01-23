import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

public class AssessmentLogger {

    private static AssessmentLogger instance;
    private static final String SUBMITTED_LOG_FILE = "submitted.log";
    private static final String UPDATED_LOG_FILE = "updated.log";
    private static final String LATE_SUBMISSION_LOG_FILE = "late_submission.log";

    private PrintWriter submittedLogWriter;
    private PrintWriter updatedLogWriter;
    private PrintWriter lateSubmissionLogWriter;

    // Constructor
    private AssessmentLogger() {
        // Create the log files
        try {
            submittedLogWriter = 
                    new PrintWriter(new FileWriter(SUBMITTED_LOG_FILE));

            updatedLogWriter = 
                    new PrintWriter(new FileWriter(UPDATED_LOG_FILE));

            lateSubmissionLogWriter =
                    new PrintWriter(new FileWriter(LATE_SUBMISSION_LOG_FILE));
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return AssessmentLogger
     */
    public static AssessmentLogger getInstance() {
        if (instance == null) {
            instance = new AssessmentLogger();
        }
        return instance; // ################### RETURN ###################
    }

    // Enum for the events
    public enum Event {
        SUBMITTED,
        UPDATED,
        LATE_SUBMISSION,
    }

    public void log(Event event, String message) {
        // Create a formatted message with the event and the message
        String formattedMessage = getFormattedLogMessage(event, message);
        // Switch statement to determine which log file to write to
        // and print the message to the console
        switch (event) {

            case SUBMITTED:
                // Write to submitted.log
                submittedLogWriter.println(formattedMessage);
                // Flush the writer 
                submittedLogWriter.flush();
                System.out.println("\nSubmitted: " + formattedMessage);
                break; // ################### BREAK ###################
            // Repeat for the other cases

            case UPDATED:
                updatedLogWriter.println(formattedMessage);
                updatedLogWriter.flush();
                System.out.println("\nUpdated: " + formattedMessage);
                break; // ################### BREAK ###################

            case LATE_SUBMISSION:
                lateSubmissionLogWriter.println(formattedMessage);
                lateSubmissionLogWriter.flush();
                System.out.println("\nLate Submission: " + formattedMessage);
                break; // ################### BREAK ###################
        }
    }

    /**
     * @param event
     * @param message
     * @return formatted message
     */
    private String getFormattedLogMessage(Event event, String message) {
        // Create a date format
        SimpleDateFormat dateFormat = 
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        // Get the current time                
        String timestamp = dateFormat.format(new java.util.Date());
        return event + " - " + timestamp + " : " + message; // #### RETURN ####
    }

    /**
     * @param event
     * @return log
     * Switch statement to determine which log file to read from
     */
    public String getLog(Event event) {
        String logFileName;
        switch (event) {
            case SUBMITTED:
                logFileName = SUBMITTED_LOG_FILE;
                break; // ################### BREAK ###################
            case UPDATED:
                logFileName = UPDATED_LOG_FILE;
                break; // ################### BREAK ###################
            case LATE_SUBMISSION:
                logFileName = LATE_SUBMISSION_LOG_FILE;
                break; // ################### BREAK ###################
            default:
                return "Invalid event"; // ############## RETURN ##############
        }

        try (
        // Create a reader for the log file
        BufferedReader reader = new BufferedReader(new FileReader(logFileName))) 
        {
            // Return the log file as a string
            return reader.lines().collect(Collectors.joining("\n"));
            // ################### RETURN ###################
        
        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading the log file"; // ########## RETURN ##########
        }
    }

    /**
     * @param event
     * Close the log file
     */
    public void closeLog(Event event) {
        switch (event) {
            case SUBMITTED:
                submittedLogWriter.close();
                break; // ################### BREAK ###################
            case UPDATED:
                updatedLogWriter.close();
                break; // ################### BREAK ###################
            case LATE_SUBMISSION:
                lateSubmissionLogWriter.close();
                break; // ################### BREAK ###################
        }
    }
}

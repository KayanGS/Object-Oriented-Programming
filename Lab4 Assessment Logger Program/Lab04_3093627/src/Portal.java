public class Portal {

	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_PURPLE = "\u001B[35m";

  	public static void main(String[] args) {
    	
		Assessment exercise1 = new Exercise("Exercise 1", "10");

    	Assessment test1 = new Test(
      		"Test 1",
      		"10",
      		new DeadLine("20:20", 10, 10, 2024)
    	);

    	Assessment assignment1 = new Assignment(
      		"Assignment 1",
      		"10",
      		new DeadLine("17:15", 20, 10, 2024)
    );

    	//Late examples
    	Assessment test2 = new Test(
      		"Test 1",
      		"10",
      		new DeadLine("20:20", 10, 10, 2020)
    );

    	Assessment assignment2 = new Assignment(
      		"Assignment 1",
      		"10",
      		new DeadLine("17:15", 20, 10, 2021)
    );

    	//Submit
    	System.out.println(
      		ANSI_PURPLE +
      		"\nTest to see if the first submission " +
      		"is logged correctly:"
    	);

    	exercise1.submit(3093627);
    	test1.submit(3093627);
    	assignment1.submit(3093627);

    	//Update
    	System.out.println(
      		ANSI_PURPLE +
      		"\nTest to see if the Updated submission " +
      		"is logged correctly:"
    	);

    	exercise1.submit(3093627);
    	test1.submit(3093627);
    	assignment1.submit(3093627);

    	//Late submission
    	System.out.println(
      		ANSI_PURPLE +
      		"\nTest to see if the Late submission is " +
      		"logged correctly:"
    	);

    	test2.submit(3093627);
    	assignment2.submit(3093627);
  }
}

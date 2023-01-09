import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class HighpeakSoftware {
  public static int[] maximizeEarnings(List<int[]> allJobs) {
    // Sort the jobs in decreasing order of profit
    Collections.sort(allJobs, (a, b) -> b[2] - a[2]);

    // Initialize variables to keep track of the number of jobs left
    // and the earnings of other employees
    int numJobsLeft = allJobs.size();
    int totalEarnings = 0;

    // Set the start and end times to the maximum possible value
    int start = 2359;
    int endTime = 0;

    for (int[] job : allJobs) {
      // Select the job if it does not overlap with the ones that Lokesh has already picked
      if (job[0] >= endTime) {
        start = job[0];
        endTime = job[1];
        numJobsLeft--;
      } else {
        // Update the earnings of other employees
        totalEarnings += job[2];
      }
    }

    // Return the number of jobs left and the earnings of other employees
    return new int[] {numJobsLeft, totalEarnings};
  }

  public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
  	  
	  System.out.print("Enter the number of Jobs: ");
	    int n = sc.nextInt();

	    List<int[]> jobs = new ArrayList<>();
	    System.out.println("Enter job start time, end time, and earnings:");
	    for (int i = 0; i < n; i++) {
	      int startTime = sc.nextInt();
	      int endTime = sc.nextInt();
	      int profit = sc.nextInt();
	      jobs.add(new int[]{startTime,endTime,profit});
	    }

	      int[] maximizeEarnings = maximizeEarnings(jobs);
	     System.out.println("The number of tasks and earnings available for others");
	     System.out.println("Task: " + maximizeEarnings[0]);
	     System.out.println("Earnings: " + maximizeEarnings[1]);
	     sc.close();
  }
}
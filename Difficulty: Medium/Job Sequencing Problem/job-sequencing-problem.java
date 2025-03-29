//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

class Job {
    int deadline;
    int profit;

    public Job(int deadline, int profit) {
        this.deadline = deadline;
        this.profit = profit;
    }
}
class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
       int n = deadline.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(deadline[i], profit[i]);
        }
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        int maxDeadline = Arrays.stream(deadline).max().orElse(0);
        boolean[] slots = new boolean[maxDeadline];
        int totalProfit = 0;
        int jobsCount = 0;
        for (Job job : jobs) {
            for (int j = Math.min(maxDeadline, job.deadline) - 1; j >= 0; j--) {
                if (!slots[j]) {
                    slots[j] = true;
                    totalProfit += job.profit;
                    jobsCount++;
                    break;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(jobsCount);
        result.add(totalProfit);

        return result;  
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] deadlineInput = sc.nextLine().trim().split("\\s+");
            int[] deadline =
                Arrays.stream(deadlineInput).mapToInt(Integer::parseInt).toArray();

            String[] profitInput = sc.nextLine().trim().split("\\s+");
            int[] profit =
                Arrays.stream(profitInput).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.jobSequencing(deadline, profit);
            System.out.println(result.get(0) + " " + result.get(1));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends
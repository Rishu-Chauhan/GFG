//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of rooms
            int m = sc.nextInt(); // Number of meetings
            int[][] meetings = new int[m][2];
            for (int i = 0; i < m; i++) {
                meetings[i][0] = sc.nextInt(); // Start time
                meetings[i][1] = sc.nextInt(); // End time
            }
            Solution ob = new Solution();
            System.out.println(ob.mostBooked(n, meetings));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends

// User function Template for Java
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // code here
     int m = meetings.length;
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        int[] freq = new int[n]; // Frequency of meetings in each room

        // Min-heap for available rooms (sorted by room number)
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();

        // Min-heap for ongoing meetings {end_time, room_number}
        PriorityQueue<int[]> ongoingMeetings = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        for (int i = 0; i < n; i++) {
            availableRooms.offer(i);
        }

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            int duration = end - start;

            while (!ongoingMeetings.isEmpty() && ongoingMeetings.peek()[0] <= start) {
                int freedRoom = ongoingMeetings.poll()[1];
                availableRooms.offer(freedRoom);
            }

            if (availableRooms.isEmpty()) {
                int[] earliest = ongoingMeetings.poll();
                int newEndTime = earliest[0] + duration;
                ongoingMeetings.offer(new int[]{newEndTime, earliest[1]});
                freq[earliest[1]]++;
            } else {
                int assignedRoom = availableRooms.poll();
                ongoingMeetings.offer(new int[]{end, assignedRoom});
                freq[assignedRoom]++;
            }
        }

        int roomNum = 0, maxMeetings = 0;
        for (int i = 0; i < n; i++) {
            if (freq[i] > maxMeetings) {
                maxMeetings = freq[i];
                roomNum = i;
            }
        }

        return roomNum;
    }
}


//{ Driver Code Starts.
// } Driver Code Ends
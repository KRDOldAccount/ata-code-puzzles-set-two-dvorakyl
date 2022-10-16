package com.kenzie.greedy.meetingroom;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Contains a problem that can be solved using the Greedy Technique.
 */

//COLLABORATED WITH DARRIAN COLLIER

public class MeetingRoom {

    /**
     * You have a single meeting room for holding meetings. Given a list of meetings with start and end times,
     * return the maximum number of meetings that the meeting room can accommodate. Assume that all the meetings
     * are for the same day.
     *
     * Example: [(meetingName, startTime-endTime)]
     * meetings = [(meeting1, 13-14), (meeting2, 15-16), (meeting3, 8-12), (meeting4, 11-12),
     * (meeting5, 9-11), (meeting6, 14-16)]
     *
     * result = [(meeting5, 9-11),(meeting4, 11-12),(meeting1, 13-14),(meeting2, 15-16)] -> 4 meetings
     *
     * @param meetings - the list of possible meetings that can be scheduled
     * @return the maximum number of meetings that can be accommodated
     */
    public static int getMaximumMeetings(List<Meeting> meetings) {
        // TODO: Implement an algorithm that utilizes the greedy technique
        List<Meeting> results = new ArrayList<>();
        int currentEndTime = 0;

        meetings.sort(Comparator.comparing(Meeting::getEndTime));

        for (Meeting meeting : meetings) {
            if (meeting.getStartTime() >= currentEndTime) {
                results.add(meeting);
                currentEndTime = meeting.getEndTime();
            }
        }
        return results.size();

    }
}

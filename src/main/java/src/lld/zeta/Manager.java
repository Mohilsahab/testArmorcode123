package src.lld.zeta;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;
import java.util.*;

public class Manager {

    @AllArgsConstructor
    @EqualsAndHashCode
    private static class TimeClass {
        private Timestamp startTime;
        private Timestamp endTime;
    }

    public Manager() {
        userMap = new HashMap<>();
        realRoomSet = new HashSet<>();
        meetingMap = new HashMap<>();
        timeClassUsersMap = new HashMap<>();
        timeClassMeetingMap = new HashMap<>();
    }

    private Map<String, User> userMap;
    private Set<RealRoom> realRoomSet;
    private Map<String, Meeting> meetingMap;
    private Map<TimeClass, List<String>> timeClassUsersMap;
    private Map<TimeClass, List<String>> timeClassMeetingMap;

    public Boolean bookMeeting(Meeting meeting) {
        if (meeting.getId() != null) {
            System.out.println("Meeting is already present");
            return false;
        }
        String meetingId = UUID.randomUUID().toString();
        String organizer = meeting.getOrganizer();
        Timestamp startTime = meeting.getStartTime();
        Timestamp endTime = meeting.getEndTime();
        if (!meetingAllowed(meeting)) {
            System.out.println("Meeting is already present");
            return false;
        }

        meeting.setId(meetingId);
        meetingMap.put(meetingId, meeting);

        TimeClass timeClass = new TimeClass(startTime, endTime);
        List<String> users = timeClassUsersMap.getOrDefault(timeClass, new ArrayList<>());
        users.add(organizer);
        timeClassUsersMap.put(timeClass, users);

        List<String> meetingIds = timeClassMeetingMap.getOrDefault(timeClass, new ArrayList<>());
        meetingIds.add(meetingId);
        timeClassMeetingMap.put(timeClass, meetingIds);
        return true;
    }

    private boolean meetingAllowed(Meeting meeting) {
//        organizerCheck betweenTime

//        roomAvailableCheck
        return false;
    }

    boolean organizerTimeCheck(String organizerId, Timestamp startTime, Timestamp endTime) {
        return false;
    }
}

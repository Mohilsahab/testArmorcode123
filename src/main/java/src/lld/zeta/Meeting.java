package src.lld.zeta;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
public class Meeting {
    @Setter
    private String id;
    private Timestamp startTime;
    private Timestamp endTime;
    private String organizer;
    private List<String> attendies;
    private Room room;
}

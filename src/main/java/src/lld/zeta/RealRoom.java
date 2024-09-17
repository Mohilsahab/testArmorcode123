package src.lld.zeta;

import lombok.Getter;

@Getter
public class RealRoom extends Room {
    private String name;

    public RealRoom(Integer id, String name) {
        super(id);
        this.name = name;
    }
}

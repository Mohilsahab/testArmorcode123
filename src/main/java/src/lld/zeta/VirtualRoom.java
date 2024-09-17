package src.lld.zeta;

import lombok.Getter;

@Getter
public class VirtualRoom extends Room{
    private String link;

    public VirtualRoom(Integer id, String link) {
        super(id);
        this.link = link;
    }
}

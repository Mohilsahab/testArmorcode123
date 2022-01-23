package src.lld.razorpay;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Document {
//    Design and implement a Simple document Service where users can create documents and read the same.
//    A document has a name and associated string content <name{string}, content{string}>
//
//    All documents are private when created.
//    Owners of documents can grant access to other users
//    Grants  can be made at global level as well. For example, if access is granted globally, then every user should have access to that document.
//    Username will be just a string. Every action like create/read/edit must be made on behalf of a user
//    Have different tiers. Hot tier should be served from memory. Cold tier should be served from the disk. Owner can specify which tier

    private String name;
    private String owner;
    @Setter
    private Tier tier;
    @Setter
    private Permission globalAccessPermission;
    @Setter
    private List<UserPermissionMapping> userPermissionMappings;

    public Document(String name, String content, String owner, Tier tier) {
        this.name = name;
        this.owner = owner;
        this.tier = tier;
        this.userPermissionMappings = new ArrayList<>();
        this.tier.storeContent(name, content);
    }
}

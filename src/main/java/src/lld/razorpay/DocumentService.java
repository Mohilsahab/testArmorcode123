package src.lld.razorpay;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Getter
public class DocumentService {
    private List<String> users;
    private Map<String, Document> documentMp;
    private Map<String, List<Document>> usersDoc;

    public DocumentService() {
        this.documentMp = new HashMap<>();
        this.users = Arrays.asList("user1", "user2", "user3");
        this.usersDoc  = new HashMap<>();
    }

    void addDocument(String name, String owner, String content, Tier tier) {
        Document document = new Document(name, content, owner, tier);
        documentMp.put(name, document);

        addUserDoc(owner, document);
    }

    private void addUserDoc(String owner, Document document) {
        List<Document> documents = usersDoc.getOrDefault(owner, new ArrayList<>());
        documents.add(document);
        usersDoc.put(owner, documents);
    }

    void addGlobalPermission(String name, Permission permission) {
        Document document = documentMp.get(name);
        document.setGlobalAccessPermission(permission);
        documentMp.put(name, document);

        addUserDoc("user1", document);
        addUserDoc("user2", document);
        addUserDoc("user3", document);
    }

    void addDocumentPermission(String name, String userId, Permission permission) {
        Document document = documentMp.get(name);
        List<UserPermissionMapping> userPermsssionList = document.getUserPermissionMappings();
        userPermsssionList.add(new UserPermissionMapping(userId, permission));
        document.setUserPermissionMappings(userPermsssionList);
        documentMp.put(name, document);


        addUserDoc(userId, document);
    }

    public List<Document> getUsersDocument(String userId) {
        return usersDoc.get(userId);
    }

    public Document getDocument(String userId, String name) {
        return null;
    }
}
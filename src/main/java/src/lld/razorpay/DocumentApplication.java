package src.lld.razorpay;


import java.util.List;

public class DocumentApplication {

    private DocumentService service;

    public DocumentApplication(DocumentService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        DocumentApplication application = new DocumentApplication(new DocumentService());
        application.service.addDocument("doc1", "user1", "content1", new HotTier());
        application.service.addDocument("doc2", "user2", "content2", new ColdTier());
        application.service.addGlobalPermission("doc2", new EditPermission());
        application.service.addDocumentPermission("doc1", "user2", new ReadPermission());


        System.out.println("User1 Docs");
        List<Document> documentList = application.service.getUsersDocument("user1");
        for (Document document : documentList) {
            System.out.println(document);
        }

        System.out.println();
        System.out.println("User2 Docs");
        List<Document> documentList2 = application.service.getUsersDocument("user2");
        for (Document document : documentList2) {
            System.out.println(document);
        }

        System.out.println();
        System.out.println("User3 Docs");
        List<Document> documentList3 = application.service.getUsersDocument("user3");
        for (Document document : documentList3) {
            System.out.println(document);
        }
    }
}

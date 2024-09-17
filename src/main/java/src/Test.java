//package src;
//
//// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
//// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
///* ObjectMapper om = new ObjectMapper();
//Root root = om.readValue(myJsonString), Root.class); */
//public class Fields{
//}
//
//public class FieldsDescending{
//}
//
//public class UnknownFields{
//    public Fields fields;
//    public FieldsDescending fieldsDescending;
//}
//
//public class AffectedVersion{
//    public int epoch_;
//    public String name_;
//    public String revision_;
//    public int kind_;
//    public String fullName_;
//    public int memoizedIsInitialized;
//    public UnknownFields unknownFields;
//    public int memoizedSize;
//    public int memoizedHashCode;
//}
//
//public class FixedVersion{
//    public int epoch_;
//    public String name_;
//    public String revision_;
//    public int kind_;
//    public String fullName_;
//    public int memoizedIsInitialized;
//    public UnknownFields unknownFields;
//    public int memoizedSize;
//    public int memoizedHashCode;
//}
//
//public class PackageIssue{
//    public String affectedCpeUri_;
//    public String affectedPackage_;
//    public AffectedVersion affectedVersion_;
//    public String fixedCpeUri_;
//    public String fixedPackage_;
//    public FixedVersion fixedVersion_;
//    public boolean fixAvailable_;
//    public int memoizedIsInitialized;
//    public UnknownFields unknownFields;
//    public int memoizedSize;
//    public int memoizedHashCode;
//}
//
//public class RelatedUrl{
//    public String url_;
//    public String label_;
//    public int memoizedIsInitialized;
//    public UnknownFields unknownFields;
//    public int memoizedSize;
//    public int memoizedHashCode;
//}
//
//public class Details{
//    public String type_;
//    public int severity_;
//    public double cvssScore_;
//    public List<PackageIssue> packageIssue_;
//    public String shortDescription_;
//    public String longDescription_;
//    public List<RelatedUrl> relatedUrls_;
//    public int effectiveSeverity_;
//    public boolean fixAvailable_;
//    public int memoizedIsInitialized;
//    public UnknownFields unknownFields;
//    public int memoizedSize;
//    public int memoizedHashCode;
//}
//
//public class CreateTime{
//    public int seconds_;
//    public int nanos_;
//    public int memoizedIsInitialized;
//    public UnknownFields unknownFields;
//    public int memoizedSize;
//    public int memoizedHashCode;
//}
//
//public class UpdateTime{
//    public int seconds_;
//    public int nanos_;
//    public int memoizedIsInitialized;
//    public UnknownFields unknownFields;
//    public int memoizedSize;
//    public int memoizedHashCode;
//}
//
//public class Root{
//    public int detailsCase_;
//    public Details details_;
//    public String name_;
//    public String resourceUri_;
//    public String noteName_;
//    public int kind_;
//    public String remediation_;
//    public CreateTime createTime_;
//    public UpdateTime updateTime_;
//    public int memoizedIsInitialized;
//    public UnknownFields unknownFields;
//    public int memoizedSize;
//    public int memoizedHashCode;
//}
//
//

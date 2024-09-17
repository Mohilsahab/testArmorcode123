package src.lld.razorpay;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserPermissionMapping {
    private String userId;
    private Permission permission;
}

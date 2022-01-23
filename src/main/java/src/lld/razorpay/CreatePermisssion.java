package src.lld.razorpay;

import org.springframework.stereotype.Service;

@Service
public class CreatePermisssion implements Permission {

    @Override
    public String getPermission() {
        return "Create Permission";
    }
}

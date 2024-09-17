package src.lld.razorpay;

import org.springframework.stereotype.Service;

@Service
public class EditPermission implements Permission {
    @Override
    public String getPermission() {
        return "Read Permission";
    }
}
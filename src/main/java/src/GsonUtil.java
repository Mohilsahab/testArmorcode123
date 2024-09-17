package src;

import com.google.gson.Gson;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GsonUtil {

    public static final Gson gson;

    static {
        gson = new Gson();
    }

    public static Gson getGson() {
        return gson;
    }

}

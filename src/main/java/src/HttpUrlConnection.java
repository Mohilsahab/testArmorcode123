package src;

import com.snapdeal.mob.errorcodes.MOBRequestExceptionCodes;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HttpUrlConnection {
    class Device {
        int id;
        Timestamp timestamp;
        String status;
        OperatingParams operatingparams;
        Asset assets;
        Parent parent;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Timestamp getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Timestamp timestamp) {
            this.timestamp = timestamp;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public OperatingParams getOperatingparams() {
            return operatingparams;
        }

        public void setOperatingparams(OperatingParams operatingparams) {
            this.operatingparams = operatingparams;
        }

        public Asset getAssets() {
            return assets;
        }

        public void setAssets(Asset assets) {
            this.assets = assets;
        }

        public Parent getParent() {
            return parent;
        }

        public void setParent(Parent parent) {
            this.parent = parent;
        }
    }

    class OperatingParams {
        int rotorSpeed;
        String slack;
        String rootThreshold;

        public int getRotorSpeed() {
            return rotorSpeed;
        }

        public void setRotorSpeed(int rotorSpeed) {
            this.rotorSpeed = rotorSpeed;
        }

        public String getSlack() {
            return slack;
        }

        public void setSlack(String slack) {
            this.slack = slack;
        }

        public String getRootThreshold() {
            return rootThreshold;
        }

        public void setRootThreshold(String rootThreshold) {
            this.rootThreshold = rootThreshold;
        }
    }

    class Asset {
        int id;
        String alias;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }
    }

    class Parent {
        int id;
        String alias;

        @Override
        public String toString() {
            return "Parent{" +
                    "id=" + id +
                    ", alias='" + alias + '\'' +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }
    }

    public static int httpConnection(String statusQuery, int parentId) {
        StringBuilder result = new StringBuilder();
        try {
            String link = "";
            URL url = new URL(link);
            HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            InputStream connectionIn = connection.getInputStream();

            BufferedReader buffer = new BufferedReader(new InputStreamReader(connectionIn));
            String inputLine;
            while ((inputLine = buffer.readLine()) != null) {
                result.append(inputLine + "\n");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }


        List<Device> deviceList = new ArrayList<>();
        return 0;
    }
}

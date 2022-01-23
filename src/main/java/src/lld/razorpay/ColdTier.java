package src.lld.razorpay;

import lombok.ToString;

import java.io.*;

@ToString
public class ColdTier implements Tier {
    private File file;

    public ColdTier() {
        this.file = new File("C:\\Users\\Kanwar\\Desktop\\rzp.text");
    }

    @Override
    public void storeContent(String name, String content) {
        try {
            FileWriter fstream = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(name + ":" + content);
            out.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Override
    public String getContent(String name) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                if (name.equals(st.substring(0, st.indexOf(":")))) {
                    return st.substring(st.indexOf(":") + 1);
                }
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
        return null;
    }
}

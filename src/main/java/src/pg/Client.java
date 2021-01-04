package src.pg;

public class Client {

    public static void main(String[] args) {
        Client client = new Client();
        PgFactory.doTxn(PgEnum.PAYU, PMEnum.Wallet);
    }
}

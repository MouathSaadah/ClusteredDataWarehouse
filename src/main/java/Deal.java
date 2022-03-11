import com.neovisionaries.i18n.CountryCode;
import java.util.logging.Logger;

public class Deal {
    private CountryCode fromCurrency;
    private CountryCode toCurrency;
    private int amount;

    public Deal(String fromCurrency, String toCurrency, String amount) {
        try {
            if (fromCurrency == null || toCurrency == null || amount == null) {
                Logger.getLogger("Deal").severe("Enter Valid Deal Data Please!");
                throw new IllegalArgumentException();
            }
            setAmount(Integer.parseInt(amount));
            setFromCurrency(CountryCode.getByCode(fromCurrency));
            setToCurrency(CountryCode.getByCode(toCurrency));
        }
        catch(Exception e){
            Logger.getLogger("Deal").severe(e.getMessage());
            Logger.getLogger("Deal").severe(e.toString());
        }
    }

    public CountryCode getFromCurrency() {
        return fromCurrency;
    }

    public CountryCode getToCurrency() {
        return toCurrency;
    }

    public int getAmount() {
        return amount;
    }

    public void setFromCurrency(CountryCode fromCurrency) {//validation amount field
        if(fromCurrency == null)
            throw new IllegalArgumentException("Please Enter Correct ISO Code for fromCurrency field!");
        this.fromCurrency = fromCurrency;
    }

    public void setToCurrency(CountryCode toCurrency) {//validation amount field
        if(toCurrency == null)
            throw new IllegalArgumentException("Please Enter Correct ISO Code for toCurrency field!");
        this.toCurrency = toCurrency;
    }

    public void setAmount(int amount) {//validation amount field
        if(amount<0)
            throw new IllegalArgumentException("Only Positive Numbers and no Letters for Amount field Please!");
        this.amount = amount;
    }
}

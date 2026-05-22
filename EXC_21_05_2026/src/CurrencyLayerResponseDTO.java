public class CurrencyLayerResponseDTO {
    private String source;
    private String currency;
    private double rate;
    private long timestamp;

    public CurrencyLayerResponseDTO(String source, String currency, double rate, long timestamp) {
        this.source = source;
        this.currency = currency;
        this.rate = rate;
        this.timestamp = timestamp;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
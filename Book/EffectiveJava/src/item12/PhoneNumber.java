package item12;

public class PhoneNumber {
    int areaCode;
    int prefix;
    int lineNum;
    @Override
    public String toString() {
        return String.format("%03d-%03d-%03d", areaCode, prefix, lineNum);
    }
}

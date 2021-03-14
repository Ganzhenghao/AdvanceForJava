import java.util.Locale;

/**
 * @ClassName LocalTest
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/28 11:38
 * @Version 1.0
 */
public class LocalTest {

    public static void main(String[] args) {
        for (Locale locale : Locale.getAvailableLocales()) {
            System.out.println(locale.getDisplayCountry() + " = " +
                    locale.getCountry() + " <------------> "+
                    locale.getDisplayLanguage()+" = "+locale.getLanguage());
        }
    }

}

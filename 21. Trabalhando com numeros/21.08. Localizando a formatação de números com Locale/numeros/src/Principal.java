import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class Principal {

    public static void main(String[] args) {
        //Locale.setDefault(Locale.CHINA);

        //ISO 639 - lingua
        //ISO 3166 - país
        Locale.setDefault(new Locale("pt", "BR"));

        double a = 4_142_298.4238;
        float b = 0.3f;
        int c = -1;
        BigDecimal d = new BigDecimal("45.362");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        
        NumberFormat formatador = new DecimalFormat("¤ #,##0.00;(¤ #,##0.00)");

        System.out.println(formatador.format(a));
        System.out.println(formatador.format(b));
        System.out.println(formatador.format(c));
        System.out.println(formatador.format(d));
    }

}
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebScraper {

    public static void main(String[] args) {
        String html = "<a href=\"mailto:joao@gmail.com\">\n   joao@gmail.com  </a>\n" +
                "<a>\n   abc@algaworks.com</a><a>xyz@algaworks.com</a>" +
                "<strong>maria@algaworks.com</strong><strong>zezinho@algaworks.com</strong>";
  //      System.out.println(html);

        //String regex = "<strong>(.*)</strong>";
        String regex = "<strong>([\\w.-]+@[a-z\\d.-]+\\.[a-z]{2,3})</strong>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(html);

        while (matcher.find()){
            System.out.println(matcher.group(1));
        }

    }

}

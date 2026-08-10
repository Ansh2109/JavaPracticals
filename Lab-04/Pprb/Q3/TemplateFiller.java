package Pprb.Q3;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateFiller {

    public static String fillTemplate(String template, String[] keys, String[] values) {
       
        Pattern pattern = Pattern.compile("\\{(\\w+)\\}");
        Matcher matcher = pattern.matcher(template);
  
        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            String placeholderKey = matcher.group(1); 
            String replacement = "[?]"; 

         
            for (int i = 0; i < keys.length; i++) {
                if (keys[i].equals(placeholderKey)) {
                    replacement = values[i];
                    break;
                }
            }

            
            matcher.appendReplacement(result, Matcher.quoteReplacement(replacement));
        }
        
    
        matcher.appendTail(result);

        return result.toString();
    }
}

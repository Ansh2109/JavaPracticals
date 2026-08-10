
package Pprb.Q3;

import java.util.*;

public class Driver {
    public static void main(String[] args) {

        String template = "Dear {name}, order {id} ships {date}.";
        String[] names = {"name", "id"};
        String[] values = {"Ansh", "A02"};
        String filledTemplate = TemplateFiller.fillTemplate(template, names, values);

        System.out.println(filledTemplate);
    }
}

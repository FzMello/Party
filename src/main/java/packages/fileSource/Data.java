/**
 * @author Zoppellaro Filippo            @data 2024_05_13
 * Class that conteins static methods and attributes
 */

package packages.fileSource;

import java.util.ArrayList;
import java.util.List;

public class Data {

    // #########################
    //         ATTRIBUTES
    // #########################

    static List<String> persons = new ArrayList<>();

    // #########################
    //       CONSTRUCTORS
    // #########################


    // #########################
    //          METHODS
    // #########################

    public static StringBuilder toPrint () {
      StringBuilder s = new StringBuilder();
      for (String string : persons) {
          s.append(string).append("\n");
      }
      return s;
    }

    //*****************
    //     PRIVATE
    //*****************

}

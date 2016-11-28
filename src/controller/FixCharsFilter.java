package controller;

public class FixCharsFilter {
	

    private String filter(String value) {
          int startSpot = 0;
          int foundSpot;
          String buildString = value;
          
          while ((foundSpot = buildString.indexOf("'",startSpot)) != -1) {
                buildString = buildString.substring(0, foundSpot) + "'" + buildString.substring(foundSpot);
                startSpot = foundSpot + 2;
          
          }
          
          return buildString;
    }

    
    
}

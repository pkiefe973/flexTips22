
//tip card object to hold all data for JSON query

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class tipCard {

// --------- instance variables ----------- //
    private int cardFlavor = 0; // identify card parameters required
    private String constructedQuery,rawQuery;
    
    private String headerTitleEng, headerTitleSpa, cardTitleEng, cardTitleSpa, cardBodyEng, cardBodySpa, button1TextEng, button1TextSpa, button1Deeplink, button2TextSpa, button2TextEng, button2Deeplink, addToListID;

    // variable for 'cardFlavor' 
    //private int case1, case2, case3, case4, case5, case6, case7, case8, case9, case10;

// ------------ constructors ------------- //

    //English only, no buttons   
    public tipCard(String headerEng, String titleEng, String bodyEng){

        headerTitleEng = headerEng;
        cardTitleEng = titleEng;
        cardBodyEng = bodyEng;
        cardFlavor = 1;
    }

    //English + Spanish, no buttons
    public tipCard(String headerEng, String titleEng, String bodyEng, String headerSpa, String titleSpa, String bodySpa){

        headerTitleEng = headerEng;
        cardTitleEng = titleEng;
        cardBodyEng = bodyEng;
        headerTitleSpa = headerSpa;
        cardTitleSpa = titleSpa;
        cardBodySpa = bodySpa;
        cardFlavor = 2;
    }

    //English only, 1 custom button 
    public tipCard(String headerEng, String titleEng, String bodyEng, String button1Eng, String button1URL){

        headerTitleEng = headerEng;
        cardTitleEng = titleEng;
        cardBodyEng = bodyEng;
        button1TextEng = button1Eng;
        button1Deeplink = button1URL;
        cardFlavor = 3;
    }

    //English only, 1 add to my list button 
     public tipCard(String headerEng, String titleEng, String bodyEng, String listID){

        headerTitleEng = headerEng;
        cardTitleEng = titleEng;
        cardBodyEng = bodyEng;
        addToListID = listID;
        cardFlavor = 4;
    }

    //English + Spanish, 1 custom button
    public tipCard(String headerEng, String titleEng, String bodyEng, String button1Eng, String button1URL,String headerSpa, String titleSpa, String bodySpa, String button1Spa){

        headerTitleEng = headerEng;
        cardTitleEng = titleEng;
        cardBodyEng = bodyEng;
        button1TextEng = button1Eng;
        button1Deeplink = button1URL;
        headerTitleSpa = headerSpa;
        cardTitleSpa = titleSpa;
        cardBodySpa = bodySpa;
        button1TextSpa = button1Spa;
        button1Deeplink = button1URL;
        cardFlavor = 5;
    }

    //English + Spanish, 1 add to my list button 
        public tipCard(String headerEng, String titleEng, String bodyEng,String headerSpa, String titleSpa, String bodySpa, String listID, int a){

        headerTitleEng = headerEng;
        cardTitleEng = titleEng;
        cardBodyEng = bodyEng;
        headerTitleSpa = headerSpa;
        cardTitleSpa = titleSpa;
        cardBodySpa = bodySpa;
        addToListID = listID;
        cardFlavor = 6;
    }

     //English only, 2 custom buttons 
    public tipCard(String headerEng, String titleEng, String bodyEng, String button1Eng, String button1URL, String button2Eng, String button2URL){

        headerTitleEng = headerEng;
        cardTitleEng = titleEng;
        cardBodyEng = bodyEng;
        button1TextEng = button1Eng;
        button1Deeplink = button1URL;
        button2TextEng = button2Eng;
        button2Deeplink = button2URL;
        cardFlavor = 7;
    }

    //English + Spanish, 2 custom buttons
    public tipCard(String headerEng, String titleEng, String bodyEng, String button1Eng, String button1URL, String button2Eng, String button2URL, String headerSpa, String titleSpa, String bodySpa, String button1Spa, String button2Spa){

        headerTitleEng = headerEng;
        cardTitleEng = titleEng;
        cardBodyEng = bodyEng;
        button1TextEng = button1Eng;
        button1Deeplink = button1URL;
        headerTitleSpa = headerSpa;
        cardTitleSpa = titleSpa;
        cardBodySpa = bodySpa;
        button1TextSpa = button1Spa;
        button1Deeplink = button1URL;
        button2TextEng = button2Eng;
        button2Deeplink = button2URL;
        button2TextSpa = button2Spa;
        cardFlavor = 8;
    }

    // English only, 1 custom button + 1 add to my list
    public tipCard(String headerEng, String titleEng, String bodyEng, String button1Eng, String button1URL, String listID, int a){

        headerTitleEng = headerEng;
        cardTitleEng = titleEng;
        cardBodyEng = bodyEng;
        button1TextEng = button1Eng;
        button1Deeplink = button1URL;
        button1Deeplink = button1URL;
        addToListID = listID;
        cardFlavor = 9;
    }

    // English + Spanish, 1 custom button + 1 add to my list
    public tipCard(String headerEng, String titleEng, String bodyEng, String button1Eng, String button1URL, String headerSpa, String titleSpa, String bodySpa, String button1Spa, String listID){

        headerTitleEng = headerEng;
        cardTitleEng = titleEng;
        cardBodyEng = bodyEng;
        button1TextEng = button1Eng;
        button1Deeplink = button1URL;
        headerTitleSpa = headerSpa;
        cardTitleSpa = titleSpa;
        cardBodySpa = bodySpa;
        button1TextSpa = button1Spa;
        button1Deeplink = button1URL;
        addToListID = listID;
        cardFlavor = 10;
    }

// ----------- methods -------------//

    public void copyJsonToClipboard(){

        StringSelection stringSelection = new StringSelection(populateJSON());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    public String populateJSON(){

        //populate JSON object with user variables based on which constructor was used.
        //after populating JSON, URL encode before returning completed string.

        String out = new String("");
        StringBuilder s = new StringBuilder(out);
        URLUTF8Encoder u = new URLUTF8Encoder();
       
        
            switch (cardFlavor) {
            
            // english only, no buttons
            case 1:
            System.out.println("case 1 execute");
                s.append("{\"header\":{\"title\":\"");
                s.append(headerTitleEng);
                s.append("\"},\"text\":{\"title\":\"");
                s.append(cardTitleEng);
                s.append("\",\"body\":\"");
                s.append(cardBodyEng);
                s.append("\"}}");

                rawQuery = ("stories:"+s.toString());
                constructedQuery = ("stories:"+u.encode(s.toString()));
                return (constructedQuery);
            
            //english + spanish, no buttons
            case 2:
                System.out.println("case 2 execute");
                s.append("{\"header\":{\"localization\":{\"en-US\":{\"title\":\"");
                s.append(headerTitleEng);
                s.append("\"},\"es-US\":{\"title\":\"");
                s.append(headerTitleSpa);
                s.append("\"}}},\"text\":{\"localization\":{\"en-US\":{\"title\":\"");
                s.append(cardTitleEng);
                s.append("\",\"body\":\"");
                s.append(cardBodyEng);
                s.append("\"},\"es-US\":{\"title\":\"");
                s.append(cardTitleSpa);
                s.append("\",\"body\":\"");
                s.append(cardBodySpa);
                s.append("\"}}}}");

                rawQuery = ("stories:"+s.toString());
                constructedQuery = ("stories:"+u.encode(s.toString()));
                return (constructedQuery);
            
            // english only, one custom button
            case 3:
                System.out.println("case 3 execute");
                s.append("{\"header\":{\"title\":\"");
                s.append(headerTitleEng);
                s.append("\"},\"text\":{\"title\":\"");
                s.append(cardTitleEng);
                s.append("\",\"body\":\"");
                s.append(cardBodyEng);
                s.append("\"},\"button\":{\"title\":\"");
                s.append(button1TextEng);
                s.append("\",\"actionUrl\":\"");
                s.append(button1Deeplink);
                s.append("\"}}");
                
                rawQuery = ("stories:"+s.toString());
                constructedQuery = ("stories:"+u.encode(s.toString()));
                return (constructedQuery);

            // english only, 1 add to my list button
            case 4:
                System.out.println("case 4 execute");
                s.append("{\"header\":{\"title\":\"");
                s.append(headerTitleEng);
                s.append("\"},\"text\":{\"title\":\"");
                s.append(cardTitleEng);
                s.append("\",\"body\":\"");
                s.append(cardBodyEng);
                s.append("\"},\"button\":{\"type\":\"mylist\"},\"programEntityId\":\"");
                s.append(addToListID);
                s.append("\"}");
                
                rawQuery = ("stories:"+s.toString());
                constructedQuery = ("stories:"+u.encode(s.toString()));
                return (constructedQuery);
                
            //English + Spanish, 1 custom button
            case 5:
                System.out.println("case 5 execute");
                s.append("{\"header\":{\"localization\":{\"en-US\":{\"title\":\"");
                s.append(headerTitleEng);
                s.append("\"},\"es-US\":{\"title\":\"");
                s.append(headerTitleSpa);
                s.append("\"}}},\"text\":{\"localization\":{\"en-US\":{\"title\":\"");
                s.append(cardTitleEng);
                s.append("\",\"body\":\"");
                s.append(cardBodyEng);
                s.append("\"},\"es-US\":{\"title\":\"");
                s.append(cardTitleSpa);
                s.append("\",\"body\":\"");
                s.append(cardBodySpa);
                s.append("\"}}},\"button\":{\"localization\":{\"en-US\":{\"title\":\"");
                s.append(button1TextEng);
                s.append("\"},\"es-US\":{\"title\":\"");
                s.append(button1TextSpa);
                s.append("\"}},\"actionUrl\":\"");
                s.append(button1Deeplink);
                s.append("\"}}");
            
                rawQuery = ("stories:"+s.toString());
                constructedQuery = ("stories:"+u.encode(s.toString()));
                return (constructedQuery);
                
            //English + Spanish, 1 add to my list button 
            case 6:

                System.out.println("case 6 execute");
                s.append("{\"header\":{\"localization\":{\"en-US\":{\"title\":\"");
                s.append(headerTitleEng);
                s.append("\"},\"es-US\":{\"title\":\"");
                s.append(headerTitleSpa);
                s.append("\"}}},\"text\":{\"localization\":{\"en-US\":{\"title\":\"");
                s.append(cardTitleEng);
                s.append("\",\"body\":\"");
                s.append(cardBodyEng);
                s.append("\"},\"es-US\":{\"title\":\"");
                s.append(cardTitleSpa);
                s.append("\",\"body\":\"");
                s.append(cardBodySpa);
                s.append("\"}}},{\"button\":{\"type\":\"mylist\"},\"programEntityId\":\"");
                s.append(addToListID);
                s.append("\"}}}");

                rawQuery = ("stories:"+s.toString());
                constructedQuery = ("stories:"+u.encode(s.toString()));
                return (constructedQuery);

            //English only, 2 custom buttons 
            case 7:

                System.out.println("case 7 execute");
                s.append("{\"header\": {\"title\": \"");
                s.append(headerTitleEng);
                s.append("\"},\"text\": {\"title\": \"");
                s.append(cardTitleEng);
                s.append("\",\"body\": \"");
                s.append(cardBodyEng);
                s.append("\",}},\"buttons\": [{\"title\": \"");
                s.append(button1TextEng);
                s.append("\",\"actionUrl\": \"");
                s.append(button1Deeplink);
                s.append("\"},{\"title\": \"");
                s.append(button2TextEng);
                s.append("\",\"actionUrl\": \"");
                s.append(button2Deeplink);
                s.append("\"}]}");
                    
                rawQuery = ("stories:"+s.toString());
                constructedQuery = ("stories:"+u.encode(s.toString()));
                return (constructedQuery);

            //English + Spanish, 2 custom buttons
            case 8:
                    return("WIP - not yet supported.");

            // English only, 1 custom button + 1 add to my list
            case 9:
                    return("WIP - not yet supported.");

            // English + Spanish, 1 custom button + 1 add to my list
            case 10:

                System.out.println("Case 10 execute");
                s.append("{\"header\":{\"localization\":{\"en-US\": {\"title\": \"");
                s.append(headerTitleEng);
                s.append("\"},\"es-US\":{\"title\":\"");
                s.append(headerTitleSpa);
                s.append("\"}}},\"text\":{\"localization\":{\"en-US\":{\"title\":\"");
                s.append(cardTitleEng);
                s.append("\",\"body\":\"");
                s.append(cardBodyEng);
                s.append("\" },\"es-US\":{\"title\": \"");
                s.append(cardTitleEng);
                s.append("\",\"body\": \"");
                s.append(cardBodySpa);
                s.append("\"}}},\"buttons\":[{\"localization\":{\"en-US\":{\"title\":\"");
                s.append(button1TextEng);
                s.append("\"},\"es-US\":{\"title\":\"");
                s.append(button1TextSpa);
                s.append("\"}},\"actionUrl\": \"");
                s.append(button1Deeplink);
                s.append("\"},{\"type\": \"mylist\"}],\"programEntityId\": \"");
                s.append(addToListID);
                s.append("\"}");

                rawQuery = ("stories:"+s.toString());
                constructedQuery = ("stories:"+u.encode(s.toString()));
                return (constructedQuery);

            //



                

/*
            s.append("{\"header\":{\"localization\":\"en-US\":{\"title\":\"");
            s.append(headerTitleEng);
            s.append("\"},\"es-US\":{\"title\":\"");
            s.append(headerTitleSpa);
            s.append("\"}}},")
            s.append(cardTitleEng);
            s.append("\",\"body\":\"");
            s.append(cardBodyEng);
            s.append("\"}}");
*/
            //System.out.println("Constructed string: \n" + s.toString());
           // return ("stories:"+u.encode(s.toString()));
                    
                }
           // return "Error - consult debug console";
            return out;
        }

        public String getEncodedQuery(){
            if(constructedQuery.isEmpty()) return "No data";
            
            return(constructedQuery);
        }

        public String getRawQuery(){
            if(rawQuery.isEmpty()) return "No data";
            return(rawQuery);
        }

    }




    


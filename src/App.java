/*
Created by Patrick Kiefer - for use by Comcast personnel only
This program is designed to format URL-encoded JSON objects for use as
Flex editorial stories in MAX. Documentation can be found at the following URL:

https://etwiki.sys.comcast.net/pages/viewpage.action?spaceKey=XDSS&title=Stories+MAX+Programming

Feedback/improvement requests can be sent to patrick_kiefer@comcast.com. Fair warning: I know nothing about web programming, so this is a currently standalone Java product.

v1 (August 2022) - implement basic functionality (using console UI) with bilingual support
*/
import java.util.*;


public class App {

    public static void main(String[] args) throws Exception {

       displayHowTo();

    /*------- THIS IS WHERE TO SET YOUR VARIABLES FOR TIP CARD CREATION -----------
    
    currently, these are hard coded strings for demo/testing purposes. these are the variables you can assign values to in order to create a tip card object
    that will correctly format the output.

    */

       
       final String bilingual, headerTitleEng, headerTitleSpa, cardTitleEng, cardTitleSpa, cardBodyEng, cardBodySpa, button1TextEng, button1TextSpa, button1Deeplink, button2TextSpa, button2TextEng, button2Deeplink, addToListID;

       headerTitleEng = "English Header";
       headerTitleSpa = "Spanish Header";

       cardTitleEng = "English title";
       cardBodyEng = "This is the english card body text.";
       
       cardTitleSpa = "Spanish title";
       cardBodySpa = "This is the spanish card body text.";

       //Great british baking show seriesmaster ID
       addToListID = "6269872668374097112";


       button1TextEng = "Button 1";
       button1TextSpa = "Button 1 (SPA)";
       button1Deeplink = "appmanager:launchApplication#appId=int.fe.leadgen.prod&additionalLaunchParams=%7B%22urlComponents.query.listingId%22%3A%22leadgen-xfinity-rewards-2021-q3%22%2C%22urlComponents.query.recordId%22%3A%2271370a3f-acd8-4605-82d5-88e58797bd84%22%2C%22urlComponents.query.displayStyle%22%3A%22x1%22%2C%22urlComponents.query.launchedFrom%22%3A%22tipcard%22%7D";


       button2TextEng = "Button 2";
       button2TextSpa = "Button 2 (SPA)";
       button2Deeplink = "appmanager:launchApplication#appId=int.fe.leadgen.prod&additionalLaunchParams=%7B%22urlComponents.query.listingId%22%3A%22leadgen-xfinity-rewards-2021-q3%22%2C%22urlComponents.query.recordId%22%3A%2271370a3f-acd8-4605-82d5-88e58797bd84%22%2C%22urlComponents.query.displayStyle%22%3A%22x1%22%2C%22urlComponents.query.launchedFrom%22%3A%22tipcard%22%7D";

//---------------------------------------------------------------

       //tipCard t = new tipCard("Planifica tu voto","Disponible en inglés y español","Planifica Tu Voto está disponible en NBCNews.com/PlanYourVote y PlanificaTuVoto.com.");


// (overloaded) CONSTRUCTORS FOR TIP CARD OBJECT BASED ON PROVIDED PARAMETERS - one for each scenario has been provided for convenience, comment/uncomment as needed.
        
        //case 1 - Eng, text only
        //tipCard t = new tipCard(headerTitleEng,cardTitleEng,cardBodyEng);

        //case 2 - Eng + Spa, text only
        //tipCard t = new tipCard(headerTitleEng,cardTitleEng,cardBodyEng,headerTitleSpa,cardTitleSpa,cardBodySpa);

        //case 3 - Eng, 1 custom button
        //tipCard t = new tipCard(headerTitleEng,  cardTitleEng,  cardBodyEng,  button1TextEng,  button1Deeplink);

        //case 4 - Eng, 1 add to my list button
        //tipCard t = new tipCard( headerTitleEng,  cardTitleEng,  cardBodyEng,  addToListID);

        //tipCard t = new tipCard( headerTitleEng,  cardTitleEng,  cardBodyEng,  button1TextEng,  button1Deeplink, headerTitleSpa,  cardTitleSpa,  cardBodySpa,  button1TextSpa);
        
        //case 6 - Eng + Spa, 1 add to my list button
        //tipCard t = new tipCard( headerTitleEng,  cardTitleEng,  cardBodyEng, headerTitleSpa,  cardTitleSpa,  cardBodySpa,  addToListID,  1);
        
        //case 7 - Eng, 2 custom buttons
        //tipCard t = new tipCard( headerTitleEng,  cardTitleEng,  cardBodyEng,  button1TextEng,  button1Deeplink,  button2TextEng,  button2Deeplink);
        
        //case 8 - Eng + Spa, 2 custom buttons
        //tipCard t = new tipCard( headerTitleEng,  cardTitleEng,  cardBodyEng,  button1TextEng,  button1Deeplink,  button2TextEng,  button2Deeplink,  headerTitleSpa,  cardTitleSpa,  cardBodySpa,  button1TextSpa,  button2TextSpa);

        //case 9 - Eng, 1 custom button + 1 add to my list button
        //tipCard t = new tipCard( headerTitleEng,  cardTitleEng,  cardBodyEng,  button1TextEng,  button1Deeplink,  addToListID, 1);

        //case 10 - Eng + Spa, 1 custom button + 1 add to my list button
        tipCard t = new tipCard( headerTitleEng,  cardTitleEng,  cardBodyEng,  button1TextEng,  button1Deeplink,  headerTitleSpa,  cardTitleSpa,  cardBodySpa,  button1TextSpa,  addToListID);

        t.populateJSON();
        System.out.println("Attempting to copy to clipboard...");
        t.copyJsonToClipboard();
        System.out.println("Encoded query copied to clipboard - complete.");
        System.out.println("\nRaw Query: \n\n" + t.getRawQuery() + "\n\n\nEncoded Query: \n\n" + t.getEncodedQuery());


    }

    public static void displayHowTo(){
        System.out.println("HOW TO USE THIS TIP CARD GENERATOR\n\nLocate the type of tip card you'd like to create in the list below:\n\n1) English only, no buttons\n2) English + Spanish, no buttons\n3) English only, 1 custom button\n4) English only, 1 add to my list button\n5) English + Spanish, 1 custom button\n6) English + Spanish, 1 add to my list button\n**ADDITIONAL TYPES WILL BE ADDED**\n\nEnter the number of the type of tip card you'd like to create:");

    }

    }



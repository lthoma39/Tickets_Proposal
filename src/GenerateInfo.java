import java.util.*;

public class GenerateInfo {

    GenerateInfo(){ } //constructor not needed

    //Whenever this function is invoked we basically just get a new Citation
    static public String generateCitation(){

        int count = 8;
        String Citation = "";
        String randStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        Random rand = new Random();

        while(count-- > 0){
            Citation += randStr.charAt(rand.nextInt(36));
        }


        return Citation;
    }

    static public String getLocation(){
        //can add locations later.

        ArrayList<String> locations = new ArrayList<>();

        locations.add("Westbound Route Location 30");


        return locations.get(0);
    }

    static public Date getDate(){return Calendar.getInstance().getTime();}

    static public String getRandLane(){

        Vector<String> lanes = new Vector<>();

        lanes.add("Left Turn Lane");
        lanes.add("Right Turn Lane");
        lanes.add("Left Lane");
        lanes.add("Right Lane");
        lanes.add("Middle Lane");

        Random rand = new Random();

        return lanes.get(rand.nextInt(lanes.size()));

    }

}

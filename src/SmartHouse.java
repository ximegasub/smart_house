import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SmartHouse {

    public static void main(String args[]) throws Exception{
        try {
            JSONParser jsonParser = new JSONParser();

            FileReader reader = new FileReader("files/actions.json");

            Object jsonObject = jsonParser.parse(reader);

            JSONArray sensorList = (JSONArray) jsonObject;

            sensorList.forEach( sensor -> parseSensorObject( (JSONObject) sensor ) );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseSensorObject(JSONObject sensor)
    {
        try {
            //Get sensor object within list
            JSONObject sensorObject = (JSONObject) sensor.get("sensor");

            //Get sensor name
            String name = (String) sensorObject.get("name");
            //Create observable object
            Observable sensorObservable = (Observable) Class.forName(name).newInstance();

            //Get sensor state
            String state = (String) sensorObject.get("state");

            //Get sensor units
            String units = (String) sensorObject.get("units");

            //Get sensor place
            String place = (String) sensorObject.get("place");

            //Get sensor devices
            JSONArray deviceList = (JSONArray) sensorObject.get("devices");
            Iterator deviceIterator = deviceList.iterator();

            while (deviceIterator.hasNext())
            {
                Iterator deviceIterator1 = ((Map) deviceIterator.next()).entrySet().iterator();
                Observer deviceObserver = null;
                while (deviceIterator1.hasNext()) {
                    Map.Entry pair = (Map.Entry) deviceIterator1.next();
                    String deviceKey = String.valueOf(pair.getKey());
                    String deviceValue = String.valueOf(pair.getValue());
                    if ("name".equals(deviceKey)) {
                        //Create observer object
                        deviceObserver = (Observer) Class.forName(deviceValue).newInstance();
                        deviceObserver.defineObservable(sensorObservable);
                        deviceObserver.definePlace(place);
                    }else if("deactivate".equals(deviceKey) && "true".equals(deviceValue)){
                        sensorObservable.deactivate(deviceObserver);
                    }
                }
            }
            //Set state and units for sensor
            sensorObservable.setUnits(units);
            sensorObservable.setState(state);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}


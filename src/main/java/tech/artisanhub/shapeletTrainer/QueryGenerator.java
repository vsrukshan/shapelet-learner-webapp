package tech.artisanhub.shapeletTrainer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.*;

public class QueryGenerator {
    public static JSONObject generateQuery(JSONObject datasetJson, String datasetname) {

        JSONArray eventArray = (JSONArray) datasetJson.get("Data");
        JSONArray cepQueries = new JSONArray();

        for (int k = 0; k < eventArray.size(); k++) {
            JSONObject currEvent = (JSONObject) eventArray.get(k);
            String mainEvent = currEvent.get("MainEvent").toString();
            JSONArray currEventData = (JSONArray) currEvent.get("Data");
            Iterator<JSONObject> currEventArr = currEventData.iterator();
            Map<String, Double> countMap = new HashMap<String, Double>();
            JSONObject curr;
            JSONArray currRow;
            String rowEvent;
            Double countTemp;
            Boolean isProcessed;
            while (currEventArr.hasNext()) {
                curr = currEventArr.next();
                currRow = (JSONArray) curr.get("Values");
                rowEvent = curr.get("EventType").toString();
                isProcessed = false;
                for (int i = 0; i < currRow.size() && !isProcessed; i++) {
                    if (currRow.get(i) != null) {
                        isProcessed = true;
                        countTemp = countMap.get(String.valueOf(i));

                        if (countTemp == null) {
                            countTemp = 0.0;
                        }

                        countTemp++;
                        countMap.put(String.valueOf(i), countTemp);
                        continue;
                    }
                }
            }

            int startPos = 0;
            Double max = 0.0;
            Double temp;
            Iterator countMapIterrator = countMap.entrySet().iterator();
            while (countMapIterrator.hasNext()) {
                Map.Entry pair = (Map.Entry) countMapIterrator.next();
                temp = (Double) pair.getValue();
                if (temp > max) {
                    startPos = Integer.parseInt(String.valueOf(pair.getKey()));
                    max = temp;
                }
            }

            List<Double> upperBound = new ArrayList();
            List<Double> lowerBound = new ArrayList();

            currEventArr = currEventData.iterator();
            Double tempUp;
            Double tempLow;
            Double currTemp;
            String currStringVal;
            int j = 0;
            while (currEventArr.hasNext()) {
                curr = currEventArr.next();
                currRow = (JSONArray) curr.get("Values");
                j = 0;
                for (int i = 0; i < currRow.size(); i++) {
                    currStringVal = String.valueOf(currRow.get(i));
                    if (currStringVal.equals("null")) {
                        continue;
                    }
                    try {
                        tempUp = upperBound.get(j);
                    } catch (IndexOutOfBoundsException e) {
                        upperBound.add(j, Double.MIN_VALUE);
                        tempUp = upperBound.get(j);
                    }

                    try {
                        tempLow = lowerBound.get(j);
                    } catch (IndexOutOfBoundsException e) {
                        lowerBound.add(j, Double.MAX_VALUE);
                        tempLow = lowerBound.get(j);
                    }
                    currTemp = new Double(currStringVal);
                    if (currTemp > tempUp) {
                        upperBound.set(j, currTemp);
                    }
                    if (currTemp < tempLow) {
                        lowerBound.set(j, currTemp);
                    }
                    j++;
                }
            }

            String query = "SELECT * WHERE";
            int i = 0;
            startPos++;
            while (i < lowerBound.size()) {
                query += " (COLUMN" + (startPos + i) + ".Value<=" + upperBound.get(i) + " AND COLUMN" + (startPos + i) + ".Value>=" + lowerBound.get(i) + ") ";
                i++;
                if (i < lowerBound.size()) {
                    query += "AND";
                }
            }
            System.out.println("Event 1: " + query);
            JSONObject currQuery = new JSONObject();
            currQuery.put("MainEvent", mainEvent);
            currQuery.put("Query", query);
            cepQueries.add(currQuery);
        }
        JSONObject finalqueries = new JSONObject();
        finalqueries.put("Dataset", datasetname);
        finalqueries.put("Queries", cepQueries);
        return finalqueries;
    }
}

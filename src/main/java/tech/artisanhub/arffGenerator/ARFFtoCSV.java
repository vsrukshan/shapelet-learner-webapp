package tech.artisanhub.arffGenerator;

import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.CSVSaver;

import java.io.File;

/**
 * Created by rnavagamuwa on 9/1/16.
 */
public class ARFFtoCSV {
    private static final String TRAINING_DATA = "dataset/EEG_Eye_State.arff";
    private static final String OUTPUT_DATA = "dataset/EEG_Eye_State.csv";
    public static void convert() throws Exception {


        //load arff
        ArffLoader loader = new ArffLoader();
        loader.setSource(new File(TRAINING_DATA));
        Instances data = loader.getDataSet();
        System.out.println("Source ARFF has been successfully loaded");

        // save csv
        CSVSaver saver = new CSVSaver();
        saver.setInstances(data);
        saver.setFile(new File(OUTPUT_DATA));
        saver.setDestination(new File(OUTPUT_DATA));
        saver.writeBatch();
        System.out.println("CSV has been successfully generated");

    }
}

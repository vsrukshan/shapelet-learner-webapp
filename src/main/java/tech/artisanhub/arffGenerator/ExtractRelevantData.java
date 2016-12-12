package tech.artisanhub.arffGenerator;

import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.File;
import java.io.IOException;

/**
 * Created by rnavagamuwa on 9/14/16.
 */
public class ExtractRelevantData {
    public static void convert(String[] args) throws IOException {
        //load arff
        ArffLoader loader = new ArffLoader();
        loader.setSource(new File("dataset/EEG_Eye_State.arff"));
        Instances data = loader.getDataSet();
        System.out.println(data.size());
    }
}

package tech.artisanhub.aSyncTaskManager;

import org.springframework.scheduling.annotation.Async;
import tech.artisanhub.shapeletTrainer.LearnShapelets;

public class AsyncTask {
    @Async
    public void doAsyncTask(String datasetName){
        LearnShapelets.learnShapelets(datasetName);
    }
}
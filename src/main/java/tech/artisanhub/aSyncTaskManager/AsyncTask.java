package tech.artisanhub.aSyncTaskManager;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import tech.artisanhub.shapeletTrainer.LearnShapelets;

public class AsyncTask {
    @Async
    public void doAsyncTask(String datasetName, SimpMessagingTemplate template) throws Exception {
        LearnShapelets.learnShapelets(datasetName, template);
    }
}
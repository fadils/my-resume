package io.github.fadils.myresume.api;

import java.util.List;

import io.github.fadils.myresume.model.FeedItem;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;

/**
 * Created by fadilsutomo on 12/8/14.
 */
public class ResumeClient {
    private static String URL_FEED = "https://raw.githubusercontent.com";
    private static ResumeClientInterface sResumeClientInterface;

    public static ResumeClientInterface getResumeClient() {
        if (sResumeClientInterface == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(URL_FEED)
                    .build();

            sResumeClientInterface = restAdapter.create(ResumeClientInterface.class);
        }

        return sResumeClientInterface;
    }


    public interface ResumeClientInterface {
        @GET("/fadils/my-resume/master/resume.json")
        void getStreams(Callback<List<FeedItem>> callback);
    }
}



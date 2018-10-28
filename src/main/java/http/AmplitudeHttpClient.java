package http;

import data.AmplitudeBatch;
import data.AmplitudeException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

@SuppressWarnings("ThrowFromFinallyBlock")
public class AmplitudeHttpClient {

    private final String API_BATCH_ADDRESS = "http://api.amplitude.com//batch";

    public AmplitudeResponse sendBatch(AmplitudeBatch batch) throws AmplitudeException {
        CloseableHttpResponse response = null;
        AmplitudeResponse result = new AmplitudeResponse();
        try {
            CloseableHttpClient client = HttpClients.createDefault();

            HttpPost httpPost = new HttpPost(API_BATCH_ADDRESS);
            httpPost.setHeader("Content-type", "application/json");
            StringEntity entity = new StringEntity(batch.toString(),
                    "application/json",
                    "UTF-8");
            httpPost.setEntity(entity);

            response = client.execute(httpPost);
            result.setBody(EntityUtils.toString(response.getEntity()));
            result.setStatus(response.getStatusLine().toString());
            return result;
        } catch (Exception e) {
            throw new AmplitudeException(e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    throw new AmplitudeException(e);
                }
            }
        }
    }

}

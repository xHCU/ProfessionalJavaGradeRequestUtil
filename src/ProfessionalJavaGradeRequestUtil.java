import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.nio.Buffer;
import java.util.Arrays;

public    class    ProfessionalJavaGradeRequestUtil     implements IProfessionalJavaGradeRequestUtilBaseVariablesConstantsInterface{
    public       static String getRequest(String url) {
        try {
            HttpsURLConnection conn = (HttpsURLConnection) new URL(url).openConnection();
            conn.addRequestProperty("User-Agent", ProfessionalJavaGradeRequestUtil_DEFAULT_USER_AGENT);

            InputStream inputStream;
            inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader;
            inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader;
            bufferedReader = new BufferedReader(inputStreamReader);

            String lbf;
            StringBuilder resp = new StringBuilder();
            while ((lbf = bufferedReader.readLine()) != null)
                resp.append(lbf);

            return resp.toString();
        } catch(Exception exceptionMethodErrorCatched) {
            String stackTraceForError = Arrays.toString(exceptionMethodErrorCatched.getStackTrace());
            System.out.println(stackTraceForError);
        }
        return url;
    }

    /// WITH CUSTOM USER AGENT ///
    public       static String getRequest(String url, String userAgentCustomUsage) {
        try {
            HttpsURLConnection conn = (HttpsURLConnection) new URL(url).openConnection();
            conn.addRequestProperty("User-Agent", userAgentCustomUsage);

            InputStream inputStream;
            inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader;
            inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader;
            bufferedReader = new BufferedReader(inputStreamReader);

            String lbf;
            StringBuilder resp = new StringBuilder();
            while ((lbf = bufferedReader.readLine()) != null)
                resp.append(lbf);

            return resp.toString();
        } catch(Exception exceptionMethodErrorCatched) {
            String stackTraceForError = Arrays.toString(exceptionMethodErrorCatched.getStackTrace());
            System.out.println(stackTraceForError);
        }
        return url;
    }

    /* @Author aliveLORD135 */
    public static void runGetRequestWithNewThread(String url) {
        new Thread(() -> {
            getRequest(url);
        }).start();
    }
    public static void runGetRequestWithNewThreadAndCustomUserAgent(String url, String customUserAgent) {
        new Thread(() -> {
            getRequest(url, customUserAgent);
        }).start();
    }
        

}


package at.ac.fhcampuswien.download;
import at.ac.fhcampuswien.NewsApiException;

import java.util.List;

public class SequentialDownloader extends Downloader {

    // returns number of downloaded article urls
    @Override
    public int process(List<String> urls) throws NewsApiException{
        int count = 0;
        for (String url : urls) {
            try {
                String fileName = saveUrl2File((url));
                if(fileName != null)
                    count++;
            } catch (NewsApiException e){
                System.err.println(e.getMessage());
                throw new NewsApiException(e.getMessage());
            } catch (Exception e){
                throw new NewsApiException("Different problem occurred in " + this.getClass().getName() + ". Message: " + e.getMessage());
            }
        }
        return count;
    }
}

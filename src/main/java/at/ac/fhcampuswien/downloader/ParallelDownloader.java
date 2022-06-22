package at.ac.fhcampuswien.downloader;

import java.util.List;

public class ParallelDownloader extends Downloader {
    // returns number of downloaded article urls
    @Override
    public int process(List<String> urls) {
        // TODO implement download function using multiple threads
        // Hint: use ExecutorService with Callables
        return 0;
    }
}

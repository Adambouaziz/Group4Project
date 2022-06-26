package at.ac.fhcampuswien.download;

import at.ac.fhcampuswien.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelDownloader extends Downloader {
    // returns number of downloaded article urls
    @Override
    public int process(List<String> urls) throws InterruptedException {
        // TODO implement download function using multiple threads
        // Hint: use ExecutorService with Callables

        int numDownloadedArticles = 0;

        int threads = Runtime.getRuntime().availableProcessors();

        ExecutorService pool = Executors.newFixedThreadPool(threads);

        List<Callable<String>> callables = new ArrayList<>();
        for (String url : urls) {
            Callable<String> download = () -> saveUrl2File(url);
            callables.add(download);
        }

        List<Future<String>> articleDownloads = pool.invokeAll(callables);
        for (Future<String> articleDownload : articleDownloads) {
            if (articleDownload != null) {
                numDownloadedArticles++;
            }
        }

        pool.shutdown();
        return numDownloadedArticles;
    }
}

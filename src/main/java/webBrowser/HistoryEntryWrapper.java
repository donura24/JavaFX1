package webBrowser;

public class HistoryEntryWrapper {
    private String url;
    private String title;
    private long lastVisitedDate;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getLastVisitedDate() {
        return lastVisitedDate;
    }

    public void setLastVisitedDate(long lastVisitedDate) {
        this.lastVisitedDate = lastVisitedDate;
    }

    public HistoryEntryWrapper(String url, String title, long lastVisitedDate) {
        this.url = url;
        this.title = title;
        this.lastVisitedDate = lastVisitedDate;
    }
}

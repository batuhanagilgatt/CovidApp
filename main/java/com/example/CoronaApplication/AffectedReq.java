package com.example.CoronaApplication;

public class AffectedReq extends RootReq {

    public AffectedReqListener listener;

    public interface AffectedReqListener {
        void affectedReqDone(String result);


    }
    public AffectedReq(AffectedReqListener listener) {
        this.listener = listener;
    }
    @Override
    public String getReqLink() {
        return "https://coronavirus-monitor.p.rapidapi.com/coronavirus/affected.php?rapidapi-key=08ce889c3emshc741b13c3e2385fp1da0cdjsn483f402d5e6a";
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.affectedReqDone(result);
    }
}

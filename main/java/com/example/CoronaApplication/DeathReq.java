package com.example.CoronaApplication;

public class DeathReq extends RootReq{

    public DeathReqListener listener;

    public interface DeathReqListener {
        void deathReqDone(String result);

    }
    public DeathReq(DeathReqListener listener) {
        this.listener = listener;
    }


    @Override
    public String getReqLink() {
        return "https://coronavirus-monitor.p.rapidapi.com/coronavirus/worldstat.php?rapidapi-key=08ce889c3emshc741b13c3e2385fp1da0cdjsn483f402d5e6a"; // url gelecek.
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.deathReqDone(result);
    }
}

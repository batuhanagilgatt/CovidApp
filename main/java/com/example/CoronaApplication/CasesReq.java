package com.example.CoronaApplication;

public class CasesReq extends RootReq{

    public CasesReqListener listener;


    public interface CasesReqListener {
        void casesReqDone(String result);
    }
    public CasesReq(CasesReqListener listener) {
        this.listener = listener;
    }

    @Override
    public String getReqLink() {
        return "https://coronavirus-monitor.p.rapidapi.com/coronavirus/cases_by_country.php?rapidapi-key=16faa83cd1msh332fa560411c936p1f3221jsne7eeffebc509";
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.casesReqDone(result);
    }
}

package tokostarmix;


public class Session {
    private String userId = null;
    
    public static Session session = new Session();
    public void setSession(String x){
        this.userId = x;
    }
    
    public String getSession(){
        return this.userId;
    }
}

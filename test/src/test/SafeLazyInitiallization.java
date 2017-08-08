package test;

public class SafeLazyInitiallization {
	private static SafeLazyInitiallization instance;
    private SafeLazyInitiallization() {
    }
    public synchronized static SafeLazyInitiallization getInstance(){
        if(instance==null){
            instance=new SafeLazyInitiallization();
        }
        return instance;
    }

}

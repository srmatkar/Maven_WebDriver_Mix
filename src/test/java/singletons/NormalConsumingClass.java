package singletons;

public class NormalConsumingClass {
	
	public static void main (String[] args) {
		
		// instantiating Singleton class first time
    	SingletonClass first= SingletonClass.getInstanceOfSingletonClass();
 
        // instantiating Singleton class second time
    	SingletonClass second= SingletonClass.getInstanceOfSingletonClass();
 
	}

}

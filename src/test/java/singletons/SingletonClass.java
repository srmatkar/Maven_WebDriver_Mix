 package singletons;

//When we develop a class in such a way that it can have only instance at any time,
//is called Singleton design pattern. 
//It is very useful when you need to use same object of a class across all classes or framework. 
//Singleton class must return the same instance again, if it is instantiated again.

class SingletonClass {
	// declaring an instance of class SingletonClassExample which is null initially
	// means not initialized.
	private static SingletonClass instanceOfSingletonClass = null;

	// Declaring constructor as private to restrict object creation outside of class
	private SingletonClass() {
		System.out.println("Object created.");
	}

	// static method to create instance of class SingletonClassExample
	public static SingletonClass getInstanceOfSingletonClass() {
		if (instanceOfSingletonClass == null)
			instanceOfSingletonClass = new SingletonClass();

		return instanceOfSingletonClass;
	}

}
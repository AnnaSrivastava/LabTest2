package singleton.design.impl;
/**
 * Organization: Yamaha Motor Solutions India
 * Project Name:lab test 2
 * Package: singleton.design.impl
 * Class: SingletonDesignImpl
 * Description: Implement SingletonDesignPattern
 * Created On:20 August 2021
 * @author Ananya Srivastava
 */
import java.io.Serializable;

//class is public to have global scope, implements Serilizable, Cloneable to override methods
public class SingletonDesignImpl implements Serializable, Cloneable{
	private static final long serialVersionUID = 1L;
	
	//singleton instance is static so that only instance is related to whole class, volatile for double-locking(refer to Head First Design Patterns)
	private static volatile SingletonDesignImpl singletonInstance = null;
	
	
	//private constructor to prevent constructor misuse outside of this class
	private SingletonDesignImpl() {}
	
	//static method to access the instance through class, public to be global in scope
	public static SingletonDesignImpl getInstance() {
		if(singletonInstance == null) {
			//lazy instantiation, use synchronized only at instantiation to make obj thread safe. Synchronized decreases performance by a factor of 100
			synchronized(singletonInstance)
			{
				singletonInstance = new SingletonDesignImpl();
			}
		}
		
		return singletonInstance;
	}
	
	
	
	
	
	
	//implement readResolve to prevent new object instantiation at deserialization
	protected Object readResolve() {
        return singletonInstance;
    }
	
	//throw error if someone tries to maliciously clone a singleton object
	 public Object clone() throws CloneNotSupportedException {
         throw new CloneNotSupportedException();
     }
}

//Eager Initialization: Object gets created when class is loaded but this creates an object even if the object is not used.

//Static Block Initialization: Make the object initialization block, so that it can be globally accessed and not be associated to any instance.

//Lazy Initialization:Create the object only when it is required.

//Thread Safe Singleton: Singleton Instance should stay consistent throughout all threads.

//Serialization Issue:Serialization creates a new instance on deserialization. write readResolve()

//Cloning Issue: Deep cloning can create new instance. Override clone()

//Reflection:Using reflection, you can interfere with the singleton instance.Use Enums.

//Enum Singleton:Use enums to handle reflection problem of singleton design pattern.
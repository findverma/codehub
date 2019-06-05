package practice.findverma.codehub.design_patterns.behavioral;

import java.util.ArrayList;
import java.util.List;

/*
 	Observer pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically. 
 	It specifies communication between objects: 
 		observable(subject) and observers. 
 	An observable(subject) is an object which notifies observers about the changes in its state.
 	You can think of observer design pattern in two ways
		1. Subject-Observer relationship:
			Object which is being observed is refereed as Subject and classes which observe subject are called Observer
		2. Publisher-Subscriber relationship:
			A publisher is one who publish data and notifies it to the list of subscribers who have subscribed for the same to that publisher. A simple example is Newspaper. Whenever a new edition is published by the publisher,it will be circulated among subscribers whom have subscribed to publisher.
 
	 A. Implement by your own interface and classes
	 B. By using java.util.Observer and java.util.Observable {Deprecated in from java 9}
	 C. By using java.beans.PropertyChangeListener
 */
abstract class FeatureControl{
	private String funName;
	private int funId;
	private boolean status = false;
	
	public FeatureControl(String funName, int funId){
		this.funId = funId;
		this.funName = funName;
	}
	public abstract void onFCStatusChanged();

	public void setStatus(boolean status) {
		this.status = status;
		onFCStatusChanged();
	}
	 // Getter and Setter
	@Override
	public String toString() {
		return "FeatureControl [funName=" + funName + ", funId=" + funId + ", status=" + status + "]";
	}
}

class CSVImportFeature extends FeatureControl{

	List<FCObserver> observers = new ArrayList<>();
	public CSVImportFeature(String funName, int funId) {
		super(funName, funId);
	}
	@Override
	public void onFCStatusChanged() {
		observers.forEach(FCObserver::notifyStatus);
	}

	 
}

interface FCObserver{
	public void notifyStatus();
}
class CSVObserver implements FCObserver{
	private CSVImportFeature csvImportFeature;
	CSVObserver(CSVImportFeature csvImportFeature){
		this.csvImportFeature = csvImportFeature;   // Add subject to observer 
		this.csvImportFeature.observers.add(this);    // Add observer to subject
	}
	@Override
	public void notifyStatus() {
		System.out.println("Status changed for : "+ csvImportFeature);
	}
}
 

public class Observer1 {

	public static void main(String[] args) {
		CSVImportFeature fc = new CSVImportFeature("csv-Import", 191919);
		new CSVObserver(fc);
		fc.setStatus(true);
		fc.setStatus(false);
	}

}

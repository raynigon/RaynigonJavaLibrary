package com.raynigon.lib.events.handling;

import java.lang.reflect.Method;

/**Generated on 14.09.2015 by Simon Schneider in Project <b>RaynigonJavaLib</b><p>
 * This is a internal storage container for every listening method registered in the {@link EventManager}
 * It should only be used by the {@link EventManager}
 * @author Simon Schneider
 */
public final class EventMethod {

	private EventListener call_object;
	private Method call_method;
	private EventHandler eventHandler;
	private Class<? extends Event> parameter_class;
	
	/**Creates an new EventMethod
	 * @param inCallObject
	 * @param inCallMethod
	 * @param inEventHandler
	 * @param inParameterClass
	 */
	protected EventMethod(EventListener inCallObject, Method inCallMethod, 
			EventHandler inEventHandler, Class<? extends Event> inParameterClass) {
		call_object = inCallObject;
		call_method = inCallMethod;
		eventHandler = inEventHandler;
		parameter_class = inParameterClass;
	}
	
	
	/**Calls the referenced Method
	 * @param event	The Event which should be passed as the parameter
	 * @return true if the method call was a success, false if an error occured
	 */
	protected boolean callMethod(Event event){
		boolean ret = false;
		try{
			call_method.invoke(call_object, event);
			ret = true;
		}catch(Exception e){
			System.err.println("Event:"+event.getClass().getName());
			System.err.println("Listener"+call_object.getClass().getName());
			System.err.println("Listener Param"+parameter_class.getName());
			e.printStackTrace();
		}
		return ret;
	}

	/**Returns the {@link EventPriority} defined by the methods {@link EventHandler}
	 * @return	the {@link EventPriority} for this method
	 */
	protected EventPriority getPriority() {
		return eventHandler.priority();
	}

	/**Returns the @{link java.lang.Class}  for the parameter of the method
	 * @return	the @{link java.lang.Class} of the parameter
	 */
	protected Class<? extends Event> getParameterClass() {
		return parameter_class;
	}
}

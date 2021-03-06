package com.raynigon.lib.events.handling;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**Generated on 14.09.2015 by Simon Schneider in Project <b>RaynigonJavaLib</b><p>
 * The EventHandler Annotation is used for declaring methods to be called by the {@link EventManager}
 * @author Simon Schneider
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface EventHandler {

	/**This priority defines in which order the listeners will be called.
	 * High priorities at the end, low priorities at first
	 * @return	The {@link EventPriority} set for this listener
	 */
	EventPriority priority() default EventPriority.NEUTREAL;
	
	/** Describes a registered Executor, if the executor was not found, 
	 * the Event will be processed in the normal Queue.
	 * @return The Id of a registered Executor
	 * */
	int executorId() default -1;
}

package javarush.task.task32.task3212;

import javarush.task.task32.task3212.contex.InitialContext;;
import javarush.task.task32.task3212.service.Service;


public class ServiceLocator {
    private static Cache cache;

    static {
        cache = new Cache();
    }

    /**
     * First, check for a service object in the cache
     * If a service object is not in the cache, perform a lookup using
     * the JNDI initial context and get the service object. Add it to
     * the cache for future use.
     *
     * @param jndiName The name of the service object in the context
     * @return Object mapped to the name in context
     */
    public static Service getService(String jndiName) {
        Service result = cache.getService(jndiName);
        if (result != null)
        {
            return result;
        } else {
            InitialContext context = new InitialContext();
            Service newService = (Service) context.lookup(jndiName);
            cache.addService(newService);

            return newService;
        }
    }
}
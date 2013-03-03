/**
 * 
 */
package calypsoutils.testing.testgenerator.generator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import calypsoutils.testing.testgenerator.writer.ObjectWritterInterface;
import calypsoutils.testing.testgenerator.writer.WrittersFactory;

import com.calypso.tk.core.Log;

/**
 * @author quique
 * 
 */
public class DefaultGenerator implements GeneratorInterface {

    /*
     * (non-Javadoc)
     * 
     * @see
     * calypsoutils.testing.testgenerator.Generator#getJavaCode(java.lang.Object
     * , java.lang.String )
     */
    @Override
    public String getJavaCode(final Object object, final String objectName) {
        final Class<? extends Object> clazz = object.getClass();
        final Method[] methods = clazz.getMethods();
        final StringBuilder sb = new StringBuilder();

        for (final Method getMethod : methods) {
            // only checks public methods
            final int modifiers = getMethod.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                final String methodName = getMethod.getName();
                // only checks getXXXX methods
                if (methodName.startsWith("get")) {
                    if (getMethod.getParameterTypes().length == 0) {
                        final Class<?> returnType = getMethod.getReturnType();
                        try {
                            // trying to find a setXXX method if not, skip it
                            final Method setMethod = clazz.getMethod("set"
                                    + methodName.substring(3),
                                    new Class[] { returnType });
                            if (setMethod != null) {
                                // invoke the get method to know the current
                                // value
                                final Object result = getMethod.invoke(object,
                                        (Object[]) null);
                                if (result != null) {
                                    final ObjectWritterInterface writter = WrittersFactory
                                            .getWritter(result.getClass());
                                    writter.write(objectName, methodName,
                                            result);
                                } else {
                                    // the result is not a 'primitive' type
                                    // TODO: Call the generator
                                }
                            }
                        } catch (final SecurityException exception) {
                            // TODO Auto-generated catch block
                            exception.printStackTrace();
                        } catch (final NoSuchMethodException exception) {
                            if (Log.isDebug()) {
                                Log.debug(this, "method " + clazz.getName()
                                        + ".set" + methodName.substring(3)
                                        + " does not exists");
                            }
                        } catch (final IllegalArgumentException exception) {
                            // TODO Auto-generated catch block
                            exception.printStackTrace();
                        } catch (final IllegalAccessException exception) {
                            // TODO Auto-generated catch block
                            exception.printStackTrace();
                        } catch (final InvocationTargetException exception) {
                            // TODO Auto-generated catch block
                            exception.printStackTrace();
                        }
                    }
                }
            }
        }
        return sb.toString();
    }
}

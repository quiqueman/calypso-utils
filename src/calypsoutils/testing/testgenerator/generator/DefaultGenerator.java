/**
 * 
 */
package calypsoutils.testing.testgenerator.generator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

import calypsoutils.testing.testgenerator.GeneratorFactory;
import calypsoutils.testing.testgenerator.TestObjectsGenerator;
import calypsoutils.testing.testgenerator.writer.ObjectWriterInterface;
import calypsoutils.testing.testgenerator.writer.WritersFactory;

import com.calypso.tk.core.Log;

/**
 * @author quique
 * 
 */
public class DefaultGenerator implements GeneratorInterface {

    public String getJavaMethodSignature(final Object object,
            final String objectName) {
        final String clazz = object.getClass().getSimpleName();

        final StringBuilder sb = new StringBuilder("\t/* creation method for ");
        sb.append(objectName);
        sb.append(" */\n");
        sb.append("\tpublic ");
        sb.append(clazz);
        sb.append(" create");
        sb.append(TestObjectsGenerator.capitalizeFirstChar(objectName));
        sb.append("() {\n");
        sb.append("\t\t");
        sb.append(clazz);
        sb.append(" ");
        sb.append(objectName);
        sb.append(" = new ");
        sb.append(clazz);
        sb.append("();\n");

        return sb.toString();
    }

    public String getJavaMethodReturn(final String objectName) {
        final StringBuilder sb = new StringBuilder("\t\treturn ");
        sb.append(objectName);
        sb.append(";\n\t}\n\n");

        return sb.toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * calypsoutils.testing.testgenerator.Generator#getJavaCode(java.lang.Object
     * , java.lang.String )
     */
    @Override
    public void getJavaCode(final List<String> methodsJavaCode,
            final Object object, final String objectName) {
        final Class<? extends Object> clazz = object.getClass();
        final Method[] methods = clazz.getMethods();
        final StringBuilder sb = new StringBuilder();

        sb.append(getJavaMethodSignature(object, objectName));

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
                                    System.out.println("method: " + setMethod
                                            + ", result: " + result);

                                    final ObjectWriterInterface writer = WritersFactory
                                            .getWriter(result.getClass());
                                    if (writer != null) {
                                        final String javacode = writer.write(
                                                objectName,
                                                setMethod.getName(), result);
                                        System.out.println(javacode);
                                        sb.append(javacode);
                                    } else {
                                        // the result is not a 'primitive' type
                                        // Call the generator
                                        // TODO:
                                        final GeneratorInterface generator = GeneratorFactory
                                                .getGenerator(object);
                                        generator
                                                .getJavaCode(methodsJavaCode,
                                                        result,
                                                        methodName.substring(3));
                                        final ObjectWriterInterface methodWriter = WritersFactory
                                                .getWriter(setMethod.getClass());
                                        final String javacode = methodWriter
                                                .write(objectName,
                                                        setMethod.getName(),
                                                        methodName);
                                        System.out.println(javacode);
                                        sb.append(javacode);
                                    }
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
        sb.append(getJavaMethodReturn(objectName));
        methodsJavaCode.add(sb.toString());
    }
}

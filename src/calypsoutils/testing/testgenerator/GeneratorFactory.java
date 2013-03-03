/**
 * 
 */
package calypsoutils.testing.testgenerator;

import calypsoutils.testing.testgenerator.generator.GeneratorInterface;

/**
 * @author quique
 * 
 */
public class GeneratorFactory {
    public static GeneratorInterface getGenerator(final Object objToSpy) {
        String clazz = objToSpy.getClass().getSimpleName();
        clazz = clazz.toUpperCase();
        final GeneratorEnum generatorEnum;
        try {
            generatorEnum = GeneratorEnum.valueOf(clazz);
        } catch (final IllegalArgumentException ex) {
            // the enumerated does not match the object class
            return GeneratorEnum.DEFAULT.getGenerator();
        }
        return generatorEnum.getGenerator();
    }
}

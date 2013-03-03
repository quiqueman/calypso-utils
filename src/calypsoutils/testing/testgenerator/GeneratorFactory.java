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
    public GeneratorInterface getGenerator(final Object objToSpy) {
        String clazz = objToSpy.getClass().getSimpleName();
        clazz = clazz.toUpperCase();
        final GeneratorEnum generatorEnum = GeneratorEnum.valueOf(clazz);
        if (generatorEnum == null) {
            return GeneratorEnum.DEFAULT.getGenerator();
        }
        return generatorEnum.getGenerator();
    }
}

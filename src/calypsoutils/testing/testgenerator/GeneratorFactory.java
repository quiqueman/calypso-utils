/**
 * 
 */
package calypsoutils.testing.testgenerator;

/**
 * @author quique
 * 
 */
public class GeneratorFactory {
    public Generator getGenerator(final Object objToSpy) {
        String clazz = objToSpy.getClass().getSimpleName();
        clazz = clazz.toUpperCase();
        final GeneratorEnum generatorEnum = GeneratorEnum.valueOf(clazz);
        if (generatorEnum == null) {
            return GeneratorEnum.TODO.getGenerator();
        }
        return generatorEnum.getGenerator();
    }
}

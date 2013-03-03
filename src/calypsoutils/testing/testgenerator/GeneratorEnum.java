/**
 * 
 */
package calypsoutils.testing.testgenerator;

import calypsoutils.testing.testgenerator.generator.DefaultGenerator;
import calypsoutils.testing.testgenerator.generator.GeneratorInterface;

/**
 * @author quique
 * 
 */
public enum GeneratorEnum {
    DEFAULT(new DefaultGenerator());

    private GeneratorInterface generator;

    /**
     * @return the generator
     */
    public GeneratorInterface getGenerator() {
        return this.generator;
    }

    /**
     * @param generator
     */
    private GeneratorEnum(final GeneratorInterface generator) {
        this.generator = generator;
    }

}

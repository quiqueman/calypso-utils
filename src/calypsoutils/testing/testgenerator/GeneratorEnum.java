/**
 * 
 */
package calypsoutils.testing.testgenerator;

/**
 * @author quique
 * 
 */
public enum GeneratorEnum {
    TODO(new TodoGenerator());

    private Generator generator;

    /**
     * @return the generator
     */
    public Generator getGenerator() {
        return this.generator;
    }

    /**
     * @param generator
     */
    private GeneratorEnum(final Generator generator) {
        this.generator = generator;
    }

}

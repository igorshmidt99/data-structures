import direct.BitSet;
import org.junit.jupiter.api.extension.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Collections.singletonList;

public class ParameterizedExtension implements TestTemplateInvocationContextProvider {

    @Override
    public boolean supportsTestTemplate(ExtensionContext context) {
        return context.getRequiredTestMethod() != null;
    }

    @Override
    public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext context) {
        Method requiredTestMethod = context.getRequiredTestMethod();
        Value params = requiredTestMethod.getAnnotation(Value.class);
        return Arrays.stream(params.value())
                .map(bitSetA -> new BitSet(bitSetA.wordLength(), bitSetA.bits()))
                .map(Context::new);
    }

    static class Context implements TestTemplateInvocationContext {

        private final BitSetResolver bitSetResolver;

        public Context(BitSet bitSet) {
            this.bitSetResolver = new BitSetResolver(bitSet);
        }

        @Override
        public List<Extension> getAdditionalExtensions() {
            return singletonList(bitSetResolver);
        }

    }

    static class BitSetResolver implements ParameterResolver {

        private final BitSet bitSet;

        BitSetResolver(BitSet bitSet) {
            this.bitSet = bitSet;
        }

        @Override
        public boolean supportsParameter(ParameterContext parameterContext,
                                         ExtensionContext extensionContext) throws ParameterResolutionException {
            return bitSet != null;
        }

        @Override
        public BitSet resolveParameter(ParameterContext parameterContext,
                                       ExtensionContext extensionContext) throws ParameterResolutionException {
            return bitSet;
        }
    }
}
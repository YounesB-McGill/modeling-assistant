/*
 * generated by Xtext 2.23.0
 */
package modelingassistant.learningcorpus.dsl.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class LearningCorpusDSLAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("modelingassistant/learningcorpus/dsl/parser/antlr/internal/InternalLearningCorpusDSL.tokens");
	}
}
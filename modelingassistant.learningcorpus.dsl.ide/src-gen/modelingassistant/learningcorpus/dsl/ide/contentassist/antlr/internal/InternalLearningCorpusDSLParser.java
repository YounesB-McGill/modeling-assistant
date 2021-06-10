package modelingassistant.learningcorpus.dsl.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import modelingassistant.learningcorpus.dsl.services.LearningCorpusDSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalLearningCorpusDSLParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=5;
    public static final int RULE_ML_COMMENT=7;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalLearningCorpusDSLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalLearningCorpusDSLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalLearningCorpusDSLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalLearningCorpusDSL.g"; }


    	private LearningCorpusDSLGrammarAccess grammarAccess;

    	public void setGrammarAccess(LearningCorpusDSLGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleLearningCorpus"
    // InternalLearningCorpusDSL.g:53:1: entryRuleLearningCorpus : ruleLearningCorpus EOF ;
    public final void entryRuleLearningCorpus() throws RecognitionException {
        try {
            // InternalLearningCorpusDSL.g:54:1: ( ruleLearningCorpus EOF )
            // InternalLearningCorpusDSL.g:55:1: ruleLearningCorpus EOF
            {
             before(grammarAccess.getLearningCorpusRule()); 
            pushFollow(FOLLOW_1);
            ruleLearningCorpus();

            state._fsp--;

             after(grammarAccess.getLearningCorpusRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLearningCorpus"


    // $ANTLR start "ruleLearningCorpus"
    // InternalLearningCorpusDSL.g:62:1: ruleLearningCorpus : ( ( rule__LearningCorpus__MistakeTypeCategoriesAssignment )* ) ;
    public final void ruleLearningCorpus() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:66:2: ( ( ( rule__LearningCorpus__MistakeTypeCategoriesAssignment )* ) )
            // InternalLearningCorpusDSL.g:67:2: ( ( rule__LearningCorpus__MistakeTypeCategoriesAssignment )* )
            {
            // InternalLearningCorpusDSL.g:67:2: ( ( rule__LearningCorpus__MistakeTypeCategoriesAssignment )* )
            // InternalLearningCorpusDSL.g:68:3: ( rule__LearningCorpus__MistakeTypeCategoriesAssignment )*
            {
             before(grammarAccess.getLearningCorpusAccess().getMistakeTypeCategoriesAssignment()); 
            // InternalLearningCorpusDSL.g:69:3: ( rule__LearningCorpus__MistakeTypeCategoriesAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalLearningCorpusDSL.g:69:4: rule__LearningCorpus__MistakeTypeCategoriesAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__LearningCorpus__MistakeTypeCategoriesAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getLearningCorpusAccess().getMistakeTypeCategoriesAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLearningCorpus"


    // $ANTLR start "entryRuleMistakeTypeCategory"
    // InternalLearningCorpusDSL.g:78:1: entryRuleMistakeTypeCategory : ruleMistakeTypeCategory EOF ;
    public final void entryRuleMistakeTypeCategory() throws RecognitionException {
        try {
            // InternalLearningCorpusDSL.g:79:1: ( ruleMistakeTypeCategory EOF )
            // InternalLearningCorpusDSL.g:80:1: ruleMistakeTypeCategory EOF
            {
             before(grammarAccess.getMistakeTypeCategoryRule()); 
            pushFollow(FOLLOW_1);
            ruleMistakeTypeCategory();

            state._fsp--;

             after(grammarAccess.getMistakeTypeCategoryRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMistakeTypeCategory"


    // $ANTLR start "ruleMistakeTypeCategory"
    // InternalLearningCorpusDSL.g:87:1: ruleMistakeTypeCategory : ( ( rule__MistakeTypeCategory__NameAssignment ) ) ;
    public final void ruleMistakeTypeCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:91:2: ( ( ( rule__MistakeTypeCategory__NameAssignment ) ) )
            // InternalLearningCorpusDSL.g:92:2: ( ( rule__MistakeTypeCategory__NameAssignment ) )
            {
            // InternalLearningCorpusDSL.g:92:2: ( ( rule__MistakeTypeCategory__NameAssignment ) )
            // InternalLearningCorpusDSL.g:93:3: ( rule__MistakeTypeCategory__NameAssignment )
            {
             before(grammarAccess.getMistakeTypeCategoryAccess().getNameAssignment()); 
            // InternalLearningCorpusDSL.g:94:3: ( rule__MistakeTypeCategory__NameAssignment )
            // InternalLearningCorpusDSL.g:94:4: rule__MistakeTypeCategory__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__MistakeTypeCategory__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getMistakeTypeCategoryAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMistakeTypeCategory"


    // $ANTLR start "rule__LearningCorpus__MistakeTypeCategoriesAssignment"
    // InternalLearningCorpusDSL.g:102:1: rule__LearningCorpus__MistakeTypeCategoriesAssignment : ( ruleMistakeTypeCategory ) ;
    public final void rule__LearningCorpus__MistakeTypeCategoriesAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:106:1: ( ( ruleMistakeTypeCategory ) )
            // InternalLearningCorpusDSL.g:107:2: ( ruleMistakeTypeCategory )
            {
            // InternalLearningCorpusDSL.g:107:2: ( ruleMistakeTypeCategory )
            // InternalLearningCorpusDSL.g:108:3: ruleMistakeTypeCategory
            {
             before(grammarAccess.getLearningCorpusAccess().getMistakeTypeCategoriesMistakeTypeCategoryParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleMistakeTypeCategory();

            state._fsp--;

             after(grammarAccess.getLearningCorpusAccess().getMistakeTypeCategoriesMistakeTypeCategoryParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LearningCorpus__MistakeTypeCategoriesAssignment"


    // $ANTLR start "rule__MistakeTypeCategory__NameAssignment"
    // InternalLearningCorpusDSL.g:117:1: rule__MistakeTypeCategory__NameAssignment : ( RULE_ID ) ;
    public final void rule__MistakeTypeCategory__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:121:1: ( ( RULE_ID ) )
            // InternalLearningCorpusDSL.g:122:2: ( RULE_ID )
            {
            // InternalLearningCorpusDSL.g:122:2: ( RULE_ID )
            // InternalLearningCorpusDSL.g:123:3: RULE_ID
            {
             before(grammarAccess.getMistakeTypeCategoryAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getMistakeTypeCategoryAccess().getNameIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MistakeTypeCategory__NameAssignment"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});

}
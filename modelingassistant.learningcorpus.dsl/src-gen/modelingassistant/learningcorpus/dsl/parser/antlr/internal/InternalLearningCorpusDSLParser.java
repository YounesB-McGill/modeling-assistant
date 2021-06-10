package modelingassistant.learningcorpus.dsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import modelingassistant.learningcorpus.dsl.services.LearningCorpusDSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalLearningCorpusDSLParser extends AbstractInternalAntlrParser {
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

        public InternalLearningCorpusDSLParser(TokenStream input, LearningCorpusDSLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "LearningCorpus";
       	}

       	@Override
       	protected LearningCorpusDSLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleLearningCorpus"
    // InternalLearningCorpusDSL.g:64:1: entryRuleLearningCorpus returns [EObject current=null] : iv_ruleLearningCorpus= ruleLearningCorpus EOF ;
    public final EObject entryRuleLearningCorpus() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLearningCorpus = null;


        try {
            // InternalLearningCorpusDSL.g:64:55: (iv_ruleLearningCorpus= ruleLearningCorpus EOF )
            // InternalLearningCorpusDSL.g:65:2: iv_ruleLearningCorpus= ruleLearningCorpus EOF
            {
             newCompositeNode(grammarAccess.getLearningCorpusRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLearningCorpus=ruleLearningCorpus();

            state._fsp--;

             current =iv_ruleLearningCorpus; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLearningCorpus"


    // $ANTLR start "ruleLearningCorpus"
    // InternalLearningCorpusDSL.g:71:1: ruleLearningCorpus returns [EObject current=null] : ( (lv_mistakeTypeCategories_0_0= ruleMistakeTypeCategory ) )* ;
    public final EObject ruleLearningCorpus() throws RecognitionException {
        EObject current = null;

        EObject lv_mistakeTypeCategories_0_0 = null;



        	enterRule();

        try {
            // InternalLearningCorpusDSL.g:77:2: ( ( (lv_mistakeTypeCategories_0_0= ruleMistakeTypeCategory ) )* )
            // InternalLearningCorpusDSL.g:78:2: ( (lv_mistakeTypeCategories_0_0= ruleMistakeTypeCategory ) )*
            {
            // InternalLearningCorpusDSL.g:78:2: ( (lv_mistakeTypeCategories_0_0= ruleMistakeTypeCategory ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalLearningCorpusDSL.g:79:3: (lv_mistakeTypeCategories_0_0= ruleMistakeTypeCategory )
            	    {
            	    // InternalLearningCorpusDSL.g:79:3: (lv_mistakeTypeCategories_0_0= ruleMistakeTypeCategory )
            	    // InternalLearningCorpusDSL.g:80:4: lv_mistakeTypeCategories_0_0= ruleMistakeTypeCategory
            	    {

            	    				newCompositeNode(grammarAccess.getLearningCorpusAccess().getMistakeTypeCategoriesMistakeTypeCategoryParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_mistakeTypeCategories_0_0=ruleMistakeTypeCategory();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getLearningCorpusRule());
            	    				}
            	    				add(
            	    					current,
            	    					"mistakeTypeCategories",
            	    					lv_mistakeTypeCategories_0_0,
            	    					"modelingassistant.learningcorpus.dsl.LearningCorpusDSL.MistakeTypeCategory");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLearningCorpus"


    // $ANTLR start "entryRuleMistakeTypeCategory"
    // InternalLearningCorpusDSL.g:100:1: entryRuleMistakeTypeCategory returns [EObject current=null] : iv_ruleMistakeTypeCategory= ruleMistakeTypeCategory EOF ;
    public final EObject entryRuleMistakeTypeCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMistakeTypeCategory = null;


        try {
            // InternalLearningCorpusDSL.g:100:60: (iv_ruleMistakeTypeCategory= ruleMistakeTypeCategory EOF )
            // InternalLearningCorpusDSL.g:101:2: iv_ruleMistakeTypeCategory= ruleMistakeTypeCategory EOF
            {
             newCompositeNode(grammarAccess.getMistakeTypeCategoryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMistakeTypeCategory=ruleMistakeTypeCategory();

            state._fsp--;

             current =iv_ruleMistakeTypeCategory; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMistakeTypeCategory"


    // $ANTLR start "ruleMistakeTypeCategory"
    // InternalLearningCorpusDSL.g:107:1: ruleMistakeTypeCategory returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleMistakeTypeCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalLearningCorpusDSL.g:113:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalLearningCorpusDSL.g:114:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalLearningCorpusDSL.g:114:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalLearningCorpusDSL.g:115:3: (lv_name_0_0= RULE_ID )
            {
            // InternalLearningCorpusDSL.g:115:3: (lv_name_0_0= RULE_ID )
            // InternalLearningCorpusDSL.g:116:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getMistakeTypeCategoryAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getMistakeTypeCategoryRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMistakeTypeCategory"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});

}
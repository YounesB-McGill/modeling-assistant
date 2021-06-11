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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_WS", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ANY_OTHER", "'MistakeTypeCategory'", "'{'", "'mistakeTypes'", "'}'", "'Mistake'", "'atomic'", "'LearningItem'"
    };
    public static final int RULE_ID=6;
    public static final int RULE_WS=4;
    public static final int RULE_STRING=7;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
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
    // InternalLearningCorpusDSL.g:71:1: ruleLearningCorpus returns [EObject current=null] : ( ( (lv_mistakeTypeCategories_0_0= ruleMistakeTypeCategory ) )* ( (lv_learningItems_1_0= ruleLearningItem ) )* ) ;
    public final EObject ruleLearningCorpus() throws RecognitionException {
        EObject current = null;

        EObject lv_mistakeTypeCategories_0_0 = null;

        EObject lv_learningItems_1_0 = null;



        	enterRule();

        try {
            // InternalLearningCorpusDSL.g:77:2: ( ( ( (lv_mistakeTypeCategories_0_0= ruleMistakeTypeCategory ) )* ( (lv_learningItems_1_0= ruleLearningItem ) )* ) )
            // InternalLearningCorpusDSL.g:78:2: ( ( (lv_mistakeTypeCategories_0_0= ruleMistakeTypeCategory ) )* ( (lv_learningItems_1_0= ruleLearningItem ) )* )
            {
            // InternalLearningCorpusDSL.g:78:2: ( ( (lv_mistakeTypeCategories_0_0= ruleMistakeTypeCategory ) )* ( (lv_learningItems_1_0= ruleLearningItem ) )* )
            // InternalLearningCorpusDSL.g:79:3: ( (lv_mistakeTypeCategories_0_0= ruleMistakeTypeCategory ) )* ( (lv_learningItems_1_0= ruleLearningItem ) )*
            {
            // InternalLearningCorpusDSL.g:79:3: ( (lv_mistakeTypeCategories_0_0= ruleMistakeTypeCategory ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalLearningCorpusDSL.g:80:4: (lv_mistakeTypeCategories_0_0= ruleMistakeTypeCategory )
            	    {
            	    // InternalLearningCorpusDSL.g:80:4: (lv_mistakeTypeCategories_0_0= ruleMistakeTypeCategory )
            	    // InternalLearningCorpusDSL.g:81:5: lv_mistakeTypeCategories_0_0= ruleMistakeTypeCategory
            	    {

            	    					newCompositeNode(grammarAccess.getLearningCorpusAccess().getMistakeTypeCategoriesMistakeTypeCategoryParserRuleCall_0_0());
            	    				
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

            // InternalLearningCorpusDSL.g:98:3: ( (lv_learningItems_1_0= ruleLearningItem ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==17) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalLearningCorpusDSL.g:99:4: (lv_learningItems_1_0= ruleLearningItem )
            	    {
            	    // InternalLearningCorpusDSL.g:99:4: (lv_learningItems_1_0= ruleLearningItem )
            	    // InternalLearningCorpusDSL.g:100:5: lv_learningItems_1_0= ruleLearningItem
            	    {

            	    					newCompositeNode(grammarAccess.getLearningCorpusAccess().getLearningItemsLearningItemParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_learningItems_1_0=ruleLearningItem();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getLearningCorpusRule());
            	    					}
            	    					add(
            	    						current,
            	    						"learningItems",
            	    						lv_learningItems_1_0,
            	    						"modelingassistant.learningcorpus.dsl.LearningCorpusDSL.LearningItem");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


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
    // $ANTLR end "ruleLearningCorpus"


    // $ANTLR start "entryRuleMistakeTypeCategory"
    // InternalLearningCorpusDSL.g:121:1: entryRuleMistakeTypeCategory returns [EObject current=null] : iv_ruleMistakeTypeCategory= ruleMistakeTypeCategory EOF ;
    public final EObject entryRuleMistakeTypeCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMistakeTypeCategory = null;


        try {
            // InternalLearningCorpusDSL.g:121:60: (iv_ruleMistakeTypeCategory= ruleMistakeTypeCategory EOF )
            // InternalLearningCorpusDSL.g:122:2: iv_ruleMistakeTypeCategory= ruleMistakeTypeCategory EOF
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
    // InternalLearningCorpusDSL.g:128:1: ruleMistakeTypeCategory returns [EObject current=null] : (otherlv_0= 'MistakeTypeCategory' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'mistakeTypes' (this_WS_4= RULE_WS )* otherlv_5= '{' ( (lv_mistakeTypes_6_0= ruleMistakeType ) )* otherlv_7= '}' otherlv_8= '}' ) ;
    public final EObject ruleMistakeTypeCategory() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token this_WS_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_mistakeTypes_6_0 = null;



        	enterRule();

        try {
            // InternalLearningCorpusDSL.g:134:2: ( (otherlv_0= 'MistakeTypeCategory' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'mistakeTypes' (this_WS_4= RULE_WS )* otherlv_5= '{' ( (lv_mistakeTypes_6_0= ruleMistakeType ) )* otherlv_7= '}' otherlv_8= '}' ) )
            // InternalLearningCorpusDSL.g:135:2: (otherlv_0= 'MistakeTypeCategory' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'mistakeTypes' (this_WS_4= RULE_WS )* otherlv_5= '{' ( (lv_mistakeTypes_6_0= ruleMistakeType ) )* otherlv_7= '}' otherlv_8= '}' )
            {
            // InternalLearningCorpusDSL.g:135:2: (otherlv_0= 'MistakeTypeCategory' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'mistakeTypes' (this_WS_4= RULE_WS )* otherlv_5= '{' ( (lv_mistakeTypes_6_0= ruleMistakeType ) )* otherlv_7= '}' otherlv_8= '}' )
            // InternalLearningCorpusDSL.g:136:3: otherlv_0= 'MistakeTypeCategory' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'mistakeTypes' (this_WS_4= RULE_WS )* otherlv_5= '{' ( (lv_mistakeTypes_6_0= ruleMistakeType ) )* otherlv_7= '}' otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getMistakeTypeCategoryAccess().getMistakeTypeCategoryKeyword_0());
            		
            // InternalLearningCorpusDSL.g:140:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLearningCorpusDSL.g:141:4: (lv_name_1_0= ruleEString )
            {
            // InternalLearningCorpusDSL.g:141:4: (lv_name_1_0= ruleEString )
            // InternalLearningCorpusDSL.g:142:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getMistakeTypeCategoryAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_6);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMistakeTypeCategoryRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"modelingassistant.learningcorpus.dsl.LearningCorpusDSL.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getMistakeTypeCategoryAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,13,FOLLOW_8); 

            			newLeafNode(otherlv_3, grammarAccess.getMistakeTypeCategoryAccess().getMistakeTypesKeyword_3());
            		
            // InternalLearningCorpusDSL.g:167:3: (this_WS_4= RULE_WS )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_WS) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalLearningCorpusDSL.g:168:4: this_WS_4= RULE_WS
            	    {
            	    this_WS_4=(Token)match(input,RULE_WS,FOLLOW_8); 

            	    				newLeafNode(this_WS_4, grammarAccess.getMistakeTypeCategoryAccess().getWSTerminalRuleCall_4());
            	    			

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_5=(Token)match(input,12,FOLLOW_9); 

            			newLeafNode(otherlv_5, grammarAccess.getMistakeTypeCategoryAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalLearningCorpusDSL.g:177:3: ( (lv_mistakeTypes_6_0= ruleMistakeType ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalLearningCorpusDSL.g:178:4: (lv_mistakeTypes_6_0= ruleMistakeType )
            	    {
            	    // InternalLearningCorpusDSL.g:178:4: (lv_mistakeTypes_6_0= ruleMistakeType )
            	    // InternalLearningCorpusDSL.g:179:5: lv_mistakeTypes_6_0= ruleMistakeType
            	    {

            	    					newCompositeNode(grammarAccess.getMistakeTypeCategoryAccess().getMistakeTypesMistakeTypeParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_mistakeTypes_6_0=ruleMistakeType();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMistakeTypeCategoryRule());
            	    					}
            	    					add(
            	    						current,
            	    						"mistakeTypes",
            	    						lv_mistakeTypes_6_0,
            	    						"modelingassistant.learningcorpus.dsl.LearningCorpusDSL.MistakeType");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_7=(Token)match(input,14,FOLLOW_10); 

            			newLeafNode(otherlv_7, grammarAccess.getMistakeTypeCategoryAccess().getRightCurlyBracketKeyword_7());
            		
            otherlv_8=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getMistakeTypeCategoryAccess().getRightCurlyBracketKeyword_8());
            		

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


    // $ANTLR start "entryRuleMistakeType"
    // InternalLearningCorpusDSL.g:208:1: entryRuleMistakeType returns [EObject current=null] : iv_ruleMistakeType= ruleMistakeType EOF ;
    public final EObject entryRuleMistakeType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMistakeType = null;


        try {
            // InternalLearningCorpusDSL.g:208:52: (iv_ruleMistakeType= ruleMistakeType EOF )
            // InternalLearningCorpusDSL.g:209:2: iv_ruleMistakeType= ruleMistakeType EOF
            {
             newCompositeNode(grammarAccess.getMistakeTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMistakeType=ruleMistakeType();

            state._fsp--;

             current =iv_ruleMistakeType; 
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
    // $ANTLR end "entryRuleMistakeType"


    // $ANTLR start "ruleMistakeType"
    // InternalLearningCorpusDSL.g:215:1: ruleMistakeType returns [EObject current=null] : (otherlv_0= 'Mistake' ( (lv_name_1_0= ruleEString ) ) ( (lv_atomic_2_0= 'atomic' ) )? ( (lv_numStepsBeforeNotification_3_0= RULE_INT ) )? ( (otherlv_4= RULE_ID ) ) ) ;
    public final EObject ruleMistakeType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_atomic_2_0=null;
        Token lv_numStepsBeforeNotification_3_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalLearningCorpusDSL.g:221:2: ( (otherlv_0= 'Mistake' ( (lv_name_1_0= ruleEString ) ) ( (lv_atomic_2_0= 'atomic' ) )? ( (lv_numStepsBeforeNotification_3_0= RULE_INT ) )? ( (otherlv_4= RULE_ID ) ) ) )
            // InternalLearningCorpusDSL.g:222:2: (otherlv_0= 'Mistake' ( (lv_name_1_0= ruleEString ) ) ( (lv_atomic_2_0= 'atomic' ) )? ( (lv_numStepsBeforeNotification_3_0= RULE_INT ) )? ( (otherlv_4= RULE_ID ) ) )
            {
            // InternalLearningCorpusDSL.g:222:2: (otherlv_0= 'Mistake' ( (lv_name_1_0= ruleEString ) ) ( (lv_atomic_2_0= 'atomic' ) )? ( (lv_numStepsBeforeNotification_3_0= RULE_INT ) )? ( (otherlv_4= RULE_ID ) ) )
            // InternalLearningCorpusDSL.g:223:3: otherlv_0= 'Mistake' ( (lv_name_1_0= ruleEString ) ) ( (lv_atomic_2_0= 'atomic' ) )? ( (lv_numStepsBeforeNotification_3_0= RULE_INT ) )? ( (otherlv_4= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getMistakeTypeAccess().getMistakeKeyword_0());
            		
            // InternalLearningCorpusDSL.g:227:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLearningCorpusDSL.g:228:4: (lv_name_1_0= ruleEString )
            {
            // InternalLearningCorpusDSL.g:228:4: (lv_name_1_0= ruleEString )
            // InternalLearningCorpusDSL.g:229:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getMistakeTypeAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_11);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMistakeTypeRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"modelingassistant.learningcorpus.dsl.LearningCorpusDSL.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalLearningCorpusDSL.g:246:3: ( (lv_atomic_2_0= 'atomic' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalLearningCorpusDSL.g:247:4: (lv_atomic_2_0= 'atomic' )
                    {
                    // InternalLearningCorpusDSL.g:247:4: (lv_atomic_2_0= 'atomic' )
                    // InternalLearningCorpusDSL.g:248:5: lv_atomic_2_0= 'atomic'
                    {
                    lv_atomic_2_0=(Token)match(input,16,FOLLOW_12); 

                    					newLeafNode(lv_atomic_2_0, grammarAccess.getMistakeTypeAccess().getAtomicAtomicKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMistakeTypeRule());
                    					}
                    					setWithLastConsumed(current, "atomic", lv_atomic_2_0 != null, "atomic");
                    				

                    }


                    }
                    break;

            }

            // InternalLearningCorpusDSL.g:260:3: ( (lv_numStepsBeforeNotification_3_0= RULE_INT ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_INT) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalLearningCorpusDSL.g:261:4: (lv_numStepsBeforeNotification_3_0= RULE_INT )
                    {
                    // InternalLearningCorpusDSL.g:261:4: (lv_numStepsBeforeNotification_3_0= RULE_INT )
                    // InternalLearningCorpusDSL.g:262:5: lv_numStepsBeforeNotification_3_0= RULE_INT
                    {
                    lv_numStepsBeforeNotification_3_0=(Token)match(input,RULE_INT,FOLLOW_13); 

                    					newLeafNode(lv_numStepsBeforeNotification_3_0, grammarAccess.getMistakeTypeAccess().getNumStepsBeforeNotificationINTTerminalRuleCall_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMistakeTypeRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"numStepsBeforeNotification",
                    						lv_numStepsBeforeNotification_3_0,
                    						"org.eclipse.xtext.common.Terminals.INT");
                    				

                    }


                    }
                    break;

            }

            // InternalLearningCorpusDSL.g:278:3: ( (otherlv_4= RULE_ID ) )
            // InternalLearningCorpusDSL.g:279:4: (otherlv_4= RULE_ID )
            {
            // InternalLearningCorpusDSL.g:279:4: (otherlv_4= RULE_ID )
            // InternalLearningCorpusDSL.g:280:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMistakeTypeRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_4, grammarAccess.getMistakeTypeAccess().getLearningItemLearningItemCrossReference_4_0());
            				

            }


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
    // $ANTLR end "ruleMistakeType"


    // $ANTLR start "entryRuleLearningItem"
    // InternalLearningCorpusDSL.g:295:1: entryRuleLearningItem returns [EObject current=null] : iv_ruleLearningItem= ruleLearningItem EOF ;
    public final EObject entryRuleLearningItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLearningItem = null;


        try {
            // InternalLearningCorpusDSL.g:295:53: (iv_ruleLearningItem= ruleLearningItem EOF )
            // InternalLearningCorpusDSL.g:296:2: iv_ruleLearningItem= ruleLearningItem EOF
            {
             newCompositeNode(grammarAccess.getLearningItemRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLearningItem=ruleLearningItem();

            state._fsp--;

             current =iv_ruleLearningItem; 
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
    // $ANTLR end "entryRuleLearningItem"


    // $ANTLR start "ruleLearningItem"
    // InternalLearningCorpusDSL.g:302:1: ruleLearningItem returns [EObject current=null] : (otherlv_0= 'LearningItem' ( (lv_name_1_0= ruleEString ) ) ( (lv_description_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleLearningItem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_description_2_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalLearningCorpusDSL.g:308:2: ( (otherlv_0= 'LearningItem' ( (lv_name_1_0= ruleEString ) ) ( (lv_description_2_0= RULE_STRING ) ) ) )
            // InternalLearningCorpusDSL.g:309:2: (otherlv_0= 'LearningItem' ( (lv_name_1_0= ruleEString ) ) ( (lv_description_2_0= RULE_STRING ) ) )
            {
            // InternalLearningCorpusDSL.g:309:2: (otherlv_0= 'LearningItem' ( (lv_name_1_0= ruleEString ) ) ( (lv_description_2_0= RULE_STRING ) ) )
            // InternalLearningCorpusDSL.g:310:3: otherlv_0= 'LearningItem' ( (lv_name_1_0= ruleEString ) ) ( (lv_description_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getLearningItemAccess().getLearningItemKeyword_0());
            		
            // InternalLearningCorpusDSL.g:314:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLearningCorpusDSL.g:315:4: (lv_name_1_0= ruleEString )
            {
            // InternalLearningCorpusDSL.g:315:4: (lv_name_1_0= ruleEString )
            // InternalLearningCorpusDSL.g:316:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getLearningItemAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_14);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLearningItemRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"modelingassistant.learningcorpus.dsl.LearningCorpusDSL.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalLearningCorpusDSL.g:333:3: ( (lv_description_2_0= RULE_STRING ) )
            // InternalLearningCorpusDSL.g:334:4: (lv_description_2_0= RULE_STRING )
            {
            // InternalLearningCorpusDSL.g:334:4: (lv_description_2_0= RULE_STRING )
            // InternalLearningCorpusDSL.g:335:5: lv_description_2_0= RULE_STRING
            {
            lv_description_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_description_2_0, grammarAccess.getLearningItemAccess().getDescriptionSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLearningItemRule());
            					}
            					setWithLastConsumed(
            						current,
            						"description",
            						lv_description_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


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
    // $ANTLR end "ruleLearningItem"


    // $ANTLR start "entryRuleEString"
    // InternalLearningCorpusDSL.g:355:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalLearningCorpusDSL.g:355:47: (iv_ruleEString= ruleEString EOF )
            // InternalLearningCorpusDSL.g:356:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
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
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalLearningCorpusDSL.g:362:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalLearningCorpusDSL.g:368:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalLearningCorpusDSL.g:369:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalLearningCorpusDSL.g:369:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_STRING) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_ID) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalLearningCorpusDSL.g:370:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalLearningCorpusDSL.g:378:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;

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
    // $ANTLR end "ruleEString"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000020802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000010060L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000080L});

}
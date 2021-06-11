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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_WS", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ANY_OTHER", "'MistakeTypeCategory'", "'}'", "'{'", "'mistakeTypes'", "'Mistake'", "'LearningItem'", "'atomic'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_WS=6;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int RULE_INT=7;
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
    // InternalLearningCorpusDSL.g:62:1: ruleLearningCorpus : ( ( rule__LearningCorpus__Group__0 ) ) ;
    public final void ruleLearningCorpus() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:66:2: ( ( ( rule__LearningCorpus__Group__0 ) ) )
            // InternalLearningCorpusDSL.g:67:2: ( ( rule__LearningCorpus__Group__0 ) )
            {
            // InternalLearningCorpusDSL.g:67:2: ( ( rule__LearningCorpus__Group__0 ) )
            // InternalLearningCorpusDSL.g:68:3: ( rule__LearningCorpus__Group__0 )
            {
             before(grammarAccess.getLearningCorpusAccess().getGroup()); 
            // InternalLearningCorpusDSL.g:69:3: ( rule__LearningCorpus__Group__0 )
            // InternalLearningCorpusDSL.g:69:4: rule__LearningCorpus__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LearningCorpus__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLearningCorpusAccess().getGroup()); 

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
    // InternalLearningCorpusDSL.g:87:1: ruleMistakeTypeCategory : ( ( rule__MistakeTypeCategory__Group__0 ) ) ;
    public final void ruleMistakeTypeCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:91:2: ( ( ( rule__MistakeTypeCategory__Group__0 ) ) )
            // InternalLearningCorpusDSL.g:92:2: ( ( rule__MistakeTypeCategory__Group__0 ) )
            {
            // InternalLearningCorpusDSL.g:92:2: ( ( rule__MistakeTypeCategory__Group__0 ) )
            // InternalLearningCorpusDSL.g:93:3: ( rule__MistakeTypeCategory__Group__0 )
            {
             before(grammarAccess.getMistakeTypeCategoryAccess().getGroup()); 
            // InternalLearningCorpusDSL.g:94:3: ( rule__MistakeTypeCategory__Group__0 )
            // InternalLearningCorpusDSL.g:94:4: rule__MistakeTypeCategory__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MistakeTypeCategory__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMistakeTypeCategoryAccess().getGroup()); 

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


    // $ANTLR start "entryRuleMistakeType"
    // InternalLearningCorpusDSL.g:103:1: entryRuleMistakeType : ruleMistakeType EOF ;
    public final void entryRuleMistakeType() throws RecognitionException {
        try {
            // InternalLearningCorpusDSL.g:104:1: ( ruleMistakeType EOF )
            // InternalLearningCorpusDSL.g:105:1: ruleMistakeType EOF
            {
             before(grammarAccess.getMistakeTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleMistakeType();

            state._fsp--;

             after(grammarAccess.getMistakeTypeRule()); 
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
    // $ANTLR end "entryRuleMistakeType"


    // $ANTLR start "ruleMistakeType"
    // InternalLearningCorpusDSL.g:112:1: ruleMistakeType : ( ( rule__MistakeType__Group__0 ) ) ;
    public final void ruleMistakeType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:116:2: ( ( ( rule__MistakeType__Group__0 ) ) )
            // InternalLearningCorpusDSL.g:117:2: ( ( rule__MistakeType__Group__0 ) )
            {
            // InternalLearningCorpusDSL.g:117:2: ( ( rule__MistakeType__Group__0 ) )
            // InternalLearningCorpusDSL.g:118:3: ( rule__MistakeType__Group__0 )
            {
             before(grammarAccess.getMistakeTypeAccess().getGroup()); 
            // InternalLearningCorpusDSL.g:119:3: ( rule__MistakeType__Group__0 )
            // InternalLearningCorpusDSL.g:119:4: rule__MistakeType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MistakeType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMistakeTypeAccess().getGroup()); 

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
    // $ANTLR end "ruleMistakeType"


    // $ANTLR start "entryRuleLearningItem"
    // InternalLearningCorpusDSL.g:128:1: entryRuleLearningItem : ruleLearningItem EOF ;
    public final void entryRuleLearningItem() throws RecognitionException {
        try {
            // InternalLearningCorpusDSL.g:129:1: ( ruleLearningItem EOF )
            // InternalLearningCorpusDSL.g:130:1: ruleLearningItem EOF
            {
             before(grammarAccess.getLearningItemRule()); 
            pushFollow(FOLLOW_1);
            ruleLearningItem();

            state._fsp--;

             after(grammarAccess.getLearningItemRule()); 
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
    // $ANTLR end "entryRuleLearningItem"


    // $ANTLR start "ruleLearningItem"
    // InternalLearningCorpusDSL.g:137:1: ruleLearningItem : ( ( rule__LearningItem__Group__0 ) ) ;
    public final void ruleLearningItem() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:141:2: ( ( ( rule__LearningItem__Group__0 ) ) )
            // InternalLearningCorpusDSL.g:142:2: ( ( rule__LearningItem__Group__0 ) )
            {
            // InternalLearningCorpusDSL.g:142:2: ( ( rule__LearningItem__Group__0 ) )
            // InternalLearningCorpusDSL.g:143:3: ( rule__LearningItem__Group__0 )
            {
             before(grammarAccess.getLearningItemAccess().getGroup()); 
            // InternalLearningCorpusDSL.g:144:3: ( rule__LearningItem__Group__0 )
            // InternalLearningCorpusDSL.g:144:4: rule__LearningItem__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LearningItem__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLearningItemAccess().getGroup()); 

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
    // $ANTLR end "ruleLearningItem"


    // $ANTLR start "entryRuleEString"
    // InternalLearningCorpusDSL.g:153:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalLearningCorpusDSL.g:154:1: ( ruleEString EOF )
            // InternalLearningCorpusDSL.g:155:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
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
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalLearningCorpusDSL.g:162:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:166:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalLearningCorpusDSL.g:167:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalLearningCorpusDSL.g:167:2: ( ( rule__EString__Alternatives ) )
            // InternalLearningCorpusDSL.g:168:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalLearningCorpusDSL.g:169:3: ( rule__EString__Alternatives )
            // InternalLearningCorpusDSL.g:169:4: rule__EString__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EString__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEStringAccess().getAlternatives()); 

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
    // $ANTLR end "ruleEString"


    // $ANTLR start "rule__EString__Alternatives"
    // InternalLearningCorpusDSL.g:177:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:181:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_STRING) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_ID) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalLearningCorpusDSL.g:182:2: ( RULE_STRING )
                    {
                    // InternalLearningCorpusDSL.g:182:2: ( RULE_STRING )
                    // InternalLearningCorpusDSL.g:183:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLearningCorpusDSL.g:188:2: ( RULE_ID )
                    {
                    // InternalLearningCorpusDSL.g:188:2: ( RULE_ID )
                    // InternalLearningCorpusDSL.g:189:3: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

                    }


                    }
                    break;

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
    // $ANTLR end "rule__EString__Alternatives"


    // $ANTLR start "rule__LearningCorpus__Group__0"
    // InternalLearningCorpusDSL.g:198:1: rule__LearningCorpus__Group__0 : rule__LearningCorpus__Group__0__Impl rule__LearningCorpus__Group__1 ;
    public final void rule__LearningCorpus__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:202:1: ( rule__LearningCorpus__Group__0__Impl rule__LearningCorpus__Group__1 )
            // InternalLearningCorpusDSL.g:203:2: rule__LearningCorpus__Group__0__Impl rule__LearningCorpus__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__LearningCorpus__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LearningCorpus__Group__1();

            state._fsp--;


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
    // $ANTLR end "rule__LearningCorpus__Group__0"


    // $ANTLR start "rule__LearningCorpus__Group__0__Impl"
    // InternalLearningCorpusDSL.g:210:1: rule__LearningCorpus__Group__0__Impl : ( ( rule__LearningCorpus__MistakeTypeCategoriesAssignment_0 )* ) ;
    public final void rule__LearningCorpus__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:214:1: ( ( ( rule__LearningCorpus__MistakeTypeCategoriesAssignment_0 )* ) )
            // InternalLearningCorpusDSL.g:215:1: ( ( rule__LearningCorpus__MistakeTypeCategoriesAssignment_0 )* )
            {
            // InternalLearningCorpusDSL.g:215:1: ( ( rule__LearningCorpus__MistakeTypeCategoriesAssignment_0 )* )
            // InternalLearningCorpusDSL.g:216:2: ( rule__LearningCorpus__MistakeTypeCategoriesAssignment_0 )*
            {
             before(grammarAccess.getLearningCorpusAccess().getMistakeTypeCategoriesAssignment_0()); 
            // InternalLearningCorpusDSL.g:217:2: ( rule__LearningCorpus__MistakeTypeCategoriesAssignment_0 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalLearningCorpusDSL.g:217:3: rule__LearningCorpus__MistakeTypeCategoriesAssignment_0
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__LearningCorpus__MistakeTypeCategoriesAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getLearningCorpusAccess().getMistakeTypeCategoriesAssignment_0()); 

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
    // $ANTLR end "rule__LearningCorpus__Group__0__Impl"


    // $ANTLR start "rule__LearningCorpus__Group__1"
    // InternalLearningCorpusDSL.g:225:1: rule__LearningCorpus__Group__1 : rule__LearningCorpus__Group__1__Impl ;
    public final void rule__LearningCorpus__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:229:1: ( rule__LearningCorpus__Group__1__Impl )
            // InternalLearningCorpusDSL.g:230:2: rule__LearningCorpus__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LearningCorpus__Group__1__Impl();

            state._fsp--;


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
    // $ANTLR end "rule__LearningCorpus__Group__1"


    // $ANTLR start "rule__LearningCorpus__Group__1__Impl"
    // InternalLearningCorpusDSL.g:236:1: rule__LearningCorpus__Group__1__Impl : ( ( rule__LearningCorpus__LearningItemsAssignment_1 )* ) ;
    public final void rule__LearningCorpus__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:240:1: ( ( ( rule__LearningCorpus__LearningItemsAssignment_1 )* ) )
            // InternalLearningCorpusDSL.g:241:1: ( ( rule__LearningCorpus__LearningItemsAssignment_1 )* )
            {
            // InternalLearningCorpusDSL.g:241:1: ( ( rule__LearningCorpus__LearningItemsAssignment_1 )* )
            // InternalLearningCorpusDSL.g:242:2: ( rule__LearningCorpus__LearningItemsAssignment_1 )*
            {
             before(grammarAccess.getLearningCorpusAccess().getLearningItemsAssignment_1()); 
            // InternalLearningCorpusDSL.g:243:2: ( rule__LearningCorpus__LearningItemsAssignment_1 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==16) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalLearningCorpusDSL.g:243:3: rule__LearningCorpus__LearningItemsAssignment_1
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__LearningCorpus__LearningItemsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getLearningCorpusAccess().getLearningItemsAssignment_1()); 

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
    // $ANTLR end "rule__LearningCorpus__Group__1__Impl"


    // $ANTLR start "rule__MistakeTypeCategory__Group__0"
    // InternalLearningCorpusDSL.g:252:1: rule__MistakeTypeCategory__Group__0 : rule__MistakeTypeCategory__Group__0__Impl rule__MistakeTypeCategory__Group__1 ;
    public final void rule__MistakeTypeCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:256:1: ( rule__MistakeTypeCategory__Group__0__Impl rule__MistakeTypeCategory__Group__1 )
            // InternalLearningCorpusDSL.g:257:2: rule__MistakeTypeCategory__Group__0__Impl rule__MistakeTypeCategory__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__MistakeTypeCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MistakeTypeCategory__Group__1();

            state._fsp--;


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
    // $ANTLR end "rule__MistakeTypeCategory__Group__0"


    // $ANTLR start "rule__MistakeTypeCategory__Group__0__Impl"
    // InternalLearningCorpusDSL.g:264:1: rule__MistakeTypeCategory__Group__0__Impl : ( 'MistakeTypeCategory' ) ;
    public final void rule__MistakeTypeCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:268:1: ( ( 'MistakeTypeCategory' ) )
            // InternalLearningCorpusDSL.g:269:1: ( 'MistakeTypeCategory' )
            {
            // InternalLearningCorpusDSL.g:269:1: ( 'MistakeTypeCategory' )
            // InternalLearningCorpusDSL.g:270:2: 'MistakeTypeCategory'
            {
             before(grammarAccess.getMistakeTypeCategoryAccess().getMistakeTypeCategoryKeyword_0()); 
            match(input,11,FOLLOW_2); 
             after(grammarAccess.getMistakeTypeCategoryAccess().getMistakeTypeCategoryKeyword_0()); 

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
    // $ANTLR end "rule__MistakeTypeCategory__Group__0__Impl"


    // $ANTLR start "rule__MistakeTypeCategory__Group__1"
    // InternalLearningCorpusDSL.g:279:1: rule__MistakeTypeCategory__Group__1 : rule__MistakeTypeCategory__Group__1__Impl rule__MistakeTypeCategory__Group__2 ;
    public final void rule__MistakeTypeCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:283:1: ( rule__MistakeTypeCategory__Group__1__Impl rule__MistakeTypeCategory__Group__2 )
            // InternalLearningCorpusDSL.g:284:2: rule__MistakeTypeCategory__Group__1__Impl rule__MistakeTypeCategory__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__MistakeTypeCategory__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MistakeTypeCategory__Group__2();

            state._fsp--;


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
    // $ANTLR end "rule__MistakeTypeCategory__Group__1"


    // $ANTLR start "rule__MistakeTypeCategory__Group__1__Impl"
    // InternalLearningCorpusDSL.g:291:1: rule__MistakeTypeCategory__Group__1__Impl : ( ( rule__MistakeTypeCategory__NameAssignment_1 ) ) ;
    public final void rule__MistakeTypeCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:295:1: ( ( ( rule__MistakeTypeCategory__NameAssignment_1 ) ) )
            // InternalLearningCorpusDSL.g:296:1: ( ( rule__MistakeTypeCategory__NameAssignment_1 ) )
            {
            // InternalLearningCorpusDSL.g:296:1: ( ( rule__MistakeTypeCategory__NameAssignment_1 ) )
            // InternalLearningCorpusDSL.g:297:2: ( rule__MistakeTypeCategory__NameAssignment_1 )
            {
             before(grammarAccess.getMistakeTypeCategoryAccess().getNameAssignment_1()); 
            // InternalLearningCorpusDSL.g:298:2: ( rule__MistakeTypeCategory__NameAssignment_1 )
            // InternalLearningCorpusDSL.g:298:3: rule__MistakeTypeCategory__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__MistakeTypeCategory__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMistakeTypeCategoryAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__MistakeTypeCategory__Group__1__Impl"


    // $ANTLR start "rule__MistakeTypeCategory__Group__2"
    // InternalLearningCorpusDSL.g:306:1: rule__MistakeTypeCategory__Group__2 : rule__MistakeTypeCategory__Group__2__Impl rule__MistakeTypeCategory__Group__3 ;
    public final void rule__MistakeTypeCategory__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:310:1: ( rule__MistakeTypeCategory__Group__2__Impl rule__MistakeTypeCategory__Group__3 )
            // InternalLearningCorpusDSL.g:311:2: rule__MistakeTypeCategory__Group__2__Impl rule__MistakeTypeCategory__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__MistakeTypeCategory__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MistakeTypeCategory__Group__3();

            state._fsp--;


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
    // $ANTLR end "rule__MistakeTypeCategory__Group__2"


    // $ANTLR start "rule__MistakeTypeCategory__Group__2__Impl"
    // InternalLearningCorpusDSL.g:318:1: rule__MistakeTypeCategory__Group__2__Impl : ( ( rule__MistakeTypeCategory__Group_2__0 )? ) ;
    public final void rule__MistakeTypeCategory__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:322:1: ( ( ( rule__MistakeTypeCategory__Group_2__0 )? ) )
            // InternalLearningCorpusDSL.g:323:1: ( ( rule__MistakeTypeCategory__Group_2__0 )? )
            {
            // InternalLearningCorpusDSL.g:323:1: ( ( rule__MistakeTypeCategory__Group_2__0 )? )
            // InternalLearningCorpusDSL.g:324:2: ( rule__MistakeTypeCategory__Group_2__0 )?
            {
             before(grammarAccess.getMistakeTypeCategoryAccess().getGroup_2()); 
            // InternalLearningCorpusDSL.g:325:2: ( rule__MistakeTypeCategory__Group_2__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalLearningCorpusDSL.g:325:3: rule__MistakeTypeCategory__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MistakeTypeCategory__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMistakeTypeCategoryAccess().getGroup_2()); 

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
    // $ANTLR end "rule__MistakeTypeCategory__Group__2__Impl"


    // $ANTLR start "rule__MistakeTypeCategory__Group__3"
    // InternalLearningCorpusDSL.g:333:1: rule__MistakeTypeCategory__Group__3 : rule__MistakeTypeCategory__Group__3__Impl ;
    public final void rule__MistakeTypeCategory__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:337:1: ( rule__MistakeTypeCategory__Group__3__Impl )
            // InternalLearningCorpusDSL.g:338:2: rule__MistakeTypeCategory__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MistakeTypeCategory__Group__3__Impl();

            state._fsp--;


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
    // $ANTLR end "rule__MistakeTypeCategory__Group__3"


    // $ANTLR start "rule__MistakeTypeCategory__Group__3__Impl"
    // InternalLearningCorpusDSL.g:344:1: rule__MistakeTypeCategory__Group__3__Impl : ( '}' ) ;
    public final void rule__MistakeTypeCategory__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:348:1: ( ( '}' ) )
            // InternalLearningCorpusDSL.g:349:1: ( '}' )
            {
            // InternalLearningCorpusDSL.g:349:1: ( '}' )
            // InternalLearningCorpusDSL.g:350:2: '}'
            {
             before(grammarAccess.getMistakeTypeCategoryAccess().getRightCurlyBracketKeyword_3()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getMistakeTypeCategoryAccess().getRightCurlyBracketKeyword_3()); 

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
    // $ANTLR end "rule__MistakeTypeCategory__Group__3__Impl"


    // $ANTLR start "rule__MistakeTypeCategory__Group_2__0"
    // InternalLearningCorpusDSL.g:360:1: rule__MistakeTypeCategory__Group_2__0 : rule__MistakeTypeCategory__Group_2__0__Impl rule__MistakeTypeCategory__Group_2__1 ;
    public final void rule__MistakeTypeCategory__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:364:1: ( rule__MistakeTypeCategory__Group_2__0__Impl rule__MistakeTypeCategory__Group_2__1 )
            // InternalLearningCorpusDSL.g:365:2: rule__MistakeTypeCategory__Group_2__0__Impl rule__MistakeTypeCategory__Group_2__1
            {
            pushFollow(FOLLOW_8);
            rule__MistakeTypeCategory__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MistakeTypeCategory__Group_2__1();

            state._fsp--;


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
    // $ANTLR end "rule__MistakeTypeCategory__Group_2__0"


    // $ANTLR start "rule__MistakeTypeCategory__Group_2__0__Impl"
    // InternalLearningCorpusDSL.g:372:1: rule__MistakeTypeCategory__Group_2__0__Impl : ( '{' ) ;
    public final void rule__MistakeTypeCategory__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:376:1: ( ( '{' ) )
            // InternalLearningCorpusDSL.g:377:1: ( '{' )
            {
            // InternalLearningCorpusDSL.g:377:1: ( '{' )
            // InternalLearningCorpusDSL.g:378:2: '{'
            {
             before(grammarAccess.getMistakeTypeCategoryAccess().getLeftCurlyBracketKeyword_2_0()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getMistakeTypeCategoryAccess().getLeftCurlyBracketKeyword_2_0()); 

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
    // $ANTLR end "rule__MistakeTypeCategory__Group_2__0__Impl"


    // $ANTLR start "rule__MistakeTypeCategory__Group_2__1"
    // InternalLearningCorpusDSL.g:387:1: rule__MistakeTypeCategory__Group_2__1 : rule__MistakeTypeCategory__Group_2__1__Impl rule__MistakeTypeCategory__Group_2__2 ;
    public final void rule__MistakeTypeCategory__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:391:1: ( rule__MistakeTypeCategory__Group_2__1__Impl rule__MistakeTypeCategory__Group_2__2 )
            // InternalLearningCorpusDSL.g:392:2: rule__MistakeTypeCategory__Group_2__1__Impl rule__MistakeTypeCategory__Group_2__2
            {
            pushFollow(FOLLOW_9);
            rule__MistakeTypeCategory__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MistakeTypeCategory__Group_2__2();

            state._fsp--;


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
    // $ANTLR end "rule__MistakeTypeCategory__Group_2__1"


    // $ANTLR start "rule__MistakeTypeCategory__Group_2__1__Impl"
    // InternalLearningCorpusDSL.g:399:1: rule__MistakeTypeCategory__Group_2__1__Impl : ( 'mistakeTypes' ) ;
    public final void rule__MistakeTypeCategory__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:403:1: ( ( 'mistakeTypes' ) )
            // InternalLearningCorpusDSL.g:404:1: ( 'mistakeTypes' )
            {
            // InternalLearningCorpusDSL.g:404:1: ( 'mistakeTypes' )
            // InternalLearningCorpusDSL.g:405:2: 'mistakeTypes'
            {
             before(grammarAccess.getMistakeTypeCategoryAccess().getMistakeTypesKeyword_2_1()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getMistakeTypeCategoryAccess().getMistakeTypesKeyword_2_1()); 

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
    // $ANTLR end "rule__MistakeTypeCategory__Group_2__1__Impl"


    // $ANTLR start "rule__MistakeTypeCategory__Group_2__2"
    // InternalLearningCorpusDSL.g:414:1: rule__MistakeTypeCategory__Group_2__2 : rule__MistakeTypeCategory__Group_2__2__Impl rule__MistakeTypeCategory__Group_2__3 ;
    public final void rule__MistakeTypeCategory__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:418:1: ( rule__MistakeTypeCategory__Group_2__2__Impl rule__MistakeTypeCategory__Group_2__3 )
            // InternalLearningCorpusDSL.g:419:2: rule__MistakeTypeCategory__Group_2__2__Impl rule__MistakeTypeCategory__Group_2__3
            {
            pushFollow(FOLLOW_9);
            rule__MistakeTypeCategory__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MistakeTypeCategory__Group_2__3();

            state._fsp--;


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
    // $ANTLR end "rule__MistakeTypeCategory__Group_2__2"


    // $ANTLR start "rule__MistakeTypeCategory__Group_2__2__Impl"
    // InternalLearningCorpusDSL.g:426:1: rule__MistakeTypeCategory__Group_2__2__Impl : ( ( RULE_WS )* ) ;
    public final void rule__MistakeTypeCategory__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:430:1: ( ( ( RULE_WS )* ) )
            // InternalLearningCorpusDSL.g:431:1: ( ( RULE_WS )* )
            {
            // InternalLearningCorpusDSL.g:431:1: ( ( RULE_WS )* )
            // InternalLearningCorpusDSL.g:432:2: ( RULE_WS )*
            {
             before(grammarAccess.getMistakeTypeCategoryAccess().getWSTerminalRuleCall_2_2()); 
            // InternalLearningCorpusDSL.g:433:2: ( RULE_WS )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_WS) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalLearningCorpusDSL.g:433:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_10); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getMistakeTypeCategoryAccess().getWSTerminalRuleCall_2_2()); 

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
    // $ANTLR end "rule__MistakeTypeCategory__Group_2__2__Impl"


    // $ANTLR start "rule__MistakeTypeCategory__Group_2__3"
    // InternalLearningCorpusDSL.g:441:1: rule__MistakeTypeCategory__Group_2__3 : rule__MistakeTypeCategory__Group_2__3__Impl rule__MistakeTypeCategory__Group_2__4 ;
    public final void rule__MistakeTypeCategory__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:445:1: ( rule__MistakeTypeCategory__Group_2__3__Impl rule__MistakeTypeCategory__Group_2__4 )
            // InternalLearningCorpusDSL.g:446:2: rule__MistakeTypeCategory__Group_2__3__Impl rule__MistakeTypeCategory__Group_2__4
            {
            pushFollow(FOLLOW_11);
            rule__MistakeTypeCategory__Group_2__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MistakeTypeCategory__Group_2__4();

            state._fsp--;


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
    // $ANTLR end "rule__MistakeTypeCategory__Group_2__3"


    // $ANTLR start "rule__MistakeTypeCategory__Group_2__3__Impl"
    // InternalLearningCorpusDSL.g:453:1: rule__MistakeTypeCategory__Group_2__3__Impl : ( '{' ) ;
    public final void rule__MistakeTypeCategory__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:457:1: ( ( '{' ) )
            // InternalLearningCorpusDSL.g:458:1: ( '{' )
            {
            // InternalLearningCorpusDSL.g:458:1: ( '{' )
            // InternalLearningCorpusDSL.g:459:2: '{'
            {
             before(grammarAccess.getMistakeTypeCategoryAccess().getLeftCurlyBracketKeyword_2_3()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getMistakeTypeCategoryAccess().getLeftCurlyBracketKeyword_2_3()); 

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
    // $ANTLR end "rule__MistakeTypeCategory__Group_2__3__Impl"


    // $ANTLR start "rule__MistakeTypeCategory__Group_2__4"
    // InternalLearningCorpusDSL.g:468:1: rule__MistakeTypeCategory__Group_2__4 : rule__MistakeTypeCategory__Group_2__4__Impl rule__MistakeTypeCategory__Group_2__5 ;
    public final void rule__MistakeTypeCategory__Group_2__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:472:1: ( rule__MistakeTypeCategory__Group_2__4__Impl rule__MistakeTypeCategory__Group_2__5 )
            // InternalLearningCorpusDSL.g:473:2: rule__MistakeTypeCategory__Group_2__4__Impl rule__MistakeTypeCategory__Group_2__5
            {
            pushFollow(FOLLOW_11);
            rule__MistakeTypeCategory__Group_2__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MistakeTypeCategory__Group_2__5();

            state._fsp--;


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
    // $ANTLR end "rule__MistakeTypeCategory__Group_2__4"


    // $ANTLR start "rule__MistakeTypeCategory__Group_2__4__Impl"
    // InternalLearningCorpusDSL.g:480:1: rule__MistakeTypeCategory__Group_2__4__Impl : ( ( rule__MistakeTypeCategory__MistakeTypesAssignment_2_4 )* ) ;
    public final void rule__MistakeTypeCategory__Group_2__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:484:1: ( ( ( rule__MistakeTypeCategory__MistakeTypesAssignment_2_4 )* ) )
            // InternalLearningCorpusDSL.g:485:1: ( ( rule__MistakeTypeCategory__MistakeTypesAssignment_2_4 )* )
            {
            // InternalLearningCorpusDSL.g:485:1: ( ( rule__MistakeTypeCategory__MistakeTypesAssignment_2_4 )* )
            // InternalLearningCorpusDSL.g:486:2: ( rule__MistakeTypeCategory__MistakeTypesAssignment_2_4 )*
            {
             before(grammarAccess.getMistakeTypeCategoryAccess().getMistakeTypesAssignment_2_4()); 
            // InternalLearningCorpusDSL.g:487:2: ( rule__MistakeTypeCategory__MistakeTypesAssignment_2_4 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==15) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalLearningCorpusDSL.g:487:3: rule__MistakeTypeCategory__MistakeTypesAssignment_2_4
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__MistakeTypeCategory__MistakeTypesAssignment_2_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getMistakeTypeCategoryAccess().getMistakeTypesAssignment_2_4()); 

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
    // $ANTLR end "rule__MistakeTypeCategory__Group_2__4__Impl"


    // $ANTLR start "rule__MistakeTypeCategory__Group_2__5"
    // InternalLearningCorpusDSL.g:495:1: rule__MistakeTypeCategory__Group_2__5 : rule__MistakeTypeCategory__Group_2__5__Impl ;
    public final void rule__MistakeTypeCategory__Group_2__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:499:1: ( rule__MistakeTypeCategory__Group_2__5__Impl )
            // InternalLearningCorpusDSL.g:500:2: rule__MistakeTypeCategory__Group_2__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MistakeTypeCategory__Group_2__5__Impl();

            state._fsp--;


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
    // $ANTLR end "rule__MistakeTypeCategory__Group_2__5"


    // $ANTLR start "rule__MistakeTypeCategory__Group_2__5__Impl"
    // InternalLearningCorpusDSL.g:506:1: rule__MistakeTypeCategory__Group_2__5__Impl : ( '}' ) ;
    public final void rule__MistakeTypeCategory__Group_2__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:510:1: ( ( '}' ) )
            // InternalLearningCorpusDSL.g:511:1: ( '}' )
            {
            // InternalLearningCorpusDSL.g:511:1: ( '}' )
            // InternalLearningCorpusDSL.g:512:2: '}'
            {
             before(grammarAccess.getMistakeTypeCategoryAccess().getRightCurlyBracketKeyword_2_5()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getMistakeTypeCategoryAccess().getRightCurlyBracketKeyword_2_5()); 

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
    // $ANTLR end "rule__MistakeTypeCategory__Group_2__5__Impl"


    // $ANTLR start "rule__MistakeType__Group__0"
    // InternalLearningCorpusDSL.g:522:1: rule__MistakeType__Group__0 : rule__MistakeType__Group__0__Impl rule__MistakeType__Group__1 ;
    public final void rule__MistakeType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:526:1: ( rule__MistakeType__Group__0__Impl rule__MistakeType__Group__1 )
            // InternalLearningCorpusDSL.g:527:2: rule__MistakeType__Group__0__Impl rule__MistakeType__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__MistakeType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MistakeType__Group__1();

            state._fsp--;


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
    // $ANTLR end "rule__MistakeType__Group__0"


    // $ANTLR start "rule__MistakeType__Group__0__Impl"
    // InternalLearningCorpusDSL.g:534:1: rule__MistakeType__Group__0__Impl : ( 'Mistake' ) ;
    public final void rule__MistakeType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:538:1: ( ( 'Mistake' ) )
            // InternalLearningCorpusDSL.g:539:1: ( 'Mistake' )
            {
            // InternalLearningCorpusDSL.g:539:1: ( 'Mistake' )
            // InternalLearningCorpusDSL.g:540:2: 'Mistake'
            {
             before(grammarAccess.getMistakeTypeAccess().getMistakeKeyword_0()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getMistakeTypeAccess().getMistakeKeyword_0()); 

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
    // $ANTLR end "rule__MistakeType__Group__0__Impl"


    // $ANTLR start "rule__MistakeType__Group__1"
    // InternalLearningCorpusDSL.g:549:1: rule__MistakeType__Group__1 : rule__MistakeType__Group__1__Impl rule__MistakeType__Group__2 ;
    public final void rule__MistakeType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:553:1: ( rule__MistakeType__Group__1__Impl rule__MistakeType__Group__2 )
            // InternalLearningCorpusDSL.g:554:2: rule__MistakeType__Group__1__Impl rule__MistakeType__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__MistakeType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MistakeType__Group__2();

            state._fsp--;


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
    // $ANTLR end "rule__MistakeType__Group__1"


    // $ANTLR start "rule__MistakeType__Group__1__Impl"
    // InternalLearningCorpusDSL.g:561:1: rule__MistakeType__Group__1__Impl : ( ( rule__MistakeType__NameAssignment_1 ) ) ;
    public final void rule__MistakeType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:565:1: ( ( ( rule__MistakeType__NameAssignment_1 ) ) )
            // InternalLearningCorpusDSL.g:566:1: ( ( rule__MistakeType__NameAssignment_1 ) )
            {
            // InternalLearningCorpusDSL.g:566:1: ( ( rule__MistakeType__NameAssignment_1 ) )
            // InternalLearningCorpusDSL.g:567:2: ( rule__MistakeType__NameAssignment_1 )
            {
             before(grammarAccess.getMistakeTypeAccess().getNameAssignment_1()); 
            // InternalLearningCorpusDSL.g:568:2: ( rule__MistakeType__NameAssignment_1 )
            // InternalLearningCorpusDSL.g:568:3: rule__MistakeType__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__MistakeType__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMistakeTypeAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__MistakeType__Group__1__Impl"


    // $ANTLR start "rule__MistakeType__Group__2"
    // InternalLearningCorpusDSL.g:576:1: rule__MistakeType__Group__2 : rule__MistakeType__Group__2__Impl rule__MistakeType__Group__3 ;
    public final void rule__MistakeType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:580:1: ( rule__MistakeType__Group__2__Impl rule__MistakeType__Group__3 )
            // InternalLearningCorpusDSL.g:581:2: rule__MistakeType__Group__2__Impl rule__MistakeType__Group__3
            {
            pushFollow(FOLLOW_13);
            rule__MistakeType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MistakeType__Group__3();

            state._fsp--;


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
    // $ANTLR end "rule__MistakeType__Group__2"


    // $ANTLR start "rule__MistakeType__Group__2__Impl"
    // InternalLearningCorpusDSL.g:588:1: rule__MistakeType__Group__2__Impl : ( ( rule__MistakeType__AtomicAssignment_2 )? ) ;
    public final void rule__MistakeType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:592:1: ( ( ( rule__MistakeType__AtomicAssignment_2 )? ) )
            // InternalLearningCorpusDSL.g:593:1: ( ( rule__MistakeType__AtomicAssignment_2 )? )
            {
            // InternalLearningCorpusDSL.g:593:1: ( ( rule__MistakeType__AtomicAssignment_2 )? )
            // InternalLearningCorpusDSL.g:594:2: ( rule__MistakeType__AtomicAssignment_2 )?
            {
             before(grammarAccess.getMistakeTypeAccess().getAtomicAssignment_2()); 
            // InternalLearningCorpusDSL.g:595:2: ( rule__MistakeType__AtomicAssignment_2 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalLearningCorpusDSL.g:595:3: rule__MistakeType__AtomicAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__MistakeType__AtomicAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMistakeTypeAccess().getAtomicAssignment_2()); 

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
    // $ANTLR end "rule__MistakeType__Group__2__Impl"


    // $ANTLR start "rule__MistakeType__Group__3"
    // InternalLearningCorpusDSL.g:603:1: rule__MistakeType__Group__3 : rule__MistakeType__Group__3__Impl rule__MistakeType__Group__4 ;
    public final void rule__MistakeType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:607:1: ( rule__MistakeType__Group__3__Impl rule__MistakeType__Group__4 )
            // InternalLearningCorpusDSL.g:608:2: rule__MistakeType__Group__3__Impl rule__MistakeType__Group__4
            {
            pushFollow(FOLLOW_13);
            rule__MistakeType__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MistakeType__Group__4();

            state._fsp--;


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
    // $ANTLR end "rule__MistakeType__Group__3"


    // $ANTLR start "rule__MistakeType__Group__3__Impl"
    // InternalLearningCorpusDSL.g:615:1: rule__MistakeType__Group__3__Impl : ( ( rule__MistakeType__NumStepsBeforeNotificationAssignment_3 )? ) ;
    public final void rule__MistakeType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:619:1: ( ( ( rule__MistakeType__NumStepsBeforeNotificationAssignment_3 )? ) )
            // InternalLearningCorpusDSL.g:620:1: ( ( rule__MistakeType__NumStepsBeforeNotificationAssignment_3 )? )
            {
            // InternalLearningCorpusDSL.g:620:1: ( ( rule__MistakeType__NumStepsBeforeNotificationAssignment_3 )? )
            // InternalLearningCorpusDSL.g:621:2: ( rule__MistakeType__NumStepsBeforeNotificationAssignment_3 )?
            {
             before(grammarAccess.getMistakeTypeAccess().getNumStepsBeforeNotificationAssignment_3()); 
            // InternalLearningCorpusDSL.g:622:2: ( rule__MistakeType__NumStepsBeforeNotificationAssignment_3 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_INT) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalLearningCorpusDSL.g:622:3: rule__MistakeType__NumStepsBeforeNotificationAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__MistakeType__NumStepsBeforeNotificationAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMistakeTypeAccess().getNumStepsBeforeNotificationAssignment_3()); 

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
    // $ANTLR end "rule__MistakeType__Group__3__Impl"


    // $ANTLR start "rule__MistakeType__Group__4"
    // InternalLearningCorpusDSL.g:630:1: rule__MistakeType__Group__4 : rule__MistakeType__Group__4__Impl ;
    public final void rule__MistakeType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:634:1: ( rule__MistakeType__Group__4__Impl )
            // InternalLearningCorpusDSL.g:635:2: rule__MistakeType__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MistakeType__Group__4__Impl();

            state._fsp--;


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
    // $ANTLR end "rule__MistakeType__Group__4"


    // $ANTLR start "rule__MistakeType__Group__4__Impl"
    // InternalLearningCorpusDSL.g:641:1: rule__MistakeType__Group__4__Impl : ( ( rule__MistakeType__LearningItemAssignment_4 ) ) ;
    public final void rule__MistakeType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:645:1: ( ( ( rule__MistakeType__LearningItemAssignment_4 ) ) )
            // InternalLearningCorpusDSL.g:646:1: ( ( rule__MistakeType__LearningItemAssignment_4 ) )
            {
            // InternalLearningCorpusDSL.g:646:1: ( ( rule__MistakeType__LearningItemAssignment_4 ) )
            // InternalLearningCorpusDSL.g:647:2: ( rule__MistakeType__LearningItemAssignment_4 )
            {
             before(grammarAccess.getMistakeTypeAccess().getLearningItemAssignment_4()); 
            // InternalLearningCorpusDSL.g:648:2: ( rule__MistakeType__LearningItemAssignment_4 )
            // InternalLearningCorpusDSL.g:648:3: rule__MistakeType__LearningItemAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__MistakeType__LearningItemAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getMistakeTypeAccess().getLearningItemAssignment_4()); 

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
    // $ANTLR end "rule__MistakeType__Group__4__Impl"


    // $ANTLR start "rule__LearningItem__Group__0"
    // InternalLearningCorpusDSL.g:657:1: rule__LearningItem__Group__0 : rule__LearningItem__Group__0__Impl rule__LearningItem__Group__1 ;
    public final void rule__LearningItem__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:661:1: ( rule__LearningItem__Group__0__Impl rule__LearningItem__Group__1 )
            // InternalLearningCorpusDSL.g:662:2: rule__LearningItem__Group__0__Impl rule__LearningItem__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__LearningItem__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LearningItem__Group__1();

            state._fsp--;


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
    // $ANTLR end "rule__LearningItem__Group__0"


    // $ANTLR start "rule__LearningItem__Group__0__Impl"
    // InternalLearningCorpusDSL.g:669:1: rule__LearningItem__Group__0__Impl : ( 'LearningItem' ) ;
    public final void rule__LearningItem__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:673:1: ( ( 'LearningItem' ) )
            // InternalLearningCorpusDSL.g:674:1: ( 'LearningItem' )
            {
            // InternalLearningCorpusDSL.g:674:1: ( 'LearningItem' )
            // InternalLearningCorpusDSL.g:675:2: 'LearningItem'
            {
             before(grammarAccess.getLearningItemAccess().getLearningItemKeyword_0()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getLearningItemAccess().getLearningItemKeyword_0()); 

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
    // $ANTLR end "rule__LearningItem__Group__0__Impl"


    // $ANTLR start "rule__LearningItem__Group__1"
    // InternalLearningCorpusDSL.g:684:1: rule__LearningItem__Group__1 : rule__LearningItem__Group__1__Impl rule__LearningItem__Group__2 ;
    public final void rule__LearningItem__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:688:1: ( rule__LearningItem__Group__1__Impl rule__LearningItem__Group__2 )
            // InternalLearningCorpusDSL.g:689:2: rule__LearningItem__Group__1__Impl rule__LearningItem__Group__2
            {
            pushFollow(FOLLOW_14);
            rule__LearningItem__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LearningItem__Group__2();

            state._fsp--;


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
    // $ANTLR end "rule__LearningItem__Group__1"


    // $ANTLR start "rule__LearningItem__Group__1__Impl"
    // InternalLearningCorpusDSL.g:696:1: rule__LearningItem__Group__1__Impl : ( ( rule__LearningItem__NameAssignment_1 ) ) ;
    public final void rule__LearningItem__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:700:1: ( ( ( rule__LearningItem__NameAssignment_1 ) ) )
            // InternalLearningCorpusDSL.g:701:1: ( ( rule__LearningItem__NameAssignment_1 ) )
            {
            // InternalLearningCorpusDSL.g:701:1: ( ( rule__LearningItem__NameAssignment_1 ) )
            // InternalLearningCorpusDSL.g:702:2: ( rule__LearningItem__NameAssignment_1 )
            {
             before(grammarAccess.getLearningItemAccess().getNameAssignment_1()); 
            // InternalLearningCorpusDSL.g:703:2: ( rule__LearningItem__NameAssignment_1 )
            // InternalLearningCorpusDSL.g:703:3: rule__LearningItem__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__LearningItem__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getLearningItemAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__LearningItem__Group__1__Impl"


    // $ANTLR start "rule__LearningItem__Group__2"
    // InternalLearningCorpusDSL.g:711:1: rule__LearningItem__Group__2 : rule__LearningItem__Group__2__Impl ;
    public final void rule__LearningItem__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:715:1: ( rule__LearningItem__Group__2__Impl )
            // InternalLearningCorpusDSL.g:716:2: rule__LearningItem__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LearningItem__Group__2__Impl();

            state._fsp--;


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
    // $ANTLR end "rule__LearningItem__Group__2"


    // $ANTLR start "rule__LearningItem__Group__2__Impl"
    // InternalLearningCorpusDSL.g:722:1: rule__LearningItem__Group__2__Impl : ( ( rule__LearningItem__DescriptionAssignment_2 ) ) ;
    public final void rule__LearningItem__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:726:1: ( ( ( rule__LearningItem__DescriptionAssignment_2 ) ) )
            // InternalLearningCorpusDSL.g:727:1: ( ( rule__LearningItem__DescriptionAssignment_2 ) )
            {
            // InternalLearningCorpusDSL.g:727:1: ( ( rule__LearningItem__DescriptionAssignment_2 ) )
            // InternalLearningCorpusDSL.g:728:2: ( rule__LearningItem__DescriptionAssignment_2 )
            {
             before(grammarAccess.getLearningItemAccess().getDescriptionAssignment_2()); 
            // InternalLearningCorpusDSL.g:729:2: ( rule__LearningItem__DescriptionAssignment_2 )
            // InternalLearningCorpusDSL.g:729:3: rule__LearningItem__DescriptionAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__LearningItem__DescriptionAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getLearningItemAccess().getDescriptionAssignment_2()); 

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
    // $ANTLR end "rule__LearningItem__Group__2__Impl"


    // $ANTLR start "rule__LearningCorpus__MistakeTypeCategoriesAssignment_0"
    // InternalLearningCorpusDSL.g:738:1: rule__LearningCorpus__MistakeTypeCategoriesAssignment_0 : ( ruleMistakeTypeCategory ) ;
    public final void rule__LearningCorpus__MistakeTypeCategoriesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:742:1: ( ( ruleMistakeTypeCategory ) )
            // InternalLearningCorpusDSL.g:743:2: ( ruleMistakeTypeCategory )
            {
            // InternalLearningCorpusDSL.g:743:2: ( ruleMistakeTypeCategory )
            // InternalLearningCorpusDSL.g:744:3: ruleMistakeTypeCategory
            {
             before(grammarAccess.getLearningCorpusAccess().getMistakeTypeCategoriesMistakeTypeCategoryParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleMistakeTypeCategory();

            state._fsp--;

             after(grammarAccess.getLearningCorpusAccess().getMistakeTypeCategoriesMistakeTypeCategoryParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__LearningCorpus__MistakeTypeCategoriesAssignment_0"


    // $ANTLR start "rule__LearningCorpus__LearningItemsAssignment_1"
    // InternalLearningCorpusDSL.g:753:1: rule__LearningCorpus__LearningItemsAssignment_1 : ( ruleLearningItem ) ;
    public final void rule__LearningCorpus__LearningItemsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:757:1: ( ( ruleLearningItem ) )
            // InternalLearningCorpusDSL.g:758:2: ( ruleLearningItem )
            {
            // InternalLearningCorpusDSL.g:758:2: ( ruleLearningItem )
            // InternalLearningCorpusDSL.g:759:3: ruleLearningItem
            {
             before(grammarAccess.getLearningCorpusAccess().getLearningItemsLearningItemParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleLearningItem();

            state._fsp--;

             after(grammarAccess.getLearningCorpusAccess().getLearningItemsLearningItemParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__LearningCorpus__LearningItemsAssignment_1"


    // $ANTLR start "rule__MistakeTypeCategory__NameAssignment_1"
    // InternalLearningCorpusDSL.g:768:1: rule__MistakeTypeCategory__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__MistakeTypeCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:772:1: ( ( ruleEString ) )
            // InternalLearningCorpusDSL.g:773:2: ( ruleEString )
            {
            // InternalLearningCorpusDSL.g:773:2: ( ruleEString )
            // InternalLearningCorpusDSL.g:774:3: ruleEString
            {
             before(grammarAccess.getMistakeTypeCategoryAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getMistakeTypeCategoryAccess().getNameEStringParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__MistakeTypeCategory__NameAssignment_1"


    // $ANTLR start "rule__MistakeTypeCategory__MistakeTypesAssignment_2_4"
    // InternalLearningCorpusDSL.g:783:1: rule__MistakeTypeCategory__MistakeTypesAssignment_2_4 : ( ruleMistakeType ) ;
    public final void rule__MistakeTypeCategory__MistakeTypesAssignment_2_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:787:1: ( ( ruleMistakeType ) )
            // InternalLearningCorpusDSL.g:788:2: ( ruleMistakeType )
            {
            // InternalLearningCorpusDSL.g:788:2: ( ruleMistakeType )
            // InternalLearningCorpusDSL.g:789:3: ruleMistakeType
            {
             before(grammarAccess.getMistakeTypeCategoryAccess().getMistakeTypesMistakeTypeParserRuleCall_2_4_0()); 
            pushFollow(FOLLOW_2);
            ruleMistakeType();

            state._fsp--;

             after(grammarAccess.getMistakeTypeCategoryAccess().getMistakeTypesMistakeTypeParserRuleCall_2_4_0()); 

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
    // $ANTLR end "rule__MistakeTypeCategory__MistakeTypesAssignment_2_4"


    // $ANTLR start "rule__MistakeType__NameAssignment_1"
    // InternalLearningCorpusDSL.g:798:1: rule__MistakeType__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__MistakeType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:802:1: ( ( ruleEString ) )
            // InternalLearningCorpusDSL.g:803:2: ( ruleEString )
            {
            // InternalLearningCorpusDSL.g:803:2: ( ruleEString )
            // InternalLearningCorpusDSL.g:804:3: ruleEString
            {
             before(grammarAccess.getMistakeTypeAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getMistakeTypeAccess().getNameEStringParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__MistakeType__NameAssignment_1"


    // $ANTLR start "rule__MistakeType__AtomicAssignment_2"
    // InternalLearningCorpusDSL.g:813:1: rule__MistakeType__AtomicAssignment_2 : ( ( 'atomic' ) ) ;
    public final void rule__MistakeType__AtomicAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:817:1: ( ( ( 'atomic' ) ) )
            // InternalLearningCorpusDSL.g:818:2: ( ( 'atomic' ) )
            {
            // InternalLearningCorpusDSL.g:818:2: ( ( 'atomic' ) )
            // InternalLearningCorpusDSL.g:819:3: ( 'atomic' )
            {
             before(grammarAccess.getMistakeTypeAccess().getAtomicAtomicKeyword_2_0()); 
            // InternalLearningCorpusDSL.g:820:3: ( 'atomic' )
            // InternalLearningCorpusDSL.g:821:4: 'atomic'
            {
             before(grammarAccess.getMistakeTypeAccess().getAtomicAtomicKeyword_2_0()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getMistakeTypeAccess().getAtomicAtomicKeyword_2_0()); 

            }

             after(grammarAccess.getMistakeTypeAccess().getAtomicAtomicKeyword_2_0()); 

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
    // $ANTLR end "rule__MistakeType__AtomicAssignment_2"


    // $ANTLR start "rule__MistakeType__NumStepsBeforeNotificationAssignment_3"
    // InternalLearningCorpusDSL.g:832:1: rule__MistakeType__NumStepsBeforeNotificationAssignment_3 : ( RULE_INT ) ;
    public final void rule__MistakeType__NumStepsBeforeNotificationAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:836:1: ( ( RULE_INT ) )
            // InternalLearningCorpusDSL.g:837:2: ( RULE_INT )
            {
            // InternalLearningCorpusDSL.g:837:2: ( RULE_INT )
            // InternalLearningCorpusDSL.g:838:3: RULE_INT
            {
             before(grammarAccess.getMistakeTypeAccess().getNumStepsBeforeNotificationINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getMistakeTypeAccess().getNumStepsBeforeNotificationINTTerminalRuleCall_3_0()); 

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
    // $ANTLR end "rule__MistakeType__NumStepsBeforeNotificationAssignment_3"


    // $ANTLR start "rule__MistakeType__LearningItemAssignment_4"
    // InternalLearningCorpusDSL.g:847:1: rule__MistakeType__LearningItemAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__MistakeType__LearningItemAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:851:1: ( ( ( RULE_ID ) ) )
            // InternalLearningCorpusDSL.g:852:2: ( ( RULE_ID ) )
            {
            // InternalLearningCorpusDSL.g:852:2: ( ( RULE_ID ) )
            // InternalLearningCorpusDSL.g:853:3: ( RULE_ID )
            {
             before(grammarAccess.getMistakeTypeAccess().getLearningItemLearningItemCrossReference_4_0()); 
            // InternalLearningCorpusDSL.g:854:3: ( RULE_ID )
            // InternalLearningCorpusDSL.g:855:4: RULE_ID
            {
             before(grammarAccess.getMistakeTypeAccess().getLearningItemLearningItemIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getMistakeTypeAccess().getLearningItemLearningItemIDTerminalRuleCall_4_0_1()); 

            }

             after(grammarAccess.getMistakeTypeAccess().getLearningItemLearningItemCrossReference_4_0()); 

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
    // $ANTLR end "rule__MistakeType__LearningItemAssignment_4"


    // $ANTLR start "rule__LearningItem__NameAssignment_1"
    // InternalLearningCorpusDSL.g:866:1: rule__LearningItem__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__LearningItem__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:870:1: ( ( ruleEString ) )
            // InternalLearningCorpusDSL.g:871:2: ( ruleEString )
            {
            // InternalLearningCorpusDSL.g:871:2: ( ruleEString )
            // InternalLearningCorpusDSL.g:872:3: ruleEString
            {
             before(grammarAccess.getLearningItemAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getLearningItemAccess().getNameEStringParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__LearningItem__NameAssignment_1"


    // $ANTLR start "rule__LearningItem__DescriptionAssignment_2"
    // InternalLearningCorpusDSL.g:881:1: rule__LearningItem__DescriptionAssignment_2 : ( RULE_STRING ) ;
    public final void rule__LearningItem__DescriptionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLearningCorpusDSL.g:885:1: ( ( RULE_STRING ) )
            // InternalLearningCorpusDSL.g:886:2: ( RULE_STRING )
            {
            // InternalLearningCorpusDSL.g:886:2: ( RULE_STRING )
            // InternalLearningCorpusDSL.g:887:3: RULE_STRING
            {
             before(grammarAccess.getLearningItemAccess().getDescriptionSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getLearningItemAccess().getDescriptionSTRINGTerminalRuleCall_2_0()); 

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
    // $ANTLR end "rule__LearningItem__DescriptionAssignment_2"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000002040L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00000000000200A0L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000010L});

}
/* The following code was generated by JFlex 1.4.3 on 10.09.15 19:50 */

/*
    Copyright 2015 Alexandr Evstigneev

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/
package com.perl5.lang.perl.lexer;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;



/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 10.09.15 19:50 from the specification file
 * <tt>C:/Repository/Perl5-IDEA/src/com/perl5/lang/perl/lexer/Perl.flex</tt>
 */
public abstract class PerlLexerGenerated extends PerlBaseLexer
{
  /**
   * lexical states
   */
  public static final int LEX_MOJO_PERL_BLOCK = 36;
  public static final int LEX_TRANS_MODIFIERS = 28;
  public static final int LEX_QUOTE_LIKE_LIST_OPENER = 18;
  public static final int LEX_CODE = 2;
  public static final int LEX_TRANS_OPENER = 22;
  public static final int LEX_HEREDOC_WAITING_QX = 8;
  public static final int LEX_MOJO_PERL_LINE_SEMI = 38;
  public static final int LEX_QUOTE_LIKE_WORDS = 20;
  public static final int LEX_TRANS_CLOSER = 26;
  public static final int LEX_HEREDOC_WAITING_QQ = 6;
  public static final int LEX_FORMAT_WAITING = 10;
  public static final int LEX_TRANS_CHARS = 24;
  public static final int LEX_REGEX_OPENER = 30;
  public static final int LEX_MOJO_PERL_LINE = 34;
  public static final int LEX_QUOTE_LIKE_OPENER = 12;
  public static final int LEX_QUOTE_LIKE_OPENER_QX = 16;
  public static final int LEX_HEREDOC_WAITING = 4;
  public static final int LEX_QUOTE_LIKE_OPENER_QQ = 14;
  public static final int LEX_PREPARSED_ITEMS = 42;
  public static final int LEX_MOJO_PERL_BLOCK_SEMI = 40;
  public static final int LEX_HTML_BLOCK = 32;
  public static final int YYINITIAL = 0;
  /**
   * initial size of the lookahead buffer
   */
  private static final int ZZ_BUFFERSIZE = 16384;
  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   * at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1,
          1, 1, 2, 2, 1, 1, 3, 3, 4, 4, 1, 1, 5, 5, 6, 6,
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
  };

  /**
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED =
          "\11\0\1\3\1\2\1\0\1\3\1\1\22\0\1\3\1\41\1\11" +
                  "\1\53\1\52\1\50\1\42\1\10\1\60\1\61\1\47\1\20\1\37" +
                  "\1\5\1\16\1\46\1\21\1\25\10\13\1\7\1\34\1\31\1\35" +
                  "\1\36\1\44\1\51\3\30\1\23\1\17\1\23\6\4\1\26\1\4" +
                  "\1\26\2\4\3\26\2\4\2\26\2\4\1\56\1\45\1\57\1\6" +
                  "\1\14\1\12\1\23\1\24\2\33\1\27\1\30\1\26\3\4\2\26" +
                  "\2\4\2\26\1\4\2\32\2\26\1\15\1\26\1\22\1\4\1\26" +
                  "\1\54\1\43\1\55\1\40\uff81\0";

  /**
   * Translates characters to character classes
   */
  private static final char[] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);
  private static final String ZZ_ACTION_PACKED_0 =
          "\7\0\2\1\1\2\1\3\1\4\1\5\1\6\1\7" +
                  "\1\10\1\11\1\4\1\12\1\13\1\11\1\4\1\14" +
                  "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24" +
                  "\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34" +
                  "\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44" +
                  "\2\45\2\46\1\47\1\50\2\0\1\4\1\51\1\4" +
                  "\1\52\1\53\1\54\2\55\1\4\1\56\1\55\1\57" +
                  "\1\0\1\60\3\4\1\61\1\0\1\62\1\63\1\64" +
                  "\1\65\1\66\1\67\1\70\1\71\1\72\1\0\1\73" +
                  "\2\0\1\54\1\55\1\0\1\55\1\0\1\74\3\55" +
                  "\5\75\1\0\1\76\3\0\1\77\1\56\3\0\1\76";
  /**
   * Translates DFA states to action switch labels.
   */
  private static final int[] ZZ_ACTION = zzUnpackAction();
  private static final String ZZ_ROWMAP_PACKED_0 =
          "\0\0\0\62\0\144\0\226\0\310\0\372\0\u012c\0\62" +
                  "\0\u015e\0\62\0\u0190\0\u01c2\0\u01f4\0\u0226\0\u0258\0\62" +
                  "\0\u028a\0\u02bc\0\u02ee\0\u0320\0\u0352\0\u0384\0\u03b6\0\62" +
                  "\0\u03e8\0\u041a\0\62\0\62\0\u044c\0\u047e\0\u04b0\0\62" +
                  "\0\62\0\62\0\62\0\62\0\62\0\u04e2\0\62\0\62" +
                  "\0\62\0\62\0\62\0\62\0\62\0\u0514\0\62\0\62" +
                  "\0\u0546\0\62\0\u0578\0\62\0\62\0\u05aa\0\u05dc\0\u060e" +
                  "\0\u0640\0\u0672\0\62\0\u0226\0\u06a4\0\u06d6\0\u0708\0\u073a" +
                  "\0\u076c\0\u079e\0\u07d0\0\u0802\0\62\0\u0834\0\u0866\0\u0898" +
                  "\0\u08ca\0\u08fc\0\62\0\62\0\62\0\62\0\62\0\62" +
                  "\0\62\0\u092e\0\u092e\0\u0640\0\62\0\u0960\0\u0258\0\u0992" +
                  "\0\u09c4\0\u09f6\0\u0a28\0\u0a5a\0\62\0\u09f6\0\u0834\0\u0866" +
                  "\0\62\0\u05aa\0\u05dc\0\u0898\0\u01c2\0\u0a8c\0\u0abe\0\u0af0" +
                  "\0\u0b22\0\u0b54\0\62\0\u0b86\0\u0bb8\0\u0bea\0\u0c1c\0\62";
  /**
   * Translates a state to a row index in the transition table
   */
  private static final int[] ZZ_ROWMAP = zzUnpackRowMap();
  private static final String ZZ_TRANS_PACKED_0 =
          "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17" +
                  "\3\20\1\21\1\14\1\22\1\23\1\14\1\24\1\25" +
                  "\1\26\2\14\1\21\3\14\1\27\2\14\1\30\1\31" +
                  "\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41" +
                  "\1\42\1\43\1\44\1\45\1\46\1\10\1\47\1\50" +
                  "\1\51\1\52\1\53\1\54\62\0\1\55\3\56\56\55" +
                  "\1\57\3\56\56\57\1\60\1\61\60\60\1\62\1\63" +
                  "\30\62\2\64\26\62\1\65\3\56\56\65\2\0\1\12" +
                  "\62\0\1\13\62\0\1\14\2\0\1\66\1\67\2\0" +
                  "\3\14\1\0\1\14\1\0\10\14\1\0\2\14\32\0" +
                  "\1\70\1\71\5\0\3\70\1\0\1\70\1\0\1\70" +
                  "\1\72\1\70\1\72\1\70\3\72\1\0\2\72\2\0" +
                  "\1\73\27\0\1\74\6\0\3\74\1\0\1\74\1\0" +
                  "\10\74\1\0\2\74\35\0\1\75\56\0\1\14\2\0" +
                  "\1\66\1\67\2\0\1\21\1\76\1\14\1\77\1\100" +
                  "\1\0\1\21\3\14\1\21\1\14\1\100\1\14\1\0" +
                  "\2\14\32\0\1\14\2\0\1\66\1\67\2\0\1\101" +
                  "\2\14\1\0\1\14\1\0\1\101\3\14\1\101\3\14" +
                  "\1\0\2\14\41\0\1\102\2\0\1\103\1\104\1\0" +
                  "\1\102\3\0\1\102\1\0\1\104\52\0\1\105\45\0" +
                  "\1\14\2\0\1\66\1\67\2\0\1\21\1\76\1\14" +
                  "\1\77\1\100\1\0\1\21\1\106\1\14\1\107\1\21" +
                  "\1\14\1\100\1\14\1\0\2\14\32\0\1\14\2\0" +
                  "\1\66\1\67\2\0\1\110\2\14\1\0\1\14\1\0" +
                  "\1\110\3\14\1\110\3\14\1\0\2\14\57\0\1\111" +
                  "\3\0\1\112\62\0\1\113\1\0\1\114\57\0\1\115" +
                  "\63\0\1\116\63\0\1\117\62\0\1\120\71\0\1\121" +
                  "\7\0\3\56\60\0\1\60\61\0\1\62\66\0\1\122" +
                  "\56\0\1\123\6\0\3\123\1\0\1\123\1\0\10\123" +
                  "\1\0\2\123\32\0\1\70\6\0\3\70\1\0\1\70" +
                  "\1\0\10\70\1\0\2\70\32\0\1\70\1\124\5\0" +
                  "\3\70\1\0\1\70\1\0\10\70\1\0\2\70\26\0" +
                  "\4\125\1\70\6\125\3\70\1\125\1\70\1\125\10\70" +
                  "\1\125\2\70\26\125\4\0\1\126\2\0\1\127\1\130" +
                  "\2\0\3\126\1\0\1\126\1\0\10\126\1\0\2\126" +
                  "\32\0\1\14\2\0\1\66\1\67\2\0\2\76\1\14" +
                  "\1\77\1\100\1\0\1\76\3\14\1\76\1\14\1\100" +
                  "\1\14\1\0\2\14\41\0\1\131\3\0\1\104\1\0" +
                  "\1\131\3\0\1\131\1\0\1\104\36\0\1\14\1\132" +
                  "\1\0\1\66\1\67\2\0\2\133\1\14\1\0\1\14" +
                  "\1\132\1\133\3\14\1\133\3\14\1\0\2\14\32\0" +
                  "\1\14\2\0\1\66\1\67\2\0\2\101\1\14\1\134" +
                  "\1\14\1\0\1\101\3\14\1\101\3\14\1\0\2\14" +
                  "\41\0\2\102\2\0\1\104\1\0\1\102\3\0\1\102" +
                  "\1\0\1\104\50\0\1\135\50\0\1\132\5\0\2\136" +
                  "\3\0\1\132\1\136\3\0\1\136\40\0\1\14\2\0" +
                  "\1\66\1\67\2\0\2\137\1\14\1\0\1\137\1\0" +
                  "\1\137\1\14\3\137\1\14\2\137\1\0\1\14\1\137" +
                  "\32\0\1\14\2\0\1\66\1\67\2\0\1\14\1\140" +
                  "\1\14\1\0\1\14\1\0\1\140\3\14\1\140\3\14" +
                  "\1\0\2\14\26\0\4\141\1\14\2\141\1\142\1\143" +
                  "\2\141\1\144\1\145\1\14\1\141\1\14\1\141\1\144" +
                  "\3\14\1\144\3\14\1\141\2\14\26\141\3\0\1\146" +
                  "\1\147\3\0\1\150\1\151\1\152\3\147\1\0\1\147" +
                  "\1\0\10\147\1\0\2\147\64\0\1\153\27\0\1\123" +
                  "\2\0\1\66\1\67\2\0\3\123\1\0\1\123\1\0" +
                  "\10\123\1\0\2\123\32\0\1\126\2\0\1\66\1\67" +
                  "\2\0\3\126\1\0\1\126\1\0\10\126\1\0\2\126" +
                  "\32\0\1\126\6\0\3\126\1\0\1\126\1\0\10\126" +
                  "\1\0\2\126\41\0\2\131\1\0\1\134\1\104\1\0" +
                  "\1\131\3\0\1\131\1\0\1\104\45\0\2\136\4\0" +
                  "\1\136\3\0\1\136\40\0\1\14\2\0\1\66\1\67" +
                  "\2\0\2\133\1\14\1\0\1\14\1\0\1\133\3\14" +
                  "\1\133\3\14\1\0\2\14\41\0\1\154\5\0\1\154" +
                  "\3\0\1\154\37\0\1\146\4\0\1\150\1\151\1\152" +
                  "\53\0\1\147\6\0\3\147\1\0\1\147\1\0\10\147" +
                  "\1\0\2\147\26\0\1\155\2\0\5\155\1\0\51\155" +
                  "\1\156\2\0\6\156\1\0\50\156\1\157\2\0\7\157" +
                  "\1\0\47\157\13\0\2\154\1\0\1\134\2\0\1\154" +
                  "\3\0\1\154\34\0\1\155\2\0\5\155\1\160\51\155" +
                  "\1\156\2\0\6\156\1\160\50\156\1\157\2\0\7\157" +
                  "\1\160\47\157";
  /**
   * The transition table of the DFA
   */
  private static final int[] ZZ_TRANS = zzUnpackTrans();
  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;
  private static final char[] EMPTY_BUFFER = new char[0];
  private static final int YYEOF = -1;
  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
          "Unkown internal scanner error",
          "Error: could not match input",
          "Error: pushback value was too large"
  };
  private static final String ZZ_ATTRIBUTE_PACKED_0 =
          "\1\0\1\10\5\0\1\11\1\1\1\11\5\1\1\11" +
                  "\7\1\1\11\2\1\2\11\3\1\6\11\1\1\7\11" +
                  "\1\1\2\11\1\1\1\11\1\1\2\11\2\0\3\1" +
                  "\1\11\10\1\1\0\1\11\4\1\1\0\7\11\2\1" +
                  "\1\0\1\11\2\0\2\1\1\0\1\1\1\0\1\11" +
                  "\3\1\1\11\4\1\1\0\1\1\3\0\1\11\1\1" +
                  "\3\0\1\11";
  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int[] ZZ_ATTRIBUTE = zzUnpackAttribute();
  private static java.io.Reader zzReader = null; // Fake
  protected int trenarCounter = 0;
  /**
   * the current state of the DFA
   */
  private int zzState;
  /**
   * the current lexical state
   */
  private int zzLexicalState = YYINITIAL;
  /**
   * this buffer contains the current text to be matched and is
   * the source of the yytext() string
   */
  private CharSequence zzBuffer = "";
  /**
   * this buffer may contains the current text array to be matched when it is cheap to acquire it
   */
  private char[] zzBufferArray;
  /**
   * the textposition at the last accepting state
   */
  private int zzMarkedPos;
  /**
   * the textposition at the last state to be included in yytext
   */
  private int zzPushbackPos;
  /**
   * the current text position in the buffer
   */
  private int zzCurrentPos;
  /**
   * startRead marks the beginning of the yytext() string in the buffer
   */
  private int zzStartRead;
  /**
   * endRead marks the last character in the buffer, that has been read
   * from input
   */
  private int zzEndRead;
  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;
  /**
   * zzAtEOF == true <=> the scanner is at the EOF
   */
  private boolean zzAtEOF;

  public PerlLexerGenerated(java.io.Reader in)
  {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public PerlLexerGenerated(java.io.InputStream in)
  {
    this(new java.io.InputStreamReader(in));
  }

  private static int[] zzUnpackAction()
  {
    int[] result = new int[112];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int[] result)
  {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l)
    {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  private static int[] zzUnpackRowMap()
  {
    int[] result = new int[112];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int[] result)
  {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l)
    {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  private static int[] zzUnpackTrans()
  {
    int[] result = new int[3150];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int[] result)
  {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l)
    {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  private static int[] zzUnpackAttribute()
  {
    int[] result = new int[112];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int[] result)
  {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l)
    {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Unpacks the compressed character translation table.
   *
   * @param packed the packed character translation table
   * @return the unpacked character translation table
   */
  private static char[] zzUnpackCMap(String packed)
  {
    char[] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 150)
    {
      int count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public CharSequence getBuffer()
  {
    return zzBuffer;
  }

  public char[] getBufferArray()
  {
    return zzBufferArray;
  }

  public int getBufferEnd() {return zzEndRead;}

    public int getNextTokenStart(){ return zzMarkedPos;}

    public boolean isLastToken(){ return zzMarkedPos == zzEndRead; }

	public abstract IElementType processStringOpener();

	public abstract IElementType guessDiv();

	public abstract IElementType getIdentifierToken();

	public abstract IElementType checkOperatorXSticked();

	public abstract IElementType parseVersion();

	public abstract IElementType parseNumber();

	public abstract IElementType parseOperatorDereference();

	public abstract IElementType parseCappedVariableName();

	public abstract IElementType parseRegex();

	public abstract IElementType processSemicolon();

	public abstract IElementType parseHeredocOpener();

	public abstract IElementType processOpenerWhiteSpace();

	public abstract IElementType processTransQuote();

	public abstract IElementType processTransChar();

	public abstract IElementType processTransCloser();

  public abstract IElementType processQuoteLikeListQuote();

  public abstract IElementType processQuoteLikeQuote();

  public final int getTokenStart()
  {
    return zzStartRead;
  }

  /* user code: */
  // fixme this must be in skeleton
  public void setTokenStart(int position)
  {
    zzCurrentPos = zzStartRead = position;
  }

  public final int getTokenEnd()
  {
    return getTokenStart() + yylength();
  }

  public void setTokenEnd(int position)
  {
    zzMarkedPos = position;
  }

  public void reset(CharSequence buffer, int start, int end, int initialState)
  {
    zzBuffer = buffer;
    zzBufferArray = com.intellij.util.text.CharArrayUtil.fromSequenceWithoutCopying(buffer);
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzPushbackPos = 0;
    zzAtEOF = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException
  {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public int yystate()
  {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState)
  {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext()
  {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos)
  {
    return zzBufferArray != null ? zzBufferArray[zzStartRead + pos] : zzBuffer.charAt(zzStartRead + pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength()
  {
    return zzMarkedPos - zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   * <p/>
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   * <p/>
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param errorCode the code of the errormessage to display
   */
  private void zzScanError(int errorCode)
  {
    String message;
    try
    {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e)
    {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)
  {
    if (number > yylength())
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return the next token
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  public IElementType perlAdvance() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;
    char[] zzBufferArrayL = zzBufferArray;
    char[] zzCMapL = ZZ_CMAP;

    int[] zzTransL = ZZ_TRANS;
    int[] zzRowMapL = ZZ_ROWMAP;
    int[] zzAttrL = ZZ_ATTRIBUTE;

    while (true)
    {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction:
      {
        while (true)
        {

          if (zzCurrentPosL < zzEndReadL)
            zzInput = (zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++] : zzBufferL.charAt(zzCurrentPosL++));
          else if (zzAtEOF)
          {
            zzInput = YYEOF;
            break zzForAction;
          } else
          {
            // store back cached positions
            zzCurrentPos = zzCurrentPosL;
            zzMarkedPos = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL = zzCurrentPos;
            zzMarkedPosL = zzMarkedPos;
            zzBufferL = zzBuffer;
            zzEndReadL = zzEndRead;
            if (eof)
            {
              zzInput = YYEOF;
              break zzForAction;
            } else
            {
              zzInput = (zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++] : zzBufferL.charAt(zzCurrentPosL++));
            }
          }
          int zzNext = zzTransL[zzRowMapL[zzState] + zzCMapL[zzInput]];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ((zzAttributes & 1) == 1)
          {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ((zzAttributes & 8) == 8) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction])
      {
        case 9:
        {
          return NUMBER_SIMPLE;
        }
        case 64:
          break;
        case 42:
        {
          return parseOperatorDereference();
        }
        case 65:
          break;
        case 8:
        {
          return processStringOpener();
        }
        case 66:
          break;
        case 51:
        {
          return OPERATOR_RE;
        }
        case 67:
          break;
        case 30:
        {
          return LEFT_BRACKET;
        }
        case 68:
          break;
        case 54:
        {
          return OPERATOR_AND;
        }
        case 69:
          break;
        case 18:
        {
          return OPERATOR_NOT;
        }
        case 70:
          break;
        case 40:
        {
          return parseRegex();
        }
        case 71:
          break;
        case 10:
        {
          return OPERATOR_CONCAT;
        }
        case 72:
          break;
        case 43:
        {
          return parseCappedVariableName();
        }
        case 73:
          break;
        case 35:
        {
          return processOpenerWhiteSpace();
        }
        case 74:
          break;
        case 55:
        {
          return OPERATOR_OR;
        }
        case 75:
          break;
        case 37:
        {
          IElementType tokenType = processTransChar();
          if (tokenType != null)
            return tokenType;
          break;
        }
        case 76:
          break;
        case 16:
        {
          return OPERATOR_COMMA;
        }
        case 77:
          break;
        case 59:
        {
          yypushback(1);
          return OPERATOR_FILETEST;
        }
        case 78:
          break;
        case 49:
        {
          return OPERATOR_SHIFT_LEFT;
        }
        case 79:
          break;
        case 34:
        {
          IElementType type = processQuoteLikeListQuote();
          if (type == null) // disallowed sharp
            break;
          return type;
        }
        case 80:
          break;
        case 3:
        {
          return TokenType.WHITE_SPACE;
        }
        case 81:
          break;
        case 36:
        {
          IElementType type = processTransQuote();
          if (type == null) // disallowed sharp
            break;
          return type;
        }
        case 82:
          break;
        case 52:
        {
          return OPERATOR_SHIFT_RIGHT;
        }
        case 83:
          break;
        case 6:
        {
          return OPERATOR_BITWISE_XOR;
        }
        case 84:
          break;
        case 44:
        {
          return PACKAGE_IDENTIFIER;
        }
        case 85:
          break;
        case 56:
        {
          return SIGIL_SCALAR_INDEX;
        }
        case 86:
          break;
        case 32:
        {
          return LEFT_PAREN;
        }
        case 87:
          break;
        case 22:
        {
          return OPERATOR_REFERENCE;
        }
        case 88:
          break;
        case 48:
        {
          return OPERATOR_PLUS_PLUS;
        }
        case 89:
          break;
        case 2:
        {
          return TokenType.NEW_LINE_INDENT;
        }
        case 90:
          break;
        case 13:
        {
          return processSemicolon();
        }
        case 91:
          break;
        case 7:
        {
          return COLON;
        }
        case 92:
          break;
        case 50:
        {
          return OPERATOR_COMMA_ARROW;
        }
        case 93:
          break;
        case 26:
        {
          return SIGIL_ARRAY;
        }
        case 94:
          break;
        case 19:
        {
          return OPERATOR_BITWISE_AND;
        }
        case 95:
          break;
        case 17:
        {
          return OPERATOR_BITWISE_NOT;
        }
        case 96:
          break;
        case 14:
        {
          return OPERATOR_ASSIGN;
        }
        case 97:
          break;
        case 5:
        {
          return OPERATOR_MINUS;
        }
        case 98:
          break;
        case 61:
        {
          return checkOperatorXSticked();
        }
        case 99:
          break;
        case 60:
        {
          return OPERATOR_HELLIP;
        }
        case 100:
          break;
        case 24:
        {
          return OPERATOR_MUL;
        }
        case 101:
          break;
        case 27:
        {
          return SIGIL_SCALAR;
        }
        case 102:
          break;
        case 62:
        {
          return parseHeredocOpener();
        }
        case 103:
          break;
        case 28:
        {
          return LEFT_BRACE;
        }
        case 104:
          break;
        case 15:
        {
          return OPERATOR_GT_NUMERIC;
        }
        case 105:
          break;
        case 46:
        {
          return parseVersion();
        }
        case 106:
          break;
        case 1:
        {
          return TokenType.BAD_CHARACTER;
        }
        case 107:
          break;
        case 33:
        {
          return RIGHT_PAREN;
        }
        case 108:
          break;
        case 47:
        {
          return OPERATOR_FLIP_FLOP;
        }
        case 109:
          break;
        case 31:
        {
          return RIGHT_BRACKET;
        }
        case 110:
          break;
        case 12:
        {
          return OPERATOR_LT_NUMERIC;
        }
        case 111:
          break;
        case 39:
        {
          return REGEX_MODIFIER;
        }
        case 112:
          break;
        case 58:
        {
          return parsePackage();
        }
        case 113:
          break;
        case 63:
        {
          return OPERATOR_CMP_NUMERIC;
        }
        case 114:
          break;
        case 25:
        {
          return OPERATOR_MOD;
        }
        case 115:
          break;
        case 45:
        {
          return parseNumber();
        }
        case 116:
          break;
        case 57:
        {
          return parsePackageCanonical();
        }
        case 117:
          break;
        case 53:
        {
          return OPERATOR_NOT_RE;
        }
        case 118:
          break;
        case 41:
        {
          return OPERATOR_MINUS_MINUS;
        }
        case 119:
          break;
        case 21:
        {
          return QUESTION;
        }
        case 120:
          break;
        case 11:
        {
          return OPERATOR_PLUS;
        }
        case 121:
          break;
        case 4:
        {
          return parseBarewordMinus();
        }
        case 122:
          break;
        case 29:
        {
          return RIGHT_BRACE;
        }
        case 123:
          break;
        case 23:
        { // regexp or div
          IElementType tokenType = guessDiv();
          if (tokenType == null)
            break;
          return tokenType;
        }
        case 124:
          break;
        case 38:
        {
          popState();
          yypushback(1);
          break;
        }
        case 125:
          break;
        case 20:
        {
          return OPERATOR_BITWISE_OR;
        }
        case 126:
          break;
        default:
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos)
          {
            zzAtEOF = true;
            return null;
          } else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}

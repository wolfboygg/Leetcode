public class ViewClassCode extends Object {
    public static void main(String[] args) {
        add(1);
        test01();
        test02();
    }

    public static int add(int k) {
        int i = 10;
        int j = 9;
        return i + j + k;
    }

    public static void test01() {
        if ("hahah".equals("hahah") && isOk()) {
            return;
        }
        if ("hahah".equals("hahah") && isError()) {
            return;
        }
    }


    public static void test02() {
        if ("hahah".equals("hahah") && (isOk() || isError())) {
            return;
        }
    }

    public static boolean isOk() {
        return true;
    }

    public static boolean isError() {
        return false;
    }

}



/**
 * Classfile /Users/guolei/Documents/studyspace/Leetcode/viewclass/target/classes/ViewClassCode.class
 * Last modified 2021-3-19; size 526 bytes
 * MD5 checksum aa23d25e91416ffeb5584ef2fcee2896
 * Compiled from "ViewClassCode.java"
 * public class ViewClassCode
 * minor version: 0
 * major version: 49
 * flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:
 * #1 = Methodref          #4.#24         // java/lang/Object."<init>":()V
 * #2 = Methodref          #3.#25         // ViewClassCode.add:(I)I
 * #3 = Class              #26            // ViewClassCode
 * #4 = Class              #27            // java/lang/Object
 * #5 = Utf8               <init>
 * #6 = Utf8               ()V
 * #7 = Utf8               Code
 * #8 = Utf8               LineNumberTable
 * #9 = Utf8               LocalVariableTable
 * #10 = Utf8               this
 * #11 = Utf8               LViewClassCode;
 * #12 = Utf8               main
 * #13 = Utf8               ([Ljava/lang/String;)V
 * #14 = Utf8               args
 * #15 = Utf8               [Ljava/lang/String;
 * #16 = Utf8               add
 * #17 = Utf8               (I)I
 * #18 = Utf8               k
 * #19 = Utf8               I
 * #20 = Utf8               i
 * #21 = Utf8               j
 * #22 = Utf8               SourceFile
 * #23 = Utf8               ViewClassCode.java
 * #24 = NameAndType        #5:#6          // "<init>":()V
 * #25 = NameAndType        #16:#17        // add:(I)I
 * #26 = Utf8               ViewClassCode
 * #27 = Utf8               java/lang/Object
 * {
 * public ViewClassCode();
 * descriptor: ()V
 * flags: ACC_PUBLIC
 * Code:
 * stack=1, locals=1, args_size=1
 * 0: aload_0
 * 1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 * 4: return
 * LineNumberTable:
 * line 1: 0
 * LocalVariableTable:
 * Start  Length  Slot  Name   Signature
 * 0       5     0  this   LViewClassCode;
 * <p>
 * public static void main(java.lang.String[]);
 * descriptor: ([Ljava/lang/String;)V
 * flags: ACC_PUBLIC, ACC_STATIC
 * Code:
 * stack=1, locals=1, args_size=1
 * 0: iconst_1
 * 1: invokestatic  #2                  // Method add:(I)I
 * 4: pop
 * 5: return
 * LineNumberTable:
 * line 3: 0
 * line 4: 5
 * LocalVariableTable:
 * Start  Length  Slot  Name   Signature
 * 0       6     0  args   [Ljava/lang/String;
 * <p>
 * public static int add(int);
 * descriptor: (I)I
 * flags: ACC_PUBLIC, ACC_STATIC
 * Code:
 * stack=2, locals=3, args_size=1
 * 0: bipush        10
 * 2: istore_1
 * 3: bipush        9
 * 5: istore_2
 * 6: iload_1
 * 7: iload_2
 * 8: iadd
 * 9: iload_0
 * 10: iadd
 * 11: ireturn
 * LineNumberTable:
 * line 7: 0
 * line 8: 3
 * line 9: 6
 * LocalVariableTable:
 * Start  Length  Slot  Name   Signature
 * 0      12     0     k   I
 * 3       9     1     i   I
 * 6       6     2     j   I
 * }
 * SourceFile: "ViewClassCode.java"
 * <p>
 * Compiled from "ViewClassCode.java"
 * public class ViewClassCode {
 * public ViewClassCode();
 * Code:
 * 0: aload_0
 * 1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 * 4: return
 * <p>
 * public static void main(java.lang.String[]);
 * Code:
 * 0: iconst_1
 * 1: invokestatic  #2                  // Method add:(I)I
 * 4: pop
 * 5: return
 * <p>
 * public static int add(int);
 * Code:
 * 0: bipush        10
 * 2: istore_1
 * 3: bipush        9
 * 5: istore_2
 * 6: iload_1
 * 7: iload_2
 * 8: iadd
 * 9: iload_0
 * 10: iadd
 * 11: ireturn
 * }
 */


/**
 * Compiled from "ViewClassCode.java"
 * public class ViewClassCode {
 *   public ViewClassCode();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: return
 *
 *   public static void main(java.lang.String[]);
 *     Code:
 *        0: iconst_1
 *        1: invokestatic  #2                  // Method add:(I)I
 *        4: pop
 *        5: return
 *
 *   public static int add(int);
 *     Code:
 *        0: bipush        10
 *        2: istore_1
 *        3: bipush        9
 *        5: istore_2
 *        6: iload_1
 *        7: iload_2
 *        8: iadd
 *        9: iload_0
 *       10: iadd
 *       11: ireturn
 * }
 */

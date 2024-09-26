package leetcodereview01.zhongdeng.top_208;

/** 实现Trie前缀树 */
public class Trie {

    private Trie[] children;

    private boolean isEnd;

    public Trie() {
        this.children = new Trie[26];
        this.isEnd = false;
    }

    public void insert(String word) {
        // 通过遍历实现为一个链表的形式
        Trie node = this;
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    public Trie searchPrefix(String word) {
        Trie node = this;
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            int index = ch - 'a';
            if (node.children[index] != null) {
                node = node.children[index];
            } else {
                return null;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));;   // 返回 True
        System.out.println(trie.search("app"));     // 返回 False
        System.out.println(trie.startWith("app")); // 返回 True
        trie.insert("app");
        System.out.println(trie.search("app"));;     // 返回 True
    }

}

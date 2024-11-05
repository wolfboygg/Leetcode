package leetcodereview01.new_top_100.top_208;


/**
 * 实现前缀树，通过一个char数组来实现挂载到底有没有
 */
public class TrieTree {

    private TrieTree[] children;
    private boolean isEnd = false;

    public TrieTree() {
        this.children = new TrieTree[26];
        this.isEnd = false;
    }

    /**
     * 类似于链表
     *
     * @param str
     */
    public void insert(String str) {
        char[] charArray = str.toCharArray();
        TrieTree node = this;
        for (char c : charArray) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieTree();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String str) {
        TrieTree trieTree = searchPrefix(str);
        return trieTree != null && trieTree.isEnd;
    }

    public boolean startWith(String str) {
        return searchPrefix(str) != null;
    }

    public TrieTree searchPrefix(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        TrieTree node = this;
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            int index = c - 'a';
            if (node.children[index] != null) {
                node = node.children[index];
            } else {
                return null;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        TrieTree trie = new TrieTree(); // 当前对象为head节点
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        ;   // 返回 True
        System.out.println(trie.search("app"));     // 返回 False
        System.out.println(trie.startWith("app")); // 返回 True
        trie.insert("app");
        System.out.println(trie.search("app"));
        ;
    }


}

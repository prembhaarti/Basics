package trie;

import java.util.HashMap;
import java.util.Map;

public class TNode {

  private Map<Character,TNode> children;
  private boolean isEnd;
  private char value;

  public TNode(char value){
    this.value=value;
    children = new HashMap<>();
  }

  public Map<Character, TNode> getChildren() {
    return children;
  }

  public void setChildren(HashMap<Character, TNode> children) {
    this.children = children;
  }

  public boolean isEnd() {
    return isEnd;
  }

  public void setEnd(boolean end) {
    isEnd = end;
  }

  public char getValue() {
    return value;
  }

  public void setValue(char value) {
    this.value = value;
  }
}

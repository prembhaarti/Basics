package basics.interview.tree;

/**
 * http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
 * Test cases:
 * Empty basics.tree
 * One node basics.tree
 * All left side basics.tree
 * All right side basics.tree
 * Mixed basics.tree
 * Full basics.tree
 * complete basics.tree
 */
public class ConstructTreeFromInOrderPreOrder {
    
    private int index = 0;
    public Node createTree(int inorder[],int preorder[]){
        Node result =  createTree(inorder,preorder,0,inorder.length-1);
        index = 0;
        return result;
    }
    
    private Node createTree(int inorder[],int preorder[], int start, int end){
        if(start > end){
            return null;
        }
        int i;
        for(i=start; i <= end; i++){
            if(preorder[index] == inorder[i]){
                break;
            }
        }
        Node node = Node.newNode(preorder[index]);
        index++;
        node.left = createTree(inorder,preorder,start,i-1);
        node.right = createTree(inorder,preorder,i+1,end);
        return node;
    }
}

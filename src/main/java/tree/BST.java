package tree;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class BST {
	private Queue<Node> nodeQueue= new LinkedBlockingQueue<>();
	private int[] inOrder={0,1,2,3,4,5,6};
	private int[] preOrder={3,1,0,2,5,4,6};

	/**
	 * if root is leaf return 1
	 * if left is null return minDepth of right + 1
	 * if right is null return minDepth of left + 1
	 * if both child are not null return Min depth of both + 1
	 * @param node
	 * @return
	 */
	public int getMinDepth(Node node){
		if (null == node) {
			return 0;
		}
		else if (null == node.lc && null == node.rc) {
			return 1;
		} else if (null == node.lc) {
			return getMinDepth(node.rc)+1;
		} else if (null == node.rc) {
			return getMinDepth(node.lc)+1;
		}
		return Math.min(getMinDepth(node.lc),getMinDepth(node.rc))+1;
	}

	/**
	 * check if BST or not
	 * predefined we send min to integer min and  max to integer max
	 *  if data is under limit then keep checking
	 * when go to left then max will be root (update)
	 * when go to right then min will be root
	 *
	 */
	public boolean isBST(Node root, int min, int max){
		if(root==null){return true;}
		if(root.data>min && root.data<max){
			return isBST(root.lc,min,root.data) && isBST(root.rc,root.data,max);
		}
			return false;
	}

	/**
	 * if first and second node null -> true
	 * if first null and second not null and vice versa -> false
	 * else
	 *  if first data and second data true
	 *  	then send
	 *  	first left and second right
	 *  	and first right and second left
	 *  to recursion
   	*/
	public boolean isMirrorTree(Node first,Node second){
		boolean isMirrored=false;
		//if both tree's root are null they are mirrored
		if(first==null && second==null) return true;
		//if node of one tree is null and corresponding other tree's node is not null
		// they are not mirrored
		else if((first==null && second!=null) || first!=null && second==null){
			return false;
		}
		else {
			// if both corresponding mirrored node are same
			if(first.data==second.data) {
				isMirrored=true;
			}
			else {
				return false;
			}
			// take one tree's left node and second's tree right node
			return isMirrored && isMirrorTree(first.lc, second.rc) && isMirrorTree(first.rc,second.lc);

		}
	}

	/**
	 * if first and second node null -> true
	 * if first null and second not null and vice versa -> false
	 * else
	 *  if first data and second data true
	 *  	then send
	 *  	first left and second left
	 *  	and first right and second right
	 *  to recursion
	 */

	public boolean isBSTSame(Node first, Node second){
		boolean isSame=false;
		if(first==null && second==null) return true;
		else if((first==null && second!=null)||(first!=null && second==null)){
			return false;
		}
		else{
			if(first.data==second.data){
				isSame=true;
			}
			else return false;
			return isSame && isBSTSame(first.lc,second.lc) && isBSTSame(first.rc,second.rc);
		}
	}

/*
	public void levelOrderTraversal(Node root){
		if(root!=null){
			if(nodeQueue.isEmpty()){
				nodeQueue.add(root);
			}
			if(root.lc!=null){
				nodeQueue.add(root.lc);
			}
			if(root.rc!=null){
				nodeQueue.add(root.rc);
			}
			levelOrderTraversal(root.lc);
			levelOrderTraversal(root.rc);
		}
	}
*/

	/**
	 * add root to queue
	 *
	 *  until queue is empty
	 * 		take out node from queue
	 * 				print node data
	 * 		take out its left and right
	 * 				and add to queue
     */
	public void levelOrderTraversal(Node root){
		if(root!=null){
			if (nodeQueue.isEmpty()) {
				nodeQueue.add(root);
			}
			while(!nodeQueue.isEmpty()) {
				Node parent = nodeQueue.remove();
				System.out.print(parent.data + " ");
				if (parent.lc != null) {
					nodeQueue.add(parent.lc);
				}
				if (parent.rc != null) {
					nodeQueue.add(parent.rc);
				}
			}
		}
	}

	Stack<Node> leftToRight= new Stack<>();
	Stack<Node> rightToLeft= new Stack<>();

	/**
	 * create two stacck leftToRight and rightToLeft
	 *
	 * first put root to leftToRight
	 * until leftToRight is empty take all it's node children
	 * and put into rightToLeft
	 *
	 * same now until rightToLeft is empty take all its node children
	 * and put into leftToRight
	 *
	 * until both gets empty
	 *
	 * print element data when you pop element from stack.
	 */
	public void zigzag(Node root){
		leftToRight.push(root);
		while(!leftToRight.isEmpty()||!rightToLeft.isEmpty()){
			while(!leftToRight.isEmpty()){
				Node node=leftToRight.pop();
				System.out.println(node.data);
				if(node.lc!=null)
					rightToLeft.push(node.lc);
				if(node.rc!=null)
					rightToLeft.push(node.rc);

			}
			while(!rightToLeft.isEmpty()){
				Node node=rightToLeft.pop();
				System.out.println(node.data);
				if(node.rc!=null)
					leftToRight.push(node.rc);
				if(node.lc!=null)
					leftToRight.push(node.lc);
			}
		}
	}

	public boolean isSibling(Node root, int left,int right){
		if(root==null || root.lc==null || root.rc==null){
			return false;
		}
		else{
			return (left==root.lc.data && right==root.rc.data)||
					(left==root.rc.data && right==root.lc.data)||
					isSibling(root.lc,left, right) ||
					isSibling(root.rc, left, right);
		}
	}

	public Node getCommonAncestorBST(Node root,int a, int b){
		if(root==null) return null;
		if(a<root.data && b<root.data){
			return	getCommonAncestorBST(root.lc, a, b);
		}
		if(a>root.data && b>root.data){
			return getCommonAncestorBST(root.rc, a, b);
		}
		return root;
	}

	/**
	 * if root left's data or root right's data -> a or b
	 * 		return root
	 *	send root.lc recursively -> will give left node in return
	 *  send root.rc recursively -> will give right node in return
	 *
	 *  if left and right both not null -> return root
	 *  if left -> null return right
	 *  if right -> null return left
	 *
   */
	public Node getCommonAncestor(Node root, int a, int b){
		if (root == null||root.data==a||root.data==b) {
			return root;
		}
		Node left=getCommonAncestor(root.lc,a, b);
		Node right=getCommonAncestor(root.rc,a,b);
		if(left!=null && right!=null) return root;
		if(left==null) return right; else return left;
	}

	//finds distance from root to given data node. result distance is one less pathLength method returns
	public int pathLength(Node root, int data){
		int pathLength=0;
		if(root!=null){
			if(root.data==data||(pathLength=pathLength(root.lc,data))>0||(pathLength=pathLength(root.rc,data))>0){
				return pathLength+1;
			}
		}
		return pathLength;
	}

	public int distanceBetweenTwoNode(Node root, int data1,int data2){
		if(root!=null){
			int data1DistanceFromRoot= pathLength(root,data1)-1;
			int data2DistanceFromRoot = pathLength(root, data2)-1;
			Node csaNode = getCommonAncestor(root, data1, data2);
			if(null==csaNode)return -1;
			int csaDistanceFromRoot= pathLength(root,csaNode.data)-1;
			int distance=data1DistanceFromRoot+data2DistanceFromRoot- 2* csaDistanceFromRoot;
			return distance;
		}
		return 0;
	}

	public void levelOrderTraversal(Node root,int level){
		if(root!=null && level>-1){
			if(level==0){
				System.out.print(root.data+" ");
			}
			else{
				levelOrderTraversal(root.lc, level-1);
				levelOrderTraversal(root.rc,level-1);
			}
		}
	}

	
	public void allLevelOrderTraversal(Node root){
		for(int i=0; i<getMaxDepth(root);i++){
			levelOrderTraversal(root, i);
			System.out.println("             --> Level:"+i);
		}
	}

	public int getMaxDepth(Node root){
		//return root==null ? 0: 1+Math.max(getMaxDepth(root.lc),getMaxDepth(root.rc));

		if(root==null){
			return 0;
		}
		else{
			int leftDepth=getMaxDepth(root.lc);
			int rightDepth=getMaxDepth(root.rc);
			
			if(leftDepth>rightDepth){
				return leftDepth+1;
			}
			else{
				return rightDepth+1;
			}
		}
	}

	public int getHeight(Node root){
		if(root==null||(root.lc==null && root.rc==null)){
			return 0;
		}
		return Math.max(getHeight(root.lc),getHeight(root.rc))+1;
	}

	public Node convertToDLLUtil(Node root){
		if(root==null) return root;
		if(root.lc!=null){
			Node left = convertToDLLUtil(root.lc);
			while(left.rc!=null) left=left.rc;
			left.rc=root;
			root.lc=left;
		}
		if(root.rc!=null){
			Node right = convertToDLLUtil(root.rc);
			while(right.lc!=null) right=right.lc;
			root.rc=right;
			right.lc=root;
		}
		return root;
	}

	/**
	 * first reach to second left most node
	 * 		check still any node on right
	 *
	 *
	 */
	public Node convertToDll(Node root){
		Node node = convertToDLLUtil(root);

		while (node.lc!=null){
			node=node.lc;
		}
		return node;
	}
	Node head=null;
	Node previous=null;

	/**
	 * you can get head and traverse dll
	 * @param root
	 */
	void BinaryTree2DoubleLinkedList(Node root)
	{
		// Base case
		if (root == null)
			return;

		// Recursively convert left subtree
		BinaryTree2DoubleLinkedList(root.lc);

		// Now convert this node
		if (prev == null)
			head = root;//only run @1 case when making head
		else
		{
			root.lc = previous;
			previous.rc = root;
		}
		previous = root;

		// Finally convert right subtree
		BinaryTree2DoubleLinkedList(root.rc);
	}
	public void boundaryView(Node root){
		printLeftBoundary(root);
		printLeaves(root);
		printRightBoundary(root);
	}

	public void printLeftBoundary(Node root){
		if(root!=null){
			if(root.lc!=null){
				System.out.println(root.data);
				printLeftBoundary(root.lc);
			}
			else if(root.rc!=null){
				System.out.println(root.data);
				printLeftBoundary(root.rc);
			}
		}
	}
	public void printRightBoundary(Node root){
		if(root!=null){
			if(root.rc!=null){
				printRightBoundary(root.rc);
				System.out.println(root.data);
			}
			else if(root.rc!=null){
				printRightBoundary(root.lc);
				System.out.println(root.data);
			}
		}
	}

	public void printLeaves(Node root){
		if(root!=null){
			if(root.lc==null || root.rc==null){
				System.out.println(root.data);
			}
			printLeaves(root.lc);
			printLeaves(root.rc);
		}
	}

	public void connectToRightPointer(Node root){

		if(root!=null){
			Node tempLeft=root.lc;
			if(tempLeft!=null){
				if(root.rc!=null)
				tempLeft.next=root.rc;
				else{
					Node dummy=root.next;
					while(dummy.lc!=null||dummy.rc!=null){
						dummy=dummy.next;
					}
					if(dummy.lc!=null)root.lc.next=dummy.lc;
					else root.rc.next=dummy.rc;
				}

			}

			if(root.rc!=null && root.next!=null){
				root.rc.next=root.next.lc;
			}
			connectToRightPointer(root.lc);
			connectToRightPointer(root.rc);
		}
	}


	private List<Integer> treeViewList = new ArrayList<>();
	public void leftTreeView(Node root,int size){
		if(null!=root){
			if(size>=treeViewList.size()){
				treeViewList.add(root.data);
				System.out.println(root.data + " ");
				int tempSize=treeViewList.size();
				leftTreeView(root.lc,tempSize);
				leftTreeView(root.rc,tempSize);
			}
		}
	}


	public Node largestNumberNode(Node root) {
		if (root != null) {
			if (root.rc != null) {
				root = largestNumberNode(root.rc);
			} else {
				return root;
			}
		}
		return root;
	}

	public Node smallestNumberNode(Node root) {
		if (root != null) {
			if (root.lc != null) {
				root = largestNumberNode(root.lc);
			} else {
				return root;
			}
		}
		return root;
	}

	/**
	 * to delete a particular number
	 * we need to search first
     */
	public Node deleteNode(Node root, int num) {
		if (root != null) {
			if (num < root.data) {
				root.lc = deleteNode(root.lc, num);
			} else if (num > root.data) {
				root.rc = deleteNode(root.rc, num);
			} else if (num == root.data) {
				// case 1: if node has no child
				if (root.lc == null && root.rc == null) {
					root = null;
				}
				// case 2: if node has 1 child
				else if (root.lc == null && root.rc != null) {
					root = root.rc;
					// return root;
				} else if (root.lc != null && root.rc == null) {
					root = root.lc;
					// return root;
				}
				// case 3: if node has two child
				else if (root.lc != null && root.rc != null) {
					// get the largest of left side node and copy to root
					Node largestNumberNode = largestNumberNode(root.lc);
					root.data = largestNumberNode.data;
					// now delete the largest node
					root.lc = deleteNode(root.lc, largestNumberNode.data);

					// we can also get the smallest of right side and copy to
					// root and repeat the same proccess.
				}
			}
		}
		return root;
	}

	public Node search(Node root,int data){
		Node result=null;
		if(root!=null){
			if(data==root.data) result=root;
			else if(data>root.data){
				return search(root.rc,data);
			}
			else{
				return search(root.lc,data);
			}
			return result;
		}
		else return result;
	}

	/**
	 * if root is null -> balanced
	 *  if check abs(leftHeight - rightheight)<=1
	 * 		check recursivley
	 * else not balanced.
   	*/
	public boolean isBSTBalanced(Node root){
		if(null==root) return true;
		int leftHeight= getMaxDepth(root.lc);
		int rightHeight= getMaxDepth(root.rc);
		if(Math.abs(leftHeight-rightHeight)>1){
			return false;
		}
		else{
			return isBSTBalanced(root.lc) && isBSTBalanced(root.rc);
		}
	}

	public boolean pathSum(Node root, int sum, List<Node> path){
		if(root==null) { return false;}
		if(sum-root.data==0){
			if(root.lc==null && root.rc==null){
				path.add(root);
				return true;
			}
		}
		else{
			if(pathSum(root.lc,sum-root.data,path)){
				path.add(root);
				return true;
			}
			if(pathSum(root.rc,sum-root.data,path)){
				path.add(root);
				return true;
			}
		}
		return false;
	}

	public void insert(Node root, int data) {
		if (data <= root.data) {
			if (root.lc != null) {
				insert(root.lc, data);
			} else {
				root.lc = new Node(data);
			}
		} else if (data > root.data) {
			if(root.rc!=null){
				insert(root.rc,data);
			}
			else{
				root.rc=new Node(data);
			}
		}
	}

	//List<Integer> preOrder = new ArrayList<>();
	public void preOrder(Node root) {
		if (root != null) {
			System.out.println(root.data);
			//preOrder.add(root.data);
			preOrder(root.lc);
			preOrder(root.rc);
		}
	}

	public void inOrder(Node root){
		if(root!=null){
			inOrder(root.lc);
			System.out.print(root.data+" ");
			inOrder(root.rc);
		}
	}

	/**
	 * create stack push root
	 * 	if root not null-> push and move to left
	 * 	if root is null -> pop, print and move to right
	 */
	public void inOrderIteration(Node root){
		Stack<Node> stack = new Stack<Node>();
		if(root!=null)
		stack.push(root);

		while(!stack.isEmpty()) {
			if (root != null) {
				stack.push(root);//push element in stack
				root = root.lc;//move to left
			}
			else{
				root=stack.pop();//popping is done when left has ended
				System.out.print(root.data+ " ");//print root
				root=root.rc;//move to right
			}
		}
	}

	/**
	 * same as in inOrder but
	 * print will occur in when root not null
	 * @param root
	 */
	public void preOrderIteration(Node root){
		Stack<Node> stack = new Stack<>();
		if(root!=null)
			stack.push(root);

		while (!stack.isEmpty()){
			if(root!=null){
				System.out.println(root.data);
				stack.push(root);
				root=root.lc;
			}
			else{
				Node right=stack.pop();
				root=right.rc;
			}
		}

	}

	public void postOrder(Node root){
		if(root!=null){
			postOrder(root.lc);
			postOrder(root.rc);
			System.out.println(root.data+" ");
		}
	}

	int maxLevelLeft=-1;
	public void leftView(Node root, int level){
		if (root != null) {
			if (level > maxLevelLeft) {
				System.out.println(root.data);
				maxLevelLeft = level;
			}
			leftView(root.lc,level+1);
			leftView(root.rc,level+1);
		}
	}

	int maxLevelRight=-1;
	public void rightView(Node root, int level){
		if (root != null) {
			if (level > maxLevelRight) {
				System.out.println(root.data);
				maxLevelRight = level;
			}
			leftView(root.rc,level+1);
			leftView(root.lc,level+1);
		}
	}

	int minLevelTop=0;
	int maxLevelTop=-1;

	public void topView(Node root, int level) {
		if (root != null) {
			if (level < minLevelTop) {
				System.out.println(root.data);
				minLevelTop = level;
			}
			if (level > maxLevelTop) {
				System.out.println(root.data);
				maxLevelTop=level;
			}
			topView(root.lc);
			topView(root.rc);
		}
	}

	/**
	 * make root as level 0
	 * send left to level+1 and right to level-1
	 *
	 *
	 */
	Map<Integer,Integer> levelContainer= new TreeMap<>();
	public void topViewHelper(Node root,int level){
		if(root!=null){
			if(!levelContainer.containsKey(level)){
				levelContainer.put(level,root.data);
			}
				topViewHelper(root.lc,level-1);
				topViewHelper(root.rc,level+1);
		}
	}

	public void bottomViewHelper(Node root,int level){
		if(root!=null){
			levelContainer.put(level,root.data);
			bottomViewHelper(root.lc,level-1);
			bottomViewHelper(root.rc,level+1);
		}
	}

	public void topView(Node root){
		topViewHelper(root,0);
		for(int key:levelContainer.keySet()){
			System.out.println(levelContainer.get(key)+" ");
		}
	}

	public void bottomView(Node root){
		bottomViewHelper(root,0);
		for(int key:levelContainer.keySet()){
			System.out.println(levelContainer.get(key)+" ");
		}
	}

	public int diameter(Node root){
		if(root!=null){
			int leftHeight= getMaxDepth(root.lc);
			int rightHeight = getMaxDepth(root.rc);
			int leftDiameter = diameter(root.lc);
			int rightDiameter = diameter(root.rc);
			return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
		}
		return 0;
	}


	public int diameterOp(Node root, Height height) {
		Height left= new Height();
		Height right= new Height();
		if (root == null) {
			height.height=0;
			return 0;
		}
		left.height++;right.height++;
		int leftDiameter = diameterOp(root.lc, left);
		int rightDiameter = diameterOp(root.rc, right);
		height.height = Math.max(left.height, right.height);
		return Math.max(left.height + right.height + 1, Math.max(leftDiameter, rightDiameter));
	}

	public Node sortedArrayToBST(int[] array,int low, int high){
			if(array.length<1 ||low>=high)return null;
			int mid=(low+high)/2;
			Node root=new Node(array[mid]);
			root.lc=sortedArrayToBST(array,low,mid);
			root.rc=sortedArrayToBST(array,mid+1,high);
			return root;
	}

	public int getLevel(Node root,int data){
		int level=-1;
		if(null==root){
			return level;
		}
		else{
			if(root.data==data){
				return level+1;
			}
			int leftLevel=getLevel(root.lc,data);
			int rightLevel=getLevel(root.rc,data);
			if(leftLevel>-1) return leftLevel+1;
			if(rightLevel>-1)
				return rightLevel+1;
		}
		return level;
	}

	/**
	 *
	 *
   */
	public int getLevel(Node root,int a, int level){
		if(root==null) return -1;
		if(a==root.data) return level;
		else{
			int levelLeft=getLevel(root.lc,a,level+1);
			int levelRight=getLevel(root.rc,a,level+1);
			if(levelLeft!=-1) return levelLeft;
			else return levelRight;
		}
	}



	/**
	 * if nodes are at same level and not cousin
   */
	public boolean isCousin(Node root, int a, int b){
		if(root==null) return false;
		return getLevel(root,a,0)==getLevel(root,b,0) && !isSibling(root,a,b);
	}

	public void diagonalTraversal(Node root){
		Map<Integer, Integer> map = new TreeMap<>();
		diagonalTraversalUtil(root,1,map);
		for(Integer sum:map.values()){
			System.out.println(sum);
		}
	}

	/**
	 * create a map will contain each diagonal level and level sum
	 *  when go to left pass level+1
	 *  when go to right pass level and add root.data to existing sum against that level
   */
	private void diagonalTraversalUtil(Node root,int level, Map<Integer,Integer> map){
		if(root==null){
			return;
		}
		if(root.lc!=null){
			diagonalTraversalUtil(root.lc,level+1,map);
		}

		if(!map.containsKey(level)){
			map.put(level,root.data);
		}
		else{
			map.put(level,map.get(level)+root.data);
		}
		if(root.rc!=null) {
			diagonalTraversalUtil(root.rc, level, map);
		}
	}

	private void maximumWidthUtil(Node root, int level, Map<Integer,Integer> map){
		if(root==null){
			return;
		}
		if(root.lc!=null){
			maximumWidthUtil(root.lc,level+1,map);
		}
		if(root.rc!=null){
			maximumWidthUtil(root.rc,level+1,map);
		}
		if(!map.containsKey(level)){
			map.put(level,1);
		}
		else{
			map.put(level,map.get(level)+1);
		}
	}

	public int maximumWidth(Node root){
		Map<Integer,Integer> map = new TreeMap<>();
		maximumWidthUtil(root,1,map);
		int max=0;
		for(int width:map.values()){
			if(width>max){
				max=width;
			}
		}
		return max;
	}

	/**
	 * traverse BT inorder and store it in a list
	 * sort list
	 * again traverse inorder BT and put data from list into traverse node one by one
	 *
	 * for putting data make index=0, add and increment index
	 */
	public Node btToBst(Node root) {
		List<Integer> list = new ArrayList<>();
		root=btToBstInorderCopy(root, list);
		Collections.sort(list);
		root=btToBstInorderPaste(root,list);
		return root;
	}

	private Node btToBstInorderCopy(Node root,List<Integer> list){
		if(root!=null){
			btToBstInorderCopy(root.lc, list);
			list.add(root.data);
			btToBstInorderCopy(root.rc,list);
		}
		return root;
	}
	int listIndex=0;
	private Node btToBstInorderPaste(Node root,List<Integer> list){
		if(root!=null){
			btToBstInorderPaste(root.lc, list);
			root.data=list.get(listIndex++);
			btToBstInorderPaste(root.rc,list);
		}
		return root;
	}

	public boolean isSumTree(Node root,SumTreeSum treeSum){
		if(root==null){
			return true;
		}
		if(root.lc==null && root.rc==null){
			treeSum.sum=root.data;
			return true;
		}
		SumTreeSum leftSum=new SumTreeSum(0);
		SumTreeSum rightSum=new SumTreeSum(0);
		if(isSumTree(root.lc,leftSum) && isSumTree(root.rc,rightSum)) {
			if (root.data == leftSum.sum + rightSum.sum) {
				return true;
			}
		}
		return false;
	}

	public Node createBinaryTreeUsingInorderPreorder(int[] in,int[] pre){
		Node root= createBinaryTreeUsingInorderPreorderUtil(in, pre, 0,in.length-1);
		return root;
	}
	private int index=0;
	public Node createBinaryTreeUsingInorderPreorderUtil(int[] in, int[] pre, int start, int end){
		if(start>end){
			return null;
		}
		int foundPlace=start;
		for(int i=start;i<end;i++){
			if(pre[index]==in[i]){
				foundPlace=i;
				break;
			}
		}
		Node root= new Node(pre[index]);
		index++;
		root.lc=createBinaryTreeUsingInorderPreorderUtil(in,pre,start,foundPlace-1);
		root.rc = createBinaryTreeUsingInorderPreorderUtil(in, pre, foundPlace + 1, end);
		return root;
	}


	public int nodeHavingKLeaves(Node root,int k){
		if(root==null){
			return 0;
		}
		if(root.lc==null && root.rc==null){
			return 1;
		}
		int left=nodeHavingKLeaves(root.lc,k);
		int right=nodeHavingKLeaves(root.rc,k);
		if(left+right==k){
			System.out.println(root.data);
		}
		return left+right;
	}

	public int maximumLevelSum(Node root){
		Map<Integer,Integer> map= new HashMap<>();
		maximumLevelSumUtil(root,map,0);
		return Collections.max(map.values());
	}

	public void maximumLevelSumUtil(Node root, Map<Integer,Integer> map, int level){
		int currentSum=-1;
		if(root!=null){
			if(map.containsKey(level)){
				currentSum=map.get(level)+root.data;
				map.put(level,currentSum);
			}
			else{
				map.put(level, root.data);
			}
			maximumLevelSumUtil(root.lc,map,level+1);
			maximumLevelSumUtil(root.rc,map,level+1);
		}
	}

	/**
	 * print all pairs with given condition, given no. k
	 *
	 * i.e  |a-b|<= k
	 *      one element should be ancestor of another
	 */
	public void similarPair(Node root, int arr[], int index,int diff){
		if(root!=null){
			arr[index]=root.data;
			for(int i=0;i<index;i++){
				if(Math.abs(arr[i]-arr[index])<=diff){
					System.out.println(arr[i]+","+arr[index]);
				}
			}
			similarPair(root.lc,arr,index+1,diff);
			similarPair(root.rc,arr,index+1,diff);
		}
	}
	int maxDiff=0;
	public void maxDiffBetweenAncestorAndNode(Node root,List<Integer> list, int index){
		if(root!=null){
			list.add(root.data);
			for(int i=0;i<index;i++){
				maxDiff=Math.max(Math.abs(list.get(i)-list.get(index)),maxDiff);
			}
			maxDiffBetweenAncestorAndNode(root.lc,list,index+1);
			if(root.lc!=null) list.remove(index+1);
			maxDiffBetweenAncestorAndNode(root.rc,list,index+1);
			if(root.rc!=null)list.remove(index+1);
		}
	}

	public void printKNodeBeforeLeaf(Node root,int distance,int current,List<Integer> list){
		if(root.lc!=null||root.rc!=null){
			list.add(current,root.data);
			printKNodeBeforeLeaf(root.lc,distance,current+1,list);
			printKNodeBeforeLeaf(root.rc,distance,current+1,list);
		}
		else{
			if(current-distance>=0 && list.size()>=distance){
				System.out.println(list.get(current-distance));
			}
		}
	}

	/**
	 * take preorder and inOrder of main string
	 * take preorder and inorder of sub string
	 *
	 * check if main String's preorder contains preOrder of subString
	 *
	 *
   */
	public boolean isSubTree(Node main,Node sub){
		StringBuilder mainInOrder = new StringBuilder();
		StringBuilder mainPreOrder = new StringBuilder();
		StringBuilder subInOrder = new StringBuilder();
		StringBuilder subPreOrder = new StringBuilder();

		stringInOrder(main,mainInOrder);
		stringInOrder(sub,subInOrder);
		stringPreOrder(main,mainPreOrder);
		stringPreOrder(sub,subPreOrder);

		return mainInOrder.toString().contains(subInOrder.toString()) &&
				mainPreOrder.toString().contains(subPreOrder.toString());

	}

	public void stringInOrder(Node root,StringBuilder sb){
		if(root!=null){
			stringInOrder(root.lc,sb);
			sb.append(root.data);
			stringInOrder(root.rc, sb);
		}
		else{
			sb.append("%");
		}
	}
	public void stringPreOrder(Node root,StringBuilder sb){
		if(root!=null){
			sb.append(root.data);
			stringPreOrder(root.lc,sb);
			stringPreOrder(root.rc, sb);
		}
		else{
			sb.append("%");
		}
	}


	/**
	 *	just do the preorder traversal and
	 *	when you find the node is null just add -1 as a marker.
	 */
	public void getSerialized(Node root, List<Integer> list){
		if(root==null){
			list.add(-1);
		}
		else{
			list.add(root.data);
			getSerialized(root.lc,list);
			getSerialized(root.rc,list);
		}
	}

	/**
	 * as we know if there's -1 at arraylist index it must be null
	 * or index is at end of the arraylist
	 *
	 * so, from root
	 * step 1: create a node and do recursion to left by sending the left child.
	 * step 2: same do for the right child for the recursion
	 *
	 * doing step1 and step2, we need to increment the index(should be global)
	 * and at end return the root
	 *
	 */
	static int dIndex=0;
	public Node getDeserialized(List<Integer> list){
		Node root=null;
		if(dIndex==list.size()||list.get(dIndex)==-1){
			return root;
		}
		else{
			root= new Node(list.get(dIndex));
			++dIndex;
			root.lc= getDeserialized(list);
			++dIndex;
			root.rc= getDeserialized(list);
		}
		return root;
	}

	public Node convertToMirrorInPlace(Node root){
		if(root!=null){
			convertToMirrorInPlace(root.lc);
			connectAtSameLevelNode(root.rc);
			Node temp=root.lc;
			root.lc=root.rc;
			root.rc=temp;
		}
		return root;
	}

	public Node getPredecessor(Node root, Node predecessor, int data) {
		if (root != null){
			if (root.data == data) {
				if (root.lc != null) {
					predecessor = largestNumberNode(root.lc);
				}
				return predecessor;
				//successor=smallestNumberNode(root.rc);
			}
			if (data < root.data) {    //going left set successor = root
				return getPredecessor(root.lc, predecessor, data);
			} else {
				predecessor = root;//going right set predecessor to left
				return getPredecessor(root.rc, predecessor, data);
			}
		}
		else return null;
	}
	public Node getSuccessor(Node root, Node successor, int data) {
		if (root != null){
			if (root.data == data) {
				// if right is not null find smallest on  left of left sub tree
				if (root.rc != null) {
					successor = smallestNumberNode(root.rc);
				}
				//if right is null it means succesor already set
				return successor;
			}
			if (data < root.data) {    //going right set successor = root
				successor=root;
				return getSuccessor(root.lc, successor, data);
			} else {
				return getSuccessor(root.rc, successor, data);
			}
		}
		else return null;
	}

	/**
	 *
	 * take four extra pointers prev, first, mid, last
	 * 	do inorder traversal
	 * 	if root found less than prev
	 * 		store prev in first, root in mid
	 *
	 * 	if root found less than prev again
	 * 		store root in last.
	 *
	 * 	#1. possibility one-> swapped data are not parent child, in this case mid and last data
	 * 						  needs to be swapped
	 * 	#2. possibility two-> if last found null, means parent child are only swapped data,
	 * 						  swap first and mid data.
	 */
	private Node rectifyUtil(Node root,Node prev,Node first,Node mid,Node last){
		if (root != null) {
			rectifyUtil(root.lc, prev, first, mid, last);
			if (prev != null && root.data > prev.data) {
					if(first==null){
						first=prev;
						mid=root;
					}
					else {
						last=root;
					}
			}
			rectifyUtil(root.rc, root, first, mid, last);
		}
		return root;
	}
    Node first=null,mid=null,last=null,prev=null;
	public void rectify(Node root){
		if (root != null) {
			rectifyUtil(root,prev,first,mid,last);
			if(first!=null && last!=null){
				int temp=first.data;
				first.data=last.data;
				last.data=temp;
			}
			else {
				int temp=first.data;
				first.data=mid.data;
				mid.data=temp;
			}
		}

	}

	public void printMidLevelOfPerfectTree(Node root) {
		if (root != null) {
			printMidLevelOfPerfectTreeUtil(root,root);
		}
	}
	private void printMidLevelOfPerfectTreeUtil(Node a,Node b) {
		if (a== null||b==null) {
			return;
		}
		if (b.lc == null || b.rc == null) {
			System.out.println(a.data);
			return;
		}
		printMidLevelOfPerfectTreeUtil(a.lc,b.lc.lc);
		printMidLevelOfPerfectTreeUtil(a.rc,b.lc.lc);
	}


	/**
	 * Q: can given array in pre-order belongs to any BST
	 *
	 * #Note: whenever go to right update root, coz you are going to get the larger value.
	 *		  current array element should be less than root value.
	 *
	 * take array
	 * take root as integer and set min value to it
	 * loop for every element
	 *
	 * if any element found less root than return false i.e. not preorder of bst
	 * if stack not empty and present element is greater than top of stack
	 * 		change root to current element and pop to element
	 *
	 * push every element to stack.
	 *
	 */
	public boolean isPreOrder(int[] arr) {
		int root= Integer.MIN_VALUE;

		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<arr.length;i++){
			if (arr[i] < root) {
				return false;
			}
			while(!stack.isEmpty() && arr[i]>stack.peek()){
				root=arr[i];
				stack.pop();
			}
			stack.push(arr[i]);
		}
		return true;
	}

	/**
	 * print leftmost and rightmost of given BST
	 *
	 * take two node leftmost and rightmost
	 * for leftmost: check if left child exist assign left child to leftmost if not exist assign right child to leftmost
	 * for rightmost: check if right child exist assign right child to rightmost if not exist assign left child to rightmost
	 *
	 */
	public void leftAndRightEndNode(Node root){
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		Node leftMost=root.lc;
		Node rightMost=root.rc;
		while (leftMost != null || rightMost != null) {
			if (leftMost != null) {
				System.out.println(leftMost.data);
				if (leftMost.lc != null) {
					leftMost=leftMost.lc;
				}
				else {
					leftMost=leftMost.rc;
				}
			}
			if (rightMost != null) {
				System.out.println(rightMost.data);
				if (rightMost.rc != null) {
					rightMost=rightMost.rc;
				}
				else {
					rightMost=rightMost.lc;
				}
			}
		}
	}

	public void bothEndNode(Node root) {
		if (root != null) {
			Queue<Integer> queue = new LinkedList<>();




		}
	}

	public boolean isomorphic(Node root1, Node root2){
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		if (root1.data != root2.data) {
			return false;
		}

		return isomorphic(root1.lc, root2.lc) && isomorphic(root1.rc, root2.rc)
				|| isomorphic(root1.lc, root2.rc) && isomorphic(root1.rc, root2.lc);

	}

	public void printExtreme(Node root)
	{
		//  star node is for keeping track of levels
		Queue<Node> q = new LinkedList<Node>();

		// pushing root node and star node
		q.add(root);
		q.add(null);

		// if isFirst = true then left most node of that level
		// will be printed
		boolean isFirst = false;

		// if isOne = true then that level has only one node
		boolean isOne = false;

		// last will store right most node of that level
		int last = 0;

		// Do level order traversal of Binary Tree
		while (!q.isEmpty())
		{
			// dequeue the front node from the queue
			Node temp = q.peek();
			q.poll();

			// if isFirst is true, then temp is leftmost node
			if (isFirst)
			{
				System.out.print(temp.data + "  ");

				if (temp.lc != null)
					q.add(temp.lc);
				if (temp.rc != null)
					q.add(temp.rc);

				// make isFirst as false and one = 1
				isFirst = false;
				isOne = true;
			}

			// Else if temp is a separator between two levels
			else if (temp == null)
			{
				// Insert new separator if there are items in queue
				if (q.size() >= 1)
					q.add(null);

				// making isFirst as true because next node will be
				// leftmost node of that level
				isFirst = true;

				// printing last node, only if that level
				// doesn't contain single node otherwise
				// that single node will be printed twice
				if (!isOne)
					System.out.print(last + "  ");
			}
			else
			{
				// Store current key as last
				last = temp.data;

				// Here we are making isOne = false to signify
				// that level has more than one node
				isOne = false;
				if (temp.lc != null)
					q.add(temp.lc);
				if (temp.rc != null)
					q.add(temp.rc);
			}
		}
	}

	/**
	 * same as level order traversal just keep putting each level in stack
	 * and do traversal from right to left, so that stack will give you left to right
	 */
	public void reverseLevelOrder(Node root) {
		Stack<Node> stack = new Stack<>();

		Queue<Node> queue = new LinkedList<>();
		if(root!=null){
			queue.add(root);
		}
		else return;

		while(!queue.isEmpty()){
			Node removedNode=queue.remove();
			stack.push(removedNode);
			if (removedNode.rc!=null) {
				queue.add(removedNode.rc);
			}
			if (removedNode.lc != null) {
				queue.add(removedNode.lc);
			}
		}
		while (!stack.isEmpty()){
			System.out.println(stack.pop().data);
		}
	}

	public void connectAtSameLevelNode(Node root){
		if(root==null){
			return;
		}
		if(root.lc!=null && root.rc!=null){
			root.lc.next=root.rc;
		}

		if(root.lc!=null && root.rc==null){
			Node neighbour= root.next;
			while(neighbour!=null){
				if(neighbour.lc!=null){
					root.lc.next=neighbour.lc;
				}
				else if(neighbour.rc!=null){
					root.lc.next=neighbour.rc;
				}
			}
		}
		if(root.rc!=null && root.lc==null){
			Node neighbour= root.next;
			while(neighbour!=null){
				if(neighbour.lc!=null){
					root.rc.next=neighbour.lc;
				}
				else if(neighbour.rc!=null){
					root.rc.next=neighbour.rc;
				}
				neighbour=neighbour.next;
			}
		}
		connectAtSameLevelNode(root.rc);
		connectAtSameLevelNode(root.lc);
	}

	public void connectSameLevelNode(Node root){
		if(root==null){
			return;
		}
		if(root.lc!=null){
			if(root.rc!=null){
				root.lc.next=root.rc;
			}
			else{
				root.lc.next=root.next!=null && root.next.lc!=null ? root.next.lc:root.next.rc;
			}
		}
		else if(root.rc!=null){
			root.rc.next=root.next!=null && root.next.lc!=null ? root.next.lc:root.next.rc;
		}
		connectSameLevelNode(root.lc);
		connectSameLevelNode(root.rc);
	}


	public static void main(String[] args) {
/*
		Node root= new Node(10);
		root.lc = new Node(5);
		root.rc = new Node(8);
		root.lc.lc = new Node(2);
		root.lc.rc = new Node(20);
*/
//		root.rc.lc = new Node(2);
//		root.rc.rc = new Node(4);
/*
		Node root= new Node(3);
		root.lc = new Node(5);
		root.rc = new Node(1);
		root.lc.lc = new Node(0);
		root.lc.rc = new Node(6);
		root.rc.lc = new Node(2);
		root.rc.rc = new Node(4);

		BST bst = new BST();
		bst.reverseLevelOrder(root);
*/

		BST bst= new BST();
		Node node = bst.getBST();
		int[] arr= {3,1,0,2,5,4,6};
		bst.preOrder(node);
		System.out.println(bst.isPreOrder(arr));
//		bst.rectifyUtil(root,null,null,null,null);
		//bst.rectify(root);
		/*
		Node rt=bst.btToBst(root);
		bst.inOrder(rt);
*/

	}



	public Node getBST(){
		Node root= new Node(3);
		root.lc = new Node(1);
		root.lc.lc = new Node(0);
		root.lc.rc = new Node(2);
		root.rc = new Node(5);
		root.rc.lc = new Node(4);
		root.rc.rc = new Node(6);
		return root;
	}


	public Node getMirroredBST(){
		Node root= new Node(45);
		root.lc=new Node(60);
		root.rc=new Node(20);
		root.lc.lc= new Node(65);
		root.lc.rc = new Node(55);
		root.rc.lc= new Node(21);
		root.rc.rc= new Node (19);
		return root;
	}

	public Node getSumTree(){
		Node root= new Node(12);
		root.lc=new Node(2);
		root.rc=new Node(10);
		root.lc.lc=new Node(0);
		root.lc.rc=new Node(2);
		root.rc.lc= new Node(4);
		root.rc.rc=new Node(6);
		return root;
	}
	public Node getBSTSample(){
		Node root= new Node(3);
		root.lc=new Node(1);
		root.rc=new Node(5);
		root.lc.lc=new Node(0);
		root.lc.rc=new Node(2);
		root.rc.lc= new Node(4);
		root.rc.rc=new Node(6);
		return root;
	}


}

class SumTreeSum{
	public SumTreeSum(int sum){
		this.sum=sum;
	}
	int sum;
}
class Height{
	public int height;
}
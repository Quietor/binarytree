package com.quietor.binarytree;

import com.quietor.binarytree.node.BinaryTreeNode;

public class BinaryTree {

	private BinaryTreeNode root;
	
	/**
	 * ͨ��һ����֪�Ľڵ㹹��������
	 * @param root
	 */
	public BinaryTree(BinaryTreeNode root) {
		this.root = root;
	}
	
	public BinaryTree() {
		
	}
	
	public BinaryTreeNode getRoot() {
		return root;
	}
	
	/**
	 * �������ĸ��ڵ�
	 * @param root
	 */
	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}
	
	private void checkTreeEmpty() {
		if(this.root==null) {
			throw new IllegalStateException("Can't insert to a null tree!Dis you forget set value for root?");
		}
	}
	
	/**����������Ӳ���**/
	public void insertAsRightChild(BinaryTreeNode child) {
		checkTreeEmpty();
		this.root.setRightChildNode(child);
	}

	
	public void insertAsLeftChild(BinaryTreeNode child) {
		this.root.setLeftChildNode(child);
	}
	/**����������Ӳ���**/
	
	/**��������ɾ������**/
	public void deleteTreeNode(BinaryTreeNode node) {
		checkTreeEmpty();//�ж϶������Ƿ�Ϊ��
		if(node==null) {
			return;//����ڵ�ʱ����ô�ͷ���
		}
		//����ڵ㲻Ϊ����ô�ͽ��Ƚ�ָ���ڵ����������ɾ��
		deleteTreeNode(node.getRightChildNode());
		deleteTreeNode(node.getLeftChildNode());
		node = null;//����ɾ�����֮����ɾ���ýڵ�
	}
	/**��������ɾ������**/
	
	/**����������ղ���**/
	public void clearTree() {
		if(root!=null) {
			deleteTreeNode(root);//����������վ��Ǵ�ɾ�����ڵ㣬���Ӹ��ڵ���ո��ڵ�Ϊnull
		}
	}
	/**����������ղ���**/
	
	/**��ȡ�������ĸ߶�**/
	public int getTreeHeight() {
		checkTreeEmpty();
		return getNodeHeight(root);
	}
	/**��ȡ�������ĸ߶�**/
	
	/**��ȡ������ָ���ڵ�ĸ߶�**/
	public int getNodeHeight(BinaryTreeNode node) {
		if(node==null) {
			return 0;
		}
		int leftChildHeight = getNodeHeight(node.getLeftChildNode());
		int rightChildHeight = getNodeHeight(node.getRightChildNode());
		
		int maxLength = Math.max(leftChildHeight, rightChildHeight);
		return 1+maxLength;
	}
	/**��ȡ������ָ���ڵ�ĸ߶�**/
	
	/**��ȡ�������Ľڵ���**/
	public int getNodeSize(BinaryTreeNode node) {
		if(node==null) {
			return 0;//����ڵ�ʱ����ô�Ͳ����ڣ����Է�����0
		}
		int leftNodeSize = getNodeSize(node.getLeftChildNode());
		int rightNodeSize = getNodeSize(node.getRightChildNode());
		
		return leftNodeSize+rightNodeSize+1;//�����������������ϵ�ǰ�ڵ�ľ����Ե�ǰ�ڵ�Ϊ���ڵ������ܽ����
	}
	
	public int getTreeSize() {
		checkTreeEmpty();
		return getNodeSize(root);
	}
	/**��ȡ�������Ľڵ���**/
	
	/**��ȡָ���ڵ�ĸ��ڵ�**/
	public BinaryTreeNode getParentNode(BinaryTreeNode node) {
		if(node==null||node.getTreeData()==root.getTreeData()) {//�ڵ�Ϊ�ջ��ǽڵ�ʱ���ڵ㶼û�и��ڵ�
			return null;
		} else {
			return getSubNodeWhithNode(root, node);
		}
	}
	/**��ȡָ���ڵ�ĸ��ڵ�**/
	public BinaryTreeNode getSubNodeWhithNode(BinaryTreeNode parentNode, BinaryTreeNode subNode) {
		if(parentNode==null) {
			return null;
		}
		
		if(subNode == null) {
			throw new IllegalStateException("sub node is null!!!!");
		}
		
		BinaryTreeNode leftTreeNode = parentNode.getLeftChildNode();
		BinaryTreeNode rightTreeNode = parentNode.getRightChildNode();
		
		if(leftTreeNode!=null) {
			if(leftTreeNode.getTreeData()==subNode.getTreeData()) {
				return parentNode;
			}
			BinaryTreeNode subParentNode = getSubNodeWhithNode(leftTreeNode, subNode);
			if(subParentNode!=null) {
				return subParentNode;
			}
		}
		
		if(rightTreeNode!=null) {
			if(rightTreeNode.getTreeData()==subNode.getTreeData()) {
				return parentNode;
			}
		}
		
		BinaryTreeNode subParentNode = getSubNodeWhithNode(rightTreeNode, subNode);
		return subParentNode;
		
	}
	
	/**
	 * �������Ľڵ���Ҫ���еĲ���
	 * @param node
	 */
	public void operateNode(BinaryTreeNode node) {
		if(node==null) {
			return;
		}
		System.out.print(node.getTreeData());
	}
	/**�������ı���**/
	//������� ���ȱ������ڵ��ٱ�����������������������
	public void firstRootIterate() {
		checkTreeEmpty();
		operateNode(root);
		firstRootIterate(root.getLeftChildNode());
		firstRootIterate(root.getRightChildNode());
	}
	
	private void firstRootIterate(BinaryTreeNode node) {
		if(node==null) {
			return;
		}
		operateNode(node);
		firstRootIterate(node.getLeftChildNode());
		firstRootIterate(node.getRightChildNode());
	}
	
	//��������ȱ����������ٱ������ڵ�������������
	public void midleRootIterate() {
		checkTreeEmpty();
		midleRootIterate(root.getLeftChildNode());
		operateNode(root);
		midleRootIterate(root.getRightChildNode());
	}
	
	public void midleRootIterate(BinaryTreeNode node) {
		if(node==null) {
			return;
		}
		midleRootIterate(node.getLeftChildNode());
		operateNode(node);
		midleRootIterate(node.getRightChildNode());
	}
	
	public void lastRootIterate() {
		checkTreeEmpty();
		lastRootIterate(root.getLeftChildNode());
		lastRootIterate(root.getRightChildNode());
		operateNode(root);
	}
	
	public void lastRootIterate(BinaryTreeNode node) {
		if(node==null) {
			return;
		}
		lastRootIterate(node.getLeftChildNode());
		lastRootIterate(node.getRightChildNode());
		operateNode(node);
	}
	/**�������ı���**/
	
	public static void main(String[] args) {
		BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
		BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
		BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
		
		BinaryTreeNode node5 = new BinaryTreeNode(5, node7, null);
		BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
		BinaryTreeNode node3 = new BinaryTreeNode(3, null, node6);
		
		BinaryTreeNode root = new BinaryTreeNode(1, node2, node3);
		
		BinaryTree binaryTree = new BinaryTree(root);
		
		binaryTree.firstRootIterate();
		System.out.println();
		binaryTree.midleRootIterate();
		System.out.println();
		binaryTree.lastRootIterate();
		System.out.println();
		System.out.println("this tree height is:"+binaryTree.getTreeHeight());
		System.out.println("this tree size is:"+binaryTree.getTreeSize());
		BinaryTreeNode testNode = new BinaryTreeNode(4, null, null);
		BinaryTreeNode parentNode = binaryTree.getParentNode(testNode);
		System.out.println("4 parent is "+parentNode==null?parentNode:parentNode.getTreeData());
		
	}
}

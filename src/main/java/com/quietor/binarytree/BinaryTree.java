package com.quietor.binarytree;

import com.quietor.binarytree.node.BinaryTreeNode;

public class BinaryTree {

	private BinaryTreeNode root;
	
	/**
	 * 通过一个已知的节点构建二叉树
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
	 * 更改树的根节点
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
	
	/**二叉树的添加操作**/
	public void insertAsRightChild(BinaryTreeNode child) {
		checkTreeEmpty();
		this.root.setRightChildNode(child);
	}

	
	public void insertAsLeftChild(BinaryTreeNode child) {
		this.root.setLeftChildNode(child);
	}
	/**二叉树的添加操作**/
	
	/**二叉树的删除操作**/
	public void deleteTreeNode(BinaryTreeNode node) {
		checkTreeEmpty();//判断二叉树是否为空
		if(node==null) {
			return;//如果节点时空那么就返回
		}
		//如果节点不为空那么就将先将指定节点的左右子树删除
		deleteTreeNode(node.getRightChildNode());
		deleteTreeNode(node.getLeftChildNode());
		node = null;//子树删除完毕之后再删除该节点
	}
	/**二叉树的删除操作**/
	
	/**二叉树的清空操作**/
	public void clearTree() {
		if(root!=null) {
			deleteTreeNode(root);//二叉树的清空就是从删除根节点，即从根节点清空根节点为null
		}
	}
	/**二叉树的清空操作**/
	
	/**获取二叉树的高度**/
	public int getTreeHeight() {
		checkTreeEmpty();
		return getNodeHeight(root);
	}
	/**获取二叉树的高度**/
	
	/**获取二叉树指定节点的高度**/
	public int getNodeHeight(BinaryTreeNode node) {
		if(node==null) {
			return 0;
		}
		int leftChildHeight = getNodeHeight(node.getLeftChildNode());
		int rightChildHeight = getNodeHeight(node.getRightChildNode());
		
		int maxLength = Math.max(leftChildHeight, rightChildHeight);
		return 1+maxLength;
	}
	/**获取二叉树指定节点的高度**/
	
	/**获取二叉树的节点数**/
	public int getNodeSize(BinaryTreeNode node) {
		if(node==null) {
			return 0;//如果节点时空那么就不存在，所以返回是0
		}
		int leftNodeSize = getNodeSize(node.getLeftChildNode());
		int rightNodeSize = getNodeSize(node.getRightChildNode());
		
		return leftNodeSize+rightNodeSize+1;//左右子树几点数加上当前节点的就是以当前节点为根节点的书的总结点数
	}
	
	public int getTreeSize() {
		checkTreeEmpty();
		return getNodeSize(root);
	}
	/**获取二叉树的节点数**/
	
	/**获取指定节点的父节点**/
	public BinaryTreeNode getParentNode(BinaryTreeNode node) {
		if(node==null||node.getTreeData()==root.getTreeData()) {//节点为空或是节点时根节点都没有父节点
			return null;
		} else {
			return getSubNodeWhithNode(root, node);
		}
	}
	/**获取指定节点的父节点**/
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
	 * 遍历到的节点所要进行的操作
	 * @param node
	 */
	public void operateNode(BinaryTreeNode node) {
		if(node==null) {
			return;
		}
		System.out.print(node.getTreeData());
	}
	/**二叉树的遍历**/
	//先序遍历 ，先遍历根节点再遍历左子树、最后遍历右子树
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
	
	//中序遍历先遍历左子树再遍历根节点最后遍历右子树
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
	/**二叉树的遍历**/
	
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

package com.quietor.binarytree.node;

public class BinaryTreeNode {

	private int treeData;
	private BinaryTreeNode leftChildNode;
	private BinaryTreeNode rightChildNode;

	public BinaryTreeNode(int treeData, BinaryTreeNode leftChildNode, BinaryTreeNode rightChildNode) {
		this.treeData = treeData;
		this.leftChildNode = leftChildNode;
		this.rightChildNode = rightChildNode;
	}

	public int getTreeData() {
		return treeData;
	}

	public void setTreeData(int treeData) {
		this.treeData = treeData;
	}

	public BinaryTreeNode getLeftChildNode() {
		return leftChildNode;
	}

	public void setLeftChildNode(BinaryTreeNode leftChildNode) {
		this.leftChildNode = leftChildNode;
	}

	public BinaryTreeNode getRightChildNode() {
		return rightChildNode;
	}

	public void setRightChildNode(BinaryTreeNode rightChildNode) {
		this.rightChildNode = rightChildNode;
	}

}

package pat;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2021/2/24 10:12
 */
public class BinaryTree {

    public static void main(String[] args) {

        int[] datas = {72,37,29,55,51,80};


        BinaryTree biTree = BinaryTree.createBiTree(datas);
        System.out.println(biTree);

    }

    //根结点,默认为null
    private Node root = null;

    public Node getRoot() {
        return root;
    }

    //通过内部类,构建结点
    private class Node{
        //左节点
        private Node left;
        //数据域
        private int data;
        //右节点
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }


    private void buildBiTree(Node node,int data){
        //如果根结点是空,那么设置根结点,并且设置数据域
        if(root == null){
            root = new Node(data);
        }else{
            /**
             * 根结点不为空,那么判断数据是否小于当前结点的数据
             */
            if(data<node.getData()){
                //如果小于,判断当前结点是否有左叶子结点
                if(node.getLeft()==null){
                    //左叶子结点为空,设置左叶子结点,并且设置数据
                    node.setLeft(new Node(data));
                }else{
                    //左叶子结点不为空,递归调用构建二叉树的函数
                    buildBiTree(node.getLeft(),data);
                }
            }else{
                //如果大于或等于,判断当前结点是否存在右叶子结点
                if(node.getRight()==null){
                    //右叶子结点为空,设置右叶子结点,并且设置数据域
                    node.setRight(new Node(data));
                }else{
                    //右叶子几点不为空,递归调用构建二叉树的函数
                    buildBiTree(node.getRight(),data);
                }
            }
        }
    }

    public static BinaryTree createBiTree(int[] datas){
        BinaryTree binaryTree = new BinaryTree();
        for (int data : datas) {
            binaryTree.buildBiTree(binaryTree.getRoot(),data);
        }

        return binaryTree;
    }
}
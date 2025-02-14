class ProductOfNumbers {
    ArrayList<Integer> list;
    Stack<Integer> st = new Stack<>();
    int size = 0;

    public ProductOfNumbers() {
        list = new ArrayList<>();
    }
    
    public void add(int num) {
        list.add(num);
        st.push(num);
    }
    
    public int getProduct(int k) {
        int result = 1;
        int n = list.size();
        for(int i=n-1;i>n-k-1;i--)
        {
            result*=list.get(i);
        }
        return result;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
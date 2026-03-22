class DinnerPlates {
    private int capacity;
    private List<Stack<Integer>> stacks;
    private PriorityQueue<Integer> pq;
    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        stacks = new ArrayList<>();
        pq = new PriorityQueue<>();
    }
    public void push(int val) {
        while (!pq.isEmpty() && pq.peek() < stacks.size()
                && stacks.get(pq.peek()).size() == capacity) {
            pq.poll();
        }
        if (!pq.isEmpty() && pq.peek() < stacks.size()) {
            int idx = pq.poll();
            stacks.get(idx).push(val);
            if (stacks.get(idx).size() < capacity) {
                pq.offer(idx);
            }
        } else {
            Stack<Integer> st = new Stack<>();
            st.push(val);
            stacks.add(st);
            if (capacity > 1) {
                pq.offer(stacks.size() - 1);
            }
        }
    }
    public int pop() {
        while (!stacks.isEmpty() && stacks.get(stacks.size() - 1).isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }
        if (stacks.isEmpty()) return -1;
        int idx = stacks.size() - 1;
        int val = stacks.get(idx).pop();
        pq.offer(idx);
        return val;
    }
    public int popAtStack(int index) {
        if (index >= stacks.size() || stacks.get(index).isEmpty()) return -1;
        int val = stacks.get(index).pop();
        pq.offer(index);
        return val;
    }
}
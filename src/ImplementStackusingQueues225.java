import java.util.LinkedList;

public class ImplementStackusingQueues225 {
    class MyStack {
        private LinkedList<Integer> q1;
        private LinkedList<Integer> q2;
        /** Initialize your data structure here. */
        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            q1.offer(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            while(q1.size()!=1) q2.offer(q1.poll());
            int res = q1.poll();
            while(q2.size()!=0) q1.offer(q2.poll());
            return res;
        }

        /** Get the top element. */
        public int top() {
            int length = q1.size();
            for(int i=0;i<length-1;i++){
                q1.offer(q1.poll());
            }
            int res = q1.poll();
            q1.offer(res);
            return res;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty();
        }
    }


    class MyStack1 {
        private LinkedList<Integer> q;
        /** Initialize your data structure here. */
        public MyStack1() {
            q = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            q.offer(x);
            for(int i=0;i<q.size()-1;i++){
                q.offer(q.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return q.poll();
        }

        /** Get the top element. */
        public int top() {
            return q.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q.isEmpty();
        }
    }
}

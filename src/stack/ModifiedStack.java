package stack;

import java.util.Stack;

public class ModifiedStack {
}

class Jodi{
    Integer first;
    Integer second;
    Jodi(int first, int second){
        this.first=first;
        this.second=second;
    }
}
class GfG
{
    int minEle;
    Stack<Jodi> s=new Stack<>();

    int getMin()
    {
        if(s.size()<1) return -1;
        return s.peek().second;
    }

    int pop()
    {
        if (s.isEmpty()) return -1;
        int res = s.peek().first;
        s.pop();
        return res;
    }

    void push(int x)
    {
        if(s.isEmpty()){
            s.push(new Jodi(x,x));
        }else{
            int temp = s.peek().second<x?s.peek().second:x;
            s.push(new Jodi(x,temp));
        }
    }
}
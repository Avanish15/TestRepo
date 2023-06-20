class MinStack {
ArrayList<Integer> a = new ArrayList<>();
ArrayList<Integer> b = new ArrayList<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
    a.add(val);
    if( b.isEmpty()){
        b.add(val);
    }
     else if(val<b.get(b.size()-1)){
        b.add(val);
    }
    else{
        
    }
    }
    
    public void pop() {
        if(a.isEmpty()){
            return;
        }
      int k= a.remove(a.size()-1);
      if(!a.contains(k) && b.contains(k)){
          b.remove(b.indexOf(k));
      }
    }
    
    public int top() {
    return a.get(a.size()-1);
    }
    
    public int getMin() {
  return b.get(b.size()-1);
    }
}
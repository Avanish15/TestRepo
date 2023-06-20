class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        if(deck.length==1)
            return deck;
        Arrays.sort(deck);
        int res[]=new int[deck.length];
        int k=1;
        int c=0;
        res[0]=deck[0];
        while(k<deck.length)
        {
            for(int i=1;i<deck.length;i++)
            {
                if(res[i]==0){
                    c++;
                if(c==2){
                    res[i]=deck[k++];
                c=0;
                
            }
        } 
            }
        }
        return res;
    }
}
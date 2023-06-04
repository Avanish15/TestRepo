class Solution {
    public int alphaDigtSearch(int finish, String sourse, ArrayList<String> stack, boolean isAlpha)
    {
        int start = finish;

        if (isAlpha)
            while (finish < sourse.length() && Character.isAlphabetic(sourse.charAt(finish))) finish++;
        else
            while (finish < sourse.length() && Character.isDigit(sourse.charAt(finish))) finish++;

        if (start != finish)
            stack.add(sourse.substring(start, finish));
        if (finish < sourse.length() && sourse.charAt(finish) == '[')
            finish++;
        return finish;
    }

    public void stackWork(ArrayList<String> stack)
    {
        String str = null;
        int repeat;
        StringBuilder answ = new StringBuilder();

        if (stack.size() > 0)
        {
            answ = new StringBuilder(stack.get(stack.size() - 1));
            stack.remove(stack.size() - 1);
        }
        while (stack.size() > 0 && !Character.isDigit(stack.get(stack.size() - 1).charAt(0))) {
            answ.insert(0, stack.get(stack.size() - 1));
            stack.remove(stack.size() - 1);
        }
        if (stack.size() > 0 && Character.isDigit(stack.get(stack.size() - 1).charAt(0)))
        {
            repeat = Integer.parseInt(stack.get(stack.size() - 1));
            stack.remove(stack.size() - 1);
            answ = repeat(answ, repeat);
        }

        while (stack.size() > 0 && Character.isAlphabetic(stack.get(stack.size() - 1).charAt(0))) {
            answ.insert(0, stack.get(stack.size() - 1));
            stack.remove(stack.size() - 1);
        }
        stack.add(answ.toString());
    }

    private StringBuilder repeat(StringBuilder answ, int i) {
        StringBuilder tmp = new StringBuilder();
        for (int j = 0; j < i; j++)
            tmp.append(answ);
        return tmp;
    }

    public String decodeString(String s)
    {
        ArrayList<String> stack = new ArrayList<>();
        int finish = 0;
        finish = alphaDigtSearch(finish, s, stack, true);
        while (finish < s.length())
        {
            finish = alphaDigtSearch(finish, s, stack, false);
            finish = alphaDigtSearch(finish, s, stack, true);
            if (finish < s.length() && s.charAt(finish) == ']') {
                stackWork(stack);
                finish++;
            }
        }
        if (stack.size() > 1)
            stackWork(stack);
        return stack.get(0);
    }
}
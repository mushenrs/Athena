package me.mushen.athena.java.innerclass;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-09-28
 */
public class Sequence {
    private Object[] items;

    private int next = 0;

    public Sequence(int size) throws Exception {
        if(size <= 0){
            throw new Exception("初始化的大小必须大于0");
        }
        items = new Object[size];
    }

    public void add(Object object){
        if(next < items.length){
            items[next++] = object;
        }
    }

    public Selector selector(){
        return new SequenceSelector();
    }

    public static void main(String[] args) throws Exception {
        Sequence sequence = new Sequence(10);
        for(int i = 0; i < 10; i++){
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        while (!selector.end()){
            System.out.print(selector.current() + "\t");
            selector.next();
        }
    }

    private class SequenceSelector implements Selector {
        private int index = 0;
        @Override
        public boolean end() {
            return index == items.length;
        }

        @Override
        public Object current() {
            return items[index];
        }

        @Override
        public void next() {
            if(index < items.length){
                index++;
            }
        }
    }
}


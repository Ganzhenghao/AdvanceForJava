package homework.bean;

import java.util.Arrays;

/**
 * @ClassName Box
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/26 18:37
 * @Version 1.0
 */
public class Box<T> {
    /*
    需求：根据可变数组的原理，结合泛型技术，实现一个简单的容器类，要求：
    1. 提供添加数据和获取数据总数的方法；并重写toString方法；
    2. 提示：默认数组长度可以定义为10；每次扩容可以为原来的1.5倍；
     */

    private Object[] elementData = new Object[10];
    private int size = 0; //下一次添加时 元素索引位置

    public boolean add(T t) {
        if (elementData.length <= size) {//elementData.length小于等于size时 证明达到数组容量上限
            grow();
        }
        elementData[size] = t;
        size++;
        return true;
    }

    public boolean addAll(T...elements){
        for (T element : elements) {
            add(element);
        }
        return true;
    }

    public T get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) elementData[index];
    }

    public boolean remove(int index) {
        if (size - 1 - index >= 0) {
            System.arraycopy(elementData, index + 1, elementData, index, size - 1 - index);
        }
        return true;
    }

    public boolean remove(T t) {
        if (t == null) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            T e = (T) elementData[i];
            if (e == null) {
                continue;
            }
            if (t.equals(e)) {
                if (size - 1 - i >= 0) {
                    System.arraycopy(elementData, i + 1, elementData, i, size - 1 - i);
                }
                return true;
            }
        }
        return false;
    }

    private void grow() {
        int newSize = outOfBoundsInt(size);
        elementData = Arrays.copyOf(elementData, newSize);
    }

    private int outOfBoundsInt(int size) {
        long factSize = (long) size + ((long) size >> 1);
        if (factSize > Integer.MAX_VALUE - 8) {
            throw new RuntimeException("扩容到达上限");
        }
        return (int) factSize;
    }


    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Box{");
        for (Object e : elementData) {
            sb.append(e.toString());
        }
        sb.append("}");
        return sb.toString();
    }

    public Iterator iterator(){
        return new Iterator();
    }


    class Iterator{
        int index;

        public boolean hasNext(){
            return size > index;
        }

        public T next(){
            return (T)elementData[index];
        }

    }
}


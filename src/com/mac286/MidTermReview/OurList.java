package com.mac286.MidTermReview;

import java.util.Arrays;

public class OurList<T> {
    private T[] data;
    private int size;

    // 初始容量
    private static final int INITIAL_CAPACITY = 10;

    // 构造函数
    @SuppressWarnings("unchecked")
    public OurList() {
        data = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    // 是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 当前元素个数
    public int size() {
        return size;
    }

    // 前端插入
    public void insertFront(T item) {
        ensureCapacity();
        // 元素整体后移
        for (int i = size; i > 0; i--) {
            data[i] = data[i - 1];
        }
        data[0] = item;
        size++;
    }

    // 后端插入
    public void insertBack(T item) {
        ensureCapacity();
        data[size] = item;
        size++;
    }

    // 前端删除
    public T removeFront() {
        if (isEmpty()) {
            throw new IllegalStateException("列表为空，无法删除前端元素");
        }
        T item = data[0];
        // 元素整体前移
        for (int i = 0; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return item;
    }

    // 后端删除
    public T removeBack() {
        if (isEmpty()) {
            throw new IllegalStateException("列表为空，无法删除后端元素");
        }
        T item = data[size - 1];
        data[size - 1] = null;
        size--;
        return item;
    }

    @Override
    public String toString() {
        return "OurList{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

    // 自动扩容
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (size == data.length) {
            T[] newData = (T[]) new Object[data.length * 2];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }
}

